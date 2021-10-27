class n383058 {
	public static boolean getFile(String gvNq6Qql, String tQo5x0mt) {
		try {
			File UMSWKbQy = new File("D:\\buttons\\data\\sounds\\" + tQo5x0mt);
			URL m8o7UKiU = new URL(gvNq6Qql);
			URLConnection hCFvdGfW = m8o7UKiU.openConnection();
			BufferedInputStream LFTqJw50 = new BufferedInputStream(hCFvdGfW.getInputStream());
			int uwnu2YJv;
			BufferedOutputStream wZ14bN01 = new BufferedOutputStream(new FileOutputStream(UMSWKbQy));
			while ((uwnu2YJv = LFTqJw50.read()) != -1) {
				wZ14bN01.write(uwnu2YJv);
			}
			System.out.println("wrote audio url: " + gvNq6Qql + " \nto file " + UMSWKbQy);
		} catch (Exception qaJ0A9LV) {
			qaJ0A9LV.printStackTrace();
			return false;
		}
		return true;
	}

}