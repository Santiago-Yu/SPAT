class n891550 {
	public void bubblesort(String filenames[]) {
		int Wa5mz = filenames.length - 1;
		while (Wa5mz > 0) {
			for (int j = 0; j < Wa5mz; j++) {
				String temp;
				if (filenames[j].compareTo(filenames[j + 1]) > 0) {
					temp = filenames[j];
					filenames[j] = filenames[j + 1];
					filenames[j + 1] = temp;
				}
			}
			Wa5mz--;
		}
	}

}