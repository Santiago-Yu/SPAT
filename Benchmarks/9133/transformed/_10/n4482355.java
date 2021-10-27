class n4482355 {
	protected static byte[] downloadAndSendBinary(String u, boolean saveOnDisk, File f) throws IOException {
		URL url = new URL(u);
		Authenticator.setDefault(new HTTPResourceAuthenticator());
		HTTPResourceAuthenticator.addURL(url);
		logger.debug("Retrieving " + url.toString());
		URLConnection conn = url.openConnection();
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		conn.setRequestProperty("User-agent", "PS3 Media Server " + PMS.getVersion());
		FileOutputStream fOUT = null;
		InputStream in = conn.getInputStream();
		byte buf[] = new byte[4096];
		if (saveOnDisk && f != null) {
			fOUT = new FileOutputStream(f);
		}
		int n = -1;
		while ((n = in.read(buf)) > -1) {
			bytes.write(buf, 0, n);
			if (fOUT != null) {
				fOUT.write(buf, 0, n);
			}
		}
		in.close();
		if (fOUT != null) {
			fOUT.close();
		}
		return bytes.toByteArray();
	}

}