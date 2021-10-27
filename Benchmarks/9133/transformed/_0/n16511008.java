class n16511008 {
	public ProgramProfilingMessageSymbol createNewProfilingMessageSymbol(int gXlOJYcB, int S1h9T1H3)
			throws AdaptationException {
		ProgramProfilingMessageSymbol QZrbwTo1 = null;
		Connection JiSFxHmK = null;
		Statement mopJYs5b = null;
		ResultSet gVlXDExi = null;
		try {
			String usOglhfD = "INSERT INTO ProgramProfilingMessageSymbols"
					+ "(projectDeploymentConfigurationID, programMessageSymbolID)" + " VALUES (" + gXlOJYcB + ", "
					+ S1h9T1H3 + ")";
			JiSFxHmK = DriverManager.getConnection(CONN_STR);
			mopJYs5b = JiSFxHmK.createStatement();
			mopJYs5b.executeUpdate(usOglhfD);
			usOglhfD = "SELECT * FROM ProgramProfilingMessageSymbols WHERE " + "projectDeploymentConfigurationID = "
					+ gXlOJYcB + " AND " + "programMessageSymbolID           = " + S1h9T1H3;
			gVlXDExi = mopJYs5b.executeQuery(usOglhfD);
			if (!gVlXDExi.next()) {
				JiSFxHmK.rollback();
				String JMWV0fRq = "Attempt to create program profiling message " + "symbol failed.";
				log.error(JMWV0fRq);
				throw new AdaptationException(JMWV0fRq);
			}
			QZrbwTo1 = getProfilingMessageSymbol(gVlXDExi);
			JiSFxHmK.commit();
		} catch (SQLException YHmxVk6h) {
			try {
				JiSFxHmK.rollback();
			} catch (Exception pw1wzLw6) {
			}
			String Proyt99A = "SQLException in createNewProfilingMessageSymbol";
			log.error(Proyt99A, YHmxVk6h);
			throw new AdaptationException(Proyt99A, YHmxVk6h);
		} finally {
			try {
				gVlXDExi.close();
			} catch (Exception YBny84c2) {
			}
			try {
				mopJYs5b.close();
			} catch (Exception FuPU4vha) {
			}
			try {
				JiSFxHmK.close();
			} catch (Exception yATZAjin) {
			}
		}
		return QZrbwTo1;
	}

}