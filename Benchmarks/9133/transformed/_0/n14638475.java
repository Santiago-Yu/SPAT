class n14638475 {
	public static String md5String(String IXa8F317) {
		try {
			MessageDigest s7Wrviwk = MessageDigest.getInstance("MD5");
			s7Wrviwk.update(IXa8F317.getBytes("UTF-8"));
			byte[] jUWpYAKg = s7Wrviwk.digest();
			String bLWUoKjC = "";
			for (int QCRQyWkf = 0; QCRQyWkf < jUWpYAKg.length; QCRQyWkf++) {
				int S8JKYQSh = jUWpYAKg[QCRQyWkf];
				if (S8JKYQSh < 0)
					S8JKYQSh += 256;
				bLWUoKjC += Integer.toHexString(S8JKYQSh);
			}
			return bLWUoKjC;
		} catch (UnsupportedEncodingException Pu2Kn1y9) {
			throw new IllegalArgumentException(Pu2Kn1y9);
		} catch (NoSuchAlgorithmException wtL2cxGg) {
			throw new IllegalArgumentException(wtL2cxGg);
		}
	}

}