package org.example.KB;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

/*
* 코테 후기
* 또 구현 문제 5단계까지 다 풀려고 하다가 2번 4단계까지는 다 풀 수 있었을 텐데 깎였다.
* 다음 부터는 문제당 시간을 대략 정해두고 풀어야할것 같다. 그 시간이 지나면 일단은 다음 문제를 먼저 보고 오는 방법으로
* */
public class main {
	public static void main(String[] args) throws IOException {
		String[] test1 = new String[]{"BR", "a_", "q", "CL", "HM", "b_", "CL", "a","CL", "k","z", "END", "BR", "c_" }; // baKZAc
		String[] test2 = new String[]{"BR", "a_", "q", "HM", "b", "c", "HM", "d", "e"}; // debcAq
		String[] test3 = new String[]{"BR", "a_", "q", "HM", "b", "c", "END", "d", "e"}; // bcAqde
		String[] test4 = new String[]{"BR", "a_", "q", "CL", "b", "c", "CL", "d", "e"}; // AqBCde

		Deque<String> dq = new LinkedList<>();
		Deque<String> tempDQ = new LinkedList<>();
		boolean isUpper = false;
		int count = 0;
		int tempCnt = 0;
		StringBuilder sb = new StringBuilder();

		int N = test2.length; //test

		for(int i = 0; i < N; i++){
			String s = test2[i]; //test

			if(s.equals("BR")){
				if(dq.size() > 1) { //dq에 값이  있을때만 삭제
					dq.pollLast();
					count--;
				}
			} else if(s.equals("CL")) {
				isUpper = !isUpper; //대문자로 들어감
			} else if(s.equals("HM")) {
				if(tempDQ.isEmpty()) { //그냥 원래대로 dq --> tempDQ로 옮기기
					tempCnt = dq.size();
					while (!dq.isEmpty()) {
						tempDQ.add(dq.poll()); //Aq 들어감
					}
					count -= tempCnt;
				} else { //dq + tempDQ => dq -> tempDQ로 옮기기
					tempCnt = dq.size();
					while (!tempDQ.isEmpty()) {
						dq.add(tempDQ.poll());
					}
					count -= tempCnt;

					tempCnt = dq.size();
					while (!dq.isEmpty()) {
						tempDQ.add(dq.poll());
					}
				}
			} else if(s.equals("END")) {
				//tempDQ => dq 맨뒤에 붙이기
				while (!tempDQ.isEmpty()) {
					dq.add(tempDQ.poll());
				}
				count += tempCnt;
				tempCnt = 0;
			} else {//일반 문자열의 경우

				count++;
				//shift 문자일 경우
				if(s.length()>1 && s.charAt(1) == '_'){
					String first = s.substring(0,1);
					if(isUpper){
						dq.addLast(first.toLowerCase());
					} else {
						dq.addLast(first.toUpperCase()); //A => B
					}
					continue;
				}

				//일반 문자열일 경우 => CL 여부 파악
				if(isUpper){
					dq.addLast(s.toUpperCase()); //A
				} else {
					dq.addLast(s.toLowerCase()); //q => kz
				}
			}
		}

		//이건 그 HM => HM으로 끝났을 때 마지막을 붙이기 위함
		while (!tempDQ.isEmpty()){
			dq.add(tempDQ.poll());
			count++;
		}

		for(int i = 0; i < count; i++){
			sb.append(dq.poll());
		}

		System.out.print(sb.toString());
	}

}
