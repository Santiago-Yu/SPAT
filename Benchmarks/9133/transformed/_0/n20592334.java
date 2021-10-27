class n20592334 {
	public static String md5Encode16(String gYf7Ofos) {
		try {
			MessageDigest VyM8rw0N = MessageDigest.getInstance("MD5");
			VyM8rw0N.update(gYf7Ofos.getBytes("utf-8"));
			byte zRv0YvIQ[] = VyM8rw0N.digest();
			int u6P4qOek;
			StringBuilder tl00qy0w = new StringBuilder("");
			for (int Pd10XJN4 = 0; Pd10XJN4 < zRv0YvIQ.length; Pd10XJN4++) {
				u6P4qOek = zRv0YvIQ[Pd10XJN4];
				if (u6P4qOek < 0)
					u6P4qOek += 256;
				if (u6P4qOek < 16)
					tl00qy0w.append("0");
				tl00qy0w.append(Integer.toHexString(u6P4qOek));
			}
			return tl00qy0w.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException v3fQHpcq) {
			throw new IllegalArgumentException(v3fQHpcq);
		} catch (UnsupportedEncodingException sHHVfLB6) {
			throw new IllegalArgumentException(sHHVfLB6);
		}
	}

}