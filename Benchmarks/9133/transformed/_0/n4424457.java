class n4424457 {
	public static void main(String[] nSHlJ3kp) throws IOException {
		long K9VcXYFO = System.currentTimeMillis();
		FileResourceManager t32uk5tk = CommonsTransactionContext.configure(new File("C:/tmp"));
		try {
			t32uk5tk.start();
		} catch (ResourceManagerSystemException HLqzrvPV) {
			throw new RuntimeException(HLqzrvPV);
		}
		FileInputStream uggMbVT6 = new FileInputStream("C:/Alfresco/WCM_Eval_Guide2.0.pdf");
		CommonsTransactionOutputStream GUyQm6Ix = new CommonsTransactionOutputStream(new Ownerr());
		IOUtils.copy(uggMbVT6, GUyQm6Ix);
		IOUtils.closeQuietly(uggMbVT6);
		IOUtils.closeQuietly(GUyQm6Ix);
		try {
			t32uk5tk.stop(FileResourceManager.SHUTDOWN_MODE_NORMAL);
		} catch (ResourceManagerSystemException hOWL5c31) {
			throw new RuntimeException(hOWL5c31);
		}
		System.out.println(System.currentTimeMillis() - K9VcXYFO);
	}

}