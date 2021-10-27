class n14856221 {
	public static String encodeByMd5(String UO4gzBEK) {
		try {
			if (UO4gzBEK == null) {
				UO4gzBEK = "";
			}
			MessageDigest XLgvluvX = MessageDigest.getInstance("MD5");
			XLgvluvX.update(UO4gzBEK.getBytes("utf-8"));
			byte[] N23gtCXM = XLgvluvX.digest();
			int FOmKZdwQ;
			StringBuffer wJUe50iZ = new StringBuffer("");
			for (int c27xMtwQ = 0; c27xMtwQ < N23gtCXM.length; c27xMtwQ++) {
				FOmKZdwQ = N23gtCXM[c27xMtwQ];
				if (FOmKZdwQ < 0) {
					FOmKZdwQ += 256;
				}
				if (FOmKZdwQ < 16) {
					wJUe50iZ.append("0");
				}
				wJUe50iZ.append(Integer.toHexString(FOmKZdwQ));
			}
			return wJUe50iZ.toString();
		} catch (Exception EoITcVyO) {
			return UO4gzBEK;
		}
	}

}