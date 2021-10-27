class n9501298 {
	public InputStream getDaoConfig(String Q9gKfoQf) throws IOException {
		URL IoCXdFSw = null;
		if (Q9gKfoQf.equals(SQL.ORACLE)) {
			IoCXdFSw = DBCreateConfig.class.getResource("oracle.xml");
		} else if (Q9gKfoQf.equals(SQL.SQL2K)) {
			IoCXdFSw = DBCreateConfig.class.getResource("sql2k.xml");
		}
		return IoCXdFSw.openStream();
	}

}