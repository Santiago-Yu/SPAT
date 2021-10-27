class n20805582 {
	public void copyFile(File dRgs9s4E, File p898rTaP) {
		try {
			FileChannel TXInYW1a = (new FileInputStream(dRgs9s4E)).getChannel();
			FileChannel Uyyj8ruC = (new FileOutputStream(p898rTaP)).getChannel();
			TXInYW1a.transferTo(0, dRgs9s4E.length(), Uyyj8ruC);
			TXInYW1a.close();
			Uyyj8ruC.close();
		} catch (Exception waV5zQnP) {
			System.out.println(waV5zQnP);
		}
	}

}