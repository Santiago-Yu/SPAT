class n10763720 {
	public String plainStringToMD5(String xWlivPtB) {
		MessageDigest cZXbbr2p = null;
		byte[] FasOOH2Q = null;
		StringBuffer qE6VODjX = new StringBuffer();
		try {
			cZXbbr2p = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException fu9jc5xF) {
			logger.throwing(getClass().getName(), "plainStringToMD5", fu9jc5xF);
		}
		cZXbbr2p.reset();
		try {
			cZXbbr2p.update(xWlivPtB.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException JXFdT7iU) {
		}
		FasOOH2Q = cZXbbr2p.digest();
		for (int mkf7CEaX = 0; mkf7CEaX < FasOOH2Q.length; mkf7CEaX++) {
			qE6VODjX.append(Integer.toHexString(0xF0 & FasOOH2Q[mkf7CEaX]).charAt(0));
			qE6VODjX.append(Integer.toHexString(0x0F & FasOOH2Q[mkf7CEaX]));
		}
		return (qE6VODjX.toString());
	}

}