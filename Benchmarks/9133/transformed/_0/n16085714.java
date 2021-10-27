class n16085714 {
	public int delete(BusinessObject hxaZCoBQ) throws DAOException {
		int cLQdS3Gz = 0;
		Currency M4VRdUTq = (Currency) hxaZCoBQ;
		try {
			PreparedStatement QeHUQSZJ = connection.prepareStatement(XMLGetQuery.getQuery("DELETE_CURRENCY"));
			QeHUQSZJ.setInt(1, M4VRdUTq.getId());
			cLQdS3Gz = QeHUQSZJ.executeUpdate();
			if (cLQdS3Gz <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (cLQdS3Gz > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException bgBi5Usp) {
			Log.write(bgBi5Usp.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException EqWextmQ) {
			Log.write(EqWextmQ.getMessage());
			throw new DAOException("Connection null");
		}
		return cLQdS3Gz;
	}

}