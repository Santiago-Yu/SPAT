class n21693488 {
	public static String getProgramVersion() {
		String A04YgIL8 = "0";
		try {
			URL cYec6RwT;
			URLConnection d1jmvhtq;
			DataInputStream PjrSbc6W;
			cYec6RwT = new URL("http://www.dombosfest.org.yu/log/yamiversion.dat");
			d1jmvhtq = cYec6RwT.openConnection();
			d1jmvhtq.setDoInput(true);
			d1jmvhtq.setUseCaches(false);
			PjrSbc6W = new DataInputStream(d1jmvhtq.getInputStream());
			while ((PjrSbc6W.readUTF()) != null) {
				A04YgIL8 = PjrSbc6W.readUTF();
			}
			PjrSbc6W.close();
		} catch (MalformedURLException kYEGUvCa) {
			System.out.println("mue:" + kYEGUvCa.getMessage());
		} catch (IOException INX3Sgxd) {
			System.out.println("ioe:" + INX3Sgxd.getMessage());
		}
		return A04YgIL8;
	}

}