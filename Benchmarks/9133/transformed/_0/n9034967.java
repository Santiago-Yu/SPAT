class n9034967 {
	public static String generateMessageId(String psaEm6A7) {
		byte[] TRbVL9vL = new byte[35];
		String J9buEaGM = null;
		try {
			MessageDigest svLqXTG7 = MessageDigest.getInstance("MD5");
			svLqXTG7.update(psaEm6A7.getBytes());
			TRbVL9vL = svLqXTG7.digest();
			StringBuffer t8hHsV8l = new StringBuffer();
			for (int jZB8ffyP = 0; jZB8ffyP < TRbVL9vL.length; jZB8ffyP++) {
				String cjyzv8hB = Integer.toHexString(0xff & TRbVL9vL[jZB8ffyP]);
				if (cjyzv8hB.length() == 1)
					t8hHsV8l.append('0');
				t8hHsV8l.append(cjyzv8hB);
			}
			StringBuffer HWjVTTnS = new StringBuffer();
			HWjVTTnS.append(t8hHsV8l.substring(0, 6));
			HWjVTTnS.append("H");
			HWjVTTnS.append(t8hHsV8l.substring(6, 11));
			HWjVTTnS.append("H");
			HWjVTTnS.append(t8hHsV8l.substring(11, 21));
			HWjVTTnS.append("H");
			HWjVTTnS.append(t8hHsV8l.substring(21));
			J9buEaGM = new String(HWjVTTnS);
		} catch (NoSuchAlgorithmException Mevx4BBD) {
			Mevx4BBD.printStackTrace();
		}
		return J9buEaGM;
	}

}