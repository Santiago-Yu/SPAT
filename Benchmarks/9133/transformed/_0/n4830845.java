class n4830845 {
	@Override
	public synchronized void deleteCallStatistics(Integer lX6HDYI7, String IcJljJWd, String T245HEqV, String i17dRhHR,
			String RYqJcDZO, Date EepLPTfp, Date O2SYt1yq, Boolean qsYAUABH, String K9apAXMA) throws DatabaseException {
		final Connection nNjUP2LM = this.getConnection();
		try {
			nNjUP2LM.setAutoCommit(false);
			String PJEKXT31 = "DELETE " + this.getCallInvocationsSchemaAndTableName() + " FROM "
					+ this.getCallInvocationsSchemaAndTableName() + " INNER JOIN "
					+ this.getCallElementsSchemaAndTableName() + " ON " + this.getCallElementsSchemaAndTableName()
					+ ".element_id =  " + this.getCallInvocationsSchemaAndTableName() + ".element_id ";
			if (K9apAXMA != null) {
				PJEKXT31 = PJEKXT31 + "LEFT JOIN " + this.getCallPrincipalsSchemaAndTableName() + " ON "
						+ this.getCallInvocationsSchemaAndTableName() + ".principal_id = "
						+ this.getCallPrincipalsSchemaAndTableName() + ".principal_id ";
			}
			PJEKXT31 = PJEKXT31 + "WHERE ";
			if (lX6HDYI7 != null) {
				PJEKXT31 = PJEKXT31 + this.getCallElementsSchemaAndTableName() + ".elementId = ? AND ";
			}
			if (IcJljJWd != null) {
				PJEKXT31 = PJEKXT31 + this.getCallElementsSchemaAndTableName() + ".context_name LIKE ? AND ";
			}
			if ((T245HEqV != null)) {
				PJEKXT31 = PJEKXT31 + this.getCallElementsSchemaAndTableName() + ".category LIKE ? AND ";
			}
			if ((i17dRhHR != null)) {
				PJEKXT31 = PJEKXT31 + this.getCallElementsSchemaAndTableName() + ".project LIKE ? AND ";
			}
			if ((RYqJcDZO != null)) {
				PJEKXT31 = PJEKXT31 + this.getCallElementsSchemaAndTableName() + ".name LIKE ? AND ";
			}
			if (EepLPTfp != null) {
				PJEKXT31 = PJEKXT31 + this.getCallInvocationsSchemaAndTableName() + ".start_timestamp >= ? AND ";
			}
			if (O2SYt1yq != null) {
				PJEKXT31 = PJEKXT31 + this.getCallInvocationsSchemaAndTableName() + ".start_timestamp <= ? AND ";
			}
			if (K9apAXMA != null) {
				PJEKXT31 = PJEKXT31 + this.getCallPrincipalsSchemaAndTableName() + ".principal_name LIKE ? AND ";
			}
			if (qsYAUABH != null) {
				if (qsYAUABH.booleanValue()) {
					PJEKXT31 = PJEKXT31 + this.getCallInvocationsSchemaAndTableName()
							+ ".exception_id IS NOT NULL AND ";
				} else {
					PJEKXT31 = PJEKXT31 + this.getCallInvocationsSchemaAndTableName() + ".exception_id IS NULL AND ";
				}
			}
			PJEKXT31 = DefaultDatabaseHandler.removeOrphanWhereAndAndFromSelect(PJEKXT31);
			final PreparedStatement THQNC9Yx = DebugPreparedStatement.prepareStatement(nNjUP2LM, PJEKXT31);
			int LmGgKlQx = 1;
			if (lX6HDYI7 != null) {
				THQNC9Yx.setLong(LmGgKlQx, lX6HDYI7.longValue());
				LmGgKlQx = LmGgKlQx + 1;
			}
			if (IcJljJWd != null) {
				THQNC9Yx.setString(LmGgKlQx, IcJljJWd);
				LmGgKlQx = LmGgKlQx + 1;
			}
			if ((T245HEqV != null)) {
				THQNC9Yx.setString(LmGgKlQx, T245HEqV);
				LmGgKlQx = LmGgKlQx + 1;
			}
			if ((i17dRhHR != null)) {
				THQNC9Yx.setString(LmGgKlQx, i17dRhHR);
				LmGgKlQx = LmGgKlQx + 1;
			}
			if ((RYqJcDZO != null)) {
				THQNC9Yx.setString(LmGgKlQx, RYqJcDZO);
				LmGgKlQx = LmGgKlQx + 1;
			}
			if (EepLPTfp != null) {
				THQNC9Yx.setTimestamp(LmGgKlQx, new Timestamp(EepLPTfp.getTime()));
				LmGgKlQx = LmGgKlQx + 1;
			}
			if (O2SYt1yq != null) {
				THQNC9Yx.setTimestamp(LmGgKlQx, new Timestamp(O2SYt1yq.getTime()));
				LmGgKlQx = LmGgKlQx + 1;
			}
			if (K9apAXMA != null) {
				THQNC9Yx.setString(LmGgKlQx, K9apAXMA);
				LmGgKlQx = LmGgKlQx + 1;
			}
			THQNC9Yx.executeUpdate();
			THQNC9Yx.close();
			nNjUP2LM.commit();
		} catch (final SQLException EYqdBmlo) {
			try {
				nNjUP2LM.rollback();
			} catch (final SQLException j0oYM4fq) {
				JeeObserverServerContext.logger.log(Level.SEVERE, "Transaction rollback error.", j0oYM4fq);
			}
			JeeObserverServerContext.logger.log(Level.SEVERE, EYqdBmlo.getMessage());
			throw new DatabaseException("Error deleting call statistics.", EYqdBmlo);
		} finally {
			this.releaseConnection(nNjUP2LM);
		}
	}

}