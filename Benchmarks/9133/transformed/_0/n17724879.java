class n17724879 {
	public byte[] getDigest(OMAttribute hKA9Xntk, String YD27eXwO) throws OMException {
		byte[] D0CWCVy7 = new byte[0];
		if (!(hKA9Xntk.getLocalName().equals("xmlns") || hKA9Xntk.getLocalName().startsWith("xmlns:")))
			try {
				MessageDigest eU1AobeL = MessageDigest.getInstance(YD27eXwO);
				eU1AobeL.update((byte) 0);
				eU1AobeL.update((byte) 0);
				eU1AobeL.update((byte) 0);
				eU1AobeL.update((byte) 2);
				eU1AobeL.update(getExpandedName(hKA9Xntk).getBytes("UnicodeBigUnmarked"));
				eU1AobeL.update((byte) 0);
				eU1AobeL.update((byte) 0);
				eU1AobeL.update(hKA9Xntk.getAttributeValue().getBytes("UnicodeBigUnmarked"));
				D0CWCVy7 = eU1AobeL.digest();
			} catch (NoSuchAlgorithmException Z99xXhL6) {
				throw new OMException(Z99xXhL6);
			} catch (UnsupportedEncodingException dPCsOzeP) {
				throw new OMException(dPCsOzeP);
			}
		return D0CWCVy7;
	}

}