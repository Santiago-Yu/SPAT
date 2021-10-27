class n2168610 {
	public int update(BusinessObject XQ3EcCpY) throws DAOException {
		int x3i4REbb = 0;
		Contact EBgDJYFB = (Contact) XQ3EcCpY;
		try {
			PreparedStatement Y7yOyuAb = connection.prepareStatement(XMLGetQuery.getQuery("UPDATE_CONTACT"));
			Y7yOyuAb.setString(1, EBgDJYFB.getName());
			Y7yOyuAb.setString(2, EBgDJYFB.getFirstname());
			Y7yOyuAb.setString(3, EBgDJYFB.getPhone());
			Y7yOyuAb.setString(4, EBgDJYFB.getEmail());
			if (EBgDJYFB.getAccount() == 0) {
				Y7yOyuAb.setNull(5, java.sql.Types.INTEGER);
			} else {
				Y7yOyuAb.setInt(5, EBgDJYFB.getAccount());
			}
			Y7yOyuAb.setBoolean(6, EBgDJYFB.isArchived());
			Y7yOyuAb.setInt(7, EBgDJYFB.getId());
			x3i4REbb = Y7yOyuAb.executeUpdate();
			if (x3i4REbb <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (x3i4REbb > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException AHGd8Xbx) {
			Log.write(AHGd8Xbx.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException hJM4buyW) {
			Log.write(hJM4buyW.getMessage());
			throw new DAOException("Connection null");
		}
		return x3i4REbb;
	}

}