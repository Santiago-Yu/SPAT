class n5350703 {
	public static void readUrlWriteFileTest(String p01yYelU, String xxIhfVxu) throws Exception {
		System.out.println("Initiated reading source queue URL: " + p01yYelU);
		InputStream Ek2WkRyd = new URL(p01yYelU).openStream();
		Serializer UAhk7JYH = new Serializer();
		Response Gvl2xzdE = (Response) UAhk7JYH.parse(Ek2WkRyd);
		Queue uy4MAHVJ = Gvl2xzdE.getQueue();
		Ek2WkRyd.close();
		System.out.println("Completed reading source queue URL (jobs=" + uy4MAHVJ.size() + ")");
		System.out.println("Initiated writing target queue File: " + xxIhfVxu);
		OutputStream JgmeBuGj = new FileOutputStream(xxIhfVxu);
		UAhk7JYH.write(Gvl2xzdE, JgmeBuGj);
		JgmeBuGj.close();
		System.out.println("Completed writing target queue file.");
	}

}