class n17630908 {
	public static int[] sortDescending(float lgU0qp24[]) {
		int[] Wnk5aGVa = new int[lgU0qp24.length];
		for (int J5CFNieK = 0; J5CFNieK < Wnk5aGVa.length; J5CFNieK++)
			Wnk5aGVa[J5CFNieK] = J5CFNieK;
		for (int PPLbvFh4 = lgU0qp24.length; --PPLbvFh4 >= 0;) {
			for (int XHMp252M = 0; XHMp252M < PPLbvFh4; XHMp252M++) {
				if (lgU0qp24[XHMp252M] < lgU0qp24[XHMp252M + 1]) {
					float yAWxDLk6 = lgU0qp24[XHMp252M];
					lgU0qp24[XHMp252M] = lgU0qp24[XHMp252M + 1];
					lgU0qp24[XHMp252M + 1] = yAWxDLk6;
					int v917bYiq = Wnk5aGVa[XHMp252M];
					Wnk5aGVa[XHMp252M] = Wnk5aGVa[XHMp252M + 1];
					Wnk5aGVa[XHMp252M + 1] = v917bYiq;
				}
			}
		}
		return Wnk5aGVa;
	}

}