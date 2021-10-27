class n10584420 {
	public static String checkUpdate() {
		URL PavUQN5m = null;
		try {
			PavUQN5m = new URL("http://googlemeupdate.bravehost.com/");
		} catch (MalformedURLException ioCG1ihA) {
			ioCG1ihA.printStackTrace();
		}
		InputStream JMBgOvhG = null;
		try {
			JMBgOvhG = PavUQN5m.openStream();
			int ydqDQADq = 0;
			String Jhcc1Dvz = "";
			String ZG7BloII = "";
			while (ydqDQADq != -1) {
				try {
					ydqDQADq = JMBgOvhG.read();
				} catch (IOException UK6Vdzzf) {
				}
				Jhcc1Dvz = Jhcc1Dvz + (char) ydqDQADq;
			}
			return Jhcc1Dvz.substring(Jhcc1Dvz.lastIndexOf("Google.mE Version: ") + 19, Jhcc1Dvz.indexOf("||"));
		} catch (IOException CvesAfkr) {
			CvesAfkr.printStackTrace();
			return "";
		}
	}

}