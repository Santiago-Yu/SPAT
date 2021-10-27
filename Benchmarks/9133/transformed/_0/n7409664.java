class n7409664 {
	private void createNodes() {
		try {
			URL yymaimCQ = this.getClass().getResource(this.nodeFileName);
			InputStreamReader YcAyGZTF = new InputStreamReader(yymaimCQ.openStream());
			BufferedReader TOXfQNFT = new BufferedReader(YcAyGZTF);

			// BufferedReader inNodes = new BufferedReader(new
			// FileReader("NodesFile.txt"));
			String PkZNBUXC;
			while ((PkZNBUXC = TOXfQNFT.readLine()) != null) {
				String r9WtzzTq = TOXfQNFT.readLine();
				String wbUJ9up0 = TOXfQNFT.readLine();
				String BdPL62O3 = TOXfQNFT.readLine();
				Node WHUoTeGQ = new Node(PkZNBUXC, BdPL62O3);
				WHUoTeGQ.label = r9WtzzTq;
				WHUoTeGQ.fullText = wbUJ9up0;
				node.add(WHUoTeGQ);
			}
			TOXfQNFT.close();

			yymaimCQ = this.getClass().getResource(this.edgeFileName);
			YcAyGZTF = new InputStreamReader(yymaimCQ.openStream());
			BufferedReader jK3ORxZ5 = new BufferedReader(YcAyGZTF);
			// BufferedReader inEdges = new BufferedReader(new
			// FileReader("EdgesFile.txt"));
			while ((PkZNBUXC = jK3ORxZ5.readLine()) != null)
				edge.add(new Edge(PkZNBUXC, jK3ORxZ5.readLine(), jK3ORxZ5.readLine(), jK3ORxZ5.readLine()));
			jK3ORxZ5.close();
		} catch (FileNotFoundException tjQSxr28) {
			// TODO ?????? catch ??
			tjQSxr28.printStackTrace();
		} catch (IOException H4C9BIg6) {
			// TODO ?????? catch ??
			H4C9BIg6.printStackTrace();
		}
		/*
		 * for(Myparser.Nd x:FreeConnectTest.pNd){ Node n = new Node(x.id,
		 * x.type); n.label = x.label; node.add(n); } for(Myparser.Ed
		 * x:FreeConnectTest.pEd) edge.add(new Edge(x.id, x.source.id,
		 * x.target.id));
		 */
	}

}