class n3352340 {
	public Long processAddCompany(Company companyBean, String userLogin, Long holdingId, AuthSession authSession) {
		PreparedStatement ps = null;
		if (authSession == null) {
			return null;
		}
		DatabaseAdapter dbDyn = null;
		try {
			CustomSequenceType seq = new CustomSequenceType();
			dbDyn = DatabaseAdapter.getInstance();
			seq.setSequenceName("seq_WM_LIST_COMPANY");
			seq.setTableName("WM_LIST_COMPANY");
			seq.setColumnName("ID_FIRM");
			Long sequenceValue = dbDyn.getSequenceNextValue(seq);
			int num = 1;
			ps = dbDyn.prepareStatement("insert into WM_LIST_COMPANY (" + "	ID_FIRM, " + "	full_name, "
					+ "	short_name, " + "	address, " + "	telefon_buh, " + "	telefon_chief, " + "	chief, "
					+ "	buh, " + "	fax, " + "	email, " + "	icq, " + "	short_client_info, " + "	url, "
					+ "	short_info, " + "is_deleted" + ")" + (dbDyn.getIsNeedUpdateBracket() ? "(" : "") + " select "
					+ "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?,"
					+ "	?," + "	?,0 from WM_AUTH_USER " + "where USER_LOGIN=? "
					+ (dbDyn.getIsNeedUpdateBracket() ? ")" : ""));
			RsetTools.setLong(ps, num++, sequenceValue);
			ps.setString(num++, companyBean.getName());
			ps.setString(num++, companyBean.getShortName());
			ps.setString(num++, companyBean.getAddress());
			ps.setString(num++, "");
			ps.setString(num++, "");
			ps.setString(num++, companyBean.getCeo());
			ps.setString(num++, companyBean.getCfo());
			ps.setString(num++, "");
			ps.setString(num++, "");
			RsetTools.setLong(ps, num++, null);
			ps.setString(num++, "");
			ps.setString(num++, companyBean.getWebsite());
			ps.setString(num++, companyBean.getInfo());
			ps.setString(num++, userLogin);
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