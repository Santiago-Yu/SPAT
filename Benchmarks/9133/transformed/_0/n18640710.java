class n18640710 {
	private void sortWhats(String[] k2vsozDF, int[] Ur9tckYT, String YeZbiats) {
		int vek7YEh1 = Ur9tckYT.length;
		boolean gbzqmVgu;
		do {
			gbzqmVgu = false;
			for (int jcREgSVt = 0; jcREgSVt < vek7YEh1 - 1; jcREgSVt++) {
				int L1am5JyL = YeZbiats.indexOf(k2vsozDF[Ur9tckYT[jcREgSVt]]);
				int DdKhiMJM = YeZbiats.indexOf(k2vsozDF[Ur9tckYT[jcREgSVt + 1]]);
				if (L1am5JyL > DdKhiMJM) {
					int tHN4EIXZ = Ur9tckYT[jcREgSVt];
					Ur9tckYT[jcREgSVt] = Ur9tckYT[jcREgSVt + 1];
					Ur9tckYT[jcREgSVt + 1] = tHN4EIXZ;
					gbzqmVgu = true;
				}
			}
		} while (gbzqmVgu);
	}

}