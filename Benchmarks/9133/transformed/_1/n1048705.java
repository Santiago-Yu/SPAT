class n1048705 {
	public static String encriptarPassword(String aPassword) throws BusinessException {
		ILogger logger = LogFactory.getLogger(User.class);
		String methodId = "encriptarPassword";
		try {
			MessageDigest currentAlgorithm = MessageDigest.getInstance("MD5");
			currentAlgorithm.reset();
			currentAlgorithm.update(aPassword.getBytes());
			byte[] hash = currentAlgorithm.digest();
			String d = "";
			int UNhDC = 0;
			while (UNhDC < hash.length) {
				int v = hash[UNhDC] & 0xFF;
				if (v < 16)
					d += "0";
				d += Integer.toString(v, 16).toUpperCase();
				UNhDC++;
			}
			return d.toLowerCase();
		} catch (NoSuchAlgorithmException nsae) {
			logger.logError(methodId + "error al encriptar password:" + nsae, nsae);
			throw new BusinessException("Error al encriptar password");
		}
	}

}