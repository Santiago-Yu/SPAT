class n1293656 {
	public int addDecisionInstruction(int rBwbLVKA, String hL1C8uN8, String RNNtybIx, int c6pxpOn9, String FbjRVinW,
			int WkudiR0F, int Yc6ckH1D)
			throws FidoDatabaseException, ObjectNotFoundException, InstructionNotFoundException {
		try {
			Connection CsGOxYL3 = null;
			Statement VaxRTHuv = null;
			try {
				if ((rBwbLVKA == ConditionalOperatorTable.CONTAINS_LINK)
						|| (rBwbLVKA == ConditionalOperatorTable.NOT_CONTAINS_LINK)) {
					ObjectTable AKHlkzv2 = new ObjectTable();
					if (AKHlkzv2.contains(c6pxpOn9) == false)
						throw new ObjectNotFoundException(c6pxpOn9);
				}
				CsGOxYL3 = fido.util.FidoDataSource.getConnection();
				CsGOxYL3.setAutoCommit(false);
				VaxRTHuv = CsGOxYL3.createStatement();
				if (contains(VaxRTHuv, WkudiR0F) == false)
					throw new InstructionNotFoundException(WkudiR0F);
				if (contains(VaxRTHuv, Yc6ckH1D) == false)
					throw new InstructionNotFoundException(Yc6ckH1D);
				String HxOUXAkC = "insert into Instructions (Type, Operator, FrameSlot, LinkName, ObjectId, AttributeName) "
						+ "values (2, " + rBwbLVKA + ", '" + hL1C8uN8 + "', '" + RNNtybIx + "', " + c6pxpOn9 + ", '"
						+ FbjRVinW + "')";
				VaxRTHuv.executeUpdate(HxOUXAkC);
				int hR50zXTD = getCurrentId(VaxRTHuv);
				InstructionGroupTable Lhzqk81o = new InstructionGroupTable();
				Lhzqk81o.deleteInstruction(VaxRTHuv, hR50zXTD);
				if (WkudiR0F != -1)
					Lhzqk81o.addInstructionAt(VaxRTHuv, hR50zXTD, 1, WkudiR0F);
				if (Yc6ckH1D != -1)
					Lhzqk81o.addInstructionAt(VaxRTHuv, hR50zXTD, 2, Yc6ckH1D);
				CsGOxYL3.commit();
				return hR50zXTD;
			} catch (SQLException ht6YJuDx) {
				if (CsGOxYL3 != null)
					CsGOxYL3.rollback();
				throw ht6YJuDx;
			} finally {
				if (VaxRTHuv != null)
					VaxRTHuv.close();
				if (CsGOxYL3 != null)
					CsGOxYL3.close();
			}
		} catch (SQLException daqjjLkA) {
			throw new FidoDatabaseException(daqjjLkA);
		}
	}

}