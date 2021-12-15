class n8330518 {
	public void startElement(String uri, String tag, String qName, org.xml.sax.Attributes attributes)
			throws SAXException {
		wabclient.Attributes prop = new wabclient.Attributes(attributes);
		try {
			if ("window".equals(tag))
				startWindow(prop);
			else if ("splitpanel".equals(tag))
				startSplitPanel(prop);
			else if ("desktoppane".equals(tag))
				startDesktopPane(prop);
			else if ("tabcontrol".equals(tag))
				startTabcontrol(prop);
			else if ("panel".equals(tag))
				startPanel(prop);
			else if ("statusbar".equals(tag))
				startStatusbar(prop);
			else if ("toolbar".equals(tag))
				startToolbar(prop);
			else if ("toolbarbutton".equals(tag))
				startToolbarbutton(prop);
			else if ("menu".equals(tag))
				startMenu(prop);
			else if ("menuitem".equals(tag))
				startMenuitem(prop);
			else if ("separator".equals(tag))
				menu.addSeparator();
			else if ("choice".equals(tag))
				startChoice(prop);
			else if ("list".equals(tag))
				startList(prop);
			else if ("option".equals(tag))
				startOption(prop);
			else if ("label".equals(tag))
				startLabel(prop);
			else if ("button".equals(tag))
				startButton(prop);
			else if ("groupbox".equals(tag))
				startGroupbox(prop);
			else if ("radiobutton".equals(tag))
				startRadioButton(prop);
			else if ("checkbox".equals(tag))
				startCheckbox(prop);
			else if ("image".equals(tag))
				startImage(prop);
			else if ("textarea".equals(tag))
				startTextArea(prop);
			else if ("singlelineedit".equals(tag))
				startSingleLineEdit(prop);
			else if ("treeview".equals(tag))
				startTreeview(prop);
			else if ("treeitem".equals(tag))
				startTreeitem(prop);
			else if ("table".equals(tag))
				startTable(prop);
			else if ("header".equals(tag))
				startHeader(prop);
			else if ("row".equals(tag)) {
				rowNumber++;
				columnNumber = 0;
				model.addRow();
			} else if ("column".equals(tag)) {
				columnNumber++;
				if (prop == null) {
					System.err.println("table.column without properties");
					return;
				}
				String value = prop.getValue("value", "");
				model.setValueAt(value, rowNumber - 1, columnNumber - 1);
			} else if ("rmbmenuitem".equals(tag)) {
				if (prop == null) {
					System.err.println("datawindow.menuitem without properties");
					return;
				}
				String action = prop.getValue("action", "");
				String label = prop.getValue("label", "");
				JMenuItem mi = new JMenuItem(label);
				mi.setActionCommand(action);
				mi.addActionListener(win);
				rmbmenu.add(mi);
			} else if ("rmbseparator".equals(tag)) {
				rmbmenu.addSeparator();
			} else if ("script".equals(tag)) {
				win.beginScript();
				String url = prop.getValue("src");
				if (url.length() > 0) {
					try {
						BufferedReader r = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
						String buffer;
						while (true) {
							buffer = r.readLine();
							if (buffer == null)
								break;
							win.script += buffer + "\n";
						}
						r.close();
						win.endScript();
					} catch (IOException ioe) {
						System.err.println("[IOError] " + ioe.getMessage());
						System.exit(0);
					}
				}
			} else
				System.err.println("[win] unparsed tag: " + tag);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

}