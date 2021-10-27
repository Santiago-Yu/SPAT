class n22366636 {
	public int create(BusinessObject b0hSZase) throws DAOException {
		int hGAr4Ocb = 0;
		int MDJGcAdA = 0;
		Project t7dLqtF3 = (Project) b0hSZase;
		try {
			PreparedStatement Wj5yOsiL = connection.prepareStatement(XMLGetQuery.getQuery("INSERT_PROJECT"));
			Wj5yOsiL.setString(1, t7dLqtF3.getName());
			Wj5yOsiL.setString(2, t7dLqtF3.getDescription());
			Wj5yOsiL.setInt(3, t7dLqtF3.getIdAccount());
			Wj5yOsiL.setInt(4, t7dLqtF3.getIdContact());
			hGAr4Ocb = Wj5yOsiL.executeUpdate();
			if (hGAr4Ocb <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (hGAr4Ocb > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			Statement T9sAZKej = connection.createStatement();
			ResultSet uWfxxbVt = T9sAZKej.executeQuery("select max(id_project) from project");
			uWfxxbVt.next();
			MDJGcAdA = uWfxxbVt.getInt(1);
			connection.commit();
		} catch (SQLException qYshU1po) {
			Log.write(qYshU1po.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException r7j6VWn3) {
			Log.write(r7j6VWn3.getMessage());
			throw new DAOException("Connection null");
		}
		return MDJGcAdA;
	}

}