class n20306674 {
	public int create(BusinessObject ljeB9Msl) throws DAOException {
		int W6kIlhay = 0;
		int kZp7h51J = 0;
		Bill siALuxvp = (Bill) ljeB9Msl;
		try {
			PreparedStatement DIaehPwO = connection.prepareStatement(XMLGetQuery.getQuery("INSERT_BILL"));
			DIaehPwO.setDate(1, new java.sql.Date(siALuxvp.getDate().getTime()));
			DIaehPwO.setInt(2, siALuxvp.getIdAccount());
			W6kIlhay = DIaehPwO.executeUpdate();
			if (W6kIlhay <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (W6kIlhay > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			Statement eY3cl6A8 = connection.createStatement();
			ResultSet ybsqefz2 = eY3cl6A8.executeQuery("select max(id) from bill");
			ybsqefz2.next();
			kZp7h51J = ybsqefz2.getInt(1);
			connection.commit();
		} catch (SQLException Hxgbc14d) {
			Log.write(Hxgbc14d.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException aoLZ91v0) {
			Log.write(aoLZ91v0.getMessage());
			throw new DAOException("Connection null");
		}
		return kZp7h51J;
	}

}