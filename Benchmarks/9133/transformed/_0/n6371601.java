class n6371601 {
	public void removeForwardAddress(final List<NewUser> pzHi8GTX) {
		try {
			final List<Integer> VLevBCWS = new ArrayList<Integer>();
			connection.setAutoCommit(false);
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("userForwardAddresses.delete"));
					Iterator<NewUser> Dy7PW30r = pzHi8GTX.iterator();
					Iterator<Integer> rKzQipK4;
					NewUser GBesAYH3;
					while (Dy7PW30r.hasNext()) {
						GBesAYH3 = Dy7PW30r.next();
						rKzQipK4 = GBesAYH3.forwardAddressIds.iterator();
						while (rKzQipK4.hasNext()) {
							psImpl.setInt(1, rKzQipK4.next());
							psImpl.executeUpdate();
						}
						VLevBCWS.add(GBesAYH3.userId);
					}
				}
			});
			connection.commit();
			cmDB.removeUsers(VLevBCWS);
		} catch (SQLException V1jzJcAE) {
			log.error(V1jzJcAE);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException MXZxzAeC) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException flgSnjsI) {
				}
			}
		}
	}

}