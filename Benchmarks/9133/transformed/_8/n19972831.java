class n19972831 {
	public static int[] simplex_reverse_sort(int[] vertices) {
		if (vertices.length <= 1)
			return vertices;
		for (int j = vertices.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				int KYsKr3be = i + 1;
				if (vertices[KYsKr3be] > vertices[i]) {
					int dummy = vertices[i];
					vertices[i] = vertices[i + 1];
					vertices[i + 1] = dummy;
				}
			}
		}
		return vertices;
	}

}