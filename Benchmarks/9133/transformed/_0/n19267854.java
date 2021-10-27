class n19267854 {
	public static void insertTableData(Connection h9hrYxNr, TableMetaData Bfq5Vkob) throws Exception {
		PreparedStatement TFaGM7r7 = null;
		try {
			h9hrYxNr.setAutoCommit(false);
			String GFwD0ZcS = "INSERT INTO " + Bfq5Vkob.getSchema() + "." + Bfq5Vkob.getTableName() + " (";
			for (String t596TdBf : Bfq5Vkob.getColumnsNames()) {
				GFwD0ZcS += t596TdBf + ",";
			}
			GFwD0ZcS = GFwD0ZcS.substring(0, GFwD0ZcS.length() - 1);
			GFwD0ZcS += ") VALUES (";
			for (String iWwj3ZN3 : Bfq5Vkob.getColumnsNames()) {
				GFwD0ZcS += "?" + ",";
			}
			GFwD0ZcS = GFwD0ZcS.substring(0, GFwD0ZcS.length() - 1);
			GFwD0ZcS += ")";
			IOHelper.writeInfo(GFwD0ZcS);
			TFaGM7r7 = h9hrYxNr.prepareStatement(GFwD0ZcS);
			for (Row KSXb7gPp : Bfq5Vkob.getData()) {
				try {
					int waCO4koQ = 1;
					for (String x84E7fIL : Bfq5Vkob.getColumnsNames()) {
						if (h9hrYxNr instanceof OracleConnection) {
							if (Bfq5Vkob.getColumnsTypes().get(x84E7fIL).equalsIgnoreCase("BLOB")) {
								BLOB dUIbdFCE = new BLOB((OracleConnection) h9hrYxNr,
										(byte[]) KSXb7gPp.getRowData().get(x84E7fIL));
								((OraclePreparedStatement) TFaGM7r7).setBLOB(waCO4koQ, dUIbdFCE);
							} else if (Bfq5Vkob.getColumnsTypes().get(x84E7fIL).equalsIgnoreCase("CLOB")) {
								((OraclePreparedStatement) TFaGM7r7).setStringForClob(waCO4koQ,
										(String) KSXb7gPp.getRowData().get(x84E7fIL));
							} else if (Bfq5Vkob.getColumnsTypes().get(x84E7fIL).equalsIgnoreCase("LONG")) {
								TFaGM7r7.setBytes(waCO4koQ, (byte[]) KSXb7gPp.getRowData().get(x84E7fIL));
							}
						} else {
							IOHelper.writeInfo(x84E7fIL + " = " + KSXb7gPp.getRowData().get(x84E7fIL));
							TFaGM7r7.setObject(waCO4koQ, KSXb7gPp.getRowData().get(x84E7fIL));
						}
						waCO4koQ++;
					}
					if (TFaGM7r7.executeUpdate() != 1) {
						h9hrYxNr.rollback();
						updateTableData(h9hrYxNr, Bfq5Vkob, KSXb7gPp);
					}
				} catch (Exception ZOrt8yDm) {
					try {
						h9hrYxNr.rollback();
						updateTableData(h9hrYxNr, Bfq5Vkob, KSXb7gPp);
					} catch (Exception fvwPwZDy) {
						IOHelper.writeError("Error in update " + GFwD0ZcS, fvwPwZDy);
					}
				}
				TFaGM7r7.clearParameters();
			}
			h9hrYxNr.commit();
			h9hrYxNr.setAutoCommit(true);
		} finally {
			if (TFaGM7r7 != null)
				TFaGM7r7.close();
		}
	}

}