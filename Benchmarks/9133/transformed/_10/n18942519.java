class n18942519 {
	public void deleteRole(AuthSession authSession, RoleBean roleBean) {
		PreparedStatement ps = null;
		DatabaseAdapter dbDyn = null;
		try {
			dbDyn = DatabaseAdapter.getInstance();
			String sql = "delete from WM_AUTH_ACCESS_GROUP where ID_ACCESS_GROUP=? ";
			if (roleBean.getRoleId() == null)
				throw new IllegalArgumentException("role id is null");
			ps = dbDyn.prepareStatement(sql);
			RsetTools.setLong(ps, 1, roleBean.getRoleId());
			int i1 = ps.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of deleted records - " + i1);
			dbDyn.commit();
		} catch (Exception e) {
			String es = "Error delete role";
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