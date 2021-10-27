class n16543560 {
	public String login() {
		String RF1WIlWN = "false";
		try {
			String k4a2bw56 = "";
			int OAmcei7F;
			if ((OAmcei7F = utils.stringIsNull(passwd)) != -1) {
				k4a2bw56 += rb.getString("passwdField") + ": " + utils.errors[OAmcei7F] + " ";
			} else if ((OAmcei7F = utils.stringIsEmpty(passwd)) != -1) {
				k4a2bw56 += rb.getString("passwdField") + ": " + utils.errors[OAmcei7F] + " ";
			}
			if ((OAmcei7F = utils.stringIsNull(login)) != -1) {
				k4a2bw56 += rb.getString("loginField") + ": " + utils.errors[OAmcei7F] + " ";
			} else if ((OAmcei7F = utils.stringIsEmpty(login)) != -1) {
				k4a2bw56 += rb.getString("loginField") + ": " + utils.errors[OAmcei7F] + " ";
			}
			String[] HnRCYoU0 = conf.getProperty("admin").split("\\s");
			boolean fvs7YpQK = false;
			for (int AGGYzXhe = 0; AGGYzXhe < HnRCYoU0.length; AGGYzXhe++) {
				if (HnRCYoU0[AGGYzXhe].equals(login)) {
					fvs7YpQK = true;
				}
			}
			if (!fvs7YpQK) {
				k4a2bw56 += rb.getString("noAdmin");
				session.invalidate();
			} else {
				session.setAttribute("conf", conf);
			}
			if (k4a2bw56.length() > 0) {
				status = k4a2bw56;
				System.out.println(status);
				FacesContext A92RAhe1 = FacesContext.getCurrentInstance();
				A92RAhe1.renderResponse();
			} else {
				MessageDigest EbnYaWay = MessageDigest.getInstance("MD5");
				EbnYaWay.reset();
				EbnYaWay.update(passwd.getBytes());
				byte[] LIRhSnuK = EbnYaWay.digest();
				StringBuffer vbnkLxX4 = new StringBuffer();
				for (int E9UmHE88 = 0; E9UmHE88 < LIRhSnuK.length; E9UmHE88++) {
					String WIJMGhEe = Integer.toHexString(0xFF & LIRhSnuK[E9UmHE88]);
					if (WIJMGhEe.length() == 1) {
						vbnkLxX4.append('0');
					}
					vbnkLxX4.append(WIJMGhEe);
				}
				RF1WIlWN = (sqlManager.getPassword(login).equals(vbnkLxX4.toString())) ? "true" : "false";
				if (RF1WIlWN.equals("false"))
					session.invalidate();
			}
		} catch (NoSuchAlgorithmException ceP3ACIR) {
			utils.catchExp(ceP3ACIR);
			status = utils.getStatus();
			if (stacktrace) {
				stackTrace = utils.getStackTrace();
			}
			FacesContext.getCurrentInstance().renderResponse();
		} catch (SQLException D0bd0Abe) {
			utils.catchExp(D0bd0Abe);
			status = utils.getStatus();
			if (stacktrace) {
				stackTrace = utils.getStackTrace();
			}
			FacesContext.getCurrentInstance().renderResponse();
		}
		return RF1WIlWN;
	}

}