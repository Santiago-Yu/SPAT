class n23658098 {
	public void copyFile(File xXryKv0i, File K8CRh7SO) throws Exception {
		FileChannel vktNrlw7 = new FileInputStream(xXryKv0i).getChannel();
		FileChannel pPTRCHEB = new FileOutputStream(K8CRh7SO).getChannel();
		vktNrlw7.transferTo(0, vktNrlw7.size(), pPTRCHEB);
		vktNrlw7.close();
		pPTRCHEB.close();
	}

}