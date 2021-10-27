class n14900316 {
	@Override
	public User createUser(User PMQjxWBI) throws SitoolsException {
		checkUser();
		if (!User.isValid(PMQjxWBI)) {
			throw new SitoolsException("CREATE_USER_MALFORMED");
		}
		Connection QvHsZQpD = null;
		try {
			QvHsZQpD = ds.getConnection();
			QvHsZQpD.setAutoCommit(false);
			PreparedStatement DQZXQSt0 = QvHsZQpD.prepareStatement(jdbcStoreResource.CREATE_USER);
			int bNBefbG7 = 1;
			DQZXQSt0.setString(bNBefbG7++, PMQjxWBI.getIdentifier());
			DQZXQSt0.setString(bNBefbG7++, PMQjxWBI.getFirstName());
			DQZXQSt0.setString(bNBefbG7++, PMQjxWBI.getLastName());
			DQZXQSt0.setString(bNBefbG7++, PMQjxWBI.getSecret());
			DQZXQSt0.setString(bNBefbG7++, PMQjxWBI.getEmail());
			DQZXQSt0.executeUpdate();
			DQZXQSt0.close();
			createProperties(PMQjxWBI, QvHsZQpD);
			if (!QvHsZQpD.getAutoCommit()) {
				QvHsZQpD.commit();
			}
		} catch (SQLException wk929Xg9) {
			try {
				QvHsZQpD.rollback();
			} catch (SQLException Md95gPP7) {
				Md95gPP7.printStackTrace();
				throw new SitoolsException("CREATE_USER ROLLBACK" + Md95gPP7.getMessage(), Md95gPP7);
			}
			wk929Xg9.printStackTrace();
			throw new SitoolsException("CREATE_USER " + wk929Xg9.getMessage(), wk929Xg9);
		} finally {
			closeConnection(QvHsZQpD);
		}
		return getUserById(PMQjxWBI.getIdentifier());
	}

}