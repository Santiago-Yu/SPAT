class n3352340 {
	public Long processAddCompany(Company companyBean, String userLogin, Long holdingId, AuthSession authSession) {
		if (authSession == null) {
			return null;
		}
		PreparedStatement ps = null;
		DatabaseAdapter dbDyn = null;
		try {
			dbDyn = DatabaseAdapter.getInstance();
			CustomSequenceType seq = new CustomSequenceType();
			seq.setSequenceName("seq_WM_LIST_COMPANY");
			seq.setTableName("WM_LIST_COMPANY");
			seq.setColumnName("ID_FIRM");
			Long sequenceValue = dbDyn.getSequenceNextValue(seq);
			ps = dbDyn.prepareStatement("insert into WM_LIST_COMPANY (" + "	ID_FIRM, " + "	full_name, "
					+ "	short_name, " + "	address, " + "	telefon_buh, " + "	telefon_chief, " + "	chief, "
					+ "	buh, " + "	fax, " + "	email, " + "	icq, " + "	short_client_info, " + "	url, "
					+ "	short_info, " + "is_deleted" + ")" + (dbDyn.getIsNeedUpdateBracket() ? "(" : "") + " select "
					+ "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?,"
					+ "	?," + "	?,0 from WM_AUTH_USER " + "where USER_LOGIN=? "
					+ (dbDyn.getIsNeedUpdateBracket() ? ")" : ""));
			int num = 1;
			RsetTools.setLong(ps, num, sequenceValue);
			num++;
			ps.setString(num, companyBean.getName());
			num++;
			ps.setString(num, companyBean.getShortName());
			num++;
			ps.setString(num, companyBean.getAddress());
			num++;
			ps.setString(num, "");
			num++;
			ps.setString(num, "");
			num++;
			ps.setString(num, companyBean.getCeo());
			num++;
			ps.setString(num, companyBean.getCfo());
			num++;
			ps.setString(num, "");
			num++;
			ps.setString(num, "");
			num++;
			RsetTools.setLong(ps, num, null);
			num++;
			ps.setString(num, "");
			num++;
			ps.setString(num, companyBean.getWebsite());
			num++;
			ps.setString(num, companyBean.getInfo());
			num++;
			ps.setString(num, userLogin);
			num++;
			int i1 = ps.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of inserted records - " + i1);
			if (holdingId != null) {
				InternalDaoFactory.getInternalHoldingDao().setRelateHoldingCompany(dbDyn, holdingId, sequenceValue);
			}
			dbDyn.commit();
			return sequenceValue;
		} catch (Exception e) {
			try {
				if (dbDyn != null)
					dbDyn.rollback();
			} catch (Exception e001) {
			}
			String es = "Error add new company";
			log.error(es, e);
			throw new IllegalStateException(es, e);
		} finally {
			DatabaseManager.close(dbDyn, ps);
			dbDyn = null;
			ps = null;
		}
	}

}