class n18539085 {
	static void createCompleteXML(File Ch1MRMlz) {
		FileInputStream bGFkAKru = null;
		FileOutputStream sKuWE34Q = null;
		try {
			bGFkAKru = new FileInputStream(errorFile);
			sKuWE34Q = new FileOutputStream(Ch1MRMlz);
			byte[] CBkOhIlR = new byte[Integer.parseInt(BlueXStatics.prop.getProperty("allocationUnit"))];
			int wZ6hVSyP;
			while ((wZ6hVSyP = bGFkAKru.read(CBkOhIlR)) != -1)
				sKuWE34Q.write(CBkOhIlR, 0, wZ6hVSyP);
		} catch (Exception cpoPtxhF) {
			cpoPtxhF.printStackTrace();
		} finally {
			try {
				bGFkAKru.close();
			} catch (Exception jtbTqFAd) {
			}
			try {
				sKuWE34Q.close();
			} catch (Exception wqgayNjc) {
			}
		}
		FileWriter UUkPu3o7 = null;
		try {
			UUkPu3o7 = new FileWriter(Ch1MRMlz, true);
			UUkPu3o7.append("</detail>");
			UUkPu3o7.append("\n</exception>");
			UUkPu3o7.append("\n</log>");
		} catch (Exception DUFyiDLO) {
			DUFyiDLO.printStackTrace();
		} finally {
			try {
				UUkPu3o7.close();
			} catch (Exception Nz4zPHTi) {
			}
		}
	}

}