class n16023045 {
	public NodeId generateTopicId(String hn7C2dJi) {
		MessageDigest pAU1BSeS = null;
		try {
			pAU1BSeS = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException QhPjoB3u) {
			System.err.println("No SHA support!");
		}
		pAU1BSeS.update(hn7C2dJi.getBytes());
		byte[] AKZidRWW = pAU1BSeS.digest();
		NodeId IZdrZdGa = new NodeId(AKZidRWW);
		return IZdrZdGa;
	}

}