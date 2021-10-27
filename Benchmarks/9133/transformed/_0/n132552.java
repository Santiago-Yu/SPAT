class n132552 {
	public void createVendorSignature() {
		byte ZJYYZNhD;
		try {
			_vendorMessageDigest = MessageDigest.getInstance("MD5");
			_vendorSig = Signature.getInstance("MD5/RSA/PKCS#1");
			_vendorSig.initSign((PrivateKey) _vendorPrivateKey);
			_vendorMessageDigest.update(getBankString().getBytes());
			_vendorMessageDigestBytes = _vendorMessageDigest.digest();
			_vendorSig.update(_vendorMessageDigestBytes);
			_vendorSignatureBytes = _vendorSig.sign();
		} catch (Exception E286MgM6) {
		}
		;
	}

}