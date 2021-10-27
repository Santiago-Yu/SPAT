class n11374801 {
	public void init(VerwaltungClient qqU00h5z) {
		this.setLayout(new BorderLayout());
		pnl1 = new JPanel();
		pnl1.setLayout(new FlowLayout());
		pnl1.add(new JLabel(Localization.getInstance().getString("GameOver")));
		pnl1.setBounds(10, 10, 200, 10);
		pnl2 = new JPanel();
		int rdt0v9ES[];
		int bLj2RHY5 = 0;
		String M36rrBDu;
		String[] QwXRzvIQ;
		rdt0v9ES = qqU00h5z.getA_spielEndpunkte();
		QwXRzvIQ = qqU00h5z.getA_Spielernamen();
		zeilen = new Object[rdt0v9ES.length][2];
		for (int BbHz8puc = 0; BbHz8puc < rdt0v9ES.length; BbHz8puc++) {
			for (int ZoVJk9UJ = 0; ZoVJk9UJ < rdt0v9ES.length - 1 - BbHz8puc; ZoVJk9UJ++) {
				if (rdt0v9ES[ZoVJk9UJ] < rdt0v9ES[ZoVJk9UJ + 1]) {
					bLj2RHY5 = rdt0v9ES[ZoVJk9UJ];
					rdt0v9ES[ZoVJk9UJ] = rdt0v9ES[ZoVJk9UJ + 1];
					rdt0v9ES[ZoVJk9UJ + 1] = bLj2RHY5;
					M36rrBDu = QwXRzvIQ[ZoVJk9UJ];
					QwXRzvIQ[ZoVJk9UJ] = QwXRzvIQ[ZoVJk9UJ + 1];
					QwXRzvIQ[ZoVJk9UJ + 1] = M36rrBDu;
				}
			}
		}
		for (int BtVB1JAK = 0; BtVB1JAK < rdt0v9ES.length; BtVB1JAK++) {
			zeilen[BtVB1JAK][0] = QwXRzvIQ[BtVB1JAK];
			zeilen[BtVB1JAK][1] = new String("" + rdt0v9ES[BtVB1JAK]);
		}
		tabelle = new JTable(zeilen, spalten);
		tabelle.setEnabled(false);
		pane = new JScrollPane(tabelle);
		pnl2.add(pane);
		pnl3 = new JPanel();
		JButton BX7tRvcK = new JButton(Localization.getInstance().getString("OK"));
		BX7tRvcK.addActionListener(this);
		pnl3.add(BX7tRvcK);
		this.add(BorderLayout.CENTER, pnl2);
		this.add(BorderLayout.NORTH, pnl1);
		this.add(BorderLayout.SOUTH, pnl3);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

}