class n3352339 {
	public Long processAddCompany(Company companyBean, Long holdingId) {
		DatabaseAdapter dbDyn = null;
		PreparedStatement ps = null;
		try {
			CustomSequenceType seq = new CustomSequenceType();
			dbDyn = DatabaseAdapter.getInstance();
			seq.setSequenceName("seq_WM_LIST_COMPANY");
			seq.setTableName("WM_LIST_COMPANY");
			seq.setColumnName("ID_FIRM");
			Long sequenceValue = dbDyn.getSequenceNextValue(seq);
			int num = 1;
			ps = dbDyn.prepareStatement(
					"insert into WM_LIST_COMPANY (" + "	ID_FIRM, " + "	full_name, " + "	short_name, "
							+ "	address, " + "	chief, " + "	buh, " + "	url, " + "	short_info, " + "   is_deleted"
							+ ")values " + (dbDyn.getIsNeedUpdateBracket() ? "(" : "") + "	?," + "	?," + "	?," + "	?,"
							+ "	?," + "	?," + "	?," + "	?," + "   0 " + (dbDyn.getIsNeedUpdateBracket() ? ")" : ""));
			RsetTools.setLong(ps, num++, sequenceValue);
			ps.setString(num++, companyBean.getName());
			ps.setString(num++, companyBean.getShortName());
			ps.setString(num++, companyBean.getAddress());
			ps.setString(num++, companyBean.getCeo());
			ps.setString(num++, companyBean.getCfo());
			ps.setString(num++, companyBean.getWebsite());
			ps.setString(num++, companyBean.getInfo());
			int i1 = ps.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of inserted records - " + i1);
			if (holdingId != null) {
				InternalDaoFactory.getInternalHoldingDao().setRelateHoldingCompany(dbDyn, holdingId, sequenceValue);
			}
			dbDyn.commit();
			return sequenceValue;
		} catch (Exception e) {
			String es = "Error add new company";
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