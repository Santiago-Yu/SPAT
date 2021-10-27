class n7704001 {
	public void deleteGroupInstruction(int DIdWqYf8, int ZX5eDB65)
			throws FidoDatabaseException, InstructionNotFoundException {
		try {
			Connection VzuBG1Ga = null;
			Statement nXDRGna8 = null;
			try {
				VzuBG1Ga = fido.util.FidoDataSource.getConnection();
				VzuBG1Ga.setAutoCommit(false);
				nXDRGna8 = VzuBG1Ga.createStatement();
				String tUnDXwzO = "delete from InstructionGroups " + "where InstructionId = " + DIdWqYf8
						+ " and Rank = " + ZX5eDB65;
				nXDRGna8.executeUpdate(tUnDXwzO);
				bumpAllRowsUp(nXDRGna8, DIdWqYf8, ZX5eDB65);
				VzuBG1Ga.commit();
			} catch (SQLException KCrQmHJg) {
				if (VzuBG1Ga != null)
					VzuBG1Ga.rollback();
				throw KCrQmHJg;
			} finally {
				if (nXDRGna8 != null)
					nXDRGna8.close();
				if (VzuBG1Ga != null)
					VzuBG1Ga.close();
			}
		} catch (SQLException I5wfi4fb) {
			throw new FidoDatabaseException(I5wfi4fb);
		}
	}

}