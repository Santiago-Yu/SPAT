class n2940068 {
	public void run() {
		checkupdates.BetaST.setText("");
		checkupdates.stableST.setText("");

		String[] QJ61wlCf = new String[7];
		int HyjlCMXm = 0;
		try {

			URL ry6ZnXaN = new URL("http://memorize-words.sourceforge.net/latest.txt");

			BufferedReader TdXc3rg1 = new BufferedReader(new InputStreamReader(ry6ZnXaN.openStream()));
			String VsunbKrr;

			while (((VsunbKrr = TdXc3rg1.readLine()) != null) && (HyjlCMXm < 7)) {

				QJ61wlCf[HyjlCMXm] = VsunbKrr;
				HyjlCMXm++;
			}
			TdXc3rg1.close();
		} catch (MalformedURLException w2lbVHUA) {
		} catch (IOException BlrfNrgK) {
		}
		if (HyjlCMXm < 5) {
			checkupdates.CheckBT.setEnabled(true);
			return;
		}
		//S[0]=latest Beta version
		//S[1]=latest Stable version
		//s[2]=Beta version download path
		//s[3]=Stable version download path
		//s[4]= Beta name
		//s[5]=Stable name
		boolean J4Ea1DZK = false;
		if ((MF.CurVersion < Integer.parseInt(QJ61wlCf[0])) && (checkupdates.BetaCHK.isSelected())) {
			checkupdates.BetaST.setText("<HTML>A newer BETA version (<b>" + QJ61wlCf[4]
					+ "</b>) is available at<BR> <a href=''>" + QJ61wlCf[2] + "</a></HTML>");
			J4Ea1DZK = true;
			checkupdates.hasBeta = true;
			checkupdates.BetaURL = QJ61wlCf[2];
		} else
			checkupdates.BetaST.setText("");

		if ((MF.CurVersion < Integer.parseInt(QJ61wlCf[1])) && (checkupdates.StableCHK.isSelected())) {
			checkupdates.stableST.setText("<HTML>A newer STABLE version (<b>" + QJ61wlCf[5]
					+ "</b>) is available at<BR> <a href=''>" + QJ61wlCf[3] + "</a></HTML>");
			J4Ea1DZK = true;
			checkupdates.hasStable = true;
			checkupdates.StableURL = QJ61wlCf[3];
		} else
			checkupdates.stableST.setText("");

		if (J4Ea1DZK)
			checkupdates.setVisible(true);
		checkupdates.CheckBT.setEnabled(true);
		// "A newer stable version (memorize-words 1-2-2) is available at http://"
		//   MF.CurVersion;
	}

}