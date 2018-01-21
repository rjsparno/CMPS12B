#ifndef _QUEUE_H_INCLUDE_
#define _QUEUE_H_INCLUDE_
//#include "queue.c"

typedef struct Node{
	int val;
	struct Node* next;
} iNode;



//creates global variables front and back
struct Node* front = NULL;
struct Node* back = NULL;

//Node* newQueue(void);

void DeQueue(FILE* out);

void Enqueue(int newVal);

void PrintQueue(FILE* out);





//struct Node* front = NULL;

#endif
