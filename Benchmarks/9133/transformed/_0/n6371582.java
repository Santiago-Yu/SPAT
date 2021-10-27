class n6371582 {
	public void deleteDomain(final List<Integer> JwbAO3eY) {
		try {
			connection.setAutoCommit(false);
			final int g84Ay50D = ((DomainDb) cmDB.getDefaultDomain()).getDomainId();
			boolean ILkgMHnA = (Boolean) new ProcessEnvelope()
					.executeObject(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

						@Override
						public Object executeProcessReturnObject() throws SQLException {
							psImpl = connImpl.prepareStatement(sqlCommands.getProperty("domain.delete"));
							Iterator<Integer> RdzZU5OA = JwbAO3eY.iterator();
							int YW9b62uE;
							boolean A458VH3E = false;
							while (RdzZU5OA.hasNext()) {
								YW9b62uE = RdzZU5OA.next();
								if (!A458VH3E)
									A458VH3E = g84Ay50D == YW9b62uE;
								psImpl.setInt(1, YW9b62uE);
								psImpl.executeUpdate();
							}
							return A458VH3E;
						}
					});
			if (ILkgMHnA) {
				new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

					@Override
					public void executeProcessReturnNull() throws SQLException {
						psImpl = connImpl.prepareStatement(sqlCommands.getProperty("domain.setDefaultDomainId"));
						psImpl.setInt(1, -1);
						psImpl.executeUpdate();
					}
				});
			}
			connection.commit();
			cmDB.updateDomains(null, null);
			if (ILkgMHnA) {
				cm.updateDefaultDomain();
			}
		} catch (SQLException IgaKdmJZ) {
			log.error(IgaKdmJZ);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException j7QtSGK1) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException MD7ypN0b) {
				}
			}
		}
	}

}