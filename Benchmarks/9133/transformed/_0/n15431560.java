class n15431560 {
	public ProgramProfilingSymbol deleteProfilingSymbol(int ZCW6Qek9) throws AdaptationException {
		ProgramProfilingSymbol Hk6n23kF = null;
		Connection Jx5P2Ksx = null;
		Statement LLcKlYBZ = null;
		ResultSet Oaku73mO = null;
		try {
			String llXyEpZc = "SELECT * FROM ProgramProfilingSymbols " + "WHERE id = " + ZCW6Qek9;
			Jx5P2Ksx = DriverManager.getConnection(CONN_STR);
			LLcKlYBZ = Jx5P2Ksx.createStatement();
			Oaku73mO = LLcKlYBZ.executeQuery(llXyEpZc);
			if (!Oaku73mO.next()) {
				Jx5P2Ksx.rollback();
				String dX4KGOUp = "Attempt to delete program profiling " + "symbol failed.";
				log.error(dX4KGOUp);
				throw new AdaptationException(dX4KGOUp);
			}
			Hk6n23kF = getProfilingSymbol(Oaku73mO);
			llXyEpZc = "DELETE FROM ProgramProfilingSymbols " + "WHERE id = " + ZCW6Qek9;
			LLcKlYBZ.executeUpdate(llXyEpZc);
			Jx5P2Ksx.commit();
		} catch (SQLException NKOrzslp) {
			try {
				Jx5P2Ksx.rollback();
			} catch (Exception X6qFkV4Z) {
			}
			String Q0BWbX2C = "SQLException in deleteProfilingSymbol";
			log.error(Q0BWbX2C, NKOrzslp);
			throw new AdaptationException(Q0BWbX2C, NKOrzslp);
		} finally {
			try {
				Oaku73mO.close();
			} catch (Exception pgiQgnRg) {
			}
			try {
				LLcKlYBZ.close();
			} catch (Exception dXbHJRlM) {
			}
			try {
				Jx5P2Ksx.close();
			} catch (Exception PNhEcUs9) {
			}
		}
		return Hk6n23kF;
	}

}