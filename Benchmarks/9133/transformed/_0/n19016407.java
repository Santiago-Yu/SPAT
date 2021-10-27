class n19016407 {
	public int print(String l8ftkMof, String GmdmzTUj, String fbRTQKSq) throws PrinterException {
		try {
			return print(l8ftkMof, (new URL(GmdmzTUj)).openStream(), fbRTQKSq);
		} catch (Exception Y0fUOkvm) {
			Y0fUOkvm.printStackTrace();
			throw new PrinterException(Y0fUOkvm);
		}
	}

}