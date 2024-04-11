import java.util.*;

class Solution {

    static int[] dI = {1,-1,0,0}; //bfs 할때 상하좌우 위한 배열
    static int[] dJ = {0, 0,1,-1}; //bfs 할때 상하좌우 위한 배열

    /*
     * 필요한 메소드
     * 1. board, table에서 조각들의 정보를 가져올 bfs 메소드
     * 2. board의 조각 하나씩 table의 조각을 돌려보며 맞춰볼 메소드
     * 3. 조각을 돌리는 메소드
     * */

    static List<List<int[]>> boardList = new ArrayList<>();
    // board에서 빈칸조각의 정보를 저장할 List -> 내부 리스트는 (0,0), (1,0) 등 세부조각의 인덱스가 0,0 을 기준으로 들어있다.
    static List<List<int[]>> tableList = new ArrayList<>();
    // table에서 조각 정보를 저장할 List

    //bfs를 위한 방문배열
    static boolean[][] visitedBoard;
    static boolean[][] visitedTable;

    static int result = 0; // 답을 저장할 변수

    // board의 크기 저장 , board 와 table의 크기는 같고, 둘다 정사각형이다.
    static int size;

    public static int solution(int[][] game_board, int[][] table) {
        size = game_board.length;

        visitedBoard = new boolean[size][size];
        visitedTable = new boolean[size][size];

        // 2중반복문으로 이용하여 각 노드그룹(큰조각)마다 bfs를 돌릴 수 있게 한다. -> 큰조각의 세부 위치정보를 저장하기 위함
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visitedBoard[i][j] && game_board[i][j] == 0) {
                    // board에서는 빈칸 bfs
                    bfs(game_board, 0, i, j, boardList, visitedBoard);
                }
                if (!visitedTable[i][j] && table[i][j] == 1) {
                    // table에서는 조각 bfs
                    bfs(table, 1, i, j, tableList, visitedTable);
                }

            }
        }


        //bfs를 돌았으면 조각정보들을 이용하여 답을 찾는 메소드를 진행한다.
        checkSegment(boardList, tableList);
