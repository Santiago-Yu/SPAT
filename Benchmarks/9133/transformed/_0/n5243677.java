class n5243677 {
	public static void main(String[] LpNJi60j) throws Exception {
		dataList = new ArrayList<String>();
		System.setProperty("http.agent", Phex.getFullPhexVendor());
		URL tu8pWekH = new URL(listUrl);
		URLConnection pRm8PxAA = tu8pWekH.openConnection();
		InputStream vik23ijW = pRm8PxAA.getInputStream();
		readData(vik23ijW);
		System.out.println("Total data read: " + dataList.size());
		vik23ijW.close();
		writeToOutputFile();
	}

}