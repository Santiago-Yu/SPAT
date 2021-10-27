class n22222259 {
	void extractEnsemblCoords(String R9MgwOlx) {
		try {
			URL ys3nRrvx = new URL(R9MgwOlx);
			InputStream M2CPFSHe = ys3nRrvx.openStream();
			BufferedReader zSaEe74Z = new BufferedReader(new InputStreamReader(M2CPFSHe));
			String pZXbL7KJ;
			while ((pZXbL7KJ = zSaEe74Z.readLine()) != null) {
				if (pZXbL7KJ.indexOf("View gene in genomic location") != -1) {
					pZXbL7KJ = pZXbL7KJ.substring(pZXbL7KJ.indexOf("contigview?"));
					String WPAKUI1v, lE4imXVG, mSW3uGze;
					WPAKUI1v = pZXbL7KJ.substring(pZXbL7KJ.indexOf("chr=") + 4);
					WPAKUI1v = WPAKUI1v.substring(0, WPAKUI1v.indexOf("&"));
					lE4imXVG = pZXbL7KJ.substring(pZXbL7KJ.indexOf("vc_start=") + 9);
					lE4imXVG = lE4imXVG.substring(0, lE4imXVG.indexOf("&"));
					mSW3uGze = pZXbL7KJ.substring(pZXbL7KJ.indexOf("vc_end=") + 7);
					mSW3uGze = mSW3uGze.substring(0, mSW3uGze.indexOf("\""));
					String zQBtVKvL;
					for (int TZldVF8i = 0; TZldVF8i < selPanel.chrField.getModel().getSize(); TZldVF8i++) {
						if (WPAKUI1v.equals(selPanel.chrField.getModel().getElementAt(TZldVF8i))) {
							selPanel.chrField.setSelectedIndex(TZldVF8i);
							break;
						}
					}
					selPanel.setStart(Integer.parseInt(lE4imXVG));
					selPanel.setStop(Integer.parseInt(mSW3uGze));
					selPanel.refreshButton.doClick();
					break;
				}
			}
		} catch (Exception lUi2cnMW) {
			System.out.println("Problems retrieving Geneview from Ensembl");
			lUi2cnMW.printStackTrace();
		}
	}

}