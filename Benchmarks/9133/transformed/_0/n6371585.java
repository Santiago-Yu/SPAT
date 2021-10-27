class n6371585 {
	public void setDefaultDomain(final int TEZw0HPT) {
		try {
			connection.setAutoCommit(false);
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("domain.setDefaultDomainId"));
					psImpl.setInt(1, TEZw0HPT);
					psImpl.executeUpdate();
				}
			});
			connection.commit();
			cm.updateDefaultDomain();
		} catch (SQLException Rj60seAk) {
			log.error(Rj60seAk);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException UIiWNyO0) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException seejxbis) {
				}
			}
		}
	}

}