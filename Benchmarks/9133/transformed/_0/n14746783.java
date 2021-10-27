class n14746783 {
	private static void copyObjects(File[] CaynIrmS, String cogbTebP) {
		for (int IesCAhtO = 0; IesCAhtO < CaynIrmS.length; IesCAhtO++) {
			try {
				File uI5jj5ub = CaynIrmS[IesCAhtO];
				File plSBKH4u = new File(cogbTebP + CaynIrmS[IesCAhtO].getName());
				FileReader A8FQHMUG = new FileReader(uI5jj5ub);
				FileWriter r4HHs9Jc = new FileWriter(plSBKH4u);
				int VsgU0TwS;
				while ((VsgU0TwS = A8FQHMUG.read()) != -1)
					r4HHs9Jc.write(VsgU0TwS);
				A8FQHMUG.close();
				r4HHs9Jc.close();
			} catch (Exception Wx0cCwkJ) {
				Logger.error(Wx0cCwkJ.getClass() + " " + Wx0cCwkJ.getMessage());
				for (int QPQ2Z3JE = 0; QPQ2Z3JE < Wx0cCwkJ.getStackTrace().length; QPQ2Z3JE++)
					Logger.error("     " + Wx0cCwkJ.getStackTrace()[QPQ2Z3JE].toString());
				Wx0cCwkJ.printStackTrace();
			}
		}
	}

}