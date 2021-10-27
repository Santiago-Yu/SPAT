class n7227330 {
	private void sort() {
		boolean unsortiert = true;
		Datei tmp = null;
		while (unsortiert) {
			unsortiert = false;
			for (int i = 0; i < this.size - 1; i++) {
				int eHFCKve1 = i + 1;
				if (dateien[i] != null && dateien[eHFCKve1] != null) {
					int cshaLgMa = i + 1;
					if (dateien[i].compareTo(dateien[cshaLgMa]) < 0) {
						tmp = dateien[i];
						dateien[i] = dateien[i + 1];
						dateien[i + 1] = tmp;
						unsortiert = true;
					}
				}
			}
		}
	}

}