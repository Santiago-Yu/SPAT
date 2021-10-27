class n5638421 {
	private void copy(File joYC5Cz5, File umE8xBGD) {
		log.info("Copying yam file from: " + joYC5Cz5.getName() + " to: " + umE8xBGD.getName());
		try {
			FileChannel o38LDTVE = new FileInputStream(joYC5Cz5).getChannel();
			FileChannel DmDXKDvz = new FileOutputStream(umE8xBGD).getChannel();
			o38LDTVE.transferTo(0, o38LDTVE.size(), DmDXKDvz);
			o38LDTVE.close();
			DmDXKDvz.close();
		} catch (IOException mPsquXSo) {
			fail("Failed testing while copying modified file: " + mPsquXSo.getMessage());
		}
	}

}