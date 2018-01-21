//------------------------------------------------------------------------------
//queue.c
//
//------------------------------------------------------------------------------
#include<stdio.h>
#include<stdlib.h>


void Enqueue(int newVal)
{
   iNode *temp;
   temp = malloc (sizeof(iNode));
   //printf("Size of Front:%d", sizeof(back));
   
 
   temp->val = newVal;
   temp->next = NULL;
   
   if(front == NULL && back == NULL)
   {
	   front = temp;
	   back = temp;
	   return;
   }

   back->next = temp;
   back = temp;
}
void DeQueue(FILE* out)
{
   int to_print;
   iNode* to_delete;
   if(front == NULL)
   {
	  fprintf(out,"empty");
      return; //queue is empty
   }
   if(front == back)
   {
	  to_delete = front;
      front = NULL; //deletes the node from front and back if it's the only node
      back = NULL;
   }
   else
   {
	  to_delete = front;
      front = front->next;
   }
   to_print = (to_delete->val);
   fprintf(out, "%d", to_print);
   free(to_delete); //freeing the memory
   to_delete = NULL;
}
void PrintQueue(FILE* out)
{
   if(front == NULL)
   {
      return;
   }
   iNode* temp;
   temp = front;
   while(temp != NULL)
   {
      fprintf(out, "%d ",temp->val);
      temp = temp->next;
   }
   
   return;
}


