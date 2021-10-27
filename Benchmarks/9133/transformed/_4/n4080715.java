class n4080715 {
	public ActionForward sendTrackback(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws RollerException {
		ActionMessages resultMsg = new ActionMessages();
		ActionForward forward = mapping.findForward("weblogEdit.page");
		ActionErrors errors = new ActionErrors();
		WeblogEntryData entry = null;
		try {
			WeblogEntryFormEx form = (WeblogEntryFormEx) actionForm;
			String entryid = form.getId();
			entryid = (entryid == null) ? request.getParameter(RollerRequest.WEBLOGENTRYID_KEY) : entryid;
			Roller roller = RollerFactory.getRoller();
			RollerContext rctx = RollerContext.getRollerContext();
			WeblogManager wmgr = roller.getWeblogManager();
			entry = wmgr.getWeblogEntry(entryid);
			RollerSession rses = RollerSession.getRollerSession(request);
			if (rses.isUserAuthorizedToAuthor(entry.getWebsite())) {
				PagePluginManager ppmgr = roller.getPagePluginManager();
				Map plugins = ppmgr.createAndInitPagePlugins(entry.getWebsite(),
						RollerContext.getRollerContext().getServletContext(),
						RollerContext.getRollerContext().getAbsoluteContextUrl(request), new VelocityContext());
				String content = "";
				content = (!StringUtils.isEmpty(entry.getText())) ? entry.getText() : entry.getSummary();
				content = ppmgr.applyPagePlugins(entry, plugins, content, true);
				String title = entry.getTitle();
				String excerpt = StringUtils.left(Utilities.removeHTML(content), 255);
				String url = rctx.createEntryPermalink(entry, request, true);
				String blog_name = entry.getWebsite().getName();
				if (form.getTrackbackUrl() != null) {
					boolean allowTrackback = true;
					String allowedURLs = RollerConfig.getProperty("trackback.allowedURLs");
					if (allowedURLs != null && allowedURLs.trim().length() > 0) {
						allowTrackback = false;
						String[] splitURLs = allowedURLs.split("\\|\\|");
						for (int i = 0; i < splitURLs.length; i++) {
							Matcher m = Pattern.compile(splitURLs[i]).matcher(form.getTrackbackUrl());
							if (m.matches()) {
								allowTrackback = true;
								break;
							}
						}
					}
					if (!allowTrackback) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.trackbackNotAllowed"));
					} else {
						try {
							String data = URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8");
							data += ("&" + URLEncoder.encode("excerpt", "UTF-8") + "="
									+ URLEncoder.encode(excerpt, "UTF-8"));
							data += ("&" + URLEncoder.encode("url", "UTF-8") + "=" + URLEncoder.encode(url, "UTF-8"));
							data += ("&" + URLEncoder.encode("blog_name", "UTF-8") + "="
									+ URLEncoder.encode(blog_name, "UTF-8"));
							URL tburl = new URL(form.getTrackbackUrl());
							HttpURLConnection conn = (HttpURLConnection) tburl.openConnection();
							conn.setDoOutput(true);
							OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
							BufferedReader rd = null;
							try {
								wr.write(data);
								wr.flush();
								boolean inputAvailable = false;
								try {
									rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
									inputAvailable = true;
								} catch (Throwable e) {
									mLogger.debug(e);
								}
								if (inputAvailable) {
									String line;
									StringBuffer resultBuff = new StringBuffer();
									while ((line = rd.readLine()) != null) {
										resultBuff.append(Utilities.escapeHTML(line, true));
										resultBuff.append("<br />");
									}
									resultMsg.add(ActionMessages.GLOBAL_MESSAGE,
											new ActionMessage("weblogEdit.trackbackResults", resultBuff));
								}
								if (conn.getResponseCode() > 399) {
									errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(
											"weblogEdit.trackbackStatusCodeBad", new Integer(conn.getResponseCode())));
								} else {
									resultMsg.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
											"weblogEdit.trackbackStatusCodeGood", new Integer(conn.getResponseCode())));
								}
							} finally {
								if (wr != null)
									wr.close();
								if (rd != null)
									rd.close();
							}
						} catch (IOException e) {
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.trackback", e));
						}
					}
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.noTrackbackUrlSpecified"));
				}
				form.setTrackbackUrl(null);
			} else {
				forward = mapping.findForward("access-denied");
			}
		} catch (Exception e) {
			mLogger.error(e);
			String msg = e.getMessage();
			msg = (msg == null) ? e.getClass().getName() : msg;
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.general", msg));
		}
		saveErrors(request, errors);
		saveMessages(request, resultMsg);
		request.setAttribute("model", new WeblogEntryPageModel(request, response, mapping,
				(WeblogEntryFormEx) actionForm, WeblogEntryPageModel.EDIT_MODE));
		return forward;
	}

}