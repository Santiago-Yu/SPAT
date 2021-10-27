class n3352341 {
	public void processSaveCompany(Company PRFhBxAv, AuthSession KbAWtSAK) {
		if (KbAWtSAK == null) {
			return;
		}
		DatabaseAdapter xc7Jj6PB = null;
		PreparedStatement pHSjQSoj = null;
		try {
			xc7Jj6PB = DatabaseAdapter.getInstance();
			String BrBLh72n = "UPDATE WM_LIST_COMPANY " + "SET " + "	full_name = ?, " + "	short_name = ?, "
					+ "	address = ?, " + "	telefon_buh = ?, " + "	telefon_chief = ?, " + "	chief = ?, "
					+ "	buh = ?, " + "	fax = ?, " + "	email = ?, " + "	icq = ?, " + "	short_client_info = ?, "
					+ "	url = ?, " + "	short_info = ? " + "WHERE ID_FIRM = ? and ID_FIRM in ";
			switch (xc7Jj6PB.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				String Hdmowd5B = KbAWtSAK.getGrantedCompanyId();
				BrBLh72n += " (" + Hdmowd5B + ") ";
				break;
			default:
				BrBLh72n += "(select z1.ID_FIRM from v$_read_list_firm z1 where z1.user_login = ?)";
				break;
			}
			pHSjQSoj = xc7Jj6PB.prepareStatement(BrBLh72n);
			int Il4vxXoe = 1;
			pHSjQSoj.setString(Il4vxXoe++, PRFhBxAv.getName());
			pHSjQSoj.setString(Il4vxXoe++, PRFhBxAv.getShortName());
			pHSjQSoj.setString(Il4vxXoe++, PRFhBxAv.getAddress());
			pHSjQSoj.setString(Il4vxXoe++, "");
			pHSjQSoj.setString(Il4vxXoe++, "");
			pHSjQSoj.setString(Il4vxXoe++, PRFhBxAv.getCeo());
			pHSjQSoj.setString(Il4vxXoe++, PRFhBxAv.getCfo());
			pHSjQSoj.setString(Il4vxXoe++, "");
			pHSjQSoj.setString(Il4vxXoe++, "");
			RsetTools.setLong(pHSjQSoj, Il4vxXoe++, null);
			pHSjQSoj.setString(Il4vxXoe++, "");
			pHSjQSoj.setString(Il4vxXoe++, PRFhBxAv.getWebsite());
			pHSjQSoj.setString(Il4vxXoe++, PRFhBxAv.getInfo());
			RsetTools.setLong(pHSjQSoj, Il4vxXoe++, PRFhBxAv.getId());
			switch (xc7Jj6PB.getFamaly()) {
			case DatabaseManager.MYSQL_FAMALY:
				break;
			default:
				pHSjQSoj.setString(Il4vxXoe++, KbAWtSAK.getUserLogin());
				break;
			}
			int mSSxrRgx = pHSjQSoj.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of updated record - " + mSSxrRgx);
			xc7Jj6PB.commit();
		} catch (Exception fEKetMqj) {
			try {
				if (xc7Jj6PB != null)
					xc7Jj6PB.rollback();
			} catch (Exception FCk831xj) {
			}
			String wkNnuCxi = "Error save company";
			log.error(wkNnuCxi, fEKetMqj);
			throw new IllegalStateException(wkNnuCxi, fEKetMqj);
		} finally {
			DatabaseManager.close(xc7Jj6PB, pHSjQSoj);
			xc7Jj6PB = null;
			pHSjQSoj = null;
		}
	}

}