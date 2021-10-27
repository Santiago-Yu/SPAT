class n4462296 {
	public synchronized void insertMessage(FrostUnsentMessageObject uMVUU1cq) throws SQLException {
		AttachmentList nLFZTiqH = uMVUU1cq.getAttachmentsOfType(Attachment.FILE);
		AttachmentList QUCsqb4F = uMVUU1cq.getAttachmentsOfType(Attachment.BOARD);
		Connection dioWZhXF = AppLayerDatabase.getInstance().getPooledConnection();
		try {
			dioWZhXF.setAutoCommit(false);
			PreparedStatement TZqAAD1i = dioWZhXF.prepareStatement("INSERT INTO UNSENDMESSAGES ("
					+ "primkey,messageid,inreplyto,board,sendafter,idlinepos,idlinelen,fromname,subject,recipient,msgcontent,"
					+ "hasfileattachment,hasboardattachment,timeAdded" + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			Long ZYw3wCP5 = null;
			Statement P8rmwCNG = AppLayerDatabase.getInstance().createStatement();
			ResultSet DsPmbBwb = P8rmwCNG.executeQuery("select UNIQUEKEY('UNSENDMESSAGES')");
			if (DsPmbBwb.next()) {
				ZYw3wCP5 = new Long(DsPmbBwb.getLong(1));
			} else {
				logger.log(Level.SEVERE, "Could not retrieve a new unique key!");
			}
			DsPmbBwb.close();
			P8rmwCNG.close();
			uMVUU1cq.setMsgIdentity(ZYw3wCP5.longValue());
			int evMeWj4Z = 1;
			TZqAAD1i.setLong(evMeWj4Z++, uMVUU1cq.getMsgIdentity());
			TZqAAD1i.setString(evMeWj4Z++, uMVUU1cq.getMessageId());
			TZqAAD1i.setString(evMeWj4Z++, uMVUU1cq.getInReplyTo());
			TZqAAD1i.setInt(evMeWj4Z++, uMVUU1cq.getBoard().getPrimaryKey().intValue());
			TZqAAD1i.setLong(evMeWj4Z++, 0);
			TZqAAD1i.setInt(evMeWj4Z++, uMVUU1cq.getIdLinePos());
			TZqAAD1i.setInt(evMeWj4Z++, uMVUU1cq.getIdLineLen());
			TZqAAD1i.setString(evMeWj4Z++, uMVUU1cq.getFromName());
			TZqAAD1i.setString(evMeWj4Z++, uMVUU1cq.getSubject());
			TZqAAD1i.setString(evMeWj4Z++, uMVUU1cq.getRecipientName());
			TZqAAD1i.setString(evMeWj4Z++, uMVUU1cq.getContent());
			TZqAAD1i.setBoolean(evMeWj4Z++, (nLFZTiqH.size() > 0));
			TZqAAD1i.setBoolean(evMeWj4Z++, (QUCsqb4F.size() > 0));
			TZqAAD1i.setLong(evMeWj4Z++, uMVUU1cq.getTimeAdded());
			int GiEKi1AX = 0;
			try {
				GiEKi1AX = TZqAAD1i.executeUpdate();
			} finally {
				TZqAAD1i.close();
			}
			if (GiEKi1AX == 0) {
				logger.log(Level.SEVERE, "message insert returned 0 !!!");
				return;
			}
			uMVUU1cq.setMsgIdentity(ZYw3wCP5.longValue());
			if (nLFZTiqH.size() > 0) {
				PreparedStatement dQuD9Hqp = dioWZhXF.prepareStatement("INSERT INTO UNSENDFILEATTACHMENTS"
						+ " (msgref,filename,filesize,filekey)" + " VALUES (?,?,?,?)");
				for (Iterator IF3ZF6yx = nLFZTiqH.iterator(); IF3ZF6yx.hasNext();) {
					FileAttachment zG2QvQuB = (FileAttachment) IF3ZF6yx.next();
					int qjigaVWL = 1;
					dQuD9Hqp.setLong(qjigaVWL++, uMVUU1cq.getMsgIdentity());
					dQuD9Hqp.setString(qjigaVWL++, zG2QvQuB.getInternalFile().getPath());
					dQuD9Hqp.setLong(qjigaVWL++, zG2QvQuB.getFileSize());
					dQuD9Hqp.setString(qjigaVWL++, zG2QvQuB.getKey());
					int OmvB6o6D = dQuD9Hqp.executeUpdate();
					if (OmvB6o6D == 0) {
						logger.log(Level.SEVERE, "fileattachment insert returned 0 !!!");
					}
				}
				dQuD9Hqp.close();
			}
			if (QUCsqb4F.size() > 0) {
				PreparedStatement dZ0teOE5 = dioWZhXF.prepareStatement("INSERT INTO UNSENDBOARDATTACHMENTS"
						+ " (msgref,boardname,boardpublickey,boardprivatekey,boarddescription)"
						+ " VALUES (?,?,?,?,?)");
				for (Iterator Fx3NAf8h = QUCsqb4F.iterator(); Fx3NAf8h.hasNext();) {
					BoardAttachment tEuyTmpH = (BoardAttachment) Fx3NAf8h.next();
					Board o6gxQmE1 = tEuyTmpH.getBoardObj();
					int PccGBa0m = 1;
					dZ0teOE5.setLong(PccGBa0m++, uMVUU1cq.getMsgIdentity());
					dZ0teOE5.setString(PccGBa0m++, o6gxQmE1.getNameLowerCase());
					dZ0teOE5.setString(PccGBa0m++, o6gxQmE1.getPublicKey());
					dZ0teOE5.setString(PccGBa0m++, o6gxQmE1.getPrivateKey());
					dZ0teOE5.setString(PccGBa0m++, o6gxQmE1.getDescription());
					int UF9ChXgG = dZ0teOE5.executeUpdate();
					if (UF9ChXgG == 0) {
						logger.log(Level.SEVERE, "boardattachment insert returned 0 !!!");
					}
				}
				dZ0teOE5.close();
			}
			dioWZhXF.commit();
			dioWZhXF.setAutoCommit(true);
		} catch (Throwable VIdl95GP) {
			logger.log(Level.SEVERE, "Exception during insert of unsent message", VIdl95GP);
			try {
				dioWZhXF.rollback();
			} catch (Throwable YgvsFOv5) {
				logger.log(Level.SEVERE, "Exception during rollback", YgvsFOv5);
			}
			try {
				dioWZhXF.setAutoCommit(true);
			} catch (Throwable nA9P9StS) {
			}
		} finally {
			AppLayerDatabase.getInstance().givePooledConnection(dioWZhXF);
		}
	}

}