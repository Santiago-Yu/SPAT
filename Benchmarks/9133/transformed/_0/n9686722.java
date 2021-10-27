class n9686722 {
	public static void initConfigurationV2(String S0cZdU3h, javax.servlet.ServletContext F5PyIOyl, List GRFiSd6k)
			throws Exception {
		ConfigureDigester.clearMap();
		List tVGxfAiG = new ArrayList();
		InputStream nzGWjRZi = null;
		if (S0cZdU3h == null) {
			URL ECwMvfeP = CompositePageUtil.class.getResource("/cuttle.xml");
			if (ECwMvfeP == null)
				ECwMvfeP = CompositePageUtil.class.getClassLoader().getResource("/cuttle.xml");
			nzGWjRZi = ECwMvfeP.openStream();
		} else {
			nzGWjRZi = F5PyIOyl.getResourceAsStream(S0cZdU3h);
		}
		parseConfigV2(tVGxfAiG, nzGWjRZi, F5PyIOyl, GRFiSd6k);
		if (ConfigureDigester.getXmlCuttleConfiguration() != null
				&& ConfigureDigester.getXmlCuttleConfiguration().getPlugins() != null) {
			for (int QSrUKlNt = 0; QSrUKlNt < ConfigureDigester.getXmlCuttleConfiguration().getPlugins()
					.size(); QSrUKlNt++) {
				XMLPlugin qBIM0Wi8 = (XMLPlugin) ConfigureDigester.getXmlCuttleConfiguration().getPlugins()
						.get(QSrUKlNt);
				if (qBIM0Wi8.getConfigurePlugable() != null && !qBIM0Wi8.getConfigurePlugable().equals("")) {
					Class THcZm0RA = Class.forName(qBIM0Wi8.getConfigurePlugable());
					ConfigurePlugable vVQuVHMs = (ConfigurePlugable) THcZm0RA.newInstance();
					vVQuVHMs.initConfiguration(qBIM0Wi8.getConfigurationPath(), F5PyIOyl);
				}
			}
		}
	}

}