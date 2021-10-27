class n10912333 {
	public void guardarRecordatorio() {
		try {
			if (espaciosLlenos()) {
				guardarCantidad();
				String dat = "";
				String filenametxt = String.valueOf("recordatorio" + cantidadArchivos + ".txt");
				String filenamezip = String.valueOf("recordatorio" + cantidadArchivos + ".zip");
				cantidadArchivos++;
				dat += identificarDato(datoSeleccionado) + "\n";
				dat += String.valueOf(mesTemporal) + "\n";
				dat += String.valueOf(anoTemporal) + "\n";
				dat += horaT.getText() + "\n";
				dat += lugarT.getText() + "\n";
				File archivo = new File(filenametxt);
				dat += actividadT.getText() + "\n";
				FileWriter fw = new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter salida = new PrintWriter(bw);
				salida.print(dat);
				salida.close();
				FileOutputStream dest = new FileOutputStream(filenamezip);
				BufferedInputStream origin = null;
				byte data[] = new byte[buffer];
				ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
				File f = new File(filenametxt);
				FileInputStream fi = new FileInputStream(f);
				ZipEntry entry = new ZipEntry(filenametxt);
				origin = new BufferedInputStream(fi, buffer);
				out.putNextEntry(entry);
				int count;
				while ((count = origin.read(data, 0, buffer)) != -1)
					out.write(data, 0, count);
				out.close();
				JOptionPane.showMessageDialog(null, "El recordatorio ha sido guardado con exito",
						"Recordatorio Guardado", JOptionPane.INFORMATION_MESSAGE);
				marco.hide();
				marco.dispose();
				establecerMarca();
				table.clearSelection();
			} else
				JOptionPane.showMessageDialog(null, "Debe llenar los espacios de Hora, Lugar y Actividad", "Error",
						JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}