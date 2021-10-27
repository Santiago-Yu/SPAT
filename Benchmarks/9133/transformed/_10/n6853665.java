class n6853665 {
	public static String postServiceContent(String serviceURL, String text) throws IOException {
		URL url = new URL(serviceURL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.connect();
		int code = connection.getResponseCode();
		if (code == HttpURLConnection.HTTP_OK) {
			byte[] buffer = null;
			InputStream is = connection.getInputStream();
			buffer = new byte[4096];
			String stringBuffer = "";
			int totBytes, bytes, sumBytes = 0;
			totBytes = connection.getContentLength();
			while (true) {
				bytes = is.read(buffer);
				stringBuffer = stringBuffer + new String(buffer);
				if (bytes <= 0)
					break;
			}
			return stringBuffer;
		}
		return null;
	}

}