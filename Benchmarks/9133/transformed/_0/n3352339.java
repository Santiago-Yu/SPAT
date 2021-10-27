class n3352339 {
	public Long processAddCompany(Company YSS6T3EL, Long ovZRzaN5) {
		PreparedStatement Va0pOHmv = null;
		DatabaseAdapter OIrPNay5 = null;
		try {
			OIrPNay5 = DatabaseAdapter.getInstance();
			CustomSequenceType XyzJBQVF = new CustomSequenceType();
			XyzJBQVF.setSequenceName("seq_WM_LIST_COMPANY");
			XyzJBQVF.setTableName("WM_LIST_COMPANY");
			XyzJBQVF.setColumnName("ID_FIRM");
			Long ouM73bWd = OIrPNay5.getSequenceNextValue(XyzJBQVF);
			Va0pOHmv = OIrPNay5.prepareStatement("insert into WM_LIST_COMPANY (" + "	ID_FIRM, " + "	full_name, "
					+ "	short_name, " + "	address, " + "	chief, " + "	buh, " + "	url, " + "	short_info, "
					+ "   is_deleted" + ")values " + (OIrPNay5.getIsNeedUpdateBracket() ? "(" : "") + "	?," + "	?,"
					+ "	?," + "	?," + "	?," + "	?," + "	?," + "	?," + "   0 "
					+ (OIrPNay5.getIsNeedUpdateBracket() ? ")" : ""));
			int Dd1jAWgY = 1;
			RsetTools.setLong(Va0pOHmv, Dd1jAWgY++, ouM73bWd);
			Va0pOHmv.setString(Dd1jAWgY++, YSS6T3EL.getName());
			Va0pOHmv.setString(Dd1jAWgY++, YSS6T3EL.getShortName());
			Va0pOHmv.setString(Dd1jAWgY++, YSS6T3EL.getAddress());
			Va0pOHmv.setString(Dd1jAWgY++, YSS6T3EL.getCeo());
			Va0pOHmv.setString(Dd1jAWgY++, YSS6T3EL.getCfo());
			Va0pOHmv.setString(Dd1jAWgY++, YSS6T3EL.getWebsite());
			Va0pOHmv.setString(Dd1jAWgY++, YSS6T3EL.getInfo());
			int cWLGjHSC = Va0pOHmv.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of inserted records - " + cWLGjHSC);
			if (ovZRzaN5 != null) {
				InternalDaoFactory.getInternalHoldingDao().setRelateHoldingCompany(OIrPNay5, ovZRzaN5, ouM73bWd);
			}
			OIrPNay5.commit();
			return ouM73bWd;
		} catch (Exception YUXT113p) {
			try {
				if (OIrPNay5 != null)
					OIrPNay5.rollback();
			} catch (Exception GtWmtRJ9) {
			}
			String S6UPFZpt = "Error add new company";
			log.error(S6UPFZpt, YUXT113p);
			throw new IllegalStateException(S6UPFZpt, YUXT113p);
		} finally {
			DatabaseManager.close(OIrPNay5, Va0pOHmv);
			OIrPNay5 = null;
			Va0pOHmv = null;
		}
	}

}