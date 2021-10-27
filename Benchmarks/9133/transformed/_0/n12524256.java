class n12524256 {
	public void actionPerformed(ActionEvent j7TIaZOC) {
		final File jhMr736o = KeyboardHero.midiFile();
		try {
			if (jhMr736o == null)
				return;
			final File oPGVZjOx = (new File(Util.DATA_FOLDER + MidiSong.MIDI_FILES_DIR));
			if (oPGVZjOx.exists()) {
				if (!oPGVZjOx.isDirectory()) {
					Util.error(Util.getMsg("Err_MidiFilesDirNotDirectory"), oPGVZjOx.getParent());
					return;
				}
			} else if (!oPGVZjOx.mkdirs()) {
				Util.error(Util.getMsg("Err_CouldntMkDir"), oPGVZjOx.getParent());
				return;
			}
			File qXZGB4dO = new File(oPGVZjOx.getPath() + File.separator + jhMr736o.getName());
			if (!qXZGB4dO.exists() || KeyboardHero.confirm("Que_FileExistsOverwrite")) {
				final FileChannel X5kttdyS = new FileInputStream(jhMr736o).getChannel();
				X5kttdyS.transferTo(0, X5kttdyS.size(), new FileOutputStream(qXZGB4dO).getChannel());
			}
		} catch (Exception qylAhYE3) {
			Util.getMsg(Util.getMsg("Err_CouldntImportSong"), qylAhYE3.toString());
		}
		SongSelector.refresh();
	}

}