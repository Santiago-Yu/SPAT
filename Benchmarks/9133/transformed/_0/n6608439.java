class n6608439 {
	public static void main(String[] iZWwdRTa) {
		FTPClient kTZ68RjR = new FTPClient();
		try {
			File OGEo80G8 = new File("C:/temp/testLoribel.html");
			String dq9v4TOp = "http://www.loribel.com/index.html";
			GB_HttpTools.loadUrlToFile(dq9v4TOp, OGEo80G8, ENCODING.ISO_8859_1);
			System.out.println("Try to connect...");
			kTZ68RjR.connect("ftp://ftp.phpnet.org");
			System.out.println("Connected to server");
			System.out.println("Try to connect...");
			boolean b6yIAISH = kTZ68RjR.login("fff", "ddd");
			System.out.println("Login: " + b6yIAISH);
			String[] IiaYa0Oc = kTZ68RjR.listNames();
			GB_DebugTools.debugArray(GB_FtpDemo2.class, "names", IiaYa0Oc);
			b6yIAISH = kTZ68RjR.makeDirectory("test02/toto");
			System.out.println("Mkdir: " + b6yIAISH);
			String zlPyVkRS = "test02/test.xml";
			InputStream t1OryvzH = new StringInputStream("Test111111111111111");
			b6yIAISH = kTZ68RjR.storeFile(zlPyVkRS, t1OryvzH);
			System.out.println("Copy file: " + b6yIAISH);
		} catch (Exception TngXRfHz) {
			TngXRfHz.printStackTrace();
		}
	}

}