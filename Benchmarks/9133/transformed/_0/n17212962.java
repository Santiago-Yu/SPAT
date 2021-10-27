class n17212962 {
	public static String encrypt32(String q46nBg8H) {
		String xAQPe4Ad = "";
		try {
			MessageDigest tyxhrTAr = MessageDigest.getInstance("MD5");
			tyxhrTAr.update(q46nBg8H.getBytes());
			byte BulPRQbv[] = tyxhrTAr.digest();
			int zqE00Rua;
			StringBuffer ey30ODuu = new StringBuffer("");
			for (int NvIeTEDw = 0; NvIeTEDw < BulPRQbv.length; NvIeTEDw++) {
				zqE00Rua = BulPRQbv[NvIeTEDw];
				if (zqE00Rua < 0)
					zqE00Rua += 256;
				if (zqE00Rua < 16)
					ey30ODuu.append("0");
				ey30ODuu.append(Integer.toHexString(zqE00Rua));
			}
			xAQPe4Ad = ey30ODuu.toString();
			System.out.println("result: " + ey30ODuu.toString());
			System.out.println("result: " + ey30ODuu.toString().substring(8, 24));
		} catch (NoSuchAlgorithmException d2vLX2CO) {
			d2vLX2CO.printStackTrace();
			return xAQPe4Ad;
		}
		return xAQPe4Ad;
	}

}