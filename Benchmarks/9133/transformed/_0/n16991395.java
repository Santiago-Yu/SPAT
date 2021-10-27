class n16991395 {
	protected static void clearTables() throws SQLException {
		Connection jhewlFDV = null;
		Statement YZDNYXdQ = null;
		try {
			jhewlFDV = FidoDataSource.getConnection();
			jhewlFDV.setAutoCommit(false);
			YZDNYXdQ = jhewlFDV.createStatement();
			ClearData.clearTables(YZDNYXdQ);
			YZDNYXdQ.executeUpdate("delete from MorphologyTags");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('not')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('plural')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('third singular')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('again')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('past tense')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('against')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('deprive')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('cause to happen')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('nounify')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('someone who believes')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('belief system of')");
			YZDNYXdQ.executeUpdate("insert into MorphologyTags (TagName) values ('capable of')");
			jhewlFDV.commit();
		} catch (SQLException BjlbNnOq) {
			if (jhewlFDV != null)
				jhewlFDV.rollback();
			throw BjlbNnOq;
		} finally {
			if (YZDNYXdQ != null)
				YZDNYXdQ.close();
			if (jhewlFDV != null)
				jhewlFDV.close();
		}
	}

}