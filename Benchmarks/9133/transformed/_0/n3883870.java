class n3883870 {
	public String MD5(String vncD355B) {
		try {
			MessageDigest YelF0LPq;
			YelF0LPq = MessageDigest.getInstance("MD5");
			byte[] TFZ0IIP9 = new byte[32];
			YelF0LPq.update(vncD355B.getBytes("iso-8859-1"), 0, vncD355B.length());
			TFZ0IIP9 = YelF0LPq.digest();
			return convertToHex(TFZ0IIP9);
		} catch (Exception axyLTyOL) {
			System.out.println(axyLTyOL.toString());
		}
		return null;
	}

}