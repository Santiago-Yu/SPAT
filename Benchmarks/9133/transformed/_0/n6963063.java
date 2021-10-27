class n6963063 {
	public static void main(String NQOvk4ua[]) {
		int[] fv8cs4zZ = { 3, 5, 6, 9, 1, -3, -4, -88 };
		int uUeCcuWI = 0;
		for (int FT4ruejZ = 0; FT4ruejZ < (fv8cs4zZ.length); FT4ruejZ++) {
			for (int NNirHOV6 = 0; NNirHOV6 < fv8cs4zZ.length - 1; NNirHOV6++) {
				if (fv8cs4zZ[NNirHOV6] > fv8cs4zZ[NNirHOV6 + 1]) {
					uUeCcuWI = fv8cs4zZ[NNirHOV6];
					fv8cs4zZ[NNirHOV6] = fv8cs4zZ[NNirHOV6 + 1];
					fv8cs4zZ[NNirHOV6 + 1] = uUeCcuWI;
				}
			}
		}
		for (int FtdldAY3 = 0; FtdldAY3 < fv8cs4zZ.length; FtdldAY3++) {
			System.out.print(" " + fv8cs4zZ[FtdldAY3]);
		}
	}

}