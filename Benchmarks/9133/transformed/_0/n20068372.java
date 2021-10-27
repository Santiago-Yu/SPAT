class n20068372 {
	@Override
	public DataUpdateResult<Record> updateRecord(String BrXVUjFs, Record J86527bl, Filter lhlUw0ut, Field fjHdnSZF,
			InputModel ZoJ17hAd) throws DataOperationException {
		validateUserIsSignedOn(BrXVUjFs);
		DataUpdateResult<Record> ImmhhUJN = new DataUpdateResult<Record>();
		HttpSession W2imbVRx = getSession();
		if (J86527bl != null) {
			Connection GLzMrnAw = null;
			boolean RECtt4H9 = false;
			try {
				GLzMrnAw = DatabaseConnector.getConnection();
				GLzMrnAw.setAutoCommit(false);
				ImmhhUJN.setMessage(messages.server_record_update_success(""));
				ImmhhUJN.setSuccessful(true);
				long iX04S8tf = getSignedOnUser(BrXVUjFs).getUserId();
				AuditTrailManager.updateAuditTrail(GLzMrnAw,
						AuditTrailManager.createAuditTrailEvent(J86527bl, iX04S8tf, AuditableEvent.EVENTYPE_UPDATE),
						BrXVUjFs, W2imbVRx);
				if (J86527bl.isTopicsChanged()) {
					ArrayList<Topic> idbBIENY = TopicRetrievalServiceImpl.getTopics(J86527bl.getRecordid(),
							getSession(), BrXVUjFs);
					TopicUpdateServiceImpl.removeRecordTopics(GLzMrnAw, idbBIENY, J86527bl.getRecordid());
					TopicUpdateServiceImpl.insertRecordTopics(GLzMrnAw, J86527bl.getTopics(), J86527bl.getRecordid());
				}
				ArrayList<RecordAttribute> aSUJ9aOi = J86527bl.getRecordattributes();
				if (aSUJ9aOi != null && aSUJ9aOi.size() > 0) {
					Iterator<RecordAttribute> to1yTE7L = aSUJ9aOi.iterator();
					while (to1yTE7L.hasNext()) {
						RecordAttribute vyTaozW7 = to1yTE7L.next();
						if (vyTaozW7.getRecordattributeid() > 0) {
							if (vyTaozW7.getArchivedtimestamp() == null) {
								String Rf3o1djQ = "update tms.recordattributes set chardata = ? "
										+ "where recordattributeid = ?";
								PreparedStatement QJcC5dDZ = GLzMrnAw.prepareStatement(Rf3o1djQ);
								QJcC5dDZ.setString(1, vyTaozW7.getChardata());
								QJcC5dDZ.setLong(2, vyTaozW7.getRecordattributeid());
								QJcC5dDZ.executeUpdate();
								AuditTrailManager.updateAuditTrail(GLzMrnAw, AuditTrailManager.createAuditTrailEvent(
										vyTaozW7, iX04S8tf, AuditableEvent.EVENTYPE_UPDATE), BrXVUjFs, W2imbVRx);
							} else {
								String abLcHrpZ = "update tms.recordattributes set archivedtimestamp = now() where  recordattributeid = ?";
								PreparedStatement KqhBndkU = GLzMrnAw.prepareStatement(abLcHrpZ);
								KqhBndkU.setLong(1, vyTaozW7.getRecordattributeid());
								KqhBndkU.executeUpdate();
								AuditTrailManager.updateAuditTrail(GLzMrnAw, AuditTrailManager.createAuditTrailEvent(
										vyTaozW7, iX04S8tf, AuditableEvent.EVENTYPE_DELETE), BrXVUjFs, W2imbVRx);
							}
						} else {
							String u9qCBFTq = "insert into tms.recordattributes "
									+ "(inputmodelfieldid, chardata, recordid) "
									+ "values (?, ?, ?) returning recordattributeid";
							PreparedStatement qJLGRCNY = GLzMrnAw.prepareStatement(u9qCBFTq);
							qJLGRCNY.setLong(1, vyTaozW7.getInputmodelfieldid());
							qJLGRCNY.setString(2, vyTaozW7.getChardata());
							qJLGRCNY.setLong(3, J86527bl.getRecordid());
							ResultSet BT4QInxX = qJLGRCNY.executeQuery();
							if (BT4QInxX.next()) {
								long einSRRZY = BT4QInxX.getLong("recordattributeid");
								vyTaozW7.setRecordattributeid(einSRRZY);
								AuditTrailManager.updateAuditTrail(GLzMrnAw, AuditTrailManager.createAuditTrailEvent(
										vyTaozW7, iX04S8tf, AuditableEvent.EVENTYPE_CREATE), BrXVUjFs, W2imbVRx);
							}
						}
					}
				}
				ArrayList<Term> RjhB4Pfv = J86527bl.getTerms();
				Iterator<Term> dMx49AW8 = RjhB4Pfv.iterator();
				while (dMx49AW8.hasNext()) {
					Term qZwrqrnw = dMx49AW8.next();
					if (qZwrqrnw.getTermid() != -1)
						TermUpdater.updateTerm(GLzMrnAw, qZwrqrnw, iX04S8tf, BrXVUjFs, getSession());
					else {
						TermAdditionServiceImpl CuP2iwRZ = new TermAdditionServiceImpl();
						CuP2iwRZ.addTerm(GLzMrnAw, qZwrqrnw, iX04S8tf, BrXVUjFs, W2imbVRx);
					}
				}
				GLzMrnAw.commit();
				RECtt4H9 = true;
				if (lhlUw0ut != null)
					RecordIdTracker.refreshRecordIdsInSessionByFilter(W2imbVRx, GLzMrnAw, true, lhlUw0ut, fjHdnSZF,
							BrXVUjFs);
				else
					RecordIdTracker.refreshRecordIdsInSession(W2imbVRx, GLzMrnAw, false, BrXVUjFs);
				RecordRetrievalServiceImpl QtGhT2VG = new RecordRetrievalServiceImpl();
				Record FbwNhCSa = QtGhT2VG.retrieveRecordByRecordId(initSignedOnUser(BrXVUjFs), J86527bl.getRecordid(),
						W2imbVRx, false, ZoJ17hAd, BrXVUjFs);
				ImmhhUJN.setResult(FbwNhCSa);
			} catch (Exception YYjxwnhK) {
				if (!RECtt4H9 && GLzMrnAw != null) {
					try {
						GLzMrnAw.rollback();
					} catch (SQLException DMmDtiSc) {
						LogUtility.log(Level.SEVERE, W2imbVRx, messages.log_db_rollback(""), DMmDtiSc, BrXVUjFs);
						DMmDtiSc.printStackTrace();
					}
				}
				ImmhhUJN.setFailed(true);
				if (RECtt4H9) {
					ImmhhUJN.setMessage(messages.server_record_update_retrieve(""));
					ImmhhUJN.setException(YYjxwnhK);
					LogUtility.log(Level.SEVERE, W2imbVRx, messages.server_record_update_retrieve(""), YYjxwnhK,
							BrXVUjFs);
				} else {
					ImmhhUJN.setMessage(messages.server_record_update_fail(""));
					ImmhhUJN.setException(new PersistenceException(YYjxwnhK));
					LogUtility.log(Level.SEVERE, W2imbVRx, messages.server_record_update_fail(""), YYjxwnhK, BrXVUjFs);
				}
				GWT.log(ImmhhUJN.getMessage(), YYjxwnhK);
			} finally {
				try {
					if (GLzMrnAw != null) {
						GLzMrnAw.setAutoCommit(true);
						GLzMrnAw.close();
					}
				} catch (Exception DXdaNMQP) {
					LogUtility.log(Level.SEVERE, W2imbVRx, messages.log_db_close(""), DXdaNMQP, BrXVUjFs);
				}
			}
		}
		return ImmhhUJN;
	}

}