class n22728536 {
	private JButton getButtonSonido() {
		if (buttonSonido == null) {
			buttonSonido = new JButton();
			buttonSonido.setText(Messages.getString("gui.AdministracionResorces.15"));
			buttonSonido.setIcon(new ImageIcon("data/icons/view_sidetree.png"));
			buttonSonido.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent yc8aKnrG) {
					JFileChooser A3WiPglH = new JFileChooser();
					A3WiPglH.addChoosableFileFilter(new SoundFilter());
					int sNGdCfIE = A3WiPglH.showDialog(AdministracionResorces.this,
							Messages.getString("gui.AdministracionResorces.17"));
					if (sNGdCfIE == JFileChooser.APPROVE_OPTION) {
						File oEjggAta = A3WiPglH.getSelectedFile();
						String VuHCA8Ig = System.getProperty("user.dir") + "/" + rutaDatos + "sonidos/"
								+ oEjggAta.getName();
						String hOrdKINj = rutaDatos + "sonidos/" + oEjggAta.getName();
						try {
							FileInputStream MLwvwQpa = new FileInputStream(oEjggAta);
							FileOutputStream nVoqmllD = new FileOutputStream(VuHCA8Ig, true);
							FileChannel TBTLpd1J = MLwvwQpa.getChannel();
							FileChannel Lj5W0hPL = nVoqmllD.getChannel();
							TBTLpd1J.transferTo(0, TBTLpd1J.size(), Lj5W0hPL);
							MLwvwQpa.close();
							nVoqmllD.close();
							imagen.setSonidoURL(hOrdKINj);
							System.out.println(VuHCA8Ig + " " + hOrdKINj);
							buttonSonido.setIcon(new ImageIcon("data/icons/view_sidetreeOK.png"));
							gui.getAudio().reproduceAudio(imagen);
						} catch (IOException hVrj1Akh) {
							hVrj1Akh.printStackTrace();
						}
					} else {
					}
				}
			});
		}
		return buttonSonido;
	}

}