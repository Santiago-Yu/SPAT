class n10912335 {
	public void guardarCantidad() {
		try {
			File archivo = new File("cantidadArchivos.txt");
			String can = String.valueOf(cantidadArchivos);
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.print(can);
			salida.close();
			FileOutputStream dest = new FileOutputStream("cantidadArchivos.zip");
			BufferedInputStream origin = null;
			byte data[] = new byte[buffer];
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
			File f = new File("cantidadArchivos.txt");
			FileInputStream fi = new FileInputStream(f);
			ZipEntry entry = new ZipEntry("cantidadArchivos.txt");
			origin = new BufferedInputStream(fi, buffer);
			out.putNextEntry(entry);
			int count;
			while ((count = origin.read(data, 0, buffer)) != -1)
				out.write(data, 0, count);
			out.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}