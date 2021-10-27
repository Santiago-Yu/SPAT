class n6975979 {
	public static void main(String[] NSMPRd1C) {
		FTPClient VSwjTZUc = new FTPClient();
		String B8SJ6BHW = "ftpdatos.aemet.es";
		SimpleDateFormat zC2WlX6f = new SimpleDateFormat("yyyyMMdd");
		final String DmOMv1cD = zC2WlX6f.format(new Date());
		System.out.println(DmOMv1cD);
		String wU7FIl5f = "datos_observacion/observaciones_diezminutales/" + DmOMv1cD + "_diezminutales/";
		try {
			InetAddress bgjbJMgo = InetAddress.getByName(B8SJ6BHW);
			VSwjTZUc.connect(bgjbJMgo);
			String Tb7UYPkL = "anonymous";
			String z7exPDql = "a@b.c";
			VSwjTZUc.login(Tb7UYPkL, z7exPDql);
			FTPFile[] wrCZZYu1 = VSwjTZUc.listFiles(wU7FIl5f, new FTPFileFilter() {

				@Override
				public boolean accept(FTPFile fpRNl6T9) {
					return fpRNl6T9.getName().startsWith(DmOMv1cD);
				}
			});
			FTPFile LpF63uMQ = wrCZZYu1[wrCZZYu1.length - 2];
			VSwjTZUc.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
			boolean EGn7EN13 = false;
			String WETAdvgg = wU7FIl5f + "/" + LpF63uMQ.getName();
			if (EGn7EN13) {
				File QTSgpiZe = new File("/home/randres/Desktop/" + LpF63uMQ.getName());
				FileOutputStream jVfIKY4D = new FileOutputStream(QTSgpiZe);
				System.out.println(VSwjTZUc.retrieveFile(WETAdvgg, jVfIKY4D));
				jVfIKY4D.flush();
				jVfIKY4D.close();
			} else {
				GZIPInputStream A3r7EwU5 = new GZIPInputStream(VSwjTZUc.retrieveFileStream(WETAdvgg));
				LineNumberReader rhYgxf2H = new LineNumberReader(new InputStreamReader(A3r7EwU5, "Cp1250"));
				String h0CtBine = null;
				while ((h0CtBine = rhYgxf2H.readLine()) != null) {
					Aeminuto.processLine(h0CtBine);
				}
				rhYgxf2H.close();
			}
			VSwjTZUc.disconnect();
		} catch (Exception jyAJgrUP) {
			jyAJgrUP.printStackTrace();
		}
	}

}