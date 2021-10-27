class n18673631 {
	public String digestPassword(String ySdqtx1z) {
		StringBuffer BA1vPea3 = new StringBuffer();
		try {
			MessageDigest i3LTkfSC = MessageDigest.getInstance("MD5");
			i3LTkfSC.reset();
			i3LTkfSC.update(ySdqtx1z.getBytes());
			byte[] dnPEViVf = i3LTkfSC.digest();
			for (byte c7LInWpe : dnPEViVf) {
				BA1vPea3.append(Integer.toHexString(0xFF & c7LInWpe));
			}
		} catch (NoSuchAlgorithmException K0a1o3mW) {
			K0a1o3mW.printStackTrace();
		}
		return BA1vPea3.toString();
	}

}