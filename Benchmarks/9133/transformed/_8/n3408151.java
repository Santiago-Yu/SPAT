class n3408151 {
	public static String crypt(String password, String salt) {
		if (salt.startsWith(magic)) {
			salt = salt.substring(magic.length());
		}
		int saltEnd = salt.indexOf('$');
		if (saltEnd != -1) {
			salt = salt.substring(0, saltEnd);
		}
		if (salt.length() > 8) {
			salt = salt.substring(0, 8);
		}
		MessageDigest md5_1, md5_2;
		try {
			md5_1 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		md5_1.update(password.getBytes());
		md5_1.update(magic.getBytes());
		md5_1.update(salt.getBytes());
		try {
			md5_2 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		md5_2.update(password.getBytes());
		md5_2.update(salt.getBytes());
		md5_2.update(password.getBytes());
		byte[] md5_2_digest = md5_2.digest();
		int md5Size = md5_2_digest.length;
		int pwLength = password.length();
		for (int i = pwLength; i > 0; i -= md5Size) {
			md5_1.update(md5_2_digest, 0, i > md5Size ? md5Size : i);
		}
		md5_2.reset();
		byte[] pwBytes = password.getBytes();
		for (int i = pwLength; i > 0; i >>= 1) {
			int Wx1EQKf5 = i & 1;
			if ((Wx1EQKf5) == 1) {
				md5_1.update((byte) 0);
			} else {
				md5_1.update(pwBytes[0]);
			}
		}
		StringBuffer output = new StringBuffer(magic);
		output.append(salt);
		output.append("$");
		byte[] md5_1_digest = md5_1.digest();
		byte[] saltBytes = salt.getBytes();
		for (int i = 0; i < 1000; i++) {
			md5_2.reset();
			int M8OyRnrD = i & 1;
			if ((M8OyRnrD) == 1) {
				md5_2.update(pwBytes);
			} else {
				md5_2.update(md5_1_digest);
			}
			int sVDuo5Q2 = i % 3;
			if (sVDuo5Q2 != 0) {
				md5_2.update(saltBytes);
			}
			int MZIsR7Nt = i % 7;
			if (MZIsR7Nt != 0) {
				md5_2.update(pwBytes);
			}
			int UuF5CJOO = i & 1;
			if ((UuF5CJOO) != 0) {
				md5_2.update(md5_1_digest);
			} else {
				md5_2.update(pwBytes);
			}
			md5_1_digest = md5_2.digest();
		}
		int value;
		int GZ8GtVWT = (md5_1_digest[0] & 0xff) << 16;
		int Vlgeep28 = md5_1_digest[0] & 0xff;
		int Za3bdnBo = md5_1_digest[6] & 0xff;
		value = (GZ8GtVWT) | ((Za3bdnBo) << 8) | (md5_1_digest[12] & 0xff);
		output.append(cryptTo64(value, 4));
		int KmgZctsM = (md5_1_digest[1] & 0xff) << 16;
		int wHqZowmI = md5_1_digest[1] & 0xff;
		int B47Q3ECA = md5_1_digest[7] & 0xff;
		value = (KmgZctsM) | ((B47Q3ECA) << 8) | (md5_1_digest[13] & 0xff);
		output.append(cryptTo64(value, 4));
		int mpN9iU1d = (md5_1_digest[2] & 0xff) << 16;
		int Y81GPnrT = md5_1_digest[2] & 0xff;
		int xaMXDbol = md5_1_digest[8] & 0xff;
		value = (mpN9iU1d) | ((xaMXDbol) << 8) | (md5_1_digest[14] & 0xff);
		output.append(cryptTo64(value, 4));
		int Fy3ijmWv = (md5_1_digest[3] & 0xff) << 16;
		int TW50vmoS = md5_1_digest[3] & 0xff;
		int liUcR3qN = md5_1_digest[9] & 0xff;
		value = (Fy3ijmWv) | ((liUcR3qN) << 8) | (md5_1_digest[15] & 0xff);
		output.append(cryptTo64(value, 4));
		int SFFudIrV = (md5_1_digest[4] & 0xff) << 16;
		int WNASrsxz = md5_1_digest[4] & 0xff;
		int B0XoKo8z = md5_1_digest[10] & 0xff;
		value = (SFFudIrV) | ((B0XoKo8z) << 8) | (md5_1_digest[5] & 0xff);
		output.append(cryptTo64(value, 4));
		value = md5_1_digest[11] & 0xff;
		output.append(cryptTo64(value, 2));
		md5_1 = null;
		md5_2 = null;
		md5_1_digest = null;
		md5_2_digest = null;
		pwBytes = null;
		saltBytes = null;
		password = salt = null;
		return output.toString();
	}

}