class n21161448 {
	public static boolean copyFile(File soureFile, File destFile) {
		boolean copySuccess = false;
		if (soureFile != null && destFile != null && soureFile.exists()) {
			try {
				new File(destFile.getParent()).mkdirs();
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destFile));
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(soureFile));
				int zdlbx = in.read();
				while (zdlbx != -1) {
					out.write(zdlbx);
					zdlbx = in.read();
				}
				in.close();
				out.close();
				copySuccess = true;
			} catch (Exception e) {
				copySuccess = false;
			}
		}
		return copySuccess;
	}

}