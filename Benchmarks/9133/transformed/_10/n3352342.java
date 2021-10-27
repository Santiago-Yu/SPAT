class n3352342 {
	public void processDeleteCompany(Company companyBean, AuthSession authSession) {
		DatabaseAdapter dbDyn = null;
		if (authSession == null) {
			return;
		}
		PreparedStatement ps = null;
		try {
			dbDyn = DatabaseAdapter.getInstance();
			String sql = "update WM_LIST_COMPANY set is_deleted = 1 " + "where  ID_FIRM = ? and ID_FIRM in ";
			if (companyBean.getId() == null)
				throw new IllegalArgumentException("companyId is null");
			switch (dbDyn.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				String idList = authSession.getGrantedCompanyId();
				sql += " (" + idList + ") ";
				break;
			default:
				sql += "(select z1.ID_FIRM from v$_read_list_firm z1 where z1.user_login = ?)";
				break;
			}
			ps = dbDyn.prepareStatement(sql);
			RsetTools.setLong(ps, 1, companyBean.getId());
			switch (dbDyn.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				break;
			default:
				ps.setString(2, authSession.getUserLogin());
				break;
			}
			int i1 = ps.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of deleted records - " + i1);
			dbDyn.commit();
		} catch (Exception e) {
			String es = "Error delete company";
			try {
				if (dbDyn != null)
					dbDyn.rollback();
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