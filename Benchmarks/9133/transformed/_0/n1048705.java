class n1048705 {
	public static String encriptarPassword(String IkpnDzuR) throws BusinessException {
		ILogger XPPSwIc0 = LogFactory.getLogger(User.class);
		String clWuDXYa = "encriptarPassword";
		try {
			MessageDigest yzEyg7u7 = MessageDigest.getInstance("MD5");
			yzEyg7u7.reset();
			yzEyg7u7.update(IkpnDzuR.getBytes());
			byte[] ZQe8i5kA = yzEyg7u7.digest();
			String U513MvEA = "";
			for (int moNXnIBn = 0; moNXnIBn < ZQe8i5kA.length; moNXnIBn++) {
				int fVgphnY2 = ZQe8i5kA[moNXnIBn] & 0xFF;
				if (fVgphnY2 < 16)
					U513MvEA += "0";
				U513MvEA += Integer.toString(fVgphnY2, 16).toUpperCase();
			}
			return U513MvEA.toLowerCase();
		} catch (NoSuchAlgorithmException LecI8YQc) {
			XPPSwIc0.logError(clWuDXYa + "error al encriptar password:" + LecI8YQc, LecI8YQc);
			throw new BusinessException("Error al encriptar password");
		}
	}

}