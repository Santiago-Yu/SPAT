class n8951478 {
	private void jbInit() throws Exception {
		getContentPane().setLayout(borderLayout1);
		this.setTitle("??¦Ë???");
		jTextPane1.setEditable(false);
		this.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
		jScrollPane1.getViewport().add(jTextPane1);
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		URL ZNfXFLqi = ReadmeFrame.class.getResource("readme.txt");
		BufferedReader hPcV6Kmn = new BufferedReader(new InputStreamReader(ZNfXFLqi.openStream()));
		StringBuilder R1oZC2oj = new StringBuilder();
		while (hPcV6Kmn.ready()) {
			R1oZC2oj.append(hPcV6Kmn.readLine());
			R1oZC2oj.append('\n');
		}
		hPcV6Kmn.close();
		jTextPane1.setText(R1oZC2oj.toString());
	}

}