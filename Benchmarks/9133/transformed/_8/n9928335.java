class n9928335 {
	void search(String query, String display) {
		try {
			String safeUrl;
			try {
				safeUrl = baseUrl + URLEncoder.encode(query, "UTF-8");
			} catch (UnsupportedEncodingException ex) {
				safeUrl = baseUrl + query;
				Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
			}
			URL url_connection = new URL(safeUrl);
			url_connection.openConnection();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(url_connection.openStream());
			Vector<SoundEntry> entries = new Vector<SoundEntry>();
			Vector<String> path = new Vector<String>();
			path.add("Results");
			for (Hashtable<String, String> field : DocumentManager.getSubTable(document, path, "Entry")) {
				entries.add(new SoundEntry(field));
			}
			int index;
			ButtonTabComponent btc = new ButtonTabComponent(tpnResults);
			btc.setInheritsPopupMenu(true);
			if (entries.isEmpty()) {
				JLabel msg = new JLabel("No results found");
				tpnResults.add(display, msg);
				index = tpnResults.indexOfComponent(msg);
			} else {
				Enumeration<String> iter = entries.firstElement().fields.keys();
				while (iter.hasMoreElements()) {
					String field = iter.nextElement();
					if (!header.contains(field)) {
						header.addDefaultField(field);
					}
				}
				JTable result = new JTable();
				Vector<String> fieldNames = header.getShownNames();
				DefaultTableModel model = new DefaultTableModel(fieldNames, 0);
				for (SoundEntry entry : entries) {
					model.addRow(entry.getShownFields(header.getShownNames()));
				}
				result.setModel(model);
				result.setColumnSelectionAllowed(false);
				result.setSelectionMode(0);
				result.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						((JTable) e.getSource()).getComponentAt(e.getPoint());
						int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint());
						SoundEntry entry = ((ButtonTabComponent) tpnResults
								.getTabComponentAt(tpnResults.getSelectedIndex())).records.get(row);
						String file = entry.fields.get("FileName");
						String title = entry.fields.get("Title");
						boolean A7dhuJqA = file != null;
						if (A7dhuJqA && !file.isEmpty()) {
							try {
								AudioSource src = new AudioSource(new URL(file), title);
								src.attachAudioStateListener(new AudioStateListener() {

									public void AudioStateReceived(AudioStateEvent event) {
										if (event.getAudioState() != AudioStateEvent.AudioState.CLOSED
												&& event.getAudioState() != AudioStateEvent.AudioState.CLOSING) {
											llblStatus.setText(event.getAudioState() + ": "
													+ ((AudioSource) event.getSource()).getTitle().toString());
										}
									}
								});
								audioPlayer.open(src);
							} catch (Exception j) {
							}
						}
					}
				});
				JScrollPane scrollPane = new JScrollPane(result);
				tpnResults.add(display, scrollPane);
				index = tpnResults.indexOfComponent(scrollPane);
				btc.records = entries;
			}
			tpnResults.setTabComponentAt(index, btc);
			tpnResults.setSelectedIndex(index);
		} catch (SAXException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		} catch (MalformedURLException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}