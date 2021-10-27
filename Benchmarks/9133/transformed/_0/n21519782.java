class n21519782 {
	protected static void copyDeleting(File POhCnhUt, File x1V8Bt7I) throws ErrorCodeException {
		byte[] ir0I4FER = new byte[8 * 1024];
		FileInputStream ej1yaHje = null;
		try {
			ej1yaHje = new FileInputStream(POhCnhUt);
			try {
				FileOutputStream I7UfaU44 = new FileOutputStream(x1V8Bt7I);
				try {
					int iItuSWqK;
					while ((iItuSWqK = ej1yaHje.read(ir0I4FER)) >= 0)
						I7UfaU44.write(ir0I4FER, 0, iItuSWqK);
				} finally {
					I7UfaU44.close();
				}
			} finally {
				ej1yaHje.close();
			}
		} catch (IOException nyLWjtrB) {
			throw new ErrorCodeException(nyLWjtrB);
		}
	}

}