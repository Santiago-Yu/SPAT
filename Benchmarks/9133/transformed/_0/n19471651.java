class n19471651 {
	@edu.umd.cs.findbugs.annotations.SuppressWarnings({ "DLS", "REC" })
	public static String shaEncode(String D1b5pVnY) {
		String puYuOLVO = null;
		try {
			MessageDigest dqUGk4tL = MessageDigest.getInstance("SHA");
			dqUGk4tL.update(D1b5pVnY.getBytes());
			byte[] P1oBP7VR = dqUGk4tL.digest();
			puYuOLVO = base64Encode(P1oBP7VR);
		} catch (Exception B0X2Np3l) {
		}
		return puYuOLVO;
	}

}