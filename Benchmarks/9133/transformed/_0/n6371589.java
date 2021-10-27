class n6371589 {
	public void insertUser(final List<NewUser> nqUAQ3iX) {
		try {
			connection.setAutoCommit(false);
			final Map<String, PasswordAndSalt> OIUrECHz = new HashMap<String, PasswordAndSalt>();
			final Map<String, List<RealmWithEncryptedPass>> NSTwyIb6 = new HashMap<String, List<RealmWithEncryptedPass>>();
			final List<String> XGMaN13G = new ArrayList<String>();
			Iterator<NewUser> wlzUGq60 = nqUAQ3iX.iterator();
			NewUser QVMtDoKG;
			Realm yn5sxsGE;
			String sXjbvSrp;
			PasswordHasher yK0IMwYs;
			while (wlzUGq60.hasNext()) {
				QVMtDoKG = wlzUGq60.next();
				sXjbvSrp = QVMtDoKG.username.toLowerCase(locale);
				yK0IMwYs = PasswordFactory.getInstance().getPasswordHasher();
				OIUrECHz.put(QVMtDoKG.username,
						new PasswordAndSalt(yK0IMwYs.hashPassword(QVMtDoKG.password), yK0IMwYs.getSalt()));
				NSTwyIb6.put(QVMtDoKG.username, new ArrayList<RealmWithEncryptedPass>());
				NSTwyIb6.get(QVMtDoKG.username).add(new RealmWithEncryptedPass(cm.getRealm("null"), PasswordFactory
						.getInstance().getPasswordHasher().hashRealmPassword(sXjbvSrp, "", QVMtDoKG.password)));
				if (QVMtDoKG.realms != null) {
					for (String jlXqyATu : QVMtDoKG.realms) {
						yn5sxsGE = cm.getRealm(jlXqyATu);
						NSTwyIb6.get(QVMtDoKG.username).add(
								new RealmWithEncryptedPass(yn5sxsGE, PasswordFactory.getInstance().getPasswordHasher()
										.hashRealmPassword(sXjbvSrp, yn5sxsGE.getFullRealmName(), QVMtDoKG.password)));
					}
					QVMtDoKG.realms = null;
				}
			}
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("user.add"),
							Statement.RETURN_GENERATED_KEYS);
					Iterator<NewUser> Swfk79jn = nqUAQ3iX.iterator();
					NewUser B6YUhUl2;
					DomainDb LI8SrR7a = null;
					while (Swfk79jn.hasNext()) {
						B6YUhUl2 = Swfk79jn.next();
						psImpl.setString(1, B6YUhUl2.username);
						psImpl.setString(2, B6YUhUl2.username.toLowerCase(locale));
						if (LI8SrR7a == null || (LI8SrR7a.getDomainId() != B6YUhUl2.domainId)) {
							LI8SrR7a = (DomainDb) cmDB.getDomain(B6YUhUl2.domainId);
						}
						XGMaN13G.add(B6YUhUl2.username + '@' + LI8SrR7a.getDomainName());
						psImpl.setInt(3, B6YUhUl2.domainId);
						psImpl.setString(4, OIUrECHz.get(B6YUhUl2.username).password);
						psImpl.setString(5, OIUrECHz.get(B6YUhUl2.username).salt);
						psImpl.executeUpdate();
						rsImpl = psImpl.getGeneratedKeys();
						if (rsImpl.next()) {
							B6YUhUl2.userId = rsImpl.getInt(1);
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
					Iterator<NewUser> wmTSaICO = nqUAQ3iX.iterator();
					NewUser NWbWkD2D;
					List<RealmWithEncryptedPass> wXSn6OPA;
					RealmWithEncryptedPass CNEXlKvc;
					RealmDb t3eJ4guu;
					while (wmTSaICO.hasNext()) {
						NWbWkD2D = wmTSaICO.next();
						wXSn6OPA = NSTwyIb6.get(NWbWkD2D.username);
						if (wXSn6OPA != null) {
							Iterator<RealmWithEncryptedPass> gSLGo6Jx = wXSn6OPA.iterator();
							while (gSLGo6Jx.hasNext()) {
								CNEXlKvc = gSLGo6Jx.next();
								t3eJ4guu = (RealmDb) CNEXlKvc.realm;
								psImpl.setInt(1, t3eJ4guu.getRealmId());
								psImpl.setInt(2, NWbWkD2D.userId);
								psImpl.setInt(3, NWbWkD2D.domainId);
								psImpl.setString(4, CNEXlKvc.password);
								psImpl.executeUpdate();
							}
						}
					}
				}
			});
			connection.commit();
			Iterator<String> mVcK2SMH = XGMaN13G.iterator();
			while (mVcK2SMH.hasNext()) {
				cm.requestDirCreation(new File(cm.getUsersDirectory(), mVcK2SMH.next()).getPath());
			}
			cm.createDirectories();
		} catch (GeneralSecurityException E3fbgOof) {
			log.error(E3fbgOof);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException lazZ7FCB) {
				}
			}
			throw new RuntimeException("Error updating Realms. Unable to continue Operation.");
		} catch (SQLException YKLLlzHw) {
			log.error(YKLLlzHw);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException myUCBno6) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException hSpKWoH5) {
				}
			}
		}
	}

}