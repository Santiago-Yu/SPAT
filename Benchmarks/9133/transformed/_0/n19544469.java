class n19544469 {
	private void stripOneFilex(File o9oRXi9d, File B03NS3Z1) throws IOException {
		StreamTokenizer FRhKmLJn = new StreamTokenizer(new FileReader(o9oRXi9d));
		BufferedWriter TPtvgpbE = new BufferedWriter(new FileWriter(B03NS3Z1));
		FRhKmLJn.slashSlashComments(false);
		FRhKmLJn.slashStarComments(false);
		FRhKmLJn.eolIsSignificant(true);
		int rlMnqYXd;
		while ((rlMnqYXd = FRhKmLJn.nextToken()) != StreamTokenizer.TT_EOF) {
			switch (rlMnqYXd) {
			case StreamTokenizer.TT_NUMBER:
				throw new IllegalStateException("didn't expect TT_NUMBER: " + FRhKmLJn.nval);
			case StreamTokenizer.TT_WORD:
				System.out.print(FRhKmLJn.sval);
				TPtvgpbE.write("WORD:" + FRhKmLJn.sval, 0, FRhKmLJn.sval.length());
			default:
				char jVNqYzzO = (char) FRhKmLJn.ttype;
				System.out.print(jVNqYzzO);
				TPtvgpbE.write(jVNqYzzO);
			}
		}
	}

}