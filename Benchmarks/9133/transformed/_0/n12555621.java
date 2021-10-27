class n12555621 {
	public String md5(Value hz02stgI) throws FaultException {
		MessageDigest SJBkSaz9 = null;
		try {
			SJBkSaz9 = MessageDigest.getInstance("MD5");
			SJBkSaz9.update(hz02stgI.strValue().getBytes("UTF8"));
		} catch (UnsupportedEncodingException E4cMWptM) {
			throw new FaultException("UnsupportedOperation", E4cMWptM);
		} catch (NoSuchAlgorithmException xNCkYilD) {
			throw new FaultException("UnsupportedOperation", xNCkYilD);
		}
		int PLNx4M5f;
		if ((PLNx4M5f = hz02stgI.getFirstChild("radix").intValue()) < 2) {
			PLNx4M5f = 16;
		}
		return new BigInteger(1, SJBkSaz9.digest()).toString(PLNx4M5f);
	}

}