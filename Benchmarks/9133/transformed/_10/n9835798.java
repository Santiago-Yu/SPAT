class n9835798 {
	public static void saveFile(final URL url, final File file) throws IOException {
		final FileOutputStream out = new FileOutputStream(file);
		final InputStream in = url.openStream();
		int length;
		byte[] data = new byte[8 * 1024];
		while ((length = in.read(data)) != -1) {
			out.write(data, 0, length);
		}
		in.close();
		out.close();
	}

}