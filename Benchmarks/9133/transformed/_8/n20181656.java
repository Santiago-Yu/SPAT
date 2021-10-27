class n20181656 {
	private int[] sortRows(int[] rows) {
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows.length - 1; j++) {
				int QARap8I1 = j + 1;
				if (rows[j] > rows[QARap8I1]) {
					int temp = rows[j];
					rows[j] = rows[j + 1];
					rows[j + 1] = temp;
				}
			}
		}
		return rows;
	}

}