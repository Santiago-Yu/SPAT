class n1831677 {
	public int delete(BusinessObject iHvn2JoP) throws DAOException {
		int OQgaTtzA = 0;
		Account wapcgIFn = (Account) iHvn2JoP;
		try {
			PreparedStatement xzXTo40i = connection.prepareStatement(XMLGetQuery.getQuery("DELETE_ACCOUNT"));
			xzXTo40i.setInt(1, wapcgIFn.getId());
			OQgaTtzA = xzXTo40i.executeUpdate();
			if (OQgaTtzA <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (OQgaTtzA > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException uHrJ7ILf) {
			Log.write(uHrJ7ILf.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException kBZzFTUj) {
			Log.write(kBZzFTUj.getMessage());
			throw new DAOException("Connection null");
		}
		return OQgaTtzA;
	}

}