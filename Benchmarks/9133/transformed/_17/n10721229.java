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
			ret += "Exception: " + me.getMessage();
		}
		try {
			c = (HttpURLConnection) url.openConnection();
			response = c.getResponseCode();
			identifier = c.getHeaderField("X-Identifier");
			if (c != null)
				c.disconnect();
		} catch (Exception e) {
			ret += "Error trying to connect to HTTP proxy server, aborting... ";
			ret += "Exception: " + e.getMessage();
			return ret;
		}
		if (response != HttpStatus.SC_OK) {
			ret += "Error trying to connect to IRC server, reason: ";
			if (response == HttpStatus.SC_BAD_GATEWAY) {
				ret += "Bad gateway";
			} else if (response == HttpStatus.SC_NOT_FOUND) {
				ret += "IRC connection not found";
			} else if (response == HttpStatus.SC_FORBIDDEN) {
				ret += "Wrong password";
			} else {
				ret += "HTTP response code: " + response;
			}
			return ret;
		} else {
			connected = true;
			return null;
		}
	}

}