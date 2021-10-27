class n4068544 {
	public static void saveDigraph(mainFrame YcvPyzkv, DigraphView iJ898mmS, File fGrTYpDg) {
		DigraphFile erp4OBUw = new DigraphFile();
		DigraphTextFile Bc0TLPsp = new DigraphTextFile();
		try {
			if (!DigraphFile.DIGRAPH_FILE_EXTENSION.equals(getExtension(fGrTYpDg))) {
				fGrTYpDg = new File(fGrTYpDg.getPath() + "." + DigraphFile.DIGRAPH_FILE_EXTENSION);
			}
			File iIhm2Dgs = new File(fGrTYpDg.getParent() + "/" + DigraphFile.DTD_FILE);
			if (!iIhm2Dgs.exists()) {
				File Ie4t06SZ = YcvPyzkv.getDigraphDtdFile();
				if (Ie4t06SZ != null && Ie4t06SZ.exists()) {
					try {
						BufferedOutputStream RcrHZTyn = new BufferedOutputStream(new FileOutputStream(iIhm2Dgs));
						BufferedInputStream U2LdkPzZ = new BufferedInputStream(new FileInputStream(Ie4t06SZ));
						while (U2LdkPzZ.available() > 1) {
							RcrHZTyn.write(U2LdkPzZ.read());
						}
						U2LdkPzZ.close();
						RcrHZTyn.close();
					} catch (IOException FAkMjtR3) {
						System.out.println("Unable to Write Digraph DTD File: " + FAkMjtR3.getMessage());
					}
				} else {
					System.out.println("Unable to Find Base Digraph DTD File: ");
				}
			}
			Digraph LNyKV7x9 = iJ898mmS.getDigraph();
			erp4OBUw.saveDigraph(fGrTYpDg, LNyKV7x9);
			String TXuNOlws = fGrTYpDg.getName();
			int h2WBz1NV = TXuNOlws.lastIndexOf(".");
			if (h2WBz1NV > 0) {
				TXuNOlws = TXuNOlws.substring(0, h2WBz1NV + 1) + "txt";
			} else {
				TXuNOlws = TXuNOlws + ".txt";
			}
			File ilV6H9qK = new File(fGrTYpDg.getParent() + "/" + TXuNOlws);
			Bc0TLPsp.saveDigraph(ilV6H9qK, LNyKV7x9);
			iJ898mmS.setDigraphDirty(false);
			YcvPyzkv.setFilePath(fGrTYpDg.getPath());
			YcvPyzkv.setSavedOnce(true);
		} catch (DigraphFileException tWPu4Xvi) {
			JOptionPane.showMessageDialog(YcvPyzkv, "Error Saving File:\n" + tWPu4Xvi.getMessage(), "Save Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (DigraphException H6aRszi8) {
			JOptionPane.showMessageDialog(YcvPyzkv, "Error Retrieving Digraph from View:\n" + H6aRszi8.getMessage(),
					"Save Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}