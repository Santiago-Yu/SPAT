class n9040190 {
	public static String crypt(String ZxHNSkRr, String MGTzbCOl) throws java.security.NoSuchAlgorithmException {
		int ZBI8B5TE;
		int eQze6Tme;
		int SI1GsbQC;
		int yzSvGiZ8;
		MessageDigest MzQvAhFj;
		MessageDigest Vfg996g2;
		byte[] zZsCOT6b;
		byte[] HYvPWF2H;
		byte[] Sv1SCY7E;
		StringBuffer SEdsrEyM;
		if (MGTzbCOl.startsWith(magic)) {
			MGTzbCOl = MGTzbCOl.substring(magic.length());
		}
		if ((ZBI8B5TE = MGTzbCOl.indexOf('$')) != -1) {
			MGTzbCOl = MGTzbCOl.substring(0, ZBI8B5TE);
		}
		if (MGTzbCOl.length() > 8) {
			MGTzbCOl = MGTzbCOl.substring(0, 8);
		}
		MzQvAhFj = MessageDigest.getInstance("MD5");
		MzQvAhFj.update(ZxHNSkRr.getBytes());
		MzQvAhFj.update(magic.getBytes());
		MzQvAhFj.update(MGTzbCOl.getBytes());
		Vfg996g2 = MessageDigest.getInstance("MD5");
		Vfg996g2.update(ZxHNSkRr.getBytes());
		Vfg996g2.update(MGTzbCOl.getBytes());
		Vfg996g2.update(ZxHNSkRr.getBytes());
		zZsCOT6b = Vfg996g2.digest();
		for (eQze6Tme = ZxHNSkRr.length(); eQze6Tme > 0; eQze6Tme -= 16) {
			MzQvAhFj.update(zZsCOT6b, 0, eQze6Tme > 16 ? 16 : eQze6Tme);
		}
		HYvPWF2H = ZxHNSkRr.getBytes();
		for (yzSvGiZ8 = ZxHNSkRr.length(); yzSvGiZ8 > 0; yzSvGiZ8 >>= 1) {
			if ((yzSvGiZ8 & 1) == 1) {
				MzQvAhFj.update((byte) 0);
			} else {
				MzQvAhFj.update(HYvPWF2H, 0, 1);
			}
		}
		SEdsrEyM = new StringBuffer(magic);
		SEdsrEyM.append(MGTzbCOl);
		SEdsrEyM.append("$");
		zZsCOT6b = MzQvAhFj.digest();
		Sv1SCY7E = MGTzbCOl.getBytes();
		for (yzSvGiZ8 = 0; yzSvGiZ8 < 1000; yzSvGiZ8++) {
			Vfg996g2.reset();
			if ((yzSvGiZ8 & 1) == 1) {
				Vfg996g2.update(HYvPWF2H);
			} else {
				Vfg996g2.update(zZsCOT6b);
			}
			if (yzSvGiZ8 % 3 != 0) {
				Vfg996g2.update(Sv1SCY7E);
			}
			if (yzSvGiZ8 % 7 != 0) {
				Vfg996g2.update(HYvPWF2H);
			}
			if ((yzSvGiZ8 & 1) != 0) {
				Vfg996g2.update(zZsCOT6b);
			} else {
				Vfg996g2.update(HYvPWF2H);
			}
			zZsCOT6b = Vfg996g2.digest();
		}
		SI1GsbQC = ((zZsCOT6b[0] & 0xff) << 16) | ((zZsCOT6b[6] & 0xff) << 8) | (zZsCOT6b[12] & 0xff);
		SEdsrEyM.append(to64(SI1GsbQC, 4));
		SI1GsbQC = ((zZsCOT6b[1] & 0xff) << 16) | ((zZsCOT6b[7] & 0xff) << 8) | (zZsCOT6b[13] & 0xff);
		SEdsrEyM.append(to64(SI1GsbQC, 4));
		SI1GsbQC = ((zZsCOT6b[2] & 0xff) << 16) | ((zZsCOT6b[8] & 0xff) << 8) | (zZsCOT6b[14] & 0xff);
		SEdsrEyM.append(to64(SI1GsbQC, 4));
		SI1GsbQC = ((zZsCOT6b[3] & 0xff) << 16) | ((zZsCOT6b[9] & 0xff) << 8) | (zZsCOT6b[15] & 0xff);
		SEdsrEyM.append(to64(SI1GsbQC, 4));
		SI1GsbQC = ((zZsCOT6b[4] & 0xff) << 16) | ((zZsCOT6b[10] & 0xff) << 8) | (zZsCOT6b[5] & 0xff);
		SEdsrEyM.append(to64(SI1GsbQC, 4));
		SI1GsbQC = zZsCOT6b[11] & 0xff;
		SEdsrEyM.append(to64(SI1GsbQC, 2));
		return SEdsrEyM.toString();
	}

}