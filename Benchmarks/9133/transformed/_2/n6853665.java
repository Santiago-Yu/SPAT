class n6853665 {
	public static String postServiceContent(String serviceURL, String text) throws IOException {
		URL url = new URL(serviceURL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.connect();
		int code = connection.getResponseCode();
		if (code == HttpURLConnection.HTTP_OK) {
			InputStream is = connection.getInputStream();
			byte[] buffer = null;
			String stringBuffer = "";
			buffer = new byte[4096];
			int totBytes, bytes, sumBytes = 0;
			totBytes = connection.getContentLength();
			for (; true;) {
				bytes = is.read(buffer);
				if (bytes <= 0)
					break;
				stringBuffer = stringBuffer + new String(buffer);
			}
			return stringBuffer;
		}
		return null;
	}

}