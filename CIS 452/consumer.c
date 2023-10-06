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
    // Generate a key for shared memory
    key_t key = ftok("producer.c", 'R');
    if (key == -1) {
        perror("ftok");
        exit(EXIT_FAILURE);
    }

    // Create a shared memory segment
    int sharedMemoryID = shmget(key, sizeof(struct myStruct), 0666 | IPC_CREAT);
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

    // Display data from shared memory
    printf("Consumer: Integer Value: %d\n", sharedMemoryPointer->integerVal);
    printf("Consumer: String: %s\n", sharedMemoryPointer->charArray);

    // Detach from the shared memory segment
    if (shmdt(sharedMemoryPointer) == -1) {
        perror("shmdt");
        exit(EXIT_FAILURE);
    }

    // Destroy the shared memory segment
    if (shmctl(sharedMemoryID, IPC_RMID, NULL) == -1) {
        perror("shmctl");
        exit(EXIT_FAILURE);
    }

    printf("Consumer: Data consumed and shared memory segment destroyed.\n");

    return 0;
}
