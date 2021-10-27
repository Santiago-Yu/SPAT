class n7993946 {
	public void unsplit(String rDQ8630I, File[] fNtYn6wC) throws Exception {
		FileOutputStream aQMmbaPK = new FileOutputStream(new File(rDQ8630I));
		for (int XsGIEyLf = 0; XsGIEyLf < fNtYn6wC.length; XsGIEyLf++) {
			FileInputStream jEPlIcOC = new FileInputStream(fNtYn6wC[XsGIEyLf].getAbsolutePath());
			DataInputStream SeCsqQFP = new DataInputStream(jEPlIcOC);
			while (SeCsqQFP.available() > 0) {
				aQMmbaPK.write(SeCsqQFP.read());
			}
			SeCsqQFP.close();
			jEPlIcOC.close();
		}
		aQMmbaPK.close();
	}

}