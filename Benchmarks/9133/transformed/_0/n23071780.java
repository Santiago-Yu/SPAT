class n23071780 {
	public boolean copyFile(File uK0X9Wpi, File Hmq5g0f4) {
		try {
			FileReader o4gJANqP = new FileReader(uK0X9Wpi);
			FileWriter tZIcDgP3 = new FileWriter(Hmq5g0f4);
			int PnqKDFPL;
			while ((PnqKDFPL = o4gJANqP.read()) != -1)
				tZIcDgP3.write(PnqKDFPL);
			o4gJANqP.close();
			tZIcDgP3.close();
			return true;
		} catch (Exception KRuYG9VP) {
			return false;
		}
	}

}