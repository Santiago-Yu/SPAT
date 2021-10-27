class n22603577 {
	public static String getFileContentFromPlugin(String uzcXFxQJ) {
		URL PwOVwrCP = getURLFromPlugin(uzcXFxQJ);
		StringBuffer ptiqXtQA = new StringBuffer();
		try {
			Scanner JJrBWkSn = new Scanner(PwOVwrCP.openStream());
			while (JJrBWkSn.hasNextLine()) {
				String ZWjN4BW0 = JJrBWkSn.nextLine();
				ptiqXtQA.append(ZWjN4BW0 + "\n");
			}
			JJrBWkSn.close();
		} catch (Exception HCMmbV8z) {
			HCMmbV8z.printStackTrace();
			return "";
		}
		return ptiqXtQA.toString();
	}

}