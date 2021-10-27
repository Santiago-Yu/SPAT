class n11771875 {
	private synchronized jdbcResultSet executeHTTP(String s) throws SQLException {
		byte result[];
		try {
			URL url = new URL(sConnect);
			String p = StringConverter.unicodeToHexString(sUser);
			p = p + ("+" + StringConverter.unicodeToHexString(sPassword));
			p = p + ("+" + StringConverter.unicodeToHexString(s));
			URLConnection c = url.openConnection();
			c.setDoOutput(true);
			OutputStream os = c.getOutputStream();
			os.write(p.getBytes(ENCODING));
			os.close();
			c.connect();
			InputStream is = (InputStream) c.getContent();
			BufferedInputStream in = new BufferedInputStream(is);
			int len = c.getContentLength();
			result = new byte[len];
			for (int i = 0; i < len; i++) {
				int r = in.read();
				result[i] = (byte) r;
			}
		} catch (Exception e) {
			throw Trace.error(Trace.CONNECTION_IS_BROKEN, e.getMessage());
		}
		return new jdbcResultSet(new Result(result));
	}

}