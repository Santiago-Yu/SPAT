class n18317329 {
	private void delete(Connection conn, int itemId) throws SQLException {
		Statement statement = null;
		try {
			conn.setAutoCommit(false);
			deleteComponents(conn, itemId);
			StringBuffer sqlBuff = new StringBuffer("DELETE FROM ");
			statement = conn.createStatement();
			sqlBuff.append(m_dbItemName);
			sqlBuff.append(" WHERE ");
			sqlBuff.append(m_dbItemIdFieldColName);
			sqlBuff.append(" = ");
			sqlBuff.append(Integer.toString(itemId));
			String sql = sqlBuff.toString();
			statement.executeUpdate(sql);
			conn.commit();
		} catch (SQLException ex) {
			throw ex;
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}

}