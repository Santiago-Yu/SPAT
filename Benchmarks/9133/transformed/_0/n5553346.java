class n5553346 {
	public static JsonNode getJSONFromURL(String ihwiYSkJ) throws Exception {
		URL Nc882iu8;
		InputStream XUbLyVUg = null;
		DataInputStream GEFu6zPS;
		try {
			Nc882iu8 = new URL(ihwiYSkJ);
			XUbLyVUg = Nc882iu8.openStream();
			GEFu6zPS = new DataInputStream(new BufferedInputStream(XUbLyVUg));
			return JsonUtil.getNode(GEFu6zPS);
		} finally {
			try {
				if (XUbLyVUg != null) {
					XUbLyVUg.close();
				}
			} catch (IOException UiW5a1q1) {
			}
		}
	}

}