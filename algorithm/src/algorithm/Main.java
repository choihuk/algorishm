package algorithm;

public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int arr[]= {1, 5, 2, 6, 3, 7, 4};
		int arrr[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		for(int sol:solution.solution(arr,arrr)) {
			System.out.println(sol);
		}
	}

}
