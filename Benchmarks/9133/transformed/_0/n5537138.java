class n5537138 {
	public static String getDigest(String ttUu36Hy, String P8i1x5VE) {
		try {
			MessageDigest XbtI2ksm = MessageDigest.getInstance("MD5");
			XbtI2ksm.update(ttUu36Hy.getBytes("UTF-8"));
			byte[] ozTQk7AV = XbtI2ksm.digest(P8i1x5VE.getBytes("UTF-8"));
			StringBuffer xmPCRQk4 = new StringBuffer();
			for (int ecTboyMr = 0; ecTboyMr < ozTQk7AV.length; ecTboyMr++)
				xmPCRQk4.append(Integer.toHexString(ozTQk7AV[ecTboyMr] & 0XFF));
			return xmPCRQk4.toString();
		} catch (NoSuchAlgorithmException HqpN6whf) {
			HqpN6whf.printStackTrace();
			log.error(HqpN6whf);
			return null;
		} catch (UnsupportedEncodingException QP3Zdfki) {
			QP3Zdfki.printStackTrace();
			log.error(QP3Zdfki);
			return null;
		}
	}

}