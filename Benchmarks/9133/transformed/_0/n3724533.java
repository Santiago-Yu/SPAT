class n3724533 {
	public static Document getDocument(URL yJ8kULax) throws Exception {
		InputStream gxcRt6MS = null;
		try {
			gxcRt6MS = new BufferedInputStream(yJ8kULax.openStream());
			return getDocumentBuilder().parse(gxcRt6MS);
		} finally {
			if (gxcRt6MS != null) {
				try {
					gxcRt6MS.close();
				} catch (IOException LyZVzQgn) {
				}
			}
		}
	}

}