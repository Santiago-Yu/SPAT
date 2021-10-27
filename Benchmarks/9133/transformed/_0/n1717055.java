class n1717055 {
	public ActionForward dbExecute(ActionMapping UUtkWIJ1, ActionForm J2mv2AZY, HttpServletRequest UW1AQoTJ,
			HttpServletResponse uNjLfhm7) throws DatabaseException {
		SubmitRegistrationForm C8EU2UH8 = (SubmitRegistrationForm) J2mv2AZY;
		if (!C8EU2UH8.getAcceptsEULA()) {
			UW1AQoTJ.setAttribute("acceptsEULA", new Boolean(true));
			UW1AQoTJ.setAttribute("noEula", new Boolean(true));
			return (UUtkWIJ1.findForward("noeula"));
		}
		if (C8EU2UH8.getAction().equals("none")) {
			C8EU2UH8.setAction("submit");
			UW1AQoTJ.setAttribute("UserdataBad", new Boolean(true));
			return (UUtkWIJ1.findForward("success"));
		}
		boolean HkXLiRLt = true;
		if (C8EU2UH8 == null) {
			return (UUtkWIJ1.findForward("failure"));
		}
		if (C8EU2UH8.getLastName().length() < 2) {
			HkXLiRLt = false;
			UW1AQoTJ.setAttribute("LastNameBad", new Boolean(true));
		}
		if (C8EU2UH8.getFirstName().length() < 2) {
			HkXLiRLt = false;
			UW1AQoTJ.setAttribute("FirstNameBad", new Boolean(true));
		}
		EmailValidator m528LcJO = EmailValidator.getInstance();
		if (!m528LcJO.isValid(C8EU2UH8.getEmailAddress())) {
			UW1AQoTJ.setAttribute("EmailBad", new Boolean(true));
			HkXLiRLt = false;
		} else {
			if (database.acquireUserByEmail(C8EU2UH8.getEmailAddress()) != null) {
				UW1AQoTJ.setAttribute("EmailDouble", new Boolean(true));
				HkXLiRLt = false;
			}
		}
		if (C8EU2UH8.getFirstPassword().length() < 5) {
			HkXLiRLt = false;
			UW1AQoTJ.setAttribute("FirstPasswordBad", new Boolean(true));
		}
		if (C8EU2UH8.getSecondPassword().length() < 5) {
			HkXLiRLt = false;
			UW1AQoTJ.setAttribute("SecondPasswordBad", new Boolean(true));
		}
		if (!C8EU2UH8.getSecondPassword().equals(C8EU2UH8.getFirstPassword())) {
			HkXLiRLt = false;
			UW1AQoTJ.setAttribute("PasswordsNotEqual", new Boolean(true));
		}
		if (HkXLiRLt) {
			User ibk9SOIy = new User();
			ibk9SOIy.setFirstName(C8EU2UH8.getFirstName());
			ibk9SOIy.setLastName(C8EU2UH8.getLastName());
			if (!C8EU2UH8.getFirstPassword().equals("")) {
				MessageDigest I5enZybJ;
				try {
					I5enZybJ = MessageDigest.getInstance("SHA");
				} catch (NoSuchAlgorithmException olUsfSkj) {
					throw new DatabaseException("Could not hash password for storage: no such algorithm");
				}
				try {
					I5enZybJ.update(C8EU2UH8.getFirstPassword().getBytes("UTF-8"));
				} catch (UnsupportedEncodingException FObpSMMi) {
					throw new DatabaseException("Could not hash password for storage: no such encoding");
				}
				ibk9SOIy.setPassword((new BASE64Encoder()).encode(I5enZybJ.digest()));
			}
			ibk9SOIy.setEmailAddress(C8EU2UH8.getEmailAddress());
			ibk9SOIy.setHomepage(C8EU2UH8.getHomepage());
			ibk9SOIy.setAddress(C8EU2UH8.getAddress());
			ibk9SOIy.setInstitution(C8EU2UH8.getInstitution());
			ibk9SOIy.setLanguages(C8EU2UH8.getLanguages());
			ibk9SOIy.setDegree(C8EU2UH8.getDegree());
			ibk9SOIy.setNationality(C8EU2UH8.getNationality());
			ibk9SOIy.setTitle(C8EU2UH8.getTitle());
			ibk9SOIy.setActive(true);
			try {
				database.updateUser(ibk9SOIy);
			} catch (DatabaseException yo9xumEd) {
				UW1AQoTJ.setAttribute("UserstoreBad", new Boolean(true));
				return (UUtkWIJ1.findForward("success"));
			}
			UW1AQoTJ.setAttribute("UserdataFine", new Boolean(true));
		} else {
			UW1AQoTJ.setAttribute("UserdataBad", new Boolean(true));
		}
		return (UUtkWIJ1.findForward("success"));
	}

}