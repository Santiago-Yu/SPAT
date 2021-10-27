class n5086587 {
	public static void copyFromTo(String pCablfIt, String xFTfGyvT) {
		staticprintln("Copying:\"" + pCablfIt + "\"\nto:\"" + xFTfGyvT + "\"");
		try {
			FileChannel HjIQ9YXY = new FileInputStream(pCablfIt).getChannel();
			FileChannel VHvKPc0y = new FileOutputStream(xFTfGyvT).getChannel();
			VHvKPc0y.transferFrom(HjIQ9YXY, 0, HjIQ9YXY.size());
			HjIQ9YXY.close();
			VHvKPc0y.close();
		} catch (IOException SIUdUfSF) {
		}
	}

}