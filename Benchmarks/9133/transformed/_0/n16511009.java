class n16511009 {
	public ProgramProfilingMessageSymbol deleteProfilingMessageSymbol(int UhKDHF7m) throws AdaptationException {
		ProgramProfilingMessageSymbol TuDYQCIJ = null;
		Connection AK2kN1xC = null;
		Statement d7IOClrR = null;
		ResultSet S0O9Z342 = null;
		try {
			String PC0ckGwx = "SELECT * FROM ProgramProfilingMessageSymbols " + "WHERE id = " + UhKDHF7m;
			AK2kN1xC = DriverManager.getConnection(CONN_STR);
			d7IOClrR = AK2kN1xC.createStatement();
			S0O9Z342 = d7IOClrR.executeQuery(PC0ckGwx);
			if (!S0O9Z342.next()) {
				AK2kN1xC.rollback();
				String fh8X7ot2 = "Attempt to delete program profiling message " + "symbol failed.";
				log.error(fh8X7ot2);
				throw new AdaptationException(fh8X7ot2);
			}
			TuDYQCIJ = getProfilingMessageSymbol(S0O9Z342);
			PC0ckGwx = "DELETE FROM ProgramProfilingMessageSymbols " + "WHERE id = " + UhKDHF7m;
			d7IOClrR.executeUpdate(PC0ckGwx);
			AK2kN1xC.commit();
		} catch (SQLException nQtaQefM) {
			try {
				AK2kN1xC.rollback();
			} catch (Exception KciczE9B) {
			}
			String yo9j8B7z = "SQLException in deleteProfilingMessageSymbol";
			log.error(yo9j8B7z, nQtaQefM);
			throw new AdaptationException(yo9j8B7z, nQtaQefM);
		} finally {
			try {
				S0O9Z342.close();
			} catch (Exception tr8lzBEI) {
			}
			try {
				d7IOClrR.close();
			} catch (Exception C3YsGCJI) {
			}
			try {
				AK2kN1xC.close();
			} catch (Exception Sh324tv0) {
			}
		}
		return TuDYQCIJ;
	}

}