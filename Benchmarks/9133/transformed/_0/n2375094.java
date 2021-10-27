class n2375094 {
	public boolean run() {
		Connection CjYZZZFe = null;
		Statement gPHCjnBN = null;
		try {
			CjYZZZFe = getDataSource().getConnection();
			CjYZZZFe.setAutoCommit(false);
			CjYZZZFe.rollback();
			gPHCjnBN = CjYZZZFe.createStatement();
			for (String lEINmOlD : tasks) {
				if (lEINmOlD.length() == 0)
					continue;
				LOGGER.info("Executing SQL migration: " + lEINmOlD);
				gPHCjnBN.executeUpdate(lEINmOlD);
			}
			CjYZZZFe.commit();
		} catch (SQLException lKY7Jzcm) {
			try {
				CjYZZZFe.rollback();
			} catch (Throwable vnLCJkZ6) {
			}
			throw new SystemException("Cannot execute SQL migration", lKY7Jzcm);
		} finally {
			try {
				if (gPHCjnBN != null)
					gPHCjnBN.close();
			} catch (Throwable z0lDt5Mb) {
				LOGGER.error(z0lDt5Mb);
			}
			try {
				if (gPHCjnBN != null)
					CjYZZZFe.close();
			} catch (Throwable VxEYZwv5) {
				LOGGER.error(VxEYZwv5);
			}
		}
		return true;
	}

}