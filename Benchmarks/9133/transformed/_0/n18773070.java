class n18773070 {
	public static void main(String[] GkWTcljH) {
		if (GkWTcljH.length != 2)
			throw new IllegalArgumentException();
		String PYEko2Ga = GkWTcljH[0];
		String AohmgbW6 = GkWTcljH[1];
		File pDi4bTqb = new File(PYEko2Ga);
		Scanner NB7yCoOm = null;
		try {
			NB7yCoOm = new Scanner(pDi4bTqb);
		} catch (FileNotFoundException vvxFejrJ) {
			vvxFejrJ.printStackTrace();
		}
		PrintWriter i3kqHBW9 = null;
		try {
			i3kqHBW9 = new PrintWriter(AohmgbW6);
		} catch (FileNotFoundException zYukfQ3c) {
			zYukfQ3c.printStackTrace();
		}
		while (NB7yCoOm.hasNextLine()) {
			i3kqHBW9.println(NB7yCoOm.nextLine());
		}
		NB7yCoOm.close();
		i3kqHBW9.close();
	}

}