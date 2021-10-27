class n15431561 {
	public ProgramProfilingSymbol updateProgramProfilingSymbol(int fezuKqSM, int NWwb4VyW, int NxQdBD0v)
			throws AdaptationException {
		ProgramProfilingSymbol cY9af8UP = null;
		Connection dVFlFe8I = null;
		Statement tnw4r5ms = null;
		ResultSet qACOjMhv = null;
		try {
			String oB6YrrYA = "UPDATE ProgramProfilingSymbols SET " + "projectDeploymentConfigurationID = " + NWwb4VyW
					+ ", " + "programSymbolID                  = " + NxQdBD0v + ", " + "WHERE id = " + fezuKqSM;
			dVFlFe8I = DriverManager.getConnection(CONN_STR);
			tnw4r5ms = dVFlFe8I.createStatement();
			tnw4r5ms.executeUpdate(oB6YrrYA);
			oB6YrrYA = "SELECT * from ProgramProfilingSymbols WHERE " + "id = " + fezuKqSM;
			qACOjMhv = tnw4r5ms.executeQuery(oB6YrrYA);
			if (!qACOjMhv.next()) {
				dVFlFe8I.rollback();
				String wySNP1AN = "Attempt to update program profiling " + "symbol failed.";
				log.error(wySNP1AN);
				throw new AdaptationException(wySNP1AN);
			}
			cY9af8UP = getProfilingSymbol(qACOjMhv);
			dVFlFe8I.commit();
		} catch (SQLException Jve4X7Yz) {
			try {
				dVFlFe8I.rollback();
			} catch (Exception XQyEppZU) {
			}
			String CcmmUN9C = "SQLException in updateProgramProfilingSymbol";
			log.error(CcmmUN9C, Jve4X7Yz);
			throw new AdaptationException(CcmmUN9C, Jve4X7Yz);
		} finally {
			try {
				qACOjMhv.close();
			} catch (Exception QuwWSKee) {
			}
			try {
				tnw4r5ms.close();
			} catch (Exception x6UjlMMr) {
			}
			try {
				dVFlFe8I.close();
			} catch (Exception AqXeU4fe) {
			}
		}
		return cY9af8UP;
	}

}