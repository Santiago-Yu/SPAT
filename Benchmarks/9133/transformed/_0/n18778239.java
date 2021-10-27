class n18778239 {
	public void init() {
		File[] qPYj0vT8 = { XPontusConstantsIF.XPONTUS_PLUGINS_DATA_DIR, XPontusConstantsIF.XPONTUS_PREFERENCES_DIR,
				XPontusConstantsIF.XPONTUS_DATABASE_CONFIG_DIR, XPontusConstantsIF.XPONTUS_PLUGINS_DIR,
				XPontusConstantsIF.XPONTUS_CACHE_DIR };
		for (int uvYAjDmu = 0; uvYAjDmu < qPYj0vT8.length; uvYAjDmu++) {
			if (!qPYj0vT8[uvYAjDmu].exists()) {
				qPYj0vT8[uvYAjDmu].mkdirs();
			}
		}
		String[] qLpPVWZ2 = { "/net/sf/xpontus/configuration/editorPanel.properties",
				"/net/sf/xpontus/configuration/general.properties",
				"/net/sf/xpontus/configuration/mimetypes.properties" };
		try {
			for (String JZ2roPqc : qLpPVWZ2) {
				String m5kgWBsG = FilenameUtils.getName(JZ2roPqc);
				File sJRrX6YM = new File(XPontusConstantsIF.XPONTUS_PREFERENCES_DIR, m5kgWBsG);
				if (!sJRrX6YM.exists()) {
					if (JZ2roPqc.equals(qLpPVWZ2[0])) {
						Properties q53X9WTM = new Properties();
						InputStream iwzimxTL = getClass().getResourceAsStream(JZ2roPqc);
						q53X9WTM.load(iwzimxTL);
						Font vnvgB2tG = UIManager.getFont("EditorPane.font");
						StrBuilder mmHJckc0 = new StrBuilder();
						mmHJckc0.append(vnvgB2tG.getFamily() + "," + vnvgB2tG.getStyle() + "," + vnvgB2tG.getSize());
						q53X9WTM.put("EditorPane.Font", mmHJckc0.toString());
						OutputStream twdLN0Nl = new FileOutputStream(sJRrX6YM);
						q53X9WTM.store(twdLN0Nl, null);
						twdLN0Nl.close();
						iwzimxTL.close();
					} else {
						InputStream sFKT9ogB = getClass().getResourceAsStream(JZ2roPqc);
						OutputStream ht1z6tUd = new FileOutputStream(sJRrX6YM);
						IOUtils.copy(sFKT9ogB, ht1z6tUd);
						ht1z6tUd.close();
						sFKT9ogB.close();
					}
				}
				if (!m5kgWBsG.equals("mimetypes.properties")) {
					Properties mrXN1Tup = PropertiesConfigurationLoader.load(sJRrX6YM);
					Iterator UoMtTL2r = mrXN1Tup.keySet().iterator();
					while (UoMtTL2r.hasNext()) {
						Object EIwlcNbV = UoMtTL2r.next();
						Object jz3j0IkU = mrXN1Tup.get(EIwlcNbV);
						XPontusConfig.put(EIwlcNbV, jz3j0IkU);
					}
				}
			}
		} catch (Exception Hjq8Qxx3) {
			Hjq8Qxx3.printStackTrace();
		}
		Properties x6M1xovR = PropertiesConfigurationLoader
				.load(XPontusConfigurationConstantsIF.EDITOR_PREFERENCES_FILE);
		String[] L8Blu3jO = x6M1xovR.get("EditorPane.Font").toString().split(",");
		String VJ6vRw5m = L8Blu3jO[0].trim();
		String GAkvncfh = L8Blu3jO[1].trim();
		int zW0w9yc9 = Integer.parseInt(GAkvncfh);
		int VOwzAusF = Integer.parseInt(L8Blu3jO[2].trim());
		Font wImnkLrr = new Font(VJ6vRw5m, zW0w9yc9, VOwzAusF);
		XPontusConfig.put("EditorPane.Font", wImnkLrr);
		Map Sf6lnz1O = new HashMap();
		Sf6lnz1O.put(ROLE, this);
		PropertiesHolder.registerProperty(XPontusSettings.KEY, Sf6lnz1O);
		DockableContainerFactory.setFactory(new XPontusDockableContainerFactory());
		FileHistoryList.init();
		initDefaultSettings();
	}

}