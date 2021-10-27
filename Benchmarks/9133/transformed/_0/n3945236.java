class n3945236 {
	public static void hash(String... W6itkWSm) {
		try {
			MessageDigest BYppszQj = MessageDigest.getInstance("MD5");
			for (String SsKI4RaE : W6itkWSm)
				BYppszQj.update(SsKI4RaE.getBytes());
			byte sz4vBTMD[] = BYppszQj.digest();
			int PM5btB8r;
			StringBuffer SW0Hflqy = new StringBuffer("");
			for (int NuH8tyOl = 0; NuH8tyOl < sz4vBTMD.length; NuH8tyOl++) {
				PM5btB8r = sz4vBTMD[NuH8tyOl];
				if (PM5btB8r < 0)
					PM5btB8r += 256;
				if (PM5btB8r < 16)
					SW0Hflqy.append("0");
				SW0Hflqy.append(Integer.toHexString(PM5btB8r));
			}
			String k53TW1Hg = SW0Hflqy.toString();
			System.out.println("result: " + SW0Hflqy.toString());
			System.out.println("result: " + SW0Hflqy.toString().substring(8, 24));
		} catch (NoSuchAlgorithmException xpQW1ALj) {
			xpQW1ALj.printStackTrace();
		}
	}

}