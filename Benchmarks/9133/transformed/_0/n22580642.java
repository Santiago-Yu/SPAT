class n22580642 {
	@Override
	protected void doPost(HttpServletRequest bnjL3lu6, HttpServletResponse l3XVRBuu)
			throws ServletException, IOException {
		long WpAxt8ja = System.currentTimeMillis();
		boolean DiKDy9mf = true;
		boolean Ad21SFc1 = false;
		String LSilePUN = bnjL3lu6.getParameter("sid");
		String aeIF0GCb = CLIENT_SESSION_KEYS.get(bnjL3lu6.getRemoteAddr());
		if (LSilePUN != null && aeIF0GCb != null && LSilePUN.equals(aeIF0GCb))
			Ad21SFc1 = true;
		DataStore GpdDW0pz = DataStore.getConnection();
		if (IPV6_DETECTED) {
			boolean F27DthpA;
			synchronized (SJQServlet.class) {
				F27DthpA = IPV6_WARNED;
				if (!IPV6_WARNED)
					IPV6_WARNED = true;
			}
			if (!F27DthpA)
				LOG.warn(
						"IPv6 interface detected; client restriction settings ignored [restrictions do not support IPv6 addresses]");
		} else {
			String[] DBo2NiUD = GpdDW0pz.getSetting("ValidClients", "").split(";");
			List<IPMatcher> SZ3ZKeb6 = new ArrayList<IPMatcher>();
			if (DBo2NiUD.length == 1 && DBo2NiUD[0].trim().length() == 0) {
				LOG.warn(
						"All client connections are being accepted and processed, please consider setting up client restrictions in SJQ settings");
			} else {
				for (String TMDL4J0h : DBo2NiUD) {
					TMDL4J0h = TMDL4J0h.trim();
					try {
						SZ3ZKeb6.add(new IPMatcher(TMDL4J0h));
					} catch (IPMatcherException rsZ78ieK) {
						LOG.error("Invalid client restriction settings; client restrictions ignored!", rsZ78ieK);
						SZ3ZKeb6.clear();
						break;
					}
				}
				DiKDy9mf = SZ3ZKeb6.size() > 0 ? false : true;
				for (IPMatcher Qj4VhsFL : SZ3ZKeb6) {
					try {
						if (Qj4VhsFL.match(bnjL3lu6.getRemoteAddr())) {
							DiKDy9mf = true;
							break;
						}
					} catch (IPMatcherException GcZzndd2) {
						LOG.error("IPMatcherException", GcZzndd2);
					}
				}
			}
		}
		String LF5IKH0Z = bnjL3lu6.getParameter("proto");
		if (LF5IKH0Z == null || Integer.parseInt(LF5IKH0Z) != SJQ_PROTO)
			throw new RuntimeException(
					"Server is speaking protocol '" + SJQ_PROTO + "', but client is speaking protocol '" + LF5IKH0Z
							+ "'; install a client version that matches the server protocol version!");
		l3XVRBuu.setHeader("Content-Type", "text/plain");
		l3XVRBuu.setDateHeader("Expires", 0);
		l3XVRBuu.setDateHeader("Last-Modified", System.currentTimeMillis());
		l3XVRBuu.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		l3XVRBuu.setHeader("Pragma", "no-cache");
		String aDEuZWSn = bnjL3lu6.getParameter("cmd");
		if (aDEuZWSn == null) {
			DataStore.returnConnection(GpdDW0pz);
			return;
		}
		ActiveClientList yHHZRdy0 = ActiveClientList.getInstance();
		BufferedWriter JVOW9qIE = new BufferedWriter(l3XVRBuu.getWriter());
		if (aDEuZWSn.equals("pop")) {
			if (!DiKDy9mf) {
				LOG.warn("Client IP rejected: " + bnjL3lu6.getRemoteAddr());
				notAuthorized(l3XVRBuu, JVOW9qIE);
			} else {
				yHHZRdy0.add(bnjL3lu6.getRemoteHost());
				ClientParser rqttFQQw = new ClientParser(
						new StringReader(GpdDW0pz.getClientConf(bnjL3lu6.getRemoteHost())));
				String m2tCD0rb = rqttFQQw.getGlobalOption("OFFDAY");
				String iwnkUEBM = rqttFQQw.getGlobalOption("OFFHOUR");
				Calendar aLM6NrFO = Calendar.getInstance();
				if (RangeInterpreter.inRange(aLM6NrFO.get(Calendar.DAY_OF_WEEK), 1, 7, m2tCD0rb)
						|| RangeInterpreter.inRange(aLM6NrFO.get(Calendar.HOUR_OF_DAY), 0, 23, iwnkUEBM)) {
					LOG.warn("Client '" + bnjL3lu6.getRemoteAddr()
							+ "' currently disabled via OFFDAY/OFFHOUR settings.");
					JVOW9qIE.write("null");
				} else {
					Task qknIlG1Y = TaskQueue.getInstance().pop(bnjL3lu6.getRemoteHost(),
							getPopCandidates(bnjL3lu6.getRemoteHost(), rqttFQQw));
					if (qknIlG1Y == null)
						JVOW9qIE.write("null");
					else {
						qknIlG1Y.setResourcesUsed(
								Integer.parseInt(rqttFQQw.getTask(qknIlG1Y.getTaskId()).getOption("RESOURCES")));
						Object W5kRNyvn = null;
						if (qknIlG1Y.getObjType().equals("media"))
							W5kRNyvn = Butler.SageApi.mediaFileAPI
									.GetMediaFileForID(Integer.parseInt(qknIlG1Y.getObjId()));
						else if (qknIlG1Y.getObjType().equals("sysmsg"))
							W5kRNyvn = SystemMessageUtils.getSysMsg(qknIlG1Y.getObjId());
						ClientTask TqymiPD8 = rqttFQQw.getTask(qknIlG1Y.getTaskId());
						JSONObject CIK55K2W = TqymiPD8.toJSONObject(W5kRNyvn);
						String IHljtE9Q = null;
						try {
							if (CIK55K2W != null)
								IHljtE9Q = CIK55K2W.getString(Task.JSON_OBJ_TYPE);
						} catch (JSONException bSW7qi5f) {
							throw new RuntimeException("Invalid ClienTask JSON object conversion!");
						}
						if (W5kRNyvn == null || CIK55K2W == null) {
							LOG.error("Source object has disappeared! [" + qknIlG1Y.getObjType() + "/"
									+ qknIlG1Y.getObjId() + "]");
							TaskQueue.getInstance().updateTask(qknIlG1Y.getObjId(), qknIlG1Y.getTaskId(),
									Task.State.FAILED, qknIlG1Y.getObjType());
							JVOW9qIE.write("null");
						} else if (IHljtE9Q.equals("media")) {
							try {
								long ccbmEJXi = calcRatio(CIK55K2W.getString(Task.JSON_OBJ_ID),
										CIK55K2W.getString(Task.JSON_NORECORDING));
								if (ccbmEJXi > 0 && new FieldTimeUntilNextRecording(null, "<=", ccbmEJXi + "S").run()) {
									LOG.info("Client '" + bnjL3lu6.getRemoteAddr() + "' cannot pop task '"
											+ qknIlG1Y.getObjType() + "/" + qknIlG1Y.getTaskId() + "/"
											+ qknIlG1Y.getObjId()
											+ "'; :NORECORDING option prevents running of this task");
									TaskQueue.getInstance().pushBack(qknIlG1Y);
									JVOW9qIE.write("null");
								} else
									JVOW9qIE.write(CIK55K2W.toString());
							} catch (JSONException jFqtkNfq) {
								throw new RuntimeException(jFqtkNfq);
							}
						} else
							JVOW9qIE.write(CIK55K2W.toString());
					}
				}
			}
		} else if (aDEuZWSn.equals("update")) {
			if (!DiKDy9mf) {
				LOG.warn("Client IP rejected: " + bnjL3lu6.getRemoteAddr());
				notAuthorized(l3XVRBuu, JVOW9qIE);
			} else {
				yHHZRdy0.add(bnjL3lu6.getRemoteHost());
				try {
					Task KQRmEkfA = new Task(new JSONObject(bnjL3lu6.getParameter("data")));
					TaskQueue.getInstance().updateTask(KQRmEkfA);
				} catch (JSONException sV3yvP2W) {
					throw new RuntimeException("Input error; client '" + bnjL3lu6.getRemoteHost() + "', CMD: update",
							sV3yvP2W);
				}
			}
		} else if (aDEuZWSn.equals("showQ")) {
			if (Ad21SFc1)
				JVOW9qIE.write(TaskQueue.getInstance().toJSONArray().toString());
			else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("log")) {
			if (Ad21SFc1) {
				String V5RgyPoD = bnjL3lu6.getParameter("m");
				String Nv2aj0kG = bnjL3lu6.getParameter("t");
				String KHf7Lt5F = bnjL3lu6.getParameter("o");
				if ((V5RgyPoD != null && !V5RgyPoD.equals("0")) && (Nv2aj0kG != null && !Nv2aj0kG.equals("0")))
					JVOW9qIE.write(GpdDW0pz.readLog(V5RgyPoD, Nv2aj0kG, KHf7Lt5F));
				else {
					BufferedReader Jac2odw1 = new BufferedReader(new FileReader("sjq.log"));
					String Vvnzg2Ip;
					while ((Vvnzg2Ip = Jac2odw1.readLine()) != null)
						JVOW9qIE.write(Vvnzg2Ip + "\n");
					Jac2odw1.close();
				}
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("appState")) {
			if (Ad21SFc1)
				JVOW9qIE.write(Butler.dumpAppTrace());
			else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("writeLog")) {
			if (!DiKDy9mf) {
				LOG.warn("Client IP reject: " + bnjL3lu6.getRemoteAddr());
				notAuthorized(l3XVRBuu, JVOW9qIE);
			} else {
				String OAWgOPDs = bnjL3lu6.getParameter("m");
				String HawW8jep;
				if (!OAWgOPDs.equals("-1"))
					HawW8jep = bnjL3lu6.getParameter("t");
				else
					HawW8jep = bnjL3lu6.getRemoteHost();
				String jDCV14WG = bnjL3lu6.getParameter("o");
				if (!OAWgOPDs.equals("0") && Boolean.parseBoolean(GpdDW0pz.getSetting("IgnoreTaskOutput", "false"))) {
					LOG.info("Dropping task output as per settings");
					DataStore.returnConnection(GpdDW0pz);
					return;
				}
				String vPtug4OC = bnjL3lu6.getParameter("data");
				String[] ww49fZoO = StringUtils.splitByWholeSeparator(vPtug4OC, "\r\n");
				if (ww49fZoO == null || ww49fZoO.length == 1)
					ww49fZoO = StringUtils.split(vPtug4OC, '\r');
				if (ww49fZoO == null || ww49fZoO.length == 1)
					ww49fZoO = StringUtils.split(vPtug4OC, '\n');
				long fLmQqZDU = System.currentTimeMillis();
				for (String C4gRnQS7 : ww49fZoO)
					GpdDW0pz.logForTaskClient(OAWgOPDs, HawW8jep, C4gRnQS7, fLmQqZDU, jDCV14WG);
				if (ww49fZoO.length > 0)
					GpdDW0pz.flushLogs();
			}
		} else if (aDEuZWSn.equals("ruleset")) {
			if (Ad21SFc1)
				JVOW9qIE.write(GpdDW0pz.getSetting("ruleset", ""));
			else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("saveRuleset")) {
			if (Ad21SFc1) {
				GpdDW0pz.setSetting("ruleset", bnjL3lu6.getParameter("data"));
				JVOW9qIE.write("Success");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("getClients")) {
			if (Ad21SFc1)
				JVOW9qIE.write(ActiveClientList.getInstance().toJSONArray().toString());
			else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("loadClnt")) {
			if (Ad21SFc1)
				JVOW9qIE.write(GpdDW0pz.getClientConf(bnjL3lu6.getParameter("id")));
			else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("saveClnt")) {
			if (Ad21SFc1) {
				if (GpdDW0pz.saveClientConf(bnjL3lu6.getParameter("id"), bnjL3lu6.getParameter("data")))
					JVOW9qIE.write("Success");
				else
					JVOW9qIE.write("Failed");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("history")) {
			if (Ad21SFc1) {
				int CM17l2CX, Z80r4I1q;
				try {
					CM17l2CX = Integer.parseInt(bnjL3lu6.getParameter("start"));
					Z80r4I1q = Integer.parseInt(bnjL3lu6.getParameter("limit"));
				} catch (NumberFormatException wUkERy35) {
					CM17l2CX = 0;
					Z80r4I1q = -1;
				}
				JVOW9qIE.write(GpdDW0pz.getJobHistory(Integer.parseInt(bnjL3lu6.getParameter("t")), CM17l2CX, Z80r4I1q,
						bnjL3lu6.getParameter("sort")).toString());
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("getSrvSetting")) {
			if (Ad21SFc1)
				JVOW9qIE.write(GpdDW0pz.getSetting(bnjL3lu6.getParameter("var"), ""));
			else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("setSrvSetting")) {
			if (Ad21SFc1) {
				GpdDW0pz.setSetting(bnjL3lu6.getParameter("var"), bnjL3lu6.getParameter("val"));
				JVOW9qIE.write("Success");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("setFileCleaner")) {
			if (Ad21SFc1) {
				GpdDW0pz.setSetting("DelRegex", bnjL3lu6.getParameter("orphan"));
				GpdDW0pz.setSetting("IfRegex", bnjL3lu6.getParameter("parent"));
				GpdDW0pz.setSetting("IgnoreRegex", bnjL3lu6.getParameter("ignore"));
				new Thread(new FileCleaner()).start();
				JVOW9qIE.write("Success");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("getFileCleanerSettings")) {
			if (Ad21SFc1) {
				JVOW9qIE.write(GpdDW0pz.getSetting("DelRegex", "") + "\n");
				JVOW9qIE.write(GpdDW0pz.getSetting("IfRegex", "") + "\n");
				JVOW9qIE.write(GpdDW0pz.getSetting("IgnoreRegex", ""));
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("writeSrvSettings")) {
			if (Ad21SFc1) {
				try {
					GpdDW0pz.setSettings(new JSONObject(bnjL3lu6.getParameter("data")));
				} catch (JSONException GR85c7e1) {
					throw new RuntimeException(GR85c7e1);
				}
				JVOW9qIE.write("Success");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("readSrvSettings")) {
			if (Ad21SFc1)
				JVOW9qIE.write(GpdDW0pz.readSettings().toString());
			else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("login")) {
			String pdfEPWRD = GpdDW0pz.getSetting("password", "");
			try {
				MessageDigest KjWEE7UD = MessageDigest.getInstance("MD5");
				KjWEE7UD.update(bnjL3lu6.getParameter("password").getBytes());
				String CtzI4w3t = new String(KjWEE7UD.digest());
				if (pdfEPWRD.length() > 0 && pdfEPWRD.equals(CtzI4w3t)) {
					JVOW9qIE.write("Success");
					int rcExBHG2 = new java.util.Random().nextInt();
					l3XVRBuu.addHeader("SJQ-Session-Token", Integer.toString(rcExBHG2));
					CLIENT_SESSION_KEYS.put(bnjL3lu6.getRemoteAddr(), Integer.toString(rcExBHG2));
				} else
					JVOW9qIE.write("BadPassword");
			} catch (NoSuchAlgorithmException BdbYXvSY) {
				JVOW9qIE.write(BdbYXvSY.getLocalizedMessage());
			}
		} else if (aDEuZWSn.equals("editPwd")) {
			try {
				MessageDigest UycQjCzq = MessageDigest.getInstance("MD5");
				String xRyeUjX9 = GpdDW0pz.getSetting("password", "");
				String dQ2jNrYA = bnjL3lu6.getParameter("old");
				UycQjCzq.update(dQ2jNrYA.getBytes());
				dQ2jNrYA = new String(UycQjCzq.digest());
				UycQjCzq.reset();
				String vqIU6xxd = bnjL3lu6.getParameter("new");
				String TV5qBE70 = bnjL3lu6.getParameter("conf");
				if (!xRyeUjX9.equals(dQ2jNrYA))
					JVOW9qIE.write("BadOld");
				else if (!vqIU6xxd.equals(TV5qBE70) || vqIU6xxd.length() == 0)
					JVOW9qIE.write("BadNew");
				else {
					UycQjCzq.update(vqIU6xxd.getBytes());
					vqIU6xxd = new String(UycQjCzq.digest());
					GpdDW0pz.setSetting("password", vqIU6xxd);
					JVOW9qIE.write("Success");
				}
			} catch (NoSuchAlgorithmException GmNfOGMg) {
				JVOW9qIE.write(GmNfOGMg.getLocalizedMessage());
			}
		} else if (aDEuZWSn.equals("runStats")) {
			if (Ad21SFc1) {
				JSONObject sROv17uQ = new JSONObject();
				try {
					sROv17uQ.put("last", Long.parseLong(GpdDW0pz.getSetting("LastRun", "0")));
					sROv17uQ.put("next", Long.parseLong(GpdDW0pz.getSetting("NextRun", "0")));
					JVOW9qIE.write(sROv17uQ.toString());
				} catch (JSONException KtSxLF14) {
					JVOW9qIE.write(KtSxLF14.getLocalizedMessage());
				}
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("runQLoader")) {
			if (Ad21SFc1) {
				Butler.wakeQueueLoader();
				JVOW9qIE.write("Success");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("delActiveQ")) {
			if (Ad21SFc1) {
				if (TaskQueue.getInstance().delete(bnjL3lu6.getParameter("m"), bnjL3lu6.getParameter("t")))
					JVOW9qIE.write("Success");
				else
					JVOW9qIE.write("Failed");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("clearActiveQ")) {
			if (Ad21SFc1) {
				if (TaskQueue.getInstance().clear())
					JVOW9qIE.write("Success");
				else
					JVOW9qIE.write("Failed");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("editPri")) {
			if (Ad21SFc1) {
				try {
					int LwJogHDH = Integer.parseInt(bnjL3lu6.getParameter("p"));
					if (TaskQueue.getInstance().editPriority(bnjL3lu6.getParameter("m"), bnjL3lu6.getParameter("t"),
							LwJogHDH))
						JVOW9qIE.write("Success");
					else
						JVOW9qIE.write("Failed");
				} catch (NumberFormatException ywa6ngJ8) {
					JVOW9qIE.write("Failed");
				}
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("clearHistory")) {
			if (Ad21SFc1) {
				if (GpdDW0pz.clear(Integer.parseInt(bnjL3lu6.getParameter("t"))))
					JVOW9qIE.write("Success");
				else
					JVOW9qIE.write("Failed");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("delHistRow")) {
			if (Ad21SFc1) {
				if (GpdDW0pz.delTask(bnjL3lu6.getParameter("m"), bnjL3lu6.getParameter("t"),
						Integer.parseInt(bnjL3lu6.getParameter("y")), bnjL3lu6.getParameter("o")))
					JVOW9qIE.write("Success");
				else
					JVOW9qIE.write("Failed");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("rmLog")) {
			if (Ad21SFc1) {
				String bQv9Uj5n = bnjL3lu6.getParameter("m");
				String L0fjgkwo = bnjL3lu6.getParameter("t");
				String V6YRzKqw = bnjL3lu6.getParameter("o");
				if (bQv9Uj5n.equals("0") && L0fjgkwo.equals("0") && V6YRzKqw.equals("null")) {
					JVOW9qIE.write("Failed: Can't delete server log file (sjq.log) while SageTV is running!");
				} else if (GpdDW0pz.clearLog(bQv9Uj5n, L0fjgkwo, V6YRzKqw))
					JVOW9qIE.write("Success");
				else
					JVOW9qIE.write("Failed");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("qryMediaFile")) {
			if (Ad21SFc1) {
				JSONArray WEqYDsjb = new JSONArray();
				MediaFileAPI.List cUdILiuq = Butler.SageApi.mediaFileAPI.GetMediaFiles(GpdDW0pz.getMediaMask());
				String F0bNrQiB = bnjL3lu6.getParameter("q");
				int YzHxsOqN = Integer.parseInt(bnjL3lu6.getParameter("m"));
				for (MediaFileAPI.MediaFile ewS6pCIp : cUdILiuq) {
					if ((F0bNrQiB.matches("\\d+") && Integer.toString(ewS6pCIp.GetMediaFileID()).startsWith(F0bNrQiB))
							|| ewS6pCIp.GetMediaTitle().matches(".*" + Pattern.quote(F0bNrQiB) + ".*")
							|| fileSegmentMatches(ewS6pCIp, F0bNrQiB)) {
						JSONObject wH0eEZjC = new JSONObject();
						try {
							wH0eEZjC.put("value", ewS6pCIp.GetFileForSegment(0).getAbsolutePath());
							String GplsbZtw = null;
							if (ewS6pCIp.GetMediaFileAiring() != null
									&& ewS6pCIp.GetMediaFileAiring().GetShow() != null)
								GplsbZtw = ewS6pCIp.GetMediaFileAiring().GetShow().GetShowEpisode();
							String JjVnq2av;
							if (GplsbZtw != null && GplsbZtw.length() > 0)
								JjVnq2av = ewS6pCIp.GetMediaTitle() + ": " + GplsbZtw;
							else
								JjVnq2av = ewS6pCIp.GetMediaTitle();
							wH0eEZjC.put("display", ewS6pCIp.GetMediaFileID() + " - " + JjVnq2av);
							WEqYDsjb.put(wH0eEZjC);
							if (WEqYDsjb.length() >= YzHxsOqN)
								break;
						} catch (JSONException jsTSBoad) {
							jsTSBoad.printStackTrace(System.out);
						}
					}
				}
				JVOW9qIE.write(WEqYDsjb.toString());
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("debugMediaFile")) {
			if (Ad21SFc1) {
				if (Butler.debugQueueLoader(bnjL3lu6.getParameter("f")))
					JVOW9qIE.write("Success");
				else
					JVOW9qIE.write("Failed");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("killTask")) {
			if (Ad21SFc1) {
				if (TaskQueue.getInstance().killTask(bnjL3lu6.getParameter("m"), bnjL3lu6.getParameter("t"),
						bnjL3lu6.getParameter("o")))
					JVOW9qIE.write("Success");
				else
					JVOW9qIE.write("Failed");
			} else
				notAuthorized(l3XVRBuu, JVOW9qIE);
		} else if (aDEuZWSn.equals("keepAlive")) {
			JVOW9qIE.write(Boolean.toString(!TaskQueue.getInstance().isTaskKilled(bnjL3lu6.getParameter("m"),
					bnjL3lu6.getParameter("t"), bnjL3lu6.getParameter("o"))));
		}
		JVOW9qIE.close();
		DataStore.returnConnection(GpdDW0pz);
		LOG.info("Servlet POST request completed [" + (System.currentTimeMillis() - WpAxt8ja) + "ms]");
		return;
	}

}