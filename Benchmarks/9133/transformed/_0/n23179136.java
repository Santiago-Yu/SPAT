class n23179136 {
	private void doLogin(String G8pkXgzl) throws LoginFailedException, IncorrectPasswordException {
		final long Vz3ahzsN = Constants.MANAGER;
		Data o1ZBfejn, EE20odTW;
		try {
			EE20odTW = sendAndWait(new Request(Vz3ahzsN)).get(0);
			MessageDigest YgOkbap3;
			try {
				YgOkbap3 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException m05UKDmh) {
				throw new RuntimeException("MD5 hash not supported.");
			}
			byte[] Lgmk6UvR = EE20odTW.getBytes();
			YgOkbap3.update(Lgmk6UvR);
			YgOkbap3.update(G8pkXgzl.getBytes(Data.STRING_ENCODING));
			try {
				o1ZBfejn = Data.valueOf(YgOkbap3.digest());
				EE20odTW = sendAndWait(new Request(Vz3ahzsN).add(0, o1ZBfejn)).get(0);
			} catch (ExecutionException QwonxRio) {
				throw new IncorrectPasswordException();
			}
			setLoginMessage(EE20odTW.getString());
			EE20odTW = sendAndWait(new Request(Vz3ahzsN).add(0, getLoginData())).get(0);
			ID = EE20odTW.getWord();
			registerSettings();
		} catch (InterruptedException WmssLxdX) {
			throw new LoginFailedException(WmssLxdX);
		} catch (ExecutionException udUK4V0C) {
			throw new LoginFailedException(udUK4V0C);
		} catch (IOException IyNlYHgy) {
			throw new LoginFailedException(IyNlYHgy);
		}
	}

}