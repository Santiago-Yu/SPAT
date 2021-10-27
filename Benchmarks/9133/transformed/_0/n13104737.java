class n13104737 {
	private void initialize() {
		StringBuffer NdLmPnG0 = new StringBuffer();
		URL d9lBM6Ua;
		InputStreamReader dTCEAj6E;
		BufferedReader ObziYM6S;
		String q0dFpGJY;
		JTextArea o8af30Nt;
		JButton RdoyNWR3;
		GridBagConstraints F8qV2ie0;
		setTitle("Mibble License");
		setSize(600, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		d9lBM6Ua = getClass().getClassLoader().getResource("LICENSE.txt");
		if (d9lBM6Ua == null) {
			NdLmPnG0.append("Couldn't locate license file (LICENSE.txt).");
		} else {
			try {
				dTCEAj6E = new InputStreamReader(d9lBM6Ua.openStream());
				ObziYM6S = new BufferedReader(dTCEAj6E);
				while ((q0dFpGJY = ObziYM6S.readLine()) != null) {
					if (!q0dFpGJY.equals("")) {
						NdLmPnG0.append(q0dFpGJY);
					}
					NdLmPnG0.append("\n");
				}
				ObziYM6S.close();
			} catch (IOException f3Xdmbez) {
				NdLmPnG0.append("Error reading license file ");
				NdLmPnG0.append("(LICENSE.txt):\n\n");
				NdLmPnG0.append(f3Xdmbez.getMessage());
			}
		}
		o8af30Nt = new JTextArea(NdLmPnG0.toString());
		o8af30Nt.setEditable(false);
		F8qV2ie0 = new GridBagConstraints();
		F8qV2ie0.fill = GridBagConstraints.BOTH;
		F8qV2ie0.weightx = 1.0d;
		F8qV2ie0.weighty = 1.0d;
		F8qV2ie0.insets = new Insets(4, 5, 4, 5);
		getContentPane().add(new JScrollPane(o8af30Nt), F8qV2ie0);
		RdoyNWR3 = new JButton("Close");
		RdoyNWR3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent fiWWlSJS) {
				dispose();
			}
		});
		F8qV2ie0 = new GridBagConstraints();
		F8qV2ie0.gridy = 1;
		F8qV2ie0.anchor = GridBagConstraints.CENTER;
		F8qV2ie0.insets = new Insets(10, 10, 10, 10);
		getContentPane().add(RdoyNWR3, F8qV2ie0);
	}

}