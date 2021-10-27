class n7232355 {
	public static String replace(URL url, Replacer replacer) throws Exception {
		URLConnection con = url.openConnection();
		InputStreamReader reader = new InputStreamReader(con.getInputStream());
		StringWriter wr = new StringWriter();
		int c;
		StringBuffer token = null;
		for (; (c = reader.read()) != -1;) {
			if (c == '@') {
				if (token == null) {
					token = new StringBuffer();
				} else {
					String val = replacer.replace(token.toString());
					if (val != null) {
						wr.write(val);
						token = null;
					} else {
						wr.write('@');
						wr.write(token.toString());
						token.delete(0, token.length());
					}
				}
			} else {
				if (token == null) {
					wr.write((char) c);
				} else {
					token.append((char) c);
				}
			}
		}
		if (token != null) {
			wr.write('@');
			wr.write(token.toString());
		}
		return wr.toString();
	}

}