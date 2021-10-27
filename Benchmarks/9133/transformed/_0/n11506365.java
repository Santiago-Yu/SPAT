class n11506365 {
	@Override
	public boolean setupDatabaseSchema() {
		Configuration A3Rp7KUQ = Configuration.getInstance();
		Connection J6LuGhw9 = getConnection();
		if (null == J6LuGhw9)
			return false;
		try {
			String zxk7RZW8 = FileTool.readFile(A3Rp7KUQ.getProperty("database.sql.rootdir")
					+ System.getProperty("file.separator") + A3Rp7KUQ.getProperty("database.sql.mysql.setupschema"));
			zxk7RZW8 = zxk7RZW8.replaceAll(MYSQL_SQL_SCHEMA_REPLACEMENT,
					StateSaver.getInstance().getDatabaseSettings().getSchema());
			J6LuGhw9.setAutoCommit(false);
			Statement ow3ckXNQ = J6LuGhw9.createStatement();
			String[] znrRfqn6 = zxk7RZW8.split(";");
			for (String Ea85Drbn : znrRfqn6) {
				if (Ea85Drbn.trim().length() > 0)
					ow3ckXNQ.executeUpdate(Ea85Drbn);
			}
			J6LuGhw9.commit();
			JOptionPane.showMessageDialog(null, language.getProperty("database.messages.executionsuccess"),
					language.getProperty("dialog.information.title"), JOptionPane.INFORMATION_MESSAGE);
			return true;
		} catch (SQLException YlFBkyaO) {
			Logger.logException(YlFBkyaO);
		}
		try {
			if (J6LuGhw9 != null)
				J6LuGhw9.rollback();
		} catch (SQLException HKLvRZ0a) {
			Logger.logException(HKLvRZ0a);
		}
		JOptionPane.showMessageDialog(null, language.getProperty("database.messages.executionerror"),
				language.getProperty("dialog.error.title"), JOptionPane.ERROR_MESSAGE);
		return false;
	}

}