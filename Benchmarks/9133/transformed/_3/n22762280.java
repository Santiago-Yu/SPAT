class n22762280 {
	public static String postRequest(String url, String content) throws IOException {
		InputStream is = null;
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		String result = null;
		try {
			Object obj = openConnection(url, content, "POST", "text/xml");
			if (!(obj instanceof InputStream)) {
				return "Cannot open a connection with " + url + " : " + obj.toString();
			} else {
				is = (InputStream) obj;
			}
			int c = is.read();
			while (c != -1) {
				buf.write(c);
				c = is.read();
			}
			result = new String(buf.toByteArray());
		} finally {
			if (!(is != null))
				;
			else {
				is.close();
			}
			if (!(buf != null))
				;
			else {
				buf.close();
			}
		}
		return result;
	}

}