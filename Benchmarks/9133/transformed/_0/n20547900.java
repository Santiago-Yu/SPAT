class n20547900 {
	public static String md5(String D8NhpW8F) {
		MessageDigest lcyt60Qx;
		StringWriter ucWlDloB = new StringWriter();
		PrintWriter HsH5u7iO = new PrintWriter(ucWlDloB);
		try {
			lcyt60Qx = MessageDigest.getInstance("MD5");
			lcyt60Qx.update(D8NhpW8F.getBytes());
			byte[] dugBRgEl = lcyt60Qx.digest();
			for (int GpjQG8Up = 0; GpjQG8Up < dugBRgEl.length; GpjQG8Up++) {
				HsH5u7iO.printf("%02x", dugBRgEl[GpjQG8Up]);
			}
			HsH5u7iO.flush();
			return ucWlDloB.getBuffer().toString();
		} catch (NoSuchAlgorithmException nnn86phZ) {
			return null;
		}
	}

}