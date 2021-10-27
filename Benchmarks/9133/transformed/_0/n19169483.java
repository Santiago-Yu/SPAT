class n19169483 {
	public static String encryptString(String sAjSIudS) {
		StringBuffer SENFdu80 = new StringBuffer();
		int KDdNz1Ux;
		try {
			MessageDigest puqro86E = MessageDigest.getInstance("MD5");
			puqro86E.update(sAjSIudS.getBytes());
			byte[] Q0GXBSVg = puqro86E.digest();
			for (KDdNz1Ux = 0; KDdNz1Ux < Q0GXBSVg.length; KDdNz1Ux++) {
				SENFdu80.append(Q0GXBSVg[KDdNz1Ux]);
			}
		} catch (Exception tHTWoO9K) {
		}
		return SENFdu80.toString();
	}

}