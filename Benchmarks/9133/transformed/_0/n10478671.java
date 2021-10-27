class n10478671 {
	private void copyFile(File iYAmfrQZ, File Gwm3MGQQ) {
		BufferedInputStream uYBWnzWC = null;
		BufferedOutputStream E1RkPEDn = null;
		try {
			uYBWnzWC = new BufferedInputStream(new FileInputStream(iYAmfrQZ));
			E1RkPEDn = new BufferedOutputStream(new FileOutputStream(Gwm3MGQQ));
			byte[] Q3RC0krl = new byte[4096];
			int RdgiZMQH = 0;
			while ((RdgiZMQH = uYBWnzWC.read(Q3RC0krl)) >= 0) {
				E1RkPEDn.write(Q3RC0krl, 0, RdgiZMQH);
			}
		} catch (IOException qIpYpZG4) {
			qIpYpZG4.printStackTrace();
		} finally {
			try {
				if (uYBWnzWC != null) {
					uYBWnzWC.close();
				}
				if (E1RkPEDn != null) {
					E1RkPEDn.close();
				}
			} catch (IOException lcrkwYSL) {
				lcrkwYSL.printStackTrace();
			}
		}
	}

}