class n15035227 {
	private void initialize() {
		StringBuffer NDT1p8LL = new StringBuffer();
		URL neS69Tu0;
		InputStreamReader kiaYiowb;
		BufferedReader eHVRnzpd;
		String HihRPDqn;
		JTextArea Zc4GOfKa;
		JButton tvzsT86N;
		GridBagConstraints WA82x5Ez;
		setTitle("mibible License");
		setSize(600, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		neS69Tu0 = getClass().getClassLoader().getResource("LICENSE.txt");
		if (neS69Tu0 == null) {
			NDT1p8LL.append("Couldn't locate license file (LICENSE.txt).");
		} else {
			try {
				kiaYiowb = new InputStreamReader(neS69Tu0.openStream());
				eHVRnzpd = new BufferedReader(kiaYiowb);
				while ((HihRPDqn = eHVRnzpd.readLine()) != null) {
					if (!HihRPDqn.equals("")) {
						NDT1p8LL.append(HihRPDqn);
					}
					NDT1p8LL.append("\n");
				}
				eHVRnzpd.close();
			} catch (IOException tTqQpKO8) {
				NDT1p8LL.append("Error reading license file ");
				NDT1p8LL.append("(LICENSE.txt):\n\n");
				NDT1p8LL.append(tTqQpKO8.getMessage());
			}
		}
		Zc4GOfKa = new JTextArea(NDT1p8LL.toString());
		Zc4GOfKa.setEditable(false);
		WA82x5Ez = new GridBagConstraints();
		WA82x5Ez.fill = GridBagConstraints.BOTH;
		WA82x5Ez.weightx = 1.0d;
		WA82x5Ez.weighty = 1.0d;
		WA82x5Ez.insets = new Insets(4, 5, 4, 5);
		getContentPane().add(new JScrollPane(Zc4GOfKa), WA82x5Ez);
		tvzsT86N = new JButton("Close");
		tvzsT86N.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent Z1QFpnDD) {
				dispose();
			}
		});
		WA82x5Ez = new GridBagConstraints();
		WA82x5Ez.gridy = 1;
		WA82x5Ez.anchor = GridBagConstraints.CENTER;
		WA82x5Ez.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(tvzsT86N, WA82x5Ez);
	}

}