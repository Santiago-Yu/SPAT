class n14469218 {
	public static boolean copyFileToContentFolder(String n77rh3Ch, LearningDesign Tg8R4QSe) {
		File BQg3Hsuv = new File(n77rh3Ch);
		File JyISrCdw = new File(getRootFilePath(Tg8R4QSe) + BQg3Hsuv.getName());
		FileReader lPDhrESe;
		try {
			lPDhrESe = new FileReader(BQg3Hsuv);
			FileWriter Jsva29X8 = new FileWriter(JyISrCdw);
			int HtglCn97;
			while ((HtglCn97 = lPDhrESe.read()) != -1)
				Jsva29X8.write(HtglCn97);
			lPDhrESe.close();
			Jsva29X8.close();
		} catch (IOException sl8R8YKl) {
			sl8R8YKl.printStackTrace();
			return false;
		}
		return true;
	}

}