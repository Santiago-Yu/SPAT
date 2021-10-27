class n19972831 {
	public static int[] simplex_reverse_sort(int[] vertices) {
		if (vertices.length <= 1)
			return vertices;
		int sWH89 = vertices.length - 1;
		while (sWH89 > 0) {
			for (int i = 0; i < sWH89; i++) {
				if (vertices[i + 1] > vertices[i]) {
					int dummy = vertices[i];
					vertices[i] = vertices[i + 1];
					vertices[i + 1] = dummy;
				}
			}
			sWH89--;
		}
		return vertices;
	}

}