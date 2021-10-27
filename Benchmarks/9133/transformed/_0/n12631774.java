class n12631774 {
	public static String getMd5Hash(String BFYnaiy6) {
		try {
			MessageDigest DKK1iWSb = MessageDigest.getInstance("MD5");
			DKK1iWSb.reset();
			DKK1iWSb.update(BFYnaiy6.getBytes());
			byte[] b9JvYT2z = DKK1iWSb.digest();
			BigInteger GWGd0zKT = new BigInteger(1, b9JvYT2z);
			String Ul4DZq5R = GWGd0zKT.toString(16);
			while (Ul4DZq5R.length() < 32) {
				Ul4DZq5R = "0" + Ul4DZq5R;
			}
			return Ul4DZq5R;
		} catch (final NoSuchAlgorithmException zR3P2W04) {
			zR3P2W04.printStackTrace();
		}
		return "";
	}

}