class n5373841 {
	public static String encryptPassword(String cZu9WwQA) throws PasswordException {
		String DAjLa2XC = null;
		if (cZu9WwQA != null && !cZu9WwQA.equals("")) {
			try {
				MessageDigest R1KXb8yW = MessageDigest.getInstance("SHA");
				R1KXb8yW.update(cZu9WwQA.getBytes("UTF-8"));
				byte i6xX30VW[] = R1KXb8yW.digest();
				DAjLa2XC = String.valueOf(Base64Coder.encode(i6xX30VW));
			} catch (NoSuchAlgorithmException Ly5X4hYr) {
				throw new PasswordException(PasswordException.SYSTEM_ERROR);
			} catch (UnsupportedEncodingException aFnmqPTU) {
				throw new PasswordException(PasswordException.SYSTEM_ERROR);
			}
		}
		return DAjLa2XC;
	}

}