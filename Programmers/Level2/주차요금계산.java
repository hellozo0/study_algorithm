package Programmers.Level2;

import java.util.*;
class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        
        List<Integer> ans = new ArrayList();
        int[] answer = {};
        
        //차량 번호가 작은 순으로 answer에 담기  --> 차량번호가 달라지는 때를 체크해서 일관적으로 answer를 add할 수 있다.
        Arrays.sort(records, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.substring(6, 10).compareTo(s2.substring(6,10));
            }
        });
        
        //차량이  OUT했는지 아닌지를 체크해주는 변수 
        boolean in = false;
        
        //시간계산 및, 문자열 substring을 담을 변수 선언
        int time = 0, final_time = 0;
        String time_info, in_or_out;
        String car_number = records[0].substring(6,10);
        
        //차량 번호가 바뀔때 마다 final_time으로 비용 계산 
        for(int i = 0; i < records.length; i++) {
            //들어오거나 나간 시간
            time_info = records[i].substring(0,5);
            
            //차 번호가 같지 않으면 ... 즉 차량 번호가 바뀔 때 마다 
            if(!car_number.equals(records[i].substring(6,10)))
            {
                if(in)  //들어오기만 한 차량이면 23:59에 출차된 것으로 간주
                {
                    final_time += 23 * 60 + 59 - time;
                    in = false;
                }
                
                //기본시간보다 적으면 기본시간을 add
                if(final_time <= fees[0])
                    ans.add(fees[1]);
                else //기본시간보다 크면 기본시간에... 식계산해서 추가 
                    ans.add(fees[1] + (int)Math.ceil((double) (final_time - fees[0]) / fees[2]) * fees[3]);
                
        
                car_number = records[i].substring(6,10);
                final_time = 0;
            }
            //In,OUT여부
            in_or_out = records[i].substring(11,12);
            
            
            int hour = Integer.parseInt(records[i].substring(0,2)) * 60;
            int min = Integer.parseInt(records[i].substring(3,5));  
            
            //IN이면  in = true
            if(in_or_out.equals("I")) {
                time = hour + min;
                in = true; 
            }
            else { //OUT이면 final time계산 
                final_time += hour + min - time;
                in = false;
            }
        }
        
        //아래는 반복문 안에 있는 것과 반복되는 구간임
        
        if(in) { //들어오기만 한 차량이면 23:59에 출차된 것으로 간주
            final_time += 23 * 60 + 59 - time;
            in = false;
        }
        
        if(final_time <= fees[0])
            ans.add(fees[1]);
        else
            ans.add(fees[1] + (int)Math.ceil((double) (final_time - fees[0]) / fees[2]) * fees[3]);
        return ans.stream().mapToInt(k -> k).toArray();
    }
}