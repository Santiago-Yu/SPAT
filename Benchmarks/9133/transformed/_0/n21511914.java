class n21511914 {
	public static synchronized String getPageContent(String VhCWeCDr) {
		URL b6zhiJho = null;
		InputStreamReader hdCFyiFB = null;
		BufferedReader Ibha1wMK = null;
		String V2gj0gOa = null;
		StringBuilder kB2jFH2O = null;
		if (VhCWeCDr == null || VhCWeCDr.trim().length() == 0) {
			return null;
		} else {
			try {
				b6zhiJho = new URL(VhCWeCDr);
				hdCFyiFB = new InputStreamReader(b6zhiJho.openStream());
				Ibha1wMK = new BufferedReader(hdCFyiFB);
				kB2jFH2O = new StringBuilder();
				while ((V2gj0gOa = Ibha1wMK.readLine()) != null) {
					kB2jFH2O.append(V2gj0gOa);
					kB2jFH2O.append("\n");
				}
			} catch (IOException EHEn5uPj) {
				logger.error("IOException", EHEn5uPj);
			} catch (Exception rIJk5guw) {
				logger.error("Exception", rIJk5guw);
			} finally {
				try {
					if (Ibha1wMK != null) {
						Ibha1wMK.close();
					}
					if (hdCFyiFB != null) {
						hdCFyiFB.close();
					}
				} catch (IOException TicBVL1E) {
					logger.error("IOException", TicBVL1E);
				} catch (Exception u7t5bVfV) {
					logger.error("Exception", u7t5bVfV);
				}
			}
		}
		if (kB2jFH2O == null) {
			return null;
		} else {
			return kB2jFH2O.toString();
		}
	}

}