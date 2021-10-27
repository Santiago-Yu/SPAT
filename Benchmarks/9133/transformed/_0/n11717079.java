class n11717079 {
	void copyFile(File WL3x40U5, File TNXwJAcj) {
		try {
			FileReader GRglkki0;
			GRglkki0 = new FileReader(WL3x40U5);
			FileWriter AGbcLT0U = new FileWriter(TNXwJAcj);
			int DGRTUk6U;
			while ((DGRTUk6U = GRglkki0.read()) != -1)
				AGbcLT0U.write(DGRTUk6U);
			GRglkki0.close();
			AGbcLT0U.close();
		} catch (FileNotFoundException lZ4UydXY) {
			lZ4UydXY.printStackTrace();
		} catch (IOException BzJlXkrn) {
			BzJlXkrn.printStackTrace();
		}
	}

}