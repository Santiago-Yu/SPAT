class n3287282 {
	public void googleImageSearch(String bsXcwhKW) {
		try {
			String rKC4cHrC = "http://images.google.com/images?q=" + custom + bsXcwhKW;
			if (rKC4cHrC.contains(" ")) {
				rKC4cHrC = rKC4cHrC.replace(" ", "+");
			}
			URL RZFUCcbr = new URL(rKC4cHrC);
			HttpURLConnection mdr24BGw = (HttpURLConnection) RZFUCcbr.openConnection();
			mdr24BGw.addRequestProperty("User-Agent", "Mozilla/4.76");
			BufferedReader d23KcsP7 = new BufferedReader(new InputStreamReader(mdr24BGw.getInputStream()));
			googleImages.clear();
			String XlJX4DiE = "";
			String D6kZrgCH = "";
			while ((D6kZrgCH = d23KcsP7.readLine()) != null) {
				XlJX4DiE += D6kZrgCH;
			}
			d23KcsP7.close();
			if (XlJX4DiE.contains("\n")) {
				XlJX4DiE = XlJX4DiE.replace("\n", "");
			}
			String[] SgxsrncZ = XlJX4DiE.split("\\Qhref=\"/imgres?imgurl=\\E");
			for (String bO4LrT06 : SgxsrncZ) {
				if (bO4LrT06.startsWith("http://") || bO4LrT06.startsWith("https://") && bO4LrT06.contains("&amp;")) {
					String hxzLFFSt = bO4LrT06.substring(0, bO4LrT06.indexOf("&amp;"));
					googleImages.add(hxzLFFSt);
				}
			}
		} catch (Exception aCqZaRFJ) {
			MusicBoxView.showErrorDialog(aCqZaRFJ);
		}
		jButton4.setEnabled(true);
		jButton2.setEnabled(true);
		getContentPane().remove(jLabel1);
		ImageIcon jqKG3r5r;
		try {
			jqKG3r5r = new ImageIcon(new URL(googleImages.elementAt(googleImageLocation)));
			int ckiZhdjC = jqKG3r5r.getIconHeight();
			int qcWi0lnb = jqKG3r5r.getIconWidth();
			jLabel1.setSize(qcWi0lnb, ckiZhdjC);
			jLabel1.setIcon(jqKG3r5r);
			add(jLabel1, BorderLayout.CENTER);
		} catch (MalformedURLException Dgw0JedU) {
			MusicBoxView.showErrorDialog(Dgw0JedU);
			jLabel1.setIcon(MusicBoxView.noImage);
		}
		add(jPanel1, BorderLayout.PAGE_END);
		pack();
	}

}