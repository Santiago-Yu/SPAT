class n10721229 {
	public String connect(String host, int port, String init) {
		HttpURLConnection c = null;
		String ret = "";
		int response;
		URL url = null;
		try {
			url = new URL("http://" + gwhost + ":" + gwport + "/connect?host=" + Utils.URLEncode(host.getBytes())
					+ "&port=" + Utils.URLEncode(("" + port).getBytes()) + "&passwd="
					+ Utils.URLEncode(gwpasswd.getBytes()) + "&data="
					+ Utils.URLEncode(stringToByteArray(init, encoding, utf8output)));
		} catch (MalformedURLException me) {
			ret = ret + ("Exception: " + me.getMessage());
		}
		try {
			c = (HttpURLConnection) url.openConnection();
			response = c.getResponseCode();
			identifier = c.getHeaderField("X-Identifier");
			if (c != null)
				c.disconnect();
		} catch (Exception e) {
			ret = ret + ("Error trying to connect to HTTP proxy server, aborting... ");
			ret = ret + ("Exception: " + e.getMessage());
			return ret;
		}
		if (response != HttpStatus.SC_OK) {
			ret = ret + ("Error trying to connect to IRC server, reason: ");
			switch (response) {
			case HttpStatus.SC_FORBIDDEN:
				ret = ret + ("Wrong password");
				break;
			case HttpStatus.SC_BAD_GATEWAY:
				ret = ret + ("Bad gateway");
				break;
			case HttpStatus.SC_NOT_FOUND:
				ret = ret + ("IRC connection not found");
				break;
			default:
				ret = ret + ("HTTP response code: " + response);
				break;
			}
			return ret;
		} else {
			connected = true;
			return null;
		}
	}

}