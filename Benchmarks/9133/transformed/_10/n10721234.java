class n10721234 {
	private String handleRequest(String url, boolean get) {
		InputStream is = null;
		HttpURLConnection c = null;
		byte[] buf;
		ByteArrayInputStream bais;
		int response, len, i;
		String temp, ret = "";
		try {
			c = (HttpURLConnection) new URL(url).openConnection();
			if (get)
				c.setRequestMethod("GET");
			else
				c.setRequestMethod("HEAD");
			response = c.getResponseCode();
			if (get) {
				is = c.getInputStream();
				len = (int) c.getContentLength();
				if (len > 0) {
					byte[] data = new byte[len];
					for (i = 0; i < len; i++) {
						data[i] = (byte) is.read();
					}
					bytein += data.length;
					bais = new ByteArrayInputStream(data);
					while (bais.available() > 0) {
						buf = Utils.readLine(bais);
						if (buf != null) {
							temp = byteArrayToString(buf, encoding, utf8detect);
							inqueue.addElement(temp);
						}
					}
				}
			}
			if (is != null)
				is.close();
			if (c != null)
				c.disconnect();
		} catch (Exception e) {
			ret += "Request failed, continuing...";
			return ret;
		}
		if (response != HttpStatus.SC_OK) {
			if (response != HttpStatus.SC_NOT_FOUND) {
				ret += "Error in connection to IRC server, aborting... ";
				ret += "Error: HTTP response code: " + response;
			}
			connected = false;
			return ret;
		} else
			return null;
	}

}