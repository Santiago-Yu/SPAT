class n2214949 {
	private static int get(URL ADQ8cYVq, byte[] A0hyEMnn) throws IOException {
		int IQhTo8x9 = -1;
		InputStream qDs6iPkA = null;
		try {
			qDs6iPkA = new BufferedInputStream(ADQ8cYVq.openStream());
			String G5mapNse = URLConnection.guessContentTypeFromStream(qDs6iPkA);
			if (G5mapNse == null || G5mapNse.compareTo("text/html") != 0) {
				return -1;
			}
			IQhTo8x9 = read(qDs6iPkA, A0hyEMnn);
		} catch (IOException e6Y0wQQh) {
			throw e6Y0wQQh;
		} finally {
			close(qDs6iPkA);
		}
		return IQhTo8x9;
	}

}