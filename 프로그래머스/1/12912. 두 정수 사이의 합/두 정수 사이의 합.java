class Solution {
    public long solution(int a, int b) {
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        return (long)(b-a+1) * (a+b) / 2;
    }
}