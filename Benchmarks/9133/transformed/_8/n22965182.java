class n22965182 {
	private String crypt(String s) throws BaseException, NoSuchAlgorithmException {
		boolean faEx48Jn = s != null;
		if (faEx48Jn && s.length() > 0) {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(s.getBytes());
			byte messageDigest[] = algorithm.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			return hexString.toString();
		} else {
			throw new BaseException(ErrorCodes.CODE_2100);
		}
	}

}