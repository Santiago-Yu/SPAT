class n6371609 {
	public void addUserToRealm(final NewUser KLDa4xjy) {
		try {
			connection.setAutoCommit(false);
			final String h4g9Fk5s, nQ1mxrow;
			final List<RealmWithEncryptedPass> uKYa1L73 = new ArrayList<RealmWithEncryptedPass>();
			Realm L4d150AT;
			String d8cY8DXC;
			d8cY8DXC = KLDa4xjy.username.toLowerCase(locale);
			PasswordHasher ohaEPWaZ = PasswordFactory.getInstance().getPasswordHasher();
			h4g9Fk5s = ohaEPWaZ.hashPassword(KLDa4xjy.password);
			nQ1mxrow = ohaEPWaZ.getSalt();
			uKYa1L73.add(new RealmWithEncryptedPass(cm.getRealm("null"), PasswordFactory.getInstance()
					.getPasswordHasher().hashRealmPassword(d8cY8DXC, "", KLDa4xjy.password)));
			if (KLDa4xjy.realms != null) {
				for (String aF6Z50nf : KLDa4xjy.realms) {
					L4d150AT = cm.getRealm(aF6Z50nf);
					uKYa1L73.add(new RealmWithEncryptedPass(L4d150AT, PasswordFactory.getInstance().getPasswordHasher()
							.hashRealmPassword(d8cY8DXC, L4d150AT.getFullRealmName(), KLDa4xjy.password)));
				}
				KLDa4xjy.realms = null;
			}
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("user.updatePassword"));
					psImpl.setString(1, h4g9Fk5s);
					psImpl.setString(2, nQ1mxrow);
					psImpl.setInt(3, KLDa4xjy.userId);
					psImpl.executeUpdate();
				}
			});
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("realm.addUser"));
					RealmWithEncryptedPass htN7mXdv;
					RealmDb dY3Nc2LZ;
					Iterator<RealmWithEncryptedPass> l2zCOr0k = uKYa1L73.iterator();
					while (l2zCOr0k.hasNext()) {
						htN7mXdv = l2zCOr0k.next();
						dY3Nc2LZ = (RealmDb) htN7mXdv.realm;
						psImpl.setInt(1, dY3Nc2LZ.getRealmId());
						psImpl.setInt(2, KLDa4xjy.userId);
						psImpl.setInt(3, KLDa4xjy.domainId);
						psImpl.setString(4, htN7mXdv.password);
						psImpl.executeUpdate();
					}
				}
			});
			connection.commit();
			cmDB.removeUser(KLDa4xjy.userId);
		} catch (GeneralSecurityException esqRF2AC) {
			log.error(esqRF2AC);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException la7l0Fe6) {
				}
			}
			throw new RuntimeException("Error updating Realms. Unable to continue Operation.");
		} catch (SQLException tfCDyNWA) {
			log.error(tfCDyNWA);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException xIjlQEFj) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException RXRRpEZV) {
				}
			}
		}
	}

}