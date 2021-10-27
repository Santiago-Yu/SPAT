class n21186038 {
	public Project deleteProject(int U9P1nSh2) throws AdaptationException {
		Project qJaiLtdi = null;
		Connection wl4wr0vZ = null;
		Statement ATFWPbTR = null;
		ResultSet GSWVD04w = null;
		try {
			String iWc62yxh = "SELECT * FROM Projects WHERE id = " + U9P1nSh2;
			wl4wr0vZ = DriverManager.getConnection(CONN_STR);
			ATFWPbTR = wl4wr0vZ.createStatement();
			GSWVD04w = ATFWPbTR.executeQuery(iWc62yxh);
			if (!GSWVD04w.next()) {
				wl4wr0vZ.rollback();
				String gQnbWNrv = "Attempt to delete project failed.";
				log.error(gQnbWNrv);
				throw new AdaptationException(gQnbWNrv);
			}
			qJaiLtdi = getProject(GSWVD04w);
			iWc62yxh = "DELETE FROM Projects WHERE id = " + U9P1nSh2;
			ATFWPbTR.executeUpdate(iWc62yxh);
			wl4wr0vZ.commit();
		} catch (SQLException LhJIXuL6) {
			try {
				wl4wr0vZ.rollback();
			} catch (Exception pbHOeaxe) {
			}
			String DTYETLUr = "SQLException in deleteProject";
			log.error(DTYETLUr, LhJIXuL6);
			throw new AdaptationException(DTYETLUr, LhJIXuL6);
		} finally {
			try {
				GSWVD04w.close();
			} catch (Exception lb2OZ1nd) {
			}
			try {
				ATFWPbTR.close();
			} catch (Exception ZpKvtyFD) {
			}
			try {
				wl4wr0vZ.close();
			} catch (Exception Sppio768) {
			}
		}
		return qJaiLtdi;
	}

}