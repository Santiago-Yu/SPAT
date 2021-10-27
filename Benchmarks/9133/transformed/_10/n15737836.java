class n15737836 {
	public void delete(Site site) throws Exception {
		Connection connection = null;
		DBOperation dbo = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			dbo = createDBOperation();
			String chkSql = "select id from t_ip_doc where channel_path=?";
			connection = dbo.getConnection();
			connection.setAutoCommit(false);
			String[] selfDefinePath = getSelfDefinePath(site.getPath(), "1", connection, preparedStatement, resultSet);
			selfDefineDelete(selfDefinePath, connection, preparedStatement);
			preparedStatement = connection.prepareStatement(chkSql);
			preparedStatement.setString(1, site.getPath());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				throw new Exception("???????" + site.getName() + "???????????????");
			} else {
				dbo = createDBOperation();
				String sqlStr = "delete from t_ip_site where site_path=?";
				connection = dbo.getConnection();
				preparedStatement = connection.prepareStatement(sqlStr);
				preparedStatement.setString(1, site.getPath());
				preparedStatement.executeUpdate();
			}
			connection.commit();
		} catch (SQLException ex) {
			connection.rollback();
			throw ex;
		} finally {
			close(resultSet, null, preparedStatement, connection, dbo);
		}
	}

}