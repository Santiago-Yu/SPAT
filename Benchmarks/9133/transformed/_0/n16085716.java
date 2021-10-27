class n16085716 {
	public int update(BusinessObject Q881E23S) throws DAOException {
		int vOGTt4VD = 0;
		Currency aMtWiRkU = (Currency) Q881E23S;
		try {
			PreparedStatement JsfrHkuM = connection.prepareStatement(XMLGetQuery.getQuery("UPDATE_CURRENCY"));
			JsfrHkuM.setString(1, aMtWiRkU.getName());
			JsfrHkuM.setInt(2, aMtWiRkU.getIdBase());
			JsfrHkuM.setDouble(3, aMtWiRkU.getValue());
			JsfrHkuM.setInt(4, aMtWiRkU.getId());
			vOGTt4VD = JsfrHkuM.executeUpdate();
			if (vOGTt4VD <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (vOGTt4VD > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException R6ljrqys) {
			Log.write(R6ljrqys.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException TNbcj4zj) {
			Log.write(TNbcj4zj.getMessage());
			throw new DAOException("Connection null");
		}
		return vOGTt4VD;
	}

}