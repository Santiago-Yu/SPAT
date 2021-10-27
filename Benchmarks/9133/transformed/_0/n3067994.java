class n3067994 {
	private String hashMD5(String jrMHm5CU) throws Exception {
		try {
			byte[] Iav59TFW = new byte[jrMHm5CU.length() * 2];
			MessageDigest XwsyXrh9 = MessageDigest.getInstance("MD5");
			XwsyXrh9.update(jrMHm5CU.getBytes("UTF-16LE"));
			Iav59TFW = XwsyXrh9.digest();
			StringBuffer ib5WBhoM = new StringBuffer();
			for (byte KwJfxQnC : Iav59TFW) {
				String YsMyVqoD = Integer.toHexString(KwJfxQnC);
				ib5WBhoM.append(YsMyVqoD.replaceAll("f", ""));
			}
			return ib5WBhoM.toString();
		} catch (NoSuchAlgorithmException TcTneQMN) {
			throw new Exception("NoSuchAlgorithmException: " + TcTneQMN.getMessage());
		}
	}

}