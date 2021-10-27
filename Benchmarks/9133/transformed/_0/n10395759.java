class n10395759 {
	public void run() {
		btnReintentar.setEnabled(false);
		try {
			lblEstado.setText("Conectando con servidor...");
			escribir("\nConectando con servidor...");
			URL ZNyvxa2L = new URL("http://apeiron.sourceforge.net/version.php");
			lblEstado.setText("Obteniendo informaci?n de versi?n...");
			escribir("Ok\n");
			escribir("Obteniendo informaci?n sobre ?ltima versi?n...");
			BufferedReader Fhgo7iBr = new BufferedReader(new InputStreamReader(ZNyvxa2L.openStream()));
			String iQGfEOq8 = Fhgo7iBr.readLine();
			escribir("Ok\n");
			if (iQGfEOq8 != null) {
				escribir("Versi?n mas reciente: " + iQGfEOq8 + "\n");
				if (Principal.version < Double.parseDouble(iQGfEOq8)) {
					lblEstado.setText("Hay una nueva versi?n: Apeiron " + iQGfEOq8);
					escribir("Puede obtener la actualizaci?n de: http://apeiron.sourceforge.net\n");
					btnActualizar.setEnabled(true);
					setVisible(true);
				} else {
					lblEstado.setText("Usted tiene la ?ltima versi?n");
				}
			}
			Fhgo7iBr.close();
		} catch (MalformedURLException LRvmm2Xy) {
			escribir("Fall?\n" + LRvmm2Xy + "\n");
			LRvmm2Xy.printStackTrace();
		} catch (IOException a0Hd8PGn) {
			escribir("Fall?\n" + a0Hd8PGn + "\n");
			a0Hd8PGn.printStackTrace();
		}
		btnReintentar.setEnabled(true);
	}

}