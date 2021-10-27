class n4520177 {
	public void fetchKey() throws IOException {
		StringBuffer result = new StringBuffer();
		String strurl = MessageFormat.format(keyurl, new Object[] { username, secret, login, session });
		URL url = null;
		BufferedReader reader = null;
		try {
			url = new URL(strurl);
			String line = null;
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (Exception e) {
			}
		}
		Pattern p = Pattern.compile("<key>(.*)</key>");
		Matcher m = p.matcher(result.toString());
		if (m.matches()) {
			this.key = m.group(1);
		}
	}

}