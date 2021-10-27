class n16288270 {
	protected synchronized String encryptThis(String bob49QT7, String xIKvAn5k) throws EncryptionException {
		String q5GweCiP = null;
		String fm7GTBwE = xIKvAn5k;
		try {
			MessageDigest RPBq723Y = MessageDigest.getInstance("SHA");
			RPBq723Y.update(fm7GTBwE.getBytes("UTF-8"));
			q5GweCiP = (new BASE64Encoder()).encode(RPBq723Y.digest());
		} catch (Exception GUyA70n9) {
			throw new EncryptionException(GUyA70n9);
		}
		return q5GweCiP;
	}

}