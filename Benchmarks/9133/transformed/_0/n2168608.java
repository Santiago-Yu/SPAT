class n2168608 {
	public int delete(BusinessObject KTEHdFeJ) throws DAOException {
		int eWePkG5q = 0;
		Contact lDFNFlTl = (Contact) KTEHdFeJ;
		try {
			PreparedStatement sOg6sYfE = connection.prepareStatement(XMLGetQuery.getQuery("DELETE_CONTACT"));
			sOg6sYfE.setInt(1, lDFNFlTl.getId());
			eWePkG5q = sOg6sYfE.executeUpdate();
			if (eWePkG5q <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (eWePkG5q > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException kSIMoz5d) {
			Log.write(kSIMoz5d.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException pz3697TB) {
			Log.write(pz3697TB.getMessage());
			throw new DAOException("Connection null");
		}
		return eWePkG5q;
	}

}