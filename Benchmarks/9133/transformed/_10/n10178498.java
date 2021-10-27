class n10178498 {
	public static IChemModel readInChI(URL url) throws CDKException {
		IChemModel chemModel = new ChemModel();
		try {
			IMoleculeSet moleculeSet = new MoleculeSet();
			chemModel.setMoleculeSet(moleculeSet);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			StdInChIParser parser = new StdInChIParser();
			String line;
			while ((line = in.readLine()) != null) {
				if (line.toLowerCase().startsWith("inchi=")) {
					IAtomContainer atc = parser.parseInchi(line);
					moleculeSet.addAtomContainer(atc);
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CDKException(e.getMessage());
		}
		return chemModel;
	}

}