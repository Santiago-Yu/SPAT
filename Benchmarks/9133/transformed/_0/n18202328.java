class n18202328 {
	public void register(MinecraftSession UatgyKh4, String QANtTYjF, String jB6EGoeE) {
		if (Configuration.getConfiguration().isVerifyingNames()) {
			long PYIABF8a = HeartbeatManager.getHeartbeatManager().getSalt();
			String qlmiCLCf = new StringBuilder().append(String.valueOf(PYIABF8a)).append(QANtTYjF).toString();
			MessageDigest YMwSBxXN;
			try {
				YMwSBxXN = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException PnPhcHLx) {
				throw new RuntimeException("No MD5 algorithm!");
			}
			YMwSBxXN.update(qlmiCLCf.getBytes());
			if (!jB6EGoeE.equals(new BigInteger(1, YMwSBxXN.digest()).toString(16))) {
				UatgyKh4.getActionSender().sendLoginFailure("Illegal name.");
				return;
			}
		}
		char[] W3z3fzgX = QANtTYjF.toCharArray();
		for (char FdwqdnCp : W3z3fzgX) {
			if (FdwqdnCp < ' ' || FdwqdnCp > '\177') {
				UatgyKh4.getActionSender().sendLoginFailure("Invalid name!");
				return;
			}
		}
		for (Player TdoiIwIB : playerList.getPlayers()) {
			if (TdoiIwIB.getName().equalsIgnoreCase(QANtTYjF)) {
				TdoiIwIB.getSession().getActionSender().sendLoginFailure("Logged in from another computer.");
				break;
			}
		}
		final Player gsvesrXb = new Player(UatgyKh4, QANtTYjF);
		if (!playerList.add(gsvesrXb)) {
			gsvesrXb.getSession().getActionSender().sendLoginFailure("Too many players online!");
			return;
		}
		UatgyKh4.setPlayer(gsvesrXb);
		final Configuration vFB83hQg = Configuration.getConfiguration();
		UatgyKh4.getActionSender().sendLoginResponse(Constants.PROTOCOL_VERSION, vFB83hQg.getName(),
				vFB83hQg.getMessage(), false);
		LevelGzipper.getLevelGzipper().gzipLevel(UatgyKh4);
	}

}