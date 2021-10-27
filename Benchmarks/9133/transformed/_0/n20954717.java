class n20954717 {
	private static final void copyFile(File RX9diiwL, File usy8pe7h, byte[] NlIXRiLQ) {
		try {
			File n856EXG4 = new File(usy8pe7h, RX9diiwL.getName());
			InputStream KbZQ2P2g = new FileInputStream(RX9diiwL);
			OutputStream EETSt63N = new FileOutputStream(n856EXG4);
			int vkg4IKCN;
			while ((vkg4IKCN = KbZQ2P2g.read(NlIXRiLQ)) != -1)
				EETSt63N.write(NlIXRiLQ, 0, vkg4IKCN);
			KbZQ2P2g.close();
			EETSt63N.close();
		} catch (IOException wm4tTjX9) {
			System.err.println("Couldn't copy file '" + RX9diiwL + "' to directory '" + usy8pe7h + "'");
		}
	}

}