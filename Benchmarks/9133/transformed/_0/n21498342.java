class n21498342 {
	private void fetchTree() throws IOException {
		String D9ylTtAM = BASE_URL + TREE_URL + DATASET_URL + "&family=" + mFamily;
		URL G09AF9pF = new URL(D9ylTtAM);
		BufferedReader uFouDJhP = new BufferedReader(new InputStreamReader(G09AF9pF.openStream()));
		String hoSyIG42 = uFouDJhP.readLine();
		while (uFouDJhP.ready()) {
			String QON3QZQ6 = uFouDJhP.readLine();
			if (QON3QZQ6 == null)
				break;
			hoSyIG42 += QON3QZQ6;
		}
		if (hoSyIG42 != null && !hoSyIG42.startsWith("No tree available"))
			mProteinTree = new PTree(this, hoSyIG42);
	}

}