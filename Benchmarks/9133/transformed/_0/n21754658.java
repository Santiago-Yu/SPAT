class n21754658 {
	public void actionPerformed(java.awt.event.ActionEvent FX7ZqcxR) {
		JFileChooser IRkyScpm = new JFileChooser();
		IRkyScpm.addChoosableFileFilter(new ImageFilter());
		IRkyScpm.setAccessory(new ImagePreview(IRkyScpm));
		int ax3E6l52 = IRkyScpm.showDialog(AdministracionResorces.this,
				Messages.getString("gui.AdministracionResorces.8"));
		if (ax3E6l52 == JFileChooser.APPROVE_OPTION) {
			File T1VHr2FT = IRkyScpm.getSelectedFile();
			String nyZEnhAt = System.getProperty("user.dir") + "/" + rutaDatos + "imagenes/" + T1VHr2FT.getName();
			String Jvpu60XX = rutaDatos + "imagenes/" + T1VHr2FT.getName();
			try {
				FileInputStream iojxUD1e = new FileInputStream(T1VHr2FT);
				FileOutputStream iLVZX9cK = new FileOutputStream(nyZEnhAt, true);
				FileChannel FllfN7ij = iojxUD1e.getChannel();
				FileChannel ApQ8Oygc = iLVZX9cK.getChannel();
				FllfN7ij.transferTo(0, FllfN7ij.size(), ApQ8Oygc);
				iojxUD1e.close();
				iLVZX9cK.close();
				imagen.setImagenURL(Jvpu60XX);
				gui.getEntrenamientoIzquierdaLabel().setIcon(gui.getProcesadorDatos().escalaImageIcon(
						((Imagen) gui.getComboBoxImagenesIzquierda().getSelectedItem()).getImagenURL()));
				gui.getEntrenamientoDerechaLabel().setIcon(gui.getProcesadorDatos()
						.escalaImageIcon(((Imagen) gui.getComboBoxImagenesDerecha().getSelectedItem()).getImagenURL()));
				buttonImagen.setIcon(new ImageIcon(
						getClass().getResource("/es/unizar/cps/tecnoDiscap/data/icons/view_sidetreeOK.png")));
				labelImagenPreview.setIcon(gui.getProcesadorDatos().escalaImageIcon(imagen.getImagenURL()));
			} catch (IOException NRFdCEMf) {
				NRFdCEMf.printStackTrace();
			}
		} else {
		}
	}

}