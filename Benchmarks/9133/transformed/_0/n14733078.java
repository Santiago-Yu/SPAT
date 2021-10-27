class n14733078 {
	private static String encrypt(String eQbMWMW8, String iLozMUQJ, Long gFHpU3cu) {
		try {
			MessageDigest oz7I5Lwu = MessageDigest.getInstance(eQbMWMW8);
			oz7I5Lwu.reset();
			oz7I5Lwu.update(iLozMUQJ.getBytes("UTF-8"));
			oz7I5Lwu.update(gFHpU3cu.toString().getBytes("UTF-8"));
			byte[] LTDkwhG9 = oz7I5Lwu.digest();
			StringBuffer ekJ7SRu4 = new StringBuffer();
			for (int nT4NAQxF = 0; nT4NAQxF < LTDkwhG9.length; nT4NAQxF++) {
				ekJ7SRu4.append(Integer.toHexString((0xf0 & LTDkwhG9[nT4NAQxF]) >> 4));
				ekJ7SRu4.append(Integer.toHexString(0x0f & LTDkwhG9[nT4NAQxF]));
			}
			return ekJ7SRu4.toString();
		} catch (NoSuchAlgorithmException nNmmz4zP) {
			throw new RuntimeException(nNmmz4zP);
		} catch (UnsupportedEncodingException o5kcE8X1) {
			throw new RuntimeException(o5kcE8X1);
		} catch (NullPointerException raKxTuHN) {
			return new StringBuffer().toString();
		}
	}

}