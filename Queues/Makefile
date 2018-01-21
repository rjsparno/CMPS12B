#Makefile for FileReverse.c with macros
FLAGS	= -std=c99 -Wall
#SOURCES	= queueClient.c queue.c
OBJECTS	= queueClient.o queueClient out.txt
all:
	gcc queueClient.c -o queueClient
	queueClient test-input.txt out.txt

clean :
	rm -f $(EXEBIN) $(OBJECTS)
