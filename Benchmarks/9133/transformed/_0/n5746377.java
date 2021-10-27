class n5746377 {
	@Override
	public JSONObject runCommand(JSONObject JmsZgWZB, HttpSession T07rtsrh) throws DefinedException {
		String OaDR6Du8 = T07rtsrh.getId();
		log.debug("Login -> runCommand SID: " + OaDR6Du8);
		JSONObject XyK2rGdp = new JSONObject();
		boolean m3JR22ki = true;
		String mqQqhanr = null;
		try {
			mqQqhanr = JmsZgWZB.getString(ComConstants.LogIn.Request.USERNAME);
		} catch (JSONException VtKaVM6f) {
			log.error("SessionId=" + OaDR6Du8 + ", Missing username parameter", VtKaVM6f);
			throw new DefinedException(StatusCodesV2.PARAMETER_ERROR);
		}
		String TOW5ogNB = null;
		if (m3JR22ki) {
			try {
				TOW5ogNB = JmsZgWZB.getString(ComConstants.LogIn.Request.PASSWORD);
			} catch (JSONException llpKyjXu) {
				log.error("SessionId=" + OaDR6Du8 + ", Missing password parameter", llpKyjXu);
				throw new DefinedException(StatusCodesV2.PARAMETER_ERROR);
			}
		}
		if (m3JR22ki) {
			MessageDigest S0xdn3IP = null;
			try {
				S0xdn3IP = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException ZhSTgFBe) {
				log.error("SessionId=" + OaDR6Du8 + ", MD5 algorithm does not exist", ZhSTgFBe);
				ZhSTgFBe.printStackTrace();
				throw new DefinedException(StatusCodesV2.INTERNAL_SYSTEM_FAILURE);
			}
			S0xdn3IP.update(TOW5ogNB.getBytes(), 0, TOW5ogNB.length());
			TOW5ogNB = new BigInteger(1, S0xdn3IP.digest()).toString(16);
			UserSession XVbyZRtB = pli.login(mqQqhanr, TOW5ogNB);
			try {
				if (XVbyZRtB != null) {
					T07rtsrh.setAttribute("user", XVbyZRtB);
					XyK2rGdp.put(ComConstants.Response.STATUS_CODE, StatusCodesV2.LOGIN_OK.getStatusCode());
					XyK2rGdp.put(ComConstants.Response.STATUS_MESSAGE, StatusCodesV2.LOGIN_OK.getStatusMessage());
				} else {
					log.error("SessionId=" + OaDR6Du8 + ", Login failed: username=" + mqQqhanr + " not found");
					XyK2rGdp.put(ComConstants.Response.STATUS_CODE,
							StatusCodesV2.LOGIN_USER_OR_PASSWORD_INCORRECT.getStatusCode());
					XyK2rGdp.put(ComConstants.Response.STATUS_MESSAGE,
							StatusCodesV2.LOGIN_USER_OR_PASSWORD_INCORRECT.getStatusMessage());
				}
			} catch (JSONException PWZx2pVb) {
				log.error("SessionId=" + OaDR6Du8 + ", JSON exception occured in response", PWZx2pVb);
				PWZx2pVb.printStackTrace();
				throw new DefinedException(StatusCodesV2.INTERNAL_SYSTEM_FAILURE);
			}
		}
		log.debug("Login <- runCommand SID: " + OaDR6Du8);
		return XyK2rGdp;
	}

}