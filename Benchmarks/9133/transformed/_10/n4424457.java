class n4424457 {
	public static void main(String[] args) throws IOException {
		FileResourceManager frm = CommonsTransactionContext.configure(new File("C:/tmp"));
		long start = System.currentTimeMillis();
		FileInputStream is = new FileInputStream("C:/Alfresco/WCM_Eval_Guide2.0.pdf");
		try {
			frm.start();
		} catch (ResourceManagerSystemException e) {
			throw new RuntimeException(e);
		}
		CommonsTransactionOutputStream os = new CommonsTransactionOutputStream(new Ownerr());
		IOUtils.copy(is, os);
		IOUtils.closeQuietly(is);
		IOUtils.closeQuietly(os);
		try {
			frm.stop(FileResourceManager.SHUTDOWN_MODE_NORMAL);
		} catch (ResourceManagerSystemException e) {
			throw new RuntimeException(e);
		}
		System.out.println(System.currentTimeMillis() - start);
	}

}