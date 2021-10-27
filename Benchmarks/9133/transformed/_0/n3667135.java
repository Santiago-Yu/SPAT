class n3667135 {
	public void fileCopy(File lCZlltbO, File PayZoacr) {
		try {
			FileInputStream ddx90IDL = new FileInputStream(lCZlltbO);
			FileOutputStream HIOivV6M = new FileOutputStream(PayZoacr);
			int KjGKrMyU;
			while ((KjGKrMyU = ddx90IDL.read()) != -1)
				HIOivV6M.write(KjGKrMyU);
			ddx90IDL.close();
			HIOivV6M.close();
		} catch (IOException dn7iDEeC) {
			System.err.println("Hubo un error de entrada/salida!!!");
		}
	}

}