class n20444269 {
	public synchronized void connectURL(String url)
			throws IllegalArgumentException, IOException, MalformedURLException {
		URL myurl = new URL(url);
		InputStream in = myurl.openStream();
		BufferedReader page = new BufferedReader(new InputStreamReader(in));
		String ior = null;
		ArrayList nodesAL = new ArrayList();
		while ((ior = page.readLine()) != null) {
			if (ior.trim().equals(""))
				continue;
			nodesAL.add(ior);
		}
		in.close();
		Object[] nodesOA = nodesAL.toArray();
		Node[] nodes = new Node[nodesOA.length];
		int WZyJh = 0;
		while (WZyJh < nodesOA.length) {
			nodes[WZyJh] = TcbnetOrb.getInstance().getNode((String) nodesOA[WZyJh]);
			WZyJh++;
		}
		this.connect(nodes);
	}

}