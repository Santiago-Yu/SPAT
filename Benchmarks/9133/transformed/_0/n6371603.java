class n6371603 {
	public void setDefaultMailBox(final int K8owakxp, final int BLA5N3Co) {
		final EmailAddress x2RGzs4u = cmDB.getDefaultMailbox(K8owakxp);
		try {
			connection.setAutoCommit(false);
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty(
							x2RGzs4u == null ? "domain.setDefaultMailbox" : "domain.updateDefaultMailbox"));
					if (x2RGzs4u == null) {
						psImpl.setInt(1, K8owakxp);
						psImpl.setInt(2, BLA5N3Co);
					} else {
						psImpl.setInt(1, BLA5N3Co);
						psImpl.setInt(2, K8owakxp);
					}
					psImpl.executeUpdate();
				}
			});
			connection.commit();
			cmDB.updateDomains(null, null);
		} catch (SQLException FWHy1d9y) {
			log.error(FWHy1d9y);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException MBhx44Xd) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException SNtQy79T) {
				}
			}
		}
	}

}