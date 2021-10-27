class n8330518 {
	public void startElement(String wvJRxURS, String UjO00uK8, String wP5ZkPFc, org.xml.sax.Attributes r4uqVBJ6)
			throws SAXException {
		wabclient.Attributes z9nqSKJO = new wabclient.Attributes(r4uqVBJ6);
		try {
			if (UjO00uK8.equals("window"))
				startWindow(z9nqSKJO);
			else if (UjO00uK8.equals("splitpanel"))
				startSplitPanel(z9nqSKJO);
			else if (UjO00uK8.equals("desktoppane"))
				startDesktopPane(z9nqSKJO);
			else if (UjO00uK8.equals("tabcontrol"))
				startTabcontrol(z9nqSKJO);
			else if (UjO00uK8.equals("panel"))
				startPanel(z9nqSKJO);
			else if (UjO00uK8.equals("statusbar"))
				startStatusbar(z9nqSKJO);
			else if (UjO00uK8.equals("toolbar"))
				startToolbar(z9nqSKJO);
			else if (UjO00uK8.equals("toolbarbutton"))
				startToolbarbutton(z9nqSKJO);
			else if (UjO00uK8.equals("menu"))
				startMenu(z9nqSKJO);
			else if (UjO00uK8.equals("menuitem"))
				startMenuitem(z9nqSKJO);
			else if (UjO00uK8.equals("separator"))
				menu.addSeparator();
			else if (UjO00uK8.equals("choice"))
				startChoice(z9nqSKJO);
			else if (UjO00uK8.equals("list"))
				startList(z9nqSKJO);
			else if (UjO00uK8.equals("option"))
				startOption(z9nqSKJO);
			else if (UjO00uK8.equals("label"))
				startLabel(z9nqSKJO);
			else if (UjO00uK8.equals("button"))
				startButton(z9nqSKJO);
			else if (UjO00uK8.equals("groupbox"))
				startGroupbox(z9nqSKJO);
			else if (UjO00uK8.equals("radiobutton"))
				startRadioButton(z9nqSKJO);
			else if (UjO00uK8.equals("checkbox"))
				startCheckbox(z9nqSKJO);
			else if (UjO00uK8.equals("image"))
				startImage(z9nqSKJO);
			else if (UjO00uK8.equals("textarea"))
				startTextArea(z9nqSKJO);
			else if (UjO00uK8.equals("singlelineedit"))
				startSingleLineEdit(z9nqSKJO);
			else if (UjO00uK8.equals("treeview"))
				startTreeview(z9nqSKJO);
			else if (UjO00uK8.equals("treeitem"))
				startTreeitem(z9nqSKJO);
			else if (UjO00uK8.equals("table"))
				startTable(z9nqSKJO);
			else if (UjO00uK8.equals("header"))
				startHeader(z9nqSKJO);
			else if (UjO00uK8.equals("row")) {
				rowNumber++;
				columnNumber = 0;
				model.addRow();
			} else if (UjO00uK8.equals("column")) {
				columnNumber++;
				if (z9nqSKJO == null) {
					System.err.println("table.column without properties");
					return;
				}
				String GQ9HEJhc = z9nqSKJO.getValue("value", "");
				model.setValueAt(GQ9HEJhc, rowNumber - 1, columnNumber - 1);
			} else if (UjO00uK8.equals("rmbmenuitem")) {
				if (z9nqSKJO == null) {
					System.err.println("datawindow.menuitem without properties");
					return;
				}
				String ZVdWPJMH = z9nqSKJO.getValue("action", "");
				String aWPnSRkj = z9nqSKJO.getValue("label", "");
				JMenuItem MyNV8C3T = new JMenuItem(aWPnSRkj);
				MyNV8C3T.setActionCommand(ZVdWPJMH);
				MyNV8C3T.addActionListener(win);
				rmbmenu.add(MyNV8C3T);
			} else if (UjO00uK8.equals("rmbseparator")) {
				rmbmenu.addSeparator();
			} else if (UjO00uK8.equals("script")) {
				win.beginScript();
				String TWhbHA8v = z9nqSKJO.getValue("src");
				if (TWhbHA8v.length() > 0) {
					try {
						BufferedReader PKabOwQ1 = new BufferedReader(
								new InputStreamReader(new URL(TWhbHA8v).openStream()));
						String IHitXZnI;
						while (true) {
							IHitXZnI = PKabOwQ1.readLine();
							if (IHitXZnI == null)
								break;
							win.script += IHitXZnI + "\n";
						}
						PKabOwQ1.close();
						win.endScript();
					} catch (IOException rPQ7W0oI) {
						System.err.println("[IOError] " + rPQ7W0oI.getMessage());
						System.exit(0);
					}
				}
			} else
				System.err.println("[win] unparsed tag: " + UjO00uK8);
		} catch (Exception ODXm74En) {
			ODXm74En.printStackTrace(System.err);
		}
	}

}