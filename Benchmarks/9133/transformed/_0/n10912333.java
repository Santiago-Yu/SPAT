class n10912333 {
	public void guardarRecordatorio() {
		try {
			if (espaciosLlenos()) {
				guardarCantidad();
				String WvzkNN6c = "";
				String SyZlajPj = String.valueOf("recordatorio" + cantidadArchivos + ".txt");
				String OOfy12NR = String.valueOf("recordatorio" + cantidadArchivos + ".zip");
				cantidadArchivos++;
				WvzkNN6c += identificarDato(datoSeleccionado) + "\n";
				WvzkNN6c += String.valueOf(mesTemporal) + "\n";
				WvzkNN6c += String.valueOf(anoTemporal) + "\n";
				WvzkNN6c += horaT.getText() + "\n";
				WvzkNN6c += lugarT.getText() + "\n";
				WvzkNN6c += actividadT.getText() + "\n";
				File FuVBj6Ro = new File(SyZlajPj);
				FileWriter fdmXF3aV = new FileWriter(FuVBj6Ro);
				BufferedWriter de7NMlzV = new BufferedWriter(fdmXF3aV);
				PrintWriter MQzft9b3 = new PrintWriter(de7NMlzV);
				MQzft9b3.print(WvzkNN6c);
				MQzft9b3.close();
				BufferedInputStream gWIVTlvn = null;
				FileOutputStream XmHGtJzE = new FileOutputStream(OOfy12NR);
				ZipOutputStream bErjbJVZ = new ZipOutputStream(new BufferedOutputStream(XmHGtJzE));
				byte rvNyXSDs[] = new byte[buffer];
				File CPZczlP1 = new File(SyZlajPj);
				FileInputStream chgEWnzE = new FileInputStream(CPZczlP1);
				gWIVTlvn = new BufferedInputStream(chgEWnzE, buffer);
				ZipEntry rbfRjK7i = new ZipEntry(SyZlajPj);
				bErjbJVZ.putNextEntry(rbfRjK7i);
				int QDRXaGOe;
				while ((QDRXaGOe = gWIVTlvn.read(rvNyXSDs, 0, buffer)) != -1)
					bErjbJVZ.write(rvNyXSDs, 0, QDRXaGOe);
				bErjbJVZ.close();
				JOptionPane.showMessageDialog(null, "El recordatorio ha sido guardado con exito",
						"Recordatorio Guardado", JOptionPane.INFORMATION_MESSAGE);
				marco.hide();
				marco.dispose();
				establecerMarca();
				table.clearSelection();
			} else
				JOptionPane.showMessageDialog(null, "Debe llenar los espacios de Hora, Lugar y Actividad", "Error",
						JOptionPane.ERROR_MESSAGE);
		} catch (Exception Cec9eF3G) {
			JOptionPane.showMessageDialog(null, "Error en: " + Cec9eF3G.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}