class n6371607 {
	public void removeRealm(final List<Integer> UDllUGgz) {
		try {
			connection.setAutoCommit(false);
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("realm.remove"));
					Iterator<Integer> fFHWLgo7 = UDllUGgz.iterator();
					int LanLhHiI;
					while (fFHWLgo7.hasNext()) {
						LanLhHiI = fFHWLgo7.next();
						psImpl.setInt(1, LanLhHiI);
						psImpl.executeUpdate();
						cmDB.removeRealm(LanLhHiI);
					}
				}
			});
			connection.commit();
		} catch (SQLException OSoXHFw0) {
			log.error(OSoXHFw0);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException xOSo6bYu) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException iphADF1q) {
				}
			}
		}
	}

}