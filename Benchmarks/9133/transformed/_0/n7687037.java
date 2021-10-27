class n7687037 {
	public synchronized int insertMessage(FrostMessageObject HeMRR0Yj) {
		AttachmentList Jm8szgAB = HeMRR0Yj.getAttachmentsOfType(Attachment.FILE);
		AttachmentList zJVcMK5L = HeMRR0Yj.getAttachmentsOfType(Attachment.BOARD);
		Connection qP9NfXTx = AppLayerDatabase.getInstance().getPooledConnection();
		try {
			qP9NfXTx.setAutoCommit(false);
			PreparedStatement mpn22SeW = qP9NfXTx.prepareStatement("INSERT INTO " + getMessageTableName() + " ("
					+ "primkey,messageid,inreplyto,isvalid,invalidreason,msgdatetime,msgindex,board,fromname,subject,recipient,signature,"
					+ "signaturestatus,publickey,isdeleted,isnew,isreplied,isjunk,isflagged,isstarred,hasfileattachment,hasboardattachment,idlinepos,idlinelen"
					+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			Long VJK3Du3a = null;
			Statement AQibrKHH = AppLayerDatabase.getInstance().createStatement();
			ResultSet L0qFf1de = AQibrKHH.executeQuery("select UNIQUEKEY('" + getMessageTableName() + "')");
			if (L0qFf1de.next()) {
				VJK3Du3a = new Long(L0qFf1de.getLong(1));
			} else {
				logger.log(Level.SEVERE, "Could not retrieve a new unique key!");
			}
			L0qFf1de.close();
			AQibrKHH.close();
			int HCpdaPgZ = 1;
			mpn22SeW.setLong(HCpdaPgZ++, VJK3Du3a.longValue());
			mpn22SeW.setString(HCpdaPgZ++, HeMRR0Yj.getMessageId());
			mpn22SeW.setString(HCpdaPgZ++, HeMRR0Yj.getInReplyTo());
			mpn22SeW.setBoolean(HCpdaPgZ++, HeMRR0Yj.isValid());
			mpn22SeW.setString(HCpdaPgZ++, HeMRR0Yj.getInvalidReason());
			mpn22SeW.setLong(HCpdaPgZ++, HeMRR0Yj.getDateAndTime().getMillis());
			mpn22SeW.setInt(HCpdaPgZ++, HeMRR0Yj.getIndex());
			mpn22SeW.setInt(HCpdaPgZ++, HeMRR0Yj.getBoard().getPrimaryKey().intValue());
			mpn22SeW.setString(HCpdaPgZ++, HeMRR0Yj.getFromName());
			mpn22SeW.setString(HCpdaPgZ++, HeMRR0Yj.getSubject());
			mpn22SeW.setString(HCpdaPgZ++,
					((HeMRR0Yj.getRecipientName() != null && HeMRR0Yj.getRecipientName().length() == 0) ? null
							: HeMRR0Yj.getRecipientName()));
			if (HeMRR0Yj.getSignatureV2() == null || HeMRR0Yj.getSignatureV2().length() == 0) {
				mpn22SeW.setString(HCpdaPgZ++, HeMRR0Yj.getSignatureV1());
			} else {
				mpn22SeW.setString(HCpdaPgZ++, HeMRR0Yj.getSignatureV2());
			}
			mpn22SeW.setInt(HCpdaPgZ++, HeMRR0Yj.getSignatureStatus());
			mpn22SeW.setString(HCpdaPgZ++, HeMRR0Yj.getPublicKey());
			mpn22SeW.setBoolean(HCpdaPgZ++, HeMRR0Yj.isDeleted());
			mpn22SeW.setBoolean(HCpdaPgZ++, HeMRR0Yj.isNew());
			mpn22SeW.setBoolean(HCpdaPgZ++, HeMRR0Yj.isReplied());
			mpn22SeW.setBoolean(HCpdaPgZ++, HeMRR0Yj.isJunk());
			mpn22SeW.setBoolean(HCpdaPgZ++, HeMRR0Yj.isFlagged());
			mpn22SeW.setBoolean(HCpdaPgZ++, HeMRR0Yj.isStarred());
			mpn22SeW.setBoolean(HCpdaPgZ++, (Jm8szgAB.size() > 0));
			mpn22SeW.setBoolean(HCpdaPgZ++, (zJVcMK5L.size() > 0));
			mpn22SeW.setInt(HCpdaPgZ++, HeMRR0Yj.getIdLinePos());
			mpn22SeW.setInt(HCpdaPgZ++, HeMRR0Yj.getIdLineLen());
			int C8o1nu3Q;
			try {
				C8o1nu3Q = mpn22SeW.executeUpdate();
			} finally {
				mpn22SeW.close();
			}
			if (C8o1nu3Q == 0) {
				logger.log(Level.SEVERE, "message insert returned 0 !!!");
				throw new Exception("message insert returned 0 !!!");
			}
			HeMRR0Yj.setMsgIdentity(VJK3Du3a.longValue());
			PreparedStatement av70sFHp = qP9NfXTx
					.prepareStatement("INSERT INTO " + getContentTableName() + " (msgref,msgcontent) VALUES (?,?)");
			av70sFHp.setLong(1, HeMRR0Yj.getMsgIdentity());
			av70sFHp.setString(2, HeMRR0Yj.getContent());
			try {
				C8o1nu3Q = av70sFHp.executeUpdate();
			} finally {
				av70sFHp.close();
			}
			if (C8o1nu3Q == 0) {
				logger.log(Level.SEVERE, "message content insert returned 0 !!!");
				throw new Exception("message content insert returned 0 !!!");
			}
			if (Jm8szgAB.size() > 0) {
				PreparedStatement rGzzZwO8 = qP9NfXTx.prepareStatement("INSERT INTO " + getFileAttachmentsTableName()
						+ " (msgref,filename,filesize,filekey)" + " VALUES (?,?,?,?)");
				try {
					for (Iterator H3s9XXxP = Jm8szgAB.iterator(); H3s9XXxP.hasNext();) {
						FileAttachment D2iquIjk = (FileAttachment) H3s9XXxP.next();
						int vZ8FWn6p = 1;
						rGzzZwO8.setLong(vZ8FWn6p++, HeMRR0Yj.getMsgIdentity());
						rGzzZwO8.setString(vZ8FWn6p++, D2iquIjk.getFilename());
						rGzzZwO8.setLong(vZ8FWn6p++, D2iquIjk.getFileSize());
						rGzzZwO8.setString(vZ8FWn6p++, D2iquIjk.getKey());
						int X9KZZauS = rGzzZwO8.executeUpdate();
						if (X9KZZauS == 0) {
							logger.log(Level.SEVERE, "fileattachment insert returned 0 !!!");
							throw new Exception("fileattachment insert returned 0 !!!");
						}
					}
				} finally {
					rGzzZwO8.close();
				}
			}
			if (zJVcMK5L.size() > 0) {
				PreparedStatement HObo2GtN = qP9NfXTx.prepareStatement("INSERT INTO " + getBoardAttachmentsTableName()
						+ " (msgref,boardname,boardpublickey,boardprivatekey,boarddescription)"
						+ " VALUES (?,?,?,?,?)");
				try {
					for (Iterator dCUh2y9n = zJVcMK5L.iterator(); dCUh2y9n.hasNext();) {
						BoardAttachment jZibZCrI = (BoardAttachment) dCUh2y9n.next();
						Board wNz35l8e = jZibZCrI.getBoardObj();
						int mg8fEwDL = 1;
						HObo2GtN.setLong(mg8fEwDL++, HeMRR0Yj.getMsgIdentity());
						HObo2GtN.setString(mg8fEwDL++, wNz35l8e.getNameLowerCase());
						HObo2GtN.setString(mg8fEwDL++, wNz35l8e.getPublicKey());
						HObo2GtN.setString(mg8fEwDL++, wNz35l8e.getPrivateKey());
						HObo2GtN.setString(mg8fEwDL++, wNz35l8e.getDescription());
						int qEBindu1 = HObo2GtN.executeUpdate();
						if (qEBindu1 == 0) {
							logger.log(Level.SEVERE, "boardattachment insert returned 0 !!!");
							throw new Exception("boardattachment insert returned 0 !!!");
						}
					}
				} finally {
					HObo2GtN.close();
				}
			}
			qP9NfXTx.commit();
			qP9NfXTx.setAutoCommit(true);
			return INSERT_OK;
		} catch (Throwable hcYKCWc4) {
			boolean stcaSz2m;
			if (hcYKCWc4.getMessage().indexOf("constraint violation") > 0
					&& hcYKCWc4.getMessage().indexOf("MSG_ID_UNIQUE_ONLY") > 0) {
				stcaSz2m = true;
				logger.warning("Duplicate message id, not added to database table: msgid='" + HeMRR0Yj.getMessageId()
						+ "', board=" + HeMRR0Yj.getBoard().getName() + ", date='" + HeMRR0Yj.getDateAndTimeString()
						+ "', index=" + HeMRR0Yj.getIndex());
			} else if (hcYKCWc4.getMessage().indexOf("constraint violation") > 0
					&& hcYKCWc4.getMessage().indexOf("MSG_UNIQUE_ONLY") > 0) {
				stcaSz2m = true;
				logger.warning("Duplicate msgdatetime,index,board, not added to database table: msgid='"
						+ HeMRR0Yj.getMessageId() + "', board=" + HeMRR0Yj.getBoard().getName() + ", date='"
						+ HeMRR0Yj.getDateAndTimeString() + "', index=" + HeMRR0Yj.getIndex());
			} else {
				stcaSz2m = false;
				logger.log(Level.SEVERE,
						"Exception during insert of message: msgid='" + HeMRR0Yj.getMessageId() + "', board="
								+ HeMRR0Yj.getBoard().getName() + ", date='" + HeMRR0Yj.getDateAndTimeString()
								+ "', index=" + HeMRR0Yj.getIndex(),
						hcYKCWc4);
				try {
					qP9NfXTx.rollback();
				} catch (Throwable mijnKhL0) {
					logger.log(Level.SEVERE, "Exception during rollback", mijnKhL0);
				}
			}
			try {
				qP9NfXTx.setAutoCommit(true);
			} catch (Throwable ijZEklkm) {
			}
			if (stcaSz2m) {
				return INSERT_DUPLICATE;
			} else {
				return INSERT_ERROR;
			}
		} finally {
			AppLayerDatabase.getInstance().givePooledConnection(qP9NfXTx);
		}
	}

}