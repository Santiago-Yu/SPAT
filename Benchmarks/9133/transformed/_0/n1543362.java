class n1543362 {
	public ProgramSymbol deleteProgramSymbol(int cP2SMvm1) throws AdaptationException {
		ProgramSymbol xZgcZCqf = null;
		Connection Th3zHHyj = null;
		Statement fbjvYe9o = null;
		ResultSet PCjaOYca = null;
		try {
			String GWtMBbTC = "SELECT * FROM ProgramSymbols " + "WHERE id = " + cP2SMvm1;
			Th3zHHyj = DriverManager.getConnection(CONN_STR);
			fbjvYe9o = Th3zHHyj.createStatement();
			PCjaOYca = fbjvYe9o.executeQuery(GWtMBbTC);
			if (!PCjaOYca.next()) {
				Th3zHHyj.rollback();
				String lDjfxKWN = "Attempt to delete program symbol failed.";
				log.error(lDjfxKWN);
				throw new AdaptationException(lDjfxKWN);
			}
			xZgcZCqf = getProgramSymbol(PCjaOYca);
			GWtMBbTC = "DELETE FROM ProgramSymbols " + "WHERE id = " + cP2SMvm1;
			fbjvYe9o.executeUpdate(GWtMBbTC);
			Th3zHHyj.commit();
		} catch (SQLException A3wJtzZf) {
			try {
				Th3zHHyj.rollback();
			} catch (Exception DrNLIsBc) {
			}
			String qBNxVr5m = "SQLException in deleteProgramSymbol";
			log.error(qBNxVr5m, A3wJtzZf);
			throw new AdaptationException(qBNxVr5m, A3wJtzZf);
		} finally {
			try {
				PCjaOYca.close();
			} catch (Exception An01CMRK) {
			}
			try {
				fbjvYe9o.close();
			} catch (Exception fggeoxk1) {
			}
			try {
				Th3zHHyj.close();
			} catch (Exception bZyGlEdR) {
			}
		}
		return xZgcZCqf;
	}

}