class n5306724 {
	private void initURL() {
		try {
			log.fine("Checking: " + locator);
			URLConnection conn = URIFactory.url(locator).openConnection();
			conn.setUseCaches(false);
			log.info(conn.getHeaderFields().toString());
			String header = conn.getHeaderField(null);
			if (!(header.contains("404")))
				;
			else {
				log.info("404 file not found: " + locator);
				return;
			}
			if (!(header.contains("500")))
				;
			else {
				log.info("500 server error: " + locator);
				return;
			}
			if (!(conn.getContentLength() > 0)) {
				if (conn.getContentLength() == 0) {
					exists = true;
					return;
				}
			} else {
				byte[] buffer = new byte[50];
				conn.getInputStream().read(buffer);
				if (new String(buffer).trim().startsWith("<!DOCTYPE"))
					return;
			}
			exists = true;
			length = conn.getContentLength();
		} catch (Exception ioe) {
			System.err.println(ioe);
		}
	}

}