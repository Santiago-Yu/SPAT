class n16995204 {
	protected ActionForward doExecute(ActionMapping lfDXZ1HQ, ActionForm be3iXVlL, HttpServletRequest FZ5sNa9j,
			HttpServletResponse ISyLVtD0) throws Exception {
		ActionMessages hX4WMziZ = new ActionMessages();
		try {
			boolean sYruXPwK = FileUpload.isMultipartContent(FZ5sNa9j);
			if (sYruXPwK) {
				Map gyvnZyTT = new HashMap();
				Vector TnRdPHcs = new Vector();
				List wUZsp2lS = diskFileUpload.parseRequest(FZ5sNa9j);
				Iterator KBPwNdPB = wUZsp2lS.iterator();
				while (KBPwNdPB.hasNext()) {
					FileItem l6G7VG6C = (FileItem) KBPwNdPB.next();
					if (l6G7VG6C.isFormField()) {
						gyvnZyTT.put(l6G7VG6C.getFieldName(), l6G7VG6C.getString());
					} else {
						if (!StringUtils.isBlank(l6G7VG6C.getName())) {
							ByteArrayOutputStream c1wKNeEn = null;
							try {
								c1wKNeEn = new ByteArrayOutputStream();
								IOUtils.copy(l6G7VG6C.getInputStream(), c1wKNeEn);
								MailPartObj ngr3xaW9 = new MailPartObj();
								ngr3xaW9.setAttachent(c1wKNeEn.toByteArray());
								ngr3xaW9.setContentType(l6G7VG6C.getContentType());
								ngr3xaW9.setName(l6G7VG6C.getName());
								ngr3xaW9.setSize(l6G7VG6C.getSize());
								TnRdPHcs.addElement(ngr3xaW9);
							} catch (Exception Oosk2O0w) {
							} finally {
								IOUtils.closeQuietly(c1wKNeEn);
							}
						}
					}
				}
				String R9HvrBKO = "";
				if (gyvnZyTT.get("taBody") != null) {
					R9HvrBKO = (String) gyvnZyTT.get("taBody");
				} else if (gyvnZyTT.get("taReplyBody") != null) {
					R9HvrBKO = (String) gyvnZyTT.get("taReplyBody");
				}
				Preferences x0Bgn0Qc = getPreferencesInstance(FZ5sNa9j);
				Send q2BulVHj = getSendInstance(FZ5sNa9j);
				String o2PxeQzx = (String) gyvnZyTT.get("mid");
				q2BulVHj.saveDraft(o2PxeQzx, Integer.parseInt((String) gyvnZyTT.get("identity")),
						(String) gyvnZyTT.get("to"), (String) gyvnZyTT.get("cc"), (String) gyvnZyTT.get("bcc"),
						(String) gyvnZyTT.get("subject"), R9HvrBKO, TnRdPHcs, x0Bgn0Qc.getPreferences().isHtmlMessage(),
						Charset.defaultCharset().displayName(), (String) gyvnZyTT.get("priority"));
			} else {
				hX4WMziZ.add("general",
						new ActionMessage(ExceptionCode.ERROR_MESSAGES_PREFIX + "mail.send", "The form is null"));
				FZ5sNa9j.setAttribute("exception", "The form is null");
				FZ5sNa9j.setAttribute("newLocation", null);
				doTrace(FZ5sNa9j, DLog.ERROR, getClass(), "The form is null");
			}
		} catch (Exception D3TYB4Kg) {
			String PfSLdy7y = ExceptionUtilities.parseMessage(D3TYB4Kg);
			if (PfSLdy7y == null) {
				PfSLdy7y = "NullPointerException";
			}
			hX4WMziZ.add("general", new ActionMessage(ExceptionCode.ERROR_MESSAGES_PREFIX + "general", PfSLdy7y));
			FZ5sNa9j.setAttribute("exception", PfSLdy7y);
			doTrace(FZ5sNa9j, DLog.ERROR, getClass(), PfSLdy7y);
		} finally {
		}
		if (hX4WMziZ.isEmpty()) {
			doTrace(FZ5sNa9j, DLog.INFO, getClass(), "OK");
			return lfDXZ1HQ.findForward(Constants.ACTION_SUCCESS_FORWARD);
		} else {
			saveErrors(FZ5sNa9j, hX4WMziZ);
			return lfDXZ1HQ.findForward(Constants.ACTION_FAIL_FORWARD);
		}
	}

}