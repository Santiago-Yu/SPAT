class n19309971 {
	private static void copyFile(String src, String dest) {
		try {
			File outputFile = new File(dest);
			File inputFile = new File(src);
			FileOutputStream out = new FileOutputStream(outputFile);
			FileInputStream in = new FileInputStream(inputFile);
			FileChannel inc = in.getChannel();
			FileChannel outc = out.getChannel();
			inc.transferTo(0, inc.size(), outc);
			inc.close();
			outc.close();
			in.close();
			out.close();
		} catch (Exception e) {
		}
	}

}