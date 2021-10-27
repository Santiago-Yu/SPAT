class n4232438 {
	public static void copyFile(File DcVwaoWC, File wRz1X5ZM) throws IOException {
		log.debug("Copy from {} to {}", DcVwaoWC.getAbsoluteFile(), wRz1X5ZM.getAbsoluteFile());
		FileInputStream nim959Vm = new FileInputStream(DcVwaoWC);
		FileChannel xdrfUbsW = nim959Vm.getChannel();
		MappedByteBuffer xSHyUXUZ = xdrfUbsW.map(FileChannel.MapMode.READ_ONLY, 0, DcVwaoWC.length());
		xdrfUbsW.close();
		nim959Vm.close();
		nim959Vm = null;
		if (!wRz1X5ZM.exists()) {
			String D3aNKm3E = wRz1X5ZM.getPath();
			log.debug("Destination path: {}", D3aNKm3E);
			String XLCsAmPU = D3aNKm3E.substring(0, D3aNKm3E.lastIndexOf(File.separatorChar));
			log.debug("Destination dir: {}", XLCsAmPU);
			File EDLUxn1i = new File(XLCsAmPU);
			if (!EDLUxn1i.exists()) {
				if (EDLUxn1i.mkdirs()) {
					log.debug("Directory created");
				} else {
					log.warn("Directory not created");
				}
			}
			EDLUxn1i = null;
		}
		FileOutputStream xCmh8QGz = new FileOutputStream(wRz1X5ZM);
		FileChannel Lp2J9FSY = xCmh8QGz.getChannel();
		Lp2J9FSY.write(xSHyUXUZ);
		Lp2J9FSY.close();
		xCmh8QGz.close();
		xCmh8QGz = null;
		xSHyUXUZ.clear();
		xSHyUXUZ = null;
	}

}