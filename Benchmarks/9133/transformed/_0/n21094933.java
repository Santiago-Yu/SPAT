class n21094933 {
	private static void checkForUpdates() {
		LOGGER.debug("Checking for Updates");
		new Thread() {

			@Override
			public void run() {
				String V2ok5Ufy = null;
				try {
					URL z4GCnAlg = new URL("http://code.google.com/p/g15lastfm/");
					URLConnection wI2koZVj = z4GCnAlg.openConnection();
					BufferedReader Hc1zcQMM = new BufferedReader(new InputStreamReader(wI2koZVj.getInputStream()));
					String fI10tFdm;
					while ((fI10tFdm = Hc1zcQMM.readLine()) != null) {
						if (fI10tFdm.contains("<strong>Current version:")) {
							V2ok5Ufy = fI10tFdm;
							break;
						}
					}
					Hc1zcQMM.close();
					if (V2ok5Ufy != null && V2ok5Ufy.length() > 0) {
						V2ok5Ufy = V2ok5Ufy.substring(V2ok5Ufy.indexOf("Current version:") + 16);
						V2ok5Ufy = V2ok5Ufy.substring(0, V2ok5Ufy.indexOf("</strong>")).trim();
						LOGGER.debug("last Version=" + V2ok5Ufy);
					}
					if (V2ok5Ufy.equals(getVersion()))
						LOGGER.debug("Not necessary to update");
					else {
						LOGGER.debug("New update found!");
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								if (JOptionPane.showConfirmDialog(null,
										"New version of G15Lastfm is available to download!",
										"New Update for G15Lastfm",
										JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
									LOGGER.debug("User choose to update, opening browser.");
									Desktop qaDxn0sF = Desktop.getDesktop();
									try {
										qaDxn0sF.browse(new URI("http://code.google.com/p/g15lastfm/"));
									} catch (IOException ngnVBHjA) {
										LOGGER.debug(ngnVBHjA);
									} catch (URISyntaxException KKEIzoG4) {
										LOGGER.debug(KKEIzoG4);
									}
								} else {
									LOGGER.debug("User choose to not update.");
								}
							}
						});
					}
				} catch (Exception IVz3o2fC) {
					LOGGER.debug(IVz3o2fC);
				}
			}
		}.start();
	}

}