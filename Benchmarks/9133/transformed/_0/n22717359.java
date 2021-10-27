class n22717359 {
	public void modify(ModifyInterceptorChain nfbvvOLk, DistinguishedName uc8Zfjxe,
			ArrayList<LDAPModification> o0bbNGGs, LDAPConstraints u2YdmGUS) throws LDAPException {
		Connection siqCicEI = (Connection) nfbvvOLk.getRequest().get(JdbcInsert.MYVD_DB_CON + "LDAPBaseServer");
		if (siqCicEI == null) {
			throw new LDAPException("Operations Error", LDAPException.OPERATIONS_ERROR, "No Database Connection");
		}
		try {
			siqCicEI.setAutoCommit(false);
			HashMap<String, String> knr6tgrA = (HashMap<String, String>) nfbvvOLk.getRequest()
					.get(JdbcInsert.MYVD_DB_DB2LDAP + "LDAPBaseServer");
			Iterator<LDAPModification> ssIKiO2y = o0bbNGGs.iterator();
			String IwNjoAhU = ((RDN) uc8Zfjxe.getDN().getRDNs().get(0)).getValue();
			int IytrYWsl = this.getId(uc8Zfjxe, siqCicEI);
			while (ssIKiO2y.hasNext()) {
				LDAPModification wUQNM45Z = ssIKiO2y.next();
				if (wUQNM45Z.getOp() == LDAPModification.REPLACE) {
					String GCJyJfvb = wUQNM45Z.getAttribute().getName();
					if (GCJyJfvb.equals(knr6tgrA.get("first")) || GCJyJfvb.equals(knr6tgrA.get("last"))) {
						PreparedStatement uq7eKCDv = siqCicEI.prepareStatement("UPDATE USERS SET "
								+ (GCJyJfvb.equals(knr6tgrA.get("first")) ? "first" : "last") + "=? WHERE username=?");
						uq7eKCDv.setString(1, wUQNM45Z.getAttribute().getStringValue());
						uq7eKCDv.setString(2, IwNjoAhU);
						uq7eKCDv.executeUpdate();
						uq7eKCDv.close();
					} else if (GCJyJfvb.equals(knr6tgrA.get("username"))) {
						throw new LDAPException("Can not modify the rdn", LDAPException.NOT_ALLOWED_ON_RDN,
								"Can not perform modify");
					} else if (GCJyJfvb.equals(knr6tgrA.get("name"))) {
						PreparedStatement dqHXvokb = siqCicEI
								.prepareStatement("DELETE FROM locationmap WHERE person=?");
						dqHXvokb.setInt(1, IytrYWsl);
						dqHXvokb.executeUpdate();
						dqHXvokb.close();
						dqHXvokb = siqCicEI.prepareStatement("INSERT INTO locationmap (person,location) VALUES (?,?)");
						PreparedStatement dmI0DUFJ = siqCicEI.prepareStatement("SELECT id FROM LOCATIONS WHERE name=?");
						String[] Tel7Uxpz = wUQNM45Z.getAttribute().getStringValueArray();
						for (int je1USVF2 = 0; je1USVF2 < Tel7Uxpz.length; je1USVF2++) {
							dmI0DUFJ.setString(1, Tel7Uxpz[je1USVF2]);
							ResultSet ie68eN9p = dmI0DUFJ.executeQuery();
							if (!ie68eN9p.next()) {
								siqCicEI.rollback();
								throw new LDAPException("Location " + Tel7Uxpz[je1USVF2] + " does not exist",
										LDAPException.OBJECT_CLASS_VIOLATION,
										"Location " + Tel7Uxpz[je1USVF2] + " does not exist");
							}
							int Hu5pinSS = ie68eN9p.getInt("id");
							dqHXvokb.setInt(1, IytrYWsl);
							dqHXvokb.setInt(2, Hu5pinSS);
							dqHXvokb.executeUpdate();
						}
						dqHXvokb.close();
						dmI0DUFJ.close();
					}
				} else if (wUQNM45Z.getOp() == LDAPModification.DELETE) {
					if (wUQNM45Z.getAttribute().getName().equals(knr6tgrA.get("name"))) {
						String[] CGtWJQi9 = wUQNM45Z.getAttribute().getStringValueArray();
						if (CGtWJQi9.length == 0) {
							PreparedStatement qZmGxN4f = siqCicEI
									.prepareStatement("DELETE FROM locationmap WHERE person=?");
							qZmGxN4f.setInt(1, IytrYWsl);
							qZmGxN4f.executeUpdate();
							qZmGxN4f.close();
						} else {
							PreparedStatement sqqr4AC4 = siqCicEI
									.prepareStatement("DELETE FROM locationmap WHERE person=? and location=?");
							PreparedStatement IMrxdnJv = siqCicEI
									.prepareStatement("SELECT id FROM LOCATIONS WHERE name=?");
							for (int tTvD6DtA = 0; tTvD6DtA < CGtWJQi9.length; tTvD6DtA++) {
								IMrxdnJv.setString(1, CGtWJQi9[tTvD6DtA]);
								ResultSet vv95S9Hm = IMrxdnJv.executeQuery();
								if (!vv95S9Hm.next()) {
									siqCicEI.rollback();
									throw new LDAPException("Location " + CGtWJQi9[tTvD6DtA] + " does not exist",
											LDAPException.OBJECT_CLASS_VIOLATION,
											"Location " + CGtWJQi9[tTvD6DtA] + " does not exist");
								}
								int N2z8QrlM = vv95S9Hm.getInt("id");
								sqqr4AC4.setInt(1, IytrYWsl);
								sqqr4AC4.setInt(2, N2z8QrlM);
								sqqr4AC4.executeUpdate();
							}
							sqqr4AC4.close();
							IMrxdnJv.close();
						}
					} else {
						throw new LDAPException("Can not delete attribute " + wUQNM45Z.getAttribute().getName(),
								LDAPException.INVALID_ATTRIBUTE_SYNTAX, "");
					}
				} else if (wUQNM45Z.getOp() == LDAPModification.ADD) {
					if (wUQNM45Z.getAttribute().getName().equals(knr6tgrA.get("name"))) {
						String[] aLrTrGJy = wUQNM45Z.getAttribute().getStringValueArray();
						PreparedStatement CcKknaT8 = siqCicEI
								.prepareStatement("INSERT INTO locationmap (person,location) VALUES (?,?)");
						PreparedStatement xsrzB03A = siqCicEI.prepareStatement("SELECT id FROM LOCATIONS WHERE name=?");
						for (int Ognv1Xae = 0; Ognv1Xae < aLrTrGJy.length; Ognv1Xae++) {
							xsrzB03A.setString(1, aLrTrGJy[Ognv1Xae]);
							ResultSet jsLJjU0e = xsrzB03A.executeQuery();
							if (!jsLJjU0e.next()) {
								siqCicEI.rollback();
								throw new LDAPException("Location " + aLrTrGJy[Ognv1Xae] + " does not exist",
										LDAPException.OBJECT_CLASS_VIOLATION,
										"Location " + aLrTrGJy[Ognv1Xae] + " does not exist");
							}
							int jqBfk61U = jsLJjU0e.getInt("id");
							CcKknaT8.setInt(1, IytrYWsl);
							CcKknaT8.setInt(2, jqBfk61U);
							CcKknaT8.executeUpdate();
						}
						CcKknaT8.close();
						xsrzB03A.close();
					} else {
						throw new LDAPException("Can not delete attribute " + wUQNM45Z.getAttribute().getName(),
								LDAPException.INVALID_ATTRIBUTE_SYNTAX, "");
					}
				}
			}
			siqCicEI.commit();
		} catch (SQLException SrwiwcLr) {
			try {
				siqCicEI.rollback();
			} catch (SQLException K5YVFX8I) {
				throw new LDAPException("Could not delete entry or rollback transaction",
						LDAPException.OPERATIONS_ERROR, SrwiwcLr.toString(), SrwiwcLr);
			}
			throw new LDAPException("Could not delete entry", LDAPException.OPERATIONS_ERROR, SrwiwcLr.toString(),
					SrwiwcLr);
		}
	}

}