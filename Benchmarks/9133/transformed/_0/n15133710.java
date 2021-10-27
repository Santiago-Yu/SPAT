class n15133710 {
	private Image retrievePdsImage(double S7DrB0e1, double lmCS5D5h) {
		imageDone = false;
		try {
			StringBuffer GTsGG3S9 = new StringBuffer(psdUrl + psdCgi + "?");
			GTsGG3S9.append("DATA_SET_NAME=" + dataSet);
			GTsGG3S9.append("&VERSION=" + version);
			GTsGG3S9.append("&PIXEL_TYPE=" + pixelType);
			GTsGG3S9.append("&PROJECTION=" + projection);
			GTsGG3S9.append("&STRETCH=" + stretch);
			GTsGG3S9.append("&GRIDLINE_FREQUENCY=" + gridlineFrequency);
			GTsGG3S9.append("&SCALE=" + URLEncoder.encode(scale));
			GTsGG3S9.append("&RESOLUTION=" + resolution);
			GTsGG3S9.append("&LATBOX=" + latbox);
			GTsGG3S9.append("&LONBOX=" + lonbox);
			GTsGG3S9.append("&BANDS_SELECTED=" + bandsSelected);
			GTsGG3S9.append("&LAT=" + S7DrB0e1);
			GTsGG3S9.append("&LON=" + lmCS5D5h);
			URL pXmE9XyU = new URL(GTsGG3S9.toString());
			BufferedReader sILO3YPp = new BufferedReader(new InputStreamReader(pXmE9XyU.openStream()));
			String PcDFiYMu = null;
			String Su5EhSIF;
			String tfiz227g;
			int kHjosMtV = 0;
			while ((Su5EhSIF = sILO3YPp.readLine()) != null) {
				if (kHjosMtV == 6)
					PcDFiYMu = Su5EhSIF;
				kHjosMtV++;
			}
			int ajE0Nqjp = PcDFiYMu.indexOf("<TH COLSPAN=2 ROWSPAN=2><IMG SRC = \"") + 36;
			int gmSWMpu2 = PcDFiYMu.indexOf("\"", ajE0Nqjp);
			tfiz227g = PcDFiYMu.substring(ajE0Nqjp, gmSWMpu2);
			URL PPRYstzb = new URL(tfiz227g);
			return (Toolkit.getDefaultToolkit().getImage(PPRYstzb));
		} catch (MalformedURLException WuwwWW4j) {
		} catch (IOException xaL1knfy) {
		}
		return null;
	}

}