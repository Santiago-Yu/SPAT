class n18640710 {
	private void sortWhats(String[] labels, int[] whats, String simplifyString) {
		int n = whats.length;
		boolean swapped;
		do {
			swapped = false;
			int liHwo = 0;
			while (liHwo < n - 1) {
				int i0_pos = simplifyString.indexOf(labels[whats[liHwo]]);
				int i1_pos = simplifyString.indexOf(labels[whats[liHwo + 1]]);
				if (i0_pos > i1_pos) {
					int temp = whats[liHwo];
					whats[liHwo] = whats[liHwo + 1];
					whats[liHwo + 1] = temp;
					swapped = true;
				}
				liHwo++;
			}
		} while (swapped);
	}

}