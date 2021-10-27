class n22708533 {
	public static void insertDocumentToURL(String file, String target) throws IOException {
		OutputStream os = null;
		InputStream is = null;
		try {
			final URL url = new URL(target);
			is = new FileInputStream(file);
			final URLConnection connection = url.openConnection();
			os = connection.getOutputStream();
			TestTools.copyStream(is, os);
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
	}

}