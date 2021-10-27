class n2940068 {
	public void run() {
		checkupdates.BetaST.setText("");
		checkupdates.stableST.setText("");

		int i = 0;
		String[] s = new String[7];
		try {

			URL url = new URL("http://memorize-words.sourceforge.net/latest.txt");

			String str;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			while (((str = in.readLine()) != null) && (i < 7)) {

				s[i] = str;
				i++;
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		boolean updated = false;
		if (i < 5) {
			checkupdates.CheckBT.setEnabled(true);
			return;
		}
		if ((MF.CurVersion < Integer.parseInt(s[0])) && (checkupdates.BetaCHK.isSelected())) {
			checkupdates.BetaST.setText("<HTML>A newer BETA version (<b>" + s[4]
					+ "</b>) is available at<BR> <a href=''>" + s[2] + "</a></HTML>");
			checkupdates.hasBeta = true;
			updated = true;
			checkupdates.BetaURL = s[2];
		} else
			checkupdates.BetaST.setText("");

		if ((MF.CurVersion < Integer.parseInt(s[1])) && (checkupdates.StableCHK.isSelected())) {
			checkupdates.stableST.setText("<HTML>A newer STABLE version (<b>" + s[5]
					+ "</b>) is available at<BR> <a href=''>" + s[3] + "</a></HTML>");
			checkupdates.hasStable = true;
			updated = true;
			checkupdates.StableURL = s[3];
		} else
			checkupdates.stableST.setText("");

		if (updated)
			checkupdates.setVisible(true);
		checkupdates.CheckBT.setEnabled(true);
		// "A newer stable version (memorize-words 1-2-2) is available at http://"
		//   MF.CurVersion;
	}

}