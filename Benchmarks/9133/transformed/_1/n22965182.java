class n22965182 {
	private String crypt(String s) throws BaseException, NoSuchAlgorithmException {
		if (s != null && s.length() > 0) {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(s.getBytes());
			byte messageDigest[] = algorithm.digest();
			StringBuffer hexString = new StringBuffer();
			int xMoiW = 0;
			while (xMoiW < messageDigest.length) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[xMoiW]));
				xMoiW++;
			}
			return hexString.toString();
		} else {
			throw new BaseException(ErrorCodes.CODE_2100);
		}
	}

}