class n23677119 {
	public static void copyFile6(File rCKqyaOn, File aH877l2h) throws FileNotFoundException {
		Scanner hbuvSM1T = new Scanner(rCKqyaOn);
		PrintWriter a4guVFRQ = new PrintWriter(aH877l2h);
		while (hbuvSM1T.hasNextLine()) {
			a4guVFRQ.println(hbuvSM1T.nextLine());
		}
		a4guVFRQ.close();
		hbuvSM1T.close();
	}

}