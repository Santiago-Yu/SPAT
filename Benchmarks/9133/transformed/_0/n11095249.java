class n11095249 {
	public void run() {
		InputStreamReader qNr39oW9 = null;
		OutputStreamWriter cdRiT1vB = null;
		URL qnHSYxp1 = null;
		File pY1mlPkI = null;
		long pOXs5kBz = 0;
		progress_bar.setValue(0);
		progress_bar.setString("connecting!");
		progress_bar.setStringPainted(true);
		if (sync_host_path_name.length() > 0) {
			try {
				try {
					if (protocol == Settings.protFTP) {
						qnHSYxp1 = new URL("ftp://" + user_name + ":" + password + "@" + sync_host_path_name);
						URLConnection HNVDhjwl = qnHSYxp1.openConnection();
						qNr39oW9 = new InputStreamReader(HNVDhjwl.getInputStream());
						pOXs5kBz = HNVDhjwl.getContentLength();
					} else {
						pY1mlPkI = new File(sync_host_path_name);
						qNr39oW9 = new InputStreamReader(new FileInputStream(pY1mlPkI), "US-ASCII");
						pOXs5kBz = pY1mlPkI.length();
					}
					progress_bar.setString("synchronising!");
					EventMemory.get_instance(null).import_vCalendar(qNr39oW9, Math.max(pOXs5kBz, 1), true,
							progress_bar);
					qNr39oW9.close();
				} catch (Exception opaZ7WuX) {
					progress_bar.setString(opaZ7WuX.getMessage());
				}
				progress_bar.setValue(0);
				progress_bar.setString("connecting!");
				if (protocol == Settings.protFTP) {
					URLConnection J7UEAnZs = qnHSYxp1.openConnection();
					J7UEAnZs.setDoOutput(true);
					cdRiT1vB = new OutputStreamWriter(J7UEAnZs.getOutputStream(), "US-ASCII");
				} else if (protocol == Settings.protFile) {
					cdRiT1vB = new OutputStreamWriter(new FileOutputStream(pY1mlPkI), "US-ASCII");
				}
				progress_bar.setString("writing!");
				int[] kPRQ3fC9 = new int[EventMemory.get_instance(null).get_size()];
				for (int RsJdUi17 = 0; RsJdUi17 < kPRQ3fC9.length; RsJdUi17++) {
					kPRQ3fC9[RsJdUi17] = RsJdUi17;
				}
				progress_bar.setStringPainted(true);
				EventMemory.get_instance(null).export_vCalendar(cdRiT1vB, kPRQ3fC9, true, progress_bar, true);
				cdRiT1vB.close();
				sync_dialog.sync_panel.unlock_input();
				sync_dialog.dispose();
			} catch (Exception p1yqXqOG) {
				progress_bar.setString(p1yqXqOG.getMessage());
				sync_dialog.sync_panel.unlock_input();
			}
		} else {
			progress_bar.setString("enter a valid URL!");
			sync_dialog.sync_panel.unlock_input();
		}
	}

}