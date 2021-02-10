public class PowerTest {

//	public static long powerRec(int x, int n) {
//		if (n == 1)
//			return x;
//		return x * powerRec(x, n - 1);
//	}

//	public static long powerRec(int x, int n) {
//		long p = x;
//		for(int i = 1; i < n; i++) {
//			p *= x;
//		}
//		return p;
//	}
	
	public static long dcPower(int x, int n) {
		if (n == 0) return 1;
		if (n == 1) return x;

		long ret = dcPower(x, n >> 1);
		if (n % 2 == 0) return ret * ret;
		else return ret * ret * x;
	}

	public static void main(String[] args) {
		long stime = System.currentTimeMillis();
//		System.out.println(powerRec(2, 10));
		// System.out.println(dcPower(2, 10));
//		System.out.println(powerRec(9, 2111111111));
//		System.out.println(dcPower(9, 2111111111));
		long etime = System.currentTimeMillis();
		System.out.printf("%dms", etime - stime);
	}

}
