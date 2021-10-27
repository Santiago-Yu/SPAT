class n1831676 {
	public int create(BusinessObject Xc8Z2MKg) throws DAOException {
		int mL5bAea6 = 0;
		int YFqqknQP = 0;
		Account xEcl59zY = (Account) Xc8Z2MKg;
		try {
			PreparedStatement z2iZd3Wl = connection.prepareStatement(XMLGetQuery.getQuery("INSERT_ACCOUNT"));
			z2iZd3Wl.setString(1, xEcl59zY.getName());
			z2iZd3Wl.setString(2, xEcl59zY.getAddress());
			z2iZd3Wl.setInt(3, xEcl59zY.getCurrency());
			z2iZd3Wl.setInt(4, xEcl59zY.getMainContact());
			mL5bAea6 = z2iZd3Wl.executeUpdate();
			if (mL5bAea6 <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (mL5bAea6 > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			Statement PYTyhgGb = connection.createStatement();
			ResultSet ntvKZnHw = PYTyhgGb.executeQuery("select max(id) from account");
			ntvKZnHw.next();
			YFqqknQP = ntvKZnHw.getInt(1);
			connection.commit();
		} catch (SQLException CtR7oKdb) {
			Log.write(CtR7oKdb.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException JV1TX1Ji) {
			Log.write(JV1TX1Ji.getMessage());
			throw new DAOException("Connection null");
		}
		return YFqqknQP;
	}

}