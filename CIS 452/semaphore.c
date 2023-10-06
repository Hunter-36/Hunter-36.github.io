#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>

int main() {
    int semId;
    struct sembuf p = { 0, -1, SEM_UNDO };
    struct sembuf v = { 0, +1, SEM_UNDO };

    if ((semId = semget(IPC_PRIVATE, 1, 0400)) == -1) {
        perror("semget: semget failed");
        exit(1);
    }

    int sharedData = 0; 
    printf("Initial shared data: %d\n", sharedData);

    printf("Reading from shared data...\n");
    if (semop(semId, &p, 1) == -1) {
        perror("semop: read operation failed");
        exit(1);
    }

    sharedData += 10;

    printf("Updated shared data: %d\n", sharedData);

    if (semop(semId, &v, 1) == -1) {
        perror("semop: release operation failed");
        exit(1);
    }

    if (semctl(semId, 0, IPC_RMID) == -1) {
        perror("semctl: removal failed");
        exit(1);
    }

    return 0;
}