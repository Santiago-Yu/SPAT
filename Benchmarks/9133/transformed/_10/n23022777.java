class n23022777 {
	public void processSaveHolding(Holding holdingBean, AuthSession authSession) {
		DatabaseAdapter dbDyn = null;
		if (authSession == null) {
			return;
		}
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE WM_LIST_HOLDING " + "SET " + "   full_name_HOLDING=?, " + "   NAME_HOLDING=? "
					+ "WHERE ID_HOLDING = ? and ID_HOLDING in ";
			dbDyn = DatabaseAdapter.getInstance();
			switch (dbDyn.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				String idList = authSession.getGrantedHoldingId();
				sql += " (" + idList + ") ";
				break;
			default:
				sql += "(select z1.ID_ROAD from v$_read_list_road z1 where z1.user_login = ?)";
				break;
			}
			int num = 1;
			ps = dbDyn.prepareStatement(sql);
			ps.setString(num++, holdingBean.getName());
			ps.setString(num++, holdingBean.getShortName());
			RsetTools.setLong(ps, num++, holdingBean.getId());
			switch (dbDyn.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				break;
			default:
				ps.setString(num++, authSession.getUserLogin());
				break;
			}
			int i1 = ps.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of updated record - " + i1);
			processDeleteRelatedCompany(dbDyn, holdingBean, authSession);
			processInsertRelatedCompany(dbDyn, holdingBean, authSession);
			dbDyn.commit();
		} catch (Exception e) {
			String es = "Error save holding";
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