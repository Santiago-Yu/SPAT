class n21946945 {
	public static String SHA1(String FJOzt40q) throws NoSuchAlgorithmException {
		MessageDigest X46BKVDU = MessageDigest.getInstance("SHA-1");
		X46BKVDU.update(FJOzt40q.getBytes());
		byte Vt69MKVW[] = X46BKVDU.digest();
		StringBuffer daeqeSUO = new StringBuffer();
		for (int NTaa8ckR = 0; NTaa8ckR < Vt69MKVW.length; NTaa8ckR++) {
			daeqeSUO.append(Integer.toString((Vt69MKVW[NTaa8ckR] & 0xff) + 0x100, 16).substring(1));
		}
		StringBuffer k6eq3u5a = new StringBuffer();
		for (int i3gIp3Lh = 0; i3gIp3Lh < Vt69MKVW.length; i3gIp3Lh++) {
			String V981TYy3 = Integer.toHexString(0xff & Vt69MKVW[i3gIp3Lh]);
			if (V981TYy3.length() == 1)
				k6eq3u5a.append('0');
			k6eq3u5a.append(V981TYy3);
		}
		return k6eq3u5a.toString();
	}

}