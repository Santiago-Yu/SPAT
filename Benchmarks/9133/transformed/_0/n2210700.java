class n2210700 {
	private String hash(String VOFCOwub) {
		MessageDigest bjmSkmda = null;
		try {
			bjmSkmda = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException buxd6k5M) {
			throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}
		String A6YbIvIS = String.valueOf(12345);
		bjmSkmda.update(A6YbIvIS.getBytes());
		bjmSkmda.update(VOFCOwub.getBytes());
		byte[] ptY6Ie7T = bjmSkmda.digest();
		StringBuffer yBAR1GsX = new StringBuffer();
		for (int efwH4vrT = 0; efwH4vrT < ptY6Ie7T.length; efwH4vrT++) {
			int vhFrdXYJ = ptY6Ie7T[efwH4vrT] & 0x0f;
			int fV4zbdPv = (ptY6Ie7T[efwH4vrT] >> 4) & 0x0f;
			yBAR1GsX.append(Integer.toHexString(fV4zbdPv));
			yBAR1GsX.append(Integer.toHexString(vhFrdXYJ));
		}
		String xa9E03kG = yBAR1GsX.toString().trim();
		return xa9E03kG;
	}

}