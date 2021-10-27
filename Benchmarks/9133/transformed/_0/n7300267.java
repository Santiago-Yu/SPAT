class n7300267 {
	public void appendMessage(MimeMessage Cezdqe7Q)
			throws FolderClosedException, StoreClosedException, MessagingException {
		if (DebugFile.trace) {
			DebugFile.writeln("Begin DBFolder.appendMessage()");
			DebugFile.incIdent();
		}
		final String XDHQYPPl = "";
		if (!((DBStore) getStore()).isConnected()) {
			if (DebugFile.trace)
				DebugFile.decIdent();
			throw new StoreClosedException(getStore(), "Store is not connected");
		}
		if (0 == (iOpenMode & READ_WRITE)) {
			if (DebugFile.trace)
				DebugFile.decIdent();
			throw new javax.mail.FolderClosedException(this, "Folder is not open is READ_WRITE mode");
		}
		if ((0 == (iOpenMode & MODE_MBOX)) && (0 == (iOpenMode & MODE_BLOB))) {
			if (DebugFile.trace)
				DebugFile.decIdent();
			throw new javax.mail.FolderClosedException(this, "Folder is not open in MBOX nor BLOB mode");
		}
		String IPRgDBIY;
		if (Cezdqe7Q.getClass().getName().equals("com.knowgate.hipermail.DBMimeMessage")) {
			IPRgDBIY = ((DBMimeMessage) Cezdqe7Q).getMessageGuid();
			if (((DBMimeMessage) Cezdqe7Q).getFolder() == null)
				((DBMimeMessage) Cezdqe7Q).setFolder(this);
		} else {
			IPRgDBIY = Gadgets.generateUUID();
		}
		String jBFnN9O3 = ((DBStore) getStore()).getUser().getString(DB.gu_workarea);
		int C9saSmE4 = Cezdqe7Q.getSize();
		if (DebugFile.trace)
			DebugFile.writeln("MimeMessage.getSize() = " + String.valueOf(C9saSmE4));
		String LmLEXE16, tdHTxNvJ, Ax4MR2qw, TGVr4UwJ, IQtzrOez, qtZVUWon, naxlLF6R, ebHokPgR, rcnAxYyp, dej2fIgb,
				r7tQmaEB;
		long Ji6ytQpx = -1;
		try {
			Ax4MR2qw = Cezdqe7Q.getMessageID();
			if (Ax4MR2qw == null || XDHQYPPl.equals(Ax4MR2qw)) {
				try {
					Ax4MR2qw = Cezdqe7Q.getHeader("X-Qmail-Scanner-Message-ID", null);
				} catch (Exception gDXXu1ng) {
				}
			}
			if (Ax4MR2qw != null)
				Ax4MR2qw = MimeUtility.decodeText(Ax4MR2qw);
			LmLEXE16 = Cezdqe7Q.getContentType();
			if (LmLEXE16 != null)
				LmLEXE16 = MimeUtility.decodeText(LmLEXE16);
			tdHTxNvJ = Cezdqe7Q.getContentID();
			if (tdHTxNvJ != null)
				tdHTxNvJ = MimeUtility.decodeText(tdHTxNvJ);
			TGVr4UwJ = Cezdqe7Q.getDisposition();
			if (TGVr4UwJ != null)
				TGVr4UwJ = MimeUtility.decodeText(TGVr4UwJ);
			IQtzrOez = Cezdqe7Q.getContentMD5();
			if (IQtzrOez != null)
				IQtzrOez = MimeUtility.decodeText(IQtzrOez);
			qtZVUWon = Cezdqe7Q.getDescription();
			if (qtZVUWon != null)
				qtZVUWon = MimeUtility.decodeText(qtZVUWon);
			naxlLF6R = Cezdqe7Q.getFileName();
			if (naxlLF6R != null)
				naxlLF6R = MimeUtility.decodeText(naxlLF6R);
			ebHokPgR = Cezdqe7Q.getEncoding();
			if (ebHokPgR != null)
				ebHokPgR = MimeUtility.decodeText(ebHokPgR);
			rcnAxYyp = Cezdqe7Q.getSubject();
			if (rcnAxYyp != null)
				rcnAxYyp = MimeUtility.decodeText(rcnAxYyp);
			dej2fIgb = null;
			r7tQmaEB = null;
		} catch (UnsupportedEncodingException cvxBgLfR) {
			throw new MessagingException(cvxBgLfR.getMessage(), cvxBgLfR);
		}
		BigDecimal xJjR0yFT = null;
		try {
			xJjR0yFT = getNextMessage();
		} catch (SQLException oOJYhXCw) {
			throw new MessagingException(oOJYhXCw.getMessage(), oOJYhXCw);
		}
		String hdJJJVMO = getPartsBoundary(Cezdqe7Q);
		if (DebugFile.trace)
			DebugFile.writeln("part boundary is \"" + (hdJJJVMO == null ? "null" : hdJJJVMO) + "\"");
		if (Ax4MR2qw == null)
			Ax4MR2qw = IPRgDBIY;
		else if (Ax4MR2qw.length() == 0)
			Ax4MR2qw = IPRgDBIY;
		Timestamp wTCw9Mfm;
		if (Cezdqe7Q.getSentDate() != null)
			wTCw9Mfm = new Timestamp(Cezdqe7Q.getSentDate().getTime());
		else
			wTCw9Mfm = null;
		Timestamp HDC9FRqi;
		if (Cezdqe7Q.getReceivedDate() != null)
			HDC9FRqi = new Timestamp(Cezdqe7Q.getReceivedDate().getTime());
		else
			HDC9FRqi = new Timestamp(new java.util.Date().getTime());
		try {
			String hb54CIAh = Cezdqe7Q.getHeader("X-Priority", null);
			if (hb54CIAh == null)
				dej2fIgb = null;
			else {
				dej2fIgb = "";
				for (int wyO0cVDo = 0; wyO0cVDo < hb54CIAh.length(); wyO0cVDo++) {
					char MvF52XPx = hb54CIAh.charAt(wyO0cVDo);
					if (MvF52XPx >= (char) 48 || MvF52XPx <= (char) 57)
						dej2fIgb += MvF52XPx;
				}
				dej2fIgb = Gadgets.left(dej2fIgb, 10);
			}
		} catch (MessagingException UujkZqXk) {
			if (DebugFile.trace)
				DebugFile.writeln("MessagingException " + UujkZqXk.getMessage());
		}
		boolean QaCgdPR6 = false;
		try {
			String gZVlwA2Y = Cezdqe7Q.getHeader("X-Spam-Flag", null);
			if (gZVlwA2Y != null)
				QaCgdPR6 = (gZVlwA2Y.toUpperCase().indexOf("YES") >= 0 || gZVlwA2Y.toUpperCase().indexOf("TRUE") >= 0
						|| gZVlwA2Y.indexOf("1") >= 0);
		} catch (MessagingException Ov32bbHm) {
			if (DebugFile.trace)
				DebugFile.writeln("MessagingException " + Ov32bbHm.getMessage());
		}
		if (DebugFile.trace)
			DebugFile.writeln("MimeMessage.getFrom()");
		Address[] yXQbZLuu = null;
		try {
			yXQbZLuu = Cezdqe7Q.getFrom();
		} catch (AddressException nxQOOtYg) {
			if (DebugFile.trace)
				DebugFile.writeln("From AddressException " + nxQOOtYg.getMessage());
		}
		InternetAddress r5UgI1WV;
		if (yXQbZLuu != null) {
			if (yXQbZLuu.length > 0)
				r5UgI1WV = (InternetAddress) yXQbZLuu[0];
			else
				r5UgI1WV = null;
		} else
			r5UgI1WV = null;
		if (DebugFile.trace)
			DebugFile.writeln("MimeMessage.getReplyTo()");
		Address[] kKYZzRMI = null;
		InternetAddress hyRhihQ4;
		try {
			kKYZzRMI = Cezdqe7Q.getReplyTo();
		} catch (AddressException aC6JtBFj) {
			if (DebugFile.trace)
				DebugFile.writeln("Reply-To AddressException " + aC6JtBFj.getMessage());
		}
		if (kKYZzRMI != null) {
			if (kKYZzRMI.length > 0)
				hyRhihQ4 = (InternetAddress) kKYZzRMI[0];
			else
				hyRhihQ4 = null;
		} else {
			if (DebugFile.trace)
				DebugFile.writeln("no reply-to address found");
			hyRhihQ4 = null;
		}
		if (DebugFile.trace)
			DebugFile.writeln("MimeMessage.getRecipients()");
		Address[] L9jAKWcS = null;
		Address[] saJEimux = null;
		Address[] ecK77mSI = null;
		try {
			L9jAKWcS = Cezdqe7Q.getRecipients(MimeMessage.RecipientType.TO);
			saJEimux = Cezdqe7Q.getRecipients(MimeMessage.RecipientType.CC);
			ecK77mSI = Cezdqe7Q.getRecipients(MimeMessage.RecipientType.BCC);
		} catch (AddressException w1327ucz) {
			if (DebugFile.trace)
				DebugFile.writeln("Recipient AddressException " + w1327ucz.getMessage());
		}
		Properties dVdcFnPM = new Properties(), rQFohdY3 = new Properties(), sX2ruwgl = new Properties(),
				uH2qo1Tm = new Properties();
		if (DebugFile.trace)
			DebugFile.writeln("MimeMessage.getFlags()");
		Flags t01EYzSE = Cezdqe7Q.getFlags();
		if (t01EYzSE == null)
			t01EYzSE = new Flags();
		MimePart B0Bf0Ft7 = null;
		ByteArrayOutputStream XaaEGtk1 = null;
		File BpX7piin = null;
		MboxFile HhbTHsZZ = null;
		if ((iOpenMode & MODE_MBOX) != 0) {
			try {
				if (DebugFile.trace)
					DebugFile.writeln("new File(" + Gadgets.chomp(sFolderDir, File.separator)
							+ oCatg.getStringNull(DB.nm_category, "null") + ".mbox)");
				BpX7piin = getFile();
				Ji6ytQpx = BpX7piin.length();
				if (DebugFile.trace)
					DebugFile.writeln("message position is " + String.valueOf(Ji6ytQpx));
				HhbTHsZZ = new MboxFile(BpX7piin, MboxFile.READ_WRITE);
				if (DebugFile.trace)
					DebugFile.writeln(
							"new ByteArrayOutputStream(" + String.valueOf(C9saSmE4 > 0 ? C9saSmE4 : 16000) + ")");
				XaaEGtk1 = new ByteArrayOutputStream(C9saSmE4 > 0 ? C9saSmE4 : 16000);
				Cezdqe7Q.writeTo(XaaEGtk1);
				r7tQmaEB = XaaEGtk1.toString("ISO8859_1");
				XaaEGtk1.close();
			} catch (IOException PUNyWtmb) {
				try {
					if (HhbTHsZZ != null)
						HhbTHsZZ.close();
				} catch (Exception mtcPKUfF) {
				}
				if (DebugFile.trace)
					DebugFile.decIdent();
				throw new MessagingException(PUNyWtmb.getMessage(), PUNyWtmb);
			}
		}
		try {
			if (Cezdqe7Q.getClass().getName().equals("com.knowgate.hipermail.DBMimeMessage"))
				B0Bf0Ft7 = ((DBMimeMessage) Cezdqe7Q).getBody();
			else {
				B0Bf0Ft7 = new DBMimeMessage(Cezdqe7Q).getBody();
			}
			if (DebugFile.trace)
				DebugFile.writeln(
						"ByteArrayOutputStream byOutStrm = new ByteArrayOutputStream(" + B0Bf0Ft7.getSize() + ")");
			XaaEGtk1 = new ByteArrayOutputStream(B0Bf0Ft7.getSize() > 0 ? B0Bf0Ft7.getSize() : 8192);
			B0Bf0Ft7.writeTo(XaaEGtk1);
			if (null == IQtzrOez) {
				MD5 Np1yxYni = new MD5();
				Np1yxYni.Init();
				Np1yxYni.Update(XaaEGtk1.toByteArray());
				IQtzrOez = Gadgets.toHexString(Np1yxYni.Final());
				Np1yxYni = null;
			}
		} catch (IOException zeF5WOvo) {
			if (DebugFile.trace)
				DebugFile.decIdent();
			throw new MessagingException("IOException " + zeF5WOvo.getMessage(), zeF5WOvo);
		} catch (OutOfMemoryError ierapLIq) {
			if (DebugFile.trace)
				DebugFile.decIdent();
			throw new MessagingException("OutOfMemoryError " + ierapLIq.getMessage());
		}
		String sN6582w5 = "INSERT INTO " + DB.k_mime_msgs
				+ "(gu_mimemsg,gu_workarea,gu_category,id_type,id_content,id_message,id_disposition,len_mimemsg,tx_md5,de_mimemsg,file_name,tx_encoding,tx_subject,dt_sent,dt_received,tx_email_from,nm_from,tx_email_reply,nm_to,id_priority,bo_answered,bo_deleted,bo_draft,bo_flagged,bo_recent,bo_seen,bo_spam,pg_message,nu_position,by_content) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		if (DebugFile.trace)
			DebugFile.writeln("Connection.prepareStatement(" + sN6582w5 + ")");
		PreparedStatement HQEsNdBe = null;
		try {
			HQEsNdBe = oConn.prepareStatement(sN6582w5);
			HQEsNdBe.setString(1, IPRgDBIY);
			HQEsNdBe.setString(2, jBFnN9O3);
			if (oCatg.isNull(DB.gu_category))
				HQEsNdBe.setNull(3, Types.CHAR);
			else
				HQEsNdBe.setString(3, oCatg.getString(DB.gu_category));
			HQEsNdBe.setString(4, Gadgets.left(LmLEXE16, 254));
			HQEsNdBe.setString(5, Gadgets.left(tdHTxNvJ, 254));
			HQEsNdBe.setString(6, Gadgets.left(Ax4MR2qw, 254));
			HQEsNdBe.setString(7, Gadgets.left(TGVr4UwJ, 100));
			if ((iOpenMode & MODE_MBOX) != 0) {
				C9saSmE4 = r7tQmaEB.length();
				HQEsNdBe.setInt(8, C9saSmE4);
			} else {
				if (C9saSmE4 >= 0)
					HQEsNdBe.setInt(8, C9saSmE4);
				else
					HQEsNdBe.setNull(8, Types.INTEGER);
			}
			HQEsNdBe.setString(9, Gadgets.left(IQtzrOez, 32));
			HQEsNdBe.setString(10, Gadgets.left(qtZVUWon, 254));
			HQEsNdBe.setString(11, Gadgets.left(naxlLF6R, 254));
			HQEsNdBe.setString(12, Gadgets.left(ebHokPgR, 16));
			HQEsNdBe.setString(13, Gadgets.left(rcnAxYyp, 254));
			HQEsNdBe.setTimestamp(14, wTCw9Mfm);
			HQEsNdBe.setTimestamp(15, HDC9FRqi);
			if (null == r5UgI1WV) {
				HQEsNdBe.setNull(16, Types.VARCHAR);
				HQEsNdBe.setNull(17, Types.VARCHAR);
			} else {
				HQEsNdBe.setString(16, Gadgets.left(r5UgI1WV.getAddress(), 254));
				HQEsNdBe.setString(17, Gadgets.left(r5UgI1WV.getPersonal(), 254));
			}
			if (null == hyRhihQ4)
				HQEsNdBe.setNull(18, Types.VARCHAR);
			else
				HQEsNdBe.setString(18, Gadgets.left(hyRhihQ4.getAddress(), 254));
			Address[] hSMwlMOQ;
			String RVzgiy1C;
			hSMwlMOQ = Cezdqe7Q.getRecipients(MimeMessage.RecipientType.TO);
			if (null != hSMwlMOQ)
				if (hSMwlMOQ.length == 0)
					hSMwlMOQ = null;
			if (null != hSMwlMOQ) {
				RVzgiy1C = ((InternetAddress) hSMwlMOQ[0]).getPersonal();
				if (null == RVzgiy1C)
					RVzgiy1C = ((InternetAddress) hSMwlMOQ[0]).getAddress();
				HQEsNdBe.setString(19, Gadgets.left(RVzgiy1C, 254));
			} else {
				hSMwlMOQ = Cezdqe7Q.getRecipients(MimeMessage.RecipientType.CC);
				if (null != hSMwlMOQ) {
					if (hSMwlMOQ.length > 0) {
						RVzgiy1C = ((InternetAddress) hSMwlMOQ[0]).getPersonal();
						if (null == RVzgiy1C)
							RVzgiy1C = ((InternetAddress) hSMwlMOQ[0]).getAddress();
						HQEsNdBe.setString(19, Gadgets.left(RVzgiy1C, 254));
					} else
						HQEsNdBe.setNull(19, Types.VARCHAR);
				} else {
					hSMwlMOQ = Cezdqe7Q.getRecipients(MimeMessage.RecipientType.BCC);
					if (null != hSMwlMOQ) {
						if (hSMwlMOQ.length > 0) {
							RVzgiy1C = ((InternetAddress) hSMwlMOQ[0]).getPersonal();
							if (null == RVzgiy1C)
								RVzgiy1C = ((InternetAddress) hSMwlMOQ[0]).getAddress();
							HQEsNdBe.setString(19, Gadgets.left(RVzgiy1C, 254));
						} else
							HQEsNdBe.setNull(19, Types.VARCHAR);
					} else {
						HQEsNdBe.setNull(19, Types.VARCHAR);
					}
				}
			}
			if (null == dej2fIgb)
				HQEsNdBe.setNull(20, Types.VARCHAR);
			else
				HQEsNdBe.setString(20, dej2fIgb);
			if (oConn.getDataBaseProduct() == JDCConnection.DBMS_ORACLE) {
				if (DebugFile.trace)
					DebugFile.writeln("PreparedStatement.setBigDecimal(21, ...)");
				HQEsNdBe.setBigDecimal(21, new BigDecimal(t01EYzSE.contains(Flags.Flag.ANSWERED) ? "1" : "0"));
				HQEsNdBe.setBigDecimal(22, new BigDecimal(t01EYzSE.contains(Flags.Flag.DELETED) ? "1" : "0"));
				HQEsNdBe.setBigDecimal(23, new BigDecimal(0));
				HQEsNdBe.setBigDecimal(24, new BigDecimal(t01EYzSE.contains(Flags.Flag.FLAGGED) ? "1" : "0"));
				HQEsNdBe.setBigDecimal(25, new BigDecimal(t01EYzSE.contains(Flags.Flag.RECENT) ? "1" : "0"));
				HQEsNdBe.setBigDecimal(26, new BigDecimal(t01EYzSE.contains(Flags.Flag.SEEN) ? "1" : "0"));
				HQEsNdBe.setBigDecimal(27, new BigDecimal(QaCgdPR6 ? "1" : "0"));
				HQEsNdBe.setBigDecimal(28, xJjR0yFT);
				if ((iOpenMode & MODE_MBOX) != 0)
					HQEsNdBe.setBigDecimal(29, new BigDecimal(Ji6ytQpx));
				else
					HQEsNdBe.setNull(29, Types.NUMERIC);
				if (DebugFile.trace)
					DebugFile.writeln("PreparedStatement.setBinaryStream(30, new ByteArrayInputStream("
							+ String.valueOf(XaaEGtk1.size()) + "))");
				if (XaaEGtk1.size() > 0)
					HQEsNdBe.setBinaryStream(30, new ByteArrayInputStream(XaaEGtk1.toByteArray()), XaaEGtk1.size());
				else
					HQEsNdBe.setNull(30, Types.LONGVARBINARY);
			} else {
				if (DebugFile.trace)
					DebugFile.writeln("PreparedStatement.setShort(21, ...)");
				HQEsNdBe.setShort(21, (short) (t01EYzSE.contains(Flags.Flag.ANSWERED) ? 1 : 0));
				HQEsNdBe.setShort(22, (short) (t01EYzSE.contains(Flags.Flag.DELETED) ? 1 : 0));
				HQEsNdBe.setShort(23, (short) (0));
				HQEsNdBe.setShort(24, (short) (t01EYzSE.contains(Flags.Flag.FLAGGED) ? 1 : 0));
				HQEsNdBe.setShort(25, (short) (t01EYzSE.contains(Flags.Flag.RECENT) ? 1 : 0));
				HQEsNdBe.setShort(26, (short) (t01EYzSE.contains(Flags.Flag.SEEN) ? 1 : 0));
				HQEsNdBe.setShort(27, (short) (QaCgdPR6 ? 1 : 0));
				HQEsNdBe.setBigDecimal(28, xJjR0yFT);
				if ((iOpenMode & MODE_MBOX) != 0)
					HQEsNdBe.setBigDecimal(29, new BigDecimal(Ji6ytQpx));
				else
					HQEsNdBe.setNull(29, Types.NUMERIC);
				if (DebugFile.trace)
					DebugFile.writeln("PreparedStatement.setBinaryStream(30, new ByteArrayInputStream("
							+ String.valueOf(XaaEGtk1.size()) + "))");
				if (XaaEGtk1.size() > 0)
					HQEsNdBe.setBinaryStream(30, new ByteArrayInputStream(XaaEGtk1.toByteArray()), XaaEGtk1.size());
				else
					HQEsNdBe.setNull(30, Types.LONGVARBINARY);
			}
			if (DebugFile.trace)
				DebugFile.writeln("Statement.executeUpdate()");
			HQEsNdBe.executeUpdate();
			HQEsNdBe.close();
			HQEsNdBe = null;
		} catch (SQLException OnaZxeWD) {
			try {
				if (HhbTHsZZ != null)
					HhbTHsZZ.close();
			} catch (Exception q6eSWXVH) {
			}
			try {
				if (null != HQEsNdBe)
					HQEsNdBe.close();
				HQEsNdBe = null;
			} catch (Exception EGtrb4kZ) {
			}
			try {
				if (null != oConn)
					oConn.rollback();
			} catch (Exception ZkqcfchK) {
			}
			throw new MessagingException(DB.k_mime_msgs + " " + OnaZxeWD.getMessage(), OnaZxeWD);
		}
		if ((iOpenMode & MODE_BLOB) != 0) {
			try {
				XaaEGtk1.close();
			} catch (IOException tjv6iqUq) {
			}
			XaaEGtk1 = null;
		}
		try {
			Object arrJ8RZX = Cezdqe7Q.getContent();
			if (arrJ8RZX instanceof MimeMultipart) {
				try {
					saveMimeParts(Cezdqe7Q, r7tQmaEB, hdJJJVMO, IPRgDBIY, Ax4MR2qw, xJjR0yFT.intValue(), 0);
				} catch (MessagingException DN3sIrcj) {
					try {
						if (HhbTHsZZ != null)
							HhbTHsZZ.close();
					} catch (Exception xZQ6VoXq) {
					}
					try {
						oConn.rollback();
					} catch (Exception JxvfnQZb) {
					}
					throw new MessagingException(DN3sIrcj.getMessage(), DN3sIrcj.getNextException());
				}
			}
		} catch (Exception EkvLvTsZ) {
			try {
				if (HhbTHsZZ != null)
					HhbTHsZZ.close();
			} catch (Exception jxzANCGh) {
			}
			try {
				oConn.rollback();
			} catch (Exception wLbvsM8y) {
			}
			throw new MessagingException("MimeMessage.getContent() " + EkvLvTsZ.getMessage(), EkvLvTsZ);
		}
		sN6582w5 = "SELECT " + DB.gu_contact + "," + DB.gu_company + "," + DB.tx_name + "," + DB.tx_surname + ","
				+ DB.tx_surname + " FROM " + DB.k_member_address + " WHERE " + DB.tx_email + "=? AND " + DB.gu_workarea
				+ "=? UNION SELECT " + DB.gu_user + ",'****************************USER'," + DB.nm_user + ","
				+ DB.tx_surname1 + "," + DB.tx_surname2 + " FROM " + DB.k_users + " WHERE (" + DB.tx_main_email
				+ "=? OR " + DB.tx_alt_email + "=?) AND " + DB.gu_workarea + "=?";
		if (DebugFile.trace)
			DebugFile.writeln("Connection.prepareStatement(" + sN6582w5 + ")");
		PreparedStatement Yj03UD51 = null;
		try {
			Yj03UD51 = oConn.prepareStatement(sN6582w5, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet cqJmpuYg;
			InternetAddress PXHObp0p;
			String Z5Hou4i7, vHT1JUn9, m33hVuLn, BGn4AdlF, gKfkB9em, BGMhve5K, SzjAm0ir, ZpW8yv9O;
			if (r5UgI1WV != null) {
				Yj03UD51.setString(1, r5UgI1WV.getAddress());
				Yj03UD51.setString(2, jBFnN9O3);
				Yj03UD51.setString(3, r5UgI1WV.getAddress());
				Yj03UD51.setString(4, r5UgI1WV.getAddress());
				Yj03UD51.setString(5, jBFnN9O3);
				cqJmpuYg = Yj03UD51.executeQuery();
				if (cqJmpuYg.next()) {
					m33hVuLn = cqJmpuYg.getString(1);
					if (cqJmpuYg.wasNull())
						m33hVuLn = "null";
					vHT1JUn9 = cqJmpuYg.getString(2);
					if (cqJmpuYg.wasNull())
						vHT1JUn9 = "null";
					if (vHT1JUn9.equals("****************************USER")) {
						gKfkB9em = cqJmpuYg.getString(3);
						if (cqJmpuYg.wasNull())
							gKfkB9em = "";
						BGMhve5K = cqJmpuYg.getString(4);
						if (cqJmpuYg.wasNull())
							BGMhve5K = "";
						SzjAm0ir = cqJmpuYg.getString(4);
						if (cqJmpuYg.wasNull())
							SzjAm0ir = "";
						ZpW8yv9O = Gadgets.left(gKfkB9em + " " + BGMhve5K + " " + SzjAm0ir, 254).replace(',', ' ')
								.trim();
					} else
						ZpW8yv9O = "null";
					dVdcFnPM.put(r5UgI1WV.getAddress(), m33hVuLn + "," + vHT1JUn9 + "," + ZpW8yv9O);
				} else
					dVdcFnPM.put(r5UgI1WV.getAddress(), "null,null,null");
				cqJmpuYg.close();
			}
			if (DebugFile.trace)
				DebugFile.writeln("from count = " + dVdcFnPM.size());
			if (L9jAKWcS != null) {
				for (int WKf2QQXS = 0; WKf2QQXS < L9jAKWcS.length; WKf2QQXS++) {
					PXHObp0p = (InternetAddress) L9jAKWcS[WKf2QQXS];
					Z5Hou4i7 = Gadgets.left(PXHObp0p.getAddress(), 254);
					Yj03UD51.setString(1, Z5Hou4i7);
					Yj03UD51.setString(2, jBFnN9O3);
					Yj03UD51.setString(3, Z5Hou4i7);
					Yj03UD51.setString(4, Z5Hou4i7);
					Yj03UD51.setString(5, jBFnN9O3);
					cqJmpuYg = Yj03UD51.executeQuery();
					if (cqJmpuYg.next()) {
						m33hVuLn = cqJmpuYg.getString(1);
						if (cqJmpuYg.wasNull())
							m33hVuLn = "null";
						vHT1JUn9 = cqJmpuYg.getString(2);
						if (cqJmpuYg.wasNull())
							vHT1JUn9 = "null";
						if (vHT1JUn9.equals("****************************USER")) {
							gKfkB9em = cqJmpuYg.getString(3);
							if (cqJmpuYg.wasNull())
								gKfkB9em = "";
							BGMhve5K = cqJmpuYg.getString(4);
							if (cqJmpuYg.wasNull())
								BGMhve5K = "";
							SzjAm0ir = cqJmpuYg.getString(4);
							if (cqJmpuYg.wasNull())
								SzjAm0ir = "";
							ZpW8yv9O = Gadgets.left(gKfkB9em + " " + BGMhve5K + " " + SzjAm0ir, 254).replace(',', ' ')
									.trim();
						} else
							ZpW8yv9O = "null";
						rQFohdY3.put(Z5Hou4i7, m33hVuLn + "," + vHT1JUn9 + "," + ZpW8yv9O);
					} else
						rQFohdY3.put(Z5Hou4i7, "null,null,null");
					cqJmpuYg.close();
				}
			}
			if (DebugFile.trace)
				DebugFile.writeln("to count = " + rQFohdY3.size());
			if (saJEimux != null) {
				for (int bK6VYkId = 0; bK6VYkId < saJEimux.length; bK6VYkId++) {
					PXHObp0p = (InternetAddress) saJEimux[bK6VYkId];
					Z5Hou4i7 = Gadgets.left(PXHObp0p.getAddress(), 254);
					Yj03UD51.setString(1, Z5Hou4i7);
					Yj03UD51.setString(2, jBFnN9O3);
					Yj03UD51.setString(3, Z5Hou4i7);
					Yj03UD51.setString(4, Z5Hou4i7);
					Yj03UD51.setString(5, jBFnN9O3);
					cqJmpuYg = Yj03UD51.executeQuery();
					if (cqJmpuYg.next()) {
						m33hVuLn = cqJmpuYg.getString(1);
						if (cqJmpuYg.wasNull())
							m33hVuLn = "null";
						vHT1JUn9 = cqJmpuYg.getString(2);
						if (cqJmpuYg.wasNull())
							vHT1JUn9 = "null";
						if (vHT1JUn9.equals("****************************USER")) {
							gKfkB9em = cqJmpuYg.getString(3);
							if (cqJmpuYg.wasNull())
								gKfkB9em = "";
							BGMhve5K = cqJmpuYg.getString(4);
							if (cqJmpuYg.wasNull())
								BGMhve5K = "";
							SzjAm0ir = cqJmpuYg.getString(4);
							if (cqJmpuYg.wasNull())
								SzjAm0ir = "";
							ZpW8yv9O = Gadgets.left(gKfkB9em + " " + BGMhve5K + " " + SzjAm0ir, 254).replace(',', ' ')
									.trim();
						} else
							ZpW8yv9O = "null";
						sX2ruwgl.put(Z5Hou4i7, m33hVuLn + "," + vHT1JUn9 + "," + ZpW8yv9O);
					} else
						sX2ruwgl.put(Z5Hou4i7, "null,null,null");
					cqJmpuYg.close();
				}
			}
			if (DebugFile.trace)
				DebugFile.writeln("cc count = " + sX2ruwgl.size());
			if (ecK77mSI != null) {
				for (int NkC8SZWm = 0; NkC8SZWm < ecK77mSI.length; NkC8SZWm++) {
					PXHObp0p = (InternetAddress) ecK77mSI[NkC8SZWm];
					Z5Hou4i7 = Gadgets.left(PXHObp0p.getAddress(), 254);
					Yj03UD51.setString(1, Z5Hou4i7);
					Yj03UD51.setString(2, jBFnN9O3);
					Yj03UD51.setString(3, Z5Hou4i7);
					Yj03UD51.setString(4, Z5Hou4i7);
					Yj03UD51.setString(5, jBFnN9O3);
					cqJmpuYg = Yj03UD51.executeQuery();
					if (cqJmpuYg.next()) {
						m33hVuLn = cqJmpuYg.getString(1);
						if (cqJmpuYg.wasNull())
							m33hVuLn = "null";
						vHT1JUn9 = cqJmpuYg.getString(2);
						if (cqJmpuYg.wasNull())
							vHT1JUn9 = "null";
						if (vHT1JUn9.equals("****************************USER")) {
							gKfkB9em = cqJmpuYg.getString(3);
							if (cqJmpuYg.wasNull())
								gKfkB9em = "";
							BGMhve5K = cqJmpuYg.getString(4);
							if (cqJmpuYg.wasNull())
								BGMhve5K = "";
							SzjAm0ir = cqJmpuYg.getString(4);
							if (cqJmpuYg.wasNull())
								SzjAm0ir = "";
							ZpW8yv9O = Gadgets.left(gKfkB9em + " " + BGMhve5K + " " + SzjAm0ir, 254).replace(',', ' ')
									.trim();
						} else
							ZpW8yv9O = "null";
						uH2qo1Tm.put(Z5Hou4i7, m33hVuLn + "," + vHT1JUn9);
					} else
						uH2qo1Tm.put(Z5Hou4i7, "null,null,null");
					cqJmpuYg.close();
				}
			}
			if (DebugFile.trace)
				DebugFile.writeln("bcc count = " + uH2qo1Tm.size());
			Yj03UD51.close();
			sN6582w5 = "INSERT INTO " + DB.k_inet_addrs
					+ " (gu_mimemsg,id_message,tx_email,tp_recipient,gu_user,gu_contact,gu_company,tx_personal) VALUES ('"
					+ IPRgDBIY + "','" + Ax4MR2qw + "',?,?,?,?,?,?)";
			if (DebugFile.trace)
				DebugFile.writeln("Connection.prepareStatement(" + sN6582w5 + ")");
			HQEsNdBe = oConn.prepareStatement(sN6582w5);
			java.util.Enumeration o7ckujbN;
			String[] OSv9kGRe;
			if (!dVdcFnPM.isEmpty()) {
				o7ckujbN = dVdcFnPM.keys();
				while (o7ckujbN.hasMoreElements()) {
					Z5Hou4i7 = (String) o7ckujbN.nextElement();
					OSv9kGRe = Gadgets.split(dVdcFnPM.getProperty(Z5Hou4i7), ',');
					HQEsNdBe.setString(1, Z5Hou4i7);
					HQEsNdBe.setString(2, "from");
					if (OSv9kGRe[0].equals("null") && OSv9kGRe[1].equals("null")) {
						HQEsNdBe.setNull(3, Types.CHAR);
						HQEsNdBe.setNull(4, Types.CHAR);
						HQEsNdBe.setNull(5, Types.CHAR);
					} else if (OSv9kGRe[1].equals("****************************USER")) {
						HQEsNdBe.setString(3, OSv9kGRe[0]);
						HQEsNdBe.setNull(4, Types.CHAR);
						HQEsNdBe.setNull(5, Types.CHAR);
					} else {
						HQEsNdBe.setNull(3, Types.CHAR);
						HQEsNdBe.setString(4, OSv9kGRe[0].equals("null") ? null : OSv9kGRe[0]);
						HQEsNdBe.setString(5, OSv9kGRe[1].equals("null") ? null : OSv9kGRe[1]);
					}
					if (OSv9kGRe[2].equals("null"))
						HQEsNdBe.setNull(6, Types.VARCHAR);
					else
						HQEsNdBe.setString(6, OSv9kGRe[2]);
					if (DebugFile.trace)
						DebugFile.writeln("Statement.executeUpdate()");
					HQEsNdBe.executeUpdate();
				}
			}
			if (!rQFohdY3.isEmpty()) {
				o7ckujbN = rQFohdY3.keys();
				while (o7ckujbN.hasMoreElements()) {
					Z5Hou4i7 = (String) o7ckujbN.nextElement();
					OSv9kGRe = Gadgets.split(rQFohdY3.getProperty(Z5Hou4i7), ',');
					HQEsNdBe.setString(1, Z5Hou4i7);
					HQEsNdBe.setString(2, "to");
					if (OSv9kGRe[0].equals("null") && OSv9kGRe[1].equals("null")) {
						HQEsNdBe.setNull(3, Types.CHAR);
						HQEsNdBe.setNull(4, Types.CHAR);
						HQEsNdBe.setNull(5, Types.CHAR);
					} else if (OSv9kGRe[1].equals("****************************USER")) {
						HQEsNdBe.setString(3, OSv9kGRe[0]);
						HQEsNdBe.setNull(4, Types.CHAR);
						HQEsNdBe.setNull(5, Types.CHAR);
					} else {
						HQEsNdBe.setNull(3, Types.CHAR);
						HQEsNdBe.setString(4, OSv9kGRe[0].equals("null") ? null : OSv9kGRe[0]);
						HQEsNdBe.setString(5, OSv9kGRe[1].equals("null") ? null : OSv9kGRe[1]);
					}
					if (OSv9kGRe[2].equals("null"))
						HQEsNdBe.setNull(6, Types.VARCHAR);
					else
						HQEsNdBe.setString(6, OSv9kGRe[2]);
					if (DebugFile.trace)
						DebugFile.writeln("Statement.executeUpdate()");
					HQEsNdBe.executeUpdate();
				}
			}
			if (!sX2ruwgl.isEmpty()) {
				o7ckujbN = sX2ruwgl.keys();
				while (o7ckujbN.hasMoreElements()) {
					Z5Hou4i7 = (String) o7ckujbN.nextElement();
					OSv9kGRe = Gadgets.split(sX2ruwgl.getProperty(Z5Hou4i7), ',');
					HQEsNdBe.setString(1, Z5Hou4i7);
					HQEsNdBe.setString(2, "cc");
					if (OSv9kGRe[0].equals("null") && OSv9kGRe[1].equals("null")) {
						HQEsNdBe.setNull(3, Types.CHAR);
						HQEsNdBe.setNull(4, Types.CHAR);
						HQEsNdBe.setNull(5, Types.CHAR);
					} else if (OSv9kGRe[1].equals("****************************USER")) {
						HQEsNdBe.setString(3, OSv9kGRe[0]);
						HQEsNdBe.setString(4, null);
						HQEsNdBe.setString(5, null);
					} else {
						HQEsNdBe.setString(3, null);
						HQEsNdBe.setString(4, OSv9kGRe[0].equals("null") ? null : OSv9kGRe[0]);
						HQEsNdBe.setString(5, OSv9kGRe[1].equals("null") ? null : OSv9kGRe[1]);
					}
					if (OSv9kGRe[2].equals("null"))
						HQEsNdBe.setNull(6, Types.VARCHAR);
					else
						HQEsNdBe.setString(6, OSv9kGRe[2]);
					if (DebugFile.trace)
						DebugFile.writeln("Statement.executeUpdate()");
					HQEsNdBe.executeUpdate();
				}
			}
			if (!uH2qo1Tm.isEmpty()) {
				o7ckujbN = uH2qo1Tm.keys();
				while (o7ckujbN.hasMoreElements()) {
					Z5Hou4i7 = (String) o7ckujbN.nextElement();
					OSv9kGRe = Gadgets.split(uH2qo1Tm.getProperty(Z5Hou4i7), ',');
					HQEsNdBe.setString(1, Z5Hou4i7);
					HQEsNdBe.setString(2, "bcc");
					if (OSv9kGRe[0].equals("null") && OSv9kGRe[1].equals("null")) {
						HQEsNdBe.setNull(3, Types.CHAR);
						HQEsNdBe.setNull(4, Types.CHAR);
						HQEsNdBe.setNull(5, Types.CHAR);
					} else if (OSv9kGRe[1].equals("****************************USER")) {
						HQEsNdBe.setString(3, OSv9kGRe[0]);
						HQEsNdBe.setNull(4, Types.CHAR);
						HQEsNdBe.setNull(5, Types.CHAR);
					} else {
						HQEsNdBe.setNull(3, Types.CHAR);
						HQEsNdBe.setString(4, OSv9kGRe[0].equals("null") ? null : OSv9kGRe[0]);
						HQEsNdBe.setString(5, OSv9kGRe[1].equals("null") ? null : OSv9kGRe[1]);
					}
					if (OSv9kGRe[2].equals("null"))
						HQEsNdBe.setNull(6, Types.VARCHAR);
					else
						HQEsNdBe.setString(6, OSv9kGRe[2]);
					HQEsNdBe.executeUpdate();
				}
			}
			HQEsNdBe.close();
			HQEsNdBe = null;
			HQEsNdBe = oConn.prepareStatement("UPDATE " + DB.k_categories + " SET " + DB.len_size + "=" + DB.len_size
					+ "+" + String.valueOf(C9saSmE4) + " WHERE " + DB.gu_category + "=?");
			HQEsNdBe.setString(1, getCategory().getString(DB.gu_category));
			HQEsNdBe.executeUpdate();
			HQEsNdBe.close();
			HQEsNdBe = null;
			if ((iOpenMode & MODE_MBOX) != 0) {
				if (DebugFile.trace)
					DebugFile.writeln("MboxFile.appendMessage("
							+ (Cezdqe7Q.getContentID() != null ? Cezdqe7Q.getContentID() : "") + ")");
				HhbTHsZZ.appendMessage(r7tQmaEB);
				HhbTHsZZ.close();
				HhbTHsZZ = null;
			}
			if (DebugFile.trace)
				DebugFile.writeln("Connection.commit()");
			oConn.commit();
		} catch (SQLException HgiOOEPN) {
			try {
				if (HhbTHsZZ != null)
					HhbTHsZZ.close();
			} catch (Exception oXhC3taB) {
			}
			try {
				if (null != HQEsNdBe)
					HQEsNdBe.close();
				HQEsNdBe = null;
			} catch (Exception J04tA1tQ) {
			}
			try {
				if (null != Yj03UD51)
					Yj03UD51.close();
				Yj03UD51 = null;
			} catch (Exception m2wigog4) {
			}
			try {
				if (null != oConn)
					oConn.rollback();
			} catch (Exception F8qHQSCt) {
			}
			throw new MessagingException(HgiOOEPN.getMessage(), HgiOOEPN);
		} catch (IOException w7eZqJ86) {
			try {
				if (HhbTHsZZ != null)
					HhbTHsZZ.close();
			} catch (Exception kru03gLX) {
			}
			try {
				if (null != HQEsNdBe)
					HQEsNdBe.close();
				HQEsNdBe = null;
			} catch (Exception H9yuW5Dc) {
			}
			try {
				if (null != Yj03UD51)
					Yj03UD51.close();
				Yj03UD51 = null;
			} catch (Exception W4I2Yjgq) {
			}
			try {
				if (null != oConn)
					oConn.rollback();
			} catch (Exception mCD2j6sA) {
			}
			throw new MessagingException(w7eZqJ86.getMessage(), w7eZqJ86);
		}
		if (DebugFile.trace) {
			DebugFile.decIdent();
			DebugFile.writeln("End DBFolder.appendMessage() : " + IPRgDBIY);
		}
	}

}