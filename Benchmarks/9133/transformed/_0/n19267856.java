class n19267856 {
	public static void updateTableData(Connection S2LcWxZp, TableMetaData RwSD7BUJ, Row IP5VFjyN) throws Exception {
		PreparedStatement xuLFWLcj = null;
		try {
			S2LcWxZp.setAutoCommit(false);
			String qOMcl9Hn = "UPDATE " + RwSD7BUJ.getSchema() + "." + RwSD7BUJ.getTableName() + " SET ";
			for (String g5WTtdXg : RwSD7BUJ.getColumnsNames()) {
				qOMcl9Hn += g5WTtdXg + " = ? ,";
			}
			qOMcl9Hn = qOMcl9Hn.substring(0, qOMcl9Hn.length() - 1);
			qOMcl9Hn += " WHERE ";
			for (String CLAobK3D : RwSD7BUJ.getPkColumns()) {
				qOMcl9Hn += CLAobK3D + " = ? AND ";
			}
			qOMcl9Hn = qOMcl9Hn.substring(0, qOMcl9Hn.length() - 4);
			System.out.println("UPDATE: " + qOMcl9Hn);
			xuLFWLcj = S2LcWxZp.prepareStatement(qOMcl9Hn);
			int kfTzXCtp = 1;
			for (String qa4khnOU : RwSD7BUJ.getColumnsNames()) {
				if (S2LcWxZp instanceof OracleConnection) {
					if (RwSD7BUJ.getColumnsTypes().get(qa4khnOU).equalsIgnoreCase("BLOB")) {
						BLOB pzEmM8ac = new BLOB((OracleConnection) S2LcWxZp,
								(byte[]) IP5VFjyN.getRowData().get(qa4khnOU));
						((OraclePreparedStatement) xuLFWLcj).setBLOB(kfTzXCtp, pzEmM8ac);
					} else if (RwSD7BUJ.getColumnsTypes().get(qa4khnOU).equalsIgnoreCase("CLOB")) {
						((OraclePreparedStatement) xuLFWLcj).setStringForClob(kfTzXCtp,
								(String) IP5VFjyN.getRowData().get(qa4khnOU));
					} else if (RwSD7BUJ.getColumnsTypes().get(qa4khnOU).equalsIgnoreCase("LONG")) {
						xuLFWLcj.setBytes(kfTzXCtp, (byte[]) IP5VFjyN.getRowData().get(qa4khnOU));
					}
				} else {
					xuLFWLcj.setObject(kfTzXCtp, IP5VFjyN.getRowData().get(qa4khnOU));
				}
				kfTzXCtp++;
			}
			for (String uaVJkSun : RwSD7BUJ.getPkColumns()) {
				xuLFWLcj.setObject(kfTzXCtp, IP5VFjyN.getRowData().get(uaVJkSun));
				kfTzXCtp++;
			}
			if (xuLFWLcj.executeUpdate() != 1) {
				S2LcWxZp.rollback();
				throw new Exception("Erro no update");
			}
			xuLFWLcj.clearParameters();
			S2LcWxZp.commit();
			S2LcWxZp.setAutoCommit(true);
		} finally {
			if (xuLFWLcj != null)
				xuLFWLcj.close();
		}
	}

}