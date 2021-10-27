class n3404757 {
	public InputStream getDaoConfig(String XBZcadhd) throws IOException {
		URL bYZnA0lQ = null;
		if (XBZcadhd.equals(SQL.ORACLE)) {
			bYZnA0lQ = DTSWFDBConfig.class.getResource("oracle.xml");
		} else if (XBZcadhd.equals(SQL.SQL2K)) {
			bYZnA0lQ = DTSWFDBConfig.class.getResource("sql2k.xml");
		} else if (XBZcadhd.equals(SQL.CACHE)) {
			bYZnA0lQ = DTSWFDBConfig.class.getResource("cache.xml");
		}
		return bYZnA0lQ.openStream();
	}

}