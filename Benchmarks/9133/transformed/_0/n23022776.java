class n23022776 {
	public Long processAddHolding(Holding PNubiAsR, AuthSession skiKbkF3) {
		if (skiKbkF3 == null) {
			return null;
		}
		PreparedStatement rQJlehsc = null;
		DatabaseAdapter gH8rd2uo = null;
		try {
			gH8rd2uo = DatabaseAdapter.getInstance();
			CustomSequenceType NmqR2Rzr = new CustomSequenceType();
			NmqR2Rzr.setSequenceName("seq_WM_LIST_HOLDING");
			NmqR2Rzr.setTableName("WM_LIST_HOLDING");
			NmqR2Rzr.setColumnName("ID_HOLDING");
			Long rDyuA2ij = gH8rd2uo.getSequenceNextValue(NmqR2Rzr);
			rQJlehsc = gH8rd2uo
					.prepareStatement("insert into WM_LIST_HOLDING " + "( ID_HOLDING, full_name_HOLDING, NAME_HOLDING )"
							+ "values " + (gH8rd2uo.getIsNeedUpdateBracket() ? "(" : "") + " ?, ?, ? "
							+ (gH8rd2uo.getIsNeedUpdateBracket() ? ")" : ""));
			int vDF7NxYm = 1;
			RsetTools.setLong(rQJlehsc, vDF7NxYm++, rDyuA2ij);
			rQJlehsc.setString(vDF7NxYm++, PNubiAsR.getName());
			rQJlehsc.setString(vDF7NxYm++, PNubiAsR.getShortName());
			int lKHeCTSC = rQJlehsc.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of inserted records - " + lKHeCTSC);
			HoldingBean o0OingHe = new HoldingBean(PNubiAsR);
			o0OingHe.setId(rDyuA2ij);
			processInsertRelatedCompany(gH8rd2uo, o0OingHe, skiKbkF3);
			gH8rd2uo.commit();
			return rDyuA2ij;
		} catch (Exception bgrMKVjI) {
			try {
				if (gH8rd2uo != null)
					gH8rd2uo.rollback();
			} catch (Exception sM0JN8T5) {
			}
			String bDmOFp67 = "Error add new holding";
			log.error(bDmOFp67, bgrMKVjI);
			throw new IllegalStateException(bDmOFp67, bgrMKVjI);
		} finally {
			DatabaseManager.close(gH8rd2uo, rQJlehsc);
			gH8rd2uo = null;
			rQJlehsc = null;
		}
	}

}