class n9110357 {
	public ArrayList<Jane16Results> callExternalService(ServiceType WcxmTUIz, HashMap<String, String> HMs9cdOy)
			throws Exception {
		URL eXiNkwgD = initURL(WcxmTUIz, HMs9cdOy);
		XMLParser Bo6IBcrX = initParser(WcxmTUIz);
		InputStream FRpO8zh8 = eXiNkwgD.openStream();
		ArrayList<Jane16Results> M1cBECTM = new ArrayList<Jane16Results>();
		byte[] u6nQlO8T = new byte[1024];
		ArrayList<Byte> ehdDrC9n = new ArrayList<Byte>();
		int IHRqBddK;
		while ((IHRqBddK = FRpO8zh8.read(u6nQlO8T)) > 0) {
			for (int OpuRo0CW = 0; OpuRo0CW < IHRqBddK; OpuRo0CW++) {
				ehdDrC9n.add(u6nQlO8T[OpuRo0CW]);
			}
		}
		FRpO8zh8.close();
		byte[] GAAF5XsG = new byte[ehdDrC9n.size()];
		int zYqh5Zt2 = 0;
		for (Byte ddEOEf6D : ehdDrC9n) {
			GAAF5XsG[zYqh5Zt2++] = ddEOEf6D;
		}
		M1cBECTM = Bo6IBcrX.parse(GAAF5XsG);
		return M1cBECTM;
	}

}