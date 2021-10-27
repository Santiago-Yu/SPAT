class n4603066 {
	public User createUser(Map KXJPC6h4) throws HamboFatalException {
		DBConnection MX6DXBBz = null;
		try {
			MX6DXBBz = DBServiceManager.allocateConnection();
			MX6DXBBz.setAutoCommit(false);
			String tkUWzmpc = (String) KXJPC6h4.get(HamboUser.USER_ID);
			String Pe6YMsWd = "insert into user_UserAccount " + "(userid,firstname,lastname,street,zipcode,city,"
					+ "province,country,email,cellph,gender,password,"
					+ "language,timezn,birthday,datecreated,lastlogin,"
					+ "disabled,wapsigned,ldapInSync,offerings,firstcb) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement VeiKWlQh = MX6DXBBz.prepareStatement(Pe6YMsWd);
			VeiKWlQh.setString(1, tkUWzmpc);
			VeiKWlQh.setString(2, (String) KXJPC6h4.get(HamboUser.FIRST_NAME));
			VeiKWlQh.setString(3, (String) KXJPC6h4.get(HamboUser.LAST_NAME));
			VeiKWlQh.setString(4, (String) KXJPC6h4.get(HamboUser.STREET_ADDRESS));
			VeiKWlQh.setString(5, (String) KXJPC6h4.get(HamboUser.ZIP_CODE));
			VeiKWlQh.setString(6, (String) KXJPC6h4.get(HamboUser.CITY));
			VeiKWlQh.setString(7, (String) KXJPC6h4.get(HamboUser.STATE));
			VeiKWlQh.setString(8, (String) KXJPC6h4.get(HamboUser.COUNTRY));
			VeiKWlQh.setString(9, (String) KXJPC6h4.get(HamboUser.EXTERNAL_EMAIL_ADDRESS));
			VeiKWlQh.setString(10, (String) KXJPC6h4.get(HamboUser.MOBILE_NUMBER));
			VeiKWlQh.setString(11, (String) KXJPC6h4.get(HamboUser.GENDER));
			VeiKWlQh.setString(12, (String) KXJPC6h4.get(HamboUser.PASSWORD));
			VeiKWlQh.setString(13, (String) KXJPC6h4.get(HamboUser.LANGUAGE));
			VeiKWlQh.setString(14, (String) KXJPC6h4.get(HamboUser.TIME_ZONE));
			java.sql.Date puRwzlVs = (java.sql.Date) KXJPC6h4.get(HamboUser.BIRTHDAY);
			if (puRwzlVs != null)
				VeiKWlQh.setDate(15, puRwzlVs);
			else
				VeiKWlQh.setNull(15, Types.DATE);
			puRwzlVs = (java.sql.Date) KXJPC6h4.get(HamboUser.CREATED);
			if (puRwzlVs != null)
				VeiKWlQh.setDate(16, puRwzlVs);
			else
				VeiKWlQh.setNull(16, Types.DATE);
			puRwzlVs = (java.sql.Date) KXJPC6h4.get(HamboUser.LAST_LOGIN);
			if (puRwzlVs != null)
				VeiKWlQh.setDate(17, puRwzlVs);
			else
				VeiKWlQh.setNull(17, Types.DATE);
			Boolean DUuTK9sE = (Boolean) KXJPC6h4.get(HamboUser.DISABLED);
			if (DUuTK9sE != null)
				VeiKWlQh.setBoolean(18, DUuTK9sE.booleanValue());
			else
				VeiKWlQh.setBoolean(18, UserAccountInfo.DEFAULT_DISABLED);
			DUuTK9sE = (Boolean) KXJPC6h4.get(HamboUser.WAP_ACCOUNT);
			if (DUuTK9sE != null)
				VeiKWlQh.setBoolean(19, DUuTK9sE.booleanValue());
			else
				VeiKWlQh.setBoolean(19, UserAccountInfo.DEFAULT_WAP_ACCOUNT);
			DUuTK9sE = (Boolean) KXJPC6h4.get(HamboUser.LDAP_IN_SYNC);
			if (DUuTK9sE != null)
				VeiKWlQh.setBoolean(20, DUuTK9sE.booleanValue());
			else
				VeiKWlQh.setBoolean(20, UserAccountInfo.DEFAULT_LDAP_IN_SYNC);
			DUuTK9sE = (Boolean) KXJPC6h4.get(HamboUser.OFFERINGS);
			if (DUuTK9sE != null)
				VeiKWlQh.setBoolean(21, DUuTK9sE.booleanValue());
			else
				VeiKWlQh.setBoolean(21, UserAccountInfo.DEFAULT_OFFERINGS);
			VeiKWlQh.setString(22, (String) KXJPC6h4.get(HamboUser.COBRANDING_ID));
			MX6DXBBz.executeUpdate(VeiKWlQh, null);
			VeiKWlQh = MX6DXBBz.prepareStatement(DBUtil.getQueryCurrentOID(MX6DXBBz, "user_UserAccount", "newoid"));
			ResultSet p396RsDH = MX6DXBBz.executeQuery(VeiKWlQh, null);
			if (p396RsDH.next()) {
				OID u3kZ0qCc = new OID(p396RsDH.getBigDecimal("newoid").doubleValue());
				KXJPC6h4.put(HamboUser.OID, u3kZ0qCc);
			}
			MX6DXBBz.commit();
		} catch (Exception wkLcGMOT) {
			if (MX6DXBBz != null)
				try {
					MX6DXBBz.rollback();
				} catch (SQLException DLA1Oucr) {
				}
			throw new HamboFatalException(MSG_INSERT_FAILED, wkLcGMOT);
		} finally {
			if (MX6DXBBz != null)
				try {
					MX6DXBBz.reset();
				} catch (SQLException tUBwH95k) {
				}
			if (MX6DXBBz != null)
				MX6DXBBz.release();
		}
		return buildUser(KXJPC6h4);
	}

}