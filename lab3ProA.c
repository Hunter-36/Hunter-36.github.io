#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <time.h>

// Signal handler for user-defined signals
void sigHandler(int signal) {
	if (signal == SIGUSR1) {
		printf("Waiting...     Received SIGUSR1\n");
	} 
	else if (signal == SIGUSR2) {
		printf("Waiting...     Received SIGUSR2\n");
	}
	else if (signal == SIGINT) {
		printf("\nReceived ^C.... time to shutdown!\n");
		exit(0);
	}
}

int main() {
	// Seed the random number generator
	srand(time(NULL));

	// Install signal handlers
	signal(SIGUSR1, sigHandler);
	signal(SIGUSR2, sigHandler);
	signal(SIGINT, sigHandler);

	pid_t child_pid = fork();

	if (child_pid == -1) {
		perror("Fork Failed!");
		exit(1);
	}

	if (child_pid == 0) {
		// child process
		while (1) {
			int random_wait_time = rand() % 5 + 1;
			sleep(random_wait_time);

			int random_signal = (rand() % 2) + 1;

			if (random_signal == 1) {
				kill(getppid(), SIGUSR1);
			}
			else {
				kill(getppid(), SIGUSR2);
			}
		}
	}
	else {
		// Parent process
		printf("Parent process (PID: %d)\n", getpid());
		printf("Spawned child process (PID: %d)\n", child_pid);

		while (1) {
			// Wait until a signal is received
			pause();
		}
	}

	return 0;
}

