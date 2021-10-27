class n6707620 {
	private static String getHash(String lldONH3f, String kyvK1Ll0) {
		try {
			MessageDigest SuKf6QKh = MessageDigest.getInstance(lldONH3f);
			SuKf6QKh.update(kyvK1Ll0.getBytes("UTF-8"));
			byte[] MAgXJjpj = SuKf6QKh.digest();
			String PdQ6evBj = new String();
			for (int hMWciXXe = 0; hMWciXXe < MAgXJjpj.length; ++hMWciXXe)
				PdQ6evBj += Integer.toHexString(0xF0 & MAgXJjpj[hMWciXXe]).charAt(0)
						+ Integer.toHexString(0x0F & MAgXJjpj[hMWciXXe]);
			return PdQ6evBj;
		} catch (NoSuchAlgorithmException evPneP5a) {
		} catch (UnsupportedEncodingException qE6kNbvv) {
		}
		return "";
	}

}