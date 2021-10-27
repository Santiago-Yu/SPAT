class n1955681 {
	public static void ExtraeArchivoJAR(String Archivo, String DirJAR, String DirDestino) {
		FileOutputStream salida = null;
		FileInputStream entrada = null;
		try {
			File f = new File(DirDestino + separador + Archivo);
			InputStream source = OP_Proced.class.getResourceAsStream(DirJAR + "/" + Archivo);
			try {
				f.createNewFile();
			} catch (Exception sad) {
				sad.printStackTrace();
			}
			FileOutputStream out = new FileOutputStream(f);
			BufferedInputStream in = new BufferedInputStream(source);
			int ch;
			while ((ch = in.read()) != -1)
				out.write(ch);
			in.close();
			out.close();
		} catch (IOException ex) {
			System.out.println(ex);
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			if (salida != null) {
				try {
					salida.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}