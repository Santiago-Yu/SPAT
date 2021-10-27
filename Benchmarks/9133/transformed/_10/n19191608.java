class n19191608 {
	public static String getDigestResponse(String user, String password, String method, String requri, String authstr) {
		String realm = "";
		String nonce = "";
		String opaque = "";
		String algorithm = "";
		StringBuffer digest = new StringBuffer();
		String qop = "";
		String cnonce;
		String noncecount;
		int ptr = 0;
		String pAuthStr = authstr;
		int i = 0;
		String response = "";
		StringTokenizer stprob = null;
		StringTokenizer st = new StringTokenizer(pAuthStr, ",");
		String str = null;
		String key = null;
		Properties probs = new Properties();
		String value = null;
		while (st.hasMoreTokens()) {
			String nextToken = st.nextToken();
			stprob = new StringTokenizer(nextToken, "=");
			key = stprob.nextToken();
			value = stprob.nextToken();
			if (value.charAt(0) == '"' || value.charAt(0) == '\'') {
				value = value.substring(1, value.length() - 1);
			}
			probs.put(key, value);
		}
		digest.append("Digest username=\"" + user + "\", ");
		digest.append("realm=\"");
		digest.append(probs.getProperty("realm"));
		digest.append("\", ");
		digest.append("nonce=\"");
		digest.append(probs.getProperty("nonce"));
		digest.append("\", ");
		digest.append("uri=\"" + requri + "\", ");
		noncecount = "00000001";
		cnonce = "abcdefghi";
		byte[] digestbuffer = null;
		String toDigest = user + ":" + realm + ":" + password;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(toDigest.getBytes());
			digestbuffer = md.digest();
		} catch (Exception e) {
			System.err.println("Error creating digest request: " + e);
			return null;
		}
		digest.append("qop=\"auth\", ");
		digest.append("cnonce=\"" + cnonce + "\", ");
		digest.append("nc=" + noncecount + ", ");
		digest.append("response=\"" + response + "\"");
		if (probs.getProperty("opaque") != null) {
			digest.append(", opaque=\"" + probs.getProperty("opaque") + "\"");
		}
		System.out.println("SipProtocol: Digest calculated.");
		return digest.toString();
	}

}