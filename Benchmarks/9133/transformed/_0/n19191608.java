class n19191608 {
	public static String getDigestResponse(String sVeR07AU, String oRpAlWLb, String pKt5PWQk, String lGgoDsjX,
			String Q4J1r8av) {
		String iuGNDW1S = "";
		String LiRkgbvS = "";
		String qT4hRSjy = "";
		String SI4nXxAs = "";
		String Bm8CcMCY = "";
		StringBuffer EEEop68f = new StringBuffer();
		String cSLxa7TU;
		String rSsyI3u6;
		String QqHeP9Dg = Q4J1r8av;
		int lX8YJV7M = 0;
		String v8twNYaK = "";
		int XsnVef53 = 0;
		StringTokenizer XqWlofdv = new StringTokenizer(QqHeP9Dg, ",");
		StringTokenizer v0odLfBc = null;
		String OB5Fz1lQ = null;
		String csYUAMco = null;
		String MfdT0oMp = null;
		Properties AwMREP36 = new Properties();
		while (XqWlofdv.hasMoreTokens()) {
			String Sc0eyS5Y = XqWlofdv.nextToken();
			v0odLfBc = new StringTokenizer(Sc0eyS5Y, "=");
			csYUAMco = v0odLfBc.nextToken();
			MfdT0oMp = v0odLfBc.nextToken();
			if (MfdT0oMp.charAt(0) == '"' || MfdT0oMp.charAt(0) == '\'') {
				MfdT0oMp = MfdT0oMp.substring(1, MfdT0oMp.length() - 1);
			}
			AwMREP36.put(csYUAMco, MfdT0oMp);
		}
		EEEop68f.append("Digest username=\"" + sVeR07AU + "\", ");
		EEEop68f.append("realm=\"");
		EEEop68f.append(AwMREP36.getProperty("realm"));
		EEEop68f.append("\", ");
		EEEop68f.append("nonce=\"");
		EEEop68f.append(AwMREP36.getProperty("nonce"));
		EEEop68f.append("\", ");
		EEEop68f.append("uri=\"" + lGgoDsjX + "\", ");
		cSLxa7TU = "abcdefghi";
		rSsyI3u6 = "00000001";
		String B0MfpyUb = sVeR07AU + ":" + iuGNDW1S + ":" + oRpAlWLb;
		byte[] YaeREUH0 = null;
		try {
			MessageDigest vywZoLR4 = MessageDigest.getInstance("MD5");
			vywZoLR4.update(B0MfpyUb.getBytes());
			YaeREUH0 = vywZoLR4.digest();
		} catch (Exception E2WQZCTK) {
			System.err.println("Error creating digest request: " + E2WQZCTK);
			return null;
		}
		EEEop68f.append("qop=\"auth\", ");
		EEEop68f.append("cnonce=\"" + cSLxa7TU + "\", ");
		EEEop68f.append("nc=" + rSsyI3u6 + ", ");
		EEEop68f.append("response=\"" + v8twNYaK + "\"");
		if (AwMREP36.getProperty("opaque") != null) {
			EEEop68f.append(", opaque=\"" + AwMREP36.getProperty("opaque") + "\"");
		}
		System.out.println("SipProtocol: Digest calculated.");
		return EEEop68f.toString();
	}

}