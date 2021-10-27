class n9168699 {
	public void insertArchiveEntries(ArchiveEntry eHb2PGXJ[]) throws WeatherMonitorException {
		String lIO64oGg = null;
		try {
			Connection vmwLdEmJ = getConnection();
			Statement kagCQC7j = vmwLdEmJ.createStatement();
			ResultSet BBV6h9jc = null;
			vmwLdEmJ.setAutoCommit(false);
			for (int OZzkQGLO = 0; OZzkQGLO < eHb2PGXJ.length; OZzkQGLO++) {
				if (!sanityCheck(eHb2PGXJ[OZzkQGLO])) {
				} else {
					lIO64oGg = getSelectSql(eHb2PGXJ[OZzkQGLO]);
					BBV6h9jc = kagCQC7j.executeQuery(lIO64oGg);
					if (BBV6h9jc.next()) {
						if (BBV6h9jc.getInt(1) == 0) {
							lIO64oGg = getInsertSql(eHb2PGXJ[OZzkQGLO]);
							if (kagCQC7j.executeUpdate(lIO64oGg) != 1) {
								vmwLdEmJ.rollback();
								System.out.println("rolling back sql");
								throw new WeatherMonitorException("exception on insert");
							}
						}
					}
				}
			}
			vmwLdEmJ.commit();
			kagCQC7j.close();
		} catch (SQLException tPUYo5MI) {
			tPUYo5MI.printStackTrace();
			throw new WeatherMonitorException(tPUYo5MI.getMessage());
		}
	}

}