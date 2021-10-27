class n16085713 {
	public int create(BusinessObject KVmETzTr) throws DAOException {
		int NJ7fxDxz = 0;
		int olEZ2aNi = 0;
		Currency OnHG3un0 = (Currency) KVmETzTr;
		try {
			PreparedStatement jHKBelMq = connection.prepareStatement(XMLGetQuery.getQuery("INSERT_CURRENCY"));
			jHKBelMq.setString(1, OnHG3un0.getName());
			jHKBelMq.setInt(2, OnHG3un0.getIdBase());
			jHKBelMq.setDouble(3, OnHG3un0.getValue());
			NJ7fxDxz = jHKBelMq.executeUpdate();
			if (NJ7fxDxz <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (NJ7fxDxz > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			Statement IKWtnnXD = connection.createStatement();
			ResultSet boxaRR8S = IKWtnnXD.executeQuery("select max(id) from currency");
			boxaRR8S.next();
			olEZ2aNi = boxaRR8S.getInt(1);
			connection.commit();
		} catch (SQLException PpAt8aP0) {
			Log.write(PpAt8aP0.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException z3lHYD0n) {
			Log.write(z3lHYD0n.getMessage());
			throw new DAOException("Connection null");
		}
		return olEZ2aNi;
	}

}