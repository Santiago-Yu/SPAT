class n20462345 {
	public ActionForward dbExecute(ActionMapping cbCPJGTG, ActionForm zoZFhuNX, HttpServletRequest OYRFpTBy,
			HttpServletResponse d3WUe3VW) throws DatabaseException {
		String btkhO4in = OYRFpTBy.getParameter("email");
		MessageDigest mqZBoBUr;
		try {
			mqZBoBUr = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException tnsFs8nG) {
			throw new DatabaseException("Could not hash password for storage: no such algorithm");
		}
		mqZBoBUr.update(OYRFpTBy.getParameter("password").getBytes());
		String vtPCqwV9 = (new BASE64Encoder()).encode(mqZBoBUr.digest());
		String UgoqRs4N = OYRFpTBy.getParameter("rememberLogin");
		User JOKMg99q = database.acquireUserByEmail(btkhO4in);
		if (JOKMg99q == null || JOKMg99q.equals(User.anonymous()) || !JOKMg99q.getActive()) {
			return cbCPJGTG.findForward("invalid");
		} else if (JOKMg99q.getPassword().equals(vtPCqwV9)) {
			OYRFpTBy.getSession().setAttribute("login", JOKMg99q);
			if (UgoqRs4N != null) {
				Cookie y7expqAp = new Cookie("bib.username", btkhO4in);
				Cookie dlQSwr77 = new Cookie("bib.password", vtPCqwV9.toString());
				y7expqAp.setPath("/");
				dlQSwr77.setPath("/");
				y7expqAp.setMaxAge(60 * 60 * 24 * 365);
				dlQSwr77.setMaxAge(60 * 60 * 24 * 365);
				d3WUe3VW.addCookie(y7expqAp);
				d3WUe3VW.addCookie(dlQSwr77);
			}
			return cbCPJGTG.findForward("success");
		} else {
			return cbCPJGTG.findForward("invalid");
		}
	}

}