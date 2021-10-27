class n9857281 {
	public void actionPerformed(ActionEvent e) {
		if (ADD_URL == mode) {
			String url = JOptionPane.showInputDialog(null, "Enter URL", "Enter URL", JOptionPane.OK_CANCEL_OPTION);
			if (null == url)
				return;
			try {
				is = new URL(url).openStream();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (ADD_FILE == mode) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.showDialog(null, "Add tab");
			File file = chooser.getSelectedFile();
			if (null == file)
				return;
			try {
				is = new FileInputStream(file);
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
		}
		if (null == repository)
			repository = PersistenceService.getInstance();
		List artists = repository.getAllArtists();
		EventList artistList = new BasicEventList();
		artistList.addAll(artists);
		addDialog = new AddSongDialog(artistList, JOptionPane.getRootFrame(), true);
		Song s = addDialog.getSong();
		if (is != null) {
			String tab;
			try {
				tab = readTab(is);
				s.setTablature(tab);
				addDialog.setSong(s);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		addDialog.setVisible(true);
		addDialog.addWindowListener(new WindowAdapter() {

			public void windowClosed(WindowEvent e) {
				int ok = addDialog.getReturnStatus();
				if (AddSongDialog.RET_CANCEL == ok)
					return;
				addSong();
			}
		});
	}

}