import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

class Solution {

    static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        public boolean equals(Object o) {
            return this.x == ((Node) o).x && this.y == ((Node) o).y;
        }
    }

    //1. 방문했던 정점(node)을 재방문하는 경우, 방이 생성
    //2. 간선 끼리 교차했을 때 --를 위해 그림판?의 크기를 크게 한다 ( 이거 전에 비슷한 문제 있었음)

    public static int solution(int[] arrows) {

        int cnt = 0;

        Node node = new Node(0, 0);
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1}; //2,3,4,5,6,7,1 값으로

        //시작 노드, 연결된 노드들의 코드
        HashMap<Node, ArrayList<Node>> visitied = new HashMap<>();

        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) {

                //이동하게 될 점
                Node newNode = new Node(node.x + dx[arrow], node.y + dy[arrow]);

                //방문 X
                if (!visitied.containsKey(newNode)) {
                    //방문 처리
                    visitied.put(newNode, makeEdgeList(node));

                    //기존에 없다면 추가
                    if (visitied.get(node) == null) {
                        visitied.put(node, makeEdgeList(newNode));
                    } else {
                        visitied.get(node).add(newNode);
                    }
                    // 재방문, 처음 통과하는 경우
                } else if (visitied.containsKey(newNode) && !(visitied.get(newNode).contains(node))) {
                    visitied.get(newNode).add(node);
                    visitied.get(node).add(newNode);
                    cnt++; //--> 이 부분을 파악하는 게 포인트 왜 해당 조건일 때 count++ 하는지
                }
                node = newNode;
            }
        }
        return cnt;
    }

    private static ArrayList<Node> makeEdgeList(Node node) {
        ArrayList<Node> edge = new ArrayList<>();
        edge.add(node);
        return edge;
    }

}