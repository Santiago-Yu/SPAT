class n18374478 {
	public void updateUser(final User user) throws IOException {
		try {
			boolean autoCommit = false;
			Connection conn = null;
			try {
				conn = pool.getConnection();
				autoCommit = conn.getAutoCommit();
				conn.setAutoCommit(false);
				final PreparedStatement updateUser = conn
						.prepareStatement("update users set mainRoleId=? where userId=?");
				updateUser.setInt(1, user.getMainRole().getId());
				updateUser.setString(2, user.getUserId());
				updateUser.executeUpdate();
				final PreparedStatement deleteRoles = conn.prepareStatement("delete from userRoles where userId=?");
				deleteRoles.setString(1, user.getUserId());
				deleteRoles.executeUpdate();
				final PreparedStatement insertRoles = conn
						.prepareStatement("insert into userRoles (userId, roleId) values (?,?)");
				for (final Role role : user.getRoles()) {
					insertRoles.setString(1, user.getUserId());
					insertRoles.setInt(2, role.getId());
					insertRoles.executeUpdate();
				}
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