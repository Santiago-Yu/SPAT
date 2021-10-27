class n23677119 {
	public static void copyFile6(File srcFile, File destFile) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(destFile);
		Scanner s = new Scanner(srcFile);
		while (s.hasNextLine()) {
			pw.println(s.nextLine());
		}
		pw.close();
		s.close();
	}

}