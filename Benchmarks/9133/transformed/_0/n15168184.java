class n15168184 {
	public void copyServer(int p8nQMoA3) throws Exception {
		File PdIi2Pk0 = new File("servers" + File.separatorChar + "server_" + p8nQMoA3);
		File KWdjDO2n = new File("servers" + File.separatorChar);
		int CMiMfLFu = KWdjDO2n.listFiles().length + 1;
		System.out.println("New File Number: " + CMiMfLFu);
		File Ag0TKyx5 = new File("servers" + File.separatorChar + "server_" + CMiMfLFu);
		FileChannel smpMgogA = new FileInputStream(PdIi2Pk0).getChannel();
		FileChannel qKdHNORX = new FileOutputStream(Ag0TKyx5).getChannel();
		try {
			smpMgogA.transferTo(0, smpMgogA.size(), qKdHNORX);
		} catch (Exception RrRezpWu) {
			RrRezpWu.printStackTrace();
		} finally {
			if (smpMgogA != null)
				smpMgogA.close();
			if (qKdHNORX != null)
				qKdHNORX.close();
		}
		getServer(CMiMfLFu - 1);
	}

}