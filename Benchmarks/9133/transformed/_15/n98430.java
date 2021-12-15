class n98430 {
	public TVRageShowInfo(String xmlShowName, String xmlSearchBy) {
        String[] tmp, tmp2;
        String line = "";
        this.usrShowName = xmlShowName;
        try {
            URL url = new URL("http://www.tvrage.com/quickinfo.php?show=" + xmlShowName.replaceAll(" ", "%20"));
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            while ((line = in.readLine()) != null) {
                tmp = line.split("@");
                if ("Show Name".equals(tmp[0])) showName = tmp[1];
                if ("Show URL".equals(tmp[0])) showURL = tmp[1];
                if ("Latest Episode".equals(tmp[0])) {
                    StringTokenizer st = new StringTokenizer(tmp[1], "^");
                    for (int i = 0; st.hasMoreTokens(); i++) {
                        if (i == 0) {
                            tmp2 = st.nextToken().split("x");
                            latestSeasonNum = tmp2[0];
                            latestEpisodeNum = tmp2[1];
                            if (latestSeasonNum.charAt(0) == '0') latestSeasonNum = latestSeasonNum.substring(1);
                        } else if (i == 1) latestTitle = st.nextToken().replaceAll("&", "and"); else latestAirDate = st.nextToken();
                    }
                }
                if ("Next Episode".equals(tmp[0])) {
                    StringTokenizer st = new StringTokenizer(tmp[1], "^");
                    for (int i = 0; st.hasMoreTokens(); i++) {
                        if (i == 0) {
                            tmp2 = st.nextToken().split("x");
                            nextSeasonNum = tmp2[0];
                            nextEpisodeNum = tmp2[1];
                            if (nextSeasonNum.charAt(0) == '0') nextSeasonNum = nextSeasonNum.substring(1);
                        } else if (i == 1) nextTitle = st.nextToken().replaceAll("&", "and"); else nextAirDate = st.nextToken();
                    }
                }
                if ("Status".equals(tmp[0])) status = tmp[1];
                if ("Airtime".equals(tmp[0]) && tmp.length > 1) {
                    airTime = tmp[1];
                }
            }
            if (airTime.length() > 10) {
                tmp = airTime.split("at");
                airTimeHour = tmp[1];
            }
            in.close();
            if ("Showname SeriesNum".equals(xmlSearchBy)) {
                url = new URL(showURL);
                in = new BufferedReader(new InputStreamReader(url.openStream()));
                while ((line = in.readLine()) != null) {
                    if (line.indexOf("<b>Latest Episode: </b>") > -1) {
                        tmp = line.split("'>");
                        if (tmp[5].indexOf(':') > -1) {
                            tmp = tmp[5].split(":");
                            latestSeriesNum = tmp[0];
                        }
                    } else if (line.indexOf("<b>Next Episode: </b>") > -1) {
                        tmp = line.split("'>");
                        if (tmp[3].indexOf(':') > -1) {
                            tmp = tmp[3].split(":");
                            nextSeriesNum = tmp[0];
                        }
                    }
                }
                in.close();
            }
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
    }

}