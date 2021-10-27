class n22131351 {
	private IMolecule readMolecule() throws Exception {
		String H7PJ65zg = "";
		if (index.equals("ichi")) {
			H7PJ65zg = URLEncoder.encode("//molecule[./identifier/basic='" + query + "']", UTF8);
		} else if (index.equals("kegg")) {
			H7PJ65zg = URLEncoder.encode("//molecule[./@name='" + query + "' and ./@dictRef='KEGG']", UTF8);
		} else if (index.equals("nist")) {
			H7PJ65zg = URLEncoder.encode("//molecule[../@id='" + query + "']", UTF8);
		} else {
			logger.error("Did not recognize index type: " + index);
			return null;
		}
		String pTX0K32N = URLEncoder.encode("/" + this.collection, UTF8);
		logger.info("Doing query: " + H7PJ65zg + " in collection " + pTX0K32N);
		URL M8Esa9Ei = new URL("http://" + server + "/Bob/QueryXindice");
		logger.info("Connection to server: " + M8Esa9Ei.toString());
		URLConnection LkjHHpFw = M8Esa9Ei.openConnection();
		LkjHHpFw.setDoOutput(true);
		PrintWriter oYmr6HIp = new PrintWriter(LkjHHpFw.getOutputStream());
		oYmr6HIp.print("detailed=on");
		oYmr6HIp.print("&");
		oYmr6HIp.print("xmlOnly=on");
		oYmr6HIp.print("&");
		oYmr6HIp.print("colName=" + pTX0K32N);
		oYmr6HIp.print("&");
		oYmr6HIp.print("xpathString=" + H7PJ65zg);
		oYmr6HIp.print("&");
		oYmr6HIp.println("query=Query");
		oYmr6HIp.close();
		InputStream S2kbFWtq = LkjHHpFw.getInputStream();
		BufferedReader N8uzUJkV = new BufferedReader(new InputStreamReader(S2kbFWtq));
		N8uzUJkV.mark(1000000);
		N8uzUJkV.readLine();
		String bO5m8kX8 = N8uzUJkV.readLine();
		logger.debug("The comment is: " + bO5m8kX8);
		Pattern L1vAJFh6 = Pattern.compile("<!-- There are (\\d{1,6}) results! -->");
		Matcher DC94ubsa = L1vAJFh6.matcher(bO5m8kX8);
		if (DC94ubsa.find()) {
			resultNum = DC94ubsa.group(1);
		} else {
			resultNum = "0";
		}
		logger.debug("The number of result is " + resultNum);
		N8uzUJkV.reset();
		CMLReader AktDqf6j = new CMLReader(S2kbFWtq);
		ChemFile ozZzRtD6 = (ChemFile) AktDqf6j.read((ChemObject) new ChemFile());
		logger.debug("#sequences: " + ozZzRtD6.getChemSequenceCount());
		IMolecule MUZ1d7zl = null;
		if (ozZzRtD6.getChemSequenceCount() > 0) {
			org.openscience.cdk.interfaces.IChemSequence tuFF3Dzi = ozZzRtD6.getChemSequence(0);
			logger.debug("#models in sequence: " + tuFF3Dzi.getChemModelCount());
			if (tuFF3Dzi.getChemModelCount() > 0) {
				org.openscience.cdk.interfaces.IChemModel BRjjYNCF = tuFF3Dzi.getChemModel(0);
				org.openscience.cdk.interfaces.IMoleculeSet Id0IwZtK = BRjjYNCF.getMoleculeSet();
				logger.debug("#mols in model: " + Id0IwZtK.getMoleculeCount());
				if (Id0IwZtK.getMoleculeCount() > 0) {
					MUZ1d7zl = Id0IwZtK.getMolecule(0);
				} else {
					logger.warn("No molecules in the model");
				}
			} else {
				logger.warn("No models in the sequence");
			}
		} else {
			logger.warn("No sequences in the file");
		}
		N8uzUJkV.close();
		return MUZ1d7zl;
	}

}