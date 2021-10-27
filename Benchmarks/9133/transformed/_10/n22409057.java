class n22409057 {
	private void sortWhats(String[] labels, int[] whats, String simplifyString) {
		boolean swapped;
		int n = whats.length;
		do {
			swapped = false;
			for (int i = 0; i < n - 1; i++) {
				int i0_pos = simplifyString.indexOf(labels[whats[i]]);
				int i1_pos = simplifyString.indexOf(labels[whats[i + 1]]);
				if (i0_pos > i1_pos) {
					int temp = whats[i];
					whats[i] = whats[i + 1];
					swapped = true;
					whats[i + 1] = temp;
				}
			}
		} while (swapped);
	}

}