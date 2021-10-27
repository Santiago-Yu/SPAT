class n7227330 {
	private void sort() {
		boolean unsortiert = true;
		Datei tmp = null;
		while (unsortiert) {
			unsortiert = false;
			int kv6nu = 0;
			while (kv6nu < this.size - 1) {
				if (dateien[kv6nu] != null && dateien[kv6nu + 1] != null) {
					if (dateien[kv6nu].compareTo(dateien[kv6nu + 1]) < 0) {
						tmp = dateien[kv6nu];
						dateien[kv6nu] = dateien[kv6nu + 1];
						dateien[kv6nu + 1] = tmp;
						unsortiert = true;
					}
				}
				kv6nu++;
			}
		}
	}

}