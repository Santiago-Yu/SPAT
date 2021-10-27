class n10912335 {
	public void guardarCantidad() {
		try {
			String jfSdkh06 = String.valueOf(cantidadArchivos);
			File pPg2WZTa = new File("cantidadArchivos.txt");
			FileWriter DGM0gSjt = new FileWriter(pPg2WZTa);
			BufferedWriter iBOatEeH = new BufferedWriter(DGM0gSjt);
			PrintWriter b3P7PDDr = new PrintWriter(iBOatEeH);
			b3P7PDDr.print(jfSdkh06);
			b3P7PDDr.close();
			BufferedInputStream US9cvCKA = null;
			FileOutputStream EoLNjVmt = new FileOutputStream("cantidadArchivos.zip");
			ZipOutputStream FBgapJdW = new ZipOutputStream(new BufferedOutputStream(EoLNjVmt));
			byte lkqHKljV[] = new byte[buffer];
			File AYKxenUx = new File("cantidadArchivos.txt");
			FileInputStream LhJ94Mg4 = new FileInputStream(AYKxenUx);
			US9cvCKA = new BufferedInputStream(LhJ94Mg4, buffer);
			ZipEntry dzZkPJfn = new ZipEntry("cantidadArchivos.txt");
			FBgapJdW.putNextEntry(dzZkPJfn);
			int tmXHzxbH;
			while ((tmXHzxbH = US9cvCKA.read(lkqHKljV, 0, buffer)) != -1)
				FBgapJdW.write(lkqHKljV, 0, tmXHzxbH);
			FBgapJdW.close();
		} catch (Exception vhfyQRLW) {
			JOptionPane.showMessageDialog(null, "Error en: " + vhfyQRLW.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}