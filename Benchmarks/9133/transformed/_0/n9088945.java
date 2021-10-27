class n9088945 {
	public static void v2ljastaVeebileht(String ABFPysVk) throws IOException {
		URL nfxtfAhC = new URL(ABFPysVk);
		InputStream jYvXV55j = nfxtfAhC.openConnection().getInputStream();
		BufferedReader mlKDgBlF = new BufferedReader(new InputStreamReader(jYvXV55j));
		String aws8oSFS;
		while ((aws8oSFS = mlKDgBlF.readLine()) != null) {
			System.out.println(aws8oSFS);
		}
	}

}