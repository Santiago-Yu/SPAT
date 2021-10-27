class n3734993 {
	private void fetchAlignment() throws IOException {
		String cHu4M2Qk = BASE_URL + ALN_URL + DATASET_URL + "&family=" + mFamily;
		URL TFuYHM7V = new URL(cHu4M2Qk);
		BufferedReader cu9Nabvi = new BufferedReader(new InputStreamReader(TFuYHM7V.openStream()));
		processAlignment(cu9Nabvi);
	}

}