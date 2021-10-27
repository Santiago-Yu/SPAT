class n151792 {
	public void bubblesort(String filenames[]) {
		int tjCzz = filenames.length - 1;
		while (tjCzz > 0) {
			for (int j = 0; j < tjCzz; j++) {
				String temp;
				if (filenames[j].compareTo(filenames[j + 1]) > 0) {
					temp = filenames[j];
					filenames[j] = filenames[j + 1];
					filenames[j + 1] = temp;
				}
			}
			tjCzz--;
		}
	}

}