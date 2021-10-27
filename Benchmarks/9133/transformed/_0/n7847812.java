class n7847812 {
	protected synchronized void doLogin(long eH5uNT0H, String TCkYBVxz)
			throws IOException, AuthenticationFailedException, TimeoutException {
		ChallengeAction gIlPDnQL;
		ManagerResponse s8HWk2sj;
		String ljVtCY0I;
		String uHIBVpV2;
		LoginAction LZ3vNBbD;
		ManagerResponse felTBuWz;
		if (socket == null) {
			connect();
		}
		if (!socket.isConnected()) {
			connect();
		}
		synchronized (protocolIdentifier) {
			if (protocolIdentifier.value == null) {
				try {
					protocolIdentifier.wait(eH5uNT0H);
				} catch (InterruptedException dk7siFlp) {
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
		gIlPDnQL = new ChallengeAction("MD5");
		try {
			s8HWk2sj = sendAction(gIlPDnQL);
		} catch (Exception odtMTxbK) {
			disconnect();
			throw new AuthenticationFailedException("Unable to send challenge action", odtMTxbK);
		}
		if (s8HWk2sj instanceof ChallengeResponse) {
			ljVtCY0I = ((ChallengeResponse) s8HWk2sj).getChallenge();
		} else {
			disconnect();
			throw new AuthenticationFailedException(
					"Unable to get challenge from Asterisk. ChallengeAction returned: " + s8HWk2sj.getMessage());
		}
		try {
			MessageDigest CiZgXyIx;
			CiZgXyIx = MessageDigest.getInstance("MD5");
			if (ljVtCY0I != null) {
				CiZgXyIx.update(ljVtCY0I.getBytes());
			}
			if (password != null) {
				CiZgXyIx.update(password.getBytes());
			}
			uHIBVpV2 = ManagerUtil.toHexString(CiZgXyIx.digest());
		} catch (NoSuchAlgorithmException GtBKXCRM) {
			disconnect();
			throw new AuthenticationFailedException("Unable to create login key using MD5 Message Digest", GtBKXCRM);
		}
		LZ3vNBbD = new LoginAction(username, "MD5", uHIBVpV2, TCkYBVxz);
		try {
			felTBuWz = sendAction(LZ3vNBbD);
		} catch (Exception vmzdeyqz) {
			disconnect();
			throw new AuthenticationFailedException("Unable to send login action", vmzdeyqz);
		}
		if (felTBuWz instanceof ManagerError) {
			disconnect();
			throw new AuthenticationFailedException(felTBuWz.getMessage());
		}
		version = determineVersion();
		writer.setTargetVersion(version);
		ConnectEvent qNdb8ho5 = new ConnectEvent(this);
		qNdb8ho5.setProtocolIdentifier(getProtocolIdentifier());
		qNdb8ho5.setDateReceived(DateUtil.getDate());
		fireEvent(qNdb8ho5);
	}

}