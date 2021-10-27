class n18942517 {
	public Long addRole(AuthSession authSession, RoleBean roleBean) {
		DatabaseAdapter dbDyn = null;
		PreparedStatement ps = null;
		try {
			CustomSequenceType seq = new CustomSequenceType();
			dbDyn = DatabaseAdapter.getInstance();
			seq.setSequenceName("seq_WM_AUTH_ACCESS_GROUP");
			seq.setTableName("WM_AUTH_ACCESS_GROUP");
			seq.setColumnName("ID_ACCESS_GROUP");
			Long sequenceValue = dbDyn.getSequenceNextValue(seq);
			ps = dbDyn.prepareStatement("insert into WM_AUTH_ACCESS_GROUP "
					+ "( ID_ACCESS_GROUP, NAME_ACCESS_GROUP ) values " + (dbDyn.getIsNeedUpdateBracket() ? "(" : "")
					+ " ?, ? " + (dbDyn.getIsNeedUpdateBracket() ? ")" : ""));
			RsetTools.setLong(ps, 1, sequenceValue);
			ps.setString(2, roleBean.getName());
			int i1 = ps.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of inserted records - " + i1);
			dbDyn.commit();
			return sequenceValue;
		} catch (Exception e) {
			String es = "Error add new role";
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