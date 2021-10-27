class n3287281 {
	private void googleImageSearch() {
		bottomShowing = true;
		googleSearched = true;
		googleImageLocation = 0;
		googleImages = new Vector<String>();
		custom = "";
		int cmoJOytl = JOptionPane.showConfirmDialog(this, "Customize google search?", "Google Search",
				JOptionPane.YES_NO_OPTION);
		if (cmoJOytl == JOptionPane.YES_OPTION) {
			custom = JOptionPane.showInputDialog("Custom Search", "");
		} else {
			custom = artist;
		}
		try {
			String IxdBAzds = "http://images.google.com/images?q=" + custom;
			if (IxdBAzds.contains(" ")) {
				IxdBAzds = IxdBAzds.replace(" ", "+");
			}
			URL ADvbSp98 = new URL(IxdBAzds);
			HttpURLConnection vHDRwAcX = (HttpURLConnection) ADvbSp98.openConnection();
			vHDRwAcX.addRequestProperty("User-Agent", "Mozilla/4.76");
			BufferedReader YUhltjmL = new BufferedReader(new InputStreamReader(vHDRwAcX.getInputStream()));
			googleImages.clear();
			String EKCwX6IM = new String();
			while ((EKCwX6IM = YUhltjmL.readLine()) != null) {
				while (EKCwX6IM.contains("href=\"/imgres?imgurl=")) {
					while (!EKCwX6IM.contains(">")) {
						EKCwX6IM += YUhltjmL.readLine();
					}
					String UMQIoB6m = EKCwX6IM.substring(EKCwX6IM.indexOf("href=\"/imgres?imgurl="),
							EKCwX6IM.indexOf(">", EKCwX6IM.indexOf("href=\"/imgres?imgurl=")));
					EKCwX6IM = EKCwX6IM.substring(EKCwX6IM.indexOf(">", EKCwX6IM.indexOf("href=\"/imgres?imgurl=")));
					if (UMQIoB6m.contains("&amp;") && UMQIoB6m.indexOf("http://") < UMQIoB6m.indexOf("&amp;")) {
						UMQIoB6m = UMQIoB6m.substring(UMQIoB6m.indexOf("http://"), UMQIoB6m.indexOf("&amp;"));
					} else {
						UMQIoB6m = UMQIoB6m.substring(UMQIoB6m.indexOf("http://"), UMQIoB6m.length());
					}
					googleImages.add(UMQIoB6m);
				}
			}
			YUhltjmL.close();
		} catch (Exception A3RXENlG) {
			MusicBoxView.showErrorDialog(A3RXENlG);
		}
		jButton1.setEnabled(false);
		getContentPane().remove(jLabel1);
		ImageIcon gNwjv8Ng;
		try {
			gNwjv8Ng = new ImageIcon(new URL(googleImages.elementAt(googleImageLocation)));
			int C9Bvw0sA = gNwjv8Ng.getIconHeight();
			int ji2Vtir7 = gNwjv8Ng.getIconWidth();
			jLabel1.setSize(ji2Vtir7, C9Bvw0sA);
			jLabel1.setIcon(gNwjv8Ng);
			add(jLabel1, BorderLayout.CENTER);
		} catch (MalformedURLException WAW3qgrY) {
			MusicBoxView.showErrorDialog(WAW3qgrY);
			jLabel1.setIcon(MusicBoxView.noImage);
		}
		add(jPanel1, BorderLayout.PAGE_END);
		pack();
	}

}