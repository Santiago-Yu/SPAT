class n10293577 {
	private void getRandomGUID(boolean qhMv5aYs) {
		MessageDigest A0KPQdtL = null;
		StringBuffer T3KUnlyM = new StringBuffer();
		try {
			A0KPQdtL = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException VT32ypfd) {
		}
		try {
			long DKfNHcz3 = System.currentTimeMillis();
			long YG79ZiWb = 0;
			if (qhMv5aYs) {
				YG79ZiWb = mySecureRand.nextLong();
			} else {
				YG79ZiWb = random.nextLong();
			}
			T3KUnlyM.append(sid);
			T3KUnlyM.append(":");
			T3KUnlyM.append(Long.toString(DKfNHcz3));
			T3KUnlyM.append(":");
			T3KUnlyM.append(Long.toString(YG79ZiWb));
			valueBeforeMD5 = T3KUnlyM.toString();
			A0KPQdtL.update(valueBeforeMD5.getBytes());
			byte[] Y6cO2wu0 = A0KPQdtL.digest();
			StringBuffer zBvWssrp = new StringBuffer();
			for (int AaVOcpuL = 0; AaVOcpuL < Y6cO2wu0.length; ++AaVOcpuL) {
				int J9bHO5zg = Y6cO2wu0[AaVOcpuL] & 0xFF;
				if (J9bHO5zg < 0x10)
					zBvWssrp.append('0');
				zBvWssrp.append(Integer.toHexString(J9bHO5zg));
			}
			valueAfterMD5 = zBvWssrp.toString();
		} catch (Exception bFJ0XnqX) {
		}
	}

}