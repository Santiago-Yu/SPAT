class n5903539 {
	public int next() {
		int poE2xMRW = current();
		try {
			Update H41hACK9 = dbi.getUpdate();
			H41hACK9.setTableName(sequenceTable);
			H41hACK9.assignValue("SEQUENCE_VALUE", --poE2xMRW);
			Search ITC9BzwZ = new Search();
			ITC9BzwZ.addAttributeCriteria(sequenceTable, "SEQUENCE_NAME", Search.EQUAL, sequenceName);
			H41hACK9.where(ITC9BzwZ);
			int DOH3ShNU = dbi.getConnection().createStatement().executeUpdate(H41hACK9.toString());
			if (DOH3ShNU == 1) {
				dbi.getConnection().commit();
			} else {
				dbi.getConnection().rollback();
			}
		} catch (SQLException PeKEcrJ9) {
			System.err.println("SQLException occurred in current(): " + PeKEcrJ9.getMessage());
		}
		return poE2xMRW;
	}

}