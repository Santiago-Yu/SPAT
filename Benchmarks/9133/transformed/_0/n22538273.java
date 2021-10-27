class n22538273 {
	public void format(File ZwZaaxku, File YcIN49Ra) {
		if (!ZwZaaxku.exists()) {
			throw new IllegalArgumentException("Source '" + ZwZaaxku + " doesn't exist");
		}
		if (!ZwZaaxku.isFile()) {
			throw new IllegalArgumentException("Source '" + ZwZaaxku + " is not a file");
		}
		YcIN49Ra.mkdirs();
		String oRG78Ml6 = ZwZaaxku.getName().substring(ZwZaaxku.getName().lastIndexOf(".") + 1);
		String x54HCC4P = ZwZaaxku.getName().replace(oRG78Ml6, "html");
		YcIN49Ra = new File(YcIN49Ra.getPath() + "/" + x54HCC4P);
		try {
			Reader cNGaGVxf = new FileReader(ZwZaaxku);
			Writer tu22Ylv1 = new FileWriter(YcIN49Ra);
			this.format(cNGaGVxf, tu22Ylv1);
		} catch (Exception Jht5bowA) {
			Jht5bowA.printStackTrace();
		}
	}

}