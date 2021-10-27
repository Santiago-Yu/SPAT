class n15225386 {
	public ActionForward sendTrackback(ActionMapping LqXyGd1u, ActionForm uOs0IWuR, HttpServletRequest ZbkHtmdW,
			HttpServletResponse P0pJ5cye) throws RollerException {
		ActionForward TXemGsJP = LqXyGd1u.findForward("weblogEdit.page");
		ActionErrors HAXTPVx0 = new ActionErrors();
		WeblogEntryData lYEr7Jrc = null;
		try {
			RollerRequest LeKfCxGN = RollerRequest.getRollerRequest(ZbkHtmdW);
			if (LeKfCxGN.isUserAuthorizedToEdit()) {
				WeblogEntryFormEx HoZrGgdl = (WeblogEntryFormEx) uOs0IWuR;
				String XwruxXwM = HoZrGgdl.getId();
				if (XwruxXwM == null) {
					XwruxXwM = ZbkHtmdW.getParameter(RollerRequest.WEBLOGENTRYID_KEY);
				}
				RollerContext lNMGHdCG = RollerContext.getRollerContext(ZbkHtmdW);
				WeblogManager aqBimt0f = LeKfCxGN.getRoller().getWeblogManager();
				lYEr7Jrc = aqBimt0f.retrieveWeblogEntry(XwruxXwM);
				String uKbkRhU1 = lYEr7Jrc.getTitle();
				PageHelper ALFG3z3X = PageHelper.createPageHelper(ZbkHtmdW, P0pJ5cye);
				ALFG3z3X.setSkipFlag(true);
				String VlRg9J46 = ALFG3z3X.renderPlugins(lYEr7Jrc);
				VlRg9J46 = StringUtils.left(Utilities.removeHTML(VlRg9J46), 255);
				String gtlWaz4w = lNMGHdCG.createEntryPermalink(lYEr7Jrc, ZbkHtmdW, true);
				String CEoMNwh6 = lYEr7Jrc.getWebsite().getName();
				if (HoZrGgdl.getTrackbackUrl() != null) {
					try {
						String x6xWNdZ1 = URLEncoder.encode("title", "UTF-8") + "="
								+ URLEncoder.encode(uKbkRhU1, "UTF-8");
						x6xWNdZ1 += ("&" + URLEncoder.encode("excerpt", "UTF-8") + "="
								+ URLEncoder.encode(VlRg9J46, "UTF-8"));
						x6xWNdZ1 += ("&" + URLEncoder.encode("url", "UTF-8") + "="
								+ URLEncoder.encode(gtlWaz4w, "UTF-8"));
						x6xWNdZ1 += ("&" + URLEncoder.encode("blog_name", "UTF-8") + "="
								+ URLEncoder.encode(CEoMNwh6, "UTF-8"));
						URL XBipGgRZ = new URL(HoZrGgdl.getTrackbackUrl());
						URLConnection e97q1YB3 = XBipGgRZ.openConnection();
						e97q1YB3.setDoOutput(true);
						OutputStreamWriter PoRlqU9t = new OutputStreamWriter(e97q1YB3.getOutputStream());
						PoRlqU9t.write(x6xWNdZ1);
						PoRlqU9t.flush();
						BufferedReader xTyoQDJ3 = new BufferedReader(new InputStreamReader(e97q1YB3.getInputStream()));
						String eE3EQQSa;
						StringBuffer RANKb1Zj = new StringBuffer();
						while ((eE3EQQSa = xTyoQDJ3.readLine()) != null) {
							RANKb1Zj.append(Utilities.escapeHTML(eE3EQQSa, true));
							RANKb1Zj.append("<br />");
						}
						ActionMessages FCDprL67 = new ActionMessages();
						FCDprL67.add(ActionMessages.GLOBAL_MESSAGE,
								new ActionMessage("weblogEdit.trackbackResults", RANKb1Zj));
						saveMessages(ZbkHtmdW, FCDprL67);
						PoRlqU9t.close();
						xTyoQDJ3.close();
					} catch (IOException YxdhKYW3) {
						HAXTPVx0.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.trackback", YxdhKYW3));
					}
				} else {
					HAXTPVx0.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.noTrackbackUrlSpecified"));
				}
				HoZrGgdl.setTrackbackUrl(null);
			} else {
				TXemGsJP = LqXyGd1u.findForward("access-denied");
			}
		} catch (Exception qiAwZ496) {
			mLogger.error(qiAwZ496);
			String dxDuk1NN = qiAwZ496.getMessage();
			if (dxDuk1NN == null) {
				dxDuk1NN = qiAwZ496.getClass().getName();
			}
			HAXTPVx0.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.general", dxDuk1NN));
		}
		if (!HAXTPVx0.isEmpty()) {
			saveErrors(ZbkHtmdW, HAXTPVx0);
		}
		ZbkHtmdW.setAttribute("model", new WeblogEntryPageModel(ZbkHtmdW, P0pJ5cye, LqXyGd1u,
				(WeblogEntryFormEx) uOs0IWuR, WeblogEntryPageModel.EDIT_MODE));
		return TXemGsJP;
	}

}