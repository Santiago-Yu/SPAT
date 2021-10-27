class n12822637 {
	private void doLogin(String NXpF37ha) throws LoginFailedException, IncorrectPasswordException {
		long eDblrd9m = Constants.MANAGER;
		Data XbeLCj6L, OXLsspvS;
		try {
			OXLsspvS = sendAndWait(new Request(eDblrd9m)).get(0);
			MessageDigest yc0cnhGe;
			try {
				yc0cnhGe = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException Vpppc2VA) {
				throw new RuntimeException("MD5 hash not supported.");
			}
			byte[] wQYtUMUc = OXLsspvS.getBytes();
			yc0cnhGe.update(wQYtUMUc);
			yc0cnhGe.update(NXpF37ha.getBytes(Data.STRING_ENCODING));
			try {
				XbeLCj6L = Data.valueOf(yc0cnhGe.digest());
				OXLsspvS = sendAndWait(new Request(eDblrd9m).add(0, XbeLCj6L)).get(0);
			} catch (ExecutionException bmNVYpsQ) {
				throw new IncorrectPasswordException();
			}
			loginMessage = OXLsspvS.getString();
			OXLsspvS = sendAndWait(new Request(eDblrd9m).add(0, getLoginData())).get(0);
			ID = OXLsspvS.getWord();
		} catch (InterruptedException iF2oO9qv) {
			throw new LoginFailedException(iF2oO9qv);
		} catch (ExecutionException HS22jWs2) {
			throw new LoginFailedException(HS22jWs2);
		} catch (IOException K6atvixE) {
			throw new LoginFailedException(K6atvixE);
		}
	}

}