//        System.out.println("result = " + result);
        return result;
    }

    /*
     * trigger는 board인 경우 0 , table인 경우 1 을 의미 -> 즉 어떤 숫자면 bfs를 진행하는지
     * bfs는 board일때와 ,talbe일때 동작방식이 달라지므로, 내부에서 if문으로 처리하는것보다는 필요한 인자를 전달받아서 처리하자.
     * 조각을 저장할 List 인자 , 방문처리를 위한 방문배열을 전달 받는다. (그렇다면 각 변수를 굳이 static으로 처리할 필요는 없긴함)
     * */
    static void bfs(int[][] map, int trigger, int startI, int startJ, List<List<int[]>> list,
        boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        visited[startI][startJ] = true;
        q.add(new int[]{startI, startJ}); // bfs 시작할 인덱스 큐에 넣는다.
        // 조각의 가장 첫번째 세부조각을 원점으로 보내고 , 그 조각을 기준으로 나머지 조각의 상대인덱스를 구해 저장할 예정
        //list에 추가할 List<int[]>를 생성
        List<int[]> segmentInfo = new ArrayList<>(); //조각의 인덱스정보를 담을 리스트
        segmentInfo.add(new int[]{startI - startI, startJ - startJ}); // 0,0 원점인덱스를 기준으로 저장할것이다.

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentI = current[0];
            int currentJ = current[1];

            for (int i = 0; i < 4; i++) {
                int nextI = currentI + dI[i];
                int nextJ = currentJ + dJ[i];

                //지금 bfs를 진행하는 큰조각의 다음 세부조각를 상하좌우에서 찾아서 큐에 저장
                if (nextI >= 0 && nextI < size && nextJ >= 0 && nextJ < size) {
                    if (!visited[nextI][nextJ] && map[nextI][nextJ] == trigger) {
                        visited[nextI][nextJ] = true;
                        q.add(new int[]{nextI, nextJ});
                        segmentInfo.add(new int[]{nextI - startI,
                            nextJ - startJ}); //지금 이 좌표도 원점기준 정렬해야하므로 기준좌표(시작좌표)를 빼준다.
                    }
                }
            }
        }
        //bfs를 다돌았으면 조각정보 List를 저장해준다.
        list.add(segmentInfo);
    }

    static void checkSegment(List<List<int[]>> boardList, List<List<int[]>> tableList) {
        // 반복문을 이용해서 빈칸의 조각하나씩 꺼내고 , 반복문을 통해서 table의 조각을 꺼내고, 회전시켜가면서 맞추는 메소드

        boolean[] completeSegT = new boolean[tableList.size()]; // 이미 사용한 조각인지 체크할 배열

        for (int i = 0; i < boardList.size(); i++) {

            List<int[]> currentBoardSeg = boardList.get(i);

            for (int j = 0; j < tableList.size(); j++) {
                if (!completeSegT[j] && currentBoardSeg.size() == tableList.get(j).size()) {
                    // 사용하지않은 조각인지 체크, 조각의 크기가 같은지 체크 ( 조각의 크기가 다르면 비교할 이유가 없음 + 딱 맞는 퍼즐만 넣어야함)
                    List<int[]> currentTableSeg = tableList.get(j);

                    boolean isCorrect = rotateCheck(currentBoardSeg, currentTableSeg);// table 조각을 0,90,180,270도 회전시켜보면서 맞는지 체크 맞으면 답 증가
                    if (isCorrect) {
                        result += currentTableSeg.size();
                        completeSegT[j] = true;
                        break;
                    }
                }


            }

        }
    }

    static boolean rotateCheck(List<int[]> currentBoardSeg, List<int[]> currentTableSeg) {
        //조각의 비교는 원점 인덱스 0,0을 기준으로 세부조각의 좌표를 정렬하여 비교한다
        //i인덱스 기준 오름차순, i가 같을시 j인덱스 기준 오름차순으로 정렬해준다. -> 두 조각의 좌표를 비교해서 맞는 퍼즐인지 확인할것이기 때문에

        //board 조각 정렬
        currentBoardSeg.sort(((o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] == o2[0]){
                if (o1[1] > o2[1]) {
                    return 1;
                }
            }
            return -1;

        }));

        for (int i = 0; i < 4; i++) { // 0,90,180,270도 회전하면서 같은 조각모양인지 체크
             // table 조각도 비교전에 같은 기준으로 정렬
            currentTableSeg.sort(((o1, o2) -> {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0]){
                    if (o1[1] > o2[1]) {
                        return 1;
                    }
                }
                return -1;
            }));

            int baseI = currentTableSeg.get(0)[0];
            int baseJ = currentTableSeg.get(0)[1];
            //회전을 하게되면 0,0 기준으로 상대위치 설정이 풀린다. 첫번째 좌표졍보를 0,0로 보내고 그 좌표를 기준으로 다시 정리
            for (int j = 0; j < currentTableSeg.size(); j++) {
                currentTableSeg.get(j)[0] -= baseI;
                currentTableSeg.get(j)[1] -= baseJ;
            }

            //조각이 같은 모양인지 비교
            boolean isCorrect = true;

            for (int j = 0; j < currentTableSeg.size(); j++) {
                int[] tableSeg = currentTableSeg.get(j);
                int[] boardSeg = currentBoardSeg.get(j);

                if (tableSeg[0] != boardSeg[0] || tableSeg[1] != boardSeg[1]) {
                    isCorrect = false;
                    break;
                }
            }

            if (!isCorrect) {
                //맞지않는다면 다음 회전으로 진행..
                // 90도 시계방향 회전은 (x,y) -> (y,-x)

                for (int j = 0; j < currentTableSeg.size(); j++) {
                    int temp = currentTableSeg.get(j)[0] * -1; // i 인덱스 임시 저장
                    currentTableSeg.get(j)[0] = currentTableSeg.get(j)[1]; // x에다가는 y를
                    currentTableSeg.get(j)[1] = temp; // y에다가는 -x를
                }

            }
            else{
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a =

            {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};

        int[][] b =
            {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};

        solution(a, b);
    }

}