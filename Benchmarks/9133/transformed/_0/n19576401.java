class n19576401 {
	public static final int executeSql(final Connection ZAPfhkiH, final String SkZzxM1s, final boolean DScVyn1L)
			throws SQLException {
		if (null == SkZzxM1s)
			return 0;
		Statement rT2RN1Q9 = null;
		try {
			rT2RN1Q9 = ZAPfhkiH.createStatement();
			final int nRpOI1dX = rT2RN1Q9.executeUpdate(SkZzxM1s);
			return nRpOI1dX;
		} catch (final SQLException GR57A8Bo) {
			if (DScVyn1L)
				ZAPfhkiH.rollback();
			throw GR57A8Bo;
		} finally {
			closeAll(null, rT2RN1Q9, null);
		}
	}

}