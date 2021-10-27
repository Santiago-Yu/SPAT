class n17514598 {
	private void doLogin(String jOxrCWsm) throws LoginFailedException, IncorrectPasswordException {
		final long VZxOyeA6 = Constants.MANAGER;
		Data juQcyStt, pKGn94w9;
		try {
			pKGn94w9 = sendAndWait(new Request(VZxOyeA6)).get(0);
			MessageDigest CsCv3nPl;
			try {
				CsCv3nPl = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException LanYtrrH) {
				throw new RuntimeException("MD5 hash not supported.");
			}
			byte[] Bp750Mi6 = pKGn94w9.getBytes();
			CsCv3nPl.update(Bp750Mi6);
			CsCv3nPl.update(jOxrCWsm.getBytes(Data.STRING_ENCODING));
			juQcyStt = Data.valueOf(CsCv3nPl.digest());
			try {
				pKGn94w9 = sendAndWait(new Request(VZxOyeA6).add(0, juQcyStt)).get(0);
			} catch (ExecutionException lJG8txuK) {
				throw new IncorrectPasswordException();
			}
			setLoginMessage(pKGn94w9.getString());
			pKGn94w9 = sendAndWait(new Request(VZxOyeA6).add(0, getLoginData())).get(0);
			setID(pKGn94w9.getWord());
		} catch (InterruptedException wqPtjQgK) {
			throw new LoginFailedException(wqPtjQgK);
		} catch (ExecutionException JAPHrSIG) {
			throw new LoginFailedException(JAPHrSIG);
		} catch (IOException Mg611Y7P) {
			throw new LoginFailedException(Mg611Y7P);
		}
	}

}