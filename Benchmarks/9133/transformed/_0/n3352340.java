class n3352340 {
	public Long processAddCompany(Company HhuBKvcQ, String n21sSdBf, Long ywnz3ht5, AuthSession lrBPAadO) {
		if (lrBPAadO == null) {
			return null;
		}
		PreparedStatement rCdsz3wG = null;
		DatabaseAdapter WZ01Y48I = null;
		try {
			WZ01Y48I = DatabaseAdapter.getInstance();
			CustomSequenceType cMokInCL = new CustomSequenceType();
			cMokInCL.setSequenceName("seq_WM_LIST_COMPANY");
			cMokInCL.setTableName("WM_LIST_COMPANY");
			cMokInCL.setColumnName("ID_FIRM");
			Long wvYFhPES = WZ01Y48I.getSequenceNextValue(cMokInCL);
			rCdsz3wG = WZ01Y48I.prepareStatement("insert into WM_LIST_COMPANY (" + "	ID_FIRM, " + "	full_name, "
					+ "	short_name, " + "	address, " + "	telefon_buh, " + "	telefon_chief, " + "	chief, "
					+ "	buh, " + "	fax, " + "	email, " + "	icq, " + "	short_client_info, " + "	url, "
					+ "	short_info, " + "is_deleted" + ")" + (WZ01Y48I.getIsNeedUpdateBracket() ? "(" : "") + " select "
					+ "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "	?,"
					+ "	?," + "	?,0 from WM_AUTH_USER " + "where USER_LOGIN=? "
					+ (WZ01Y48I.getIsNeedUpdateBracket() ? ")" : ""));
			int LeI8zJK4 = 1;
			RsetTools.setLong(rCdsz3wG, LeI8zJK4++, wvYFhPES);
			rCdsz3wG.setString(LeI8zJK4++, HhuBKvcQ.getName());
			rCdsz3wG.setString(LeI8zJK4++, HhuBKvcQ.getShortName());
			rCdsz3wG.setString(LeI8zJK4++, HhuBKvcQ.getAddress());
			rCdsz3wG.setString(LeI8zJK4++, "");
			rCdsz3wG.setString(LeI8zJK4++, "");
			rCdsz3wG.setString(LeI8zJK4++, HhuBKvcQ.getCeo());
			rCdsz3wG.setString(LeI8zJK4++, HhuBKvcQ.getCfo());
			rCdsz3wG.setString(LeI8zJK4++, "");
			rCdsz3wG.setString(LeI8zJK4++, "");
			RsetTools.setLong(rCdsz3wG, LeI8zJK4++, null);
			rCdsz3wG.setString(LeI8zJK4++, "");
			rCdsz3wG.setString(LeI8zJK4++, HhuBKvcQ.getWebsite());
			rCdsz3wG.setString(LeI8zJK4++, HhuBKvcQ.getInfo());
			rCdsz3wG.setString(LeI8zJK4++, n21sSdBf);
			int BGJeKpJt = rCdsz3wG.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of inserted records - " + BGJeKpJt);
			if (ywnz3ht5 != null) {
				InternalDaoFactory.getInternalHoldingDao().setRelateHoldingCompany(WZ01Y48I, ywnz3ht5, wvYFhPES);
			}
			WZ01Y48I.commit();
			return wvYFhPES;
		} catch (Exception YlP6Tmnr) {
			try {
				if (WZ01Y48I != null)
					WZ01Y48I.rollback();
			} catch (Exception JyJG4Nfi) {
			}
			String QIbR58Zl = "Error add new company";
			log.error(QIbR58Zl, YlP6Tmnr);
			throw new IllegalStateException(QIbR58Zl, YlP6Tmnr);
		} finally {
			DatabaseManager.close(WZ01Y48I, rCdsz3wG);
			WZ01Y48I = null;
			rCdsz3wG = null;
		}
	}

}