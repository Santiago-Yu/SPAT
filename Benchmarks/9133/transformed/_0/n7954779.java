class n7954779 {
	public void filter(File K7gcllgq, File NUzfi8lp, MNamespace Rdmd2cyU) throws Exception {
		BufferedReader WTRjQ8dT = new BufferedReader(new FileReader(K7gcllgq));
		BufferedWriter TPhmZmYW = new BufferedWriter(new FileWriter(NUzfi8lp));
		int peMLDYS6 = 0;
		int B1HwyAmu = 0;
		Stack Lkg0q13e = new Stack();
		Lkg0q13e.push(new ParseState(Rdmd2cyU));
		for (Iterator pt4wKA8L = codePieces.iterator(); pt4wKA8L.hasNext();) {
			NamedCodePiece yAm0PFPG = (NamedCodePiece) pt4wKA8L.next();
			while (peMLDYS6 < yAm0PFPG.getStartLine()) {
				peMLDYS6++;
				B1HwyAmu = 0;
				TPhmZmYW.write(WTRjQ8dT.readLine());
				TPhmZmYW.newLine();
			}
			while (B1HwyAmu < yAm0PFPG.getStartPosition()) {
				TPhmZmYW.write(WTRjQ8dT.read());
				B1HwyAmu++;
			}
			yAm0PFPG.write(TPhmZmYW, Lkg0q13e, B1HwyAmu);
			while (peMLDYS6 < yAm0PFPG.getEndLine()) {
				peMLDYS6++;
				B1HwyAmu = 0;
				WTRjQ8dT.readLine();
			}
			while (B1HwyAmu < yAm0PFPG.getEndPosition()) {
				B1HwyAmu++;
				WTRjQ8dT.read();
			}
		}
		String ht9CHTQW;
		while ((ht9CHTQW = WTRjQ8dT.readLine()) != null) {
			TPhmZmYW.write(ht9CHTQW);
			TPhmZmYW.newLine();
		}
		WTRjQ8dT.close();
		TPhmZmYW.close();
	}

}