class n15169806 {
	public void run() {
		try {
			URL url = new URL(UPDATE_URL);
			URLConnection urlc = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
			String versionString = br.readLine();
			if (!(versionString != null && !versionString.equals(PinEmUp.VERSION))) {
				if (showUpToDateMessage) {
					JOptionPane.showMessageDialog(null, I18N.getInstance().getString("info.versionuptodate"),
							I18N.getInstance().getString("info.title"), JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				StringBuilder changelogString = new StringBuilder();
				changelogString.append("<html>");
				changelogString.append("<p>" + I18N.getInstance().getString("info.updateavailable.part1") + "</p>");
				changelogString.append("<p>" + I18N.getInstance().getString("info.updateavailable.part2") + " "
						+ PinEmUp.VERSION + "<br />");
				changelogString.append(
						I18N.getInstance().getString("info.updateavailable.part3") + " " + versionString + "</p>");
				changelogString.append("<p>" + I18N.getInstance().getString("info.updateavailable.part4")
						+ " <a href=\"http://pinemup.sourceforge.net\">http://pinemup.sourceforge.net</a></p>");
				changelogString.append("<p>&nbsp;</p>");
				changelogString.append("<p>Changelog:<br />");
				changelogString.append("--------------------------------</p><p>");
				boolean firstList = true;
				String nextLine;
				do {
					nextLine = br.readLine();
					if (nextLine != null) {
						if (nextLine.startsWith("-")) {
							changelogString.append("<li>" + nextLine.substring(2) + "</li>");
						} else {
							if (!firstList) {
								changelogString.append("</ul>");
							} else {
								firstList = false;
							}
							changelogString.append(nextLine + "<ul>");
						}
					}
				} while (nextLine != null);
				changelogString.append("</p></html>");
				new UpdateDialog(changelogString.toString());
			}
			br.close();
		} catch (IOException e) {
		}
	}

}