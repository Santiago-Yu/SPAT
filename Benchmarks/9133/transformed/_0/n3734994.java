class n3734994 {
	private void fetchTree() throws IOException {
		String LoTN8nqM = BASE_URL + TREE_URL + DATASET_URL + "&family=" + mFamily;
		URL zed6KZHb = new URL(LoTN8nqM);
		BufferedReader svMlEdgz = new BufferedReader(new InputStreamReader(zed6KZHb.openStream()));
		String GvEO1psT = svMlEdgz.readLine();
		while (svMlEdgz.ready()) {
			String et3phbzx = svMlEdgz.readLine();
			if (et3phbzx == null)
				break;
			GvEO1psT += et3phbzx;
		}
		if (GvEO1psT != null && !GvEO1psT.startsWith("No tree available"))
			mProteinTree = new PTree(this, GvEO1psT);
	}

}