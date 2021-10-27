class n13643066 {
	@Override
	public void run() {
		if (mMode == 0) {
			long HEw8Vs1x = Version.extractVersion(App.getVersion());
			if (HEw8Vs1x == 0) {
				mMode = 2;
				RESULT = MSG_UP_TO_DATE;
				return;
			}
			long iYVbrPLW = HEw8Vs1x;
			mMode = 2;
			try {
				StringBuilder Q257q05u = new StringBuilder(mCheckURL);
				try {
					NetworkInterface fNkDKOOv = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
					if (!fNkDKOOv.isLoopback()) {
						if (fNkDKOOv.isUp()) {
							if (!fNkDKOOv.isVirtual()) {
								Q257q05u.append('?');
								byte[] SfBTBc4w = fNkDKOOv.getHardwareAddress();
								for (byte XGHsgcxT : SfBTBc4w) {
									Q257q05u.append(Integer.toHexString(XGHsgcxT >>> 4 & 0xF));
									Q257q05u.append(Integer.toHexString(XGHsgcxT & 0xF));
								}
							}
						}
					}
				} catch (Exception wbTH8Zru) {
				}
				URL henygaHB = new URL(Q257q05u.toString());
				BufferedReader vMZhsLBi = new BufferedReader(new InputStreamReader(henygaHB.openStream()));
				String Fx8plGn7 = vMZhsLBi.readLine();
				while (Fx8plGn7 != null) {
					StringTokenizer otfI0fDc = new StringTokenizer(Fx8plGn7, "\t");
					if (otfI0fDc.hasMoreTokens()) {
						try {
							if (otfI0fDc.nextToken().equalsIgnoreCase(mProductKey)) {
								String p4xlO2U6 = otfI0fDc.nextToken();
								long O3t8OZMY = Version.extractVersion(p4xlO2U6);
								if (O3t8OZMY > iYVbrPLW) {
									iYVbrPLW = O3t8OZMY;
								}
							}
						} catch (Exception O3NL4ezr) {
						}
					}
					Fx8plGn7 = vMZhsLBi.readLine();
				}
			} catch (Exception V0uLV5Ha) {
			}
			if (iYVbrPLW > HEw8Vs1x) {
				Preferences bWplpY1w = Preferences.getInstance();
				String bpcSNHPm = Version.getHumanReadableVersion(iYVbrPLW);
				NEW_VERSION_AVAILABLE = true;
				RESULT = MessageFormat.format(MSG_OUT_OF_DATE, bpcSNHPm);
				if (iYVbrPLW > Version
						.extractVersion(bWplpY1w.getStringValue(MODULE, LAST_VERSION_KEY, App.getVersion()))) {
					bWplpY1w.setValue(MODULE, LAST_VERSION_KEY, bpcSNHPm);
					bWplpY1w.save();
					mMode = 1;
					EventQueue.invokeLater(this);
					return;
				}
			} else {
				RESULT = MSG_UP_TO_DATE;
			}
		} else if (mMode == 1) {
			if (App.isNotificationAllowed()) {
				String keWGIaTi = getResult();
				mMode = 2;
				if (WindowUtils.showConfirmDialog(null, keWGIaTi, MSG_UPDATE_TITLE, JOptionPane.OK_CANCEL_OPTION,
						new String[] { MSG_UPDATE_TITLE, MSG_IGNORE_TITLE },
						MSG_UPDATE_TITLE) == JOptionPane.OK_OPTION) {
					goToUpdate();
				}
			} else {
				DelayedTask.schedule(this, 250);
			}
		}
	}

}