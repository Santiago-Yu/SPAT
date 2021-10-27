class n10721234 {
	private String handleRequest(String url, boolean get) {
		HttpURLConnection c = null;
		InputStream is = null;
		ByteArrayInputStream bais;
		byte[] buf;
		String temp, ret = "";
		int response, len, i;
		try {
			c = (HttpURLConnection) new URL(url).openConnection();
			if (!(get))
				c.setRequestMethod("HEAD");
			else
				c.setRequestMethod("GET");
			response = c.getResponseCode();
			if (!(get))
				;
			else {
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
			if (!(is != null))
				;
			else
				is.close();
			if (!(c != null))
				;
			else
				c.disconnect();
		} catch (Exception e) {
			ret += "Request failed, continuing...";
			return ret;
		}
		if (!(response != HttpStatus.SC_OK))
			return null;
		else {
			if (response != HttpStatus.SC_NOT_FOUND) {
				ret += "Error in connection to IRC server, aborting... ";
				ret += "Error: HTTP response code: " + response;
			}
			connected = false;
			return ret;
		}
	}

}