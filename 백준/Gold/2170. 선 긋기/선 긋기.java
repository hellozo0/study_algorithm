
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{

    public static class Line implements Comparable<Line> {
        int x;
        int y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line l) {
            int rs = this.x - l.x;
            if (rs == 0) rs = this.y - l.y;
            return rs;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> list = new ArrayList<Line>();

        // 리스트에 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        //리스트 정렬
        Collections.sort(list);

        //차이 값
        int answer = list.get(0).y - list.get(0).x;
        int prev = list.get(0).y;

        for (Line line : list) {
            if (prev >= line.y) {
                // 이전 라인이 현재 라인을 포함
                // nothing
            } else if (prev < line.y && prev > line.x) {
                // 이전 라인의 끝이 현재 라인 내에 포함되어 있음
                answer += line.y - prev;
                prev = line.y;
            } else {
                // 이전 라인의 끝이 현재 라인 전에 끝이 나있음.
                answer += line.y - line.x;
                prev = line.y;
            }
        }
        System.out.println(answer);

    }
}
