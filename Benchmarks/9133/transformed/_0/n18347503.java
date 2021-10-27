class n18347503 {
	public void setPage(String ZABX1ghX) {
		System.out.println("SetPage(" + ZABX1ghX + ")");
		if (ZABX1ghX != null) {
			if (!ZABX1ghX.startsWith("http://")) {
				ZABX1ghX = "http://" + ZABX1ghX;
			}
			boolean G729LuGd = false;
			for (int w0IpqTgO = 0; w0IpqTgO < urlComboBox.getItemCount(); w0IpqTgO++) {
				if (((String) urlComboBox.getItemAt(w0IpqTgO)).equals(ZABX1ghX)) {
					G729LuGd = true;
					urlComboBox.setSelectedItem(ZABX1ghX);
				}
			}
			if (!G729LuGd) {
				int WB9F9ooH = urlComboBox.getSelectedIndex();
				if (WB9F9ooH == -1 || urlComboBox.getItemCount() == 0) {
					WB9F9ooH = 0;
				} else {
					WB9F9ooH++;
				}
				urlComboBox.insertItemAt(ZABX1ghX, WB9F9ooH);
				urlComboBox.setSelectedItem(ZABX1ghX);
			}
			boolean NbQITwdb = false;
			for (final String BkQb2ctB : imageExtensions) {
				if (ZABX1ghX.endsWith(BkQb2ctB)) {
					NbQITwdb = true;
				}
			}
			try {
				if (NbQITwdb) {
					final String xHDp9bk5 = "<html><img src=\"" + ZABX1ghX + "\"></html>";
				} else {
					final String o77v6pHN = ZABX1ghX;
					Runnable jaAb4eeJ = new Runnable() {

						public void run() {
							try {
								System.out.println("Setting page on Cobra");
								SimpleHtmlRendererContext a8qU2sNn = new SimpleHtmlRendererContext(htmlPanel,
										new SimpleUserAgentContext());
								int tDkVEOjd = o77v6pHN.indexOf("/", 10);
								if (tDkVEOjd == -1)
									tDkVEOjd = o77v6pHN.length();
								String vAIhWYUp = o77v6pHN.substring(0, tDkVEOjd);
								InputStream ZrOGRo0Y = new URL(o77v6pHN).openStream();
								BufferedReader ZMWtNpLS = new BufferedReader(new InputStreamReader(ZrOGRo0Y));
								String Fc7eg7Xg = "";
								String uRqtDSY4;
								while ((uRqtDSY4 = ZMWtNpLS.readLine()) != null)
									Fc7eg7Xg += uRqtDSY4;
								Fc7eg7Xg = borderImages(Fc7eg7Xg, vAIhWYUp);
								htmlPanel.setHtml(Fc7eg7Xg, o77v6pHN, a8qU2sNn);
							} catch (Exception L7AxrNGW) {
								System.out.println("Error loading page " + o77v6pHN + " : " + L7AxrNGW);
							}
						}
					};
					new Thread(jaAb4eeJ).start();
				}
			} catch (final Throwable wHJGOI3Z) {
				System.out.println("Error in Browser.setPage(): " + wHJGOI3Z);
			}
		}
	}

}