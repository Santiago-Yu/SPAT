class n98428 {
	public static XMLShowInfo NzbSearch(TVRageShowInfo zfBWCIJ1, XMLShowInfo zTzfBQWr, int Iym0Txyv) {
		String ke8pjF9A = "", LmYi0jCH = "", FV6nxsXW = "", DYLscfjJ = "", Uxn66Pw0 = "";
		String[] g34VZa34;
		DateFormat mLw0d6Vi = new SimpleDateFormat("MMM/dd/yyyy");
		DateFormat HvMA9d6S = new SimpleDateFormat("yyyy-MM-dd");
		ke8pjF9A = "?q=" + zTzfBQWr.showName + "+";
		if (Iym0Txyv == 0) {
			if (zTzfBQWr.searchBy.equals("ShowName Season x Episode"))
				ke8pjF9A += zfBWCIJ1.latestSeasonNum + "x" + zfBWCIJ1.latestEpisodeNum;
			else if (zTzfBQWr.searchBy.equals("Showname SeriesNum"))
				ke8pjF9A += zfBWCIJ1.latestSeriesNum;
			else if (zTzfBQWr.searchBy.equals("Showname YYYY-MM-DD")) {
				try {
					Date mkuHHfn7 = mLw0d6Vi.parse(zfBWCIJ1.latestAirDate);
					ke8pjF9A += HvMA9d6S.format(mkuHHfn7);
				} catch (ParseException PGWNIZ4t) {
					PGWNIZ4t.printStackTrace();
				}
			} else if (zTzfBQWr.searchBy.equals("Showname EpisodeTitle"))
				ke8pjF9A += zfBWCIJ1.latestTitle;
		} else {
			if (zTzfBQWr.searchBy.equals("ShowName Season x Episode"))
				ke8pjF9A += zfBWCIJ1.nextSeasonNum + "x" + zfBWCIJ1.nextEpisodeNum;
			else if (zTzfBQWr.searchBy.equals("Showname SeriesNum"))
				ke8pjF9A += zfBWCIJ1.nextSeriesNum;
			else if (zTzfBQWr.searchBy.equals("Showname YYYY-MM-DD")) {
				try {
					Date lCZXSUD7 = mLw0d6Vi.parse(zfBWCIJ1.nextAirDate);
					ke8pjF9A += HvMA9d6S.format(lCZXSUD7);
				} catch (ParseException B276nI9m) {
					B276nI9m.printStackTrace();
				}
			} else if (zTzfBQWr.searchBy.equals("Showname EpisodeTitle"))
				ke8pjF9A += zfBWCIJ1.nextTitle;
		}
		ke8pjF9A += "&searchaction=Search";
		ke8pjF9A += "&fpn=p";
		ke8pjF9A += "&category=8category=11";
		ke8pjF9A += "&area=-1";
		ke8pjF9A += "&u_nfo_posts_only=0";
		ke8pjF9A += "&u_url_posts_only=0";
		ke8pjF9A += "&u_comment_posts_only=0";
		ke8pjF9A += "&u_v3_retention=1209600";
		ke8pjF9A += "&ps_rb_language=" + zTzfBQWr.language;
		ke8pjF9A += "&sort=ps_edit_date";
		ke8pjF9A += "&order=desc";
		ke8pjF9A += "&areadone=-1";
		ke8pjF9A += "&feed=csv";
		ke8pjF9A += "&ps_rb_video_format=" + zTzfBQWr.format;
		ke8pjF9A = ke8pjF9A.replaceAll(" ", "%20");
		System.out.println("http://v3.newzbin.com/search/" + ke8pjF9A);
		try {
			URL n3JcF8Ym = new URL("http://v3.newzbin.com/search/" + ke8pjF9A);
			BufferedReader THQtVPGF = new BufferedReader(new InputStreamReader(n3JcF8Ym.openStream()));
			LmYi0jCH = THQtVPGF.readLine();
			if (LmYi0jCH != null) {
				JavaNZB.searchCount++;
				if (searchCount == 6) {
					searchCount = 0;
					System.out.println("Sleeping for 60 seconds");
					try {
						Thread.sleep(60000);
					} catch (InterruptedException GujCkpuW) {
						GujCkpuW.printStackTrace();
					}
				}
				g34VZa34 = LmYi0jCH.split(",");
				g34VZa34[2] = g34VZa34[2].substring(1, g34VZa34[2].length() - 1);
				g34VZa34[3] = g34VZa34[3].substring(1, g34VZa34[3].length() - 1);
				Pattern dnrJMQk3 = Pattern.compile("[\\\\</:>?\\[|\\]\"]");
				Matcher s43eH2wq = dnrJMQk3.matcher(g34VZa34[3]);
				g34VZa34[3] = s43eH2wq.replaceAll(" ");
				g34VZa34[3] = g34VZa34[3].replaceAll("&", "and");
				URLConnection AyVFEtd9;
				DataOutputStream HpIwe3Eu;
				n3JcF8Ym = new URL("http://v3.newzbin.com/api/dnzb/");
				AyVFEtd9 = n3JcF8Ym.openConnection();
				AyVFEtd9.setDoInput(true);
				AyVFEtd9.setDoOutput(true);
				AyVFEtd9.setUseCaches(false);
				AyVFEtd9.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				HpIwe3Eu = new DataOutputStream(AyVFEtd9.getOutputStream());
				String r7AX069H = "username=" + JavaNZB.newzbinUsr + "&password=" + JavaNZB.newzbinPass + "&reportid="
						+ g34VZa34[2];
				HpIwe3Eu.writeBytes(r7AX069H);
				HpIwe3Eu.flush();
				HpIwe3Eu.close();
				BufferedReader tSdNGuH6 = new BufferedReader(new InputStreamReader(AyVFEtd9.getInputStream()));
				String nyWtSfpA = "";
				if (zTzfBQWr.format.equals("17"))
					nyWtSfpA = " Xvid";
				if (zTzfBQWr.format.equals("131072"))
					nyWtSfpA = " x264";
				if (zTzfBQWr.format.equals("2"))
					nyWtSfpA = " DVD";
				if (zTzfBQWr.format.equals("4"))
					nyWtSfpA = " SVCD";
				if (zTzfBQWr.format.equals("8"))
					nyWtSfpA = " VCD";
				if (zTzfBQWr.format.equals("32"))
					nyWtSfpA = " HDts";
				if (zTzfBQWr.format.equals("64"))
					nyWtSfpA = " WMV";
				if (zTzfBQWr.format.equals("128"))
					nyWtSfpA = " Other";
				if (zTzfBQWr.format.equals("256"))
					nyWtSfpA = " ratDVD";
				if (zTzfBQWr.format.equals("512"))
					nyWtSfpA = " iPod";
				if (zTzfBQWr.format.equals("1024"))
					nyWtSfpA = " PSP";
				File wm4QNkZQ = new File(JavaNZB.hellaQueueDir, g34VZa34[3] + nyWtSfpA + ".nzb");
				BufferedWriter CT0T5pWT = new BufferedWriter(new FileWriter(wm4QNkZQ));
				String gQFr3u4y;
				System.out.println("--Downloading " + g34VZa34[3] + nyWtSfpA + ".nzb" + " to queue directory--");
				while (null != ((gQFr3u4y = tSdNGuH6.readLine())))
					CT0T5pWT.write(gQFr3u4y);
				tSdNGuH6.close();
				CT0T5pWT.close();
				if (Iym0Txyv == 0) {
					zTzfBQWr.episode = zfBWCIJ1.latestEpisodeNum;
					zTzfBQWr.season = zfBWCIJ1.latestSeasonNum;
				} else {
					zTzfBQWr.episode = zfBWCIJ1.nextEpisodeNum;
					zTzfBQWr.season = zfBWCIJ1.nextSeasonNum;
				}
			} else
				System.out.println("No new episode posted");
			System.out.println();
		} catch (MalformedURLException GlcvOZbW) {
		} catch (IOException Wg4UuBQB) {
			System.out.println("IO Exception from NzbSearch");
		}
		return zTzfBQWr;
	}

}