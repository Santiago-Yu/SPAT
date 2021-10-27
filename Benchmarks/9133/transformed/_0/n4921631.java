class n4921631 {
	public int create(BusinessObject nMOtuIIE) throws DAOException {
		int RPzSJoJq = 0;
		int gFCrAS7C = 0;
		Item REMa3yyK = (Item) nMOtuIIE;
		try {
			PreparedStatement gPBMwy0T = connection.prepareStatement(XMLGetQuery.getQuery("INSERT_ITEM"));
			gPBMwy0T.setString(1, REMa3yyK.getDescription());
			gPBMwy0T.setDouble(2, REMa3yyK.getUnit_price());
			gPBMwy0T.setInt(3, REMa3yyK.getQuantity());
			gPBMwy0T.setDouble(4, REMa3yyK.getVat());
			gPBMwy0T.setInt(5, REMa3yyK.getIdProject());
			gPBMwy0T.setInt(6, REMa3yyK.getIdCurrency());
			RPzSJoJq = gPBMwy0T.executeUpdate();
			if (RPzSJoJq <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (RPzSJoJq > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			Statement bcdnkYZk = connection.createStatement();
			ResultSet pOP1Erd3 = bcdnkYZk.executeQuery("select max(id_item) from item");
			pOP1Erd3.next();
			gFCrAS7C = pOP1Erd3.getInt(1);
			connection.commit();
		} catch (SQLException bY0cQp95) {
			Log.write(bY0cQp95.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException Z67ubGTj) {
			Log.write(Z67ubGTj.getMessage());
			throw new DAOException("Connection null");
		}
		return gFCrAS7C;
	}

}