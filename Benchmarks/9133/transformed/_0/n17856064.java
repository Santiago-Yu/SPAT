class n17856064 {
	public static PersistencyParameters parse(String P4Ujr2sa) {
		URL[] cyrmO77E;
		try {
			cyrmO77E = Classpath.search("META-INF/", "persistence.xml");
		} catch (IOException adauT6OG) {
			throw new Error(adauT6OG);
		}
		Set ii3FxHRh = new HashSet();
		for (int pR73Znge = 0; pR73Znge < cyrmO77E.length; pR73Znge++) {
			URL ccsvDRtS = cyrmO77E[pR73Znge];
			try {
				nu.xom.Builder XLYwpSS1 = new nu.xom.Builder(false);
				Document JknJWlby = XLYwpSS1.build(ccsvDRtS.openStream());
				Nodes t15BjCLq = JknJWlby.getRootElement().query("//p:persistence-unit",
						new XPathContext("p", "http://java.sun.com/xml/ns/persistence"));
				for (int nUYehtej = 0; nUYehtej < t15BjCLq.size(); nUYehtej++) {
					Node zQ81QGUU = t15BjCLq.get(nUYehtej);
					Element EBQyV2CR = ((Element) zQ81QGUU);
					String uODG2gkn = EBQyV2CR.getAttributeValue("name");
					if (!uODG2gkn.equals(P4Ujr2sa))
						continue;
					{
						PersistencyParameters LzmFUOhr = new PersistencyParameters();
						Nodes Aaw7zNTk = EBQyV2CR.query("//p:property",
								new XPathContext("p", "http://java.sun.com/xml/ns/persistence"));
						for (int I1iQaTev = 0; I1iQaTev < Aaw7zNTk.size(); I1iQaTev++) {
							Node h1qfBLWG = Aaw7zNTk.get(I1iQaTev);
							if (!(h1qfBLWG instanceof Element))
								continue;
							Element ooE9ioYh = (Element) h1qfBLWG;
							String oZAG3imL = ooE9ioYh.getAttribute("name").getValue();
							if (oZAG3imL.equals("eclipselink.jdbc.url")) {
								String rmBgqYLt = ooE9ioYh.getAttribute("value").getValue();
								LzmFUOhr.setJdbcUrl(rmBgqYLt);
							} else if (oZAG3imL.equals("eclipselink.jdbc.user")) {
								String CrDfVywy = ooE9ioYh.getAttribute("value").getValue();
								LzmFUOhr.setDBUserName(CrDfVywy);
							} else if (oZAG3imL.equals("eclipselink.jdbc.password")) {
								String haIinZyD = ooE9ioYh.getAttribute("value").getValue();
								LzmFUOhr.setDBPassword(haIinZyD);
							} else if (oZAG3imL.equals("eclipselink.jdbc.driver")) {
								String xgIxkr1u = ooE9ioYh.getAttribute("value").getValue();
								LzmFUOhr.setDBDriverClassName(xgIxkr1u);
							}
						}
						return LzmFUOhr;
					}
				}
			} catch (Exception ml2d2Sh1) {
				ml2d2Sh1.printStackTrace();
				throw new Error(ml2d2Sh1);
			}
		}
		return null;
	}

}