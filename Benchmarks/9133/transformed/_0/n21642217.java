class n21642217 {
	private String searchMetabolite(String ZMs0Tomd) {
		{
			BufferedReader Anl7P4wI = null;
			try {
				String sqVMwQKf = ZMs0Tomd;
				URL faFDIWzn = new URL(sqVMwQKf);
				Anl7P4wI = new BufferedReader(new InputStreamReader(faFDIWzn.openStream()));
				String TwTSKUlv;
				Boolean hCO2ZOcs = false;
				while ((TwTSKUlv = Anl7P4wI.readLine()) != null) {
					if (TwTSKUlv.contains("Metabolite</h1>")) {
						hCO2ZOcs = true;
					}
					if (TwTSKUlv.contains("<td><a href=\"/Metabolites/") && hCO2ZOcs) {
						String ahYlOsww = TwTSKUlv.substring(TwTSKUlv.indexOf("/Metabolites/") + 13,
								TwTSKUlv.indexOf("aspx\" target") + 4);
						return "http://gmd.mpimp-golm.mpg.de/Metabolites/" + ahYlOsww;
					}
				}
				Anl7P4wI.close();
				return ZMs0Tomd;
			} catch (IOException rj8RJR0N) {
				Logger.getLogger(GetGolmIDsTask.class.getName()).log(Level.SEVERE, null, rj8RJR0N);
				return null;
			}
		}
	}

}