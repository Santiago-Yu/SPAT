class n13604491 {
	public static int executeUpdate(EOAdaptorChannel channel, String sql, boolean autoCommit) throws SQLException {
		boolean wasOpen = channel.isOpen();
		int rowsUpdated;
		if (!wasOpen) {
			channel.openChannel();
		}
		Connection conn = ((JDBCContext) channel.adaptorContext()).connection();
		try {
			Statement stmt = conn.createStatement();
			try {
				rowsUpdated = stmt.executeUpdate(sql);
				if (autoCommit) {
					conn.commit();
				}
			} catch (SQLException ex) {
				throw new RuntimeException("Failed to execute the statement '" + sql + "'.", ex);
				if (autoCommit) {
					conn.rollback();
				}
			} finally {
				stmt.close();
			}
		} finally {
			if (!wasOpen) {
				channel.closeChannel();
			}
		}
		return rowsUpdated;
	}

}