class n11722050 {
	public byte[] authClient(String MMJ9yyx9, String Ur3yOgEH, String VgP997Ih, String XyRoJcFe, String BJ53xmto)
			throws IOException {
		ByteArrayOutputStream TJf0kJKP = new ByteArrayOutputStream();
		OutputStream OxFb4S21 = new BASE64EncoderStream(TJf0kJKP, Integer.MAX_VALUE);
		SecureRandom azCP7Qsr;
		try {
			azCP7Qsr = new SecureRandom();
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException UOnQMrNg) {
			if (debugout != null)
				debugout.println("DEBUG DIGEST-MD5: " + UOnQMrNg);
			throw new IOException(UOnQMrNg.toString());
		}
		StringBuffer V2J8eNC0 = new StringBuffer();
		uri = "smtp/" + MMJ9yyx9;
		String kUIiPEl9 = "00000001";
		String zBOsNU1U = "auth";
		byte[] oTtQ51ZM = new byte[32];
		int we2wKD1x;
		if (debugout != null)
			debugout.println("DEBUG DIGEST-MD5: Begin authentication ...");
		Hashtable ELAIjkNH = tokenize(BJ53xmto);
		if (XyRoJcFe == null) {
			String EJQq2Cr5 = (String) ELAIjkNH.get("realm");
			XyRoJcFe = EJQq2Cr5 != null ? new StringTokenizer(EJQq2Cr5, ",").nextToken() : MMJ9yyx9;
		}
		String VahJqiEW = (String) ELAIjkNH.get("nonce");
		azCP7Qsr.nextBytes(oTtQ51ZM);
		OxFb4S21.write(oTtQ51ZM);
		OxFb4S21.flush();
		String Eq4sfhM1 = TJf0kJKP.toString();
		TJf0kJKP.reset();
		md5.update(md5.digest(ASCIIUtility.getBytes(Ur3yOgEH + ":" + XyRoJcFe + ":" + VgP997Ih)));
		md5.update(ASCIIUtility.getBytes(":" + VahJqiEW + ":" + Eq4sfhM1));
		clientResponse = toHex(md5.digest()) + ":" + VahJqiEW + ":" + kUIiPEl9 + ":" + Eq4sfhM1 + ":" + zBOsNU1U + ":";
		md5.update(ASCIIUtility.getBytes("AUTHENTICATE:" + uri));
		md5.update(ASCIIUtility.getBytes(clientResponse + toHex(md5.digest())));
		V2J8eNC0.append("username=\"" + Ur3yOgEH + "\"");
		V2J8eNC0.append(",realm=\"" + XyRoJcFe + "\"");
		V2J8eNC0.append(",qop=" + zBOsNU1U);
		V2J8eNC0.append(",nc=" + kUIiPEl9);
		V2J8eNC0.append(",nonce=\"" + VahJqiEW + "\"");
		V2J8eNC0.append(",cnonce=\"" + Eq4sfhM1 + "\"");
		V2J8eNC0.append(",digest-uri=\"" + uri + "\"");
		V2J8eNC0.append(",response=" + toHex(md5.digest()));
		if (debugout != null)
			debugout.println("DEBUG DIGEST-MD5: Response => " + V2J8eNC0.toString());
		OxFb4S21.write(ASCIIUtility.getBytes(V2J8eNC0.toString()));
		OxFb4S21.flush();
		return TJf0kJKP.toByteArray();
	}

}