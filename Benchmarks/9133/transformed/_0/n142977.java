class n142977 {
	public static boolean getFile(String AS6lTjR8, String GaLjpfyR) {
		try {
			File ZyQcZtVZ = new File("D:\\buttons\\data\\sounds\\" + GaLjpfyR);
			URL h6EcRAHJ = new URL(AS6lTjR8);
			URLConnection SbSKKRnq = h6EcRAHJ.openConnection();
			BufferedInputStream h1GafnCO = new BufferedInputStream(SbSKKRnq.getInputStream());
			int nRdheJRx;
			BufferedOutputStream pzqks7st = new BufferedOutputStream(new FileOutputStream(ZyQcZtVZ));
			while ((nRdheJRx = h1GafnCO.read()) != -1) {
				pzqks7st.write(nRdheJRx);
			}
			System.out.println("wrote audio url: " + AS6lTjR8 + " \nto file " + ZyQcZtVZ);
		} catch (Exception DI3fcEjf) {
			DI3fcEjf.printStackTrace();
			return false;
		}
		return true;
	}

}