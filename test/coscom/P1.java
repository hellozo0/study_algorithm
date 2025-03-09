package org.example.coscom;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P1 {
	public static void main(String[] args) {
		int[][] test1 = {
			{100, 100, 100, 2},
			{1, 1, 1, 3},
			{1, 1, 10, 1}
		};

		int[][] test2 = {
			{10, 9, 8, 4},
			{10, 9, 8, 3},
			{10, 9, 8, 2},
			{10, 9, 8, 1}
		};

		int[][] test3 = {
			{10, 9, 8, 1},
			{10, 9, 8, 2},
			{10, 9, 8, 3},
			{10, 9, 8, 4}
		};

		int[][] test4 = {
			{99, 1, 98, 3},
			{99, 2, 98, 1},
			{99, 3, 98, 4},
			{99, 4, 98, 2}
		};

		int[][] test5 = {
			{10, 10, 30, 4},
			{10, 10, 20, 1},
			{20, 10, 10, 3},
			{30, 20, 20, 2},
			{10, 10, 19, 5}
		};

		System.out.println(Arrays.toString(solution(test1))); // 기대 결과: (2,1,1)
		System.out.println(Arrays.toString(solution(test2))); // 기대 결과: (4,3,2,1)
		System.out.println(Arrays.toString(solution(test3))); // 기대 결과: (1,1,1,1)
		System.out.println(Arrays.toString(solution(test4))); // 기대 결과: (2,3,1,2)
		System.out.println(Arrays.toString(solution(test5))); // 기대 결과: (2,1,2,2,1)
	}

	public static int[] solution(int[][] conveyor) {
		int[] result = new int[conveyor.length];

		//1. conveyor에 대해 HashMap을 만들기, 컨베이어벨트 큐, 인간 큐
		HashMap<Integer, int[]> map = new HashMap<>();
		Deque<Integer> belt = new LinkedList<>();
		Deque<Integer> person = new LinkedList<>();

		//2. 작업 세팅
		for(int i = 0; i < conveyor.length; i++){
			map.put(conveyor[i][3], new int[]{conveyor[i][0], conveyor[i][1], conveyor[i][2]});
			belt.add(conveyor[i][3]);
			person.add(i+1);
		}

		//4. 그 특징이 몇개가 같은지 판단하는
		while (!person.isEmpty()){

			int beltId = belt.poll();
			int personId = person.poll();

			int correctNum = countingFeature(map, beltId, personId);

			if(correctNum < 2 && beltId != personId) {
				//벨트만 돌리기
				belt.addLast(beltId);
				person.addFirst(personId);
			} else if (correctNum >= 2 && beltId != personId) { // ✅여기 수정해야했음, 3개 특징 같은데 내꺼 아닌거....
				//인간을 맨뒤로
				//인간 행위 + 1
				belt.addFirst(beltId);
				person.addLast(personId);
				result[personId-1] +=1;
			} else if (correctNum ==3 && beltId == personId){
				//벨트 poll, 인간 poll, 인간 행위 +1
				result[personId-1] +=1;
			}
		}

		return result;
	}

	public static int countingFeature(HashMap<Integer, int[]> map, int beltId, int personId){
		int cnt = 0;

		int[] belt = map.get(beltId);
		int[] person = map.get(personId);

		for(int i = 0; i < 3; i++) {
			if(belt[i] == person[i]) cnt++;
		}

		return cnt;
	}
}
