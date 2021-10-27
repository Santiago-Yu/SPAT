class n21555906 {
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jbutton) {
			try {
				String toservlet = "http://localhost:8080/direto-project/arquivos/teste.odt";
				URL servleturl = new URL(toservlet);
				URLConnection servletconnection = servleturl.openConnection();
				servletconnection.setDoInput(true);
				servletconnection.setDoOutput(true);
				servletconnection.setUseCaches(false);
				servletconnection.setDefaultUseCaches(false);
				DataInputStream inputFromClient = new DataInputStream(servletconnection.getInputStream());
				inputFromClient.readByte();
				byte[] buf = new byte[1024];
				OutputStream fos = new FileOutputStream("/home/danillo/arquivo_carregado.odt");
				int bytesread;
				while ((bytesread = inputFromClient.read(buf)) > -1) {
					fos.write(buf, 0, bytesread);
				}
				inputFromClient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}