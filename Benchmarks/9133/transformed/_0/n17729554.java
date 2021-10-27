class n17729554 {
	public boolean clonarFichero(FileInputStream nAuxPe3t, String aeMNOLYP) {
		System.out.println("");
		boolean h2WYErGl = false;
		try {
			FileOutputStream C8HAiBAJ = new FileOutputStream(aeMNOLYP);
			FileChannel zoxCB0v9 = nAuxPe3t.getChannel();
			FileChannel YzuVZz3K = C8HAiBAJ.getChannel();
			zoxCB0v9.transferTo(0, zoxCB0v9.size(), YzuVZz3K);
			nAuxPe3t.close();
			C8HAiBAJ.close();
			h2WYErGl = true;
		} catch (IOException fdhTRB9H) {
			System.out.println("No se encontro el archivo");
			fdhTRB9H.printStackTrace();
			h2WYErGl = false;
		}
		return h2WYErGl;
	}

}