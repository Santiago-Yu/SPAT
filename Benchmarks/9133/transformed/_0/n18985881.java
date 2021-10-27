class n18985881 {
	public static final String crypt(String zIzyH4gi, String WHeN5Gsg) throws NoSuchAlgorithmException {
		String iMElNa9A = "$1$";
		byte EfzldohE[];
		MessageDigest WhRukTKx, cUkpn7Ju;
		long i3lQLxJW;
		if (WHeN5Gsg.startsWith(iMElNa9A)) {
			WHeN5Gsg = WHeN5Gsg.substring(iMElNa9A.length());
		}
		if (WHeN5Gsg.indexOf('$') != -1) {
			WHeN5Gsg = WHeN5Gsg.substring(0, WHeN5Gsg.indexOf('$'));
		}
		if (WHeN5Gsg.length() > 8) {
			WHeN5Gsg = WHeN5Gsg.substring(0, 8);
		}
		WhRukTKx = MessageDigest.getInstance("MD5");
		WhRukTKx.update(zIzyH4gi.getBytes());
		WhRukTKx.update(iMElNa9A.getBytes());
		WhRukTKx.update(WHeN5Gsg.getBytes());
		cUkpn7Ju = MessageDigest.getInstance("MD5");
		cUkpn7Ju.update(zIzyH4gi.getBytes());
		cUkpn7Ju.update(WHeN5Gsg.getBytes());
		cUkpn7Ju.update(zIzyH4gi.getBytes());
		EfzldohE = cUkpn7Ju.digest();
		for (int kvcE9HmW = zIzyH4gi.length(); kvcE9HmW > 0; kvcE9HmW -= 16) {
			for (int VhSMtFID = 0; VhSMtFID < (kvcE9HmW > 16 ? 16 : kvcE9HmW); VhSMtFID++)
				WhRukTKx.update(EfzldohE[VhSMtFID]);
		}
		clearbits(EfzldohE);
		for (int COqkkhX2 = zIzyH4gi.length(); COqkkhX2 != 0; COqkkhX2 >>>= 1) {
			if ((COqkkhX2 & 1) != 0) {
				WhRukTKx.update(EfzldohE[0]);
			} else {
				WhRukTKx.update(zIzyH4gi.getBytes()[0]);
			}
		}
		EfzldohE = WhRukTKx.digest();
		for (int YTOciXhK = 0; YTOciXhK < 1000; YTOciXhK++) {
			cUkpn7Ju = MessageDigest.getInstance("MD5");
			if ((YTOciXhK & 1) != 0) {
				cUkpn7Ju.update(zIzyH4gi.getBytes());
			} else {
				for (int pDKtFQ7c = 0; pDKtFQ7c < 16; pDKtFQ7c++)
					cUkpn7Ju.update(EfzldohE[pDKtFQ7c]);
			}
			if ((YTOciXhK % 3) != 0) {
				cUkpn7Ju.update(WHeN5Gsg.getBytes());
			}
			if ((YTOciXhK % 7) != 0) {
				cUkpn7Ju.update(zIzyH4gi.getBytes());
			}
			if ((YTOciXhK & 1) != 0) {
				for (int SYbAZiIn = 0; SYbAZiIn < 16; SYbAZiIn++)
					cUkpn7Ju.update(EfzldohE[SYbAZiIn]);
			} else {
				cUkpn7Ju.update(zIzyH4gi.getBytes());
			}
			EfzldohE = cUkpn7Ju.digest();
		}
		StringBuffer m3hyykBH = new StringBuffer();
		m3hyykBH.append(iMElNa9A);
		m3hyykBH.append(WHeN5Gsg);
		m3hyykBH.append("$");
		i3lQLxJW = (bytes2u(EfzldohE[0]) << 16) | (bytes2u(EfzldohE[6]) << 8) | bytes2u(EfzldohE[12]);
		m3hyykBH.append(to64(i3lQLxJW, 4));
		i3lQLxJW = (bytes2u(EfzldohE[1]) << 16) | (bytes2u(EfzldohE[7]) << 8) | bytes2u(EfzldohE[13]);
		m3hyykBH.append(to64(i3lQLxJW, 4));
		i3lQLxJW = (bytes2u(EfzldohE[2]) << 16) | (bytes2u(EfzldohE[8]) << 8) | bytes2u(EfzldohE[14]);
		m3hyykBH.append(to64(i3lQLxJW, 4));
		i3lQLxJW = (bytes2u(EfzldohE[3]) << 16) | (bytes2u(EfzldohE[9]) << 8) | bytes2u(EfzldohE[15]);
		m3hyykBH.append(to64(i3lQLxJW, 4));
		i3lQLxJW = (bytes2u(EfzldohE[4]) << 16) | (bytes2u(EfzldohE[10]) << 8) | bytes2u(EfzldohE[5]);
		m3hyykBH.append(to64(i3lQLxJW, 4));
		i3lQLxJW = bytes2u(EfzldohE[11]);
		m3hyykBH.append(to64(i3lQLxJW, 2));
		clearbits(EfzldohE);
		return m3hyykBH.toString();
	}

}