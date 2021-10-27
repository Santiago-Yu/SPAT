class n16713229 {
	public void uploadFile(ActionEvent Sjme4XOT) throws IOException {
		InputFile e9uVHvnA = (InputFile) Sjme4XOT.getSource();
		synchronized (e9uVHvnA) {
			ServletContext ZSZKsWUr = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();
			String Nnj6GIAE = arrangeUplodedFilePath(ZSZKsWUr.getRealPath(""), e9uVHvnA.getFile().getName());
			File rOkZrTwp = new File(Nnj6GIAE);
			System.out.println(Nnj6GIAE);
			DataInputStream GA34KApr = new DataInputStream(new FileInputStream(e9uVHvnA.getFile()));
			DataOutputStream e428LbSR = new DataOutputStream(new FileOutputStream(rOkZrTwp));
			int N6C3E585 = 0;
			byte[] OZgRmT2l = new byte[512];
			while ((N6C3E585 = GA34KApr.read(OZgRmT2l, 0, 512)) != -1)
				e428LbSR.write(OZgRmT2l, 0, N6C3E585);
		}
	}

}