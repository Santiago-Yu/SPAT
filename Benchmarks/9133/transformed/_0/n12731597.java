class n12731597 {
	public void SetRoles(Connection tIHhtf8o, User mNrVI3LQ, String[] zU04CpYT) throws NpsException {
		if (!IsSysAdmin() && !IsLocalAdmin())
			throw new NpsException(ErrorHelper.ACCESS_NOPRIVILEGE);
		PreparedStatement o8pBa5PH = null;
		ResultSet sdMJuNBT = null;
		try {
			String Lv4C3cvy = "delete from userrole where userid=?";
			o8pBa5PH = tIHhtf8o.prepareStatement(Lv4C3cvy);
			o8pBa5PH.setString(1, mNrVI3LQ.id);
			o8pBa5PH.executeUpdate();
			if (zU04CpYT != null && zU04CpYT.length > 0) {
				try {
					o8pBa5PH.close();
				} catch (Exception Okm1ZIbe) {
				}
				Lv4C3cvy = "insert into userrole(userid,roleid) values(?,?)";
				o8pBa5PH = tIHhtf8o.prepareStatement(Lv4C3cvy);
				for (int jYoqfQc0 = 0; jYoqfQc0 < zU04CpYT.length; jYoqfQc0++) {
					if (zU04CpYT[jYoqfQc0] != null && zU04CpYT[jYoqfQc0].length() > 0) {
						o8pBa5PH.setString(1, mNrVI3LQ.GetId());
						o8pBa5PH.setString(2, zU04CpYT[jYoqfQc0]);
						o8pBa5PH.executeUpdate();
					}
				}
			}
			try {
				o8pBa5PH.close();
			} catch (Exception GzDipNU5) {
			}
			if (mNrVI3LQ.roles_by_name != null)
				mNrVI3LQ.roles_by_name.clear();
			if (mNrVI3LQ.roles_by_id != null)
				mNrVI3LQ.roles_by_id.clear();
			if (zU04CpYT != null && zU04CpYT.length > 0) {
				Lv4C3cvy = "select b.* from UserRole a,Role b where a.roleid = b.id and a.userid=?";
				o8pBa5PH = tIHhtf8o.prepareStatement(Lv4C3cvy);
				o8pBa5PH.setString(1, mNrVI3LQ.id);
				sdMJuNBT = o8pBa5PH.executeQuery();
				while (sdMJuNBT.next()) {
					if (mNrVI3LQ.roles_by_name == null)
						mNrVI3LQ.roles_by_name = new Hashtable();
					if (mNrVI3LQ.roles_by_id == null)
						mNrVI3LQ.roles_by_id = new Hashtable();
					mNrVI3LQ.roles_by_name.put(sdMJuNBT.getString("name"), sdMJuNBT.getString("id"));
					mNrVI3LQ.roles_by_id.put(sdMJuNBT.getString("id"), sdMJuNBT.getString("name"));
				}
			}
		} catch (Exception krDvzbdD) {
			try {
				tIHhtf8o.rollback();
			} catch (Exception WovJqrqv) {
			}
			nps.util.DefaultLog.error(krDvzbdD);
		} finally {
			if (sdMJuNBT != null)
				try {
					sdMJuNBT.close();
				} catch (Exception nFoqpKye) {
				}
			if (o8pBa5PH != null)
				try {
					o8pBa5PH.close();
				} catch (Exception t527FUKM) {
				}
		}
	}

}