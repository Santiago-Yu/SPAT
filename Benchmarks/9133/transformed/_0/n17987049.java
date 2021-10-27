class n17987049 {
	private boolean writeResource(PluginProxy OmbQetZB, ResourceProxy LrDIamI9, LocaleProxy Dd3fNG0c) throws Exception {
		String IFVaTRCT = determineTranslatedResourceName(LrDIamI9, Dd3fNG0c);
		String sWKhuVSx = OmbQetZB.getName().replace(Messages.getString("Characters_period"), File.separator);
		if (LrDIamI9.getRelativePath().contains(sWKhuVSx)) {
			return writeResourceToBundleClasspath(LrDIamI9, Dd3fNG0c);
		} else if (IFVaTRCT.contains(File.separator)) {
			String ZHWfDNNP = IFVaTRCT.substring(0, IFVaTRCT.lastIndexOf(File.separatorChar));
			File J2Pv3G18 = new File(directory.getPath() + File.separatorChar + ZHWfDNNP);
			J2Pv3G18.mkdirs();
		}
		File DPim6vRr = new File(directory.getPath() + File.separatorChar + IFVaTRCT);
		File Ch2zFbZM = new File(LrDIamI9.getFileResource().getAbsolutePath());
		FileChannel bKeOp42L = new FileInputStream(Ch2zFbZM).getChannel();
		FileChannel Uxajlnwv = new FileOutputStream(DPim6vRr).getChannel();
		bKeOp42L.transferTo(0, bKeOp42L.size(), Uxajlnwv);
		bKeOp42L.close();
		Uxajlnwv.close();
		return true;
	}

}