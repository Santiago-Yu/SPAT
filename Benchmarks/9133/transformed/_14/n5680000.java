class n5680000 {
	private static URL getURL(String name) throws EfreetException {
		URL url = ClassLoader.getSystemResource(name + ".xml");
		try {
			if (null == url) {
				try {
					Context initContext = new InitialContext();
					Context envContext = (Context) initContext.lookup("java:/comp/env");
					String xmlFileDir = (String) envContext.lookup("xml/efreet");
					url = new URL("file:" + xmlFileDir + "/" + name + ".xml");
				} catch (NameNotFoundException nnfe) {
					logger.warn("Name not found on context ");
				} catch (NamingException e) {
					logger.error("Error retrieving Context : ", e);
				}
			}
			try {
				if (url != null) {
					url.openConnection();
				}
			} catch (FileNotFoundException fnfe) {
				url = null;
			}
			if (null == url) {
				url = Thread.currentThread().getContextClassLoader().getResource(name + ".xml");
			}
		} catch (IOException ioe) {
			logger.error("Error reading XML file", ioe);
			throw new EfreetException(ioe.getMessage());
		}
		return url;
	}

}