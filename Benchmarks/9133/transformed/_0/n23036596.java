class n23036596 {
	public static boolean copyfile(String Jv9nh7B1, String sreabCsi) {
		try {
			File jEj76l82 = new File(Jv9nh7B1);
			File wQf9H6fF = new File(sreabCsi);
			FileInputStream VkFV6F4B = new FileInputStream(jEj76l82);
			FileOutputStream vjWmWozO = new FileOutputStream(wQf9H6fF);
			int MBcchc3R;
			while ((MBcchc3R = VkFV6F4B.read()) != -1)
				vjWmWozO.write(MBcchc3R);
			VkFV6F4B.close();
			vjWmWozO.close();
			VkFV6F4B = null;
			vjWmWozO = null;
			return true;
		} catch (Exception otdrLJoM) {
			return false;
		}
	}

}