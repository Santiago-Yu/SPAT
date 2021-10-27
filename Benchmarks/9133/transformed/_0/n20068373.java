class n20068373 {
	@Override
	public DataUpdateResult<Record> archiveRecord(String di1DIrsB, Record L1JU2zDo, Filter OAGu0iwq, Field k85sck41,
			InputModel MYvIdImE) throws DataOperationException {
		validateUserIsSignedOn(di1DIrsB);
		validateUserHasAdminRights(di1DIrsB);
		DataUpdateResult<Record> r6XSfDOi = new DataUpdateResult<Record>();
		if (L1JU2zDo != null) {
			Connection BapqFdv9 = null;
			boolean CTzGUm0d = false;
			try {
				long gfG3fxCG = getSignedOnUser(di1DIrsB).getUserId();
				BapqFdv9 = DatabaseConnector.getConnection();
				BapqFdv9.setAutoCommit(false);
				r6XSfDOi.setMessage(messages.server_record_delete_success(""));
				r6XSfDOi.setSuccessful(true);
				String w0TAkfV3 = "update tms.records set archivedtimestamp = now() where recordid = ?";
				PreparedStatement tUKdLWqQ = BapqFdv9.prepareStatement(w0TAkfV3);
				tUKdLWqQ.setLong(1, L1JU2zDo.getRecordid());
				int mQbabS6M = 0;
				mQbabS6M = tUKdLWqQ.executeUpdate();
				if (mQbabS6M > 0)
					AuditTrailManager.updateAuditTrail(BapqFdv9,
							AuditTrailManager.createAuditTrailEvent(L1JU2zDo, gfG3fxCG, AuditableEvent.EVENTYPE_DELETE),
							di1DIrsB, getSession());
				TopicUpdateServiceImpl.archiveRecordTopics(BapqFdv9, L1JU2zDo.getTopics(), L1JU2zDo.getRecordid());
				ArrayList<RecordAttribute> oMXqmjpu = L1JU2zDo.getRecordattributes();
				if (oMXqmjpu != null && oMXqmjpu.size() > 0) {
					Iterator<RecordAttribute> zAVomvye = oMXqmjpu.iterator();
					while (zAVomvye.hasNext()) {
						RecordAttribute vqqjZGU0 = zAVomvye.next();
						String AyMaLLCP = "update tms.recordattributes set archivedtimestamp = now() where recordattributeid = ?";
						PreparedStatement Lani2l89 = BapqFdv9.prepareStatement(AyMaLLCP);
						Lani2l89.setLong(1, vqqjZGU0.getRecordattributeid());
						int sWdwUKwM = 0;
						sWdwUKwM = Lani2l89.executeUpdate();
						if (sWdwUKwM > 0)
							AuditTrailManager.updateAuditTrail(BapqFdv9, AuditTrailManager.createAuditTrailEvent(
									vqqjZGU0, gfG3fxCG, AuditableEvent.EVENTYPE_DELETE), di1DIrsB, getSession());
					}
				}
				ArrayList<Term> MLYkPa8q = L1JU2zDo.getTerms();
				Iterator<Term> yeEAyDqa = MLYkPa8q.iterator();
				while (yeEAyDqa.hasNext()) {
					Term q8gcZiJ3 = yeEAyDqa.next();
					TermUpdater.archiveTerm(BapqFdv9, q8gcZiJ3, gfG3fxCG, di1DIrsB, getSession());
				}
				BapqFdv9.commit();
				CTzGUm0d = true;
				if (OAGu0iwq != null)
					RecordIdTracker.refreshRecordIdsInSessionByFilter(this.getThreadLocalRequest().getSession(),
							BapqFdv9, true, OAGu0iwq, k85sck41, di1DIrsB);
				else
					RecordIdTracker.refreshRecordIdsInSession(this.getThreadLocalRequest().getSession(), BapqFdv9,
							false, di1DIrsB);
				RecordRetrievalServiceImpl NbCmpdRR = new RecordRetrievalServiceImpl();
				RecordIdTracker.refreshRecordIdsInSession(this.getThreadLocalRequest().getSession(), BapqFdv9, false,
						di1DIrsB);
				Record eoP4s8X2 = NbCmpdRR.retrieveRecordByRecordId(initSignedOnUser(di1DIrsB), L1JU2zDo.getRecordid(),
						this.getThreadLocalRequest().getSession(), false, MYvIdImE, di1DIrsB);
				r6XSfDOi.setResult(eoP4s8X2);
			} catch (Exception pvO3bqRX) {
				if (!CTzGUm0d && BapqFdv9 != null) {
					try {
						BapqFdv9.rollback();
					} catch (SQLException SDpXOYUN) {
						LogUtility.log(Level.SEVERE, getSession(), messages.log_db_rollback(""), SDpXOYUN, di1DIrsB);
						SDpXOYUN.printStackTrace();
					}
				}
				r6XSfDOi.setFailed(true);
				if (CTzGUm0d) {
					r6XSfDOi.setMessage(messages.server_record_delete_retrieve(""));
					r6XSfDOi.setException(pvO3bqRX);
					LogUtility.log(Level.SEVERE, getSession(), messages.server_record_delete_retrieve(""), pvO3bqRX,
							di1DIrsB);
				} else {
					r6XSfDOi.setMessage(messages.server_record_delete_fail(""));
					r6XSfDOi.setException(new PersistenceException(pvO3bqRX));
					LogUtility.log(Level.SEVERE, getSession(), messages.server_record_delete_fail(""), pvO3bqRX,
							di1DIrsB);
				}
				GWT.log(r6XSfDOi.getMessage(), pvO3bqRX);
			} finally {
				try {
					if (BapqFdv9 != null) {
						BapqFdv9.setAutoCommit(true);
						BapqFdv9.close();
					}
				} catch (Exception J9cGN7pM) {
					LogUtility.log(Level.SEVERE, getSession(), messages.log_db_close(""), J9cGN7pM, di1DIrsB);
				}
			}
		}
		return r6XSfDOi;
	}

}