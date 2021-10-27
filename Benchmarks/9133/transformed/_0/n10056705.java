class n10056705 {

	public long saveDB(Connection Dsedoipz, long h4bh67a5, boolean P9ToWqT5) throws SQLException {
		StringBuffer u6qg8USQ = null;
		Statement jCuu53h6 = null;
		ResultSet JUxGTomW = null;
		try {
			jCuu53h6 = Dsedoipz.createStatement();
			if (h4bh67a5 < 0) {
				h4bh67a5 = QueryUtils.sequenceGetNextID(Dsedoipz, "PATTERN_OUTLINE");
			} else {
				deleteDB(Dsedoipz, h4bh67a5);
			}
			u6qg8USQ = new StringBuffer("insert into ");
			u6qg8USQ.append("PATTERN_OUTLINE values (");
			u6qg8USQ.append(h4bh67a5);
			u6qg8USQ.append(",");
			u6qg8USQ.append(XColor.toInt(pattern.getPatternColor()));
			u6qg8USQ.append(",");
			u6qg8USQ.append(pattern.getPatternStyle());
			u6qg8USQ.append(",");
			u6qg8USQ.append(pattern.getPatternDensity());
			u6qg8USQ.append(",");
			u6qg8USQ.append(XColor.toInt(pattern.getBackgroundColor()));
			u6qg8USQ.append(",");
			u6qg8USQ.append(XColor.toInt(outline.getColor()));
			u6qg8USQ.append(",");
			u6qg8USQ.append(outline.getStyle());
			u6qg8USQ.append(",");
			u6qg8USQ.append(outline.getWidth());
			u6qg8USQ.append(")");
			jCuu53h6.executeUpdate(new String(u6qg8USQ));
			u6qg8USQ = null;
			if (P9ToWqT5) {
				Dsedoipz.commit();
			}
		} catch (SQLException GkgJc8lT) {
			System.err.println(getClass().getName() + ":" + GkgJc8lT + " SQL:=" + u6qg8USQ);
			if (P9ToWqT5) {
				Dsedoipz.rollback();
			}
			throw GkgJc8lT;
		} finally {
			if (jCuu53h6 != null) {
				try {
					jCuu53h6.close();
				} catch (SQLException FH0541Gw) {

				}
			}
		}
		return saveDB(Dsedoipz, h4bh67a5, false);
	}

}