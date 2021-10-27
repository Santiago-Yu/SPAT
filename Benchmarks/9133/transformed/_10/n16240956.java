class n16240956 {
	public static void copyZip() {
		OutputStream os;
		InputStream is;
		String javacZip = "";
		try {
			if ("windows".equalsIgnoreCase(Compilador.getSo())) {
				is = UnZip.class.getResourceAsStream("javacWin.zip");
				javacZip = "javacWin.zip";
			} else if ("linux".equalsIgnoreCase(Compilador.getSo())) {
				is = UnZip.class.getResourceAsStream("javacLinux.zip");
				javacZip = "javacLinux.zip";
			}
			File tempZip = File.createTempFile("tempJavacJTraductor", ".zip");
			is = UnZip.class.getResourceAsStream(javacZip);
			tempZip.mkdir();
			tempZip.deleteOnExit();
			os = FileUtils.openOutputStream(tempZip);
			IOUtils.copy(is, os);
			is.close();
			os.close();
			extractZip(tempZip.getPath());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(PseutemView.mainPanel,
					"Error al copiar los archivos temporales necesarios para ejecutar el programa:\n\n" + ex,
					"Error copiando.", JOptionPane.ERROR_MESSAGE);
		}
	}

}