class n18477921 {
	public void callUpdate() {
		LOGGER.debug("Checking for Updates");
		new Thread() {

			@Override
			public void run() {
				String bO65WVhJ = null;
				try {
					URL Ki67vHuS = new URL("http://code.google.com/p/g15lastfm/");
					URLConnection HTCqes15 = Ki67vHuS.openConnection();
					BufferedReader pYntEAFr = new BufferedReader(new InputStreamReader(HTCqes15.getInputStream()));
					String IJO98f1B;
					while ((IJO98f1B = pYntEAFr.readLine()) != null) {
						if (IJO98f1B.contains("<strong>Current version:")) {
							bO65WVhJ = IJO98f1B;
							break;
						}
					}
					pYntEAFr.close();
					if (bO65WVhJ != null && bO65WVhJ.length() > 0) {
						bO65WVhJ = bO65WVhJ.substring(bO65WVhJ.indexOf("Current version:") + 16);
						bO65WVhJ = bO65WVhJ.substring(0, bO65WVhJ.indexOf("</strong>")).trim();
						LOGGER.debug("last Version=" + bO65WVhJ);
					}
					if (!bO65WVhJ.equals(G15LastfmPlayer.getVersion()))
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
									Desktop sLQvLXxn = Desktop.getDesktop();
									try {
										sLQvLXxn.browse(new URI("http://code.google.com/p/g15lastfm/"));
									} catch (IOException EsAQLIJP) {
										LOGGER.debug(EsAQLIJP);
									} catch (URISyntaxException PY7J8wd9) {
										LOGGER.debug(PY7J8wd9);
									}
								} else {
									LOGGER.debug("User choose to not update.");
								}
							}
						});
					}
				} catch (Exception nynOEJ2F) {
					LOGGER.debug(nynOEJ2F);
				}
			}
		}.start();
	}

}