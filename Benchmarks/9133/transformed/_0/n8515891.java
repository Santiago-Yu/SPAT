class n8515891 {
	protected String readUrl(String YQZLsQmX) throws IOException {
		URL ilmbv51I = new URL(YQZLsQmX);
		URLConnection u1PzkOqV = ilmbv51I.openConnection();
		if (ilmbv51I.getProtocol().equals("https")) {
			String csBYfoOU = user + ":" + password;
			String ulb7wXHn = new sun.misc.BASE64Encoder().encode(csBYfoOU.getBytes());
			u1PzkOqV.setRequestProperty("Authorization", "Basic " + ulb7wXHn);
		}
		InputStream lH7eVAFA = null;
		String MBJMbl6o = null;
		try {
			lH7eVAFA = u1PzkOqV.getInputStream();
			MBJMbl6o = read(lH7eVAFA);
		} finally {
			try {
				lH7eVAFA.close();
			} catch (Exception nERlnT25) {
			}
		}
		return MBJMbl6o;
	}

}