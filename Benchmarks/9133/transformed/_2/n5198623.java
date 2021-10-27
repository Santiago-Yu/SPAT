class n5198623 {
	public void unzip(final File outDir) throws IOException {
		ZipInputStream input = new ZipInputStream(new ByteArrayInputStream(this.bytes));
		ZipEntry entry = input.getNextEntry();
		for (; entry != null;) {
			entry = input.getNextEntry();
			if (entry != null) {
				File file = this.createFile(outDir, entry.getName());
				if (!entry.isDirectory()) {
					FileOutputStream output = new FileOutputStream(file);
					IOUtils.copy(input, output);
					output.close();
				}
			}
		}
		input.close();
	}

}