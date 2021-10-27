class n19919874 {
	public Long createSite(Site PYuiH2oh, List<String> eRR9Yfyn) {
		if (log.isDebugEnabled()) {
			log.debug("site: " + PYuiH2oh);
			if (PYuiH2oh != null) {
				log.debug("    language: " + PYuiH2oh.getDefLanguage());
				log.debug("    country: " + PYuiH2oh.getDefCountry());
				log.debug("    variant: " + PYuiH2oh.getDefVariant());
				log.debug("    companyId: " + PYuiH2oh.getCompanyId());
			}
		}
		PreparedStatement W1wo7FMl = null;
		DatabaseAdapter do6WAxqV = null;
		try {
			do6WAxqV = DatabaseAdapter.getInstance();
			CustomSequenceType CK3BmNpL = new CustomSequenceType();
			CK3BmNpL.setSequenceName("seq_WM_PORTAL_LIST_SITE");
			CK3BmNpL.setTableName("WM_PORTAL_LIST_SITE");
			CK3BmNpL.setColumnName("ID_SITE");
			Long QR2dAwEG = do6WAxqV.getSequenceNextValue(CK3BmNpL);
			W1wo7FMl = do6WAxqV.prepareStatement(
					"insert into WM_PORTAL_LIST_SITE (" + "ID_SITE, ID_FIRM, DEF_LANGUAGE, DEF_COUNTRY, DEF_VARIANT, "
							+ "NAME_SITE, ADMIN_EMAIL, IS_CSS_DYNAMIC, CSS_FILE, " + "IS_REGISTER_ALLOWED " + ")values "
							+ (do6WAxqV.getIsNeedUpdateBracket() ? "(" : "") + "	?," + "	?," + "	?," + "	?," + "	?,"
							+ "	?," + "	?," + "	?," + "	?," + "	? " + (do6WAxqV.getIsNeedUpdateBracket() ? ")" : ""));
			int ufuNFf5Z = 1;
			RsetTools.setLong(W1wo7FMl, ufuNFf5Z++, QR2dAwEG);
			RsetTools.setLong(W1wo7FMl, ufuNFf5Z++, PYuiH2oh.getCompanyId());
			W1wo7FMl.setString(ufuNFf5Z++, PYuiH2oh.getDefLanguage());
			W1wo7FMl.setString(ufuNFf5Z++, PYuiH2oh.getDefCountry());
			W1wo7FMl.setString(ufuNFf5Z++, PYuiH2oh.getDefVariant());
			W1wo7FMl.setString(ufuNFf5Z++, PYuiH2oh.getSiteName());
			W1wo7FMl.setString(ufuNFf5Z++, PYuiH2oh.getAdminEmail());
			W1wo7FMl.setInt(ufuNFf5Z++, PYuiH2oh.getCssDynamic() ? 1 : 0);
			W1wo7FMl.setString(ufuNFf5Z++, PYuiH2oh.getCssFile());
			W1wo7FMl.setInt(ufuNFf5Z++, PYuiH2oh.getRegisterAllowed() ? 1 : 0);
			int D1xob195 = W1wo7FMl.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of inserted records - " + D1xob195);
			if (eRR9Yfyn != null) {
				for (String xzjltx5i : eRR9Yfyn) {
					VirtualHost fbIIOu5V = new VirtualHostBean(null, QR2dAwEG, xzjltx5i);
					InternalDaoFactory.getInternalVirtualHostDao().createVirtualHost(do6WAxqV, fbIIOu5V);
				}
			}
			do6WAxqV.commit();
			return QR2dAwEG;
		} catch (Exception gW1vKK1A) {
			try {
				if (do6WAxqV != null)
					do6WAxqV.rollback();
			} catch (Exception b8FkcASy) {
			}
			String UOlbAGsg = "Error add new site";
			log.error(UOlbAGsg, gW1vKK1A);
			throw new IllegalStateException(UOlbAGsg, gW1vKK1A);
		} finally {
			DatabaseManager.close(do6WAxqV, W1wo7FMl);
			do6WAxqV = null;
			W1wo7FMl = null;
		}
	}

}