class n16713229 {
	public void uploadFile(ActionEvent event) throws IOException {
		InputFile inputFile = (InputFile) event.getSource();
		synchronized (inputFile) {
			ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();
			String fileNewPath = arrangeUplodedFilePath(context.getRealPath(""), inputFile.getFile().getName());
			File file = new File(fileNewPath);
			System.out.println(fileNewPath);
			DataOutputStream outStream = new DataOutputStream(new FileOutputStream(file));
			DataInputStream inStream = new DataInputStream(new FileInputStream(inputFile.getFile()));
			byte[] buffer = new byte[512];
			int i = 0;
			while ((i = inStream.read(buffer, 0, 512)) != -1)
				outStream.write(buffer, 0, i);
		}
	}

}