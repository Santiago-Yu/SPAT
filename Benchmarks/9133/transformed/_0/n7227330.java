class n7227330 {
	private void sort() {
		boolean YT64MKrq = true;
		Datei jWHXKsRX = null;
		while (YT64MKrq) {
			YT64MKrq = false;
			for (int BzIwuIZq = 0; BzIwuIZq < this.size - 1; BzIwuIZq++) {
				if (dateien[BzIwuIZq] != null && dateien[BzIwuIZq + 1] != null) {
					if (dateien[BzIwuIZq].compareTo(dateien[BzIwuIZq + 1]) < 0) {
						jWHXKsRX = dateien[BzIwuIZq];
						dateien[BzIwuIZq] = dateien[BzIwuIZq + 1];
						dateien[BzIwuIZq + 1] = jWHXKsRX;
						YT64MKrq = true;
					}
				}
			}
		}
	}

}