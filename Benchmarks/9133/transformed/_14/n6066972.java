class n6066972 {
	@Override
	public void run() {
		Shell currentShell = Display.getCurrent().getActiveShell();
		if (null == DMManager.getInstance().getOntology())
			return;
		DataRecordSet data = DMManager.getInstance().getOntology().getDataView().dataset();
		InputDialog input = new InputDialog(currentShell, Resources.I18N.getString("vikamine.dtp.title"),
				Resources.I18N.getString("vikamine.dtp.export.tablename"), data.getRelationName(), null);
		input.open();
		String tablename = input.getValue();
		if (null == tablename)
			return;
		super.getProfile().connect();
		IManagedConnection mc = super.getProfile().getManagedConnection("java.sql.Connection");
		java.sql.Connection sql = (java.sql.Connection) mc.getConnection().getRawConnection();
		try {
			sql.setAutoCommit(false);
			DatabaseMetaData dbmd = sql.getMetaData();
			ResultSet tables = dbmd.getTables(null, null, tablename, new String[] { "TABLE" });
			if (tables.next()) {
				if (!MessageDialog.openConfirm(currentShell, Resources.I18N.getString("vikamine.dtp.title"),
						Resources.I18N.getString("vikamine.dtp.export.overwriteTable")))
					return;
				Statement statement = sql.createStatement();
				statement.executeUpdate("DROP TABLE " + tablename);
				statement.close();
			}
			String createTableQuery = null;
			for (int i = 0; i < data.getNumAttributes(); i++) {
				if (DMManager.getInstance().getOntology().isIDAttribute(data.getAttribute(i)))
					continue;
				if (null == createTableQuery)
					createTableQuery = "";
				else
					createTableQuery += ",";
				createTableQuery += getColumnDefinition(data.getAttribute(i));
			}
			Statement statement = sql.createStatement();
			statement.executeUpdate("CREATE TABLE " + tablename + "(" + createTableQuery + ")");
			statement.close();
			exportRecordSet(data, sql, tablename);
			sql.commit();
			sql.setAutoCommit(true);
			MessageDialog.openInformation(currentShell, Resources.I18N.getString("vikamine.dtp.title"),
					Resources.I18N.getString("vikamine.dtp.export.successful"));
		} catch (SQLException e) {
			try {
				sql.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			MessageDialog.openError(currentShell, Resources.I18N.getString("vikamine.dtp.title"),
					Resources.I18N.getString("vikamine.dtp.export.failed"));
			e.printStackTrace();
		}
	}

}