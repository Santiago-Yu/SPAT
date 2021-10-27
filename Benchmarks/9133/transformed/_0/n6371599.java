class n6371599 {
	public void addForwardAddress(final List<NewUser> W8Te7Su7) {
		try {
			final List<Integer> nvoioGAI = new ArrayList<Integer>();
			connection.setAutoCommit(false);
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("userForwardAddresses.add"));
					Iterator<NewUser> RMLgLBhi = W8Te7Su7.iterator();
					Iterator<String> UUIzsxKX;
					NewUser DnBszzth;
					while (RMLgLBhi.hasNext()) {
						DnBszzth = RMLgLBhi.next();
						psImpl.setInt(1, DnBszzth.userId);
						UUIzsxKX = DnBszzth.forwardAddresses.iterator();
						while (UUIzsxKX.hasNext()) {
							psImpl.setString(2, UUIzsxKX.next());
							psImpl.executeUpdate();
						}
						nvoioGAI.add(DnBszzth.userId);
					}
				}
			});
			connection.commit();
			cmDB.removeUsers(nvoioGAI);
		} catch (SQLException ae9dPHdF) {
			log.error(ae9dPHdF);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException s1VyaYYj) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException ZZFLLsXM) {
				}
			}
		}
	}

}