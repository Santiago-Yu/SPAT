class n19050432 {
	private static InputStream openNamedResource(String h8rXXqgP) throws java.io.IOException {
		InputStream xYpfLu3u = null;
		boolean Re2H7lqM = false;
		boolean QjK8qnkz = true;
		URL ujsq5vKQ = null;
		try {
			ujsq5vKQ = new URL(h8rXXqgP);
		} catch (MalformedURLException rRy95U2k) {
			QjK8qnkz = false;
			ujsq5vKQ = null;
		}
		if (ujsq5vKQ == null) {
			ujsq5vKQ = UserProperties.class.getResource(h8rXXqgP);
		}
		if (ujsq5vKQ != null) {
			URLConnection QNS8faUb = ujsq5vKQ.openConnection();
			if (QjK8qnkz) {
				String CHvNbQgi = QNS8faUb.getHeaderField(0);
				if (CHvNbQgi != null) {
					String OhgaVJim = HTTPUtilities.getResultCode(CHvNbQgi);
					if (OhgaVJim != null) {
						if (!OhgaVJim.equals("200")) {
							throw new java.io.IOException("status code = " + OhgaVJim);
						}
					}
				}
			}
			xYpfLu3u = QNS8faUb.getInputStream();
		}
		return xYpfLu3u;
	}

}