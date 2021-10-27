class n12469140 {
	public Program updateProgramPath(int eYikeDmr, String YMdsChdZ) throws AdaptationException {
		Program LK2Gd8Fa = null;
		Connection MujceXUL = null;
		Statement x6gfxSls = null;
		ResultSet oGSXXA2U = null;
		try {
			String yCjztkGd = "UPDATE Programs SET " + "sourcePath = '" + YMdsChdZ + "' " + "WHERE id = " + eYikeDmr;
			MujceXUL = DriverManager.getConnection(CONN_STR);
			x6gfxSls = MujceXUL.createStatement();
			x6gfxSls.executeUpdate(yCjztkGd);
			yCjztkGd = "SELECT * from Programs WHERE id = " + eYikeDmr;
			oGSXXA2U = x6gfxSls.executeQuery(yCjztkGd);
			if (!oGSXXA2U.next()) {
				MujceXUL.rollback();
				String chgVADo3 = "Attempt to update program failed.";
				log.error(chgVADo3);
				throw new AdaptationException(chgVADo3);
			}
			LK2Gd8Fa = getProgram(oGSXXA2U);
			MujceXUL.commit();
		} catch (SQLException jn9yrd9S) {
			try {
				MujceXUL.rollback();
			} catch (Exception Mv3MH06P) {
			}
			String foQ6em2s = "SQLException in updateProgramPath";
			log.error(foQ6em2s, jn9yrd9S);
			throw new AdaptationException(foQ6em2s, jn9yrd9S);
		} finally {
			try {
				oGSXXA2U.close();
			} catch (Exception Av8xGpX5) {
			}
			try {
				x6gfxSls.close();
			} catch (Exception GHvMFWpe) {
			}
			try {
				MujceXUL.close();
			} catch (Exception lPEG4ER8) {
			}
		}
		return LK2Gd8Fa;
	}

}