import java.util.HashSet;
import java.util.Arrays;

public class Solution {
    public int[] solution(String s) {
        s = s.substring(0, s.length() - 2).replace("{", "");
        String[] arr = s.split("},");
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            String[] numbers = arr[i].split(",");
            for(String number : numbers){
                if(!set.contains(number)){
                    answer[i] = Integer.parseInt(number);
                    set.add(number);
                }
            }
        }
        return answer;
    }
}

/* 
# 좀 더 명확하게 문자열 파싱하기: 문자열 길이 말고 "집합 단위"로 다루기.

public class Solution {
    public int[] solution(String s){
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("},\\{");
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        HashSet<Integer> set = new HashSet<>();
        int[] answer = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            String[] numbers = arr[i].split(",");
            for(String number : numbers) {
                int v = Integer.parseInt(number);
                if(!set.contains(v)){
                    set.add(v);
                    answer[i] = v;
                }
            }
        }
        return answer;
    }
}

# 문자열 내에서 등장한 빈도수 기준으로 HashMap에 저장하고 내림차순으로 정렬: 튜플 순서.

public class Solution {
    public int[] solution(String s){
        String cleaned = s.replace("{", "").replace("}", "");
        String[] tokens = cleaned.split(",");
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(String token : tokens) {
            int num = Integer.parseInt(token);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> map.get(o2), map.get(o1));
        
        int[] answer = new int[keys.size()];
        for(int i = 0; i < keys.size(); i++){
            answer[i] = keys.get(i);
        }
        return answer;
    }
}

# 문자열로 저장된 각 집합을 ArrayList<Integer>로 변환해서 다루기.

public class Solution {
    public int[] solution(String s){
        s = s.substring(2, s.length() - 2);
        String[] parts = s.split("},\\{");
        
        ArrayList<ArrayList<Integer>> setsList = new ArrayList<>();
        for(String part : parts) {
            String[] nums = part.split(",");
            ArrayList<Integer> temp = new ArrayList<>();
            for(String num : nums){
                temp.add(Integer.parseInt(num));
            }
            setsList.add(temp);
        }
        
        setsList.sort(Comparator.comparingInt(ArrayList::size));
        
        HashSet<Integer> set = new HashSet<>();
        int[] answer = new int[setsList.size()];
        int idx = 0;
        for(ArrayList<Integer> setList : setsList){
            for(int v : setList){
                if(!set.contains(v){
                    set.add(v);
                    answer[idx++] = v;
                })
            }
        }
        return answer;
    }
}
*/