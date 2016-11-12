#include <stdio.h>
#include <stdlib.h>

int count(char* string, int slength, char* pattern, int plength) {
   int sum = 0;
   for (int i = 0; i < slength; i++) {
      for (int j = 0; j < plength; j++) {
         if (pattern[j] == '*' || pattern[j] == string[i+j]) {
            if (j == plength-1)
               sum += 1;
         } else {
            break;
         }
      }
   }
   return sum;
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int slength, plength;
    char tmp[10];
    char* string;
    char* pattern;
    scanf("%d%d", &slength, &plength);
    gets(tmp);
    string = malloc(slength+1);
    pattern = malloc(plength+1);
    gets(string);
    gets(pattern);

    int sum = count(string, slength, pattern, plength);
    printf("%d\n", sum);
    free(string);
    free(pattern);
    return 0;
}
