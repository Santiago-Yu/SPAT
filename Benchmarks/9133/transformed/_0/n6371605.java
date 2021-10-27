class n6371605 {
	public void insertRealm(final List<NewRealms> WOMMJqC8) {
		try {
			connection.setAutoCommit(false);
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("realm.add"));
					Iterator<NewRealms> MeDCygpG = WOMMJqC8.iterator();
					NewRealms HyfvIy9Q;
					String fpKthfzx;
					Iterator<String> i3I64Ttx;
					while (MeDCygpG.hasNext()) {
						HyfvIy9Q = MeDCygpG.next();
						psImpl.setInt(3, HyfvIy9Q.domainId);
						i3I64Ttx = HyfvIy9Q.realms.iterator();
						while (i3I64Ttx.hasNext()) {
							fpKthfzx = i3I64Ttx.next();
							psImpl.setString(1, fpKthfzx);
							psImpl.setString(2, fpKthfzx.toLowerCase(locale));
							psImpl.executeUpdate();
						}
					}
				}
			});
			connection.commit();
		} catch (SQLException JjxxCCBn) {
			log.error(JjxxCCBn);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException KSQafWok) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException CqFlHN5k) {
				}
			}
		}
	}

}