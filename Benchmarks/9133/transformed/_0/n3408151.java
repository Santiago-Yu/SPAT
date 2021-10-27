class n3408151 {
	public static String crypt(String VJ89XLhs, String dwTTyx9Y) {
		if (dwTTyx9Y.startsWith(magic)) {
			dwTTyx9Y = dwTTyx9Y.substring(magic.length());
		}
		int lrkq5uJI = dwTTyx9Y.indexOf('$');
		if (lrkq5uJI != -1) {
			dwTTyx9Y = dwTTyx9Y.substring(0, lrkq5uJI);
		}
		if (dwTTyx9Y.length() > 8) {
			dwTTyx9Y = dwTTyx9Y.substring(0, 8);
		}
		MessageDigest ELy7hbga, A20tFIPZ;
		try {
			ELy7hbga = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException yFZbPcrO) {
			yFZbPcrO.printStackTrace();
			return null;
		}
		ELy7hbga.update(VJ89XLhs.getBytes());
		ELy7hbga.update(magic.getBytes());
		ELy7hbga.update(dwTTyx9Y.getBytes());
		try {
			A20tFIPZ = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException gGIDLFXy) {
			gGIDLFXy.printStackTrace();
			return null;
		}
		A20tFIPZ.update(VJ89XLhs.getBytes());
		A20tFIPZ.update(dwTTyx9Y.getBytes());
		A20tFIPZ.update(VJ89XLhs.getBytes());
		byte[] EelFJAi5 = A20tFIPZ.digest();
		int rzfDkG6o = EelFJAi5.length;
		int PrIslzOv = VJ89XLhs.length();
		for (int yKh1p7yX = PrIslzOv; yKh1p7yX > 0; yKh1p7yX -= rzfDkG6o) {
			ELy7hbga.update(EelFJAi5, 0, yKh1p7yX > rzfDkG6o ? rzfDkG6o : yKh1p7yX);
		}
		A20tFIPZ.reset();
		byte[] GLTM9VH6 = VJ89XLhs.getBytes();
		for (int LGlSxj1l = PrIslzOv; LGlSxj1l > 0; LGlSxj1l >>= 1) {
			if ((LGlSxj1l & 1) == 1) {
				ELy7hbga.update((byte) 0);
			} else {
				ELy7hbga.update(GLTM9VH6[0]);
			}
		}
		StringBuffer FoyHsFzL = new StringBuffer(magic);
		FoyHsFzL.append(dwTTyx9Y);
		FoyHsFzL.append("$");
		byte[] Y8NDZ7pF = ELy7hbga.digest();
		byte[] iooLyv5M = dwTTyx9Y.getBytes();
		for (int gE89ZXYs = 0; gE89ZXYs < 1000; gE89ZXYs++) {
			A20tFIPZ.reset();
			if ((gE89ZXYs & 1) == 1) {
				A20tFIPZ.update(GLTM9VH6);
			} else {
				A20tFIPZ.update(Y8NDZ7pF);
			}
			if (gE89ZXYs % 3 != 0) {
				A20tFIPZ.update(iooLyv5M);
			}
			if (gE89ZXYs % 7 != 0) {
				A20tFIPZ.update(GLTM9VH6);
			}
			if ((gE89ZXYs & 1) != 0) {
				A20tFIPZ.update(Y8NDZ7pF);
			} else {
				A20tFIPZ.update(GLTM9VH6);
			}
			Y8NDZ7pF = A20tFIPZ.digest();
		}
		int DrqJsYOY;
		DrqJsYOY = ((Y8NDZ7pF[0] & 0xff) << 16) | ((Y8NDZ7pF[6] & 0xff) << 8) | (Y8NDZ7pF[12] & 0xff);
		FoyHsFzL.append(cryptTo64(DrqJsYOY, 4));
		DrqJsYOY = ((Y8NDZ7pF[1] & 0xff) << 16) | ((Y8NDZ7pF[7] & 0xff) << 8) | (Y8NDZ7pF[13] & 0xff);
		FoyHsFzL.append(cryptTo64(DrqJsYOY, 4));
		DrqJsYOY = ((Y8NDZ7pF[2] & 0xff) << 16) | ((Y8NDZ7pF[8] & 0xff) << 8) | (Y8NDZ7pF[14] & 0xff);
		FoyHsFzL.append(cryptTo64(DrqJsYOY, 4));
		DrqJsYOY = ((Y8NDZ7pF[3] & 0xff) << 16) | ((Y8NDZ7pF[9] & 0xff) << 8) | (Y8NDZ7pF[15] & 0xff);
		FoyHsFzL.append(cryptTo64(DrqJsYOY, 4));
		DrqJsYOY = ((Y8NDZ7pF[4] & 0xff) << 16) | ((Y8NDZ7pF[10] & 0xff) << 8) | (Y8NDZ7pF[5] & 0xff);
		FoyHsFzL.append(cryptTo64(DrqJsYOY, 4));
		DrqJsYOY = Y8NDZ7pF[11] & 0xff;
		FoyHsFzL.append(cryptTo64(DrqJsYOY, 2));
		ELy7hbga = null;
		A20tFIPZ = null;
		Y8NDZ7pF = null;
		EelFJAi5 = null;
		GLTM9VH6 = null;
		iooLyv5M = null;
		VJ89XLhs = dwTTyx9Y = null;
		return FoyHsFzL.toString();
	}

}