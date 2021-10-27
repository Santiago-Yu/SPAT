class n20306675 {
	public int delete(BusinessObject VOCkGgck) throws DAOException {
		int XHahpNdx = 0;
		Bill rn1kbdNw = (Bill) VOCkGgck;
		try {
			PreparedStatement p1LhGau0 = connection.prepareStatement(XMLGetQuery.getQuery("DELETE_BILL"));
			p1LhGau0.setInt(1, rn1kbdNw.getId());
			XHahpNdx = p1LhGau0.executeUpdate();
			if (XHahpNdx <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (XHahpNdx > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException hbwcwP0s) {
			Log.write(hbwcwP0s.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException gjRagopR) {
			Log.write(gjRagopR.getMessage());
			throw new DAOException("Connection null");
		}
		return XHahpNdx;
	}

}