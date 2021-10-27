class n6066972 {
	@Override
	public void run() {
		Shell eAd8Yh7o = Display.getCurrent().getActiveShell();
		if (DMManager.getInstance().getOntology() == null)
			return;
		DataRecordSet lpiEhghq = DMManager.getInstance().getOntology().getDataView().dataset();
		InputDialog yhUJyTcZ = new InputDialog(eAd8Yh7o, Resources.I18N.getString("vikamine.dtp.title"),
				Resources.I18N.getString("vikamine.dtp.export.tablename"), lpiEhghq.getRelationName(), null);
		yhUJyTcZ.open();
		String WZDpjlO6 = yhUJyTcZ.getValue();
		if (WZDpjlO6 == null)
			return;
		super.getProfile().connect();
		IManagedConnection toHwzzAD = super.getProfile().getManagedConnection("java.sql.Connection");
		java.sql.Connection nBehDBeN = (java.sql.Connection) toHwzzAD.getConnection().getRawConnection();
		try {
			nBehDBeN.setAutoCommit(false);
			DatabaseMetaData Uw6nmrvu = nBehDBeN.getMetaData();
			ResultSet HSWpHL2O = Uw6nmrvu.getTables(null, null, WZDpjlO6, new String[] { "TABLE" });
			if (HSWpHL2O.next()) {
				if (!MessageDialog.openConfirm(eAd8Yh7o, Resources.I18N.getString("vikamine.dtp.title"),
						Resources.I18N.getString("vikamine.dtp.export.overwriteTable")))
					return;
				Statement LTtos0tJ = nBehDBeN.createStatement();
				LTtos0tJ.executeUpdate("DROP TABLE " + WZDpjlO6);
				LTtos0tJ.close();
			}
			String ahuvRSbQ = null;
			for (int pYabbpAE = 0; pYabbpAE < lpiEhghq.getNumAttributes(); pYabbpAE++) {
				if (DMManager.getInstance().getOntology().isIDAttribute(lpiEhghq.getAttribute(pYabbpAE)))
					continue;
				if (ahuvRSbQ == null)
					ahuvRSbQ = "";
				else
					ahuvRSbQ += ",";
				ahuvRSbQ += getColumnDefinition(lpiEhghq.getAttribute(pYabbpAE));
			}
			Statement gxkiPxGJ = nBehDBeN.createStatement();
			gxkiPxGJ.executeUpdate("CREATE TABLE " + WZDpjlO6 + "(" + ahuvRSbQ + ")");
			gxkiPxGJ.close();
			exportRecordSet(lpiEhghq, nBehDBeN, WZDpjlO6);
			nBehDBeN.commit();
			nBehDBeN.setAutoCommit(true);
			MessageDialog.openInformation(eAd8Yh7o, Resources.I18N.getString("vikamine.dtp.title"),
					Resources.I18N.getString("vikamine.dtp.export.successful"));
		} catch (SQLException yrty4dHS) {
			try {
				nBehDBeN.rollback();
			} catch (SQLException j4JyMWK9) {
				j4JyMWK9.printStackTrace();
			}
			MessageDialog.openError(eAd8Yh7o, Resources.I18N.getString("vikamine.dtp.title"),
					Resources.I18N.getString("vikamine.dtp.export.failed"));
			yrty4dHS.printStackTrace();
		}
	}

}