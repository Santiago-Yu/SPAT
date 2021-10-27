class n497400 {
	public TVRageShowInfo(String qpNfTqvk) {
        String[] Nz7Sr6Gr, a8YY2BHK;
        String ZxMzB7Qt = "";
        this.usrShowName = qpNfTqvk;
        try {
            URL Ow0vv3bz = new URL("http://www.tvrage.com/quickinfo.php?show=" + qpNfTqvk.replaceAll(" ", "%20"));
            BufferedReader qhNfZBiE = new BufferedReader(new InputStreamReader(Ow0vv3bz.openStream()));
            while ((ZxMzB7Qt = qhNfZBiE.readLine()) != null) {
                Nz7Sr6Gr = ZxMzB7Qt.split("@");
                if (Nz7Sr6Gr[0].equals("Show Name")) showName = Nz7Sr6Gr[1];
                if (Nz7Sr6Gr[0].equals("Show URL")) showURL = Nz7Sr6Gr[1];
                if (Nz7Sr6Gr[0].equals("Latest Episode")) {
                    StringTokenizer HIxDQvbv = new StringTokenizer(Nz7Sr6Gr[1], "^");
                    for (int qZS0X32A = 0; HIxDQvbv.hasMoreTokens(); qZS0X32A++) {
                        if (qZS0X32A == 0) {
                            a8YY2BHK = HIxDQvbv.nextToken().split("x");
                            latestSeasonNum = a8YY2BHK[0];
                            latestEpisodeNum = a8YY2BHK[1];
                            if (latestSeasonNum.charAt(0) == '0') latestSeasonNum = latestSeasonNum.substring(1);
                        } else if (qZS0X32A == 1) latestTitle = HIxDQvbv.nextToken().replaceAll("&", "and"); else latestAirDate = HIxDQvbv.nextToken();
                    }
                }
                if (Nz7Sr6Gr[0].equals("Next Episode")) {
                    StringTokenizer P7NGMRsn = new StringTokenizer(Nz7Sr6Gr[1], "^");
                    for (int K1aqvxIb = 0; P7NGMRsn.hasMoreTokens(); K1aqvxIb++) {
                        if (K1aqvxIb == 0) {
                            a8YY2BHK = P7NGMRsn.nextToken().split("x");
                            nextSeasonNum = a8YY2BHK[0];
                            nextEpisodeNum = a8YY2BHK[1];
                            if (nextSeasonNum.charAt(0) == '0') nextSeasonNum = nextSeasonNum.substring(1);
                        } else if (K1aqvxIb == 1) nextTitle = P7NGMRsn.nextToken().replaceAll("&", "and"); else nextAirDate = P7NGMRsn.nextToken();
                    }
                }
                if (Nz7Sr6Gr[0].equals("Status")) status = Nz7Sr6Gr[1];
                if (Nz7Sr6Gr[0].equals("Airtime")) airTime = Nz7Sr6Gr[1];
            }
            if (airTime.length() != 0) {
                Nz7Sr6Gr = airTime.split(",");
                airTimeHour = Nz7Sr6Gr[1];
            }
            qhNfZBiE.close();
            Ow0vv3bz = new URL(showURL);
            qhNfZBiE = new BufferedReader(new InputStreamReader(Ow0vv3bz.openStream()));
            while ((ZxMzB7Qt = qhNfZBiE.readLine()) != null) {
                if (ZxMzB7Qt.indexOf("<b>Latest Episode: </b>") > -1) {
                    Nz7Sr6Gr = ZxMzB7Qt.split("'>");
                    if (Nz7Sr6Gr[2].indexOf(':') > -1) {
                        Nz7Sr6Gr = Nz7Sr6Gr[2].split(":");
                        latestSeriesNum = Nz7Sr6Gr[0];
                    }
                } else if (ZxMzB7Qt.indexOf("<b>Next Episode: </b>") > -1) {
                    Nz7Sr6Gr = ZxMzB7Qt.split("'>");
                    if (Nz7Sr6Gr[2].indexOf(':') > -1) {
                        Nz7Sr6Gr = Nz7Sr6Gr[2].split(":");
                        nextSeriesNum = Nz7Sr6Gr[0];
                    }
                }
            }
            qhNfZBiE.close();
        } catch (MalformedURLException yf6JEhUt) {
        } catch (IOException O3tO8vsQ) {
        }
    }

}