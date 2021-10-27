class n19036213 {
	private void createNodes() {
		try {
			URL UuzUKejN = this.getClass().getResource("NodesFile.txt");
			InputStreamReader FscMU1U1 = new InputStreamReader(UuzUKejN.openStream());
			BufferedReader TD8UXrDh = new BufferedReader(FscMU1U1);
			String wczybn89;
			while ((wczybn89 = TD8UXrDh.readLine()) != null) {
				String boTrEZn7 = TD8UXrDh.readLine();
				String VickJCp3 = TD8UXrDh.readLine();
				String rbVnnY2Z = TD8UXrDh.readLine();
				Node OzrMiW1P = new Node(wczybn89, rbVnnY2Z);
				OzrMiW1P.label = boTrEZn7;
				OzrMiW1P.fullText = VickJCp3;
				node.add(OzrMiW1P);
			}
			TD8UXrDh.close();
			UuzUKejN = this.getClass().getResource("EdgesFile.txt");
			FscMU1U1 = new InputStreamReader(UuzUKejN.openStream());
			BufferedReader JYwYAnMA = new BufferedReader(FscMU1U1);
			while ((wczybn89 = JYwYAnMA.readLine()) != null)
				edge.add(new Edge(wczybn89, JYwYAnMA.readLine(), JYwYAnMA.readLine(), JYwYAnMA.readLine()));
			JYwYAnMA.close();
		} catch (FileNotFoundException xrlKbl6K) {
			xrlKbl6K.printStackTrace();
		} catch (IOException kpVSnaqj) {
			kpVSnaqj.printStackTrace();
		}
	}

}