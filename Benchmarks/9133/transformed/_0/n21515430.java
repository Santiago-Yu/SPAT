class n21515430 {
	protected synchronized void doLogin(long d3EzqKgu, String P3xYdQfC)
			throws IOException, AuthenticationFailedException, TimeoutException {
		ChallengeAction X6HmAYFz;
		ManagerResponse m12uUZrj;
		String ibVmkeX1;
		String UDLZ1XZE;
		LoginAction L8fxbbTj;
		ManagerResponse HwwXpl9Z;
		if (socket == null) {
			connect();
		}
		synchronized (protocolIdentifier) {
			if (protocolIdentifier.value == null) {
				try {
					protocolIdentifier.wait(d3EzqKgu);
				} catch (InterruptedException IJPsuV2Y) {
					Thread.currentThread().interrupt();
				}
			}
			if (protocolIdentifier.value == null) {
				disconnect();
				if (reader != null && reader.getTerminationException() != null) {
					throw reader.getTerminationException();
				} else {
					throw new TimeoutException("Timeout waiting for protocol identifier");
				}
			}
		}
		X6HmAYFz = new ChallengeAction("MD5");
		try {
			m12uUZrj = sendAction(X6HmAYFz);
		} catch (Exception BU8nYSgY) {
			disconnect();
			throw new AuthenticationFailedException("Unable to send challenge action", BU8nYSgY);
		}
		if (m12uUZrj instanceof ChallengeResponse) {
			ibVmkeX1 = ((ChallengeResponse) m12uUZrj).getChallenge();
		} else {
			disconnect();
			throw new AuthenticationFailedException(
					"Unable to get challenge from Asterisk. ChallengeAction returned: " + m12uUZrj.getMessage());
		}
		try {
			MessageDigest tdDY5IQg;
			tdDY5IQg = MessageDigest.getInstance("MD5");
			if (ibVmkeX1 != null) {
				tdDY5IQg.update(ibVmkeX1.getBytes());
			}
			if (password != null) {
				tdDY5IQg.update(password.getBytes());
			}
			UDLZ1XZE = ManagerUtil.toHexString(tdDY5IQg.digest());
		} catch (NoSuchAlgorithmException pCjdWIM2) {
			disconnect();
			throw new AuthenticationFailedException("Unable to create login key using MD5 Message Digest", pCjdWIM2);
		}
		L8fxbbTj = new LoginAction(username, "MD5", UDLZ1XZE, P3xYdQfC);
		try {
			HwwXpl9Z = sendAction(L8fxbbTj);
		} catch (Exception OwSVrz0X) {
			disconnect();
			throw new AuthenticationFailedException("Unable to send login action", OwSVrz0X);
		}
		if (HwwXpl9Z instanceof ManagerError) {
			disconnect();
			throw new AuthenticationFailedException(HwwXpl9Z.getMessage());
		}
		state = CONNECTED;
		logger.info("Successfully logged in");
		version = determineVersion();
		writer.setTargetVersion(version);
		logger.info("Determined Asterisk version: " + version);
		ConnectEvent XRMuDe01 = new ConnectEvent(this);
		XRMuDe01.setProtocolIdentifier(getProtocolIdentifier());
		XRMuDe01.setDateReceived(DateUtil.getDate());
		fireEvent(XRMuDe01);
	}

}