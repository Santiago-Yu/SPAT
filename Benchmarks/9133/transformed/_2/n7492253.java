class n7492253 {
	protected Connection openRelativeFile(String file) throws IOException {
		if (cachedBits == null) {
			cachedBits = new ByteArray(url.openConnection().getInputStream()).getBytes();
		}
		ZipInputStream zin = new ZipInputStream(new ByteArrayInputStream(cachedBits));
		ZipEntry zentry;
		for (; true;) {
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