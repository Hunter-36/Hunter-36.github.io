#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/sem.h>

// Structure for the semaphore operations
struct sembuf p = {0, -1, SEM_UNDO}; // Semaphore P (Wait)
struct sembuf v = {0, 1, SEM_UNDO};  // Semaphore V (Signal)

int main() {
    int semId; // Semaphore ID
    key_t key = IPC_PRIVATE; // Unique key for semaphore

    // Create a semaphore with initial value 1
    if ((semId = semget(key, 1, IPC_CREAT | IPC_EXCL | 0666)) == -1) {
        perror("semget: semget failed");
        exit(1);
    }

    // Set the initial value of the semaphore to 1
    if (semop(semId, &v, 1) == -1) {
        perror("semop: semop failed");
        exit(1);
    }

    // Fork a child process
    pid_t childPid = fork();

    if (childPid == -1) {
        perror("fork");
        exit(1);
    }

    if (childPid == 0) {
        // Child process
        printf("Child process: Trying to access the shared data.\n");

        // Wait (P) on the semaphore to access the shared data
        if (semop(semId, &p, 1) == -1) {
            perror("semop: semop failed");
            exit(1);
        }

        printf("Child process: Accessing the shared data.\n");

        // Release (V) the semaphore
        if (semop(semId, &v, 1) == -1) {
            perror("semop: semop failed");
            exit(1);
        }
    } else {
        // Parent process
        printf("Parent process: Trying to access the shared data.\n");

        // Wait (P) on the semaphore to access the shared data
        if (semop(semId, &p, 1) == -1) {
            perror("semop: semop failed");
            exit(1);
        }

        printf("Parent process: Accessing the shared data.\n");

        // Release (V) the semaphore
        if (semop(semId, &v, 1) == -1) {
            perror("semop: semop failed");
            exit(1);
        }
    }

    // Remove the semaphore
    if (semctl(semId, 0, IPC_RMID) == -1) {
        perror("semctl: semctl failed");
        exit(1);
    }

    return 0;
}