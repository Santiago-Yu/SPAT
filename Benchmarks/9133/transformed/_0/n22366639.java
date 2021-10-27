class n22366639 {
	public int update(BusinessObject ZQDZXbot) throws DAOException {
		int NxYOqk9R = 0;
		Project JFQQzvzf = (Project) ZQDZXbot;
		try {
			PreparedStatement zmzIeHYR = connection.prepareStatement(XMLGetQuery.getQuery("UPDATE_PROJECT"));
			zmzIeHYR.setString(1, JFQQzvzf.getName());
			zmzIeHYR.setString(2, JFQQzvzf.getDescription());
			zmzIeHYR.setInt(3, JFQQzvzf.getIdAccount());
			zmzIeHYR.setInt(4, JFQQzvzf.getIdContact());
			zmzIeHYR.setBoolean(5, JFQQzvzf.isArchived());
			zmzIeHYR.setInt(6, JFQQzvzf.getId());
			NxYOqk9R = zmzIeHYR.executeUpdate();
			if (NxYOqk9R <= 0) {
				connection.rollback();
				throw new DAOException("Number of rows <= 0");
			} else if (NxYOqk9R > 1) {
				connection.rollback();
				throw new DAOException("Number of rows > 1");
			}
			connection.commit();
		} catch (SQLException M54iHR1f) {
			Log.write(M54iHR1f.getMessage());
			throw new DAOException("A SQLException has occured");
		} catch (NullPointerException QrcElYhK) {
			Log.write(QrcElYhK.getMessage());
			throw new DAOException("Connection null");
		}
		return NxYOqk9R;
	}

}