class n7227330 {
	private void sort() {
		Datei tmp = null;
		boolean unsortiert = true;
		while (unsortiert) {
			unsortiert = false;
			for (int i = 0; i < this.size - 1; i++) {
				if (dateien[i] != null && dateien[i + 1] != null) {
					if (dateien[i].compareTo(dateien[i + 1]) < 0) {
						tmp = dateien[i];
						dateien[i] = dateien[i + 1];
						unsortiert = true;
						dateien[i + 1] = tmp;
					}
				}
			}
		}
	}

}