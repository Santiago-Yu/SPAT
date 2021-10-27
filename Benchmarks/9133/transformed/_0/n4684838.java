class n4684838 {
	public static Vector<String> readFileFromURL(URL n0M8oMGK) {
		Vector<String> O2Tx5mAA = new Vector<String>();
		try {
			BufferedReader Vbxs9MZr = new BufferedReader(new InputStreamReader(n0M8oMGK.openStream()));
			String YhDEIYsa;
			while ((YhDEIYsa = Vbxs9MZr.readLine()) != null) {
				O2Tx5mAA.add(YhDEIYsa);
			}
			Vbxs9MZr.close();
		} catch (Exception JoRjKpmw) {
			return null;
		}
		return O2Tx5mAA;
	}

}