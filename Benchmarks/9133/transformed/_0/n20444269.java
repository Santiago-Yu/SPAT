class n20444269 {
	public synchronized void connectURL(String WjXmHc2k)
			throws IllegalArgumentException, IOException, MalformedURLException {
		URL EG2m1Cam = new URL(WjXmHc2k);
		InputStream EX5N5hpL = EG2m1Cam.openStream();
		BufferedReader IT8YEkSX = new BufferedReader(new InputStreamReader(EX5N5hpL));
		String Rh9sPThD = null;
		ArrayList UXN3ZjYk = new ArrayList();
		while ((Rh9sPThD = IT8YEkSX.readLine()) != null) {
			if (Rh9sPThD.trim().equals(""))
				continue;
			UXN3ZjYk.add(Rh9sPThD);
		}
		EX5N5hpL.close();
		Object[] EOS1JAfs = UXN3ZjYk.toArray();
		Node[] oF5D6XsV = new Node[EOS1JAfs.length];
		for (int rzUywjnR = 0; rzUywjnR < EOS1JAfs.length; rzUywjnR++)
			oF5D6XsV[rzUywjnR] = TcbnetOrb.getInstance().getNode((String) EOS1JAfs[rzUywjnR]);
		this.connect(oF5D6XsV);
	}

}