class n8708052 {
	public ActionForward dbExecute(ActionMapping hmzvtjI6, ActionForm hGEmZGxW, HttpServletRequest wW4JC2dS,
			HttpServletResponse xmKaDlK7) throws DatabaseException {
		Integer l6IOD570;
		SubmitUserForm EiOI2Fzq = (SubmitUserForm) hGEmZGxW;
		if (wW4JC2dS.getParameter("key") == null) {
			l6IOD570 = EiOI2Fzq.getPrimaryKey();
		} else {
			l6IOD570 = Integer.parseInt(wW4JC2dS.getParameter("key"));
		}
		User Mz5aFDoG = (User) (wW4JC2dS.getSession().getAttribute("login"));
		if ((Mz5aFDoG == null) || (!Mz5aFDoG.getAdminRights() && (Mz5aFDoG.getPrimaryKey() != l6IOD570))) {
			return (hmzvtjI6.findForward("denied"));
		}
		if (Mz5aFDoG.getAdminRights()) {
			wW4JC2dS.setAttribute("isAdmin", new Boolean(true));
		}
		if (Mz5aFDoG.getPDFRights()) {
			wW4JC2dS.setAttribute("pdfRights", Boolean.TRUE);
		}
		User mS89EQb4 = database.acquireUserByPrimaryKey(l6IOD570);
		if (mS89EQb4.isSuperAdmin() && !Mz5aFDoG.isSuperAdmin()) {
			return (hmzvtjI6.findForward("denied"));
		}
		wW4JC2dS.setAttribute("user", mS89EQb4);
		wW4JC2dS.setAttribute("taxonomy", database.acquireTaxonomy());
		if (EiOI2Fzq.getAction().equals("none")) {
			EiOI2Fzq.setPrimaryKey(mS89EQb4.getPrimaryKey());
		}
		if (EiOI2Fzq.getAction().equals("edit")) {
			FormError ViUf4g8L = EiOI2Fzq.validateFields();
			if (ViUf4g8L != null) {
				if (ViUf4g8L.getFormFieldErrors().get("firstName") != null) {
					wW4JC2dS.setAttribute("FirstNameBad", new Boolean(true));
				}
				if (ViUf4g8L.getFormFieldErrors().get("lastName") != null) {
					wW4JC2dS.setAttribute("LastNameBad", new Boolean(true));
				}
				if (ViUf4g8L.getFormFieldErrors().get("emailAddress") != null) {
					wW4JC2dS.setAttribute("EmailAddressBad", new Boolean(true));
				}
				if (ViUf4g8L.getFormFieldErrors().get("mismatchPassword") != null) {
					wW4JC2dS.setAttribute("mismatchPassword", new Boolean(true));
				}
				if (ViUf4g8L.getFormFieldErrors().get("shortPassword") != null) {
					wW4JC2dS.setAttribute("shortPassword", new Boolean(true));
				}
				return (hmzvtjI6.findForward("invalid"));
			}
			mS89EQb4.setFirstName(EiOI2Fzq.getFirstName());
			mS89EQb4.setLastName(EiOI2Fzq.getLastName());
			mS89EQb4.setEmailAddress(EiOI2Fzq.getEmailAddress());
			if (!EiOI2Fzq.getFirstPassword().equals("")) {
				MessageDigest naDDsVag;
				try {
					naDDsVag = MessageDigest.getInstance("SHA");
				} catch (NoSuchAlgorithmException SrbpnHGS) {
					throw new DatabaseException("Could not hash password for storage: no such algorithm");
				}
				try {
					naDDsVag.update(EiOI2Fzq.getFirstPassword().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException kiJlv7Ll) {
					throw new DatabaseException("Could not hash password for storage: no such encoding");
				}
				mS89EQb4.setPassword((new BASE64Encoder()).encode(naDDsVag.digest()));
			}
			mS89EQb4.setTitle(EiOI2Fzq.getTitle());
			mS89EQb4.setDegree(EiOI2Fzq.getDegree());
			mS89EQb4.setAddress(EiOI2Fzq.getAddress());
			mS89EQb4.setNationality(EiOI2Fzq.getNationality());
			mS89EQb4.setLanguages(EiOI2Fzq.getLanguages());
			mS89EQb4.setHomepage(EiOI2Fzq.getHomepage());
			mS89EQb4.setInstitution(EiOI2Fzq.getInstitution());
			if (wW4JC2dS.getParameter("hideEmail") != null) {
				if (wW4JC2dS.getParameter("hideEmail").equals("on")) {
					mS89EQb4.setHideEmail(true);
				}
			} else {
				mS89EQb4.setHideEmail(false);
			}
			User D1ShvFpS = database.acquireUserByPrimaryKey(mS89EQb4.getPrimaryKey());
			if (Mz5aFDoG.isSuperAdmin()) {
				if (wW4JC2dS.getParameter("admin") != null) {
					mS89EQb4.setAdminRights(true);
				} else {
					if (!D1ShvFpS.isSuperAdmin()) {
						mS89EQb4.setAdminRights(false);
					}
				}
			} else {
				mS89EQb4.setAdminRights(D1ShvFpS.getAdminRights());
			}
			if (Mz5aFDoG.isAdmin())
				if (wW4JC2dS.getParameter("PDFRights") != null)
					mS89EQb4.setPDFRights(true);
				else
					mS89EQb4.setPDFRights(false);
			if (Mz5aFDoG.isAdmin()) {
				if (!D1ShvFpS.isAdmin() || !D1ShvFpS.isSuperAdmin()) {
					if (wW4JC2dS.getParameter("active") != null) {
						mS89EQb4.setActive(true);
					} else {
						mS89EQb4.setActive(false);
					}
				} else {
					mS89EQb4.setActive(D1ShvFpS.getActive());
				}
			}
			if (Mz5aFDoG.isAdmin() || Mz5aFDoG.isSuperAdmin()) {
				String[] tuTwutjg = wW4JC2dS.getParameterValues("categories");
				mS89EQb4.setModeratorRights(new Categories());
				if (tuTwutjg != null) {
					try {
						for (int pSF85xo2 = 0; pSF85xo2 < tuTwutjg.length; pSF85xo2++) {
							Integer KqZKH2eQ = Integer.parseInt(tuTwutjg[pSF85xo2]);
							Category T3coove8 = database.acquireCategoryByPrimaryKey(KqZKH2eQ);
							mS89EQb4.getModeratorRights().add(T3coove8);
						}
					} catch (NumberFormatException VHP1MGVi) {
						throw new DatabaseException("Invalid category key.");
					}
				}
			}
			if (!Mz5aFDoG.isAdmin() && !Mz5aFDoG.isSuperAdmin()) {
				mS89EQb4.setAdminRights(false);
				mS89EQb4.setSuperAdminRights(false);
			}
			database.updateUser(mS89EQb4);
			if (Mz5aFDoG.getPrimaryKey() == mS89EQb4.getPrimaryKey()) {
				wW4JC2dS.getSession().setAttribute("login", mS89EQb4);
			}
			wW4JC2dS.setAttribute("helpKey", l6IOD570);
			if (Mz5aFDoG.isAdmin() || Mz5aFDoG.isSuperAdmin()) {
				return (hmzvtjI6.findForward("adminfinished"));
			}
			return (hmzvtjI6.findForward("finished"));
		}
		return (hmzvtjI6.findForward("success"));
	}

}