class n23058336 {
	public static void copyFile(File dsmkT7PJ, File cC3B8Yik) throws Exception {
		FileChannel qRCpJygN = new FileInputStream(dsmkT7PJ).getChannel();
		FileChannel sYbNi5Gr = new FileOutputStream(cC3B8Yik).getChannel();
		qRCpJygN.transferTo(0, qRCpJygN.size(), sYbNi5Gr);
		qRCpJygN.close();
		sYbNi5Gr.close();
	}

}