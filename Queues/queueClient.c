#include<stdio.h>
#include<stdlib.h>
#include "queue.h"
#include "queue.c"
int main(int argc, char* argv[])
{
   FILE* in;
   FILE* out; 
   
   char word[256];
   char sword;
   int EnQ[256];
   if(argc != 3)
   {
      printf("Usage: %s <input file> <output file>\n", argv[0]);
      exit(EXIT_FAILURE);
   }
   in = fopen(argv[1], "r");
   if( in==NULL )
   {
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }   
   out = fopen(argv[2], "w");
   if( out==NULL )
   {
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }
   while( fscanf(in, " %s", word) != EOF )
   {
      if(*word == 'e')
      {
         fscanf(in," %d", EnQ);
		 fprintf(out, "enqueued %d", *EnQ);
	     Enqueue(*EnQ);
		 fprintf(out,"\n");
      }
      else if(*word == 'd')
      { 
		 DeQueue(out);
		 fprintf(out,"\n");
         
      }
      else if(*word == 'p')
      {
		 PrintQueue(out);
		 fprintf(out,"\n");
      }

   }
   return(EXIT_SUCCESS);
}

