class n17954700 {
	public static String getPasswordHash(String sgJPrSxq) {
		try {
			MessageDigest qjItwUmY = MessageDigest.getInstance("SHA-256");
			qjItwUmY.update(sgJPrSxq.getBytes());
			byte[] RNDEpGLU = qjItwUmY.digest();
			StringBuilder xMWdcsAo = new StringBuilder();
			for (int x6cznLYY = 0; x6cznLYY < RNDEpGLU.length; x6cznLYY++) {
				xMWdcsAo.append(Integer.toString((RNDEpGLU[x6cznLYY] & 0xff) + 0x100, 16).substring(1));
			}
			return xMWdcsAo.toString();
		} catch (NoSuchAlgorithmException sp0gxPku) {
			logger.log(Level.SEVERE, "Unknow error in hashing password", sp0gxPku);
			return "Unknow error, check system log";
		}
	}

}