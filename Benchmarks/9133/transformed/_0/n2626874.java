class n2626874 {
	public static ResultSet execute(String wx0OTpcR) {
		ResultSet amKnnGPE = null;
		BufferedReader mXFABRTM = new BufferedReader(new StringReader(wx0OTpcR));
		String brdbKI0k = null;
		Connection Xr4kukt4 = ConnPool.getConnection();
		try {
			Statement CBidl6Ve = Xr4kukt4.createStatement();
			while ((brdbKI0k = mXFABRTM.readLine()) != null) {
				brdbKI0k = brdbKI0k.toLowerCase().trim();
				if (brdbKI0k.equals("") || brdbKI0k.startsWith("#")) {
					continue;
				}
				if (dmaLogger.isInfoEnabled(SqlExecutor.class)) {
					dmaLogger.logInfo("Executing SQL: " + brdbKI0k, SqlExecutor.class);
				}
				long GGxsCp0Q = System.currentTimeMillis();
				if (brdbKI0k.startsWith("select")) {
					amKnnGPE = CBidl6Ve.executeQuery(brdbKI0k);
				} else {
					CBidl6Ve.executeUpdate(brdbKI0k);
				}
				dmaLogger.logInfo(DateUtil.getElapsedTime("SQL execution of " + brdbKI0k + "  took: ",
						(System.currentTimeMillis() - GGxsCp0Q)), SqlExecutor.class);
			}
			if (amKnnGPE == null) {
				CBidl6Ve.close();
			}
			return amKnnGPE;
		} catch (SQLException mdFJhI2i) {
			try {
				Xr4kukt4.rollback();
			} catch (SQLException imJRpk56) {
			}
			throw new RuntimeException("Execution of " + brdbKI0k + " failed:" + mdFJhI2i.getMessage(), mdFJhI2i);
		} catch (IOException iqWuMCmb) {
			try {
				Xr4kukt4.rollback();
			} catch (SQLException kWyfQPkI) {
			}
			throw new RuntimeException("Execution of " + brdbKI0k + " failed:", iqWuMCmb);
		} finally {
			ConnPool.releaseConnection(Xr4kukt4);
		}
	}

}