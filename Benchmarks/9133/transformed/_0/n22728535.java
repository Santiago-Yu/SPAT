class n22728535 {
	public void actionPerformed(java.awt.event.ActionEvent FU8QEtbN) {
		JFileChooser WtZBwJTZ = new JFileChooser();
		WtZBwJTZ.addChoosableFileFilter(new ImageFilter());
		WtZBwJTZ.setAccessory(new ImagePreview(WtZBwJTZ));
		int vsdJVCHI = WtZBwJTZ.showDialog(AdministracionResorces.this,
				Messages.getString("gui.AdministracionResorces.8"));
		if (vsdJVCHI == JFileChooser.APPROVE_OPTION) {
			File h7qhHsnZ = WtZBwJTZ.getSelectedFile();
			String ZzYwEeCi = System.getProperty("user.dir") + "/" + rutaDatos + "imagenes/" + h7qhHsnZ.getName();
			String MrBLaywQ = rutaDatos + "imagenes/" + h7qhHsnZ.getName();
			try {
				FileInputStream R4PcEpLz = new FileInputStream(h7qhHsnZ);
				FileOutputStream sRANLdat = new FileOutputStream(ZzYwEeCi, true);
				FileChannel qsmOwLcA = R4PcEpLz.getChannel();
				FileChannel sE48IjOI = sRANLdat.getChannel();
				qsmOwLcA.transferTo(0, qsmOwLcA.size(), sE48IjOI);
				R4PcEpLz.close();
				sRANLdat.close();
				imagen.setImagenURL(MrBLaywQ);
				gui.getEntrenamientoIzquierdaLabel().setIcon(gui.getProcesadorDatos().escalaImageIcon(
						((Imagen) gui.getComboBoxImagenesIzquierda().getSelectedItem()).getImagenURL()));
				gui.getEntrenamientoDerechaLabel().setIcon(gui.getProcesadorDatos()
						.escalaImageIcon(((Imagen) gui.getComboBoxImagenesDerecha().getSelectedItem()).getImagenURL()));
				buttonImagen.setIcon(new ImageIcon("data/icons/view_sidetreeOK.png"));
				labelImagenPreview.setIcon(gui.getProcesadorDatos().escalaImageIcon(imagen.getImagenURL()));
			} catch (IOException IuPrmIHK) {
				IuPrmIHK.printStackTrace();
			}
		} else {
		}
	}

}