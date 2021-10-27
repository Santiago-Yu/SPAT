class n13733916 {
	public static void fileTrans(String kRycLkOM, String sta3z0Cu, String gsuTHAck, String j4cZZUtD, int EnVAT4O3) {
		try {
			URL oHyYS9EX = new URL(sta3z0Cu);
			oHyYS9EX.openStream();
		} catch (Exception jzjyWMYZ) {
			jzjyWMYZ.printStackTrace();
		}
		File JlnvF7U6 = new File(kRycLkOM);
		try {
			FileInputStream nnH5lykU = new FileInputStream(JlnvF7U6);
			Socket pZT4toas = new Socket(InetAddress.getByName(j4cZZUtD), EnVAT4O3);
			OutputStream sX4J7W1Y = pZT4toas.getOutputStream();
			DataOutputStream MmSQFFyW = new DataOutputStream(new BufferedOutputStream(sX4J7W1Y));
			byte[] XNHddCmC = new byte[2048];
			int FK3cxng4 = nnH5lykU.read(XNHddCmC);
			while (FK3cxng4 != -1) {
				MmSQFFyW.write(XNHddCmC, 0, FK3cxng4);
				MmSQFFyW.flush();
				FK3cxng4 = nnH5lykU.read(XNHddCmC);
			}
			nnH5lykU.close();
			MmSQFFyW.close();
			pZT4toas.close();
		} catch (Exception adZ13lgq) {
			adZ13lgq.printStackTrace();
		}
		try {
			URL QnfCFHiW = new URL(gsuTHAck);
			QnfCFHiW.openStream();
		} catch (Exception uuqUAJYi) {
			uuqUAJYi.printStackTrace();
		}
	}

}