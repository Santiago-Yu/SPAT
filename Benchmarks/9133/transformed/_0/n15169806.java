class n15169806 {
	public void run() {
		try {
			URL BcefgcYt = new URL(UPDATE_URL);
			URLConnection bc7ElB7H = BcefgcYt.openConnection();
			BufferedReader Q8lRVJGv = new BufferedReader(new InputStreamReader(bc7ElB7H.getInputStream()));
			String odByZLsC = Q8lRVJGv.readLine();
			if (odByZLsC != null && !odByZLsC.equals(PinEmUp.VERSION)) {
				StringBuilder uq3Y60VE = new StringBuilder();
				uq3Y60VE.append("<html>");
				uq3Y60VE.append("<p>" + I18N.getInstance().getString("info.updateavailable.part1") + "</p>");
				uq3Y60VE.append("<p>" + I18N.getInstance().getString("info.updateavailable.part2") + " "
						+ PinEmUp.VERSION + "<br />");
				uq3Y60VE.append(I18N.getInstance().getString("info.updateavailable.part3") + " " + odByZLsC + "</p>");
				uq3Y60VE.append("<p>" + I18N.getInstance().getString("info.updateavailable.part4")
						+ " <a href=\"http://pinemup.sourceforge.net\">http://pinemup.sourceforge.net</a></p>");
				uq3Y60VE.append("<p>&nbsp;</p>");
				uq3Y60VE.append("<p>Changelog:<br />");
				uq3Y60VE.append("--------------------------------</p><p>");
				boolean DHWu6Ryg = true;
				String IelCjHDk;
				do {
					IelCjHDk = Q8lRVJGv.readLine();
					if (IelCjHDk != null) {
						if (IelCjHDk.startsWith("-")) {
							uq3Y60VE.append("<li>" + IelCjHDk.substring(2) + "</li>");
						} else {
							if (!DHWu6Ryg) {
								uq3Y60VE.append("</ul>");
							} else {
								DHWu6Ryg = false;
							}
							uq3Y60VE.append(IelCjHDk + "<ul>");
						}
					}
				} while (IelCjHDk != null);
				uq3Y60VE.append("</p></html>");
				new UpdateDialog(uq3Y60VE.toString());
			} else if (showUpToDateMessage) {
				JOptionPane.showMessageDialog(null, I18N.getInstance().getString("info.versionuptodate"),
						I18N.getInstance().getString("info.title"), JOptionPane.INFORMATION_MESSAGE);
			}
			Q8lRVJGv.close();
		} catch (IOException Ih7LNQSC) {
		}
	}

}