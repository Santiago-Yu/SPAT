class n15225386 {
	public ActionForward sendTrackback(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws RollerException {
		ActionErrors errors = new ActionErrors();
		ActionForward forward = mapping.findForward("weblogEdit.page");
		WeblogEntryData entry = null;
		try {
			RollerRequest rreq = RollerRequest.getRollerRequest(request);
			if (rreq.isUserAuthorizedToEdit()) {
				WeblogEntryFormEx form = (WeblogEntryFormEx) actionForm;
				String entryid = form.getId();
				if (entryid == null) {
					entryid = request.getParameter(RollerRequest.WEBLOGENTRYID_KEY);
				}
				RollerContext rctx = RollerContext.getRollerContext(request);
				WeblogManager wmgr = rreq.getRoller().getWeblogManager();
				entry = wmgr.retrieveWeblogEntry(entryid);
				String title = entry.getTitle();
				PageHelper pageHelper = PageHelper.createPageHelper(request, response);
				pageHelper.setSkipFlag(true);
				String excerpt = pageHelper.renderPlugins(entry);
				excerpt = StringUtils.left(Utilities.removeHTML(excerpt), 255);
				String url = rctx.createEntryPermalink(entry, request, true);
				String blog_name = entry.getWebsite().getName();
				if (form.getTrackbackUrl() != null) {
					try {
						String data = URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8");
						data += ("&" + URLEncoder.encode("excerpt", "UTF-8") + "="
								+ URLEncoder.encode(excerpt, "UTF-8"));
						data += ("&" + URLEncoder.encode("url", "UTF-8") + "=" + URLEncoder.encode(url, "UTF-8"));
						data += ("&" + URLEncoder.encode("blog_name", "UTF-8") + "="
								+ URLEncoder.encode(blog_name, "UTF-8"));
						URL tburl = new URL(form.getTrackbackUrl());
						URLConnection conn = tburl.openConnection();
						conn.setDoOutput(true);
						OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
						wr.write(data);
						wr.flush();
						String line;
						BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						StringBuffer resultBuff = new StringBuffer();
						ActionMessages resultMsg = new ActionMessages();
						while ((line = rd.readLine()) != null) {
							resultBuff.append(Utilities.escapeHTML(line, true));
							resultBuff.append("<br />");
						}
						resultMsg.add(ActionMessages.GLOBAL_MESSAGE,
								new ActionMessage("weblogEdit.trackbackResults", resultBuff));
						saveMessages(request, resultMsg);
						wr.close();
						rd.close();
					} catch (IOException e) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.trackback", e));
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
			if (msg == null) {
				msg = e.getClass().getName();
			}
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.general", msg));
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}
		request.setAttribute("model", new WeblogEntryPageModel(request, response, mapping,
				(WeblogEntryFormEx) actionForm, WeblogEntryPageModel.EDIT_MODE));
		return forward;
	}

}