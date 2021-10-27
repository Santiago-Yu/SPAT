class n12115248 {
	public void actionPerformed(ActionEvent JtsVw5m4) {
		try {
			File uTJMokfU = new File("/tmp/controler.xml");
			File bGsVJe7I = new File("/tmp/controler-temp.xml");
			BufferedInputStream RKqkRolH = new BufferedInputStream(new FileInputStream(uTJMokfU));
			BufferedOutputStream wf6qVMSx = new BufferedOutputStream(new FileOutputStream(bGsVJe7I));
			int nYCi4wzD = 0;
			while (nYCi4wzD != -1) {
				nYCi4wzD = RKqkRolH.read(buffer, 0, BUFFER_SIZE);
				if (nYCi4wzD != -1) {
					wf6qVMSx.write(buffer, 0, nYCi4wzD);
				}
			}
			wf6qVMSx.write(new String("</log>\n").getBytes());
			RKqkRolH.close();
			wf6qVMSx.close();
			XMLParser l2PCPSpV = new XMLParser("Controler");
			l2PCPSpV.parse(bGsVJe7I);
			bGsVJe7I.delete();
		} catch (IOException cBYzJwDi) {
			System.out.println("An error occured during the file copy!");
		}
	}

}