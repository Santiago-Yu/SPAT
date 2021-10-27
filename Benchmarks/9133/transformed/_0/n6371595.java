class n6371595 {
	public void setUserPassword(final List<NewUser> r7mvFBxk) {
		try {
			final List<Integer> iXWF9VPt = new ArrayList<Integer>();
			connection.setAutoCommit(false);
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("user.updatePassword"));
					Iterator<NewUser> a2n542sU = r7mvFBxk.iterator();
					NewUser s07s1m1O;
					PasswordHasher PAGaXMMD;
					while (a2n542sU.hasNext()) {
						s07s1m1O = a2n542sU.next();
						PAGaXMMD = PasswordFactory.getInstance().getPasswordHasher();
						psImpl.setString(1, PAGaXMMD.hashPassword(s07s1m1O.password));
						psImpl.setString(2, PAGaXMMD.getSalt());
						psImpl.setInt(3, s07s1m1O.userId);
						psImpl.executeUpdate();
						iXWF9VPt.add(s07s1m1O.userId);
					}
				}
			});
			List<JESRealmUser> mjLzXx4H = (List<JESRealmUser>) new ProcessEnvelope()
					.executeObject(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

						@Override
						public Object executeProcessReturnObject() throws SQLException {
							List<JESRealmUser> Ixvq4pIG = new ArrayList<JESRealmUser>(r7mvFBxk.size() + 10);
							psImpl = connImpl.prepareStatement(sqlCommands.getProperty("realms.user.load"));
							Iterator<NewUser> IX3Z5Xn9 = r7mvFBxk.iterator();
							NewUser PGFqvcT6;
							while (IX3Z5Xn9.hasNext()) {
								PGFqvcT6 = IX3Z5Xn9.next();
								psImpl.setInt(1, PGFqvcT6.userId);
								rsImpl = psImpl.executeQuery();
								while (rsImpl.next()) {
									Ixvq4pIG.add(new JESRealmUser(PGFqvcT6.username, PGFqvcT6.userId,
											rsImpl.getInt("realm_id"), rsImpl.getInt("domain_id"), PGFqvcT6.password,
											rsImpl.getString("realm_name_lower_case")));
								}
							}
							return Ixvq4pIG;
						}
					});
			final List<JESRealmUser> Yw1XTLUr = new ArrayList<JESRealmUser>(mjLzXx4H.size());
			Iterator<JESRealmUser> lHmfA6nv = mjLzXx4H.iterator();
			JESRealmUser kNWRa3z4;
			Realm M3p3gnsE;
			while (lHmfA6nv.hasNext()) {
				kNWRa3z4 = lHmfA6nv.next();
				M3p3gnsE = cm.getRealm(kNWRa3z4.realm);
				Yw1XTLUr.add(new JESRealmUser(null, kNWRa3z4.userId, kNWRa3z4.realmId, kNWRa3z4.domainId,
						PasswordFactory.getInstance().getPasswordHasher().hashRealmPassword(
								kNWRa3z4.username.toLowerCase(locale),
								M3p3gnsE.getFullRealmName().equals("null") ? "" : M3p3gnsE.getFullRealmName(),
								kNWRa3z4.password),
						null));
			}
			new ProcessEnvelope().executeNull(new ExecuteProcessAbstractImpl(connection, false, false, true, true) {

				@Override
				public void executeProcessReturnNull() throws SQLException {
					psImpl = connImpl.prepareStatement(sqlCommands.getProperty("realms.user.update"));
					Iterator<JESRealmUser> LwefQsVQ = Yw1XTLUr.iterator();
					JESRealmUser XvgMVGK4;
					while (LwefQsVQ.hasNext()) {
						XvgMVGK4 = LwefQsVQ.next();
						psImpl.setString(1, XvgMVGK4.password);
						psImpl.setInt(2, XvgMVGK4.realmId);
						psImpl.setInt(3, XvgMVGK4.userId);
						psImpl.setInt(4, XvgMVGK4.domainId);
						psImpl.executeUpdate();
					}
				}
			});
			connection.commit();
			cmDB.removeUsers(iXWF9VPt);
		} catch (GeneralSecurityException bo8PZ0L4) {
			log.error(bo8PZ0L4);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException IDrX9wFV) {
				}
			}
			throw new RuntimeException("Error updating Realms. Unable to continue Operation.");
		} catch (SQLException arxtPJK6) {
			log.error(arxtPJK6);
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException oPhGzGmj) {
				}
			}
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
				} catch (SQLException sMyxlEYJ) {
				}
			}
		}
	}

}