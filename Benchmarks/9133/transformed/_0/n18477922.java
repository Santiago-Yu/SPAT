class n18477922 {
	@Override
	public void run() {
		String XwaBjVVB = null;
		try {
			URL wyldLAF5 = new URL("http://code.google.com/p/g15lastfm/");
			URLConnection CdYkQoPE = wyldLAF5.openConnection();
			BufferedReader Z3vMFFdV = new BufferedReader(new InputStreamReader(CdYkQoPE.getInputStream()));
			String atuFabtF;
			while ((atuFabtF = Z3vMFFdV.readLine()) != null) {
				if (atuFabtF.contains("<strong>Current version:")) {
					XwaBjVVB = atuFabtF;
					break;
				}
			}
			Z3vMFFdV.close();
			if (XwaBjVVB != null && XwaBjVVB.length() > 0) {
				XwaBjVVB = XwaBjVVB.substring(XwaBjVVB.indexOf("Current version:") + 16);
				XwaBjVVB = XwaBjVVB.substring(0, XwaBjVVB.indexOf("</strong>")).trim();
				LOGGER.debug("last Version=" + XwaBjVVB);
			}
			if (!XwaBjVVB.equals(G15LastfmPlayer.getVersion()))
				LOGGER.debug("Not necessary to update");
			else {
				LOGGER.debug("New update found!");
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						if (JOptionPane.showConfirmDialog(null, "New version of G15Lastfm is available to download!",
								"New Update for G15Lastfm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							LOGGER.debug("User choose to update, opening browser.");
							Desktop wavImvAz = Desktop.getDesktop();
							try {
								wavImvAz.browse(new URI("http://code.google.com/p/g15lastfm/"));
							} catch (IOException AtixCT4u) {
								LOGGER.debug(AtixCT4u);
							} catch (URISyntaxException MwPTVMnL) {
								LOGGER.debug(MwPTVMnL);
							}
						} else {
							LOGGER.debug("User choose to not update.");
						}
					}
				});
			}
		} catch (Exception XNLJ8oXE) {
			LOGGER.debug(XNLJ8oXE);
		}
	}

}