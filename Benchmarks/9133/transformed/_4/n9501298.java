class n9501298 {
	public InputStream getDaoConfig(String connectionType) throws IOException {
		URL url = null;
		if (connectionType.equals(SQL.ORACLE)) {
			url = DBCreateConfig.class.getResource("oracle.xml");
		} else
			url = (connectionType.equals(SQL.SQL2K)) ? DBCreateConfig.class.getResource("sql2k.xml") : url;
		return url.openStream();
	}

}