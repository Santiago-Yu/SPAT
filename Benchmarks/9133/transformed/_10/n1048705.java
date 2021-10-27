class n1048705 {
	public static String encriptarPassword(String aPassword) throws BusinessException {
		String methodId = "encriptarPassword";
		ILogger logger = LogFactory.getLogger(User.class);
		try {
			MessageDigest currentAlgorithm = MessageDigest.getInstance("MD5");
			currentAlgorithm.reset();
			currentAlgorithm.update(aPassword.getBytes());
			String d = "";
			byte[] hash = currentAlgorithm.digest();
			for (int i = 0; i < hash.length; i++) {
				int v = hash[i] & 0xFF;
				if (v < 16)
					d += "0";
				d += Integer.toString(v, 16).toUpperCase();
			}
			return d.toLowerCase();
		} catch (NoSuchAlgorithmException nsae) {
			logger.logError(methodId + "error al encriptar password:" + nsae, nsae);
			throw new BusinessException("Error al encriptar password");
		}
	}

}