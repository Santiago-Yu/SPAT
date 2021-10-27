class n22131351 {
	private IMolecule readMolecule() throws Exception {
		String xpath = "";
		if (index.equals("ichi")) {
			xpath = URLEncoder.encode("//molecule[./identifier/basic='" + query + "']", UTF8);
		} else if (index.equals("kegg")) {
			xpath = URLEncoder.encode("//molecule[./@name='" + query + "' and ./@dictRef='KEGG']", UTF8);
		} else if (index.equals("nist")) {
			xpath = URLEncoder.encode("//molecule[../@id='" + query + "']", UTF8);
		} else {
			logger.error("Did not recognize index type: " + index);
			return null;
		}
		String colname = URLEncoder.encode("/" + this.collection, UTF8);
		logger.info("Doing query: " + xpath + " in collection " + colname);
		URL url = new URL("http://" + server + "/Bob/QueryXindice");
		logger.info("Connection to server: " + url.toString());
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		out.print("detailed=on");
		out.print("&");
		out.print("xmlOnly=on");
		out.print("&");
		out.print("colName=" + colname);
		out.print("&");
		out.print("xpathString=" + xpath);
		out.print("&");
		out.println("query=Query");
		out.close();
		InputStream stream = connection.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		in.mark(1000000);
		in.readLine();
		String comment = in.readLine();
		logger.debug("The comment is: " + comment);
		Pattern p = Pattern.compile("<!-- There are (\\d{1,6}) results! -->");
		Matcher match = p.matcher(comment);
		resultNum = (match.find()) ? match.group(1) : "0";
		logger.debug("The number of result is " + resultNum);
		in.reset();
		CMLReader reader = new CMLReader(stream);
		ChemFile cf = (ChemFile) reader.read((ChemObject) new ChemFile());
		logger.debug("#sequences: " + cf.getChemSequenceCount());
		IMolecule m = null;
		if (cf.getChemSequenceCount() > 0) {
			org.openscience.cdk.interfaces.IChemSequence chemSequence = cf.getChemSequence(0);
			logger.debug("#models in sequence: " + chemSequence.getChemModelCount());
			if (chemSequence.getChemModelCount() > 0) {
				org.openscience.cdk.interfaces.IChemModel chemModel = chemSequence.getChemModel(0);
				org.openscience.cdk.interfaces.IMoleculeSet setOfMolecules = chemModel.getMoleculeSet();
				logger.debug("#mols in model: " + setOfMolecules.getMoleculeCount());
				if (setOfMolecules.getMoleculeCount() > 0) {
					m = setOfMolecules.getMolecule(0);
				} else {
					logger.warn("No molecules in the model");
				}
			} else {
				logger.warn("No models in the sequence");
			}
		} else {
			logger.warn("No sequences in the file");
		}
		in.close();
		return m;
	}

}