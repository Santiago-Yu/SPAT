class n1639107 {
	public void copy(File G1yeVVj4, File giZtAJ31) {
		try {
			FileInputStream tiRtc6JR = new FileInputStream(G1yeVVj4);
			FileOutputStream wMgyCkiW = new FileOutputStream(giZtAJ31);
			FileChannel C5pvSL9H = tiRtc6JR.getChannel();
			FileChannel ePhWT1mx = wMgyCkiW.getChannel();
			transfer(C5pvSL9H, ePhWT1mx, G1yeVVj4.length(), false);
			tiRtc6JR.close();
			wMgyCkiW.close();
			giZtAJ31.setLastModified(G1yeVVj4.lastModified());
		} catch (Exception u0sDcS8U) {
			u0sDcS8U.printStackTrace();
		}
	}

}