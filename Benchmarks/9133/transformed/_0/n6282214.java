class n6282214 {
	public static boolean Copy(String Wc2efjRI, String AZwHlwW4) {
		try {
			int bKhhnIv2 = 0;
			int psTvnal3 = -1;
			java.io.File dLTLlQoA = new java.io.File(Wc2efjRI);
			if (dLTLlQoA.exists()) {
				InputStream AagiSIbi = new FileInputStream(Wc2efjRI);
				FileOutputStream jZtv1qOQ = new FileOutputStream(AZwHlwW4);
				byte[] sOxQA92a = new byte[1024];
				while ((psTvnal3 = AagiSIbi.read(sOxQA92a)) != -1) {
					bKhhnIv2 += psTvnal3;
					jZtv1qOQ.write(sOxQA92a, 0, psTvnal3);
				}
				AagiSIbi.close();
				jZtv1qOQ.close();
			} else {
				return false;
			}
		} catch (Exception PuMS9Bjt) {
			System.out.println("processFile.copyFile()?????????????????? " + PuMS9Bjt.getMessage());
			return false;
		}
		return true;
	}

}