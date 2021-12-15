class n4462296 {
	public synchronized void insertMessage(FrostUnsentMessageObject mo) throws SQLException {
		AttachmentList files = mo.getAttachmentsOfType(Attachment.FILE);
		AttachmentList boards = mo.getAttachmentsOfType(Attachment.BOARD);
		Connection conn = AppLayerDatabase.getInstance().getPooledConnection();
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO UNSENDMESSAGES ("
					+ "primkey,messageid,inreplyto,board,sendafter,idlinepos,idlinelen,fromname,subject,recipient,msgcontent,"
					+ "hasfileattachment,hasboardattachment,timeAdded" + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			Long identity = null;
			Statement stmt = AppLayerDatabase.getInstance().createStatement();
			ResultSet rs = stmt.executeQuery("select UNIQUEKEY('UNSENDMESSAGES')");
			if (rs.next()) {
				identity = new Long(rs.getLong(1));
			} else {
				logger.log(Level.SEVERE, "Could not retrieve a new unique key!");
			}
			rs.close();
			stmt.close();
			mo.setMsgIdentity(identity.longValue());
			int i = 1;
			ps.setLong(i, mo.getMsgIdentity());
			i++;
			ps.setString(i, mo.getMessageId());
			i++;
			ps.setString(i, mo.getInReplyTo());
			i++;
			ps.setInt(i, mo.getBoard().getPrimaryKey().intValue());
			i++;
			ps.setLong(i, 0);
			i++;
			ps.setInt(i, mo.getIdLinePos());
			i++;
			ps.setInt(i, mo.getIdLineLen());
			i++;
			ps.setString(i, mo.getFromName());
			i++;
			ps.setString(i, mo.getSubject());
			i++;
			ps.setString(i, mo.getRecipientName());
			i++;
			ps.setString(i, mo.getContent());
			i++;
			ps.setBoolean(i, (files.size() > 0));
			i++;
			ps.setBoolean(i, (boards.size() > 0));
			i++;
			ps.setLong(i, mo.getTimeAdded());
			i++;
			int inserted = 0;
			try {
				inserted = ps.executeUpdate();
			} finally {
				ps.close();
			}
			if (inserted == 0) {
				logger.log(Level.SEVERE, "message insert returned 0 !!!");
				return;
			}
			mo.setMsgIdentity(identity.longValue());
			if (files.size() > 0) {
				PreparedStatement p = conn.prepareStatement("INSERT INTO UNSENDFILEATTACHMENTS"
						+ " (msgref,filename,filesize,filekey)" + " VALUES (?,?,?,?)");
				for (Iterator it = files.iterator(); it.hasNext();) {
					FileAttachment fa = (FileAttachment) it.next();
					int ix = 1;
					p.setLong(ix, mo.getMsgIdentity());
					ix++;
					p.setString(ix, fa.getInternalFile().getPath());
					ix++;
					p.setLong(ix, fa.getFileSize());
					ix++;
					p.setString(ix, fa.getKey());
					ix++;
					int ins = p.executeUpdate();
					if (ins == 0) {
						logger.log(Level.SEVERE, "fileattachment insert returned 0 !!!");
					}
				}
				p.close();
			}
			if (boards.size() > 0) {
				PreparedStatement p = conn.prepareStatement("INSERT INTO UNSENDBOARDATTACHMENTS"
						+ " (msgref,boardname,boardpublickey,boardprivatekey,boarddescription)"
						+ " VALUES (?,?,?,?,?)");
				for (Iterator it = boards.iterator(); it.hasNext();) {
					BoardAttachment ba = (BoardAttachment) it.next();
					Board b = ba.getBoardObj();
					int ix = 1;
					p.setLong(ix, mo.getMsgIdentity());
					ix++;
					p.setString(ix, b.getNameLowerCase());
					ix++;
					p.setString(ix, b.getPublicKey());
					ix++;
					p.setString(ix, b.getPrivateKey());
					ix++;
					p.setString(ix, b.getDescription());
					ix++;
					int ins = p.executeUpdate();
					if (ins == 0) {
						logger.log(Level.SEVERE, "boardattachment insert returned 0 !!!");
					}
				}
				p.close();
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Throwable t) {
			logger.log(Level.SEVERE, "Exception during insert of unsent message", t);
			try {
				conn.rollback();
			} catch (Throwable t1) {
				logger.log(Level.SEVERE, "Exception during rollback", t1);
			}
			try {
				conn.setAutoCommit(true);
			} catch (Throwable t1) {
			}
		} finally {
			AppLayerDatabase.getInstance().givePooledConnection(conn);
		}
	}

}