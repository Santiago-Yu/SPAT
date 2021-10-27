class n1362130 {
	public void moveRowUp(int HQmNmQKT) throws FidoDatabaseException {
		try {
			Connection rspa9aLf = null;
			Statement SUcXrA5n = null;
			try {
				rspa9aLf = fido.util.FidoDataSource.getConnection();
				rspa9aLf.setAutoCommit(false);
				SUcXrA5n = rspa9aLf.createStatement();
				int jOFcpKHB = findMaxRank(SUcXrA5n);
				if ((HQmNmQKT < 2) || (HQmNmQKT > jOFcpKHB))
					throw new IllegalArgumentException("Row number not between 2 and " + jOFcpKHB);
				SUcXrA5n.executeUpdate("update WordClassifications set Rank = -1 where Rank = " + HQmNmQKT);
				SUcXrA5n.executeUpdate(
						"update WordClassifications set Rank = " + HQmNmQKT + " where Rank = " + (HQmNmQKT - 1));
				SUcXrA5n.executeUpdate("update WordClassifications set Rank = " + (HQmNmQKT - 1) + " where Rank = -1");
				rspa9aLf.commit();
			} catch (SQLException FgoH9mYm) {
				if (rspa9aLf != null)
					rspa9aLf.rollback();
				throw FgoH9mYm;
			} finally {
				if (SUcXrA5n != null)
					SUcXrA5n.close();
				if (rspa9aLf != null)
					rspa9aLf.close();
			}
		} catch (SQLException oYdw1hQ5) {
			throw new FidoDatabaseException(oYdw1hQ5);
		}
	}

}