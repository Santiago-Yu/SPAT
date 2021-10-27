class n18374479 {
	public void removeUser(final User user) throws IOException {
		try {
			boolean autoCommit = false;
			Connection conn = null;
			try {
				conn = pool.getConnection();
				autoCommit = conn.getAutoCommit();
				conn.setAutoCommit(false);
				final PreparedStatement removeUser = conn.prepareStatement("delete from users  where userId = ?");
				removeUser.setString(1, user.getUserId());
				removeUser.executeUpdate();
				final PreparedStatement deleteRoles = conn.prepareStatement("delete from userRoles where userId=?");
				deleteRoles.setString(1, user.getUserId());
				deleteRoles.executeUpdate();
				conn.commit();
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