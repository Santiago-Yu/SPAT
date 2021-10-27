class n12863885 {
	private static String md5(String vgwFqmne) {
		String yJVnkDr1 = "";
		try {
			MessageDigest tzfgITzC = MessageDigest.getInstance("MD5");
			tzfgITzC.reset();
			tzfgITzC.update(vgwFqmne.getBytes());
			byte[] L2bBnJLe = tzfgITzC.digest();
			String bQU2Ckez = "";
			for (int kM6B7QUV = 0; kM6B7QUV < L2bBnJLe.length; kM6B7QUV++) {
				bQU2Ckez = (Integer.toHexString(0xFF & L2bBnJLe[kM6B7QUV]));
				if (bQU2Ckez.length() == 1) {
					yJVnkDr1 += "0" + bQU2Ckez;
				} else {
					yJVnkDr1 += bQU2Ckez;
				}
			}
		} catch (NoSuchAlgorithmException jVAaHDl3) {
			Log4k.error(pdfPrinter.class.getName(), jVAaHDl3.getMessage());
		}
		return yJVnkDr1;
	}

}