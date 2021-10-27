class n12242903 {
	private String hashKey(String B4Wp1e0L) {
		String fmtR96xS = "";
		try {
			MessageDigest emJM2EdE = MessageDigest.getInstance("MD5");
			emJM2EdE.update(B4Wp1e0L.getBytes());
			BigInteger a4ldaPlq = new BigInteger(1, emJM2EdE.digest());
			fmtR96xS = a4ldaPlq.toString(16);
		} catch (Exception Cuu9ZlOm) {
			Cuu9ZlOm.printStackTrace();
			fmtR96xS = String.valueOf(B4Wp1e0L.hashCode());
		}
		return fmtR96xS;
	}

}