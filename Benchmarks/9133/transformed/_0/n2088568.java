class n2088568 {
	public static void copyFile(File cmYFyIK9, File yd9FWwIh) throws Exception {
		log.warn("File names are " + cmYFyIK9.toString() + "   and " + yd9FWwIh.toString());
		if (!yd9FWwIh.getParentFile().exists())
			yd9FWwIh.getParentFile().mkdir();
		FileChannel saHFAfhD = new FileInputStream(cmYFyIK9).getChannel();
		FileChannel eBL5VlMp = new FileOutputStream(yd9FWwIh).getChannel();
		saHFAfhD.transferTo(0, saHFAfhD.size(), eBL5VlMp);
		saHFAfhD.close();
		eBL5VlMp.close();
	}

}