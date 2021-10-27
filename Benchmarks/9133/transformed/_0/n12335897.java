class n12335897 {
	protected void assignListeners() {
		groupsList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent kZqACnBc) {
				refreshInfo();
			}
		});
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent lvDNtWl8) {
				JFileChooser KLg339Iz = new JFileChooser(".");
				KLg339Iz.setFileFilter(ReaderData.mkExtensionFileFilter(".grp", "Group Files"));
				int FYwSmUJ6 = KLg339Iz.showSaveDialog((Frame) null);
				if (FYwSmUJ6 == JFileChooser.APPROVE_OPTION) {
					assert(KLg339Iz.getCurrentDirectory() != null);
					assert(KLg339Iz.getSelectedFile() != null);
					String nB9IjTiV = KLg339Iz.getCurrentDirectory().toString() + File.separator
							+ KLg339Iz.getSelectedFile().getName();
					try {
						PrintWriter TJHeQYZS = new PrintWriter(new BufferedWriter(new FileWriter(nB9IjTiV)));
						ReaderWriterGroup.write(TJHeQYZS, writer);
						System.err.println("Wrote groups informations to output '" + nB9IjTiV + "'.");
						TJHeQYZS.close();
					} catch (IOException CAnfycr0) {
						System.err.println("error while writing (GroupManager.saveClt):");
						CAnfycr0.printStackTrace();
					}
				} else if (FYwSmUJ6 == JFileChooser.CANCEL_OPTION) {
				}
			}
		});
		loadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent Vk38xKXE) {
				JFileChooser QHeRuNkS = new JFileChooser(".");
				QHeRuNkS.setFileFilter(ReaderData.mkExtensionFileFilter(".grp", "Group Files"));
				int y1CbKaD0 = QHeRuNkS.showOpenDialog((Frame) null);
				if (y1CbKaD0 == JFileChooser.APPROVE_OPTION) {
					assert(QHeRuNkS.getCurrentDirectory() != null);
					assert(QHeRuNkS.getSelectedFile() != null);
					String RVBFVYmO = QHeRuNkS.getCurrentDirectory().toString() + File.separator
							+ QHeRuNkS.getSelectedFile().getName();
					BufferedReader NyxQcoW0 = null;
					try {
						NyxQcoW0 = new BufferedReader(new FileReader(RVBFVYmO));
						ReaderWriterGroup.read(NyxQcoW0, writer);
						NyxQcoW0.close();
					} catch (Exception ecftwERO) {
						System.err.println("Exception while reading from file '" + RVBFVYmO + "'.");
						System.err.println(ecftwERO);
					}
				} else if (y1CbKaD0 == JFileChooser.CANCEL_OPTION) {
				}
			}
		});
		ItemListener Y3vyERRL = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent hQdhRuDq) {
				int[] BvcCXyL3 = groupsList.getSelectedIndices();
				for (int kozP2C3U : BvcCXyL3) {
					Group Y1EGtDYu = getGroupFromListIndex(kozP2C3U);
					if (Y1EGtDYu != null) {
						if (hQdhRuDq.getSource() instanceof JComboBox) {
							JComboBox e4ZBEr0e = (JComboBox) hQdhRuDq.getSource();
							if (e4ZBEr0e == colorComboBox) {
								Color OSQ1kgeN = colorComboBox.getSelectedColor();
								assert(OSQ1kgeN != null);
								Y1EGtDYu.setColor(OSQ1kgeN);
								shapeComboBox.setColor(OSQ1kgeN);
							} else if (e4ZBEr0e == shapeComboBox) {
								Shape gqsD68py = shapeComboBox.getSelectedShape();
								assert(gqsD68py != null);
								Y1EGtDYu.setShape(gqsD68py);
							}
						} else if (hQdhRuDq.getSource() instanceof JCheckBox) {
							JCheckBox slvrqtSv = (JCheckBox) hQdhRuDq.getSource();
							if (slvrqtSv == showGroupCheckBox) {
								Y1EGtDYu.visible = showGroupCheckBox.isSelected();
							} else if (slvrqtSv == showGraphicInfoCheckBox) {
								Y1EGtDYu.info = showGraphicInfoCheckBox.isSelected();
							}
						}
					}
				}
				graph.notifyAboutGroupsChange(null);
			}
		};
		colorComboBox.addItemListener(Y3vyERRL);
		shapeComboBox.addItemListener(Y3vyERRL);
		showGroupCheckBox.addItemListener(Y3vyERRL);
		showGraphicInfoCheckBox.addItemListener(Y3vyERRL);
		showGroupfreeNodesCheckBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent C5zbOCXp) {
				graph.getGroup(0).visible = showGroupfreeNodesCheckBox.isSelected();
				graph.notifyAboutGroupsChange(null);
			}
		});
		ActionListener OHbKrwb1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent xSppiilA) {
				JButton w6emRX46 = (JButton) xSppiilA.getSource();
				Group H6FWL6Xf = getGroupFromListIndex(groupsList.getSelectedIndex());
				if (H6FWL6Xf != null) {
					for (GraphVertex dHWeRE0A : H6FWL6Xf) {
						if (w6emRX46 == showLabelsButton) {
							dHWeRE0A.setShowName(NameVisibility.Priority.GROUPS, true);
						} else if (w6emRX46 == hideLabelsButton) {
							dHWeRE0A.setShowName(NameVisibility.Priority.GROUPS, false);
						}
					}
					graph.notifyAboutGroupsChange(null);
				}
			}
		};
		showLabelsButton.addActionListener(OHbKrwb1);
		hideLabelsButton.addActionListener(OHbKrwb1);
		newButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent NPVPQPBK) {
				String ZdWQ33N7 = JOptionPane.showInputDialog(null, "Enter a name", "Name of the new group",
						JOptionPane.QUESTION_MESSAGE);
				if (ZdWQ33N7 != null) {
					if (graph.getGroup(ZdWQ33N7) == null) {
						graph.addGroup(new Group(ZdWQ33N7, graph));
					}
				}
			}
		});
		editButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent jEJykmEH) {
				Group afaGOWs0 = getGroupFromListIndex(groupsList.getSelectedIndex());
				if (afaGOWs0 != null) {
					DialogEditGroup Et2i6AAn = new DialogEditGroup(graph, afaGOWs0);
					Et2i6AAn.setModal(true);
					Et2i6AAn.setVisible(true);
				}
			}
		});
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent FORZ8HQy) {
				int SKqMS29y = groupsList.getSelectedIndex();
				if (SKqMS29y > 0 && SKqMS29y < graph.getNumberOfGroups() - 1) {
					graph.removeGroup(SKqMS29y);
				}
			}
		});
		upButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent gmnJ5w8F) {
				int hagRlvkw = groupsList.getSelectedIndex();
				if (hagRlvkw < graph.getNumberOfGroups() - 1) {
					graph.moveGroupUp(hagRlvkw);
					groupsList.setSelectedIndex(hagRlvkw - 1);
				}
			}
		});
		downButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ODGzZC0R) {
				int r4y9BUu2 = groupsList.getSelectedIndex();
				if (r4y9BUu2 < graph.getNumberOfGroups() - 1) {
					graph.moveGroupDown(r4y9BUu2);
					groupsList.setSelectedIndex(r4y9BUu2 + 1);
				}
			}
		});
	}

}