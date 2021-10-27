class n1202515 {
	public static void copyFile(URL QwdLw2Mj, File Age30rl5) throws IOException {
		InputStream agtoc1RX = null;
		FileWriter VkWJOxuH = null;
		try {
			VkWJOxuH = new FileWriter(Age30rl5);
			agtoc1RX = QwdLw2Mj.openStream();
			int c4FEEHlX;
			while ((c4FEEHlX = agtoc1RX.read()) != -1) {
				VkWJOxuH.write(c4FEEHlX);
			}
		} finally {
			try {
				VkWJOxuH.flush();
				VkWJOxuH.close();
				agtoc1RX.close();
			} catch (Exception lHTPRwHG) {
				LOGGER.error(lHTPRwHG);
			}
		}
	}

}