package org.example.KB;

import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

public class main2 {
	public static void main(String[] args) throws IOException {
		String[] test1 = new String[]{"BR", "a_", "q", "CL", "HM", "b_", "CL", "a","CL", "k","z", "END", "BR", "c_" }; // baKZAc
		String[] test2 = new String[]{"BR", "a_", "q", "HM", "b", "c", "HM", "d", "e"}; // debcAq
		String[] test3 = new String[]{"BR", "a_", "q", "HM", "b", "c", "END", "d", "e"}; // bcAqde
		String[] test4 = new String[]{"BR", "a_", "q", "CL", "b", "c", "CL", "d", "e"}; // AqBCde

		LinkedList<Character> text = new LinkedList<>();  // 실제 입력된 문자를 저장하는 리스트
		ListIterator<Character> cursor = text.listIterator(); // 커서를 관리하는 ListIterator
		boolean isCapsLock = false; // CapsLock 상태 저장

		for (String s : test1) {
			if (s.equals("BR")) { // 백스페이스 (이전 문자 삭제)
				if (cursor.hasPrevious()) {
					cursor.previous();
					cursor.remove();
				}
			} else if (s.equals("CL")) { // CapsLock 토글
				isCapsLock = !isCapsLock;
			} else if (s.equals("HM")) { // Home 키 (커서를 맨 앞으로)
				while (cursor.hasPrevious()) {
					cursor.previous();
				}
			} else if (s.equals("END")) { // End 키 (커서를 맨 뒤로)
				while (cursor.hasNext()) {
					cursor.next();
				}
			} else { // 일반 문자 입력
				char ch;
				if (s.length() > 1 && s.charAt(1) == '_') { // a_ 같은 특수 문자 처리 (1회 CapsLock)
					ch = isCapsLock ? Character.toLowerCase(s.charAt(0)) : Character.toUpperCase(s.charAt(0));
				} else { // 일반 문자
					ch = isCapsLock ? Character.toUpperCase(s.charAt(0)) : Character.toLowerCase(s.charAt(0));
				}
				cursor.add(ch); // 현재 커서 위치에 문자 삽입
			}
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (char c : text) {
			sb.append(c);
		}
		System.out.println(sb.toString()); // 정답: baKZ A q(삭제) C
	}
}
