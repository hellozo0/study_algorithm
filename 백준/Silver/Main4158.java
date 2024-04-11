package 백준.Silver;

import java.io.*;
import java.util.*;

public class Main4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) { // 입력의 마지막 줄에는 0 0이 주어지면 반복문 종료
                break;
            }
            int[] arr1 = new int[n]; // 상근이가 가지고 있는 CD 번호 배열
            int[] arr2 = new int[m]; // 선영이가 가지고 있는 CD 번호 배열
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(br.readLine()); // 상근이의 CD 번호 입력 받기
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(br.readLine()); // 선영이의 CD 번호 입력 받기
            }
            int i = 0 ;
            int j = 0;
            int count = 0; // 두 사람이 동시에 가지고 있는 CD의 개수를 저장할 변수
            while (i != n && j != m) { // 두 리스트를 동시에 하나씩 비교하여 공통된 번호를 찾기 위한 반복문
                if (arr1[i] == arr2[j]) { // 공통된 번호를 찾으면
                    count++; // 개수 증가
                    i++; // 두 리스트의 다음 원소를 비교하기 위해 인덱스 증가
                    j++;
                }
                else if (arr1[i] > arr2[j]) { // 상근이의 번호가 더 크면 선영이의 번호를 늘림
                    j++;
                } else { // 선영이의 번호가 더 크면 상근이의 번호를 늘림
                    i++;
                }
            }
            System.out.println(count); // 두 사람이 동시에 가지고 있는 CD의 개수 출력
        }
    }
}