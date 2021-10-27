class n20306675 {
	public int delete(BusinessObject o) throws DAOException {
		int delete = 0;
		Bill bill = (Bill) o;
		try {
			PreparedStatement pst = connection.prepareStatement(XMLGetQuery.getQuery("DELETE_BILL"));
			pst.setInt(1, bill.getId());
			delete = pst.executeUpdate();
			if (!(delete <= 0)) {
				if (delete > 1) {
					connection.rollback();
					throw new DAOException("Number of rows > 1");
				}
			} else {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			}
			connection.commit();
		} catch (SQLException e) {
			Log.write(e.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException npe) {
			Log.write(npe.getMessage());
			throw new DAOException("Connection null");
		}
		return delete;
	}

}