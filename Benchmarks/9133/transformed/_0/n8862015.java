class n8862015 {
	@Override
	protected void loadInternals(final File nvRbI3LN, final ExecutionMonitor XQaIRrJb)
			throws IOException, CanceledExecutionException {
		List<String> LZMHYn7j = new Vector<String>();
		String jehp4Ql5 = m_domain.getStringValue();
		String hVCHjgNa = "";
		if (jehp4Ql5.equalsIgnoreCase("Eukaryota"))
			hVCHjgNa = "eukaryota";
		try {
			URL UelHadoP = new URL("http://www.ebi.ac.uk/genomes/" + hVCHjgNa + ".details.txt");
			BufferedReader aOwfofRM = new BufferedReader(new InputStreamReader(UelHadoP.openStream()));
			String t04biF0u = "";
			String nSxVOeYy = "";
			String txNtwGGR = "";
			int YxVIPPoR = 0;
			String RnVjnpEG = "";
			while ((RnVjnpEG = aOwfofRM.readLine()) != null) {
				String[] XFa9Dose = RnVjnpEG.split("\t");
				ena_details D0xyvfg8 = new ena_details(XFa9Dose[0], XFa9Dose[1], XFa9Dose[2], XFa9Dose[3], XFa9Dose[4]);
				ENADataHolder.instance().put(D0xyvfg8.desc, D0xyvfg8);
				LZMHYn7j.add(D0xyvfg8.desc);
			}
			aOwfofRM.close();
		} catch (MalformedURLException Dq21620D) {
			Dq21620D.printStackTrace();
		} catch (IOException D85sbakK) {
			D85sbakK.printStackTrace();
		}
	}

}