class n17286898 {
	public void run() {
		BufferedReader neDV9ZCX = null;
		String Fp7QG3Wt = null;
		int JNSoTyuu = SWT.ICON_WARNING;
		try {
			URL WB9PT9t0 = new URL(Version.LATEST_VERSION_URL);
			URLConnection nLyxNtlg = WB9PT9t0.openConnection();
			neDV9ZCX = new BufferedReader(new InputStreamReader(nLyxNtlg.getInputStream()));
			String yMtOoGfR = neDV9ZCX.readLine();
			yMtOoGfR = yMtOoGfR.substring(yMtOoGfR.indexOf(' ') + 1);
			if (!Version.getVersion().equals(yMtOoGfR)) {
				Fp7QG3Wt = Labels.getLabel("text.version.old");
				Fp7QG3Wt = Fp7QG3Wt.replaceFirst("%LATEST", yMtOoGfR);
				Fp7QG3Wt = Fp7QG3Wt.replaceFirst("%VERSION", Version.getVersion());
				JNSoTyuu = SWT.ICON_QUESTION | SWT.YES | SWT.NO;
			} else {
				Fp7QG3Wt = Labels.getLabel("text.version.latest");
				JNSoTyuu = SWT.ICON_INFORMATION;
			}
		} catch (Exception hW3AWLqO) {
			Fp7QG3Wt = Labels.getLabel("exception.UserErrorException.version.latestFailed");
			Logger.getLogger(getClass().getName()).log(Level.WARNING, Fp7QG3Wt, hW3AWLqO);
		} finally {
			try {
				if (neDV9ZCX != null)
					neDV9ZCX.close();
			} catch (IOException wbiIauUJ) {
			}
			final String MNsVtbH4 = Fp7QG3Wt;
			final int zpAxcQ7y = JNSoTyuu;
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					statusBar.setStatusText(null);
					MessageBox aLUTef3l = new MessageBox(statusBar.getShell(), zpAxcQ7y);
					aLUTef3l.setText(Version.getFullName());
					aLUTef3l.setMessage(MNsVtbH4);
					if (aLUTef3l.open() == SWT.YES) {
						BrowserLauncher.openURL(Version.DOWNLOAD_URL);
					}
				}
			});
		}
	}

}