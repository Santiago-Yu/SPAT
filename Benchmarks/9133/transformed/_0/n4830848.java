class n4830848 {
	@Override
	public synchronized void deletePersistenceEntityStatistics(Integer DQZojhs3, String QGYtY8T4, String M9vBj6ob,
			String JhmadpKM, Date vmTyOugd, Date cRju4dsZ) throws DatabaseException {
		final Connection ogX1t4Qr = this.getConnection();
		try {
			ogX1t4Qr.setAutoCommit(false);
			String fbgQYdiJ = "DELETE " + this.getPersistenceEntityStatisticsSchemaAndTableName() + " FROM "
					+ this.getPersistenceEntityStatisticsSchemaAndTableName() + " INNER JOIN "
					+ this.getPersistenceEntityElementsSchemaAndTableName() + " ON "
					+ this.getPersistenceEntityElementsSchemaAndTableName() + ".element_id =  "
					+ this.getPersistenceEntityStatisticsSchemaAndTableName() + ".element_id WHERE ";
			if (DQZojhs3 != null) {
				fbgQYdiJ = fbgQYdiJ + " elementId = ? AND ";
			}
			if (QGYtY8T4 != null) {
				fbgQYdiJ = fbgQYdiJ + " context_name LIKE ? AND ";
			}
			if ((M9vBj6ob != null)) {
				fbgQYdiJ = fbgQYdiJ + " project LIKE ? AND ";
			}
			if ((JhmadpKM != null)) {
				fbgQYdiJ = fbgQYdiJ + " name LIKE ? AND ";
			}
			if (vmTyOugd != null) {
				fbgQYdiJ = fbgQYdiJ + " start_timestamp >= ? AND ";
			}
			if (cRju4dsZ != null) {
				fbgQYdiJ = fbgQYdiJ + " start_timestamp <= ? AND ";
			}
			fbgQYdiJ = DefaultDatabaseHandler.removeOrphanWhereAndAndFromSelect(fbgQYdiJ);
			final PreparedStatement fRjPtAEZ = DebugPreparedStatement.prepareStatement(ogX1t4Qr, fbgQYdiJ);
			int l5YkW6tw = 1;
			if (DQZojhs3 != null) {
				fRjPtAEZ.setLong(l5YkW6tw, DQZojhs3.longValue());
				l5YkW6tw = l5YkW6tw + 1;
			}
			if (QGYtY8T4 != null) {
				fRjPtAEZ.setString(l5YkW6tw, QGYtY8T4);
				l5YkW6tw = l5YkW6tw + 1;
			}
			if ((M9vBj6ob != null)) {
				fRjPtAEZ.setString(l5YkW6tw, M9vBj6ob);
				l5YkW6tw = l5YkW6tw + 1;
			}
			if ((JhmadpKM != null)) {
				fRjPtAEZ.setString(l5YkW6tw, JhmadpKM);
				l5YkW6tw = l5YkW6tw + 1;
			}
			if (vmTyOugd != null) {
				fRjPtAEZ.setTimestamp(l5YkW6tw, new Timestamp(vmTyOugd.getTime()));
				l5YkW6tw = l5YkW6tw + 1;
			}
			if (cRju4dsZ != null) {
				fRjPtAEZ.setTimestamp(l5YkW6tw, new Timestamp(cRju4dsZ.getTime()));
				l5YkW6tw = l5YkW6tw + 1;
			}
			fRjPtAEZ.executeUpdate();
			fRjPtAEZ.close();
			ogX1t4Qr.commit();
		} catch (final SQLException wRvGvBHa) {
			try {
				ogX1t4Qr.rollback();
			} catch (final SQLException j5MfVasE) {
				JeeObserverServerContext.logger.log(Level.SEVERE, "Transaction rollback error.", j5MfVasE);
			}
			JeeObserverServerContext.logger.log(Level.SEVERE, wRvGvBHa.getMessage());
			throw new DatabaseException("Error deleting persistence entity statistics.", wRvGvBHa);
		} finally {
			this.releaseConnection(ogX1t4Qr);
		}
	}

}