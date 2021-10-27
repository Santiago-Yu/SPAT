class n11154758 {
	public static void main(String[] Ytr2XVqy) {
		FTPClient sLc1yWjV = new FTPClient();
		FileOutputStream kIG9IPBy = null;
		try {
			sLc1yWjV.connect("192.168.1.10");
			sLc1yWjV.login("a", "123456");
			String UViR7kJN = "i.exe";
			kIG9IPBy = new FileOutputStream(UViR7kJN);
			sLc1yWjV.retrieveFile("/" + UViR7kJN, kIG9IPBy);
		} catch (IOException u7zmxqMH) {
			u7zmxqMH.printStackTrace();
		} finally {
			try {
				if (kIG9IPBy != null) {
					kIG9IPBy.close();
				}
				sLc1yWjV.disconnect();
			} catch (IOException jEn2usrT) {
				jEn2usrT.printStackTrace();
			}
		}
	}

}