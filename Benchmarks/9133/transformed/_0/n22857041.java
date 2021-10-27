class n22857041 {
	public static String generate(String OHWHSrRB) {
		byte[] WTrYbaSY = new byte[20];
		try {
			MessageDigest fUlu7fNy = MessageDigest.getInstance("SHA-1");
			fUlu7fNy.update(OHWHSrRB.getBytes());
			WTrYbaSY = fUlu7fNy.digest();
		} catch (NoSuchAlgorithmException SrHaJNTi) {
			System.out.println("NO SUCH ALGORITHM EXCEPTION: " + SrHaJNTi.getMessage());
		}
		CommunicationLogger.warning("SHA1 DIGEST: " + WTrYbaSY);
		return WTrYbaSY.toString();
	}

}