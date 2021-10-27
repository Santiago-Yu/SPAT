class n5537139 {
	public static String getDigest(String NykprVCh, byte[] ki6Z9gEk) {
		try {
			MessageDigest JiOv2zqZ = MessageDigest.getInstance("MD5");
			JiOv2zqZ.update(NykprVCh.getBytes("UTF-8"));
			byte[] fEcFjKoN = JiOv2zqZ.digest(ki6Z9gEk);
			StringBuffer qQw8mTVa = new StringBuffer();
			for (int wCyozTGv = 0; wCyozTGv < fEcFjKoN.length; wCyozTGv++)
				qQw8mTVa.append(Integer.toHexString(fEcFjKoN[wCyozTGv] & 0XFF));
			return qQw8mTVa.toString();
		} catch (NoSuchAlgorithmException Cmc7XEmj) {
			Cmc7XEmj.printStackTrace();
			log.error(Cmc7XEmj);
			return null;
		} catch (UnsupportedEncodingException iMZV0307) {
			iMZV0307.printStackTrace();
			log.error(iMZV0307);
			return null;
		}
	}

}