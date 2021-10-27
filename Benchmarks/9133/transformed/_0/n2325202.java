class n2325202 {
	protected ActionForward doExecute(ActionMapping fMlGUkyj, ActionForm n19kC0Gn, HttpServletRequest qUdIfdUe,
			HttpServletResponse NmbxqQsY) throws Exception {
		ActionMessages uTyuXjP9 = new ActionMessages();
		try {
			boolean gZt0giCD = FileUpload.isMultipartContent(qUdIfdUe);
			Store o2vsD0Bk = getStoreInstance(qUdIfdUe);
			if (gZt0giCD) {
				Map Qi80sArn = new HashMap();
				Vector kvLjT06o = new Vector();
				List hN9SJuxe = diskFileUpload.parseRequest(qUdIfdUe);
				Iterator uu5HkgZ0 = hN9SJuxe.iterator();
				while (uu5HkgZ0.hasNext()) {
					FileItem hJ9nNMlN = (FileItem) uu5HkgZ0.next();
					if (hJ9nNMlN.isFormField()) {
						Qi80sArn.put(hJ9nNMlN.getFieldName(), hJ9nNMlN.getString());
					} else {
						if (!StringUtils.isBlank(hJ9nNMlN.getName())) {
							ByteArrayOutputStream lBLm3whB = null;
							try {
								lBLm3whB = new ByteArrayOutputStream();
								IOUtils.copy(hJ9nNMlN.getInputStream(), lBLm3whB);
								MailPartObj BrqybDd8 = new MailPartObj();
								BrqybDd8.setAttachent(lBLm3whB.toByteArray());
								BrqybDd8.setContentType(hJ9nNMlN.getContentType());
								BrqybDd8.setName(hJ9nNMlN.getName());
								BrqybDd8.setSize(hJ9nNMlN.getSize());
								kvLjT06o.addElement(BrqybDd8);
							} catch (Exception FOUQzSN6) {
							} finally {
								IOUtils.closeQuietly(lBLm3whB);
							}
						}
					}
				}
				if (kvLjT06o.size() > 0) {
					o2vsD0Bk.send(kvLjT06o, 0, Charset.defaultCharset().displayName());
				}
			} else {
				uTyuXjP9.add("general",
						new ActionMessage(ExceptionCode.ERROR_MESSAGES_PREFIX + "mail.send", "The form is null"));
				qUdIfdUe.setAttribute("exception", "The form is null");
				qUdIfdUe.setAttribute("newLocation", null);
				doTrace(qUdIfdUe, DLog.ERROR, getClass(), "The form is null");
			}
		} catch (Exception BgZQxxaM) {
			String myMxY9b9 = ExceptionUtilities.parseMessage(BgZQxxaM);
			if (myMxY9b9 == null) {
				myMxY9b9 = "NullPointerException";
			}
			uTyuXjP9.add("general", new ActionMessage(ExceptionCode.ERROR_MESSAGES_PREFIX + "general", myMxY9b9));
			qUdIfdUe.setAttribute("exception", myMxY9b9);
			doTrace(qUdIfdUe, DLog.ERROR, getClass(), myMxY9b9);
		} finally {
		}
		if (uTyuXjP9.isEmpty()) {
			doTrace(qUdIfdUe, DLog.INFO, getClass(), "OK");
			return fMlGUkyj.findForward(Constants.ACTION_SUCCESS_FORWARD);
		} else {
			saveErrors(qUdIfdUe, uTyuXjP9);
			return fMlGUkyj.findForward(Constants.ACTION_FAIL_FORWARD);
		}
	}

}