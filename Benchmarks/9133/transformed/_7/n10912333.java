class n10912333 {
	public void guardarRecordatorio() {
		try {
			if (espaciosLlenos()) {
				guardarCantidad();
				String dat = "";
				String filenametxt = String.valueOf("recordatorio" + cantidadArchivos + ".txt");
				String filenamezip = String.valueOf("recordatorio" + cantidadArchivos + ".zip");
				cantidadArchivos++;
				dat = dat + (identificarDato(datoSeleccionado) + "\n");
				dat = dat + (String.valueOf(mesTemporal) + "\n");
				dat = dat + (String.valueOf(anoTemporal) + "\n");
				dat = dat + (horaT.getText() + "\n");
				dat = dat + (lugarT.getText() + "\n");
				dat = dat + (actividadT.getText() + "\n");
				File archivo = new File(filenametxt);
				FileWriter fw = new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter salida = new PrintWriter(bw);
				salida.print(dat);
				salida.close();
				BufferedInputStream origin = null;
				FileOutputStream dest = new FileOutputStream(filenamezip);
				ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
				byte data[] = new byte[buffer];
				File f = new File(filenametxt);
				FileInputStream fi = new FileInputStream(f);
				origin = new BufferedInputStream(fi, buffer);
				ZipEntry entry = new ZipEntry(filenametxt);
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