class n1005108 {
	public void googleImageSearch(String TkcoDA0p, String tC5unv8s) {
		try {
			String HudqrDlm = "http://images.google.com/images?q=" + TkcoDA0p + tC5unv8s;
			if (HudqrDlm.contains(" ")) {
				HudqrDlm = HudqrDlm.replace(" ", "+");
			}
			URL cOK3fJBa = new URL(HudqrDlm);
			HttpURLConnection qxUMxbvF = (HttpURLConnection) cOK3fJBa.openConnection();
			qxUMxbvF.addRequestProperty("User-Agent", "Mozilla/4.76");
			BufferedReader LhSnqn8Q = new BufferedReader(new InputStreamReader(qxUMxbvF.getInputStream()));
			googleImages.clear();
			String L4QJgd0X = "";
			String UKlOdiaX = "";
			while ((UKlOdiaX = LhSnqn8Q.readLine()) != null) {
				L4QJgd0X += UKlOdiaX;
			}
			LhSnqn8Q.close();
			if (L4QJgd0X.contains("\n")) {
				L4QJgd0X = L4QJgd0X.replace("\n", "");
			}
			String[] Je34YrVb = L4QJgd0X.split("\\Qhref=\"/imgres?imgurl=\\E");
			for (String mT36RO4b : Je34YrVb) {
				if (mT36RO4b.startsWith("http://") || mT36RO4b.startsWith("https://") && mT36RO4b.contains("&amp;")) {
					String d7jh0IpY = mT36RO4b.substring(0, mT36RO4b.indexOf("&amp;"));
					googleImages.add(d7jh0IpY);
				}
			}
		} catch (Exception k2yZkNIN) {
			MusicBoxView.showErrorDialog(k2yZkNIN);
		}
		MusicBoxView.jButton7.setEnabled(true);
		ImageIcon sK1gIxab;
		try {
			sK1gIxab = new ImageIcon(new URL(googleImages.elementAt(MusicBoxView.googleImageLocation)));
			ImageIcon b1zUDOID = new ImageIcon(sK1gIxab.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
			MusicBoxView.albumArtLabel.setIcon(b1zUDOID);
		} catch (MalformedURLException wGilmURu) {
			MusicBoxView.showErrorDialog(wGilmURu);
		}
	}

}