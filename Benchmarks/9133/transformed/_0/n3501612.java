class n3501612 {
	char[] DigestCalcResponse(char[] hGrCePz8, String IAKmKCXe, String xelE6J1I, String vcLzFbyA, String q5QJJkkY,
			String HJNT14lg, String hlKOdrb3, boolean n9BRvDAR) throws SaslException {
		byte[] OzCAQiNQ;
		byte[] YX1vX3RE;
		char[] jOlszZ7d;
		try {
			MessageDigest MGG74LyR = MessageDigest.getInstance("MD5");
			if (n9BRvDAR)
				MGG74LyR.update(HJNT14lg.getBytes("UTF-8"));
			MGG74LyR.update(":".getBytes("UTF-8"));
			MGG74LyR.update(hlKOdrb3.getBytes("UTF-8"));
			if ("auth-int".equals(q5QJJkkY)) {
				MGG74LyR.update(":".getBytes("UTF-8"));
				MGG74LyR.update("00000000000000000000000000000000".getBytes("UTF-8"));
			}
			OzCAQiNQ = MGG74LyR.digest();
			jOlszZ7d = convertToHex(OzCAQiNQ);
			MGG74LyR.update(new String(hGrCePz8).getBytes("UTF-8"));
			MGG74LyR.update(":".getBytes("UTF-8"));
			MGG74LyR.update(IAKmKCXe.getBytes("UTF-8"));
			MGG74LyR.update(":".getBytes("UTF-8"));
			if (q5QJJkkY.length() > 0) {
				MGG74LyR.update(xelE6J1I.getBytes("UTF-8"));
				MGG74LyR.update(":".getBytes("UTF-8"));
				MGG74LyR.update(vcLzFbyA.getBytes("UTF-8"));
				MGG74LyR.update(":".getBytes("UTF-8"));
				MGG74LyR.update(q5QJJkkY.getBytes("UTF-8"));
				MGG74LyR.update(":".getBytes("UTF-8"));
			}
			MGG74LyR.update(new String(jOlszZ7d).getBytes("UTF-8"));
			YX1vX3RE = MGG74LyR.digest();
		} catch (NoSuchAlgorithmException NOtKOubD) {
			throw new SaslException("No provider found for MD5 hash", NOtKOubD);
		} catch (UnsupportedEncodingException jRHSkpC2) {
			throw new SaslException("UTF-8 encoding not supported by platform.", jRHSkpC2);
		}
		return convertToHex(YX1vX3RE);
	}

}