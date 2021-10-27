class n21754659 {
	private JButton getButtonSonido() {
		if (buttonSonido == null) {
			buttonSonido = new JButton();
			buttonSonido.setText(Messages.getString("gui.AdministracionResorces.15"));
			buttonSonido.setIcon(
					new ImageIcon(getClass().getResource("/es/unizar/cps/tecnoDiscap/data/icons/view_sidetree.png")));
			buttonSonido.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent JCQ80Lcm) {
					JFileChooser ra0RQibC = new JFileChooser();
					ra0RQibC.addChoosableFileFilter(new SoundFilter());
					int vdWHhzKA = ra0RQibC.showDialog(AdministracionResorces.this,
							Messages.getString("gui.AdministracionResorces.17"));
					if (vdWHhzKA == JFileChooser.APPROVE_OPTION) {
						File uCgFWAco = ra0RQibC.getSelectedFile();
						String rslVPmd6 = System.getProperty("user.dir") + "/" + rutaDatos + "sonidos/"
								+ uCgFWAco.getName();
						String sh0cdtQ3 = rutaDatos + "sonidos/" + uCgFWAco.getName();
						try {
							FileInputStream DxT6qo4n = new FileInputStream(uCgFWAco);
							FileOutputStream bvJBjjvc = new FileOutputStream(rslVPmd6, true);
							FileChannel qvxUoWi4 = DxT6qo4n.getChannel();
							FileChannel UFuYnNRo = bvJBjjvc.getChannel();
							qvxUoWi4.transferTo(0, qvxUoWi4.size(), UFuYnNRo);
							DxT6qo4n.close();
							bvJBjjvc.close();
							imagen.setSonidoURL(sh0cdtQ3);
							System.out.println(rslVPmd6 + " " + sh0cdtQ3);
							buttonSonido.setIcon(new ImageIcon(getClass()
									.getResource("/es/unizar/cps/tecnoDiscap/data/icons/view_sidetreeOK.png")));
							gui.getAudio().reproduceAudio(imagen);
						} catch (IOException OZI6sJPL) {
							OZI6sJPL.printStackTrace();
						}
					} else {
					}
				}
			});
		}
		return buttonSonido;
	}

}