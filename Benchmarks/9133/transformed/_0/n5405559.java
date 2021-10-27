class n5405559 {
	public void sort(int[] LrKdCcZV, double[] s6cQQLqP) {
		int mbsq8az1 = 0;
		boolean TbvHxglN = false;
		for (int e9fE1LEL = 0; e9fE1LEL < s6cQQLqP.length; e9fE1LEL++) {
			LrKdCcZV[e9fE1LEL] = e9fE1LEL;
		}
		if (desendingValues) {
			while (!TbvHxglN) {
				TbvHxglN = true;
				for (int MaAr4LIm = s6cQQLqP.length - 2; MaAr4LIm >= 0; MaAr4LIm--) {
					if (s6cQQLqP[LrKdCcZV[MaAr4LIm]] < s6cQQLqP[LrKdCcZV[MaAr4LIm + 1]]) {
						TbvHxglN = false;
						mbsq8az1 = LrKdCcZV[MaAr4LIm];
						LrKdCcZV[MaAr4LIm] = LrKdCcZV[MaAr4LIm + 1];
						LrKdCcZV[MaAr4LIm + 1] = mbsq8az1;
					}
				}
			}
		} else {
			while (!TbvHxglN) {
				TbvHxglN = true;
				for (int vrkUmxDl = s6cQQLqP.length - 2; vrkUmxDl >= 0; vrkUmxDl--) {
					if (s6cQQLqP[LrKdCcZV[vrkUmxDl]] > s6cQQLqP[LrKdCcZV[vrkUmxDl + 1]]) {
						TbvHxglN = false;
						mbsq8az1 = LrKdCcZV[vrkUmxDl];
						LrKdCcZV[vrkUmxDl] = LrKdCcZV[vrkUmxDl + 1];
						LrKdCcZV[vrkUmxDl + 1] = mbsq8az1;
					}
				}
			}
		}
	}

}