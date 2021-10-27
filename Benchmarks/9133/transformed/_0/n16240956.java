class n16240956 {
	public static void copyZip() {
		InputStream zu1KwYKV;
		OutputStream gABaTMyQ;
		String tmC5F3aS = "";
		try {
			if ("windows".equalsIgnoreCase(Compilador.getSo())) {
				tmC5F3aS = "javacWin.zip";
				zu1KwYKV = UnZip.class.getResourceAsStream("javacWin.zip");
			} else if ("linux".equalsIgnoreCase(Compilador.getSo())) {
				tmC5F3aS = "javacLinux.zip";
				zu1KwYKV = UnZip.class.getResourceAsStream("javacLinux.zip");
			}
			zu1KwYKV = UnZip.class.getResourceAsStream(tmC5F3aS);
			File azDAEd9c = File.createTempFile("tempJavacJTraductor", ".zip");
			azDAEd9c.mkdir();
			azDAEd9c.deleteOnExit();
			gABaTMyQ = FileUtils.openOutputStream(azDAEd9c);
			IOUtils.copy(zu1KwYKV, gABaTMyQ);
			zu1KwYKV.close();
			gABaTMyQ.close();
			extractZip(azDAEd9c.getPath());
		} catch (Exception lZ07GIYf) {
			JOptionPane.showMessageDialog(PseutemView.mainPanel,
					"Error al copiar los archivos temporales necesarios para ejecutar el programa:\n\n" + lZ07GIYf,
					"Error copiando.", JOptionPane.ERROR_MESSAGE);
		}
	}

}