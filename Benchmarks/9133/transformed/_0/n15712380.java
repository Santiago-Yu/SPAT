class n15712380 {
	public static void main(String[] KaDb5YSR) {
		if (KaDb5YSR.length == 0) {
			System.out.println("Specify name of the file, just one entry per line");
			System.exit(0);
		}
		File Y8KNPQQM = new File(KaDb5YSR[0]);
		BufferedReader BilvzNAg = null;
		File PhNdDW3B = new File(KaDb5YSR[0] + ".xml");
		BufferedWriter O3vjklqw = null;
		try {
			BilvzNAg = new BufferedReader(new FileReader(Y8KNPQQM));
			O3vjklqw = new BufferedWriter(new FileWriter(PhNdDW3B));
		} catch (Exception lKMV0CXI) {
			System.out.println("IN: " + Y8KNPQQM.getAbsolutePath());
			System.out.println("OUT: " + PhNdDW3B.getAbsolutePath());
			lKMV0CXI.printStackTrace();
			System.exit(0);
		}
		try {
			String wzRESL1Y;
			while ((wzRESL1Y = BilvzNAg.readLine()) != null) {
				O3vjklqw.write("<dbColumn name=\"" + wzRESL1Y + "\" display=\"" + wzRESL1Y + "\" panel=\"CENTER\"  >");
				O3vjklqw.write("\n");
				O3vjklqw.write("<dbType name=\"text\" maxVal=\"10\" defaultVal=\"\" sizeX=\"5\"/>");
				O3vjklqw.write("\n");
				O3vjklqw.write("</dbColumn>");
				O3vjklqw.write("\n");
			}
			O3vjklqw.close();
			BilvzNAg.close();
		} catch (Exception xP33PzMP) {
			xP33PzMP.printStackTrace();
			System.exit(0);
		}
		System.out.println("OUT: " + PhNdDW3B.getAbsolutePath());
		System.out.println("erzeugt");
	}

}