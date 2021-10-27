class n22368135 {
	private static void testIfModified() throws IOException {
		HttpURLConnection TO6o7Izx = (HttpURLConnection) url.openConnection();
		TO6o7Izx.setIfModifiedSince(System.currentTimeMillis() + 1000);
		TO6o7Izx.connect();
		int EzYqe6SH = TO6o7Izx.getResponseCode();
		System.out.print("If-Modified-Since     : ");
		boolean QgZD3LmI = (EzYqe6SH == 304);
		System.out.println(b2s(QgZD3LmI) + " - " + EzYqe6SH + " (" + TO6o7Izx.getResponseMessage() + ")");
	}

}