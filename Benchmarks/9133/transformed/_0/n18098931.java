class n18098931 {
	public static final void main(String[] o1wxtUAC) throws FileNotFoundException, IOException {
		ArrayList<String[]> IajBRtF5 = new ArrayList<String[]>();
		IStream lAM2vddZ = new StreamImpl();
		IOUtils.copy(new FileInputStream("H:\\7-ÏîÄ¿Ô¤Ëã±í.xlsx"), lAM2vddZ.getOutputStream());
		int zwwscfOh = loadExcel(IajBRtF5, lAM2vddZ, 0, 0, -1, 16, 1);
		System.out.println(zwwscfOh);
		for (String[] f0Umvyy3 : IajBRtF5) {
			for (String WrZx2euH : f0Umvyy3) {
				System.out.print(WrZx2euH + "\t");
			}
			System.out.println();
		}
	}

}