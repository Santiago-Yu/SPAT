class n10178498 {
	public static IChemModel readInChI(URL WSkyQiRZ) throws CDKException {
		IChemModel Zue79hR5 = new ChemModel();
		try {
			IMoleculeSet fwkiBn9T = new MoleculeSet();
			Zue79hR5.setMoleculeSet(fwkiBn9T);
			StdInChIParser o40BGejh = new StdInChIParser();
			BufferedReader iZ4SgGXA = new BufferedReader(new InputStreamReader(WSkyQiRZ.openStream()));
			String pgGbMdjd;
			while ((pgGbMdjd = iZ4SgGXA.readLine()) != null) {
				if (pgGbMdjd.toLowerCase().startsWith("inchi=")) {
					IAtomContainer mwLb4lsG = o40BGejh.parseInchi(pgGbMdjd);
					fwkiBn9T.addAtomContainer(mwLb4lsG);
				}
			}
			iZ4SgGXA.close();
		} catch (Exception bF3JfbUb) {
			bF3JfbUb.printStackTrace();
			throw new CDKException(bF3JfbUb.getMessage());
		}
		return Zue79hR5;
	}

}