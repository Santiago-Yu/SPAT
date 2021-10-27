class n474165 {
	public TVRageShowInfo(String brepIWMg) {
        String[] FX2dBZG6, M8BdfH0K;
        String Mi45xVdt = "";
        this.usrShowName = brepIWMg;
        try {
            URL peyIwzeC = new URL("http://www.tvrage.com/quickinfo.php?show=" + brepIWMg.replaceAll(" ", "%20"));
            BufferedReader Z041N9rV = new BufferedReader(new InputStreamReader(peyIwzeC.openStream()));
            while ((Mi45xVdt = Z041N9rV.readLine()) != null) {
                FX2dBZG6 = Mi45xVdt.split("@");
                if (FX2dBZG6[0].equals("Show Name")) showName = FX2dBZG6[1];
                if (FX2dBZG6[0].equals("Show URL")) showURL = FX2dBZG6[1];
                if (FX2dBZG6[0].equals("Latest Episode")) {
                    StringTokenizer vSxgu0qc = new StringTokenizer(FX2dBZG6[1], "^");
                    for (int ykwjRbVJ = 0; vSxgu0qc.hasMoreTokens(); ykwjRbVJ++) {
                        if (ykwjRbVJ == 0) {
                            M8BdfH0K = vSxgu0qc.nextToken().split("x");
                            latestSeasonNum = M8BdfH0K[0];
                            latestEpisodeNum = M8BdfH0K[1];
                            if (latestSeasonNum.charAt(0) == '0') latestSeasonNum = latestSeasonNum.substring(1);
                        } else if (ykwjRbVJ == 1) latestTitle = vSxgu0qc.nextToken().replaceAll("&", "and"); else latestAirDate = vSxgu0qc.nextToken();
                    }
                }
                if (FX2dBZG6[0].equals("Next Episode")) {
                    StringTokenizer BzUhOLWj = new StringTokenizer(FX2dBZG6[1], "^");
                    for (int n8NcHyyc = 0; BzUhOLWj.hasMoreTokens(); n8NcHyyc++) {
                        if (n8NcHyyc == 0) {
                            M8BdfH0K = BzUhOLWj.nextToken().split("x");
                            nextSeasonNum = M8BdfH0K[0];
                            nextEpisodeNum = M8BdfH0K[1];
                            if (nextSeasonNum.charAt(0) == '0') nextSeasonNum = nextSeasonNum.substring(1);
                        } else if (n8NcHyyc == 1) nextTitle = BzUhOLWj.nextToken().replaceAll("&", "and"); else nextAirDate = BzUhOLWj.nextToken();
                    }
                }
                if (FX2dBZG6[0].equals("Status")) status = FX2dBZG6[1];
                if (FX2dBZG6[0].equals("Airtime")) airTime = FX2dBZG6[1];
            }
            Z041N9rV.close();
            peyIwzeC = new URL(showURL);
            Z041N9rV = new BufferedReader(new InputStreamReader(peyIwzeC.openStream()));
            while ((Mi45xVdt = Z041N9rV.readLine()) != null) {
                if (Mi45xVdt.indexOf("<b>Latest Episode: </b>") > -1) {
                    FX2dBZG6 = Mi45xVdt.split("'>");
                    if (FX2dBZG6[2].indexOf(':') > -1) {
                        FX2dBZG6 = FX2dBZG6[2].split(":");
                        latestSeriesNum = FX2dBZG6[0];
                    }
                } else if (Mi45xVdt.indexOf("<b>Next Episode: </b>") > -1) {
                    FX2dBZG6 = Mi45xVdt.split("'>");
                    if (FX2dBZG6[2].indexOf(':') > -1) {
                        FX2dBZG6 = FX2dBZG6[2].split(":");
                        nextSeriesNum = FX2dBZG6[0];
                    }
                }
            }
            Z041N9rV.close();
        } catch (MalformedURLException UuYh67v0) {
        } catch (IOException Wz67YOGc) {
        }
    }

}