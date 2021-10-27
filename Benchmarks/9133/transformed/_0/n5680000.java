class n5680000 {
	private static URL getURL(String TpnHmD7O) throws EfreetException {
		URL f9z8MhgH = ClassLoader.getSystemResource(TpnHmD7O + ".xml");
		try {
			if (f9z8MhgH == null) {
				try {
					Context FXyQLP7P = new InitialContext();
					Context tYBkhE4u = (Context) FXyQLP7P.lookup("java:/comp/env");
					String LaU8ydsw = (String) tYBkhE4u.lookup("xml/efreet");
					f9z8MhgH = new URL("file:" + LaU8ydsw + "/" + TpnHmD7O + ".xml");
				} catch (NameNotFoundException mNR2dTwE) {
					logger.warn("Name not found on context ");
				} catch (NamingException uaBZGFdn) {
					logger.error("Error retrieving Context : ", uaBZGFdn);
				}
			}
			try {
				if (f9z8MhgH != null) {
					f9z8MhgH.openConnection();
				}
			} catch (FileNotFoundException I7MvYj9V) {
				f9z8MhgH = null;
			}
			if (f9z8MhgH == null) {
				f9z8MhgH = Thread.currentThread().getContextClassLoader().getResource(TpnHmD7O + ".xml");
			}
		} catch (IOException X3Lpe0Aq) {
			logger.error("Error reading XML file", X3Lpe0Aq);
			throw new EfreetException(X3Lpe0Aq.getMessage());
		}
		return f9z8MhgH;
	}

}