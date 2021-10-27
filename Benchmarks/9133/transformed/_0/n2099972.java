class n2099972 {
	public static void copyResource(String RciqKylT) {
		try {
			URL Wdizgi7J = copyURL.class.getResource(RciqKylT);
			InputStream h4wIqhEg = Wdizgi7J.openStream();
			System.out.flush();
			FileOutputStream S0bsxN7s = null;
			S0bsxN7s = new FileOutputStream(System.getProperty("user.home") + "/JavaCPC/" + RciqKylT);
			int nvvsxATv, RJLTNBtm = 0;
			while ((nvvsxATv = h4wIqhEg.read()) != -1) {
				S0bsxN7s.write(nvvsxATv);
				RJLTNBtm++;
			}
			h4wIqhEg.close();
			S0bsxN7s.close();
		} catch (MalformedURLException ZDWeXnli) {
			System.err.println(ZDWeXnli.toString());
		} catch (IOException wxXwMxkn) {
			System.err.println(wxXwMxkn.toString());
		}
	}

}