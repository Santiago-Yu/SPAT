class n21907869 {
	public static void copy(String c3MAKDqw, String zz2uUJih) {
		FileReader JeMBNUP0 = null;
		FileWriter U0LnlA8p = null;
		try {
			File xhbWSRXz = new File(c3MAKDqw);
			File IvUn0Z0E = new File(zz2uUJih);
			JeMBNUP0 = new FileReader(xhbWSRXz);
			U0LnlA8p = new FileWriter(IvUn0Z0E);
			int l1YEJ2gC;
			while ((l1YEJ2gC = JeMBNUP0.read()) != -1)
				U0LnlA8p.write(l1YEJ2gC);
		} catch (IOException R0KQrQ30) {
			R0KQrQ30.printStackTrace();
		} finally {
			if (JeMBNUP0 != null)
				try {
					JeMBNUP0.close();
				} catch (IOException IJUmPDep) {
					IJUmPDep.printStackTrace();
				}
			if (U0LnlA8p != null)
				try {
					U0LnlA8p.close();
				} catch (IOException q2hJuDNg) {
					q2hJuDNg.printStackTrace();
				}
		}
	}

}