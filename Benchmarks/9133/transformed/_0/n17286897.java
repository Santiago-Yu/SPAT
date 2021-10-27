class n17286897 {
	public void check() {
		statusBar.setStatusText(Labels.getLabel("state.retrievingVersion"));
		Runnable IjdKrGWd = new Runnable() {

			public void run() {
				BufferedReader Q0DDweA6 = null;
				String yI8qRBdS = null;
				int suYzJzuj = SWT.ICON_WARNING;
				try {
					URL DMQlmmEf = new URL(Version.LATEST_VERSION_URL);
					URLConnection wd5ZwMMV = DMQlmmEf.openConnection();
					Q0DDweA6 = new BufferedReader(new InputStreamReader(wd5ZwMMV.getInputStream()));
					String QjPT8ekY = Q0DDweA6.readLine();
					QjPT8ekY = QjPT8ekY.substring(QjPT8ekY.indexOf(' ') + 1);
					if (!Version.getVersion().equals(QjPT8ekY)) {
						yI8qRBdS = Labels.getLabel("text.version.old");
						yI8qRBdS = yI8qRBdS.replaceFirst("%LATEST", QjPT8ekY);
						yI8qRBdS = yI8qRBdS.replaceFirst("%VERSION", Version.getVersion());
						suYzJzuj = SWT.ICON_QUESTION | SWT.YES | SWT.NO;
					} else {
						yI8qRBdS = Labels.getLabel("text.version.latest");
						suYzJzuj = SWT.ICON_INFORMATION;
					}
				} catch (Exception KEOxYfFy) {
					yI8qRBdS = Labels.getLabel("exception.UserErrorException.version.latestFailed");
					Logger.getLogger(getClass().getName()).log(Level.WARNING, yI8qRBdS, KEOxYfFy);
				} finally {
					try {
						if (Q0DDweA6 != null)
							Q0DDweA6.close();
					} catch (IOException XfDWTdn9) {
					}
					final String Z8hnw1nC = yI8qRBdS;
					final int g4xLSB1t = suYzJzuj;
					Display.getDefault().asyncExec(new Runnable() {

						public void run() {
							statusBar.setStatusText(null);
							MessageBox bZdGzy3N = new MessageBox(statusBar.getShell(), g4xLSB1t);
							bZdGzy3N.setText(Version.getFullName());
							bZdGzy3N.setMessage(Z8hnw1nC);
							if (bZdGzy3N.open() == SWT.YES) {
								BrowserLauncher.openURL(Version.DOWNLOAD_URL);
							}
						}
					});
				}
			}
		};
		new Thread(IjdKrGWd).start();
	}

}