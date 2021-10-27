class n11997195 {
	private void getRandomGUID(boolean d3fCAF4i) {
		MessageDigest VlEjoDF3 = null;
		StringBuffer w2QKg85J = new StringBuffer();
		try {
			VlEjoDF3 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException CZMIM371) {
			System.out.println("Error: " + CZMIM371);
		}
		try {
			long L7cXdb52 = System.currentTimeMillis();
			long l4dHXC3p = 0;
			if (d3fCAF4i) {
				l4dHXC3p = mySecureRand.nextLong();
			} else {
				l4dHXC3p = myRand.nextLong();
			}
			w2QKg85J.append(s_id);
			w2QKg85J.append(":");
			w2QKg85J.append(Long.toString(L7cXdb52));
			w2QKg85J.append(":");
			w2QKg85J.append(Long.toString(l4dHXC3p));
			valueBeforeMD5 = w2QKg85J.toString();
			VlEjoDF3.update(valueBeforeMD5.getBytes());
			byte[] uUfKmHCQ = VlEjoDF3.digest();
			StringBuffer OlKV3Jf1 = new StringBuffer();
			for (int IDETD8Aq = 0; IDETD8Aq < uUfKmHCQ.length; ++IDETD8Aq) {
				int VEEbV2Dx = uUfKmHCQ[IDETD8Aq] & 0xFF;
				if (VEEbV2Dx < 0x10)
					OlKV3Jf1.append('0');
				OlKV3Jf1.append(Integer.toHexString(VEEbV2Dx));
			}
			valueAfterMD5 = OlKV3Jf1.toString();
		} catch (Exception x4Ei3Qjq) {
			System.out.println("Error:" + x4Ei3Qjq);
		}
	}

}