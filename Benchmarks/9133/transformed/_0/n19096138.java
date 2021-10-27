class n19096138 {
	public static void main(String[] PnAzzUG7) {
		String FM6Xosne = PnAzzUG7[0];
		int J0UBjXp9 = new Integer(PnAzzUG7[1]).intValue();
		String iPJS1BJ6 = "P0";
		if (PnAzzUG7.length > 2) {
			iPJS1BJ6 = PnAzzUG7[2];
		}
		try {
			BufferedReader sGx4SroJ = new BufferedReader(new FileReader(FM6Xosne));
			BufferedWriter aOXZyOQW = new BufferedWriter(new FileWriter(new File(FM6Xosne + ".trim")));
			String SjFWZ1at;
			int ZLTsOfV9 = 0;
			while ((SjFWZ1at = sGx4SroJ.readLine()) != null) {
				if ((ZLTsOfV9++ % J0UBjXp9 == 0) && SjFWZ1at.startsWith(iPJS1BJ6)) {
					aOXZyOQW.write(SjFWZ1at + "\n");
				}
			}
			aOXZyOQW.flush();
			aOXZyOQW.close();
		} catch (IOException dWiThrzr) {
			dWiThrzr.printStackTrace();
		}
	}

}