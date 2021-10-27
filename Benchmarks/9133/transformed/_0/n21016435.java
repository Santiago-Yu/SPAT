class n21016435 {
	private String getFullScreenUrl() {
		progressDown.setIndeterminate(true);
		System.out.println("Har: " + ytUrl);
		String XrnM51MY = ytUrl;
		URLConnection GnYiI9pg = null;
		String aqHu8sbV = null;
		String WzV2lfTW = "";
		String zto4peBn = "";
		try {
			URL bdWD3UQe = new URL(XrnM51MY);
			GnYiI9pg = bdWD3UQe.openConnection();
			GnYiI9pg.setDoOutput(true);
			BufferedReader Ade2NLK8 = new BufferedReader(new InputStreamReader(GnYiI9pg.getInputStream()));
			while ((aqHu8sbV = Ade2NLK8.readLine()) != null) {
				if (aqHu8sbV.contains("fullscreenUrl")) {
					WzV2lfTW = aqHu8sbV.trim();
				}
			}
			Ade2NLK8.close();
			System.out.println(WzV2lfTW);
			int VfYOUPaa = 0;
			String[] ppEJKtvq = WzV2lfTW.split("&");
			String[] reuaMGlh = null;
			String TGdK4vwi = null;
			String TnqZp7CQ = null;
			String JETobJ40 = null;
			for (int X65jCcWY = 0; X65jCcWY < ppEJKtvq.length; X65jCcWY++) {
				if (ppEJKtvq[X65jCcWY].startsWith("video_id=")) {
					reuaMGlh = ppEJKtvq[X65jCcWY].split("=");
					TGdK4vwi = reuaMGlh[1];
				}
				if (ppEJKtvq[X65jCcWY].startsWith("t=")) {
					reuaMGlh = ppEJKtvq[X65jCcWY].split("=");
					TnqZp7CQ = reuaMGlh[1];
				}
				if (ppEJKtvq[X65jCcWY].startsWith("title=")) {
					reuaMGlh = ppEJKtvq[X65jCcWY].split("=");
					JETobJ40 = reuaMGlh[1].substring(0, (reuaMGlh[1].length() - 2));
				}
				System.out.println(ppEJKtvq[X65jCcWY]);
			}
			System.out.println("So we got...");
			System.out.println("video_id: " + TGdK4vwi);
			System.out.println("t: " + TnqZp7CQ);
			System.out.println("title: " + JETobJ40);
			ytTitle = JETobJ40;
			zto4peBn = "http://www.youtube.com/get_video.php?video_id=" + TGdK4vwi + "&t=" + TnqZp7CQ;
		} catch (Exception R3kZE2tn) {
			System.err.println("Error: " + R3kZE2tn.getLocalizedMessage());
		}
		progressDown.setIndeterminate(false);
		return zto4peBn;
	}

}