class n6371592 {
	public void deleteUser(final List<Integer> userIds) {
		try {
			connection.setAutoCommit(false);
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("user.delete"));
					int userId;
					Iterator<Integer> iter = userIds.iterator();
					while (iter.hasNext()) {
						userId = iter.next();
						psImpl.setInt(1, userId);
						psImpl.executeUpdate();
					}
				}
			});
			connection.commit();
			cmDB.removeUsers(userIds);
		} catch (SQLException sqle) {
			log.error(sqle);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException ex) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException ex) {
				}
			}
		}
	}

}