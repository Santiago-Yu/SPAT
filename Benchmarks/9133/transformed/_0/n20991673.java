class n20991673 {
	public NodeId generateTopicId(String D70EXWsr) {
		MessageDigest xtByIslj = null;
		try {
			xtByIslj = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException fefJCSzV) {
			System.err.println("No SHA support!");
		}
		if (m_ready)
			System.out.println("Scribe is ready at" + getNodeId() + " , topic is " + D70EXWsr);
		xtByIslj.update(D70EXWsr.getBytes());
		byte[] VTpGPU4Q = xtByIslj.digest();
		NodeId SNaMfn63 = new NodeId(VTpGPU4Q);
		return SNaMfn63;
	}

}