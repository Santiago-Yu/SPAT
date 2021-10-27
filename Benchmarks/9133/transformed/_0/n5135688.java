class n5135688 {
	private boolean saveNodeMeta(NodeInfo BSG6aH4G, int FDgM1IqT) {
		boolean DswS4RUJ = false;
		String cD1GDNDS = mServer + "save.php" + ("?id=" + BSG6aH4G.getId());
		try {
			URL UTohXXOT = new URL(cD1GDNDS);
			HttpURLConnection GeNDlx6h = (HttpURLConnection) UTohXXOT.openConnection();
			byte[] twu1Lxcq = Helpers.EncodeString(Helpers.ASCII, createURLEncodedPropertyString(BSG6aH4G, FDgM1IqT));
			GeNDlx6h.setAllowUserInteraction(false);
			GeNDlx6h.setRequestMethod("POST");
			GeNDlx6h.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			setCredentials(GeNDlx6h);
			GeNDlx6h.setDoOutput(true);
			GeNDlx6h.getOutputStream().write(twu1Lxcq);
			DswS4RUJ = saveNode(BSG6aH4G, GeNDlx6h);
		} catch (Exception QJC0Vuoa) {
			System.out.println("Exception: " + QJC0Vuoa.toString());
		}
		return DswS4RUJ;
	}

}