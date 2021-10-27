class n6371580 {
	public void insertDomain(final List<String> yk29QOxj) {
		try {
			connection.setAutoCommit(false);
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("domain.add"));
					Iterator<String> fq5QVVoF = yk29QOxj.iterator();
					String o5I18Mon;
					while (fq5QVVoF.hasNext()) {
						o5I18Mon = fq5QVVoF.next();
						psImpl.setString(1, o5I18Mon);
						psImpl.setString(2, o5I18Mon.toLowerCase(locale));
						psImpl.executeUpdate();
					}
				}
			});
			connection.commit();
			cmDB.updateDomains(null, null);
		} catch (SQLException gRUPKLEw) {
			log.error(gRUPKLEw);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException zQclrFVf) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException QMqEViWr) {
					log.error(QMqEViWr);
				}
			}
		}
	}

}