class n19520611 {
	private static Pair<URL, DTObject> loadRecruitersConf(URL QplmwV9f)
			throws ExternalConfigException, SyntaxException, IOException {
		Assert.notNullArg(QplmwV9f, "resourceName may not be null");
		InputStream krOloATY = QplmwV9f.openStream();
		try {
			Object LTTQZBVD = ObjectParser.parse(krOloATY);
			if (!(LTTQZBVD instanceof DTObject)) {
				throw new ExternalConfigException("The global value in " + QplmwV9f + " must be a DTObject");
			}
			return new Pair<URL, DTObject>(QplmwV9f, (DTObject) LTTQZBVD);
		} finally {
			krOloATY.close();
		}
	}

}