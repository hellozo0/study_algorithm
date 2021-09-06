package Silver;
import java.util.*;

public class Main2941 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = 0;
        sc.close();

        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 'c'){
                if (i < str.length() -1){
                    if (str.charAt(i+1) == '='){
                        i += 1;
                    }
                    else if (str.charAt(i+1) == '-'){
                        i += 1;
                    }
                }
            }
            else if (str.charAt(i) == 'd'){
                if(i < str.length() -1){
                    if (str.charAt(i+1) == 'z'){
                        if(i < str.length() -2){
                            if (str.charAt(i+2)== '='){
                                i += 2;
                            }
                            else{
                                i +=1;
                                count +=1;
                            }
                        }
                    }
                    else if (str.charAt(i+1) == '-'){
                        i += 1;
                    }
                }
            }
            else if (str.charAt(i) == 'l'){
                if (i < str.length()-1){
                    if (str.charAt(i+1) == 'j'){
                        i += 1;
                    }
                }
            }
            else if (str.charAt(i) == 'n'){
                if (i < str.length()-1){
                    if (str.charAt(i+1) == 'j'){
                        i += 1;
                    }
                }
            }
            else if (str.charAt(i) == 's'){
                if ( i < str.length()-1){
                    if (str.charAt(i+1) == '='){
                        i += 1;
                    }
                }
            }
            else if (str.charAt(i) == 'z'){
                if ( i < str.length() - 1){
                    if (str.charAt(i+1) == '='){
                        i += 1;
                    }
                }
            }
            count += 1;
        }
        System.out.println(count);
    }
}
