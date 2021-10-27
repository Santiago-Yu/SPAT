class n1293657 {
	public void modifyDecisionInstruction(int HeoPUTxg, int hXAgs5Gr, String m077FKSt, String J7mFSrik, int OeHUBXN2,
			String zuWAopQI, int iJN480DV, int FMzS713e)
			throws FidoDatabaseException, ObjectNotFoundException, InstructionNotFoundException {
		try {
			Connection ucjzuK4j = null;
			Statement UkDYgeE6 = null;
			try {
				if ((hXAgs5Gr == ConditionalOperatorTable.CONTAINS_LINK)
						|| (hXAgs5Gr == ConditionalOperatorTable.NOT_CONTAINS_LINK)) {
					ObjectTable BIUCf13P = new ObjectTable();
					if (BIUCf13P.contains(OeHUBXN2) == false)
						throw new ObjectNotFoundException(OeHUBXN2);
				}
				ucjzuK4j = fido.util.FidoDataSource.getConnection();
				ucjzuK4j.setAutoCommit(false);
				UkDYgeE6 = ucjzuK4j.createStatement();
				if (contains(UkDYgeE6, iJN480DV) == false)
					throw new InstructionNotFoundException(iJN480DV);
				if (contains(UkDYgeE6, FMzS713e) == false)
					throw new InstructionNotFoundException(FMzS713e);
				String JYQqiy4w = "update Instructions set Operator = " + hXAgs5Gr + ", "
						+ "                        FrameSlot = '" + m077FKSt + "', "
						+ "                        LinkName = '" + J7mFSrik + "', "
						+ "                        ObjectId = " + OeHUBXN2 + ", "
						+ "                        AttributeName = '" + zuWAopQI + "' " + "where InstructionId = "
						+ HeoPUTxg;
				UkDYgeE6.executeUpdate(JYQqiy4w);
				InstructionGroupTable mXP4i72x = new InstructionGroupTable();
				mXP4i72x.deleteInstruction(UkDYgeE6, HeoPUTxg);
				if (iJN480DV != -1)
					mXP4i72x.addInstructionAt(UkDYgeE6, HeoPUTxg, 1, iJN480DV);
				if (FMzS713e != -1)
					mXP4i72x.addInstructionAt(UkDYgeE6, HeoPUTxg, 2, FMzS713e);
				ucjzuK4j.commit();
			} catch (SQLException LD4TI44y) {
				if (ucjzuK4j != null)
					ucjzuK4j.rollback();
				throw LD4TI44y;
			} finally {
				if (UkDYgeE6 != null)
					UkDYgeE6.close();
				if (ucjzuK4j != null)
					ucjzuK4j.close();
			}
		} catch (SQLException CiAhDEQ3) {
			throw new FidoDatabaseException(CiAhDEQ3);
		}
	}

}