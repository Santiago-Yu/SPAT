class n7300264 {
	private void saveMimeParts(MimeMessage shVXlOiE, String Yyum5fNj, String Zw2DCbLj, String M7w5dMYC, String wLW3Xor7,
			int xA5QVEPJ, int rxPLUz0I) throws MessagingException, OutOfMemoryError {
		if (DebugFile.trace) {
			DebugFile.writeln("Begin DBFolder.saveMimeParts([Connection], [MimeMessage], " + Zw2DCbLj + ", " + M7w5dMYC
					+ "," + wLW3Xor7 + ", " + String.valueOf(xA5QVEPJ) + ", " + String.valueOf(rxPLUz0I)
					+ ", [Properties])");
			DebugFile.incIdent();
		}
		PreparedStatement OTcSaXu8 = null;
		Blob wF4066rF;
		ByteArrayOutputStream NkrbkSpH;
		int BcvM634c = 0, OZcogwzl = 0, zg82zogc = 0, hhtZnKlk = 0;
		try {
			MimeMultipart BSafYYmD = (MimeMultipart) shVXlOiE.getContent();
			final int Dl4S3IXs = BSafYYmD.getCount();
			if (DebugFile.trace)
				DebugFile.writeln("message has " + String.valueOf(Dl4S3IXs) + " parts");
			if (Dl4S3IXs > 0) {
				if (Yyum5fNj != null && Zw2DCbLj != null && ((iOpenMode & MODE_MBOX) != 0)) {
					BcvM634c = Yyum5fNj.indexOf(Zw2DCbLj, BcvM634c);
					if (BcvM634c > 0) {
						BcvM634c += Zw2DCbLj.length();
						if (DebugFile.trace)
							DebugFile.writeln("found message boundary token at " + String.valueOf(BcvM634c));
					}
				}
				String u8f6A1UE = "INSERT INTO " + DB.k_mime_parts
						+ "(gu_mimemsg,id_message,pg_message,nu_offset,id_part,id_content,id_type,id_disposition,len_part,de_part,tx_md5,file_name,by_content) VALUES ('"
						+ M7w5dMYC + "',?,?,?,?,?,?,?,?,?,NULL,?,?)";
				if (DebugFile.trace)
					DebugFile.writeln("Connection.prepareStatement(" + u8f6A1UE + ")");
				OTcSaXu8 = oConn.prepareStatement(u8f6A1UE);
				for (int mx5MUDXK = 0; mx5MUDXK < Dl4S3IXs; mx5MUDXK++) {
					if (DebugFile.trace)
						DebugFile.writeln("processing part " + String.valueOf(mx5MUDXK));
					BodyPart jiGmdVLf = BSafYYmD.getBodyPart(mx5MUDXK);
					NkrbkSpH = new ByteArrayOutputStream(jiGmdVLf.getSize() > 0 ? jiGmdVLf.getSize() : 131072);
					jiGmdVLf.writeTo(NkrbkSpH);
					if (Yyum5fNj != null && Zw2DCbLj != null && BcvM634c > 0) {
						OZcogwzl = Yyum5fNj.indexOf(Zw2DCbLj, BcvM634c);
						if (OZcogwzl > 0) {
							if (DebugFile.trace)
								DebugFile.writeln("found part " + String.valueOf(mx5MUDXK + rxPLUz0I) + " boundary at "
										+ String.valueOf(OZcogwzl));
							hhtZnKlk = OZcogwzl + Zw2DCbLj.length();
							while (hhtZnKlk < Yyum5fNj.length()) {
								if (Yyum5fNj.charAt(hhtZnKlk) != ' ' && Yyum5fNj.charAt(hhtZnKlk) != '\r'
										&& Yyum5fNj.charAt(hhtZnKlk) != '\n' && Yyum5fNj.charAt(hhtZnKlk) != '\t')
									break;
								else
									hhtZnKlk++;
							}
						}
						zg82zogc = Yyum5fNj.indexOf(Zw2DCbLj, hhtZnKlk);
						if (zg82zogc < 0) {
							if (DebugFile.trace)
								DebugFile.writeln("no next part found");
							zg82zogc = Yyum5fNj.length();
						} else {
							if (DebugFile.trace)
								DebugFile.writeln("next part boundary found at " + String.valueOf(zg82zogc));
						}
					}
					String wQMNv8p1 = jiGmdVLf.getContentType();
					if (wQMNv8p1 != null)
						wQMNv8p1 = MimeUtility.decodeText(wQMNv8p1);
					boolean cI1li3bq = false;
					if ((null != wQMNv8p1) && (null != ((DBStore) getStore()).getSession())) {
						if (DebugFile.trace)
							DebugFile.writeln("Part Content-Type: " + wQMNv8p1.replace('\r', ' ').replace('\n', ' '));
						if (wQMNv8p1.toUpperCase().startsWith("MULTIPART/ALTERNATIVE")
								|| wQMNv8p1.toUpperCase().startsWith("MULTIPART/RELATED")
								|| wQMNv8p1.toUpperCase().startsWith("MULTIPART/SIGNED")) {
							try {
								ByteArrayInputStream HD5JyEMS = new ByteArrayInputStream(NkrbkSpH.toByteArray());
								MimeMessage tzjAOZOK = new MimeMessage(((DBStore) getStore()).getSession(), HD5JyEMS);
								saveMimeParts(tzjAOZOK, Yyum5fNj, getPartsBoundary(tzjAOZOK), M7w5dMYC, wLW3Xor7,
										xA5QVEPJ, rxPLUz0I + Dl4S3IXs);
								HD5JyEMS.close();
								HD5JyEMS = null;
								cI1li3bq = true;
							} catch (Exception hlVbDhIb) {
								if (DebugFile.trace)
									DebugFile.writeln(hlVbDhIb.getClass().getName() + " " + hlVbDhIb.getMessage());
							}
						}
					}
					if (!cI1li3bq) {
						OTcSaXu8.setString(1, wLW3Xor7);
						OTcSaXu8.setBigDecimal(2, new BigDecimal(xA5QVEPJ));
						if ((hhtZnKlk > 0) && ((iOpenMode & MODE_MBOX) != 0))
							OTcSaXu8.setBigDecimal(3, new BigDecimal(hhtZnKlk));
						else
							OTcSaXu8.setNull(3, oConn.getDataBaseProduct() == JDCConnection.DBMS_ORACLE ? Types.NUMERIC
									: Types.DECIMAL);
						OTcSaXu8.setInt(4, mx5MUDXK + rxPLUz0I);
						OTcSaXu8.setString(5, ((javax.mail.internet.MimeBodyPart) jiGmdVLf).getContentID());
						OTcSaXu8.setString(6, Gadgets.left(wQMNv8p1, 254));
						OTcSaXu8.setString(7, Gadgets.left(jiGmdVLf.getDisposition(), 100));
						if ((iOpenMode & MODE_MBOX) != 0)
							OTcSaXu8.setInt(8, zg82zogc - hhtZnKlk);
						else
							OTcSaXu8.setInt(8, jiGmdVLf.getSize() > 0 ? jiGmdVLf.getSize() : NkrbkSpH.size());
						if (jiGmdVLf.getDescription() != null)
							OTcSaXu8.setString(9, Gadgets.left(MimeUtility.decodeText(jiGmdVLf.getDescription()), 254));
						else
							OTcSaXu8.setNull(9, Types.VARCHAR);
						if (DebugFile.trace)
							DebugFile.writeln("file name is " + jiGmdVLf.getFileName());
						if (jiGmdVLf.getFileName() != null)
							OTcSaXu8.setString(10, Gadgets.left(MimeUtility.decodeText(jiGmdVLf.getFileName()), 254));
						else
							OTcSaXu8.setNull(10, Types.VARCHAR);
						if ((iOpenMode & MODE_BLOB) != 0)
							OTcSaXu8.setBinaryStream(11, new ByteArrayInputStream(NkrbkSpH.toByteArray()),
									NkrbkSpH.size());
						else
							OTcSaXu8.setNull(11, Types.LONGVARBINARY);
						if (DebugFile.trace)
							DebugFile.writeln("PreparedStatement.executeUpdate()");
						OTcSaXu8.executeUpdate();
					}
					NkrbkSpH.close();
					NkrbkSpH = null;
					wF4066rF = null;
					if ((iOpenMode & MODE_MBOX) != 0)
						BcvM634c = zg82zogc;
				}
				if (DebugFile.trace)
					DebugFile.writeln("PreparedStatement.close()");
				OTcSaXu8.close();
			}
		} catch (SQLException SfN5b6Ym) {
			if (DebugFile.trace) {
				DebugFile.writeln("SQLException " + SfN5b6Ym.getMessage());
				DebugFile.decIdent();
			}
			if (null != OTcSaXu8) {
				try {
					OTcSaXu8.close();
				} catch (Exception fFuWjPKK) {
				}
			}
			try {
				if (null != oConn)
					oConn.rollback();
			} catch (Exception nIztu4CA) {
			}
			throw new MessagingException(SfN5b6Ym.getMessage(), SfN5b6Ym);
		} catch (IOException IpdIDCDy) {
			if (DebugFile.trace) {
				DebugFile.writeln("IOException " + IpdIDCDy.getMessage());
				DebugFile.decIdent();
			}
			if (null != OTcSaXu8) {
				try {
					OTcSaXu8.close();
				} catch (Exception AM0798zm) {
				}
			}
			throw new MessagingException(IpdIDCDy.getMessage(), IpdIDCDy);
		} catch (Exception o5wpJjhN) {
			if (DebugFile.trace) {
				DebugFile.writeln(o5wpJjhN.getClass().getName() + " " + o5wpJjhN.getMessage());
				DebugFile.decIdent();
			}
			if (null != OTcSaXu8) {
				try {
					OTcSaXu8.close();
				} catch (Exception ylv9wNe8) {
				}
			}
			throw new MessagingException(o5wpJjhN.getMessage(), o5wpJjhN);
		}
		if (DebugFile.trace) {
			DebugFile.decIdent();
			DebugFile.writeln("End DBFolder.saveMimeParts()");
		}
	}

}