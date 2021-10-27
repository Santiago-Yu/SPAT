class n17930256 {
	private JButton getButtonImagen() {
		if (buttonImagen == null) {
			buttonImagen = new JButton();
			buttonImagen.setText("Cargar Imagen");
			buttonImagen.setIcon(new ImageIcon(getClass().getResource("/data/icons/view_sidetree.png")));
			buttonImagen.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent crG5jNwH) {
					JFileChooser oYsHPfVk = new JFileChooser();
					oYsHPfVk.addChoosableFileFilter(new ImageFilter());
					oYsHPfVk.setFileView(new ImageFileView());
					oYsHPfVk.setAccessory(new ImagePreview(oYsHPfVk));
					int aN1CDKuL = oYsHPfVk.showDialog(Resorces.this, "Seleccione una imagen");
					if (aN1CDKuL == JFileChooser.APPROVE_OPTION) {
						File B5IdGo0j = oYsHPfVk.getSelectedFile();
						String h91qNZzL = System.getProperty("user.dir") + B5IdGo0j.separator + "data"
								+ B5IdGo0j.separator + "imagenes" + B5IdGo0j.separator + B5IdGo0j.getName();
						String QbylG6I8 = "data" + B5IdGo0j.separator + "imagenes" + B5IdGo0j.separator
								+ B5IdGo0j.getName();
						try {
							FileInputStream SLIDTS0U = new FileInputStream(B5IdGo0j);
							FileOutputStream j6ioi0aU = new FileOutputStream(h91qNZzL, true);
							FileChannel IlTZLxgW = SLIDTS0U.getChannel();
							FileChannel Qv3APDsA = j6ioi0aU.getChannel();
							IlTZLxgW.transferTo(0, IlTZLxgW.size(), Qv3APDsA);
							SLIDTS0U.close();
							j6ioi0aU.close();
						} catch (IOException pKDRKzy7) {
							pKDRKzy7.printStackTrace();
						}
						imagen.setImagenURL(QbylG6I8);
						System.out.println(h91qNZzL + " " + QbylG6I8);
						buttonImagen.setIcon(new ImageIcon(getClass().getResource("/data/icons/view_sidetreeOK.png")));
						labelImagenPreview.setIcon(gui.procesadorDatos.escalaImageIcon(imagen.getImagenURL()));
					} else {
					}
				}
			});
		}
		return buttonImagen;
	}

}