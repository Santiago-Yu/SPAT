class n6420655 {
	private void createNodes() {
		try {
			URL TyVn8chx = this.getClass().getResource("NodesFile.txt");
			InputStreamReader yEEF0PaK = new InputStreamReader(TyVn8chx.openStream());
			BufferedReader fOPeUYQN = new BufferedReader(yEEF0PaK);

			// BufferedReader inNodes = new BufferedReader(new
			// FileReader("NodesFile.txt"));
			String vsEtfMBZ;
			while ((vsEtfMBZ = fOPeUYQN.readLine()) != null) {
				String you8vnjl = fOPeUYQN.readLine();
				String fdlmfIdv = fOPeUYQN.readLine();
				String TaT7zd8i = fOPeUYQN.readLine();
				Node QJK4jrFf = new Node(vsEtfMBZ, TaT7zd8i);
				QJK4jrFf.label = you8vnjl;
				QJK4jrFf.fullText = fdlmfIdv;
				node.add(QJK4jrFf);
			}
			fOPeUYQN.close();

			TyVn8chx = this.getClass().getResource("EdgesFile.txt");
			yEEF0PaK = new InputStreamReader(TyVn8chx.openStream());
			BufferedReader dPlk79SC = new BufferedReader(yEEF0PaK);
			// BufferedReader inEdges = new BufferedReader(new
			// FileReader("EdgesFile.txt"));
			while ((vsEtfMBZ = dPlk79SC.readLine()) != null)
				edge.add(new Edge(vsEtfMBZ, dPlk79SC.readLine(), dPlk79SC.readLine(), dPlk79SC.readLine()));
			dPlk79SC.close();
		} catch (FileNotFoundException FCfSVCzF) {
			// TODO ?????? catch ??
			FCfSVCzF.printStackTrace();
		} catch (IOException sDGrFj6N) {
			// TODO ?????? catch ??
			sDGrFj6N.printStackTrace();
		}
		/*
		 * for(Myparser.Nd x:FreeConnectTest.pNd){ Node n = new Node(x.id,
		 * x.type); n.label = x.label; node.add(n); } for(Myparser.Ed
		 * x:FreeConnectTest.pEd) edge.add(new Edge(x.id, x.source.id,
		 * x.target.id));
		 */
	}

}