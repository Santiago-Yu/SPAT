class n21022202 {
	public void end() throws Exception {
		handle.waitFor();
		Calendar NMMmqhpT = Calendar.getInstance();
		File kwcY1Rdo = new File(runDir, "results");
		if (!kwcY1Rdo.isDirectory())
			throw new Exception("The results directory not found!");
		String M3xvHOfM = null;
		String NHpze6qb = null;
		String[] qaX1BNLZ = kwcY1Rdo.list();
		for (String m2ksSLeF : qaX1BNLZ) {
			if (m2ksSLeF.indexOf("html") >= 0)
				M3xvHOfM = m2ksSLeF;
			else if (m2ksSLeF.indexOf("txt") >= 0)
				NHpze6qb = m2ksSLeF;
		}
		if (M3xvHOfM == null)
			throw new IOException("SPECweb2005 output (html) file not found");
		if (NHpze6qb == null)
			throw new IOException("SPECweb2005 output (txt) file not found");
		File xBuG20C4 = new File(kwcY1Rdo, M3xvHOfM);
		copyFile(xBuG20C4.getAbsolutePath(), runDir + "SPECWeb-result.html", false);
		BufferedReader mlxqi3Sn = new BufferedReader(new FileReader(new File(kwcY1Rdo, NHpze6qb)));
		logger.fine("Text file: " + kwcY1Rdo + NHpze6qb);
		Writer kguibZ7j = new FileWriter(runDir + "summary.xml");
		SummaryParser teAISniE = new SummaryParser(getRunId(), startTime, NMMmqhpT, logger);
		teAISniE.convert(mlxqi3Sn, kguibZ7j);
		kguibZ7j.close();
		mlxqi3Sn.close();
	}

}