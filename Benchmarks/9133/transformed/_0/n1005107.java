class n1005107 {
	public void googleImageSearch() {
		if (artist.compareToIgnoreCase(previousArtist) != 0) {
			MusicBoxView.googleImageLocation = 0;
			try {
				String QoM2plbe = "http://images.google.com/images?q=" + currentTrack.getArtist() + " - "
						+ currentTrack.getAlbum() + "&sa=N&start=0&ndsp=21";
				if (QoM2plbe.contains(" ")) {
					QoM2plbe = QoM2plbe.replace(" ", "+");
				}
				URL vRQG6B83 = new URL(QoM2plbe);
				HttpURLConnection a5zxzSra = (HttpURLConnection) vRQG6B83.openConnection();
				a5zxzSra.addRequestProperty("User-Agent", "Mozilla/4.76");
				BufferedReader Y24wljFt = new BufferedReader(new InputStreamReader(a5zxzSra.getInputStream()));
				String rzr4nTlC = "";
				String xHt9BMIr = "";
				while ((xHt9BMIr = Y24wljFt.readLine()) != null) {
					rzr4nTlC += xHt9BMIr;
				}
				Y24wljFt.close();
				if (rzr4nTlC.contains("\n")) {
					rzr4nTlC = rzr4nTlC.replace("\n", "");
				}
				String[] Ha39UOuz = rzr4nTlC.split("\\Qhref=\"/imgres?imgurl=\\E");
				for (String MoMo34k0 : Ha39UOuz) {
					if (MoMo34k0.startsWith("http://")
							|| MoMo34k0.startsWith("https://") && MoMo34k0.contains("&amp;")) {
						String ZvRfOzJR = MoMo34k0.substring(0, MoMo34k0.indexOf("&amp;"));
						googleImages.add(ZvRfOzJR);
					}
				}
			} catch (Exception dAP7ifQj) {
				MusicBoxView.showErrorDialog(dAP7ifQj);
			}
		}
	}

}