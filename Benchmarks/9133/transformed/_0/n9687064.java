class n9687064 {
	public static synchronized int registerVote(String PyiN6jDM, byte[] JJFx7wpC, byte[] Qa8bXyDK, byte[] yD3WfT9P,
			Config RZLkpy3v) {
		if (PyiN6jDM == null) {
			LOGGER.error("registerVote::IDV null");
			return C_addVote_BOH;
		}
		if (JJFx7wpC == null) {
			LOGGER.error("registerVote::T1 null");
			return C_addVote_BOH;
		}
		if (yD3WfT9P == null) {
			LOGGER.error("registerVote::envelope null");
			return C_addVote_BOH;
		}
		LOGGER.info("registering vote started");
		Connection H7Vrz3Dz = null;
		PreparedStatement ZOw8fH7u = null;
		boolean fjPI2mIZ = true;
		int Esh7hBZ7 = C_addVote_BOH;
		try {
			ByteArrayInputStream UhYrdgk1 = new ByteArrayInputStream(yD3WfT9P);
			SAXReader otC890uk = new SAXReader();
			Document oSD5DLbc = otC890uk.read(UhYrdgk1);
			if (LOGGER.isTraceEnabled())
				LOGGER.trace(oSD5DLbc.asXML());
			String k3mp1HTs = new String(Base64.encodeBase64(JJFx7wpC), "utf-8");
			String VjesWOYe = new String(Base64.encodeBase64(Qa8bXyDK), "utf-8");
			String gkhOAiiJ = new String(Base64.encodeBase64(yD3WfT9P), "utf-8");
			LOGGER.trace("loading jdbc driver ...");
			Class.forName("com.mysql.jdbc.Driver");
			LOGGER.trace("... loaded");
			H7Vrz3Dz = DriverManager.getConnection(RZLkpy3v.getSconn());
			fjPI2mIZ = H7Vrz3Dz.getAutoCommit();
			H7Vrz3Dz.setAutoCommit(false);
			String sagviESj = "" + " INSERT INTO votes(IDVotazione, T1, signByT2 , envelope) "
					+ " VALUES           (?          , ? , ?        , ?       ) ";
			ZOw8fH7u = H7Vrz3Dz.prepareStatement(sagviESj);
			ZOw8fH7u.setString(1, PyiN6jDM);
			ZOw8fH7u.setString(2, k3mp1HTs);
			ZOw8fH7u.setString(3, VjesWOYe);
			ZOw8fH7u.setString(4, gkhOAiiJ);
			ZOw8fH7u.executeUpdate();
			ZOw8fH7u.close();
			LOGGER.debug("vote saved for references, now start the parsing");
			sagviESj = "" + " INSERT INTO risposte (IDVotazione, T1, IDquestion , myrisposta,freetext) "
					+ " VALUES               (?          , ? , ?          , ?         ,?)        ";
			ZOw8fH7u = H7Vrz3Dz.prepareStatement(sagviESj);
			Element UmzYQYzj, ntxJDgoi, zPZhAJXw;
			List<Element> aMgxEeZn;
			String mFITgnYf, V4DDHehY, KlU5iyLt, o4uhAIwp, PvCv63k4;
			Iterator<Element> MwO46NMv = oSD5DLbc.selectNodes("/poll/manifest/question").iterator();
			while (MwO46NMv.hasNext()) {
				UmzYQYzj = (Element) MwO46NMv.next();
				KlU5iyLt = o4uhAIwp = "";
				mFITgnYf = UmzYQYzj.attributeValue("id");
				ntxJDgoi = UmzYQYzj.element("items");
				PvCv63k4 = ntxJDgoi == null ? "" : ntxJDgoi.attributeValue("type");
				zPZhAJXw = UmzYQYzj.element("myrisposta");
				V4DDHehY = zPZhAJXw == null ? "" : zPZhAJXw.getText();
				if (V4DDHehY.equals(Votazione.C_TAG_WHITE_XML)) {
					KlU5iyLt = C_TAG_WHITE;
				} else if (V4DDHehY.equals(Votazione.C_TAG_NULL_XML)) {
					KlU5iyLt = C_TAG_NULL;
				} else {
					if (!V4DDHehY.equals("") && LOGGER.isDebugEnabled())
						LOGGER.warn("Risposta text should be empty!: " + V4DDHehY);
					KlU5iyLt = C_TAG_BUG;
					if (PvCv63k4.equals("selection")) {
						Element goTrxsEB = zPZhAJXw.element("item");
						String sngX9fyk = goTrxsEB.attributeValue("index");
						if (sngX9fyk != null) {
							KlU5iyLt = sngX9fyk;
							if (KlU5iyLt.equals("0"))
								o4uhAIwp = goTrxsEB.getText();
						}
					} else if (PvCv63k4.equals("borda")) {
						aMgxEeZn = zPZhAJXw.elements("item");
						if (aMgxEeZn != null) {
							KlU5iyLt = "";
							String d06Vksda, DO8IzBe3;
							for (Element FZzWkmp6 : aMgxEeZn) {
								d06Vksda = FZzWkmp6.attributeValue("index");
								DO8IzBe3 = FZzWkmp6.attributeValue("tokens");
								if (d06Vksda.equals("0"))
									o4uhAIwp = FZzWkmp6.getText();
								if (KlU5iyLt.length() > 0)
									KlU5iyLt += ",";
								KlU5iyLt += d06Vksda + ":" + DO8IzBe3;
							}
						}
					} else if (PvCv63k4.equals("ordering")) {
						aMgxEeZn = zPZhAJXw.elements("item");
						if (aMgxEeZn != null) {
							KlU5iyLt = "";
							String cAzn78dv, vfnXf8o8;
							for (Element PKw1m9dN : aMgxEeZn) {
								cAzn78dv = PKw1m9dN.attributeValue("index");
								vfnXf8o8 = PKw1m9dN.attributeValue("order");
								if (cAzn78dv == null) {
									continue;
								}
								if (cAzn78dv.equals("0"))
									o4uhAIwp = PKw1m9dN.getText();
								if (KlU5iyLt.length() > 0)
									KlU5iyLt += ",";
								KlU5iyLt += cAzn78dv + ":" + vfnXf8o8;
							}
						}
					} else if (PvCv63k4.equals("multiple")) {
						aMgxEeZn = zPZhAJXw.elements("item");
						if (aMgxEeZn != null) {
							KlU5iyLt = "";
							String Ajrhk1Gy;
							for (Element pdCao4Ya : aMgxEeZn) {
								Ajrhk1Gy = pdCao4Ya.attributeValue("index");
								if (Ajrhk1Gy.equals("0"))
									o4uhAIwp = pdCao4Ya.getText();
								if (KlU5iyLt.length() > 0)
									KlU5iyLt += ",";
								KlU5iyLt += Ajrhk1Gy;
							}
						}
					} else if (PvCv63k4.equals("free")) {
						o4uhAIwp = zPZhAJXw.element("item").getText();
						KlU5iyLt = "";
					}
				}
				if (LOGGER.isTraceEnabled()) {
					LOGGER.trace("ID_QUESTION: " + mFITgnYf);
					LOGGER.trace("question type: " + PvCv63k4);
					LOGGER.trace("risposta: " + KlU5iyLt);
					LOGGER.trace("freetext: " + o4uhAIwp);
				}
				if (KlU5iyLt.equals(C_TAG_BUG)) {
					LOGGER.error("Invalid answer");
					LOGGER.error("T1: " + k3mp1HTs);
					LOGGER.error("ID_QUESTION: " + mFITgnYf);
					LOGGER.error("question type: " + PvCv63k4);
				}
				ZOw8fH7u.setString(1, PyiN6jDM);
				ZOw8fH7u.setString(2, k3mp1HTs);
				ZOw8fH7u.setString(3, mFITgnYf);
				ZOw8fH7u.setString(4, KlU5iyLt);
				ZOw8fH7u.setString(5, o4uhAIwp);
				ZOw8fH7u.addBatch();
			}
			ZOw8fH7u.executeBatch();
			ZOw8fH7u.close();
			H7Vrz3Dz.commit();
			Esh7hBZ7 = C_addVote_OK;
			LOGGER.info("registering vote end successfully");
		} catch (SQLException Q83HsVSJ) {
			try {
				H7Vrz3Dz.rollback();
			} catch (Exception DHfpK90C) {
			}
			if (Q83HsVSJ.getErrorCode() == 1062) {
				Esh7hBZ7 = C_addVote_DUPLICATE;
				LOGGER.error("error while registering vote (duplication)");
			} else {
				Esh7hBZ7 = C_addVote_BOH;
				LOGGER.error("error while registering vote", Q83HsVSJ);
			}
		} catch (UnsupportedEncodingException LkRNHxlm) {
			try {
				H7Vrz3Dz.rollback();
			} catch (Exception mtg90cFf) {
			}
			LOGGER.error("encoding error", LkRNHxlm);
			Esh7hBZ7 = C_addVote_BOH;
		} catch (DocumentException VpJvF5QZ) {
			LOGGER.error("DocumentException", VpJvF5QZ);
			Esh7hBZ7 = C_addVote_BOH;
		} catch (ClassNotFoundException gxHd5Flj) {
			try {
				H7Vrz3Dz.rollback();
			} catch (Exception CKz8j7Le) {
			}
			LOGGER.error("error while registering vote", gxHd5Flj);
			Esh7hBZ7 = C_addVote_BOH;
		} catch (Exception UT2Jrf8P) {
			try {
				H7Vrz3Dz.rollback();
			} catch (Exception y4Y9as90) {
			}
			LOGGER.error("Unexpected exception while registering vote", UT2Jrf8P);
			Esh7hBZ7 = C_addVote_BOH;
		} finally {
			try {
				H7Vrz3Dz.setAutoCommit(fjPI2mIZ);
				H7Vrz3Dz.close();
			} catch (Exception oaVyL52u) {
			}
			;
		}
		return Esh7hBZ7;
	}

}