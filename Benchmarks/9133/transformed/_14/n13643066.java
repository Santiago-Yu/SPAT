class n13643066 {
	@Override
	public void run() {
		if (0 == mMode) {
			long currentVersion = Version.extractVersion(App.getVersion());
			if (0 == currentVersion) {
				mMode = 2;
				RESULT = MSG_UP_TO_DATE;
				return;
			}
			long versionAvailable = currentVersion;
			mMode = 2;
			try {
				StringBuilder buffer = new StringBuilder(mCheckURL);
				try {
					NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
					if (!ni.isLoopback()) {
						if (ni.isUp()) {
							if (!ni.isVirtual()) {
								buffer.append('?');
								byte[] macAddress = ni.getHardwareAddress();
								for (byte one : macAddress) {
									buffer.append(Integer.toHexString(one >>> 4 & 0xF));
									buffer.append(Integer.toHexString(one & 0xF));
								}
							}
						}
					}
				} catch (Exception exception) {
				}
				URL url = new URL(buffer.toString());
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				String line = in.readLine();
				while (line != null) {
					StringTokenizer tokenizer = new StringTokenizer(line, "\t");
					if (tokenizer.hasMoreTokens()) {
						try {
							if (tokenizer.nextToken().equalsIgnoreCase(mProductKey)) {
								String token = tokenizer.nextToken();
								long version = Version.extractVersion(token);
								if (version > versionAvailable) {
									versionAvailable = version;
								}
							}
						} catch (Exception exception) {
						}
					}
					line = in.readLine();
				}
			} catch (Exception exception) {
			}
			if (versionAvailable > currentVersion) {
				Preferences prefs = Preferences.getInstance();
				String humanReadableVersion = Version.getHumanReadableVersion(versionAvailable);
				NEW_VERSION_AVAILABLE = true;
				RESULT = MessageFormat.format(MSG_OUT_OF_DATE, humanReadableVersion);
				if (versionAvailable > Version
						.extractVersion(prefs.getStringValue(MODULE, LAST_VERSION_KEY, App.getVersion()))) {
					prefs.setValue(MODULE, LAST_VERSION_KEY, humanReadableVersion);
					prefs.save();
					mMode = 1;
					EventQueue.invokeLater(this);
					return;
				}
			} else {
				RESULT = MSG_UP_TO_DATE;
			}
		} else if (1 == mMode) {
			if (App.isNotificationAllowed()) {
				String result = getResult();
				mMode = 2;
				if (JOptionPane.OK_OPTION == WindowUtils.showConfirmDialog(null, result, MSG_UPDATE_TITLE,
						JOptionPane.OK_CANCEL_OPTION, new String[] { MSG_UPDATE_TITLE, MSG_IGNORE_TITLE },
						MSG_UPDATE_TITLE)) {
					goToUpdate();
				}
			} else {
				DelayedTask.schedule(this, 250);
			}
		}
	}

}