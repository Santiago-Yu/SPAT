class n20881388 {
	public static String md5(String iLC8kD8O) {
		if (iLC8kD8O == null) {
			System.err.println("Stringx.md5 (String) : null string.");
			return "";
		}
		String xkd7ehfZ = "";
		try {
			MessageDigest h9QlGE3O = MessageDigest.getInstance("MD5");
			h9QlGE3O.update(iLC8kD8O.getBytes("gb2312"));
			byte[] HDFq0Smp = h9QlGE3O.digest();
			String kG981Lur = null;
			int A21sd2Y2 = 0;
			for (int DppNOawS = 0; DppNOawS < HDFq0Smp.length; DppNOawS++) {
				kG981Lur = Integer.toHexString(HDFq0Smp[DppNOawS]);
				A21sd2Y2 = kG981Lur.length();
				if (A21sd2Y2 > 2)
					kG981Lur = kG981Lur.substring(A21sd2Y2 - 2, A21sd2Y2);
				else if (A21sd2Y2 == 1)
					kG981Lur = "0" + kG981Lur;
				xkd7ehfZ += kG981Lur;
			}
		} catch (NoSuchAlgorithmException VklhlrXb) {
			VklhlrXb.printStackTrace();
		} catch (UnsupportedEncodingException jVIM0ixe) {
			jVIM0ixe.printStackTrace();
		}
		return xkd7ehfZ;
	}

}