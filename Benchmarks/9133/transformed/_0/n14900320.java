class n14900320 {
	@Override
	public User updateUser(User wqMMt83t) throws SitoolsException {
		checkUser();
		Connection gKssNRQQ = null;
		try {
			gKssNRQQ = ds.getConnection();
			gKssNRQQ.setAutoCommit(false);
			PreparedStatement cuPKa5NF;
			int B5SdVPnM = 1;
			if (wqMMt83t.getSecret() != null && !"".equals(wqMMt83t.getSecret())) {
				cuPKa5NF = gKssNRQQ.prepareStatement(jdbcStoreResource.UPDATE_USER_WITH_PW);
				cuPKa5NF.setString(B5SdVPnM++, wqMMt83t.getFirstName());
				cuPKa5NF.setString(B5SdVPnM++, wqMMt83t.getLastName());
				cuPKa5NF.setString(B5SdVPnM++, wqMMt83t.getSecret());
				cuPKa5NF.setString(B5SdVPnM++, wqMMt83t.getEmail());
				cuPKa5NF.setString(B5SdVPnM++, wqMMt83t.getIdentifier());
			} else {
				cuPKa5NF = gKssNRQQ.prepareStatement(jdbcStoreResource.UPDATE_USER_WITHOUT_PW);
				cuPKa5NF.setString(B5SdVPnM++, wqMMt83t.getFirstName());
				cuPKa5NF.setString(B5SdVPnM++, wqMMt83t.getLastName());
				cuPKa5NF.setString(B5SdVPnM++, wqMMt83t.getEmail());
				cuPKa5NF.setString(B5SdVPnM++, wqMMt83t.getIdentifier());
			}
			cuPKa5NF.executeUpdate();
			cuPKa5NF.close();
			if (wqMMt83t.getProperties() != null) {
				deleteProperties(wqMMt83t.getIdentifier(), gKssNRQQ);
				createProperties(wqMMt83t, gKssNRQQ);
			}
			if (!gKssNRQQ.getAutoCommit()) {
				gKssNRQQ.commit();
			}
		} catch (SQLException Na1feZ4N) {
			try {
				gKssNRQQ.rollback();
			} catch (SQLException qdKnKeGN) {
				throw new SitoolsException("UPDATE_USER ROLLBACK" + qdKnKeGN.getMessage(), qdKnKeGN);
			}
			throw new SitoolsException("UPDATE_USER " + Na1feZ4N.getMessage(), Na1feZ4N);
		} finally {
			closeConnection(gKssNRQQ);
		}
		return getUserById(wqMMt83t.getIdentifier());
	}

}