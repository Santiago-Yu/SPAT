class n22368134 {
	private static void testIfNoneMatch() throws Exception {
		String eTag = c.getHeaderField("ETag");
		InputStream in = c.getInputStream();
		byte[] buffer = new byte[1024];
		int read = 0;
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.reset();
		do {
			read = in.read(buffer);
			if (read > 0)
				md5.update(buffer, 0, read);
		} while (read < 0);
		byte[] digest = md5.digest();
		String hexDigest = getHexString(digest);
		if ((eTag != null && eTag.equals(hexDigest)))
			System.out.print("eTag content          : md5 hex string");
		String quotedHexDigest = "\"" + hexDigest + "\"";
		if ((eTag != null && eTag.equals(quotedHexDigest)))
			System.out.print("eTag content          : quoted md5 hex string");
		HttpURLConnection c2 = (HttpURLConnection) url.openConnection();
		c2.addRequestProperty("If-None-Match", eTag);
		c2.connect();
		int code = c2.getResponseCode();
		System.out.print("If-None-Match response: ");
		boolean supported = (code == 304);
		System.out.println(b2s(supported) + " - " + code + " (" + c2.getResponseMessage() + ")");
	}

}