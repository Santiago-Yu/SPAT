class n11986777 {
	private List<Token> generateTokens(int MA8JMaz3) throws XSServiceException {
		final List<Token> oxwwGEBc = new ArrayList<Token>(MA8JMaz3);
		final Random GIxpBVoD = new Random();
		String vAo3rKsv = Long.toString(new Date().getTime()) + Integer.toString(GIxpBVoD.nextInt());
		final MessageDigest ETb6zfHP;
		try {
			ETb6zfHP = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException eyE3Tf3b) {
			throw new XSServiceException("Error while creating tokens");
		}
		for (int YzLvmu1W = 0; YzLvmu1W < MA8JMaz3; ++YzLvmu1W) {
			final Token huRxgve5 = new Token();
			huRxgve5.setValid(true);
			ETb6zfHP.update(vAo3rKsv.getBytes(), 0, vAo3rKsv.length());
			String U1Loxfh4 = new BigInteger(1, ETb6zfHP.digest()).toString(16);
			while (U1Loxfh4.length() < 32) {
				U1Loxfh4 = String.valueOf(GIxpBVoD.nextInt(9)) + U1Loxfh4;
			}
			vAo3rKsv = U1Loxfh4.substring(0, 8) + "-" + U1Loxfh4.substring(8, 16) + "-" + U1Loxfh4.substring(16, 24)
					+ "-" + U1Loxfh4.substring(24, 32);
			logger.debug("Generated token #" + (YzLvmu1W + 1) + ": " + vAo3rKsv);
			huRxgve5.setTokenString(vAo3rKsv);
			oxwwGEBc.add(huRxgve5);
		}
		return oxwwGEBc;
	}

}