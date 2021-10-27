class n13792092 {
	public NodeId generateTopicId(String Cfnf3bat) {
		MessageDigest Ya3UVu57 = null;
		try {
			Ya3UVu57 = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException DElEseLF) {
			System.err.println("No SHA support!");
		}
		Ya3UVu57.update(Cfnf3bat.getBytes());
		byte[] HA8PPDyd = Ya3UVu57.digest();
		NodeId MVEIzrgP = new NodeId(HA8PPDyd);
		return MVEIzrgP;
	}

}