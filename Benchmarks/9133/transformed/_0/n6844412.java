class n6844412 {
	public static void copyResourceFileTo(String OoUz8SQz, String Uu0yQlEb) {
		if (OoUz8SQz == null || Uu0yQlEb == null)
			throw new IllegalArgumentException("Argument cannot be null.");
		try {
			FileInputStream vcmBtfLD = null;
			FileOutputStream BE4NVeM1 = null;
			URL SEnYrxMr = HelperMethods.class.getResource(Uu0yQlEb);
			if (SEnYrxMr == null) {
				System.out.println("URL " + Uu0yQlEb + " cannot be created.");
				return;
			}
			String kuXLF8FK = SEnYrxMr.getFile();
			kuXLF8FK = kuXLF8FK.replaceAll("%20", " ");
			File xM70Zt6X = new File(kuXLF8FK);
			if (!xM70Zt6X.isFile()) {
				System.out.println(kuXLF8FK + " cannot be opened.");
				return;
			}
			vcmBtfLD = new FileInputStream(xM70Zt6X);
			BE4NVeM1 = new FileOutputStream(new File(OoUz8SQz));
			int RJsEz2ep;
			while ((RJsEz2ep = vcmBtfLD.read()) != -1)
				BE4NVeM1.write(RJsEz2ep);
			vcmBtfLD.close();
			BE4NVeM1.close();
		} catch (IOException v78M0Asa) {
			v78M0Asa.printStackTrace();
		}
	}

}