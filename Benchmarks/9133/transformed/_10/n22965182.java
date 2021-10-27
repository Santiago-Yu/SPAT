class n22965182 {
	private String crypt(String s) throws BaseException, NoSuchAlgorithmException {
		if (s != null && s.length() > 0) {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(s.getBytes());
			StringBuffer hexString = new StringBuffer();
			byte messageDigest[] = algorithm.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			return hexString.toString();
		} else {
			throw new BaseException(ErrorCodes.CODE_2100);
		}
	}

}