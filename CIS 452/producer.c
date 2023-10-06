#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/shm.h>

#define MAX_STRING_LENGTH 40

struct myStruct {
    int integerVal;
    char charArray[MAX_STRING_LENGTH];
};

int main() {
    struct myStruct data;
    data.integerVal = 42;
    strcpy(data.charArray, "Not Hello World");

    // Generate a key for shared memory
    key_t key = ftok("producer.c", 'R');
    if (key == -1) {
        perror("ftok");
        exit(EXIT_FAILURE);
    }

    // Create a shared memory segment
    int sharedMemoryID = shmget(key, sizeof(struct myStruct), S_IWUSR | S_IRUSR | S_IRGRP | S_IWGRP | IPC_CREAT);
    if (sharedMemoryID == -1) {
        perror("shmget");
        exit(EXIT_FAILURE);
    }

    // Attach to the shared memory segment
    struct myStruct *sharedMemoryPointer = (struct myStruct *)shmat(sharedMemoryID, NULL, 0);
    if ((int)sharedMemoryPointer == -1) {
        perror("shmat");
        exit(EXIT_FAILURE);
    }

    // Copy data to shared memory
    *sharedMemoryPointer = data;

    // Detach from the shared memory segment
    if (shmdt(sharedMemoryPointer) == -1) {
        perror("shmdt");
        exit(EXIT_FAILURE);
    }

    printf("Producer: Data produced and stored in shared memory.\n");

    // Display shared memory segments
    system("ipcs -m");

    return 0;
}
