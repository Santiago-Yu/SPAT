class n22366637 {
	public int delete(BusinessObject EwWnR1oR) throws DAOException {
		int kZv6Bdu1 = 0;
		Project W8AMgCac = (Project) EwWnR1oR;
		try {
			PreparedStatement qUBJeWnN = connection.prepareStatement(XMLGetQuery.getQuery("DELETE_PROJECT"));
			qUBJeWnN.setInt(1, W8AMgCac.getId());
			kZv6Bdu1 = qUBJeWnN.executeUpdate();
			if (kZv6Bdu1 <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (kZv6Bdu1 > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException M1t4PYdV) {
			Log.write(M1t4PYdV.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException mKTLmTie) {
			Log.write(mKTLmTie.getMessage());
			throw new DAOException("Connection null");
		}
		return kZv6Bdu1;
	}

}