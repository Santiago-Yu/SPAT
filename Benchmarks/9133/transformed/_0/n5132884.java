class n5132884 {
	public byte[] encryptMsg(String FZlRBrlh) {
		byte[] JMtAGPMR = null;
		try {
			MessageDigest GDer9ktr = MessageDigest.getInstance("MD5");
			GDer9ktr.update(FZlRBrlh.getBytes());
			JMtAGPMR = GDer9ktr.digest();
		} catch (NoSuchAlgorithmException eLtXdJ07) {
			eLtXdJ07.printStackTrace();
		}
		return JMtAGPMR;
	}

}