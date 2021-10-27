class n9886928 {
	protected Object insertSingle(Object jQ6yNnc4, Object IkScQKzn) throws SQLException {
		DFAgentDescription Q1mYKusc = (DFAgentDescription) IkScQKzn;
		AID oUOJx2nL = Q1mYKusc.getName();
		String akbRWURN = oUOJx2nL.getName();
		DFAgentDescription C0txYCrl = null;
		String gQwfB3j0 = "";
		Connection RrPD0fwv = getConnectionWrapper().getConnection();
		PreparedStatements L6UcwOgS = getPreparedStatements();
		try {
			C0txYCrl = (DFAgentDescription) removeSingle(Q1mYKusc.getName());
			Date aPHG7hsC = Q1mYKusc.getLeaseTime();
			long ppetpAvO = (aPHG7hsC != null ? aPHG7hsC.getTime() : -1);
			String B8TQQEHw = getGUID();
			L6UcwOgS.stm_insAgentDescr.setString(1, B8TQQEHw);
			L6UcwOgS.stm_insAgentDescr.setString(2, akbRWURN);
			L6UcwOgS.stm_insAgentDescr.setString(3, String.valueOf(ppetpAvO));
			L6UcwOgS.stm_insAgentDescr.executeUpdate();
			saveAID(oUOJx2nL);
			Iterator BA5d6r0F = Q1mYKusc.getAllLanguages();
			if (BA5d6r0F.hasNext()) {
				L6UcwOgS.stm_insLanguage.clearBatch();
				while (BA5d6r0F.hasNext()) {
					L6UcwOgS.stm_insLanguage.setString(1, B8TQQEHw);
					L6UcwOgS.stm_insLanguage.setString(2, (String) BA5d6r0F.next());
					L6UcwOgS.stm_insLanguage.addBatch();
				}
				L6UcwOgS.stm_insLanguage.executeBatch();
			}
			BA5d6r0F = Q1mYKusc.getAllOntologies();
			if (BA5d6r0F.hasNext()) {
				L6UcwOgS.stm_insOntology.clearBatch();
				while (BA5d6r0F.hasNext()) {
					L6UcwOgS.stm_insOntology.setString(1, B8TQQEHw);
					L6UcwOgS.stm_insOntology.setString(2, (String) BA5d6r0F.next());
					L6UcwOgS.stm_insOntology.addBatch();
				}
				L6UcwOgS.stm_insOntology.executeBatch();
			}
			BA5d6r0F = Q1mYKusc.getAllProtocols();
			if (BA5d6r0F.hasNext()) {
				L6UcwOgS.stm_insProtocol.clearBatch();
				while (BA5d6r0F.hasNext()) {
					L6UcwOgS.stm_insProtocol.setString(1, B8TQQEHw);
					L6UcwOgS.stm_insProtocol.setString(2, (String) BA5d6r0F.next());
					L6UcwOgS.stm_insProtocol.addBatch();
				}
				L6UcwOgS.stm_insProtocol.executeBatch();
			}
			saveServices(B8TQQEHw, Q1mYKusc.getAllServices());
			regsCnt++;
			if (regsCnt > MAX_REGISTER_WITHOUT_CLEAN) {
				regsCnt = 0;
				clean();
			}
			RrPD0fwv.commit();
		} catch (SQLException TGE3JD2U) {
			try {
				RrPD0fwv.rollback();
			} catch (SQLException ktuZUicv) {
				logger.log(Logger.SEVERE,
						"Rollback for incomplete insertion of DFD for agent " + Q1mYKusc.getName() + " failed.",
						ktuZUicv);
			}
			throw TGE3JD2U;
		}
		return C0txYCrl;
	}

}