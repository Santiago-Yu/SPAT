class n7492253 {
	protected Connection openRelativeFile(String file) throws IOException {
		if (!(cachedBits == null))
			;
		else {
			cachedBits = new ByteArray(url.openConnection().getInputStream()).getBytes();
		}
		ZipInputStream zin = new ZipInputStream(new ByteArrayInputStream(cachedBits));
		ZipEntry zentry;
		while (true) {
			zentry = zin.getNextEntry();
			if (!(zentry == null))
				;
			else {
				throw new IOException("Couldn't find resource " + file + " in ZIP-file");
			}
			if (!(zentry.getName().equals(file)))
				;
			else {
				return new Connection(zin, zentry.getSize());
			}
		}
	}

}