class n3352342 {
	public void processDeleteCompany(Company hGJQ4rYF, AuthSession CkpMe2BA) {
		if (CkpMe2BA == null) {
			return;
		}
		DatabaseAdapter tptEDMq8 = null;
		PreparedStatement lUMIOPRL = null;
		try {
			tptEDMq8 = DatabaseAdapter.getInstance();
			if (hGJQ4rYF.getId() == null)
				throw new IllegalArgumentException("companyId is null");
			String MrEY3Zhf = "update WM_LIST_COMPANY set is_deleted = 1 " + "where  ID_FIRM = ? and ID_FIRM in ";
			switch (tptEDMq8.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				String GzU5uebO = CkpMe2BA.getGrantedCompanyId();
				MrEY3Zhf += " (" + GzU5uebO + ") ";
				break;
			default:
				MrEY3Zhf += "(select z1.ID_FIRM from v$_read_list_firm z1 where z1.user_login = ?)";
				break;
			}
			lUMIOPRL = tptEDMq8.prepareStatement(MrEY3Zhf);
			RsetTools.setLong(lUMIOPRL, 1, hGJQ4rYF.getId());
			switch (tptEDMq8.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				break;
			default:
				lUMIOPRL.setString(2, CkpMe2BA.getUserLogin());
				break;
			}
			int OhZcjYAX = lUMIOPRL.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of deleted records - " + OhZcjYAX);
			tptEDMq8.commit();
		} catch (Exception n54fx0mT) {
			try {
				if (tptEDMq8 != null)
					tptEDMq8.rollback();
			} catch (Exception xgMaZZhu) {
			}
			String x2QqcAMr = "Error delete company";
			log.error(x2QqcAMr, n54fx0mT);
			throw new IllegalStateException(x2QqcAMr, n54fx0mT);
		} finally {
			DatabaseManager.close(tptEDMq8, lUMIOPRL);
			tptEDMq8 = null;
			lUMIOPRL = null;
		}
	}

}