class n22728537 {
	public void actionPerformed(java.awt.event.ActionEvent Flw8czHp) {
		JFileChooser PH1EEJ8w = new JFileChooser();
		PH1EEJ8w.addChoosableFileFilter(new SoundFilter());
		int PlJDN1u6 = PH1EEJ8w.showDialog(AdministracionResorces.this,
				Messages.getString("gui.AdministracionResorces.17"));
		if (PlJDN1u6 == JFileChooser.APPROVE_OPTION) {
			File IlvRQVbL = PH1EEJ8w.getSelectedFile();
			String p0rqGptd = System.getProperty("user.dir") + "/" + rutaDatos + "sonidos/" + IlvRQVbL.getName();
			String wrJnftsx = rutaDatos + "sonidos/" + IlvRQVbL.getName();
			try {
				FileInputStream tAKrLO4M = new FileInputStream(IlvRQVbL);
				FileOutputStream R1XvLS5n = new FileOutputStream(p0rqGptd, true);
				FileChannel fNwjtLtA = tAKrLO4M.getChannel();
				FileChannel L0ouKyGU = R1XvLS5n.getChannel();
				fNwjtLtA.transferTo(0, fNwjtLtA.size(), L0ouKyGU);
				tAKrLO4M.close();
				R1XvLS5n.close();
				imagen.setSonidoURL(wrJnftsx);
				System.out.println(p0rqGptd + " " + wrJnftsx);
				buttonSonido.setIcon(new ImageIcon("data/icons/view_sidetreeOK.png"));
				gui.getAudio().reproduceAudio(imagen);
			} catch (IOException MSnW1ZsT) {
				MSnW1ZsT.printStackTrace();
			}
		} else {
		}
	}

}