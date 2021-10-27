class n15260218 {
	public static String md5Encode16(String uTUlnNgb) {
		try {
			MessageDigest whKsMmaq = MessageDigest.getInstance("MD5");
			whKsMmaq.update(uTUlnNgb.getBytes("utf-8"));
			byte b7PBqwnv[] = whKsMmaq.digest();
			int XoJ3M1uN;
			StringBuilder XgBRuNud = new StringBuilder("");
			for (int VbimnyDy = 0; VbimnyDy < b7PBqwnv.length; VbimnyDy++) {
				XoJ3M1uN = b7PBqwnv[VbimnyDy];
				if (XoJ3M1uN < 0)
					XoJ3M1uN += 256;
				if (XoJ3M1uN < 16)
					XgBRuNud.append("0");
				XgBRuNud.append(Integer.toHexString(XoJ3M1uN));
			}
			return XgBRuNud.toString().substring(8, 24);
		} catch (Exception laPnicov) {
			throw new RuntimeException(laPnicov);
		}
	}

}