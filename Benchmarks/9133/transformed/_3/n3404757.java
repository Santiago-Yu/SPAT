class n3404757 {
	public InputStream getDaoConfig(String connectionType) throws IOException {
		URL url = null;
		if (!(connectionType.equals(SQL.ORACLE))) {
			if (connectionType.equals(SQL.SQL2K)) {
				url = DTSWFDBConfig.class.getResource("sql2k.xml");
			} else if (connectionType.equals(SQL.CACHE)) {
				url = DTSWFDBConfig.class.getResource("cache.xml");
			}
		} else {
			url = DTSWFDBConfig.class.getResource("oracle.xml");
		}
		return url.openStream();
	}

}