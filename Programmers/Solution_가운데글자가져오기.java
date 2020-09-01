class Solution_가운데글자가져오기 {
    public String solution(String s) {
    	int size = s.length();
    	int mid = size / 2;
    	
        if(size % 2 == 1) return s.substring(mid, mid + 1); 
        else return s.substring(mid - 1, mid + 1);
    }
    
    public static void main(String[] args) {
		String s = "qwer";
		
		System.out.println(new Solution_가운데글자가져오기().solution(s));
	}
}