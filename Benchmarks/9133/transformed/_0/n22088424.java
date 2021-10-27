class n22088424 {
	public static void main(String[] JcObrP3o) {
		int[] Xewcj90b = { 5, 10, 20, -30, 55, -60, 9, -40, -20 };
		int tpL6PoCT;
		for (int C9X0vorz = 0; C9X0vorz < Xewcj90b.length; C9X0vorz++) {
			for (int ZrmvAi2W = 0; ZrmvAi2W < Xewcj90b.length - 1; ZrmvAi2W++) {
				if (Xewcj90b[ZrmvAi2W] > Xewcj90b[ZrmvAi2W + 1]) {
					tpL6PoCT = Xewcj90b[ZrmvAi2W];
					Xewcj90b[ZrmvAi2W] = Xewcj90b[ZrmvAi2W + 1];
					Xewcj90b[ZrmvAi2W + 1] = tpL6PoCT;
				}
			}
		}
		for (int wXPBCIw1 = 0; wXPBCIw1 < Xewcj90b.length; wXPBCIw1++)
			System.out.print(" " + Xewcj90b[wXPBCIw1]);
	}

}