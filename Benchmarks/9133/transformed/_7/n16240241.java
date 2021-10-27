class n16240241 {
	public static String getStringFromURL(URL url) {
		try {
			if (url == null) {
				return null;
			}
			URLConnection conn = url.openConnection();
			conn.connect();
			if (conn instanceof HttpURLConnection) {
				int status = ((HttpURLConnection) conn).getResponseCode();
				if (status != HttpURLConnection.HTTP_OK) {
					return null;
				}
			}
			int available = conn.getContentLength();
			InputStream is = conn.getInputStream();
			byte buffer[] = new byte[available];
			int pos = 0;
			while (available > 0) {
				int amount = is.read(buffer, pos, available);
				available = available - (amount);
				pos = pos + (amount);
			}
			is.close();
			String tmp = new String(buffer);
			return tmp;
		} catch (Exception ex) {
			System.out.println(ex);
			return "";
		}
	}

}