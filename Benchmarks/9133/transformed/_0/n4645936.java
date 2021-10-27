class n4645936 {
	public static void creme_connect(String sRIQT32c, String XwLSBL7h, String ct4eKjuJ, String eOLTTOqI, TRP[] r83RRX42,
			GTRN[] tBtqP6TJ, FLUX[] VO4JzMFT, TRANS[] yvExG0fa, LETSPEC[] TcwFHDlc, PUP[] yb8QusLx, HUP[] I9usFVe2,
			DOSE[] WLZ785Us) {
		int tZOLld8n = r83RRX42.length + tBtqP6TJ.length + VO4JzMFT.length + yvExG0fa.length + TcwFHDlc.length
				+ yb8QusLx.length + I9usFVe2.length + WLZ785Us.length;
		int pq12NO5t = 0;
		String[] Zfy9qp8Y = new String[tZOLld8n];
		for (int yUm0EhTi = 0; yUm0EhTi < r83RRX42.length; yUm0EhTi++) {
			Zfy9qp8Y[pq12NO5t] = r83RRX42[yUm0EhTi].getThisFileName();
			pq12NO5t++;
		}
		for (int mZgqmXyi = 0; mZgqmXyi < tBtqP6TJ.length; mZgqmXyi++) {
			Zfy9qp8Y[pq12NO5t] = tBtqP6TJ[mZgqmXyi].getThisFileName();
			pq12NO5t++;
		}
		for (int hNO4YJrE = 0; hNO4YJrE < VO4JzMFT.length; hNO4YJrE++) {
			Zfy9qp8Y[pq12NO5t] = VO4JzMFT[hNO4YJrE].getThisFileName();
			pq12NO5t++;
		}
		for (int O08bPqo7 = 0; O08bPqo7 < yvExG0fa.length; O08bPqo7++) {
			Zfy9qp8Y[pq12NO5t] = yvExG0fa[O08bPqo7].getThisFileName();
			pq12NO5t++;
		}
		for (int TIsrRKW7 = 0; TIsrRKW7 < TcwFHDlc.length; TIsrRKW7++) {
			Zfy9qp8Y[pq12NO5t] = TcwFHDlc[TIsrRKW7].getThisFileName();
			pq12NO5t++;
		}
		for (int YMC9C3w3 = 0; YMC9C3w3 < yb8QusLx.length; YMC9C3w3++) {
			Zfy9qp8Y[pq12NO5t] = yb8QusLx[YMC9C3w3].getThisFileName();
			pq12NO5t++;
		}
		for (int Neca0eS2 = 0; Neca0eS2 < I9usFVe2.length; Neca0eS2++) {
			Zfy9qp8Y[pq12NO5t] = I9usFVe2[Neca0eS2].getThisFileName();
			pq12NO5t++;
		}
		for (int T8l7pPu6 = 0; T8l7pPu6 < WLZ785Us.length; T8l7pPu6++) {
			Zfy9qp8Y[pq12NO5t] = WLZ785Us[T8l7pPu6].getThisFileName();
			pq12NO5t++;
		}
		Logger LSd9DT2K = Logger.getLogger(CreateAStudy.class);
		String yEP4N90B = "creme96.nrl.navy.mil";
		String EATapx3Z = "anonymous";
		String o9XK0GWX = sRIQT32c;
		Logger.setLevel(Level.ALL);
		FTPClient LzpIz5gR = null;
		try {
			LzpIz5gR = new FTPClient();
			LzpIz5gR.setRemoteHost(yEP4N90B);
			FTPMessageCollector xs3OMJOQ = new FTPMessageCollector();
			LzpIz5gR.setMessageListener(xs3OMJOQ);
			LSd9DT2K.info("Connecting");
			LzpIz5gR.connect();
			LSd9DT2K.info("Logging in");
			LzpIz5gR.login(EATapx3Z, o9XK0GWX);
			LSd9DT2K.debug("Setting up passive, ASCII transfers");
			LzpIz5gR.setConnectMode(FTPConnectMode.ACTIVE);
			LzpIz5gR.setType(FTPTransferType.BINARY);
			LSd9DT2K.info("Putting file");
			for (int QvtDoXaG = 0; QvtDoXaG < Zfy9qp8Y.length; QvtDoXaG++) {
				LzpIz5gR.put(Zfy9qp8Y[QvtDoXaG], Zfy9qp8Y[QvtDoXaG]);
			}
			LSd9DT2K.info("Quitting client");
			LzpIz5gR.quit();
			LSd9DT2K.debug("Listener log:");
			LSd9DT2K.info("Test complete");
		} catch (Exception dUUnIWut) {
			LSd9DT2K.error("Demo failed", dUUnIWut);
			dUUnIWut.printStackTrace();
		}
		System.out.println("Finished FTPing User Request Files to common directory");
		Upload_Files.upload(Zfy9qp8Y, XwLSBL7h, ct4eKjuJ, eOLTTOqI);
		System.out.println("Finished transfering User Request Files to your CREME96 personal directory");
		RunRoutines.routines(Zfy9qp8Y, XwLSBL7h, ct4eKjuJ, eOLTTOqI);
		System.out.println("Finished running all of your uploaded routines");
	}

}