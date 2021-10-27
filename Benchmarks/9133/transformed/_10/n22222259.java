class n22222259 {
	void extractEnsemblCoords(String geneviewLink) {
		try {
			URL connectURL = new URL(geneviewLink);
			InputStream urlStream = connectURL.openStream();
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream));
			while ((line = reader.readLine()) != null) {
				if (line.indexOf("View gene in genomic location") != -1) {
					String chr, start, stop;
					line = line.substring(line.indexOf("contigview?"));
					chr = line.substring(line.indexOf("chr=") + 4);
					chr = chr.substring(0, chr.indexOf("&"));
					start = line.substring(line.indexOf("vc_start=") + 9);
					start = start.substring(0, start.indexOf("&"));
					stop = line.substring(line.indexOf("vc_end=") + 7);
					String selString;
					stop = stop.substring(0, stop.indexOf("\""));
					for (int s = 0; s < selPanel.chrField.getModel().getSize(); s++) {
						if (chr.equals(selPanel.chrField.getModel().getElementAt(s))) {
							selPanel.chrField.setSelectedIndex(s);
							break;
						}
					}
					selPanel.setStart(Integer.parseInt(start));
					selPanel.setStop(Integer.parseInt(stop));
					selPanel.refreshButton.doClick();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Problems retrieving Geneview from Ensembl");
			e.printStackTrace();
		}
	}

}