class n17638898 {
	public InputStream getDaoConfig(String connectionType) throws IOException {
		URL url = null;
		InputStream inStream = null;
		if (!(connectionType.equals(SQL.ORACLE))) {
			if (connectionType.equals(SQL.SQL2K)) {
				url = com.apelon.selext.db.config.MatchLoadConfig.class.getResource("sql2k.xml");
			} else if (connectionType.equals(SQL.CACHE)) {
				url = com.apelon.selext.db.config.MatchLoadConfig.class.getResource("cache.xml");
			} else if (connectionType.equals(SQL.DB2)) {
				url = com.apelon.selext.db.config.MatchLoadConfig.class.getResource("db2.xml");
			} else {
				Categories.dataXml().error("* Problem: Unknown connection type: " + connectionType);
			}
		} else {
			url = com.apelon.selext.db.config.MatchLoadConfig.class.getResource("oracle.xml");
		}
		try {
			inStream = url.openStream();
		} catch (NullPointerException npe) {
			Categories.dataXml().error("* Problem: Undefined resource URL: " + npe.getMessage());
			throw npe;
		}
		return inStream;
	}

}