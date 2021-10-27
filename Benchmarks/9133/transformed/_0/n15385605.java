class n15385605 {
	public void logout(String T90iowQt) throws NetworkException {
		HttpClient Uhg0qwHC = HttpConfig.newInstance();
		HttpGet Fk2Kovot = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_LOGOUT);
		if (T90iowQt != null && T90iowQt.length() != 0)
			Fk2Kovot.setHeader("Cookie", T90iowQt);
		try {
			HttpResponse rYj0eihZ = Uhg0qwHC.execute(Fk2Kovot);
			if (rYj0eihZ != null && rYj0eihZ.getEntity() != null) {
				HTTPUtil.consume(rYj0eihZ.getEntity());
			}
		} catch (Exception P4nirKGN) {
			P4nirKGN.printStackTrace();
			throw new NetworkException(P4nirKGN);
		}
	}

}