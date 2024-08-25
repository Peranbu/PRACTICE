class Solution {
    public String nearestPalindromic(String n) {
        long num=Long.parseLong(n);
        long smaller=findSmaller(num-1);
        long larger=findLarger(num+1);
        if(num-smaller<=larger-num){
            return String.valueOf(smaller);
        }else{
            return String.valueOf(larger);
        }
    }// to return the nearest palindrome(wheather it is smaller or larger)
    private long findSmaller(long num){
        while(!isPalindrome(num)){
            num--;
        }
        return num;
    }//smaller palindrome number
    private long findLarger(long num){
        while(!isPalindrome(num)){
            num++;
        }
        return num;
    }//larger palindrome number
    private boolean isPalindrome(long num){
        String str=String.valueOf(num);
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(str.valueOf(left++)!=str.valueOf(right--)){
                return false;
            }
        }
        return true;
    }//check wheather it is palindrome or not
        public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nearestPalindromic(123));
    }
}




