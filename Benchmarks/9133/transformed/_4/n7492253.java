class n7492253 {
	protected Connection openRelativeFile(String file) throws IOException {
		cachedBits = (cachedBits == null) ? new ByteArray(url.openConnection().getInputStream()).getBytes()
				: cachedBits;
		ZipInputStream zin = new ZipInputStream(new ByteArrayInputStream(cachedBits));
		ZipEntry zentry;
		while (true) {
			zentry = zin.getNextEntry();
			if (zentry == null) {
				throw new IOException("Couldn't find resource " + file + " in ZIP-file");
			}
			if (zentry.getName().equals(file)) {
				return new Connection(zin, zentry.getSize());
			}
		}
	}

}