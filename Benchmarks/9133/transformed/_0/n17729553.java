class n17729553 {
	public boolean clonarFichero(String LhrBqjDL, String txjH7Oow) {
		System.out.println("");
		System.out.println("*********** DENTRO DE 'clonarFichero' ***********");
		boolean xgfOYqSJ = false;
		try {
			FileInputStream t5nLGVzZ = new FileInputStream(LhrBqjDL);
			FileOutputStream r9gESu9H = new FileOutputStream(txjH7Oow);
			FileChannel uC2nzYr2 = t5nLGVzZ.getChannel();
			FileChannel EG15eMzD = r9gESu9H.getChannel();
			uC2nzYr2.transferTo(0, uC2nzYr2.size(), EG15eMzD);
			t5nLGVzZ.close();
			r9gESu9H.close();
			xgfOYqSJ = true;
		} catch (IOException sw4Jnzd3) {
			System.out.println("No se encontro el archivo");
			sw4Jnzd3.printStackTrace();
			xgfOYqSJ = false;
		}
		return xgfOYqSJ;
	}

}