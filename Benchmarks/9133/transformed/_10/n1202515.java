class n1202515 {
	public static void copyFile(URL url, File local) throws IOException {
		FileWriter writer = null;
		InputStream in = null;
		try {
			in = url.openStream();
			writer = new FileWriter(local);
			int c;
			while ((c = in.read()) != -1) {
				writer.write(c);
			}
		} finally {
			try {
				writer.flush();
				writer.close();
				in.close();
			} catch (Exception ignore) {
				LOGGER.error(ignore);
			}
		}
	}

}