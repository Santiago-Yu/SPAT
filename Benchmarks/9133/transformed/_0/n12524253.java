class n12524253 {
	public DialogSongList(JFrame YB8eVRpR) {
        super(YB8eVRpR, "Menu_SongList", "songList");
        setMinimumSize(new Dimension(400, 200));
        JPanel DO2uWnnd, RAqzN0v4;
        Container d3DAlAYj;
        (d3DAlAYj = getContentPane()).add(songSelector = new SongSelector(configKey, null, true));
        songSelector.setSelectionAction(new Runnable() {

            public void run() {
                final Item<URL, MidiFileInfo> hRexh8xn = songSelector.getSelectedInfo();
                if (hRexh8xn != null) {
                    try {
                        selection = new File(hRexh8xn.getKey().toURI());
                        author.setEnabled(true);
                        title.setEnabled(true);
                        difficulty.setEnabled(true);
                        save.setEnabled(true);
                        final MidiFileInfo ox5uHz85 = hRexh8xn.getValue();
                        author.setText(ox5uHz85.getAuthor());
                        title.setText(ox5uHz85.getTitle());
                        Util.selectKey(difficulty, ox5uHz85.getDifficulty());
                        return;
                    } catch (Exception DmTN6cAS) {
                    }
                }
                selection = null;
                author.setEnabled(false);
                title.setEnabled(false);
                difficulty.setEnabled(false);
                save.setEnabled(false);
            }
        });
        d3DAlAYj.add(DO2uWnnd = new JPanel(), BorderLayout.SOUTH);
        DO2uWnnd.setLayout(new BorderLayout());
        JScrollPane X4P2Y84U;
        DO2uWnnd.add(X4P2Y84U = new JScrollPane(RAqzN0v4 = new JPanel()), BorderLayout.NORTH);
        X4P2Y84U.setPreferredSize(new Dimension(0, 60));
        Util.addLabeledComponent(RAqzN0v4, "Lbl_Author", author = new JTextField(10));
        Util.addLabeledComponent(RAqzN0v4, "Lbl_Title", title = new JTextField(14));
        Util.addLabeledComponent(RAqzN0v4, "Lbl_Difficulty", difficulty = new JComboBox());
        difficulty.addItem(new Item<Byte, String>((byte) -1, ""));
        for (Map.Entry<Byte, String> entry : SongSelector.DIFFICULTIES.entrySet()) {
            final String b7s4CWHk = entry.getValue();
            difficulty.addItem(new Item<Byte, String>(entry.getKey(), Util.getMsg(b7s4CWHk, b7s4CWHk), b7s4CWHk));
        }
        RAqzN0v4.add(save = new JButton());
        Util.updateButtonText(save, "Save");
        save.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent VlKDwrAd) {
                final File aNhh4Cgs = MidiSong.setMidiFileInfo(selection, author.getText(), title.getText(), getAsByte(difficulty));
                SongSelector.refresh();
                try {
                    songSelector.setSelected(aNhh4Cgs == null ? null : aNhh4Cgs.toURI().toURL());
                } catch (MalformedURLException VpF4OOh4) {
                }
            }
        });
        author.setEnabled(false);
        title.setEnabled(false);
        difficulty.setEnabled(false);
        save.setEnabled(false);
        JButton rWwuYhOc;
        DO2uWnnd.add(RAqzN0v4 = new JPanel(), BorderLayout.WEST);
        RAqzN0v4.add(rWwuYhOc = new JButton());
        Util.updateButtonText(rWwuYhOc, "Import");
        rWwuYhOc.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent BJubYFG2) {
                final File RhgwbN5B = KeyboardHero.midiFile();
                try {
                    if (RhgwbN5B == null) return;
                    final File uEhLGnP9 = (new File(Util.DATA_FOLDER + MidiSong.MIDI_FILES_DIR));
                    if (uEhLGnP9.exists()) {
                        if (!uEhLGnP9.isDirectory()) {
                            Util.error(Util.getMsg("Err_MidiFilesDirNotDirectory"), uEhLGnP9.getParent());
                            return;
                        }
                    } else if (!uEhLGnP9.mkdirs()) {
                        Util.error(Util.getMsg("Err_CouldntMkDir"), uEhLGnP9.getParent());
                        return;
                    }
                    File vv4Uo4uq = new File(uEhLGnP9.getPath() + File.separator + RhgwbN5B.getName());
                    if (!vv4Uo4uq.exists() || KeyboardHero.confirm("Que_FileExistsOverwrite")) {
                        final FileChannel Z3LwT71o = new FileInputStream(RhgwbN5B).getChannel();
                        Z3LwT71o.transferTo(0, Z3LwT71o.size(), new FileOutputStream(vv4Uo4uq).getChannel());
                    }
                } catch (Exception npc24gUb) {
                    Util.getMsg(Util.getMsg("Err_CouldntImportSong"), npc24gUb.toString());
                }
                SongSelector.refresh();
            }
        });
        RAqzN0v4.add(rWwuYhOc = new JButton());
        Util.updateButtonText(rWwuYhOc, "Delete");
        rWwuYhOc.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent xNM3MKoi) {
                if (KeyboardHero.confirm(Util.getMsg("Que_SureToDelete"))) {
                    try {
                        new File(songSelector.getSelectedFile().toURI()).delete();
                    } catch (Exception ET42N3GP) {
                        Util.error(Util.getMsg("Err_CouldntDeleteFile"), ET42N3GP.toString());
                    }
                    SongSelector.refresh();
                }
            }
        });
        DO2uWnnd.add(RAqzN0v4 = new JPanel(), BorderLayout.CENTER);
        RAqzN0v4.setLayout(new FlowLayout());
        RAqzN0v4.add(rWwuYhOc = new JButton());
        Util.updateButtonText(rWwuYhOc, "Close");
        rWwuYhOc.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent kpcLLjSv) {
                close();
            }
        });
        RAqzN0v4.add(rWwuYhOc = new JButton());
        Util.updateButtonText(rWwuYhOc, "Play");
        rWwuYhOc.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent kG9LakQO) {
                Game.newGame(songSelector.getSelectedFile());
                close();
            }
        });
        DO2uWnnd.add(RAqzN0v4 = new JPanel(), BorderLayout.EAST);
        RAqzN0v4.add(rWwuYhOc = new JButton());
        Util.updateButtonText(rWwuYhOc, "Refresh");
        rWwuYhOc.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent LhuZQlHd) {
                SongSelector.refresh();
            }
        });
        getRootPane().setDefaultButton(rWwuYhOc);
        instance = this;
    }

}