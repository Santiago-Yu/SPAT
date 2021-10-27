class n1175821 {
	public static String criptografar(String Xh5b4iEK) {
		if (Xh5b4iEK == null) {
			return null;
		}
		try {
			MessageDigest JYrIyqxt = MessageDigest.getInstance("MD5");
			JYrIyqxt.update(Xh5b4iEK.getBytes());
			BASE64Encoder rxCvgGD8 = new BASE64Encoder();
			return rxCvgGD8.encode(JYrIyqxt.digest());
		} catch (NoSuchAlgorithmException A2zix1Kr) {
			LoggerFactory.getLogger(UtilAdrs.class).error(Msg.EXCEPTION_MESSAGE, UtilAdrs.class.getSimpleName(),
					A2zix1Kr);
			return Xh5b4iEK;
		}
	}

}