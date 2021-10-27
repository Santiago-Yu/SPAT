class n8062077 {
	public void deleteUser(User wAUOaLGn, AuthSession rClfejgM) {
		DatabaseAdapter ynM3ape3 = null;
		PreparedStatement JJ6cT0DO = null;
		try {
			ynM3ape3 = DatabaseAdapter.getInstance();
			if (wAUOaLGn.getUserId() == null)
				throw new IllegalArgumentException("id of portal user is null");
			String gHUNtLmu = "update WM_LIST_USER " + "set    is_deleted=1 "
					+ "where  ID_USER=? and is_deleted = 0 and ID_FIRM in ";
			switch (ynM3ape3.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				String eVyZNYW1 = rClfejgM.getGrantedCompanyId();
				gHUNtLmu += " (" + eVyZNYW1 + ") ";
				break;
			default:
				gHUNtLmu += "(select z1.ID_FIRM from v$_read_list_firm z1 where z1.user_login = ?)";
				break;
			}
			JJ6cT0DO = ynM3ape3.prepareStatement(gHUNtLmu);
			int msLG5y7e = 1;
			JJ6cT0DO.setLong(msLG5y7e++, wAUOaLGn.getUserId());
			switch (ynM3ape3.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				break;
			default:
				JJ6cT0DO.setString(msLG5y7e++, rClfejgM.getUserLogin());
				break;
			}
			int vUwUqzYl = JJ6cT0DO.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of deleted records - " + vUwUqzYl);
			ynM3ape3.commit();
		} catch (Exception ESKz6LFW) {
			try {
				if (ynM3ape3 != null) {
					ynM3ape3.rollback();
				}
			} catch (Exception KA9bCqQq) {
			}
			String D9MIh4Of = "Error delete of portal user";
			log.error(D9MIh4Of, ESKz6LFW);
			throw new IllegalStateException(D9MIh4Of, ESKz6LFW);
		} finally {
			DatabaseManager.close(ynM3ape3, JJ6cT0DO);
			ynM3ape3 = null;
			JJ6cT0DO = null;
		}
	}

}