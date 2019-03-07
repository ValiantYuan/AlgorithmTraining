package practice;

class Solution {
	
	public static void main(String[] args) {
		int[][] matrix = {{1,4},{2,5}};
		new Solution().searchMatrix(matrix, 4);
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int col = matrix[0].length - 1;
        int row = 0;
        
        while(col >= 0 && row < matrix.length) {
        	if(matrix[row][col] == target) return true;
        	else if(matrix[row][col] > target) row++;
        	else col--;
        }
        return false;
    }
    

    
}