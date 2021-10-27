class n6371612 {
	public void removeUserFromRealm(final List<NewUser> lxQBaYl6) {
		try {
			connection.setAutoCommit(false);
			final List<Integer> qmccThTS = (List<Integer>) new ProcessEnvelope()
					.executeObject(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

						@Override
						public Object executeProcessReturnObject() throws SQLException {
							psImpl = connImpl.prepareStatement(sqlCommands.getProperty("realm.removeUser"));
							Iterator<NewUser> d6NFPXHS = lxQBaYl6.iterator();
							NewUser U4Kp6d6W;
							int dcMIUSgS;
							Iterator<Integer> o584jMbz;
							List<Integer> IwodeC4W = new ArrayList<Integer>();
							while (d6NFPXHS.hasNext()) {
								U4Kp6d6W = d6NFPXHS.next();
								psImpl.setInt(1, U4Kp6d6W.userId);
								o584jMbz = U4Kp6d6W.realmIds.iterator();
								while (o584jMbz.hasNext()) {
									dcMIUSgS = o584jMbz.next();
									if (dcMIUSgS == 0) {
										IwodeC4W.add(U4Kp6d6W.userId);
										continue;
									}
									psImpl.setInt(2, dcMIUSgS);
									psImpl.executeUpdate();
								}
								cmDB.removeUser(U4Kp6d6W.userId);
							}
							return IwodeC4W;
						}
					});
			if (!qmccThTS.isEmpty()) {
				new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

					@Override
					public void executeProcessReturnNull() throws SQLException {
						psImpl = connImpl.prepareStatement(sqlCommands.getProperty("realm.removeUserFromNullRealm"));
						Iterator<Integer> ZLOLQyqF = qmccThTS.iterator();
						while (ZLOLQyqF.hasNext()) {
							psImpl.setInt(1, ZLOLQyqF.next());
							psImpl.executeUpdate();
						}
					}
				});
			}
			connection.commit();
		} catch (SQLException bIk4kbE1) {
			log.error(bIk4kbE1);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException uKpj62E1) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException udWg5STX) {
				}
			}
		}
	}

}