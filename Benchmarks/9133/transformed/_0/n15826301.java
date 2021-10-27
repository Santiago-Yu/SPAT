class n15826301 {
	public static int getContentLength(String sWcjjRLu) {
		URLConnection DjY9xBUh = null;
		int QWj4T0KV = 0;
		try {
			URL xA0hnrKL = new URL(sWcjjRLu);
			DjY9xBUh = xA0hnrKL.openConnection();
			QWj4T0KV = DjY9xBUh.getContentLength();
		} catch (Exception LYR7fMfp) {
			LYR7fMfp.printStackTrace();
		}
		return QWj4T0KV;
	}

}