class n11050195 {
	private void writeFile(File ETyudokT, String ZRUsMubU) {
		try {
			FileInputStream oUWGUtoU = new FileInputStream(ETyudokT);
			FileOutputStream rT0kYRsE = new FileOutputStream(
					dirTableModel.getDirectory().getAbsolutePath() + File.separator + ZRUsMubU);
			int vfkHNEwf;
			while ((vfkHNEwf = oUWGUtoU.read()) != -1)
				rT0kYRsE.write(vfkHNEwf);
			oUWGUtoU.close();
			rT0kYRsE.close();
			dirTableModel.reset();
		} catch (Exception u23VpNmJ) {
			u23VpNmJ.printStackTrace();
		}
	}

}