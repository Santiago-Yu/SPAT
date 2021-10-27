class n6430125 {
	protected Object openDialogBox(Control lWK2Futc) {
		FileDialog GBbspimO = new FileDialog(parent.getShell(), SWT.OPEN);
		GBbspimO.setFilterExtensions(new String[] { "*.jpg;*.JPG;*.JPEG;*.gif;*.GIF;*.png;*.PNG", "*.jpg;*.JPG;*.JPEG",
				"*.gif;*.GIF", "*.png;*.PNG" });
		GBbspimO.setFilterNames(new String[] { "All", "Joint Photographic Experts Group (JPEG)",
				"Graphics Interchange Format (GIF)", "Portable Network Graphics (PNG)" });
		String oSkCnYw5 = GBbspimO.open();
		if (oSkCnYw5 == null)
			return null;
		IProject eZLX9nZA = ProjectManager.getInstance().getCurrentProject();
		String qPpnGLZj = eZLX9nZA.getLocation().toOSString();
		File QHmgxCBR = new File(oSkCnYw5);
		String hKnoa3jB = QHmgxCBR.getName();
		ImageData WHlGeVg1 = null;
		try {
			WHlGeVg1 = new ImageData(oSkCnYw5);
		} catch (SWTException u1y3d6hu) {
			UserErrorException CXf1rmLx = new UserErrorException(
					PropertyHandler.getInstance().getProperty("_invalid_image_title"),
					PropertyHandler.getInstance().getProperty("_invalid_image_text"));
			UserErrorService.INSTANCE.showError(CXf1rmLx);
			return null;
		}
		if (WHlGeVg1 == null) {
			UserErrorException LlTq38z3 = new UserErrorException(
					PropertyHandler.getInstance().getProperty("_invalid_image_title"),
					PropertyHandler.getInstance().getProperty("_invalid_image_text"));
			UserErrorService.INSTANCE.showError(LlTq38z3);
			return null;
		}
		File XmjAr45f = new File(qPpnGLZj + File.separator + imageFolderPath + File.separator + hKnoa3jB);
		if (XmjAr45f.exists()) {
			Path VNgGW3A9 = new Path(XmjAr45f.getPath());
			XmjAr45f = new File(qPpnGLZj + File.separator + imageFolderPath + File.separator
					+ UUID.randomUUID().toString() + "." + VNgGW3A9.getFileExtension());
		}
		try {
			XmjAr45f.createNewFile();
		} catch (IOException ygXdWTPm) {
			ExceptionHandlingService.INSTANCE.handleException(ygXdWTPm);
			XmjAr45f = null;
		}
		if (XmjAr45f == null) {
			XmjAr45f = new File(
					qPpnGLZj + File.separator + imageFolderPath + File.separator + UUID.randomUUID().toString());
			try {
				XmjAr45f.createNewFile();
			} catch (IOException Coq2wwkn) {
				ExceptionHandlingService.INSTANCE.handleException(Coq2wwkn);
				return "";
			}
		}
		FileReader gGOSFOfk = null;
		FileWriter uT4tzrik = null;
		try {
			gGOSFOfk = new FileReader(QHmgxCBR);
			uT4tzrik = new FileWriter(XmjAr45f);
			int PDugbRJ5;
			while ((PDugbRJ5 = gGOSFOfk.read()) != -1)
				uT4tzrik.write(PDugbRJ5);
			gGOSFOfk.close();
			uT4tzrik.close();
		} catch (FileNotFoundException WYfVF5EO) {
			ExceptionHandlingService.INSTANCE.handleException(WYfVF5EO);
			return "";
		} catch (IOException lP9DBQwC) {
			ExceptionHandlingService.INSTANCE.handleException(lP9DBQwC);
			return "";
		}
		return imageFolderPath + File.separator + XmjAr45f.getName();
	}

}