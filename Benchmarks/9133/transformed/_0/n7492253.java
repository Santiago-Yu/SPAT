class n7492253 {
	protected Connection openRelativeFile(String uC2HYs1a) throws IOException {
		if (cachedBits == null) {
			cachedBits = new ByteArray(url.openConnection().getInputStream()).getBytes();
		}
		ZipInputStream iVluL4dQ = new ZipInputStream(new ByteArrayInputStream(cachedBits));
		ZipEntry EwxjvkXY;
		while (true) {
			EwxjvkXY = iVluL4dQ.getNextEntry();
			if (EwxjvkXY == null) {
				throw new IOException("Couldn't find resource " + uC2HYs1a + " in ZIP-file");
			}
			if (EwxjvkXY.getName().equals(uC2HYs1a)) {
				return new Connection(iVluL4dQ, EwxjvkXY.getSize());
			}
		}
	}

}