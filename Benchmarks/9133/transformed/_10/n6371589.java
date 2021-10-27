class n6371589 {
	public void insertUser(final List<NewUser> newUsers) {
		try {
			connection.setAutoCommit(false);
			final Map<String, PasswordAndSalt> pass = new HashMap<String, PasswordAndSalt>();
			final Map<String, List<RealmWithEncryptedPass>> realmPass = new HashMap<String, List<RealmWithEncryptedPass>>();
			Iterator<NewUser> iter = newUsers.iterator();
			final List<String> userDirs = new ArrayList<String>();
			Realm realm;
			NewUser user;
			PasswordHasher ph;
			String username;
			while (iter.hasNext()) {
				user = iter.next();
				username = user.username.toLowerCase(locale);
				ph = PasswordFactory.getInstance().getPasswordHasher();
				pass.put(user.username, new PasswordAndSalt(ph.hashPassword(user.password), ph.getSalt()));
				realmPass.put(user.username, new ArrayList<RealmWithEncryptedPass>());
				realmPass.get(user.username).add(new RealmWithEncryptedPass(cm.getRealm("null"), PasswordFactory
						.getInstance().getPasswordHasher().hashRealmPassword(username, "", user.password)));
				if (user.realms != null) {
					for (String realmName : user.realms) {
						realm = cm.getRealm(realmName);
						realmPass.get(user.username)
								.add(new RealmWithEncryptedPass(realm, PasswordFactory.getInstance().getPasswordHasher()
										.hashRealmPassword(username, realm.getFullRealmName(), user.password)));
					}
					user.realms = null;
				}
			}
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("user.add"),
							Statement.RETURN_GENERATED_KEYS);
					NewUser user;
					Iterator<NewUser> iter = newUsers.iterator();
					DomainDb domain = null;
					while (iter.hasNext()) {
						user = iter.next();
						psImpl.setString(1, user.username);
						psImpl.setString(2, user.username.toLowerCase(locale));
						if (domain == null || (domain.getDomainId() != user.domainId)) {
							domain = (DomainDb) cmDB.getDomain(user.domainId);
						}
						userDirs.add(user.username + '@' + domain.getDomainName());
						psImpl.setInt(3, user.domainId);
						psImpl.setString(4, pass.get(user.username).password);
						psImpl.setString(5, pass.get(user.username).salt);
						psImpl.executeUpdate();
						rsImpl = psImpl.getGeneratedKeys();
						if (rsImpl.next()) {
							user.userId = rsImpl.getInt(1);
							rsImpl.close();
						} else {
							throw new SQLException("Need to have a user id generated.");
						}
					}
				}
			});
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("realm.addUser"));
					NewUser user;
					Iterator<NewUser> iter = newUsers.iterator();
					RealmWithEncryptedPass rwep;
					List<RealmWithEncryptedPass> list;
					RealmDb realm;
					while (iter.hasNext()) {
						user = iter.next();
						list = realmPass.get(user.username);
						if (list != null) {
							Iterator<RealmWithEncryptedPass> iter1 = list.iterator();
							while (iter1.hasNext()) {
								rwep = iter1.next();
								realm = (RealmDb) rwep.realm;
								psImpl.setInt(1, realm.getRealmId());
								psImpl.setInt(2, user.userId);
								psImpl.setInt(3, user.domainId);
								psImpl.setString(4, rwep.password);
								psImpl.executeUpdate();
							}
						}
					}
				}
			});
			connection.commit();
			Iterator<String> iterator = userDirs.iterator();
			while (iterator.hasNext()) {
				cm.requestDirCreation(new File(cm.getUsersDirectory(), iterator.next()).getPath());
			}
			cm.createDirectories();
		} catch (GeneralSecurityException e) {
			log.error(e);
			throw new RuntimeException("Error updating Realms. Unable to continue Operation.");
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException ex) {
				}
			}
		} catch (SQLException sqle) {
			log.error(sqle);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException ex) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException ex) {
				}
			}
		}
	}

}