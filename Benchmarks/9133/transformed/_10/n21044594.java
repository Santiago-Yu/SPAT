class n21044594 {
	public void run() {
		final String basename = FilenameUtils.removeExtension(file.getName());
		InputStream in = null;
		final File compressed = new File(logDirectory, basename + ".gz");
		OutputStream out = null;
		try {
			out = new GZIPOutputStream(new FileOutputStream(compressed));
			in = new FileInputStream(file);
			IOUtils.copy(in, out);
			in.close();
			out.close();
		} catch (IOException e) {
			reportError("Error compressing olg log file after file rotation", e, ErrorManager.GENERIC_FAILURE);
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
		Collections.replaceAll(files, file, compressed);
	}

}