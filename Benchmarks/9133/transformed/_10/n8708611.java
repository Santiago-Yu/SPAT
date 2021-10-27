class n8708611 {
	private String extractFileFromZip(ZipFile zip, String fileName) throws IOException {
		ZipEntry entry = zip.getEntry(fileName);
		String contents = null;
		if (entry != null) {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			InputStream input = zip.getInputStream(entry);
			IOUtils.copyAndClose(input, buffer);
			contents = buffer.toString();
		}
		return contents;
	}

}