class n15472181 {
	private InputStream getInputStream(String item) {
		URLConnection urlc = null;
		InputStream is = null;
		int i = 0;
		try {
			URL url = new URL(item);
			urlc = url.openConnection();
			is = urlc.getInputStream();
			current_source = url.getProtocol() + "://" + url.getHost() + ":" + url.getPort() + url.getFile();
		} catch (Exception ee) {
			System.err.println(ee);
		}
		udp_port = -1;
		udp_baddress = null;
		while (urlc != null) {
			String s = urlc.getHeaderField(i);
			if (s == null) {
				break;
			}
			String t = urlc.getHeaderFieldKey(i);
			if ("udp-port".equals(t)) {
				try {
					udp_port = Integer.parseInt(s);
				} catch (Exception e) {
				}
			} else if ("udp-broadcast-address".equals(t)) {
				udp_baddress = s;
			}
			i++;
		}
		return is;
	}

}