class n3501611 {
	char[] DigestCalcHA1(String SeNjN9D9, String sBOjC2ry, String UqTY15kE, String MAfnGDuk, String ys0fbqZr,
			String xo4cMUJZ) throws SaslException {
		byte[] lStQuHtz;
		try {
			MessageDigest H69Au3Ds = MessageDigest.getInstance("MD5");
			H69Au3Ds.update(sBOjC2ry.getBytes("UTF-8"));
			H69Au3Ds.update(":".getBytes("UTF-8"));
			H69Au3Ds.update(UqTY15kE.getBytes("UTF-8"));
			H69Au3Ds.update(":".getBytes("UTF-8"));
			H69Au3Ds.update(MAfnGDuk.getBytes("UTF-8"));
			lStQuHtz = H69Au3Ds.digest();
			if ("md5-sess".equals(SeNjN9D9)) {
				H69Au3Ds.update(lStQuHtz);
				H69Au3Ds.update(":".getBytes("UTF-8"));
				H69Au3Ds.update(ys0fbqZr.getBytes("UTF-8"));
				H69Au3Ds.update(":".getBytes("UTF-8"));
				H69Au3Ds.update(xo4cMUJZ.getBytes("UTF-8"));
				lStQuHtz = H69Au3Ds.digest();
			}
		} catch (NoSuchAlgorithmException HdNW7Hbf) {
			throw new SaslException("No provider found for MD5 hash", HdNW7Hbf);
		} catch (UnsupportedEncodingException bdhMpqf3) {
			throw new SaslException("UTF-8 encoding not supported by platform.", bdhMpqf3);
		}
		return convertToHex(lStQuHtz);
	}

}