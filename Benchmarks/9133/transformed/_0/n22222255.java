class n22222255 {
	public void doQuery(String FJ7gxFUA, final int zMju5Imp) {
		this.keyword = FJ7gxFUA;
		FJ7gxFUA = FJ7gxFUA.replace(' ', '+');
		commentText = new JTextArea(10, 80);
		final Vector u47imo8N = new Vector();
		int Jfih3K5Y = 0;
		int wBOrOiJP = 0;
		getContentPane().removeAll();
		Vector x3u28SGx = new Vector();
		try {
			String HtcjzFNh = FJ7gxFUA;
			URL L0LzyCoi = new URL(
					"http://www.ensembl.org/Homo_sapiens/textview?idx=External&q=" + FJ7gxFUA + "&page=" + zMju5Imp);
			InputStream qyrxO2rh = L0LzyCoi.openStream();
			BufferedReader ZdXxKvF7 = new BufferedReader(new InputStreamReader(qyrxO2rh));
			String DFxxzIBg, igKpm6TG, aYHcLxxd, RlktPcwM, fTqjwSFu = null;
			Box s3na2154 = null;
			String KSQkZ4nm;
			String p8n2lbNi = "";
			int BrlBKTWn;
			int gpbRqE97;
			while ((DFxxzIBg = ZdXxKvF7.readLine()) != null) {
				if (DFxxzIBg.indexOf("documents match your query") != -1) {
					Jfih3K5Y = Integer
							.parseInt(DFxxzIBg.substring(DFxxzIBg.indexOf("<B>") + 3, DFxxzIBg.indexOf("</B>")));
					continue;
				}
				if (DFxxzIBg.indexOf("matches in the Ensembl External index") != -1) {
				}
				if (DFxxzIBg.indexOf("matches in the Ensembl Gene index:") != -1) {
				}
				if (DFxxzIBg.indexOf("Homo_sapiens/geneview?gene") != -1) {
					if (DFxxzIBg.indexOf("www.ensembl.org") != -1) {
						DFxxzIBg = DFxxzIBg.substring(DFxxzIBg.indexOf("www.ensembl.org"));
						DFxxzIBg = DFxxzIBg.substring(DFxxzIBg.indexOf("</A>") + 4);
					}
					int oSLKQtKe = DFxxzIBg.indexOf("Homo_sapiens/geneview?gene");
					if (oSLKQtKe == -1)
						break;
					KSQkZ4nm = "http://www.ensembl.org/" + DFxxzIBg.substring(oSLKQtKe, DFxxzIBg.indexOf("\">"));
					DFxxzIBg = DFxxzIBg.substring(DFxxzIBg.indexOf("</A>") + 4);
					StringBuffer QgmXUJmJ = new StringBuffer(DFxxzIBg.length());
					boolean nJvWldzz = false;
					boolean dReQ4k0d = false;
					boolean MqMQkUCZ = false;
					DFxxzIBg = DFxxzIBg.substring(DFxxzIBg.indexOf("<"));
					for (int DYu8rqCx = 0; DYu8rqCx < DFxxzIBg.length(); DYu8rqCx++) {
						if (DFxxzIBg.charAt(DYu8rqCx) == '<') {
							nJvWldzz = true;
							if ((DFxxzIBg.charAt(DYu8rqCx + 1) == 'b' || DFxxzIBg.charAt(DYu8rqCx + 1) == 'B')
									&& (DFxxzIBg.charAt(DYu8rqCx + 2) == 'r' || DFxxzIBg.charAt(DYu8rqCx + 2) == 'R')) {
								if (MqMQkUCZ) {
									QgmXUJmJ.append("\n");
								} else {
									MqMQkUCZ = true;
								}
							}
						}
						if (DFxxzIBg.charAt(DYu8rqCx) == '&')
							dReQ4k0d = true;
						if (!nJvWldzz && !dReQ4k0d)
							QgmXUJmJ.append(DFxxzIBg.charAt(DYu8rqCx));
						if (DFxxzIBg.charAt(DYu8rqCx) == ';')
							dReQ4k0d = false;
						if (DFxxzIBg.charAt(DYu8rqCx) == '>')
							nJvWldzz = false;
					}
					p8n2lbNi = QgmXUJmJ.toString();
					u47imo8N.add(p8n2lbNi);
					x3u28SGx.add(KSQkZ4nm);
					wBOrOiJP++;
				}
			}
			if (wBOrOiJP == 0)
				commentText.setText("No Matches Found for " + FJ7gxFUA);
			commentText.setLineWrap(true);
			commentText.setWrapStyleWord(true);
		} catch (Exception n8iECPZ0) {
			n8iECPZ0.printStackTrace();
			JOptionPane.showMessageDialog(this, "No Matches Found for " + FJ7gxFUA);
			return;
		}
		final JList A7DJZCoS = new JList(x3u28SGx);
		A7DJZCoS.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent pRBP0jcQ) {
				int eWFkDAug = A7DJZCoS.getSelectedIndex();
				commentText.setText((String) u47imo8N.elementAt(eWFkDAug));
				commentText.select(0, 0);
			}
		});
		MouseListener aH2Ia1Ay = new MouseAdapter() {

			public void mouseClicked(MouseEvent WPuvXdzC) {
				if (WPuvXdzC.getClickCount() == 2) {
					int bCTQ2fuN = A7DJZCoS.locationToIndex(WPuvXdzC.getPoint());
					extractEnsemblCoords((String) A7DJZCoS.getModel().getElementAt(bCTQ2fuN));
				}
			}
		};
		A7DJZCoS.addMouseListener(aH2Ia1Ay);
		A7DJZCoS.setSelectedIndex(0);
		scrollPane = new JScrollPane(commentText);
		JPanel iCLDCM7D = new JPanel();
		final JButton AyuwgWFK = new JButton("<=");
		final JButton MrbGP0Jt = new JButton("=>");
		AyuwgWFK.setEnabled(zMju5Imp > 1);
		MrbGP0Jt.setEnabled(zMju5Imp + wBOrOiJP < Jfih3K5Y);
		ActionListener Tx9TjoVr = new ActionListener() {

			public void actionPerformed(ActionEvent fqr1x7t1) {
				if (fqr1x7t1.getSource() == AyuwgWFK) {
					doQuery(EnsemblLookup.this.keyword, zMju5Imp - 20);
				} else {
					doQuery(EnsemblLookup.this.keyword, zMju5Imp + 20);
				}
			}
		};
		iCLDCM7D.add(AyuwgWFK);
		AyuwgWFK.addActionListener(Tx9TjoVr);
		iCLDCM7D.add(MrbGP0Jt);
		MrbGP0Jt.addActionListener(Tx9TjoVr);
		JPanel KxI9hCIP = new JPanel();
		KxI9hCIP.setLayout(new GridLayout(2, 1));
		KxI9hCIP.add(new JScrollPane(A7DJZCoS));
		KxI9hCIP.add(scrollPane);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(KxI9hCIP, BorderLayout.CENTER);
		getContentPane().add(iCLDCM7D, BorderLayout.SOUTH);
		setTitle("Results for " + FJ7gxFUA + "  Displaying " + (zMju5Imp + 1)
				+ ((wBOrOiJP > 1) ? (" - " + (zMju5Imp + wBOrOiJP)) : "") + " of " + Jfih3K5Y);
		show();
	}

}