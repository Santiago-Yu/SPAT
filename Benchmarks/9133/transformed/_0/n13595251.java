class n13595251 {
	public void descargarArchivo() {
		try {
			FileInputStream Ba5JOTdl = new FileInputStream(resultados.elementAt(materialSelccionado).getRuta());
			FileOutputStream RuFPslCJ = new FileOutputStream(rutaDestinoDescarga);
			FileChannel ZUBeuVSb = Ba5JOTdl.getChannel();
			FileChannel ZnnLL8Wx = RuFPslCJ.getChannel();
			ZUBeuVSb.transferTo(0, ZUBeuVSb.size(), ZnnLL8Wx);
			Ba5JOTdl.close();
			RuFPslCJ.close();
		} catch (IOException U1knxVsk) {
			System.err.println("Error al Generar Copia del Material\n" + U1knxVsk);
		}
	}

}