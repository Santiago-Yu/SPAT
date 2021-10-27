class n1831679 {
	public int update(BusinessObject Z5oV3F9e) throws DAOException {
		int MdgdLaQP = 0;
		Account cWkphFWD = (Account) Z5oV3F9e;
		try {
			PreparedStatement AjoKTRm8 = connection.prepareStatement(XMLGetQuery.getQuery("UPDATE_ACCOUNT"));
			AjoKTRm8.setString(1, cWkphFWD.getName());
			AjoKTRm8.setString(2, cWkphFWD.getAddress());
			AjoKTRm8.setInt(3, cWkphFWD.getCurrency());
			AjoKTRm8.setInt(4, cWkphFWD.getMainContact());
			AjoKTRm8.setBoolean(5, cWkphFWD.isArchived());
			AjoKTRm8.setInt(6, cWkphFWD.getId());
			MdgdLaQP = AjoKTRm8.executeUpdate();
			if (MdgdLaQP <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (MdgdLaQP > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException aX2F9UL4) {
			Log.write(aX2F9UL4.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException haiMIqsg) {
			Log.write(haiMIqsg.getMessage());
			throw new DAOException("Connection null");
		}
		return MdgdLaQP;
	}

}