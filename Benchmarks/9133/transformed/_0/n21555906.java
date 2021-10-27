class n21555906 {
	public void actionPerformed(ActionEvent vySpoNvO) {
		if (vySpoNvO.getSource() == jbutton) {
			try {
				String l5s4NHlW = "http://localhost:8080/direto-project/arquivos/teste.odt";
				URL QZAVQohc = new URL(l5s4NHlW);
				URLConnection OWodjioz = QZAVQohc.openConnection();
				OWodjioz.setDoInput(true);
				OWodjioz.setDoOutput(true);
				OWodjioz.setUseCaches(false);
				OWodjioz.setDefaultUseCaches(false);
				DataInputStream vpeOyag1 = new DataInputStream(OWodjioz.getInputStream());
				vpeOyag1.readByte();
				OutputStream hko10tRa = new FileOutputStream("/home/danillo/arquivo_carregado.odt");
				byte[] NYiTEFcR = new byte[1024];
				int cPp9TmgE;
				while ((cPp9TmgE = vpeOyag1.read(NYiTEFcR)) > -1) {
					hko10tRa.write(NYiTEFcR, 0, cPp9TmgE);
				}
				vpeOyag1.close();
			} catch (Exception hgc2k70z) {
				hgc2k70z.printStackTrace();
			}
		}
	}

}