class n22728534 {
	private JButton getButtonImagen() {
		if (buttonImagen == null) {
			buttonImagen = new JButton();
			buttonImagen.setText(Messages.getString("gui.AdministracionResorces.6"));
			buttonImagen.setIcon(new ImageIcon("data/icons/view_sidetree.png"));
			buttonImagen.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent nkTUzkrm) {
					JFileChooser YRFdRmIj = new JFileChooser();
					YRFdRmIj.addChoosableFileFilter(new ImageFilter());
					YRFdRmIj.setAccessory(new ImagePreview(YRFdRmIj));
					int OmfHFe9e = YRFdRmIj.showDialog(AdministracionResorces.this,
							Messages.getString("gui.AdministracionResorces.8"));
					if (OmfHFe9e == JFileChooser.APPROVE_OPTION) {
						File bHeO6UTH = YRFdRmIj.getSelectedFile();
						String NY3BN3Ur = System.getProperty("user.dir") + "/" + rutaDatos + "imagenes/"
								+ bHeO6UTH.getName();
						String w4ew0HMM = rutaDatos + "imagenes/" + bHeO6UTH.getName();
						try {
							FileInputStream serIpmzd = new FileInputStream(bHeO6UTH);
							FileOutputStream M76FndVR = new FileOutputStream(NY3BN3Ur, true);
							FileChannel MET9LinC = serIpmzd.getChannel();
							FileChannel U8JSQCch = M76FndVR.getChannel();
							MET9LinC.transferTo(0, MET9LinC.size(), U8JSQCch);
							serIpmzd.close();
							M76FndVR.close();
							imagen.setImagenURL(w4ew0HMM);
							gui.getEntrenamientoIzquierdaLabel().setIcon(gui.getProcesadorDatos().escalaImageIcon(
									((Imagen) gui.getComboBoxImagenesIzquierda().getSelectedItem()).getImagenURL()));
							gui.getEntrenamientoDerechaLabel().setIcon(gui.getProcesadorDatos().escalaImageIcon(
									((Imagen) gui.getComboBoxImagenesDerecha().getSelectedItem()).getImagenURL()));
							buttonImagen.setIcon(new ImageIcon("data/icons/view_sidetreeOK.png"));
							labelImagenPreview.setIcon(gui.getProcesadorDatos().escalaImageIcon(imagen.getImagenURL()));
						} catch (IOException e2bZwa67) {
							e2bZwa67.printStackTrace();
						}
					} else {
					}
				}
			});
		}
		return buttonImagen;
	}

}