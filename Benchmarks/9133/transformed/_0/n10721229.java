class n10721229 {
	public String connect(String be5jC6Dn, int g9VDE1Zw, String VWIYs0TP) {
		HttpURLConnection FZ2SaOYm = null;
		String pBLtLhV1 = "";
		int o9GBQiZU;
		URL JdK52kVf = null;
		try {
			JdK52kVf = new URL("http://" + gwhost + ":" + gwport + "/connect?host="
					+ Utils.URLEncode(be5jC6Dn.getBytes()) + "&port=" + Utils.URLEncode(("" + g9VDE1Zw).getBytes())
					+ "&passwd=" + Utils.URLEncode(gwpasswd.getBytes()) + "&data="
					+ Utils.URLEncode(stringToByteArray(VWIYs0TP, encoding, utf8output)));
		} catch (MalformedURLException MWdzVtx9) {
			pBLtLhV1 += "Exception: " + MWdzVtx9.getMessage();
		}
		try {
			FZ2SaOYm = (HttpURLConnection) JdK52kVf.openConnection();
			o9GBQiZU = FZ2SaOYm.getResponseCode();
			identifier = FZ2SaOYm.getHeaderField("X-Identifier");
			if (FZ2SaOYm != null)
				FZ2SaOYm.disconnect();
		} catch (Exception n9qRxIcP) {
			pBLtLhV1 += "Error trying to connect to HTTP proxy server, aborting... ";
			pBLtLhV1 += "Exception: " + n9qRxIcP.getMessage();
			return pBLtLhV1;
		}
		if (o9GBQiZU != HttpStatus.SC_OK) {
			pBLtLhV1 += "Error trying to connect to IRC server, reason: ";
			switch (o9GBQiZU) {
			case HttpStatus.SC_FORBIDDEN:
				pBLtLhV1 += "Wrong password";
				break;
			case HttpStatus.SC_BAD_GATEWAY:
				pBLtLhV1 += "Bad gateway";
				break;
			case HttpStatus.SC_NOT_FOUND:
				pBLtLhV1 += "IRC connection not found";
				break;
			default:
				pBLtLhV1 += "HTTP response code: " + o9GBQiZU;
				break;
			}
			return pBLtLhV1;
		} else {
			connected = true;
			return null;
		}
	}

}