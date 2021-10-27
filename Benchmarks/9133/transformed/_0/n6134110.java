class n6134110 {
	@Override
	protected void doPost(HttpServletRequest YsT1PXXx, HttpServletResponse ZJhnSfDy)
			throws ServletException, IOException {
		if (doAuth(YsT1PXXx, ZJhnSfDy)) {
			Connection TTCzZGHr = null;
			try {
				int DQKveh1N = icsm.getIntChatSession(YsT1PXXx).getUID();
				TTCzZGHr = getJDBCConnection(icsm.getHeavyDatabaseConnectionPool(), YsT1PXXx, ZJhnSfDy,
						HttpServletResponse.SC_SERVICE_UNAVAILABLE);
				if (TTCzZGHr == null)
					return;
				ResultSet lEq264LS = IntChatDatabaseOperations.executeQuery(TTCzZGHr,
						"SELECT id FROM ic_messagetypes WHERE templatename='"
								+ IntChatConstants.MessageTemplates.IC_FILES + "' LIMIT 1");
				if (lEq264LS.next()) {
					int jCj122Zd = lEq264LS.getInt("id");
					String hVN8O2as = YsT1PXXx.getHeader(IntChatConstants.HEADER_FILERECIPIENTS);
					lEq264LS.getStatement().close();
					lEq264LS = null;
					if (hVN8O2as != null) {
						HashMap<String, String> Oi0DxBcH = Tools
								.parseMultiparamLine(YsT1PXXx.getHeader("Content-Disposition"));
						String JWzow9Zb = URLDecoder.decode(Oi0DxBcH.get("filename"), IntChatServerDefaults.ENCODING);
						long PiOfeZVa = (YsT1PXXx.getHeader("Content-Length") != null
								? Long.parseLong(YsT1PXXx.getHeader("Content-Length"))
								: -1);
						PiOfeZVa = (YsT1PXXx.getHeader(IntChatConstants.HEADER_FILELENGTH) != null
								? Long.parseLong(YsT1PXXx.getHeader(IntChatConstants.HEADER_FILELENGTH))
								: PiOfeZVa);
						long hq4946up = RuntimeParameters.getIntValue(ParameterNames.MAX_FILE_SIZE) * 1048576;
						if (hq4946up > 0 && PiOfeZVa > hq4946up) {
							YsT1PXXx.getInputStream().close();
							ZJhnSfDy.sendError(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE);
							return;
						}
						long HVqJvypq = System.currentTimeMillis();
						long b5Zak9uF = ic_messages_id_seq.nextval();
						IntChatServletInputStream ASo9BLcO = new IntChatServletInputStream(YsT1PXXx);
						IntChatMessage aC2RIyGG = null;
						TTCzZGHr.setAutoCommit(false);
						try {
							PreparedStatement j6llr3VF = TTCzZGHr.prepareStatement(
									"INSERT INTO ic_messages (id, tid, mhead, mbody, mdate, sid) VALUES (?, ?, ?, ?, ?, ?)");
							j6llr3VF.setLong(1, b5Zak9uF);
							j6llr3VF.setInt(2, jCj122Zd);
							j6llr3VF.setString(3, JWzow9Zb);
							j6llr3VF.setString(4, Long.toString(PiOfeZVa));
							j6llr3VF.setLong(5, HVqJvypq);
							j6llr3VF.setInt(6, DQKveh1N);
							j6llr3VF.executeUpdate();
							j6llr3VF.close();
							if (!insertBLOB(TTCzZGHr, ASo9BLcO, PiOfeZVa, b5Zak9uF, hq4946up)) {
								TTCzZGHr.rollback();
								return;
							}
							aC2RIyGG = new IntChatMessage(false, jCj122Zd, null, null);
							String[] MCgz5QKI = hVN8O2as.split(",");
							int hdsY9U54;
							for (int e1utytgt = 0; e1utytgt < MCgz5QKI.length; e1utytgt++) {
								hdsY9U54 = Integer.parseInt(MCgz5QKI[e1utytgt].trim());
								IntChatDatabaseOperations.executeUpdate(TTCzZGHr,
										"INSERT INTO ic_recipients (mid, rid) VALUES ('" + b5Zak9uF + "', '" + hdsY9U54
												+ "')");
								aC2RIyGG.addTo(hdsY9U54);
							}
							TTCzZGHr.commit();
						} catch (Exception skMWTPzB) {
							TTCzZGHr.rollback();
							throw skMWTPzB;
						} finally {
							TTCzZGHr.setAutoCommit(true);
						}
						if (aC2RIyGG != null) {
							aC2RIyGG.setID(b5Zak9uF);
							aC2RIyGG.setDate(new Timestamp(HVqJvypq - TimeZone.getDefault().getOffset(HVqJvypq)));
							aC2RIyGG.setFrom(DQKveh1N);
							aC2RIyGG.setHeadText(JWzow9Zb);
							aC2RIyGG.setBodyText(Long.toString(PiOfeZVa));
							icsm.onClientSentMessage(aC2RIyGG);
						}
						ZJhnSfDy.setStatus(HttpServletResponse.SC_OK);
					} else {
						ZJhnSfDy.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					}
				} else {
					ZJhnSfDy.setStatus(HttpServletResponse.SC_NOT_FOUND);
				}
				if (lEq264LS != null) {
					lEq264LS.getStatement().close();
					lEq264LS = null;
				}
			} catch (RetryRequest JNKwJPFO) {
				throw JNKwJPFO;
			} catch (Exception wvVF4FP6) {
				Tools.makeErrorResponse(YsT1PXXx, ZJhnSfDy, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, wvVF4FP6);
			} finally {
				try {
					if (TTCzZGHr != null)
						icsm.getHeavyDatabaseConnectionPool().releaseConnection(TTCzZGHr);
				} catch (Exception iMAWlBOe) {
				}
			}
		}
	}

}