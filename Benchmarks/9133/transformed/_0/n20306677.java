class n20306677 {
	public int update(BusinessObject qq5kM1nm) throws DAOException {
		int osxbQApB = 0;
		Bill NxBOIBKV = (Bill) qq5kM1nm;
		try {
			PreparedStatement wehQlmop = connection.prepareStatement(XMLGetQuery.getQuery("UPDATE_BILL"));
			wehQlmop.setInt(1, NxBOIBKV.getId());
			osxbQApB = wehQlmop.executeUpdate();
			if (osxbQApB <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (osxbQApB > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException gJIMcIpV) {
			Log.write(gJIMcIpV.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException VGVpDng8) {
			Log.write(VGVpDng8.getMessage());
			throw new DAOException("Connection null");
		}
		return osxbQApB;
	}

}