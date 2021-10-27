class n9928335 {
	void search(String VL18oaaN, String rX0nFwpo) {
		try {
			String niJtkDDR;
			try {
				niJtkDDR = baseUrl + URLEncoder.encode(VL18oaaN, "UTF-8");
			} catch (UnsupportedEncodingException a00zQoEH) {
				niJtkDDR = baseUrl + VL18oaaN;
				Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, a00zQoEH);
			}
			URL UZh9CocN = new URL(niJtkDDR);
			UZh9CocN.openConnection();
			DocumentBuilderFactory n39gieYd = DocumentBuilderFactory.newInstance();
			DocumentBuilder yD1sdSo3 = n39gieYd.newDocumentBuilder();
			Document mPM4YuaW = yD1sdSo3.parse(UZh9CocN.openStream());
			Vector<SoundEntry> mPIUCIVK = new Vector<SoundEntry>();
			Vector<String> jsSBYN5C = new Vector<String>();
			jsSBYN5C.add("Results");
			for (Hashtable<String, String> bY586Jzz : DocumentManager.getSubTable(mPM4YuaW, jsSBYN5C, "Entry")) {
				mPIUCIVK.add(new SoundEntry(bY586Jzz));
			}
			int u2ciOOtI;
			ButtonTabComponent P2SZmdlK = new ButtonTabComponent(tpnResults);
			P2SZmdlK.setInheritsPopupMenu(true);
			if (mPIUCIVK.isEmpty()) {
				JLabel mNgXXppT = new JLabel("No results found");
				tpnResults.add(rX0nFwpo, mNgXXppT);
				u2ciOOtI = tpnResults.indexOfComponent(mNgXXppT);
			} else {
				Enumeration<String> P7KnylAr = mPIUCIVK.firstElement().fields.keys();
				while (P7KnylAr.hasMoreElements()) {
					String GSyIXGge = P7KnylAr.nextElement();
					if (!header.contains(GSyIXGge)) {
						header.addDefaultField(GSyIXGge);
					}
				}
				JTable TyZVXJOj = new JTable();
				Vector<String> hPOF5NuO = header.getShownNames();
				DefaultTableModel a15MOoJD = new DefaultTableModel(hPOF5NuO, 0);
				for (SoundEntry WlmuYT1e : mPIUCIVK) {
					a15MOoJD.addRow(WlmuYT1e.getShownFields(header.getShownNames()));
				}
				TyZVXJOj.setModel(a15MOoJD);
				TyZVXJOj.setColumnSelectionAllowed(false);
				TyZVXJOj.setSelectionMode(0);
				TyZVXJOj.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent b9XH3bko) {
						((JTable) b9XH3bko.getSource()).getComponentAt(b9XH3bko.getPoint());
						int HnNiznw2 = ((JTable) b9XH3bko.getSource()).rowAtPoint(b9XH3bko.getPoint());
						SoundEntry V7WhjCTe = ((ButtonTabComponent) tpnResults
								.getTabComponentAt(tpnResults.getSelectedIndex())).records.get(HnNiznw2);
						String B4ByuGCu = V7WhjCTe.fields.get("FileName");
						String vskrcPJd = V7WhjCTe.fields.get("Title");
						if (B4ByuGCu != null && !B4ByuGCu.isEmpty()) {
							try {
								AudioSource gMotTnoI = new AudioSource(new URL(B4ByuGCu), vskrcPJd);
								gMotTnoI.attachAudioStateListener(new AudioStateListener() {

									public void AudioStateReceived(AudioStateEvent r0zMIxAw) {
										if (r0zMIxAw.getAudioState() != AudioStateEvent.AudioState.CLOSED
												&& r0zMIxAw.getAudioState() != AudioStateEvent.AudioState.CLOSING) {
											llblStatus.setText(r0zMIxAw.getAudioState() + ": "
													+ ((AudioSource) r0zMIxAw.getSource()).getTitle().toString());
										}
									}
								});
								audioPlayer.open(gMotTnoI);
							} catch (Exception xor0t2QF) {
							}
						}
					}
				});
				JScrollPane Leoxl4DM = new JScrollPane(TyZVXJOj);
				tpnResults.add(rX0nFwpo, Leoxl4DM);
				u2ciOOtI = tpnResults.indexOfComponent(Leoxl4DM);
				P2SZmdlK.records = mPIUCIVK;
			}
			tpnResults.setTabComponentAt(u2ciOOtI, P2SZmdlK);
			tpnResults.setSelectedIndex(u2ciOOtI);
		} catch (SAXException sdGnFgqQ) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, sdGnFgqQ);
		} catch (ParserConfigurationException nAOjMiiX) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, nAOjMiiX);
		} catch (MalformedURLException jsiBRfWc) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, jsiBRfWc);
		} catch (IOException WIaHe4jO) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, WIaHe4jO);
		}
	}

}