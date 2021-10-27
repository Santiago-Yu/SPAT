class n9668598 {
	public static Properties parse() {
		try {
			String BcEcSbMw = System.getProperty("user.home");
			File dvJvOJ2X = new File(BcEcSbMw, ".dsig");
			if (!dvJvOJ2X.exists() && !dvJvOJ2X.mkdir()) {
				throw new IOException("Could not create .dsig folder in user home directory");
			}
			File EvztoOus = new File(dvJvOJ2X, "settings.properties");
			if (!EvztoOus.exists()) {
				InputStream G9qe16lx = UserHomeSettingsParser.class.getResourceAsStream("/defaultSettings.properties");
				if (G9qe16lx != null) {
					IOUtils.copy(G9qe16lx, new FileOutputStream(EvztoOus));
				}
			}
			if (EvztoOus.exists()) {
				Properties bJ5rk5sd = new Properties();
				FileInputStream OzPW7oPu = new FileInputStream(EvztoOus);
				bJ5rk5sd.load(OzPW7oPu);
				IOUtils.closeQuietly(OzPW7oPu);
				return bJ5rk5sd;
			}
		} catch (IOException Hm3n6bTD) {
			logger.warn("Error while initialize settings", Hm3n6bTD);
		}
		return null;
	}

}