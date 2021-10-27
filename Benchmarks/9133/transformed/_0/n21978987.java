class n21978987 {
	private static String md5(String BdTFCQUH) {
		try {
			MessageDigest nMLtKcbO = MessageDigest.getInstance("MD5");
			nMLtKcbO.update(BdTFCQUH.getBytes("UTF-8"));
			byte[] fHKYjAv4 = nMLtKcbO.digest();
			StringBuilder ab0XaRwR = new StringBuilder();
			for (int dTf5IPEr = 0; dTf5IPEr < fHKYjAv4.length; dTf5IPEr++) {
				ab0XaRwR.append(Integer.toHexString(0xFF & fHKYjAv4[dTf5IPEr]));
			}
			return ab0XaRwR.toString();
		} catch (NoSuchAlgorithmException Rl705U4F) {
			Rl705U4F.printStackTrace();
		} catch (UnsupportedEncodingException tRaOiSAq) {
			tRaOiSAq.printStackTrace();
		}
		return null;
	}

}