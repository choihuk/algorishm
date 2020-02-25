package summerWinterCoding;

class Solution {
	public long solution(long w,long h) {
        long one = w;
        long two = h;
		if(w<h) {
        	one = h;
        	two = w;
        }
		long r = 1;
		while(r>0) {
			r = one%two;
			one = two;
			two = r;
		}
		return w*h-(w/one+h/one-1)*one;
	}
}