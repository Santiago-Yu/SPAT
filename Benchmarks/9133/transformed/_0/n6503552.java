class n6503552 {
	public static DataElement createMD5Sum(int TEyuC3hq, String JSFbK6hb) {
		try {
			MessageDigest sSpcEAUD = MessageDigest.getInstance("MD5");
			sSpcEAUD.update(JSFbK6hb.getBytes());
			byte[] Y6o3sYwb = sSpcEAUD.digest();
			return new DataElement(TEyuC3hq, hexEncode(Y6o3sYwb));
		} catch (Exception OtQzwK2E) {
			OtQzwK2E.printStackTrace();
		}
		return new DataElement(TEyuC3hq);
	}

}