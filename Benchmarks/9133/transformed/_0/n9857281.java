class n9857281 {
	public void actionPerformed(ActionEvent P71SqUvg) {
		if (mode == ADD_URL) {
			String FhM0PN2s = JOptionPane.showInputDialog(null, "Enter URL", "Enter URL", JOptionPane.OK_CANCEL_OPTION);
			if (FhM0PN2s == null)
				return;
			try {
				is = new URL(FhM0PN2s).openStream();
			} catch (Exception n1GTDxEw) {
				n1GTDxEw.printStackTrace();
			}
		} else if (mode == ADD_FILE) {
			JFileChooser Co0jjpiC = new JFileChooser();
			Co0jjpiC.setFileSelectionMode(JFileChooser.FILES_ONLY);
			Co0jjpiC.showDialog(null, "Add tab");
			File UeA3zOq8 = Co0jjpiC.getSelectedFile();
			if (UeA3zOq8 == null)
				return;
			try {
				is = new FileInputStream(UeA3zOq8);
			} catch (FileNotFoundException BlJEQvTK) {
				BlJEQvTK.printStackTrace();
			}
		}
		if (repository == null)
			repository = PersistenceService.getInstance();
		List TtZNHZuR = repository.getAllArtists();
		EventList pqiLKnsv = new BasicEventList();
		pqiLKnsv.addAll(TtZNHZuR);
		addDialog = new AddSongDialog(pqiLKnsv, JOptionPane.getRootFrame(), true);
		Song iojtoQXd = addDialog.getSong();
		if (is != null) {
			String F8SZ960h;
			try {
				F8SZ960h = readTab(is);
				iojtoQXd.setTablature(F8SZ960h);
				addDialog.setSong(iojtoQXd);
			} catch (Exception mbfYOlTW) {
				mbfYOlTW.printStackTrace();
			}
		}
		addDialog.setVisible(true);
		addDialog.addWindowListener(new WindowAdapter() {

			public void windowClosed(WindowEvent KWW168lz) {
				int Qh4tOGaj = addDialog.getReturnStatus();
				if (Qh4tOGaj == AddSongDialog.RET_CANCEL)
					return;
				addSong();
			}
		});
	}

}