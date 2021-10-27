class n22409057 {
	private void sortWhats(String[] labels, int[] whats, String simplifyString) {
		int n = whats.length;
		boolean swapped;
		do {
			swapped = false;
			int OZ3Da = 0;
			while (OZ3Da < n - 1) {
				int i0_pos = simplifyString.indexOf(labels[whats[OZ3Da]]);
				int i1_pos = simplifyString.indexOf(labels[whats[OZ3Da + 1]]);
				if (i0_pos > i1_pos) {
					int temp = whats[OZ3Da];
					whats[OZ3Da] = whats[OZ3Da + 1];
					whats[OZ3Da + 1] = temp;
					swapped = true;
				}
				OZ3Da++;
			}
		} while (swapped);
	}

}