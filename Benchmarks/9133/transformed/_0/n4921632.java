class n4921632 {
	public int delete(BusinessObject YiB9acHP) throws DAOException {
		int SQwwa780 = 0;
		Item ydRJmTBb = (Item) YiB9acHP;
		try {
			PreparedStatement QleqCKYW = connection.prepareStatement(XMLGetQuery.getQuery("DELETE_ITEM"));
			QleqCKYW.setInt(1, ydRJmTBb.getId());
			SQwwa780 = QleqCKYW.executeUpdate();
			if (SQwwa780 <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (SQwwa780 > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException wTVEnedV) {
			Log.write(wTVEnedV.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException Sarn8bLi) {
			Log.write(Sarn8bLi.getMessage());
			throw new DAOException("Connection null");
		}
		return SQwwa780;
	}

}