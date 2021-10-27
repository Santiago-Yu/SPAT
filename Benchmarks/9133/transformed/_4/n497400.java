class n497400 {
	public TVRageShowInfo(String xmlShowName) {
        String[] tmp, tmp2;
        String line = "";
        this.usrShowName = xmlShowName;
        try {
            URL url = new URL("http://www.tvrage.com/quickinfo.php?show=" + xmlShowName.replaceAll(" ", "%20"));
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = in.readLine()) != null) {
                tmp = line.split("@");
                showName = (tmp[0].equals("Show Name")) ? tmp[1] : showName;
                showURL = (tmp[0].equals("Show URL")) ? tmp[1] : showURL;
                if (tmp[0].equals("Latest Episode")) {
                    StringTokenizer st = new StringTokenizer(tmp[1], "^");
                    for (int i = 0; st.hasMoreTokens(); i++) {
                        if (i == 0) {
                            tmp2 = st.nextToken().split("x");
                            latestSeasonNum = tmp2[0];
                            latestEpisodeNum = tmp2[1];
                            latestSeasonNum = (latestSeasonNum.charAt(0) == '0') ? latestSeasonNum.substring(1)
									: latestSeasonNum;
                        } else
							latestTitle = (i == 1) ? st.nextToken().replaceAll("&", "and") : st.nextToken();
                    }
                }
                if (tmp[0].equals("Next Episode")) {
                    StringTokenizer st = new StringTokenizer(tmp[1], "^");
                    for (int i = 0; st.hasMoreTokens(); i++) {
                        if (i == 0) {
                            tmp2 = st.nextToken().split("x");
                            nextSeasonNum = tmp2[0];
                            nextEpisodeNum = tmp2[1];
                            nextSeasonNum = (nextSeasonNum.charAt(0) == '0') ? nextSeasonNum.substring(1)
									: nextSeasonNum;
                        } else
							nextTitle = (i == 1) ? st.nextToken().replaceAll("&", "and") : st.nextToken();
                    }
                }
                status = (tmp[0].equals("Status")) ? tmp[1] : status;
                airTime = (tmp[0].equals("Airtime")) ? tmp[1] : airTime;
            }
            if (airTime.length() != 0) {
                tmp = airTime.split(",");
                airTimeHour = tmp[1];
            }
            in.close();
            url = new URL(showURL);
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = in.readLine()) != null) {
                if (line.indexOf("<b>Latest Episode: </b>") > -1) {
                    tmp = line.split("'>");
                    if (tmp[2].indexOf(':') > -1) {
                        tmp = tmp[2].split(":");
                        latestSeriesNum = tmp[0];
                    }
                } else if (line.indexOf("<b>Next Episode: </b>") > -1) {
                    tmp = line.split("'>");
                    if (tmp[2].indexOf(':') > -1) {
                        tmp = tmp[2].split(":");
                        nextSeriesNum = tmp[0];
                    }
                }
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
    }

}