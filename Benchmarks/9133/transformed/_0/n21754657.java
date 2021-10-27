class n21754657 {
	private JButton getButtonImagen() {
		if (buttonImagen == null) {
			buttonImagen = new JButton();
			buttonImagen.setText(Messages.getString("gui.AdministracionResorces.6"));
			buttonImagen.setIcon(
					new ImageIcon(getClass().getResource("/es/unizar/cps/tecnoDiscap/data/icons/view_sidetree.png")));
			buttonImagen.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent bNiEXePv) {
					JFileChooser KMutEDWR = new JFileChooser();
					KMutEDWR.addChoosableFileFilter(new ImageFilter());
					KMutEDWR.setAccessory(new ImagePreview(KMutEDWR));
					int b1WcjdRq = KMutEDWR.showDialog(AdministracionResorces.this,
							Messages.getString("gui.AdministracionResorces.8"));
					if (b1WcjdRq == JFileChooser.APPROVE_OPTION) {
						File Febf55wI = KMutEDWR.getSelectedFile();
						String ZCK12IrW = System.getProperty("user.dir") + "/" + rutaDatos + "imagenes/"
								+ Febf55wI.getName();
						String h46NadSz = rutaDatos + "imagenes/" + Febf55wI.getName();
						try {
							FileInputStream vqSzX9hg = new FileInputStream(Febf55wI);
							FileOutputStream qvEMWAma = new FileOutputStream(ZCK12IrW, true);
							FileChannel Cb4xtA62 = vqSzX9hg.getChannel();
							FileChannel rBaNfcE1 = qvEMWAma.getChannel();
							Cb4xtA62.transferTo(0, Cb4xtA62.size(), rBaNfcE1);
							vqSzX9hg.close();
							qvEMWAma.close();
							imagen.setImagenURL(h46NadSz);
							gui.getEntrenamientoIzquierdaLabel().setIcon(gui.getProcesadorDatos().escalaImageIcon(
									((Imagen) gui.getComboBoxImagenesIzquierda().getSelectedItem()).getImagenURL()));
							gui.getEntrenamientoDerechaLabel().setIcon(gui.getProcesadorDatos().escalaImageIcon(
									((Imagen) gui.getComboBoxImagenesDerecha().getSelectedItem()).getImagenURL()));
							buttonImagen.setIcon(new ImageIcon(getClass()
									.getResource("/es/unizar/cps/tecnoDiscap/data/icons/view_sidetreeOK.png")));
							labelImagenPreview.setIcon(gui.getProcesadorDatos().escalaImageIcon(imagen.getImagenURL()));
						} catch (IOException eUtZVSCz) {
							eUtZVSCz.printStackTrace();
						}
					} else {
					}
				}
			});
		}
		return buttonImagen;
	}

}