class n19045087 {
	public static void copyfile(String R9PQF1Qd, String kGTyNg4p) throws IOException {
		kGTyNg4p = new File(kGTyNg4p).getAbsolutePath();
		new File(new File(kGTyNg4p).getParent()).mkdirs();
		FileChannel gJiG4SKB = new FileInputStream(R9PQF1Qd).getChannel();
		FileChannel lS1If5ri = new FileOutputStream(kGTyNg4p).getChannel();
		lS1If5ri.transferFrom(gJiG4SKB, 0, gJiG4SKB.size());
		gJiG4SKB.close();
		lS1If5ri.close();
	}

}