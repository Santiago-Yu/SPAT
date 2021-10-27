class n19897048 {
	public void insertRight(final String right) throws IOException {
		try {
			boolean autoCommit = false;
			Connection conn = null;
			try {
				conn = pool.getConnection();
				autoCommit = conn.getAutoCommit();
				conn.setAutoCommit(true);
				final PreparedStatement insert = conn.prepareStatement("insert into rights (name) values (?)");
				insert.setString(1, right);
				insert.executeUpdate();
			} catch (Throwable t) {
				throw new SQLException(t.toString());
				if (conn != null)
					conn.rollback();
			} finally {
				if (conn != null) {
					conn.setAutoCommit(autoCommit);
					conn.close();
				}
			}
		} catch (final SQLException sqle) {
			log.log(Level.SEVERE, sqle.toString(), sqle);
			throw new IOException(sqle.toString());
		}
	}

}