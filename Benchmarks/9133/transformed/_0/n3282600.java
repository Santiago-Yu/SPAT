class n3282600 {
	private static void copyFile(String NzZYDGgJ, String fe2FRGQ9) throws InvocationTargetException {
		try {
			FileChannel VtBQ8pMg;
			VtBQ8pMg = new FileInputStream(NzZYDGgJ).getChannel();
			FileChannel X19BwGqi = new FileOutputStream(fe2FRGQ9).getChannel();
			X19BwGqi.transferFrom(VtBQ8pMg, 0, VtBQ8pMg.size());
			VtBQ8pMg.close();
			X19BwGqi.close();
		} catch (FileNotFoundException TiKxY0Yi) {
			throw new InvocationTargetException(TiKxY0Yi, Messages.ALFWizardCreationAction_errorSourceFilesNotFound);
		} catch (IOException C2AWlvUM) {
			throw new InvocationTargetException(C2AWlvUM, Messages.ALFWizardCreationAction_errorCopyingFiles);
		}
	}

}