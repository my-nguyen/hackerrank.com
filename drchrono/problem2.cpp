#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Record {
   char* first;
   char* middle;
   char* last;
   long ssn;

   Record(char* name, long number) {
      ssn = number;

      if (strchr(name, ',')) {
         char* lname = strtok(name, ",");
         last = copy(lname);

         char* fname = strtok(NULL, ",");
         if (strchr(fname, ' ')) {
            char* ffname = strtok(fname, " ");
            first = copy(ffname);

            char* mname = strtok(NULL, " ");
            middle = copy(mname);
         } else {
            first = copy(fname);
            middle = NULL;
         }
      } else if (strchr(name, ' ')) {
         char* fname = strtok(name, " ");
         first = copy(fname);

         char* tmp1 = strtok(NULL, " ");
         char* tmp2 = strtok(NULL, " " );
         if (tmp2 == NULL) {
            last = copy(tmp1);
            middle = NULL;
         } else {
            last = copy(tmp2);
            middle = copy(tmp1);
         }
         printf("complete: %s %s %s\n", first, middle, last);
      } else {
         first = copy(name);
         middle = NULL;
         last = NULL;
      }
   }

   void print() {
      printf("%s %s %s %ld\n", first, middle, last, ssn);
   }

   ~Record() {
      free(first);
      free(middle);
      free(last);
   }

   char* copy(char* string) {
      char* result = (char*)malloc(strlen(string) + 1);
      strcpy(result, string);
      return result;
   }
};

int main() {
   int count;
   char line[200];
   Record** list;
   int size = 0;

   gets(line);
   count = atoi(line);
   list = (Record**)malloc(count * sizeof(Record*));
   for (int i = 0; i < count; i++) {
      gets(line);
      char* name = strtok(line, ":");
      char* value = strtok(NULL, ":");
      long ssn = atol(value);
      // printf("%s %ld\n", name, ssn);
      // list[i] = new Record(name, ssn);
      Record record(name, ssn);
      for (int i = 0; i < size; i++) {
      }
      list[i]->print();
   }
   return 0;
}
