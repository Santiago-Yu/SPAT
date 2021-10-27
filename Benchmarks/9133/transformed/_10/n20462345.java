class n20462345 {
	public ActionForward dbExecute(ActionMapping pMapping, ActionForm pForm, HttpServletRequest pRequest,
			HttpServletResponse pResponse) throws DatabaseException {
		MessageDigest md;
		String email = pRequest.getParameter("email");
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			throw new DatabaseException("Could not hash password for storage: no such algorithm");
		}
		md.update(pRequest.getParameter("password").getBytes());
		String password = (new BASE64Encoder()).encode(md.digest());
		String remember = pRequest.getParameter("rememberLogin");
		User user = database.acquireUserByEmail(email);
		if (user == null || user.equals(User.anonymous()) || !user.getActive()) {
			return pMapping.findForward("invalid");
		} else if (user.getPassword().equals(password)) {
			pRequest.getSession().setAttribute("login", user);
			if (remember != null) {
				Cookie passcookie = new Cookie("bib.password", password.toString());
				Cookie usercookie = new Cookie("bib.username", email);
				usercookie.setPath("/");
				passcookie.setPath("/");
				usercookie.setMaxAge(60 * 60 * 24 * 365);
				passcookie.setMaxAge(60 * 60 * 24 * 365);
				pResponse.addCookie(usercookie);
				pResponse.addCookie(passcookie);
			}
			return pMapping.findForward("success");
		} else {
			return pMapping.findForward("invalid");
		}
	}

}