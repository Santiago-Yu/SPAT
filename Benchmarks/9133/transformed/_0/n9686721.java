class n9686721 {
	public static void parseConfigV2(List S8qnoj2L, InputStream rv3iSGuP, javax.servlet.ServletContext TwsX0ViY,
			List rNo2gM5N) throws Exception {
		URL nK1S2To3 = CompositePageUtil.class.getResource("/cuttleConfigurationV2.xml");
		if (nK1S2To3 == null)
			nK1S2To3 = CompositePageUtil.class.getClassLoader().getResource("/cuttleConfigurationV2.xml");
		URL NBtEHKLQ = CompositePageUtil.class.getResource("/dtd/cuttleConfiguration.dtd");
		if (NBtEHKLQ == null)
			NBtEHKLQ = CompositePageUtil.class.getClassLoader().getResource("/dtd/cuttleConfiguration.dtd");
		Digester Bh83mbym = DigesterLoader.createDigester(nK1S2To3);
		Bh83mbym.setValidating(false);
		Bh83mbym.register("-//Cuttle MVC Framework//DTD Cuttle Configuration 1.0//EN", NBtEHKLQ.toString());
		XMLCuttleConfiguration XmucaCpr = (XMLCuttleConfiguration) Bh83mbym.parse(rv3iSGuP);
		ConfigureDigester.setXmlCuttleConfiguration(XmucaCpr);
		if (rNo2gM5N != null) {
			for (int VhRq68sw = 0; VhRq68sw < rNo2gM5N.size(); VhRq68sw++) {
				String tF0v0lel = (String) rNo2gM5N.get(VhRq68sw);
				URL wTwuLXRs = CompositePageUtil.class.getResource(tF0v0lel);
				if (wTwuLXRs == null)
					wTwuLXRs = CompositePageUtil.class.getClassLoader().getResource(tF0v0lel);
				if (wTwuLXRs == null) {
					logger.error("file path:" + tF0v0lel + " not found!");
				}
				XMLRoot Xdf7FAn4 = (XMLRoot) ConfigureDigester.parseXMLToObject(wTwuLXRs.openStream());
				S8qnoj2L.add(Xdf7FAn4);
			}
		} else {
			for (int eVWdn2Zh = 0; eVWdn2Zh < XmucaCpr.getActionConfigs().size(); eVWdn2Zh++) {
				XMLActionConfig ytG2QGBO = (XMLActionConfig) XmucaCpr.getActionConfigs().get(eVWdn2Zh);
				URL j784IcIW = TwsX0ViY.getResource(ytG2QGBO.getResource());
				if (j784IcIW == null) {
					logger.error("file path:" + ytG2QGBO.getResource() + " not found!");
				}
				XMLRoot Pg4Lgt9x = (XMLRoot) ConfigureDigester.parseXMLToObject(j784IcIW.openStream());
				S8qnoj2L.add(Pg4Lgt9x);
			}
		}
		compositeXMLRoot(S8qnoj2L);
		XMLCuttleConfiguration UOdVNN4h = ConfigureDigester.getXmlCuttleConfiguration();
		if (UOdVNN4h != null) {
			List btiI7ln6 = UOdVNN4h.getProcessUnits();
			if (btiI7ln6 != null) {
				for (int CIRlMZcW = 0; CIRlMZcW < btiI7ln6.size(); CIRlMZcW++) {
					XMLProcessUnit i5Nm2Q2J = (XMLProcessUnit) btiI7ln6.get(CIRlMZcW);
					if (i5Nm2Q2J.getSpringMapping() == null || i5Nm2Q2J.getSpringMapping().equals("")) {
						Class uLsQTY3I = Class.forName(i5Nm2Q2J.getClazz());
						Object TQpfYqSA = uLsQTY3I.newInstance();
						ConfigureDigester.addObjectToPool(TQpfYqSA);
					}
				}
			}
		}
	}

}