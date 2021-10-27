class n17981986 {
	public void saveProjectFile(File Z2bMVmfM) {
		SimpleDateFormat Rdpp8EDc = new SimpleDateFormat("yyMMddHHmmss");
		File v2azAMbp = new File(theProjectsDirectory, Rdpp8EDc.format(Calendar.getInstance().getTime()));
		if (v2azAMbp.mkdirs()) {
			File cL8aBzQa = new File(v2azAMbp, "project.xml");
			try {
				FileChannel Nc6pEckH = new FileInputStream(Z2bMVmfM).getChannel();
				FileChannel jMSxnbRx = new FileOutputStream(cL8aBzQa).getChannel();
				Nc6pEckH.transferTo(0, Nc6pEckH.size(), jMSxnbRx);
				Nc6pEckH.close();
				jMSxnbRx.close();
			} catch (IOException jV0dGTcT) {
				jV0dGTcT.printStackTrace();
			} finally {
				Z2bMVmfM.delete();
			}
		}
	}

}