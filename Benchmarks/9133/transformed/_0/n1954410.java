class n1954410 {
	protected ActionForward doExecute(ActionMapping HN9wtq2O, ActionForm wRDjVxKB, HttpServletRequest V0la1tQs,
			HttpServletResponse spqpTSIe) throws Exception {
		ActionMessages LvuyERw3 = new ActionMessages();
		try {
			boolean nSKPvd2F = FileUpload.isMultipartContent(V0la1tQs);
			Mail jKCwgyUa = getMailInstance(V0la1tQs);
			if (nSKPvd2F) {
				Map K66pIXGi = new HashMap();
				Vector BnafPIka = new Vector();
				List p4i1cXau = diskFileUpload.parseRequest(V0la1tQs);
				Iterator Kz1Kx6N4 = p4i1cXau.iterator();
				while (Kz1Kx6N4.hasNext()) {
					FileItem AUgnvA4a = (FileItem) Kz1Kx6N4.next();
					if (AUgnvA4a.isFormField()) {
						if (AUgnvA4a.getFieldName().equals("forwardAttachments")) {
							String[] YK36xby8 = AUgnvA4a.getString().split(":");
							MailPartObj j1Lh7ECF = jKCwgyUa.getAttachment(YK36xby8[0], YK36xby8[1]);
							BnafPIka.addElement(j1Lh7ECF);
						} else {
							K66pIXGi.put(AUgnvA4a.getFieldName(), AUgnvA4a.getString());
						}
					} else {
						if (!StringUtils.isBlank(AUgnvA4a.getName())) {
							ByteArrayOutputStream nhquqHge = null;
							try {
								nhquqHge = new ByteArrayOutputStream();
								IOUtils.copy(AUgnvA4a.getInputStream(), nhquqHge);
								MailPartObj yie8bdBM = new MailPartObj();
								yie8bdBM.setAttachent(nhquqHge.toByteArray());
								yie8bdBM.setContentType(AUgnvA4a.getContentType());
								yie8bdBM.setName(AUgnvA4a.getName());
								yie8bdBM.setSize(AUgnvA4a.getSize());
								BnafPIka.addElement(yie8bdBM);
							} catch (Exception VKQ3mhCz) {
							} finally {
								IOUtils.closeQuietly(nhquqHge);
							}
						}
					}
				}
				String wdylEUsd = "";
				if (K66pIXGi.get("taBody") != null) {
					wdylEUsd = (String) K66pIXGi.get("taBody");
				} else if (K66pIXGi.get("taReplyBody") != null) {
					wdylEUsd = (String) K66pIXGi.get("taReplyBody");
				}
				Preferences pITm1zUa = getPreferencesInstance(V0la1tQs);
				Send fMkO7ife = getSendInstance(V0la1tQs);
				String G0KmEJZ7 = (String) K66pIXGi.get("mid");
				if (StringUtils.isBlank(G0KmEJZ7)) {
					V0la1tQs.setAttribute("action", "compose");
				} else {
					V0la1tQs.setAttribute("action", "reply");
				}
				Boolean JnhnEUlS = null;
				if (StringUtils.isBlank((String) K66pIXGi.get("isHtml"))) {
					JnhnEUlS = new Boolean(pITm1zUa.getPreferences().isHtmlMessage());
				} else {
					JnhnEUlS = Boolean.valueOf((String) K66pIXGi.get("isHtml"));
				}
				fMkO7ife.send(G0KmEJZ7, Integer.parseInt((String) K66pIXGi.get("identity")),
						(String) K66pIXGi.get("to"), (String) K66pIXGi.get("cc"), (String) K66pIXGi.get("bcc"),
						(String) K66pIXGi.get("subject"), wdylEUsd, BnafPIka, JnhnEUlS.booleanValue(),
						Charset.defaultCharset().displayName(), (String) K66pIXGi.get("priority"));
			} else {
				LvuyERw3.add("general",
						new ActionMessage(ExceptionCode.ERROR_MESSAGES_PREFIX + "mail.send", "The form is null"));
				V0la1tQs.setAttribute("exception", "The form is null");
				V0la1tQs.setAttribute("newLocation", null);
				doTrace(V0la1tQs, DLog.ERROR, getClass(), "The form is null");
			}
		} catch (Exception HCY5KKm2) {
			String NXHt3nvN = ExceptionUtilities.parseMessage(HCY5KKm2);
			if (NXHt3nvN == null) {
				NXHt3nvN = "NullPointerException";
			}
			LvuyERw3.add("general", new ActionMessage(ExceptionCode.ERROR_MESSAGES_PREFIX + "general", NXHt3nvN));
			V0la1tQs.setAttribute("exception", NXHt3nvN);
			doTrace(V0la1tQs, DLog.ERROR, getClass(), NXHt3nvN);
		} finally {
		}
		if (LvuyERw3.isEmpty()) {
			doTrace(V0la1tQs, DLog.INFO, getClass(), "OK");
			return HN9wtq2O.findForward(Constants.ACTION_SUCCESS_FORWARD);
		} else {
			saveErrors(V0la1tQs, LvuyERw3);
			return HN9wtq2O.findForward(Constants.ACTION_FAIL_FORWARD);
		}
	}

}