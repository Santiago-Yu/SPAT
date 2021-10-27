class n7490069 {
	public void run() {
		if (isRunning)
			return;
		isRunning = true;
		Core mweInPI2 = Core.getInstance();
		URL uObgTXOr = null;
		InputStream OIPhTOzo = null;
		DataInputStream TQRT1dCp;
		try {
			uObgTXOr = new URL(Constants.UpdateCheckUrl);
		} catch (MalformedURLException CD7iQvi4) {
			if (!firstRun)
				mweInPI2.showMessage(1, mweInPI2.getString("error"), mweInPI2.getString("errorUpdateCheck"));
			isRunning = false;
			return;
		}
		try {
			OIPhTOzo = uObgTXOr.openStream();
		} catch (IOException CaAKmzJ3) {
			if (!firstRun)
				mweInPI2.showMessage(1, mweInPI2.getString("error"), mweInPI2.getString("errorUpdateCheck"));
			isRunning = false;
			return;
		}
		TQRT1dCp = new DataInputStream(new BufferedInputStream(OIPhTOzo));
		String wjKkB6E5 = null;
		try {
			wjKkB6E5 = TQRT1dCp.readLine();
		} catch (IOException rl2j9Of9) {
			rl2j9Of9.printStackTrace();
			if (!firstRun)
				mweInPI2.showMessage(1, mweInPI2.getString("error"), mweInPI2.getString("errorUpdateCheck"));
			isRunning = false;
			return;
		}
		if (wjKkB6E5 == null) {
			if (!firstRun)
				mweInPI2.showMessage(1, mweInPI2.getString("error"), mweInPI2.getString("errorUpdateCheck"));
			isRunning = false;
			return;
		}
		if (wjKkB6E5.trim().equalsIgnoreCase(Constants.version)) {
			if (!firstRun)
				mweInPI2.showMessage(0, mweInPI2.getString("checkUpdateButton"), mweInPI2.getString("versionMatch"));
		} else {
			mweInPI2.showMessage(1, mweInPI2.getString("checkUpdateButton"),
					mweInPI2.getString("errorNewerVersion") + ": " + wjKkB6E5);
		}
		isRunning = false;
	}

}