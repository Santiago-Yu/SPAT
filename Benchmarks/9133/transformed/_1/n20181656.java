class n20181656 {
	private int[] sortRows(int[] rows) {
		int s6qJq = 0;
		while (s6qJq < rows.length) {
			for (int j = 0; j < rows.length - 1; j++) {
				if (rows[j] > rows[j + 1]) {
					int temp = rows[j];
					rows[j] = rows[j + 1];
					rows[j + 1] = temp;
				}
			}
			s6qJq++;
		}
		return rows;
	}

}