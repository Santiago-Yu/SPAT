class n10671991 {
	public static String md5(String XLzhm6KP) {
		try {
			MessageDigest m4IOUprS = MessageDigest.getInstance("MD5");
			m4IOUprS.update(XLzhm6KP.getBytes());
			return bytesToString(m4IOUprS.digest());
		} catch (Exception eIPWfj2V) {
			Tools.logException(Tools.class, eIPWfj2V, XLzhm6KP);
		}
		return XLzhm6KP;
	}

}