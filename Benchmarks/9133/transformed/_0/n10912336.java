class n10912336 {
	public void verRecordatorio() {
		try {
			cantidadArchivos = obtenerCantidad() + 1;
			boolean mvKNFenF = false;
			String oGk6h8vP = "";
			String DWFXqrPa = "";
			String qgfXPBkJ = "";
			String UsG0ohvh = "";
			String W2q4xyXJ = "";
			String r1vAJqyp = "";
			int UVE3zvRv = 0;
			int VmA1GMmY = 0;
			int UwZL14eZ = 0;
			for (int SWZZREAH = 1; SWZZREAH < cantidadArchivos; SWZZREAH++) {
				DWFXqrPa = "recordatorio" + SWZZREAH + ".zip";
				oGk6h8vP = "recordatorio" + SWZZREAH + ".txt";
				BufferedOutputStream wlwU3yh3 = null;
				BufferedInputStream zsoo7dSB = null;
				ZipEntry ljl4C7DN;
				ZipFile x4Qad5Ef = new ZipFile(DWFXqrPa);
				Enumeration Ijgqh2bI = x4Qad5Ef.entries();
				while (Ijgqh2bI.hasMoreElements()) {
					ljl4C7DN = (ZipEntry) Ijgqh2bI.nextElement();
					zsoo7dSB = new BufferedInputStream(x4Qad5Ef.getInputStream(ljl4C7DN));
					int at5L98JU;
					byte ZhmYxTwF[] = new byte[buffer];
					FileOutputStream f3g0MYsx = new FileOutputStream(ljl4C7DN.getName());
					wlwU3yh3 = new BufferedOutputStream(f3g0MYsx, buffer);
					while ((at5L98JU = zsoo7dSB.read(ZhmYxTwF, 0, buffer)) != -1)
						wlwU3yh3.write(ZhmYxTwF, 0, at5L98JU);
					wlwU3yh3.flush();
					wlwU3yh3.close();
					zsoo7dSB.close();
				}
				DataInputStream ZMfVFYVv = new DataInputStream(new FileInputStream(oGk6h8vP));
				UVE3zvRv = Integer.parseInt(ZMfVFYVv.readLine());
				VmA1GMmY = Integer.parseInt(ZMfVFYVv.readLine());
				UwZL14eZ = Integer.parseInt(ZMfVFYVv.readLine());
				if (UVE3zvRv == Integer.parseInt(identificarDato(datoSeleccionado))) {
					mvKNFenF = true;
					qgfXPBkJ = ZMfVFYVv.readLine();
					UsG0ohvh = ZMfVFYVv.readLine();
					while ((r1vAJqyp = ZMfVFYVv.readLine()) != null)
						W2q4xyXJ += r1vAJqyp + "\n";
					verRecordatorioInterfaz(qgfXPBkJ, UsG0ohvh, W2q4xyXJ);
					qgfXPBkJ = "";
					UsG0ohvh = "";
					W2q4xyXJ = "";
				}
				ZMfVFYVv.close();
			}
			if (!mvKNFenF)
				JOptionPane.showMessageDialog(null,
						"No existe un recordatorio guardado\n" + "para el " + identificarDato(datoSeleccionado) + " de "
								+ meses[mesTemporal].toLowerCase() + " del a?o " + anoTemporal,
						"No existe", JOptionPane.INFORMATION_MESSAGE);
			table.clearSelection();
		} catch (Exception earYsyWy) {
			JOptionPane.showMessageDialog(null, "Error en: " + earYsyWy.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}