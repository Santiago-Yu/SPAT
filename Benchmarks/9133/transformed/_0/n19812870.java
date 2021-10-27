class n19812870 {
	private void init() throws IOException {
		JarInputStream wuJywjJ7 = new JarInputStream(new BufferedInputStream(url.openStream()));
		try {
			do {
				ZipEntry DhQrLvc4 = wuJywjJ7.getNextEntry();
				if (DhQrLvc4 == null) {
					break;
				}
				if (!DhQrLvc4.isDirectory()) {
					entries.add(DhQrLvc4.getName());
				}
			} while (true);
		} finally {
			wuJywjJ7.close();
		}
	}

}