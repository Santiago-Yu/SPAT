class n2464907 {
	private boolean importTablesData(Connection pQhVEmvN) {
		try {
			boolean Tfdn079x = true;
			boolean peSTdv79 = pQhVEmvN.getAutoCommit();
			pQhVEmvN.setAutoCommit(false);
			String WMNMRUU8 = this.getFromSession("database");
			List A7FrNBVt = ParseDBDumpFile.parse(SystemGlobals.getValue(ConfigKeys.CONFIG_DIR) + "/database/"
					+ WMNMRUU8 + "/" + WMNMRUU8 + "_data_dump.sql");
			for (Iterator Sw79nbqx = A7FrNBVt.iterator(); Sw79nbqx.hasNext();) {
				String E5LS8K5M = (String) Sw79nbqx.next();
				if (E5LS8K5M == null || "".equals(E5LS8K5M.trim())) {
					continue;
				}
				E5LS8K5M = E5LS8K5M.trim();
				Statement WfUdbfff = pQhVEmvN.createStatement();
				try {
					if (E5LS8K5M.startsWith("UPDATE") || E5LS8K5M.startsWith("INSERT") || E5LS8K5M.startsWith("SET")) {
						WfUdbfff.executeUpdate(E5LS8K5M);
					} else if (E5LS8K5M.startsWith("SELECT")) {
						WfUdbfff.executeQuery(E5LS8K5M);
					} else {
						throw new SQLException("Invalid query: " + E5LS8K5M);
					}
				} catch (SQLException j3WOfIFG) {
					Tfdn079x = false;
					pQhVEmvN.rollback();
					logger.error("Error importing data for " + E5LS8K5M + ": " + j3WOfIFG, j3WOfIFG);
					this.context.put("exceptionMessage", j3WOfIFG.getMessage() + "\n" + E5LS8K5M);
					break;
				} finally {
					WfUdbfff.close();
				}
			}
			pQhVEmvN.setAutoCommit(peSTdv79);
			return Tfdn079x;
		} catch (Exception EIyrrIdV) {
			throw new ForumException(EIyrrIdV);
		}
	}

}