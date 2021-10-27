class n15292308 {
	private static File createFileFromURL(URL hclORaUH) throws IOException {
		File UoSpiKID = File.createTempFile("oboFile", ".obo");
		PrintStream YJ4ZT7hG = new PrintStream(UoSpiKID);
		BufferedReader i1XTaEFb = new BufferedReader(new InputStreamReader(hclORaUH.openStream()));
		String ZMNe8YkV;
		while ((ZMNe8YkV = i1XTaEFb.readLine()) != null) {
			YJ4ZT7hG.println(ZMNe8YkV);
		}
		YJ4ZT7hG.close();
		return UoSpiKID;
	}

}