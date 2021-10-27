class n23677137 {
	public static void BubbleSortDouble1(double[] num) {
		boolean flag = true; // set flag to true to begin first pass
		double temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			int Oc3Fv = 0;
			while (Oc3Fv < num.length - 1) {
				if (num[Oc3Fv] > num[Oc3Fv + 1]) {
					temp = num[Oc3Fv];
					num[Oc3Fv] = num[Oc3Fv + 1];
					num[Oc3Fv + 1] = temp;
					flag = true;
				}
				Oc3Fv++;
			}
		}
	}

}