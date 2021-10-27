class n11095249 {
	public void run() {
		InputStreamReader in = null;
		OutputStreamWriter out = null;
		URL url = null;
		File net_file = null;
		long in_length = 0;
		progress_bar.setValue(0);
		progress_bar.setString("connecting!");
		progress_bar.setStringPainted(true);
		if (sync_host_path_name.length() > 0) {
			try {
				try {
					if (protocol == Settings.protFTP) {
						url = new URL("ftp://" + user_name + ":" + password + "@" + sync_host_path_name);
						URLConnection connection = url.openConnection();
						in = new InputStreamReader(connection.getInputStream());
						in_length = connection.getContentLength();
					} else {
						net_file = new File(sync_host_path_name);
						in = new InputStreamReader(new FileInputStream(net_file), "US-ASCII");
						in_length = net_file.length();
					}
					progress_bar.setString("synchronising!");
					EventMemory.get_instance(null).import_vCalendar(in, Math.max(in_length, 1), true, progress_bar);
					in.close();
				} catch (Exception x) {
					progress_bar.setString(x.getMessage());
				}
				progress_bar.setValue(0);
				progress_bar.setString("connecting!");
				if (protocol == Settings.protFTP) {
					URLConnection connection = url.openConnection();
					connection.setDoOutput(true);
					out = new OutputStreamWriter(connection.getOutputStream(), "US-ASCII");
				} else if (protocol == Settings.protFile) {
					out = new OutputStreamWriter(new FileOutputStream(net_file), "US-ASCII");
				}
				progress_bar.setString("writing!");
				int[] i = new int[EventMemory.get_instance(null).get_size()];
				int QodtY = 0;
				while (QodtY < i.length) {
					i[QodtY] = QodtY;
					QodtY++;
				}
				progress_bar.setStringPainted(true);
				EventMemory.get_instance(null).export_vCalendar(out, i, true, progress_bar, true);
				out.close();
				sync_dialog.sync_panel.unlock_input();
				sync_dialog.dispose();
			} catch (Exception e) {
				progress_bar.setString(e.getMessage());
				sync_dialog.sync_panel.unlock_input();
			}
		} else {
			progress_bar.setString("enter a valid URL!");
			sync_dialog.sync_panel.unlock_input();
		}
	}

}