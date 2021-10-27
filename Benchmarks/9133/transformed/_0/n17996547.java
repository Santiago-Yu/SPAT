class n17996547 {
	public static File copyFile(File lKmkfkSD, File Mj2EHsB5) {
		BufferedInputStream SJlfkDiD = null;
		BufferedOutputStream fjD6DKiO = null;
		if (!Mj2EHsB5.exists()) {
			try {
				Mj2EHsB5.createNewFile();
			} catch (IOException YFrJD288) {
				YFrJD288.printStackTrace();
				return null;
			}
		}
		try {
			SJlfkDiD = new BufferedInputStream(new FileInputStream(lKmkfkSD), 4096);
			fjD6DKiO = new BufferedOutputStream(new FileOutputStream(Mj2EHsB5), 4096);
			int Ig4ejzkN;
			while ((Ig4ejzkN = SJlfkDiD.read()) != -1)
				fjD6DKiO.write(Ig4ejzkN);
			SJlfkDiD.close();
			fjD6DKiO.close();
		} catch (FileNotFoundException RbsFqCZb) {
			RbsFqCZb.printStackTrace();
			return null;
		} catch (IOException zhTgsEJl) {
			zhTgsEJl.printStackTrace();
			return null;
		}
		return Mj2EHsB5;
	}

}