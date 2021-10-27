class n15588201 {
	public void copy(File j6L6yLMo, File WB73Daqw) {
		try {
			FileInputStream xSI1EbJS = new FileInputStream(j6L6yLMo);
			FileOutputStream OftrrR1E = new FileOutputStream(WB73Daqw);
			FileChannel SpsYA1rg = xSI1EbJS.getChannel();
			FileChannel ID5CP4Z2 = OftrrR1E.getChannel();
			transfer(SpsYA1rg, ID5CP4Z2, j6L6yLMo.length(), 1024 * 1024 * 32, true, true);
			xSI1EbJS.close();
			OftrrR1E.close();
		} catch (Exception yOR9T9tG) {
			yOR9T9tG.printStackTrace();
		}
	}

}