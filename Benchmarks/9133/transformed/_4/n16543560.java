class n16543560 {
	public String login() {
		String authSuccess = "false";
		try {
			String errorMesg = "";
			int error;
			if ((error = utils.stringIsNull(passwd)) != -1) {
				errorMesg += rb.getString("passwdField") + ": " + utils.errors[error] + " ";
			} else
				errorMesg = ((error = utils.stringIsEmpty(passwd)) != -1)
						? rb.getString("passwdField") + ": " + utils.errors[error] + " "
						: errorMesg;
			if ((error = utils.stringIsNull(login)) != -1) {
				errorMesg += rb.getString("loginField") + ": " + utils.errors[error] + " ";
			} else
				errorMesg = ((error = utils.stringIsEmpty(login)) != -1)
						? rb.getString("loginField") + ": " + utils.errors[error] + " "
						: errorMesg;
			String[] admins = conf.getProperty("admin").split("\\s");
			boolean admin = false;
			for (int i = 0; i < admins.length; i++) {
				admin = (admins[i].equals(login)) ? true : admin;
			}
			if (!admin) {
				errorMesg += rb.getString("noAdmin");
				session.invalidate();
			} else {
				session.setAttribute("conf", conf);
			}
			if (errorMesg.length() > 0) {
				status = errorMesg;
				System.out.println(status);
				FacesContext context = FacesContext.getCurrentInstance();
				context.renderResponse();
			} else {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				md5.reset();
				md5.update(passwd.getBytes());
				byte[] result = md5.digest();
				StringBuffer hexString = new StringBuffer();
				for (int i = 0; i < result.length; i++) {
					String hex = Integer.toHexString(0xFF & result[i]);
					if (hex.length() == 1) {
						hexString.append('0');
					}
					hexString.append(hex);
				}
				authSuccess = (sqlManager.getPassword(login).equals(hexString.toString())) ? "true" : "false";
				if (authSuccess.equals("false"))
					session.invalidate();
			}
		} catch (NoSuchAlgorithmException nsae) {
			utils.catchExp(nsae);
			status = utils.getStatus();
			stackTrace = (stacktrace) ? utils.getStackTrace() : stackTrace;
			FacesContext.getCurrentInstance().renderResponse();
		} catch (SQLException sqle) {
			utils.catchExp(sqle);
			status = utils.getStatus();
			stackTrace = (stacktrace) ? utils.getStackTrace() : stackTrace;
			FacesContext.getCurrentInstance().renderResponse();
		}
		return authSuccess;
	}

}