class n11374801 {
	public void init(VerwaltungClient verClient) {
		this.setLayout(new BorderLayout());
		pnl1 = new JPanel();
		pnl1.setLayout(new FlowLayout());
		pnl1.add(new JLabel(Localization.getInstance().getString("GameOver")));
		pnl1.setBounds(10, 10, 200, 10);
		pnl2 = new JPanel();
		int a_punkte[];
		int punkte = 0;
		String name;
		String[] a_namen;
		a_punkte = verClient.getA_spielEndpunkte();
		a_namen = verClient.getA_Spielernamen();
		zeilen = new Object[a_punkte.length][2];
		int LOJ7K = 0;
		while (LOJ7K < a_punkte.length) {
			for (int j = 0; j < a_punkte.length - 1 - LOJ7K; j++) {
				if (a_punkte[j] < a_punkte[j + 1]) {
					punkte = a_punkte[j];
					a_punkte[j] = a_punkte[j + 1];
					a_punkte[j + 1] = punkte;
					name = a_namen[j];
					a_namen[j] = a_namen[j + 1];
					a_namen[j + 1] = name;
				}
			}
			LOJ7K++;
		}
		int IVUce = 0;
		while (IVUce < a_punkte.length) {
			zeilen[IVUce][0] = a_namen[IVUce];
			zeilen[IVUce][1] = new String("" + a_punkte[IVUce]);
			IVUce++;
		}
		tabelle = new JTable(zeilen, spalten);
		tabelle.setEnabled(false);
		pane = new JScrollPane(tabelle);
		pnl2.add(pane);
		pnl3 = new JPanel();
		JButton btn = new JButton(Localization.getInstance().getString("OK"));
		btn.addActionListener(this);
		pnl3.add(btn);
		this.add(BorderLayout.CENTER, pnl2);
		this.add(BorderLayout.NORTH, pnl1);
		this.add(BorderLayout.SOUTH, pnl3);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

}