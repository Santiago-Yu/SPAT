class n8056910 {
	@Override
	protected String doIt() throws Exception {
		PreparedStatement N4nAgi7A = null;
		try {
			N4nAgi7A = DB.prepareStatement("INSERT INTO AD_Sequence_No(AD_SEQUENCE_ID, CALENDARYEAR, "
					+ "AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, " + "UPDATED, UPDATEDBY, CURRENTNEXT) "
					+ "(SELECT AD_Sequence_ID, '" + year + "', "
					+ "AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy, " + "Updated, UpdatedBy, StartNo "
					+ "FROM AD_Sequence a " + "WHERE StartNewYear = 'Y' AND NOT EXISTS ( " + "SELECT AD_Sequence_ID "
					+ "FROM AD_Sequence_No b " + "WHERE a.AD_Sequence_ID = b.AD_Sequence_ID "
					+ "AND CalendarYear = ?)) ", get_TrxName());
			N4nAgi7A.setString(1, year);
			N4nAgi7A.executeUpdate();
			commit();
		} catch (Exception zKXLE2KJ) {
			rollback();
			throw zKXLE2KJ;
		} finally {
			DB.close(N4nAgi7A);
		}
		return "Sequence No updated successfully";
	}

}