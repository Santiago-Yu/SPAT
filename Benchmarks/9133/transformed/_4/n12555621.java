class n12555621 {
	public String md5(Value request) throws FaultException {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(request.strValue().getBytes("UTF8"));
		} catch (UnsupportedEncodingException e) {
			throw new FaultException("UnsupportedOperation", e);
		} catch (NoSuchAlgorithmException e) {
			throw new FaultException("UnsupportedOperation", e);
		}
		int radix;
		radix = ((radix = request.getFirstChild("radix").intValue()) < 2) ? 16 : radix;
		return new BigInteger(1, md.digest()).toString(radix);
	}

}