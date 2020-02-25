package algorithm;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
    	int[] answer = new int[commands.length];
    	int number = 0;
    	for (int i = 0; i < commands.length; i++) {
    		int arr[] = new int[commands[i][1]-commands[i][0]+1];
    		int num = 0;
			for (int j = 0; j < array.length; j++) {
				if(commands[i][0]-1<=j&&commands[i][1]-1>=j) {
					arr[num] = array[j];
					num++;
				}
			}
			for (int j = 0; j < arr.length; j++) {
				for (int k =j+1; k < arr.length; k++) {
					if(arr[j]>arr[k]) {
						int tmep = arr[j];
						arr[j] = arr[k];
						arr[k] = tmep;
					}
				}
			}
			answer[number] = arr[commands[i][2]-1];
			number++;
		}
        return answer;
    }
}