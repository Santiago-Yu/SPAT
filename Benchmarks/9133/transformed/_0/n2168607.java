class n2168607 {
	public int create(BusinessObject WBuJeVTZ) throws DAOException {
		int sWf3yU6o = 0;
		int Fa8jNvDg = 0;
		Contact MHGPl9Qd = (Contact) WBuJeVTZ;
		try {
			PreparedStatement SUwi2edu = connection.prepareStatement(XMLGetQuery.getQuery("INSERT_CONTACT"));
			SUwi2edu.setString(1, MHGPl9Qd.getName());
			SUwi2edu.setString(2, MHGPl9Qd.getFirstname());
			SUwi2edu.setString(3, MHGPl9Qd.getPhone());
			SUwi2edu.setString(4, MHGPl9Qd.getEmail());
			if (MHGPl9Qd.getAccount() == 0) {
				SUwi2edu.setNull(5, java.sql.Types.INTEGER);
			} else {
				SUwi2edu.setInt(5, MHGPl9Qd.getAccount());
			}
			sWf3yU6o = SUwi2edu.executeUpdate();
			if (sWf3yU6o <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (sWf3yU6o > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			Statement bxOiGsmw = connection.createStatement();
			ResultSet S1oWp8jO = bxOiGsmw.executeQuery("select max(id) from contact");
			S1oWp8jO.next();
			Fa8jNvDg = S1oWp8jO.getInt(1);
			connection.commit();
		} catch (SQLException sXWNssv1) {
			Log.write(sXWNssv1.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException MBXSR5X3) {
			Log.write(MBXSR5X3.getMessage());
			throw new DAOException("Connection null");
		}
		return Fa8jNvDg;
	}

}