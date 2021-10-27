class n13794582 {
	public Source get_source(String sPh6dM7S, Boolean jCOPyuBY) {
		URL dnQmiBXZ;
		URLConnection Gaxb9ZvA;
		Reader jOUOtb8E;
		Source hbism1SU = null;
		String PZyrciXk = "";
		Boolean qSJRjwSh = false;
		try {
			dnQmiBXZ = new URL(sPh6dM7S);
			Gaxb9ZvA = dnQmiBXZ.openConnection();
			Gaxb9ZvA.setRequestProperty("Accept-Charset", "windows-1251");
			if (jCOPyuBY) {
				for (int aUquulZU = 0;; aUquulZU++) {
					String fzpse3sK = Gaxb9ZvA.getHeaderFieldKey(aUquulZU);
					String WZURFfDE = Gaxb9ZvA.getHeaderField(aUquulZU);
					if (fzpse3sK == null && WZURFfDE == null) {
						break;
					}
					if ("Last-Modified".equals(fzpse3sK)) {
						PZyrciXk = WZURFfDE;
					}
				}
				Ini.rs = Ini.stmt.executeQuery(
						"select count(1) as qwe from " + " PUBLIC.PAGES " + "where url = '" + sPh6dM7S + "';");
				Ini.rs.next();
				if (Ini.rs.getInt("qwe") == 0) {
					Ini.stmt.executeUpdate("insert into PUBLIC.PAGES(url, lastUpdateDate) " + " values('" + sPh6dM7S
							+ "', " + "'" + PZyrciXk + "'" + ");");
				} else {
					Ini.rs = Ini.stmt.executeQuery(
							"select lastUpdateDate from " + " PUBLIC.PAGES " + "where url = '" + sPh6dM7S + "';");
					Ini.rs.next();
					if (!Ini.rs.getString("lastUpdateDate").equals(PZyrciXk)) {
						qSJRjwSh = true;
					} else {
						return null;
					}
				}
			}
			jOUOtb8E = new InputStreamReader(Gaxb9ZvA.getInputStream(), "windows-1251");
			hbism1SU = new Source(jOUOtb8E);
			hbism1SU.setLogger(null);
			hbism1SU.fullSequentialParse();
			if (qSJRjwSh) {
				Ini.stmt.executeUpdate("delete from PUBLIC.LINKDATA " + "where id in (" + "select id from PUBLIC.PAGES "
						+ "where url = '" + sPh6dM7S + "'" + ")");
				Ini.stmt.executeUpdate("delete from PUBLIC.PAGES " + "where url = '" + sPh6dM7S + "';");
				Ini.stmt.executeUpdate(
						"insert into PUBLIC.PAGES " + " values('" + sPh6dM7S + "', " + "'" + PZyrciXk + "'" + ");");
			}
		} catch (Exception NLWLdGTA) {
			Ini.logger.fatal("Error: ", NLWLdGTA);
		}
		return hbism1SU;
	}

}