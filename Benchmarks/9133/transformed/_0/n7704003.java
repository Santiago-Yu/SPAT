class n7704003 {
	public void moveRowUp(int f3RifzmP, int ySVc0E37) throws FidoDatabaseException {
		try {
			Connection e1Blu1rZ = null;
			Statement tkChETxn = null;
			try {
				e1Blu1rZ = fido.util.FidoDataSource.getConnection();
				e1Blu1rZ.setAutoCommit(false);
				tkChETxn = e1Blu1rZ.createStatement();
				int pRDtxUi3 = findMaxRank(tkChETxn, f3RifzmP);
				if ((ySVc0E37 < 2) || (ySVc0E37 > pRDtxUi3))
					throw new IllegalArgumentException("Row number not between 2 and " + pRDtxUi3);
				tkChETxn.executeUpdate("update InstructionGroups set Rank = -1 where InstructionId = '" + f3RifzmP
						+ "' and Rank = " + ySVc0E37);
				tkChETxn.executeUpdate("update InstructionGroups set Rank = " + ySVc0E37 + " where InstructionId = '"
						+ f3RifzmP + "' and Rank = " + (ySVc0E37 - 1));
				tkChETxn.executeUpdate("update InstructionGroups set Rank = " + (ySVc0E37 - 1)
						+ " where InstructionId = '" + f3RifzmP + "' and Rank = -1");
				e1Blu1rZ.commit();
			} catch (SQLException ck0NEODu) {
				if (e1Blu1rZ != null)
					e1Blu1rZ.rollback();
				throw ck0NEODu;
			} finally {
				if (tkChETxn != null)
					tkChETxn.close();
				if (e1Blu1rZ != null)
					e1Blu1rZ.close();
			}
		} catch (SQLException YSQtLLDA) {
			throw new FidoDatabaseException(YSQtLLDA);
		}
	}

}