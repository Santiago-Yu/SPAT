class n4776598 {
	private void init(URL vAGcwHnR) {
		frame = new JInternalFrame(name);
		frame.addInternalFrameListener(this);
		listModel.add(listModel.size(), this);
		area = new JTextArea();
		area.setMargin(new Insets(5, 5, 5, 5));
		try {
			BufferedReader j3Ack51A = new BufferedReader(new InputStreamReader(vAGcwHnR.openStream()));
			String Qe84zgjD;
			while ((Qe84zgjD = j3Ack51A.readLine()) != null) {
				area.append(Qe84zgjD);
				area.append("\n");
			}
			j3Ack51A.close();
		} catch (Exception DgJvPhxf) {
			DgJvPhxf.printStackTrace();
			return;
		}
		th = area.getTransferHandler();
		area.setFont(new Font("monospaced", Font.PLAIN, 12));
		area.setCaretPosition(0);
		area.setDragEnabled(true);
		area.setDropMode(DropMode.INSERT);
		frame.getContentPane().add(new JScrollPane(area));
		dp.add(frame);
		frame.show();
		if (DEMO) {
			frame.setSize(300, 200);
		} else {
			frame.setSize(400, 300);
		}
		frame.setResizable(true);
		frame.setClosable(true);
		frame.setIconifiable(true);
		frame.setMaximizable(true);
		frame.setLocation(left, top);
		incr();
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				select();
			}
		});
		nullItem.addActionListener(this);
		setNullTH();
	}

}