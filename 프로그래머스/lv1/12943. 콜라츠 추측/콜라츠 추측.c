#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num) {
    int count = 0;
    int answer = 0;
    
    while(num != 1){
        if (count == 500){
            answer = -1;
            break;
        }
        if (num % 2 == 0){
            num /= 2;
        } 
        else if (num % 2 == 1){
            num = (num * 3) + 1;
        }
        count++;
    }
    
    if (num == 1){
        answer = count;
    }
    
    return answer;
}

// for문을 쓰는게 더 깔끔하고 좋은듯!
// for(int i=0; i<500; i++){
//     if (answer == 1)
//         return i;

//     answer = (answer % 2 == 0) ? (answer / 2) : (3 * answer + 1); 
// }

// return -1;