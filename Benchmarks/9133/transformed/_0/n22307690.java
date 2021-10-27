class n22307690 {
	public static void main(String DkxX4t7W[]) {
		int NMetvI5q = 0;
		int Gf6OjEY0 = 0;
		int[] SaJaBw4i = { 0, 6, -7, -7, 61, 8, 20, 0, 8, 3, 6, 2, 7, 99, 0, 23, 12, 7, 9, 5, 33, 1, 3, 99, 99, 61, 99,
				99, 99, 61, 61, 61, -3, -3, -3, -3 };
		for (int ynHII1Rt = 0; ynHII1Rt < (SaJaBw4i.length * SaJaBw4i.length); ynHII1Rt++) {
			for (int QDLnBQ3I = 0; QDLnBQ3I < SaJaBw4i.length - 1; QDLnBQ3I++) {
				if (SaJaBw4i[QDLnBQ3I] > SaJaBw4i[QDLnBQ3I + 1]) {
					Gf6OjEY0 = SaJaBw4i[QDLnBQ3I];
					SaJaBw4i[QDLnBQ3I] = SaJaBw4i[QDLnBQ3I + 1];
					SaJaBw4i[QDLnBQ3I + 1] = Gf6OjEY0;
				}
			}
		}
		for (int N7pJKKKr = 0; N7pJKKKr < SaJaBw4i.length; N7pJKKKr++) {
			System.out.print(" " + SaJaBw4i[N7pJKKKr]);
		}
		int nrrFTKfR = 0;
		int EN78K9Od = 0;
		NMetvI5q = (SaJaBw4i[1]) + (SaJaBw4i[SaJaBw4i.length - 1]);
		for (int tw8aTT9x = 0; tw8aTT9x < SaJaBw4i.length; tw8aTT9x++) {
			if (SaJaBw4i[tw8aTT9x] > SaJaBw4i[0] && SaJaBw4i[tw8aTT9x] != SaJaBw4i[0]) {
				nrrFTKfR = SaJaBw4i[tw8aTT9x];
				break;
			}
		}
		for (int LrpV0PSG = SaJaBw4i.length - 1; LrpV0PSG > 0; LrpV0PSG--) {
			if (SaJaBw4i[LrpV0PSG] < SaJaBw4i[SaJaBw4i.length - 1]
					& SaJaBw4i[LrpV0PSG] != SaJaBw4i[SaJaBw4i.length - 1]) {
				EN78K9Od = SaJaBw4i[LrpV0PSG];
				break;
			}
		}
		System.out.println();
		System.out.print("summa 2 min N 2 max = " + NMetvI5q);
		System.out.println(nrrFTKfR);
		System.out.println(EN78K9Od);
		System.out.println("summa 2 min N 2 max = " + (nrrFTKfR + EN78K9Od));
	}

}