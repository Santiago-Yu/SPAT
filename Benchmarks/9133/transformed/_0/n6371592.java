class n6371592 {
	public void deleteUser(final List<Integer> EBSz8pdG) {
		try {
			connection.setAutoCommit(false);
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("user.delete"));
					Iterator<Integer> mKa1VbXh = EBSz8pdG.iterator();
					int tEhz0TiT;
					while (mKa1VbXh.hasNext()) {
						tEhz0TiT = mKa1VbXh.next();
						psImpl.setInt(1, tEhz0TiT);
						psImpl.executeUpdate();
					}
				}
			});
			connection.commit();
			cmDB.removeUsers(EBSz8pdG);
		} catch (SQLException Md2UIjXK) {
			log.error(Md2UIjXK);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException qM79pEoJ) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException xPkg9qeF) {
				}
			}
		}
	}

}