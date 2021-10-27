class n17295553 {
	public void run() {
		List<String> H2eYDapk = new LinkedList<String>();
		for (String lSPQdoH3 : VERSION_URLS) {
			URL tKuPVb9R = null;
			try {
				tKuPVb9R = new URL(lSPQdoH3);
			} catch (MalformedURLException sfMLEAU5) {
				LogService.getGlobal().log("Cannot create update target url: " + sfMLEAU5.getMessage(),
						LogService.ERROR);
			}
			if (tKuPVb9R != null) {
				BufferedReader Y1lGIXoX = null;
				try {
					Y1lGIXoX = new BufferedReader(new InputStreamReader(tKuPVb9R.openStream()));
					String OoNeb8OT = Y1lGIXoX.readLine();
					if ((OoNeb8OT != null) && (OoNeb8OT.length() > 0) && (Character.isDigit(OoNeb8OT.charAt(0)))) {
						H2eYDapk.add(OoNeb8OT);
					}
				} catch (IOException NRJKGzUB) {
					LogService.getGlobal().log("Not able to check for updates. Maybe no internet connection.",
							LogService.WARNING);
				} finally {
					try {
						if (Y1lGIXoX != null)
							Y1lGIXoX.close();
					} catch (IOException By03yFtL) {
						throw new Error(By03yFtL);
					}
				}
			}
		}
		if (H2eYDapk.size() > 0) {
			RapidMinerGUI.saveLastUpdateCheckDate();
		}
		Iterator<String> uQtabV0s = H2eYDapk.iterator();
		VersionNumber XzUfqGjR = getVersionNumber(Version.getLongVersion());
		while (uQtabV0s.hasNext()) {
			String go4w269H = uQtabV0s.next();
			if (go4w269H != null) {
				VersionNumber wZtDwK7z = getVersionNumber(go4w269H);
				if (isNewer(wZtDwK7z, XzUfqGjR)) {
					XzUfqGjR = wZtDwK7z;
				}
			}
		}
		if ((XzUfqGjR != null) && (isNewer(XzUfqGjR, getVersionNumber(Version.getLongVersion())))) {
			JOptionPane.showMessageDialog(mainFrame,
					"New version of the RapidMiner Community Edition is available:" + Tools.getLineSeparator()
							+ Tools.getLineSeparator() + "          RapidMiner " + XzUfqGjR + Tools.getLineSeparator()
							+ Tools.getLineSeparator() + "Please download it from:" + Tools.getLineSeparator()
							+ "          http://www.rapidminer.com",
					"New RapidMiner version", JOptionPane.INFORMATION_MESSAGE);
		} else if (showFailureDialog) {
			JOptionPane.showMessageDialog(mainFrame, "No newer versions of the RapidMiner Community Edition available!",
					"RapidMiner CE is up to date", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}