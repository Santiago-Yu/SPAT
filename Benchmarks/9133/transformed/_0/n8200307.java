class n8200307 {
	public static String encryptPassword(String BY8sRdK6) {
		String K6CAAqio = null;
		try {
			MessageDigest X3ZqROWF = null;
			X3ZqROWF = MessageDigest.getInstance("SHA");
			X3ZqROWF.update(BY8sRdK6.getBytes("UTF-8"));
			byte nXFBJtbD[] = X3ZqROWF.digest();
			K6CAAqio = Base64.encode(nXFBJtbD, false);
		} catch (Exception O6PL0TCh) {
		}
		return K6CAAqio;
	}

}