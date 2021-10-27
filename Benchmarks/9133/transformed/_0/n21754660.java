class n21754660 {
	public void actionPerformed(java.awt.event.ActionEvent NOXkFEpa) {
		JFileChooser hAaWxvwt = new JFileChooser();
		hAaWxvwt.addChoosableFileFilter(new SoundFilter());
		int QfISl2l7 = hAaWxvwt.showDialog(AdministracionResorces.this,
				Messages.getString("gui.AdministracionResorces.17"));
		if (QfISl2l7 == JFileChooser.APPROVE_OPTION) {
			File x2wCm0yi = hAaWxvwt.getSelectedFile();
			String DYEkMKsv = System.getProperty("user.dir") + "/" + rutaDatos + "sonidos/" + x2wCm0yi.getName();
			String j0cmtNNR = rutaDatos + "sonidos/" + x2wCm0yi.getName();
			try {
				FileInputStream iRBEzr0I = new FileInputStream(x2wCm0yi);
				FileOutputStream LJXIoold = new FileOutputStream(DYEkMKsv, true);
				FileChannel JCFmtHal = iRBEzr0I.getChannel();
				FileChannel ECafdu8F = LJXIoold.getChannel();
				JCFmtHal.transferTo(0, JCFmtHal.size(), ECafdu8F);
				iRBEzr0I.close();
				LJXIoold.close();
				imagen.setSonidoURL(j0cmtNNR);
				System.out.println(DYEkMKsv + " " + j0cmtNNR);
				buttonSonido.setIcon(new ImageIcon(
						getClass().getResource("/es/unizar/cps/tecnoDiscap/data/icons/view_sidetreeOK.png")));
				gui.getAudio().reproduceAudio(imagen);
			} catch (IOException aDg3GRpJ) {
				aDg3GRpJ.printStackTrace();
			}
		} else {
		}
	}

}