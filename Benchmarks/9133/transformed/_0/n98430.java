class n98430 {
	public TVRageShowInfo(String ovXkvmYJ, String h66VpiRM) {
        String[] Hs3HspJe, DkqTGKY1;
        String o2r9Hzji = "";
        this.usrShowName = ovXkvmYJ;
        try {
            URL nyzf16sk = new URL("http://www.tvrage.com/quickinfo.php?show=" + ovXkvmYJ.replaceAll(" ", "%20"));
            BufferedReader IIohMitQ = new BufferedReader(new InputStreamReader(nyzf16sk.openStream(), "UTF-8"));
            while ((o2r9Hzji = IIohMitQ.readLine()) != null) {
                Hs3HspJe = o2r9Hzji.split("@");
                if (Hs3HspJe[0].equals("Show Name")) showName = Hs3HspJe[1];
                if (Hs3HspJe[0].equals("Show URL")) showURL = Hs3HspJe[1];
                if (Hs3HspJe[0].equals("Latest Episode")) {
                    StringTokenizer NrsxakKG = new StringTokenizer(Hs3HspJe[1], "^");
                    for (int MImmJS12 = 0; NrsxakKG.hasMoreTokens(); MImmJS12++) {
                        if (MImmJS12 == 0) {
                            DkqTGKY1 = NrsxakKG.nextToken().split("x");
                            latestSeasonNum = DkqTGKY1[0];
                            latestEpisodeNum = DkqTGKY1[1];
                            if (latestSeasonNum.charAt(0) == '0') latestSeasonNum = latestSeasonNum.substring(1);
                        } else if (MImmJS12 == 1) latestTitle = NrsxakKG.nextToken().replaceAll("&", "and"); else latestAirDate = NrsxakKG.nextToken();
                    }
                }
                if (Hs3HspJe[0].equals("Next Episode")) {
                    StringTokenizer r6MwYLZZ = new StringTokenizer(Hs3HspJe[1], "^");
                    for (int E5dplyCu = 0; r6MwYLZZ.hasMoreTokens(); E5dplyCu++) {
                        if (E5dplyCu == 0) {
                            DkqTGKY1 = r6MwYLZZ.nextToken().split("x");
                            nextSeasonNum = DkqTGKY1[0];
                            nextEpisodeNum = DkqTGKY1[1];
                            if (nextSeasonNum.charAt(0) == '0') nextSeasonNum = nextSeasonNum.substring(1);
                        } else if (E5dplyCu == 1) nextTitle = r6MwYLZZ.nextToken().replaceAll("&", "and"); else nextAirDate = r6MwYLZZ.nextToken();
                    }
                }
                if (Hs3HspJe[0].equals("Status")) status = Hs3HspJe[1];
                if (Hs3HspJe[0].equals("Airtime") && Hs3HspJe.length > 1) {
                    airTime = Hs3HspJe[1];
                }
            }
            if (airTime.length() > 10) {
                Hs3HspJe = airTime.split("at");
                airTimeHour = Hs3HspJe[1];
            }
            IIohMitQ.close();
            if (h66VpiRM.equals("Showname SeriesNum")) {
                nyzf16sk = new URL(showURL);
                IIohMitQ = new BufferedReader(new InputStreamReader(nyzf16sk.openStream()));
                while ((o2r9Hzji = IIohMitQ.readLine()) != null) {
                    if (o2r9Hzji.indexOf("<b>Latest Episode: </b>") > -1) {
                        Hs3HspJe = o2r9Hzji.split("'>");
                        if (Hs3HspJe[5].indexOf(':') > -1) {
                            Hs3HspJe = Hs3HspJe[5].split(":");
                            latestSeriesNum = Hs3HspJe[0];
                        }
                    } else if (o2r9Hzji.indexOf("<b>Next Episode: </b>") > -1) {
                        Hs3HspJe = o2r9Hzji.split("'>");
                        if (Hs3HspJe[3].indexOf(':') > -1) {
                            Hs3HspJe = Hs3HspJe[3].split(":");
                            nextSeriesNum = Hs3HspJe[0];
                        }
                    }
                }
                IIohMitQ.close();
            }
        } catch (MalformedURLException nvlfWsNo) {
        } catch (IOException zcEsFAO5) {
        }
    }

}