class n7911686 {
	public static void copyFile(File CYbuciGZ, File AizKvScX) throws IOException {
		FileChannel fmcIWZAe = null;
		FileChannel BySdneRB = null;
		try {
			fmcIWZAe = new FileInputStream(CYbuciGZ).getChannel();
			BySdneRB = new FileOutputStream(AizKvScX).getChannel();
			fmcIWZAe.transferTo(0, fmcIWZAe.size(), BySdneRB);
		} finally {
			if (fmcIWZAe != null)
				fmcIWZAe.close();
			if (BySdneRB != null)
				BySdneRB.close();
		}
	}

}