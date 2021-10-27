class n18578541 {
	public static boolean copyFile(File I9pVGhPG, File zyv7r2Kt) {
		InputStream pAxbUi6d = null;
		OutputStream smh2ogQj = null;
		try {
			if (I9pVGhPG.createNewFile()) {
				pAxbUi6d = new FileInputStream(zyv7r2Kt);
				smh2ogQj = new FileOutputStream(I9pVGhPG);
				byte[] yGA0lFJE = new byte[1024];
				int z0067Sfy;
				while ((z0067Sfy = pAxbUi6d.read(yGA0lFJE)) > 0)
					smh2ogQj.write(yGA0lFJE, 0, z0067Sfy);
				pAxbUi6d.close();
				smh2ogQj.close();
			} else
				return false;
		} catch (IOException mOfpj8Rz) {
			mOfpj8Rz.printStackTrace();
			return false;
		}
		return true;
	}

}