class n474163 {
	public static XMLShowInfo NzbSearch(TVRageShowInfo IGu0wjTO, XMLShowInfo B6NC9w4v, int lYNRn75O) {
		String NfKwvXUP = "", ArF6GJhG = "", l8iepfDh = "", YXgqeg7d = "", uAhGF6xl = "";
		String[] x46w6IDl;
		DateFormat ZabiI1fq = new SimpleDateFormat("MMM/dd/yyyy");
		DateFormat HG7g61id = new SimpleDateFormat("yyyy-MM-dd");
		NfKwvXUP = "?q=" + B6NC9w4v.showName + "+";
		if (lYNRn75O == 0) {
			if (B6NC9w4v.searchBy.equals("ShowName Season x Episode"))
				NfKwvXUP += IGu0wjTO.latestSeasonNum + "x" + IGu0wjTO.latestEpisodeNum;
			else if (B6NC9w4v.searchBy.equals("Showname SeriesNum"))
				NfKwvXUP += IGu0wjTO.latestSeriesNum;
			else if (B6NC9w4v.searchBy.equals("Showname YYYY-MM-DD")) {
				try {
					Date z0Ra8rli = ZabiI1fq.parse(IGu0wjTO.latestAirDate);
					NfKwvXUP += HG7g61id.format(z0Ra8rli);
				} catch (ParseException Rm9nVfeh) {
					Rm9nVfeh.printStackTrace();
				}
			} else if (B6NC9w4v.searchBy.equals("Showname EpisodeTitle"))
				NfKwvXUP += IGu0wjTO.latestTitle;
		} else {
			if (B6NC9w4v.searchBy.equals("ShowName Season x Episode"))
				NfKwvXUP += IGu0wjTO.nextSeasonNum + "x" + IGu0wjTO.nextEpisodeNum;
			else if (B6NC9w4v.searchBy.equals("Showname SeriesNum"))
				NfKwvXUP += IGu0wjTO.nextSeriesNum;
			else if (B6NC9w4v.searchBy.equals("Showname YYYY-MM-DD")) {
				try {
					Date CG4Exb8U = ZabiI1fq.parse(IGu0wjTO.nextAirDate);
					NfKwvXUP += HG7g61id.format(CG4Exb8U);
				} catch (ParseException CzobvAVM) {
					CzobvAVM.printStackTrace();
				}
			} else if (B6NC9w4v.searchBy.equals("Showname EpisodeTitle"))
				NfKwvXUP += IGu0wjTO.nextTitle;
		}
		NfKwvXUP += "&searchaction=Search";
		NfKwvXUP += "&fpn=p";
		NfKwvXUP += "&category=8category=11";
		NfKwvXUP += "&area=-1";
		NfKwvXUP += "&u_nfo_posts_only=0";
		NfKwvXUP += "&u_url_posts_only=0";
		NfKwvXUP += "&u_comment_posts_only=0";
		NfKwvXUP += "&u_v3_retention=1209600";
		NfKwvXUP += "&ps_rb_language=" + B6NC9w4v.language;
		NfKwvXUP += "&sort=ps_edit_date";
		NfKwvXUP += "&order=desc";
		NfKwvXUP += "&areadone=-1";
		NfKwvXUP += "&feed=csv";
		NfKwvXUP += "&ps_rb_video_format=" + B6NC9w4v.format;
		NfKwvXUP = NfKwvXUP.replaceAll(" ", "%20");
		System.out.println("http://v3.newzbin.com/search/" + NfKwvXUP);
		try {
			URL HfSYDPsc = new URL("http://v3.newzbin.com/search/" + NfKwvXUP);
			BufferedReader jWimQdQi = new BufferedReader(new InputStreamReader(HfSYDPsc.openStream()));
			ArF6GJhG = jWimQdQi.readLine();
			if (ArF6GJhG != null) {
				JavaNZB.searchCount++;
				if (searchCount == 6) {
					searchCount = 0;
					System.out.println("Sleeping for 60 seconds");
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e9WDiT5K) {
						e9WDiT5K.printStackTrace();
					}
				}
				x46w6IDl = ArF6GJhG.split(",");
				x46w6IDl[2] = x46w6IDl[2].substring(1, x46w6IDl[2].length() - 1);
				x46w6IDl[3] = x46w6IDl[3].substring(1, x46w6IDl[3].length() - 1);
				Pattern YDEx2Nhf = Pattern.compile("[\\\\</:>?\\[|\\]\"]");
				Matcher y59xONlS = YDEx2Nhf.matcher(x46w6IDl[3]);
				x46w6IDl[3] = y59xONlS.replaceAll(" ");
				x46w6IDl[3] = x46w6IDl[3].replaceAll("&", "and");
				URLConnection kZnggvUy;
				DataOutputStream ksDqly4i;
				HfSYDPsc = new URL("http://v3.newzbin.com/api/dnzb/");
				kZnggvUy = HfSYDPsc.openConnection();
				kZnggvUy.setDoInput(true);
				kZnggvUy.setDoOutput(true);
				kZnggvUy.setUseCaches(false);
				kZnggvUy.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				ksDqly4i = new DataOutputStream(kZnggvUy.getOutputStream());
				String aXDXISp4 = "username=" + JavaNZB.newzbinUsr + "&password=" + JavaNZB.newzbinPass + "&reportid="
						+ x46w6IDl[2];
				ksDqly4i.writeBytes(aXDXISp4);
				ksDqly4i.flush();
				ksDqly4i.close();
				BufferedReader D6LyAhbJ = new BufferedReader(new InputStreamReader(kZnggvUy.getInputStream()));
				File XDB5FxJN = new File(JavaNZB.hellaQueueDir, x46w6IDl[3] + ".nzb");
				BufferedWriter fBWKq8K3 = new BufferedWriter(new FileWriter(XDB5FxJN));
				String HO00aY4S;
				System.out.println("--Downloading " + x46w6IDl[3] + ".nzb" + " to queue directory--");
				while (null != ((HO00aY4S = D6LyAhbJ.readLine())))
					fBWKq8K3.write(HO00aY4S);
				D6LyAhbJ.close();
				fBWKq8K3.close();
				if (lYNRn75O == 0) {
					B6NC9w4v.episode = IGu0wjTO.latestEpisodeNum;
					B6NC9w4v.season = IGu0wjTO.latestSeasonNum;
				} else {
					B6NC9w4v.episode = IGu0wjTO.nextEpisodeNum;
					B6NC9w4v.season = IGu0wjTO.nextSeasonNum;
				}
			} else
				System.out.println("No new episode posted");
			System.out.println();
		} catch (MalformedURLException C76g7qU1) {
		} catch (IOException hU02KP3c) {
			System.out.println("IO Exception from NzbSearch");
		}
		return B6NC9w4v;
	}

}