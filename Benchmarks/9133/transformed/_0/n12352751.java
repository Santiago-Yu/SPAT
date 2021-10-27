class n12352751 {
	public void startElement(String HG1EHeq2, String p60jnsQ1, String GVP4xnCo, org.xml.sax.Attributes cmyeqXwf)
			throws SAXException {
		wabclient.Attributes b5HvUlCW = new wabclient.Attributes(cmyeqXwf);
		try {
			if (p60jnsQ1.equals("window")) {
				if (b5HvUlCW == null) {
					System.err.println("window without properties");
					return;
				}
				int kKVmkEAG = b5HvUlCW.getValue("x", 0);
				int aNegnLhK = b5HvUlCW.getValue("y", 0);
				int aw8qSkM8 = b5HvUlCW.getValue("width", 0);
				int q5O5uiLp = b5HvUlCW.getValue("height", 0);
				Color y39wVeCd = b5HvUlCW.getValue("bgcolor", Color.white);
				String DugVuGwQ = b5HvUlCW.getValue("caption", "");
				layout = b5HvUlCW.getValue("layout", 0);
				boolean VfzxKQLG = b5HvUlCW.getValue("statusbar", false);
				if (sheet.opentype == WABSheet.LAYERED) {
					Point HUszllhs = frame.getNextMDIPos();
					sheet.setBounds(HUszllhs.x, HUszllhs.y, 400, 200);
					sheet.setNormalBounds(new Rectangle(HUszllhs.x, HUszllhs.y, 400, 200));
				} else {
					sheet.setBounds(kKVmkEAG, aNegnLhK, aw8qSkM8, q5O5uiLp);
					sheet.setNormalBounds(new Rectangle(kKVmkEAG, aNegnLhK, aw8qSkM8, q5O5uiLp));
				}
				if (sheet.opentype == WABSheet.MAXIMIZED)
					sheet.setMaximum(true);
				else
					sheet.setMaximum(false);
				sheet.setTitle(DugVuGwQ);
				frame.addSheetToMenu(DugVuGwQ);
				sheet.setBackground(y39wVeCd);
				if (layout == 1)
					sheet.getContentPane().setLayout(new FlowLayout());
				else if (layout == 2)
					sheet.getContentPane().setLayout(new BorderLayout());
				else
					sheet.getContentPane().setLayout(null);
			} else if (p60jnsQ1.equals("menu")) {
				if (b5HvUlCW == null) {
					System.err.println("menu without properties");
					return;
				}
				String CcMW3JZk = b5HvUlCW.getValue("id", "");
				String WNTdVfTn = b5HvUlCW.getValue("label", "");
				if ((CcMW3JZk != null && CcMW3JZk.equals("WINDOW_MENU") || WNTdVfTn.equalsIgnoreCase("window"))) {
					windowMenu = new JMenu();
					menu = windowMenu;
					sheet.setWindowMenu(menu);
				} else {
					menu = new JMenu();
				}
				menu.setText(WNTdVfTn);
				sheet.menubar.add(menu);
			} else if (p60jnsQ1.equals("menuitem")) {
				if (b5HvUlCW == null) {
					System.err.println("menuitem without properties");
					return;
				}
				JMenuItem VERGhy64;
				String ry0QNZ0F = b5HvUlCW.getValue("action", "");
				String f3JBkthT = b5HvUlCW.getValue("label", "");
				boolean RCvvOUaS = b5HvUlCW.getValue("visible", true);
				String N2kTXCqv = b5HvUlCW.getValue("icon", "");
				if (ry0QNZ0F.equals("WINDOW_OVERLAPPED")) {
					VERGhy64 = windowMenuOverlapped = new JMenuItem();
					VERGhy64.setActionCommand("10001");
					VERGhy64.addActionListener(frame);
				} else if (ry0QNZ0F.equals("WINDOW_TILE_HORIZONTALLY")) {
					VERGhy64 = windowMenuTile = new JMenuItem();
					VERGhy64.setActionCommand("10002");
					VERGhy64.addActionListener(frame);
				} else if (ry0QNZ0F.equals("WINDOW_TILE_VERTICALLY")) {
					VERGhy64 = windowMenuArrange = new JMenuItem();
					VERGhy64.setActionCommand("10003");
					VERGhy64.addActionListener(frame);
				} else {
					VERGhy64 = new JMenuItem();
					VERGhy64.setActionCommand(ry0QNZ0F);
					VERGhy64.addActionListener((WABClient) global);
				}
				VERGhy64.setText(f3JBkthT);
				if (!RCvvOUaS)
					menu.setVisible(false);
				menu.add(VERGhy64);
				if (frame.getToolBar() != null) {
					if (N2kTXCqv.length() > 0) {
						try {
							ImageIcon TWwLNU6s = new ImageIcon(new URL(N2kTXCqv));
							BufferedImage cdmvdu17 = new BufferedImage(25, 25, BufferedImage.TYPE_4BYTE_ABGR);
							Graphics lEKfLpAB = cdmvdu17.createGraphics();
							lEKfLpAB.setColor(new Color(0, 0, 0, 0));
							lEKfLpAB.fillRect(0, 0, 25, 25);
							lEKfLpAB.drawImage(TWwLNU6s.getImage(), 4, 4, 16, 16, (ImageObserver) null);
							BufferedImage fc9kyukN = new BufferedImage(25, 25, BufferedImage.TYPE_4BYTE_ABGR);
							lEKfLpAB = fc9kyukN.createGraphics();
							lEKfLpAB.setColor(new Color(0, 0, 0, 0));
							lEKfLpAB.fillRect(0, 0, 25, 25);
							lEKfLpAB.drawImage(TWwLNU6s.getImage(), 5, 5, 16, 16, (ImageObserver) null);
							lEKfLpAB.setColor(new Color(132, 132, 132));
							lEKfLpAB.drawLine(0, 0, 24, 0);
							lEKfLpAB.drawLine(0, 0, 0, 24);
							lEKfLpAB.setColor(new Color(255, 255, 255));
							lEKfLpAB.drawLine(24, 24, 24, 0);
							lEKfLpAB.drawLine(24, 24, 0, 24);
							BufferedImage nSkJa0cq = new BufferedImage(25, 25, BufferedImage.TYPE_4BYTE_ABGR);
							lEKfLpAB = nSkJa0cq.createGraphics();
							lEKfLpAB.setColor(new Color(0, 0, 0, 0));
							lEKfLpAB.fillRect(0, 0, 25, 25);
							lEKfLpAB.drawImage(TWwLNU6s.getImage(), 4, 4, 16, 16, (ImageObserver) null);
							lEKfLpAB.setColor(new Color(255, 255, 255));
							lEKfLpAB.drawLine(0, 0, 24, 0);
							lEKfLpAB.drawLine(0, 0, 0, 24);
							lEKfLpAB.setColor(new Color(132, 132, 132));
							lEKfLpAB.drawLine(24, 24, 24, 0);
							lEKfLpAB.drawLine(24, 24, 0, 24);
							JButton ZVULB12U = new JButton(new ImageIcon(cdmvdu17));
							ZVULB12U.setRolloverEnabled(true);
							ZVULB12U.setPressedIcon(new ImageIcon(fc9kyukN));
							ZVULB12U.setRolloverIcon(new ImageIcon(nSkJa0cq));
							ZVULB12U.setToolTipText(f3JBkthT);
							ZVULB12U.setActionCommand(ry0QNZ0F);
							ZVULB12U.setFocusPainted(false);
							ZVULB12U.setBorderPainted(false);
							ZVULB12U.setContentAreaFilled(false);
							ZVULB12U.setMargin(new Insets(0, 0, 0, 0));
							ZVULB12U.addActionListener(sheet);
							sheet.toolbar.add(ZVULB12U);
						} catch (Exception Yrptp8Nt) {
						}
					}
				}
			} else if (p60jnsQ1.equals("separator")) {
				menu.addSeparator();
			} else if (p60jnsQ1.equals("choice")) {
				if (b5HvUlCW == null) {
					System.err.println("choice without properties");
					return;
				}
				combo = new JComboBox();
				list = null;
				int RjJEw42r = b5HvUlCW.getValue("x", 0);
				int Rn8jaYKZ = b5HvUlCW.getValue("y", 0);
				int JQ0aQkbE = b5HvUlCW.getValue("width", 0);
				int HY0wCtnK = b5HvUlCW.getValue("height", 0);
				String ONg2femk = b5HvUlCW.getValue("id", "");
				Object p9ExCPJQ = b5HvUlCW.getValue("constraints");
				boolean Qo2ww35F = b5HvUlCW.getValue("editable", false);
				boolean oXLYPZKo = b5HvUlCW.getValue("visible", true);
				boolean QUIStxg1 = b5HvUlCW.getValue("enabled", true);
				combo_text = b5HvUlCW.getValue("text", "");
				combo.setBounds(RjJEw42r, Rn8jaYKZ, JQ0aQkbE, HY0wCtnK);
				combo.setName((String) ONg2femk);
				if (Qo2ww35F) {
					combo.setEditable(Qo2ww35F);
					combo.setSelectedItem(combo_text);
				}
				if (!oXLYPZKo)
					combo.setVisible(false);
				if (!QUIStxg1)
					combo.setEnabled(false);
				if (layout == 0)
					sheet.getContentPane().add(combo);
				else
					sheet.getContentPane().add(combo, p9ExCPJQ);
			} else if (p60jnsQ1.equals("list")) {
				if (b5HvUlCW == null) {
					System.err.println("list without properties");
					return;
				}
				list = new JList();
				combo = null;
				listdata = new Vector();
				int dIPbMghz = b5HvUlCW.getValue("x", 0);
				int L0kwb4Oh = b5HvUlCW.getValue("y", 0);
				int VaUAJPLG = b5HvUlCW.getValue("width", 0);
				int I5UD9xbq = b5HvUlCW.getValue("height", 0);
				String Q5WrLB18 = b5HvUlCW.getValue("id", "");
				Object XKVOYKSe = b5HvUlCW.getValue("constraints");
				list.setName((String) Q5WrLB18);
				list.setListData(listdata);
				JScrollPane qzcdQvnt = new JScrollPane(list);
				qzcdQvnt.setBounds(dIPbMghz, L0kwb4Oh, VaUAJPLG, I5UD9xbq);
				if (layout == 0)
					sheet.getContentPane().add(qzcdQvnt);
				else
					sheet.getContentPane().add(qzcdQvnt, XKVOYKSe);
			} else if (p60jnsQ1.equals("option")) {
				if (b5HvUlCW == null) {
					System.err.println("choice.option without properties");
					return;
				}
				String RGDPMYSJ = b5HvUlCW.getValue("value", "");
				String rhzelzXH = b5HvUlCW.getValue("text", "");
				if (list != null)
					listdata.addElement(new ComboOption(rhzelzXH, RGDPMYSJ));
				if (combo != null) {
					ComboOption k5bdlg57 = new ComboOption(rhzelzXH, RGDPMYSJ);
					combo.addItem(k5bdlg57);
					if (combo_text.equals(rhzelzXH.trim()))
						combo.setSelectedItem(k5bdlg57);
				}
			} else if (p60jnsQ1.equals("label")) {
				if (b5HvUlCW == null) {
					System.err.println("label without properties");
					return;
				}
				JLabel osJGKVf9 = new JLabel();
				int bZTpCfVc = b5HvUlCW.getValue("x", 0);
				int mZGF1M09 = b5HvUlCW.getValue("y", 0);
				int BMAA1pFn = b5HvUlCW.getValue("width", 0);
				int QdxIOS9r = b5HvUlCW.getValue("height", 0);
				String T6iJfABv = b5HvUlCW.getValue("text", "");
				Object LSrlDAlv = b5HvUlCW.getValue("constraints");
				boolean O5GoLBR5 = b5HvUlCW.getValue("visible", true);
				osJGKVf9.setBounds(bZTpCfVc, mZGF1M09, BMAA1pFn, QdxIOS9r);
				osJGKVf9.setText(T6iJfABv);
				if (!O5GoLBR5)
					osJGKVf9.setVisible(false);
				if (layout == 0)
					sheet.getContentPane().add(osJGKVf9);
				else
					sheet.getContentPane().add(osJGKVf9, LSrlDAlv);
			} else if (p60jnsQ1.equals("button")) {
				if (b5HvUlCW == null) {
					System.err.println("button without properties");
					return;
				}
				JButton Kyk3nprt = new JButton();
				int bYkaog8u = b5HvUlCW.getValue("x", 0);
				int sDSCBtMN = b5HvUlCW.getValue("y", 0);
				int kyE7HCud = b5HvUlCW.getValue("width", 0);
				int hjuFmZ4E = b5HvUlCW.getValue("height", 0);
				String oYMwyh4X = b5HvUlCW.getValue("id", "");
				String LCnXQziM = b5HvUlCW.getValue("text", "");
				String hi4jX4an = b5HvUlCW.getValue("onmouseup", "");
				Object oEFkY6JB = b5HvUlCW.getValue("constraints");
				Kyk3nprt.setBounds(bYkaog8u, sDSCBtMN, kyE7HCud, hjuFmZ4E);
				Kyk3nprt.setText(LCnXQziM);
				Kyk3nprt.addActionListener(sheet);
				Kyk3nprt.setActionCommand(hi4jX4an);
				if (layout == 0)
					sheet.getContentPane().add(Kyk3nprt);
				else
					sheet.getContentPane().add(Kyk3nprt, oEFkY6JB);
			} else if (p60jnsQ1.equals("radiobutton")) {
				if (b5HvUlCW == null) {
					System.err.println("radiobutton without properties");
					return;
				}
				JRadioButton AoeOFzae = new JRadioButton();
				int MWh7m7Aa = b5HvUlCW.getValue("x", 0);
				int xTZI1TPj = b5HvUlCW.getValue("y", 0);
				int oQF5Y64W = b5HvUlCW.getValue("width", 0);
				int lqUT9WE5 = b5HvUlCW.getValue("height", 0);
				String r7RhEhO8 = b5HvUlCW.getValue("id", "");
				String jiwN2Iyp = b5HvUlCW.getValue("text", "");
				Object QGXeMkJU = b5HvUlCW.getValue("constraints");
				String IoSG2RwK = b5HvUlCW.getValue("checked", "false");
				AoeOFzae.setBounds(MWh7m7Aa, xTZI1TPj, oQF5Y64W, lqUT9WE5);
				AoeOFzae.setText(jiwN2Iyp);
				AoeOFzae.setName((String) r7RhEhO8);
				AoeOFzae.addActionListener(sheet);
				AoeOFzae.setSelected(IoSG2RwK.equalsIgnoreCase("true"));
				if (layout == 0)
					sheet.getContentPane().add(AoeOFzae);
				else
					sheet.getContentPane().add(AoeOFzae, QGXeMkJU);
			} else if (p60jnsQ1.equals("checkbox")) {
				if (b5HvUlCW == null) {
					System.err.println("checkbox without properties");
					return;
				}
				JCheckBox jel2Aq7r = new JCheckBox();
				int nhpc1FkY = b5HvUlCW.getValue("x", 0);
				int Tj9UAcd9 = b5HvUlCW.getValue("y", 0);
				int MhNTCJqs = b5HvUlCW.getValue("width", 0);
				int c2xqjZM1 = b5HvUlCW.getValue("height", 0);
				String L4NjqWU0 = b5HvUlCW.getValue("id", "");
				String uLxNwfFH = b5HvUlCW.getValue("text", "");
				String XTzJ5T7B = b5HvUlCW.getValue("onmouseup", "");
				Object ILXJgUHD = b5HvUlCW.getValue("constraints");
				String bAtLvXri = b5HvUlCW.getValue("checked", "false");
				jel2Aq7r.setBounds(nhpc1FkY, Tj9UAcd9, MhNTCJqs, c2xqjZM1);
				jel2Aq7r.setText(uLxNwfFH);
				jel2Aq7r.setName((String) L4NjqWU0);
				jel2Aq7r.setSelected(bAtLvXri.equalsIgnoreCase("true"));
				if (layout == 0)
					sheet.getContentPane().add(jel2Aq7r);
				else
					sheet.getContentPane().add(jel2Aq7r, ILXJgUHD);
			} else if (p60jnsQ1.equals("image")) {
				if (b5HvUlCW == null) {
					System.err.println("image without properties");
					return;
				}
				JLabel smQvs2UC = new JLabel();
				int ZJPhWosk = b5HvUlCW.getValue("x", 0);
				int mMpNnUQA = b5HvUlCW.getValue("y", 0);
				int euWUapGL = b5HvUlCW.getValue("width", 0);
				int zDHT0kor = b5HvUlCW.getValue("height", 0);
				String Rd2X2hk2 = b5HvUlCW.getValue("src", "");
				Object g0LQ0eCu = b5HvUlCW.getValue("constraints");
				smQvs2UC.setIcon(new ImageIcon(new URL(Rd2X2hk2)));
				smQvs2UC.setBounds(ZJPhWosk, mMpNnUQA, euWUapGL, zDHT0kor);
				if (layout == 0)
					sheet.getContentPane().add(smQvs2UC);
				else
					sheet.getContentPane().add(smQvs2UC, g0LQ0eCu);
			} else if (p60jnsQ1.equals("singlelineedit")) {
				if (b5HvUlCW == null) {
					System.err.println("singlelineedit without properties");
					return;
				}
				String GfTswqNi = b5HvUlCW.getValue("password", "");
				JTextField dSdwIF8V;
				if (GfTswqNi.equalsIgnoreCase("true"))
					dSdwIF8V = new JPasswordField();
				else
					dSdwIF8V = new JTextField();
				int hTCr1Fpu = b5HvUlCW.getValue("x", 0);
				int m6RHOqwP = b5HvUlCW.getValue("y", 0);
				int u28dA986 = b5HvUlCW.getValue("width", 0);
				int xUng0xop = b5HvUlCW.getValue("height", 0);
				Object W31Qlw7J = b5HvUlCW.getValue("id");
				String Xiyf5364 = b5HvUlCW.getValue("text", "");
				Object DASN5zeL = b5HvUlCW.getValue("constraints");
				dSdwIF8V.setBounds(hTCr1Fpu, m6RHOqwP, u28dA986, xUng0xop);
				dSdwIF8V.setText(Xiyf5364);
				dSdwIF8V.setName((String) W31Qlw7J);
				if (layout == 0)
					sheet.getContentPane().add(dSdwIF8V);
				else
					sheet.getContentPane().add(dSdwIF8V, DASN5zeL);
			} else if (p60jnsQ1.equals("treeview")) {
				if (b5HvUlCW == null) {
					System.err.println("treeview without properties");
					return;
				}
				treeview_root = new DefaultMutableTreeNode("root");
				treeview = new JTree(treeview_root);
				Object u1GpZ5Cx = b5HvUlCW.getValue("constraints");
				sheet.getContentPane().add(new JScrollPane(treeview), u1GpZ5Cx);
			} else if (p60jnsQ1.equals("treeitem")) {
				if (b5HvUlCW == null) {
					System.err.println("treeview.treeitem without properties");
					return;
				}
				String wMUWnhxi = b5HvUlCW.getValue("text", "");
				String A2LAqhEP = b5HvUlCW.getValue("value", "");
				DefaultMutableTreeNode rLuRDPc3 = new DefaultMutableTreeNode(wMUWnhxi);
				treeview_root.add(rLuRDPc3);
			} else if (p60jnsQ1.equals("table")) {
				if (b5HvUlCW == null) {
					System.err.println("table without properties");
					return;
				}
				String ukp1PkB1 = b5HvUlCW.getValue("id", "");
				table = new JTable();
				model = new DefaultTableModel() {

					public boolean isCellEditable(int rk8eMV5l, int hJdzkxuA) {
						return false;
					}
				};
				table.setModel(model);
				table.setName((String) ukp1PkB1);
				Object Mgdg5Sx8 = b5HvUlCW.getValue("constraints");
				sheet.getContentPane().add(new JScrollPane(table), Mgdg5Sx8);
				rowNumber = 0;
				columnNumber = 0;
				headerWidths = new Vector();
			} else if (p60jnsQ1.equals("header")) {
				if (b5HvUlCW == null) {
					System.err.println("table.header without properties");
					return;
				}
				String RDH091yh = b5HvUlCW.getValue("text", "");
				int Qo5PCAJX = b5HvUlCW.getValue("width", 0);
				headerWidths.addElement(new Integer(Qo5PCAJX));
				model.addColumn(RDH091yh);
			} else if (p60jnsQ1.equals("row")) {
				rowNumber++;
				columnNumber = 0;
				model.setRowCount(rowNumber);
			} else if (p60jnsQ1.equals("column")) {
				columnNumber++;
				if (b5HvUlCW == null) {
					System.err.println("table.column without properties");
					return;
				}
				String g6129XOp = b5HvUlCW.getValue("value", "");
				model.setValueAt(g6129XOp, rowNumber - 1, columnNumber - 1);
			} else if (p60jnsQ1.equals("script")) {
				sheet.beginScript();
				String gxXLdRkY = b5HvUlCW.getValue("src");
				if (gxXLdRkY.length() > 0) {
					try {
						BufferedReader Cfss4AP4 = new BufferedReader(
								new InputStreamReader(new URL(gxXLdRkY).openStream()));
						String yvxkyZI1;
						while (true) {
							yvxkyZI1 = Cfss4AP4.readLine();
							if (yvxkyZI1 == null)
								break;
							sheet.script += yvxkyZI1 + "\n";
						}
						Cfss4AP4.close();
						sheet.endScript();
					} catch (IOException p5QbgX6s) {
						System.err.println("[IOError] " + p5QbgX6s.getMessage());
						System.exit(0);
					}
				}
			} else
				System.err.println("[sheet] unparsed tag: " + p60jnsQ1);
		} catch (Exception DmgjOBRM) {
			DmgjOBRM.printStackTrace(System.err);
		}
	}

}