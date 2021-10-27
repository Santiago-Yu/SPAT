class n18142979 {
	private String copyTutorial() throws IOException {
		File ZzFzFh8E = new File(getFilenameForOriginalTutorial());
		File KHUX1rAs = new File(getFilenameForCopiedTutorial());
		FileReader VXG4YICU = new FileReader(ZzFzFh8E);
		FileWriter qEryxDcD = new FileWriter(KHUX1rAs);
		int tWt1oT33;
		while ((tWt1oT33 = VXG4YICU.read()) != -1)
			qEryxDcD.write(tWt1oT33);
		VXG4YICU.close();
		qEryxDcD.close();
		return getFilenameForCopiedTutorial();
	}

}