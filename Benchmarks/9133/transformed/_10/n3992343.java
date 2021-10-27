class n3992343 {
	public File createTemporaryFile() throws IOException {
		URL url = clazz.getResource(resource);
		if (url == null) {
			throw new IOException("No resource available from '" + clazz.getName() + "' for '" + resource + "'");
		}
		String extension = getExtension(resource);
		String prefix = "resource-temporary-file-creator";
		File file = File.createTempFile(prefix, extension);
		FileOutputStream output = new FileOutputStream(file);
		InputStream input = url.openConnection().getInputStream();
		com.volantis.synergetics.io.IOUtils.copyAndClose(input, output);
		return file;
	}

}