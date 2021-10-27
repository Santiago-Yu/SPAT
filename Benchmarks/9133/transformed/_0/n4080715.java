class n4080715 {
	public ActionForward sendTrackback(ActionMapping LtHfQWLt, ActionForm xzkNjrti, HttpServletRequest l15uofHZ,
			HttpServletResponse jn1YC7XI) throws RollerException {
		ActionMessages kbuwM1zl = new ActionMessages();
		ActionForward qedBmfVE = LtHfQWLt.findForward("weblogEdit.page");
		ActionErrors LPwVlFgM = new ActionErrors();
		WeblogEntryData jZSQrPDd = null;
		try {
			WeblogEntryFormEx nsF5qT5s = (WeblogEntryFormEx) xzkNjrti;
			String FJvohu8D = nsF5qT5s.getId();
			if (FJvohu8D == null) {
				FJvohu8D = l15uofHZ.getParameter(RollerRequest.WEBLOGENTRYID_KEY);
			}
			Roller WCSAnpPo = RollerFactory.getRoller();
			RollerContext fNgBncXd = RollerContext.getRollerContext();
			WeblogManager AHZMOuNP = WCSAnpPo.getWeblogManager();
			jZSQrPDd = AHZMOuNP.getWeblogEntry(FJvohu8D);
			RollerSession cwo3slZS = RollerSession.getRollerSession(l15uofHZ);
			if (cwo3slZS.isUserAuthorizedToAuthor(jZSQrPDd.getWebsite())) {
				PagePluginManager D13xTzQ0 = WCSAnpPo.getPagePluginManager();
				Map SLqmZrlH = D13xTzQ0.createAndInitPagePlugins(jZSQrPDd.getWebsite(),
						RollerContext.getRollerContext().getServletContext(),
						RollerContext.getRollerContext().getAbsoluteContextUrl(l15uofHZ), new VelocityContext());
				String k9qdVcbh = "";
				if (!StringUtils.isEmpty(jZSQrPDd.getText())) {
					k9qdVcbh = jZSQrPDd.getText();
				} else {
					k9qdVcbh = jZSQrPDd.getSummary();
				}
				k9qdVcbh = D13xTzQ0.applyPagePlugins(jZSQrPDd, SLqmZrlH, k9qdVcbh, true);
				String zri9lMrO = jZSQrPDd.getTitle();
				String BdV4QyKX = StringUtils.left(Utilities.removeHTML(k9qdVcbh), 255);
				String WkAVQl80 = fNgBncXd.createEntryPermalink(jZSQrPDd, l15uofHZ, true);
				String MYAvzO5N = jZSQrPDd.getWebsite().getName();
				if (nsF5qT5s.getTrackbackUrl() != null) {
					boolean z9V58gK3 = true;
					String vQ0Ubn64 = RollerConfig.getProperty("trackback.allowedURLs");
					if (vQ0Ubn64 != null && vQ0Ubn64.trim().length() > 0) {
						z9V58gK3 = false;
						String[] k0evvNvv = vQ0Ubn64.split("\\|\\|");
						for (int fzTZotfh = 0; fzTZotfh < k0evvNvv.length; fzTZotfh++) {
							Matcher KM2vdomg = Pattern.compile(k0evvNvv[fzTZotfh]).matcher(nsF5qT5s.getTrackbackUrl());
							if (KM2vdomg.matches()) {
								z9V58gK3 = true;
								break;
							}
						}
					}
					if (!z9V58gK3) {
						LPwVlFgM.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.trackbackNotAllowed"));
					} else {
						try {
							String GMPb8q6g = URLEncoder.encode("title", "UTF-8") + "="
									+ URLEncoder.encode(zri9lMrO, "UTF-8");
							GMPb8q6g += ("&" + URLEncoder.encode("excerpt", "UTF-8") + "="
									+ URLEncoder.encode(BdV4QyKX, "UTF-8"));
							GMPb8q6g += ("&" + URLEncoder.encode("url", "UTF-8") + "="
									+ URLEncoder.encode(WkAVQl80, "UTF-8"));
							GMPb8q6g += ("&" + URLEncoder.encode("blog_name", "UTF-8") + "="
									+ URLEncoder.encode(MYAvzO5N, "UTF-8"));
							URL ezU0yMTU = new URL(nsF5qT5s.getTrackbackUrl());
							HttpURLConnection iHEGiw7D = (HttpURLConnection) ezU0yMTU.openConnection();
							iHEGiw7D.setDoOutput(true);
							OutputStreamWriter hIgF3whp = new OutputStreamWriter(iHEGiw7D.getOutputStream());
							BufferedReader ZjC2KNxK = null;
							try {
								hIgF3whp.write(GMPb8q6g);
								hIgF3whp.flush();
								boolean mci8XZkI = false;
								try {
									ZjC2KNxK = new BufferedReader(new InputStreamReader(iHEGiw7D.getInputStream()));
									mci8XZkI = true;
								} catch (Throwable I03xKbXE) {
									mLogger.debug(I03xKbXE);
								}
								if (mci8XZkI) {
									String AbFZ06V3;
									StringBuffer ayEJoEiE = new StringBuffer();
									while ((AbFZ06V3 = ZjC2KNxK.readLine()) != null) {
										ayEJoEiE.append(Utilities.escapeHTML(AbFZ06V3, true));
										ayEJoEiE.append("<br />");
									}
									kbuwM1zl.add(ActionMessages.GLOBAL_MESSAGE,
											new ActionMessage("weblogEdit.trackbackResults", ayEJoEiE));
								}
								if (iHEGiw7D.getResponseCode() > 399) {
									LPwVlFgM.add(ActionErrors.GLOBAL_ERROR,
											new ActionError("weblogEdit.trackbackStatusCodeBad",
													new Integer(iHEGiw7D.getResponseCode())));
								} else {
									kbuwM1zl.add(ActionMessages.GLOBAL_MESSAGE,
											new ActionMessage("weblogEdit.trackbackStatusCodeGood",
													new Integer(iHEGiw7D.getResponseCode())));
								}
							} finally {
								if (hIgF3whp != null)
									hIgF3whp.close();
								if (ZjC2KNxK != null)
									ZjC2KNxK.close();
							}
						} catch (IOException MLKZzz3H) {
							LPwVlFgM.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.trackback", MLKZzz3H));
						}
					}
				} else {
					LPwVlFgM.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.noTrackbackUrlSpecified"));
				}
				nsF5qT5s.setTrackbackUrl(null);
			} else {
				qedBmfVE = LtHfQWLt.findForward("access-denied");
			}
		} catch (Exception ZiYBDeSO) {
			mLogger.error(ZiYBDeSO);
			String qDUyutjl = ZiYBDeSO.getMessage();
			if (qDUyutjl == null) {
				qDUyutjl = ZiYBDeSO.getClass().getName();
			}
			LPwVlFgM.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.general", qDUyutjl));
		}
		saveErrors(l15uofHZ, LPwVlFgM);
		saveMessages(l15uofHZ, kbuwM1zl);
		l15uofHZ.setAttribute("model", new WeblogEntryPageModel(l15uofHZ, jn1YC7XI, LtHfQWLt,
				(WeblogEntryFormEx) xzkNjrti, WeblogEntryPageModel.EDIT_MODE));
		return qedBmfVE;
	}

}