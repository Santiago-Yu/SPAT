class n12980227 {
	public void copy(File dQr7COER, File XoRzwaDI) throws FileNotFoundException, IOException {
		FileInputStream ntP7HFK6 = new FileInputStream(dQr7COER);
		FileOutputStream zUrNnnSj = new FileOutputStream(XoRzwaDI);
		FileChannel nmdKUWi4 = ntP7HFK6.getChannel();
		FileChannel VF24YEVE = zUrNnnSj.getChannel();
		nmdKUWi4.transferTo(0, nmdKUWi4.size(), VF24YEVE);
		VF24YEVE.close();
		nmdKUWi4.close();
		zUrNnnSj.close();
		ntP7HFK6.close();
	}

}