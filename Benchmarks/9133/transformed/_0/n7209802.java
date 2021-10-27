class n7209802 {
	public static void main(String[] iavhtHkG) throws IOException {
		ServerSocket MK5UyS4p = null;
		try {
			MK5UyS4p = new ServerSocket(4444);
		} catch (IOException EDUMDBSk) {
			System.err.println("Could not listen on port: 4444.");
			System.exit(1);
		}
		Socket kflOMERW = null;
		try {
			kflOMERW = MK5UyS4p.accept();
		} catch (IOException cGgMz5rY) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		DataOutputStream xbnxv09d = new DataOutputStream(kflOMERW.getOutputStream());
		BufferedReader pCXCM60y = new BufferedReader(new InputStreamReader(kflOMERW.getInputStream()));
		String OETsgV8b, p6Ggx2cf;
		OETsgV8b = pCXCM60y.readLine();
		String j9Quz3PJ = pCXCM60y.readLine();
		File cZ3iUdH3 = new File("data.txt");
		FileWriter Q6Fptb4U = new FileWriter(cZ3iUdH3);
		Q6Fptb4U.write(OETsgV8b);
		Q6Fptb4U.close();
		File edI3OKcK = new File("sample_coords.txt");
		edI3OKcK.delete();
		File zwHP7rGP = new File("sp_coords.txt");
		zwHP7rGP.delete();
		try {
			System.out.println("Running python script...");
			System.out.println("Command: " + "python l19test.py " + "\"" + j9Quz3PJ + "\"");
			Process G8dBze61 = Runtime.getRuntime().exec("python l19test.py " + j9Quz3PJ);
			BufferedReader L34xrEEB = new BufferedReader(new InputStreamReader(G8dBze61.getErrorStream()));
			String Zf3J9fcV;
			while ((Zf3J9fcV = L34xrEEB.readLine()) != null) {
				System.out.println(Zf3J9fcV);
			}
			int xyy1Is8p = G8dBze61.waitFor();
			System.out.println("Process Exit Value: " + xyy1Is8p);
			System.out.println("done.");
		} catch (Exception WduXm8qk) {
			System.out.println("Unable to run python script for PCoA analysis");
		}
		File btdyl7rr = new File("sp_coords.txt");
		byte[] QDCpnGA4 = new byte[(new Long(btdyl7rr.length())).intValue()];
		FileInputStream DyZ8Ryv4 = new FileInputStream(btdyl7rr);
		System.out.println(".");
		System.out.println(btdyl7rr.length());
		xbnxv09d.writeInt((int) btdyl7rr.length());
		for (int EJXqqnbD = 0; EJXqqnbD < btdyl7rr.length(); EJXqqnbD++) {
			xbnxv09d.writeByte(DyZ8Ryv4.read());
		}
		btdyl7rr = new File("sample_coords.txt");
		QDCpnGA4 = new byte[(int) btdyl7rr.length()];
		DyZ8Ryv4 = new FileInputStream(btdyl7rr);
		DyZ8Ryv4.read(QDCpnGA4);
		System.out.println(".");
		System.out.println(btdyl7rr.length());
		xbnxv09d.writeInt((int) btdyl7rr.length());
		xbnxv09d.write(QDCpnGA4);
		btdyl7rr = new File("evals.txt");
		QDCpnGA4 = new byte[(new Long(btdyl7rr.length())).intValue()];
		DyZ8Ryv4 = new FileInputStream(btdyl7rr);
		DyZ8Ryv4.read(QDCpnGA4);
		System.out.println(".");
		System.out.println(btdyl7rr.length());
		xbnxv09d.writeInt((int) btdyl7rr.length());
		xbnxv09d.write(QDCpnGA4);
		xbnxv09d.flush();
		xbnxv09d.close();
		pCXCM60y.close();
		kflOMERW.close();
		MK5UyS4p.close();
	}

}