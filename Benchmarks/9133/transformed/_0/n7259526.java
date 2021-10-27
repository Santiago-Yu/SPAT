class n7259526 {
	public void SetRoles(Connection S37BnW84, User czufRfZ6, String[] d4owLB31) throws NpsException {
		if (!IsSysAdmin() && !IsLocalAdmin())
			throw new NpsException(ErrorHelper.ACCESS_NOPRIVILEGE);
		PreparedStatement qF37kWbe = null;
		ResultSet itKgiMjH = null;
		try {
			String lGd6M9yv = "delete from userrole where userid=?";
			qF37kWbe = S37BnW84.prepareStatement(lGd6M9yv);
			qF37kWbe.setString(1, czufRfZ6.id);
			qF37kWbe.executeUpdate();
			if (d4owLB31 != null && d4owLB31.length > 0) {
				try {
					qF37kWbe.close();
				} catch (Exception wWqcUAdy) {
				}
				lGd6M9yv = "insert into userrole(userid,roleid) values(?,?)";
				qF37kWbe = S37BnW84.prepareStatement(lGd6M9yv);
				for (int PGfdLjPa = 0; PGfdLjPa < d4owLB31.length; PGfdLjPa++) {
					if (d4owLB31[PGfdLjPa] != null && d4owLB31[PGfdLjPa].length() > 0) {
						qF37kWbe.setString(1, czufRfZ6.GetId());
						qF37kWbe.setString(2, d4owLB31[PGfdLjPa]);
						qF37kWbe.executeUpdate();
					}
				}
			}
			try {
				qF37kWbe.close();
			} catch (Exception xyvBdAip) {
			}
			if (czufRfZ6.roles_by_name != null)
				czufRfZ6.roles_by_name.clear();
			if (czufRfZ6.roles_by_id != null)
				czufRfZ6.roles_by_id.clear();
			if (d4owLB31 != null && d4owLB31.length > 0) {
				lGd6M9yv = "select b.* from UserRole a,Role b where a.roleid = b.id and a.userid=?";
				qF37kWbe = S37BnW84.prepareStatement(lGd6M9yv);
				qF37kWbe.setString(1, czufRfZ6.id);
				itKgiMjH = qF37kWbe.executeQuery();
				while (itKgiMjH.next()) {
					if (czufRfZ6.roles_by_name == null)
						czufRfZ6.roles_by_name = new Hashtable();
					if (czufRfZ6.roles_by_id == null)
						czufRfZ6.roles_by_id = new Hashtable();
					czufRfZ6.roles_by_name.put(itKgiMjH.getString("name"), itKgiMjH.getString("id"));
					czufRfZ6.roles_by_id.put(itKgiMjH.getString("id"), itKgiMjH.getString("name"));
				}
			}
		} catch (Exception s6YcrtOk) {
			try {
				S37BnW84.rollback();
			} catch (Exception fbqAQqX5) {
			}
			com.microfly.util.DefaultLog.error(s6YcrtOk);
		} finally {
			if (itKgiMjH != null)
				try {
					itKgiMjH.close();
				} catch (Exception JVnVwMJY) {
				}
			if (qF37kWbe != null)
				try {
					qF37kWbe.close();
				} catch (Exception IcljWW0S) {
				}
		}
	}

}