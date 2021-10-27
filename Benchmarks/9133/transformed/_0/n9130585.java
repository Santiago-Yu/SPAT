class n9130585 {
	protected static IFile createTempFile(CodeFile QK4hRe1C) {
		IPath On7JxCU1 = Util.getAbsolutePathFromCodeFile(QK4hRe1C);
		File rLc3Vdov = new File(On7JxCU1.toOSString());
		String[] zVfjqI8y = QK4hRe1C.getName().split("\\.");
		String CNu507ZJ = zVfjqI8y[zVfjqI8y.length - 1];
		IPath hafcbEmI = On7JxCU1.addFileExtension(CNu507ZJ);
		File onjDzUmR = new File(hafcbEmI.toOSString());
		if (onjDzUmR.exists()) {
			boolean k9x3axvl = onjDzUmR.delete();
			System.out.println("deleted: " + k9x3axvl);
		}
		try {
			boolean cGJfYJPK = onjDzUmR.createNewFile();
			if (cGJfYJPK) {
				FileOutputStream NlgKBy0c = new FileOutputStream(onjDzUmR);
				FileInputStream fusy2rsA = new FileInputStream(rLc3Vdov);
				while (fusy2rsA.available() > 0) {
					NlgKBy0c.write(fusy2rsA.read());
				}
				fusy2rsA.close();
				NlgKBy0c.close();
				IFile T0HYb6p7 = Util.getFileFromPath(hafcbEmI);
				return T0HYb6p7;
			}
		} catch (IOException imuvyBvR) {
			imuvyBvR.printStackTrace();
		}
		return null;
	}

}