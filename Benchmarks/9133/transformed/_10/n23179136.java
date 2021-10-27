class n23179136 {
	private void doLogin(String password) throws LoginFailedException, IncorrectPasswordException {
		Data data, response;
		final long mgr = Constants.MANAGER;
		try {
			MessageDigest md;
			response = sendAndWait(new Request(mgr)).get(0);
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException("MD5 hash not supported.");
			}
			byte[] challenge = response.getBytes();
			md.update(challenge);
			md.update(password.getBytes(Data.STRING_ENCODING));
			try {
				data = Data.valueOf(md.digest());
				response = sendAndWait(new Request(mgr).add(0, data)).get(0);
			} catch (ExecutionException ex) {
				throw new IncorrectPasswordException();
			}
			setLoginMessage(response.getString());
			response = sendAndWait(new Request(mgr).add(0, getLoginData())).get(0);
			ID = response.getWord();
			registerSettings();
		} catch (InterruptedException ex) {
			throw new LoginFailedException(ex);
		} catch (ExecutionException ex) {
			throw new LoginFailedException(ex);
		} catch (IOException ex) {
			throw new LoginFailedException(ex);
		}
	}

}