class n18477921{
    public void callUpdate() {
        LOGGER.debug("Checking for Updates");
        new Thread() {

            @Override
            public void run() {
                String lastVersion = null;
                try {
                    URL projectSite = new URL("http://code.google.com/p/g15lastfm/");
                    URLConnection urlC = projectSite.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(urlC.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        if (inputLine.contains("<strong>Current version:")) {
                            lastVersion = inputLine;
                            break;
                        }
                    }
                    in.close();
                    if (lastVersion != null && lastVersion.length() > 0) {
                        lastVersion = lastVersion.substring(lastVersion.indexOf("Current version:") + 16);
                        lastVersion = lastVersion.substring(0, lastVersion.indexOf("</strong>")).trim();
                        LOGGER.debug("last Version=" + lastVersion);
                    }
                    if (!lastVersion.equals(G15LastfmPlayer.getVersion())) LOGGER.debug("Not necessary to update"); else {
                        LOGGER.debug("New update found!");
                        SwingUtilities.invokeLater(new Runnable() {

                            @Override
                            public void run() {
                                if (JOptionPane.showConfirmDialog(null, "New version of G15Lastfm is available to download!", "New Update for G15Lastfm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                    LOGGER.debug("User choose to update, opening browser.");
                                    Desktop desktop = Desktop.getDesktop();
                                    try {
                                        desktop.browse(new URI("http://code.google.com/p/g15lastfm/"));
                                    } catch (IOException e) {
                                        LOGGER.debug(e);
                                    } catch (URISyntaxException e) {
                                        LOGGER.debug(e);
                                    }
                                } else {
                                    LOGGER.debug("User choose to not update.");
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    LOGGER.debug(e);
                }
            }
        }.start();
    }

}