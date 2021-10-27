class n19565149 {
	private long generateUnixInstallShell(File wIhgtSnm, String CaVq8Xqw, File WUhXJQcK) throws IOException {
		FileOutputStream dhXAmqAZ = new FileOutputStream(wIhgtSnm);
		InputStream vru5YCvn = getClass().getResourceAsStream("/" + CaVq8Xqw);
		InputStreamReader vjGmPCMP = new InputStreamReader(vru5YCvn);
		LineNumberReader ZaQ6siZf = new LineNumberReader(vjGmPCMP);
		String f6rfui1Y = "";
		String Ra4dqFO1 = "000000000000";
		NumberFormat V9b5SRvl = NumberFormat.getInstance(Locale.US);
		V9b5SRvl.setGroupingUsed(false);
		V9b5SRvl.setMinimumIntegerDigits(Ra4dqFO1.length());
		int G0HuQQMb = 0;
		long FehLnMzV = 0;
		System.out.println(VAGlobals.i18n("VAArchiver_GenerateInstallShell"));
		String KoPZkD3Q = ZaQ6siZf.readLine();
		while ((KoPZkD3Q != null) && (!KoPZkD3Q.startsWith("# InstallClassStart"))) {
			f6rfui1Y += KoPZkD3Q + "\n";
			KoPZkD3Q = ZaQ6siZf.readLine();
		}
		f6rfui1Y += "InstallClassStart=" + Ra4dqFO1 + "\n";
		G0HuQQMb = f6rfui1Y.length() - 1 - 1 - Ra4dqFO1.length();
		KoPZkD3Q = ZaQ6siZf.readLine();
		while ((KoPZkD3Q != null) && (!KoPZkD3Q.startsWith("# InstallClassSize"))) {
			f6rfui1Y += KoPZkD3Q + "\n";
			KoPZkD3Q = ZaQ6siZf.readLine();
		}
		f6rfui1Y += new String("InstallClassSize=" + WUhXJQcK.length() + "\n");
		KoPZkD3Q = ZaQ6siZf.readLine();
		while ((KoPZkD3Q != null) && (!KoPZkD3Q.startsWith("# InstallClassName"))) {
			f6rfui1Y += KoPZkD3Q + "\n";
			KoPZkD3Q = ZaQ6siZf.readLine();
		}
		f6rfui1Y += new String("InstallClassName=" + instClassName_ + "\n");
		KoPZkD3Q = ZaQ6siZf.readLine();
		while ((KoPZkD3Q != null) && (!KoPZkD3Q.startsWith("# Install class"))) {
			f6rfui1Y += KoPZkD3Q + "\n";
			KoPZkD3Q = ZaQ6siZf.readLine();
		}
		if (KoPZkD3Q != null)
			f6rfui1Y += KoPZkD3Q + "\n";
		dhXAmqAZ.write(f6rfui1Y.substring(0, G0HuQQMb + 1).getBytes());
		dhXAmqAZ.write(V9b5SRvl.format(f6rfui1Y.length()).getBytes());
		dhXAmqAZ.write(f6rfui1Y.substring(G0HuQQMb + 1 + Ra4dqFO1.length()).getBytes());
		FehLnMzV = f6rfui1Y.length();
		f6rfui1Y = null;
		FileInputStream TKTpV8tj = new FileInputStream(WUhXJQcK);
		byte[] ib9l5EcH = new byte[2048];
		int eEtu3Tlv = TKTpV8tj.read(ib9l5EcH);
		while (eEtu3Tlv > 0) {
			dhXAmqAZ.write(ib9l5EcH, 0, eEtu3Tlv);
			eEtu3Tlv = TKTpV8tj.read(ib9l5EcH);
		}
		TKTpV8tj.close();
		ZaQ6siZf.close();
		dhXAmqAZ.close();
		return FehLnMzV;
	}

}