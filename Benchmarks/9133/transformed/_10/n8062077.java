class n8062077 {
	public void deleteUser(User portalUserBean, AuthSession authSession) {
		PreparedStatement ps = null;
		DatabaseAdapter dbDyn = null;
		try {
			dbDyn = DatabaseAdapter.getInstance();
			String sql = "update WM_LIST_USER " + "set    is_deleted=1 "
					+ "where  ID_USER=? and is_deleted = 0 and ID_FIRM in ";
			if (portalUserBean.getUserId() == null)
				throw new IllegalArgumentException("id of portal user is null");
			switch (dbDyn.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				String idList = authSession.getGrantedCompanyId();
				sql += " (" + idList + ") ";
				break;
			default:
				sql += "(select z1.ID_FIRM from v$_read_list_firm z1 where z1.user_login = ?)";
				break;
			}
			int num = 1;
			ps = dbDyn.prepareStatement(sql);
			ps.setLong(num++, portalUserBean.getUserId());
			switch (dbDyn.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				break;
			default:
				ps.setString(num++, authSession.getUserLogin());
				break;
			}
			int i1 = ps.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of deleted records - " + i1);
			dbDyn.commit();
		} catch (Exception e) {
			String es = "Error delete of portal user";
			try {
				if (dbDyn != null) {
					dbDyn.rollback();
				}
			} catch (Exception e001) {
			}
			log.error(es, e);
			throw new IllegalStateException(es, e);
		} finally {
			DatabaseManager.close(dbDyn, ps);
			ps = null;
			dbDyn = null;
		}
	}

}