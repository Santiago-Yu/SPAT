class n19267855 {
	public static void updateTableData(Connection phIXgfEh, TableMetaData vOCHi9S6) throws Exception {
		PreparedStatement r1FVy9dA = null;
		try {
			phIXgfEh.setAutoCommit(false);
			String mWiHvioS = "UPDATE " + vOCHi9S6.getSchema() + "." + vOCHi9S6.getTableName() + " SET ";
			for (String dhSJyYBz : vOCHi9S6.getColumnsNames()) {
				mWiHvioS += dhSJyYBz + " = ? ,";
			}
			mWiHvioS = mWiHvioS.substring(0, mWiHvioS.length() - 1);
			mWiHvioS += " WHERE ";
			for (String AE2xXURM : vOCHi9S6.getPkColumns()) {
				mWiHvioS += AE2xXURM + " = ? AND ";
			}
			mWiHvioS = mWiHvioS.substring(0, mWiHvioS.length() - 4);
			r1FVy9dA = phIXgfEh.prepareStatement(mWiHvioS);
			for (Row d7Nu9v6I : vOCHi9S6.getData()) {
				int PvjHxmjf = 1;
				for (String L3KpvMTv : vOCHi9S6.getColumnsNames()) {
					if (phIXgfEh instanceof OracleConnection) {
						if (vOCHi9S6.getColumnsTypes().get(L3KpvMTv).equalsIgnoreCase("BLOB")) {
							BLOB izuyQhC1 = new BLOB((OracleConnection) phIXgfEh,
									(byte[]) d7Nu9v6I.getRowData().get(L3KpvMTv));
							((OraclePreparedStatement) r1FVy9dA).setBLOB(PvjHxmjf, izuyQhC1);
						} else if (vOCHi9S6.getColumnsTypes().get(L3KpvMTv).equalsIgnoreCase("CLOB")) {
							((OraclePreparedStatement) r1FVy9dA).setStringForClob(PvjHxmjf,
									(String) d7Nu9v6I.getRowData().get(L3KpvMTv));
						} else if (vOCHi9S6.getColumnsTypes().get(L3KpvMTv).equalsIgnoreCase("LONG")) {
							r1FVy9dA.setBytes(PvjHxmjf, (byte[]) d7Nu9v6I.getRowData().get(L3KpvMTv));
						}
					} else {
						r1FVy9dA.setObject(PvjHxmjf, d7Nu9v6I.getRowData().get(L3KpvMTv));
					}
					PvjHxmjf++;
				}
				for (String zAD4Ylb4 : vOCHi9S6.getPkColumns()) {
					r1FVy9dA.setObject(PvjHxmjf, d7Nu9v6I.getRowData().get(zAD4Ylb4));
					PvjHxmjf++;
				}
				if (r1FVy9dA.executeUpdate() != 1) {
					phIXgfEh.rollback();
					throw new Exception();
				}
				r1FVy9dA.clearParameters();
			}
			phIXgfEh.commit();
			phIXgfEh.setAutoCommit(true);
		} finally {
			if (r1FVy9dA != null)
				r1FVy9dA.close();
		}
	}

}