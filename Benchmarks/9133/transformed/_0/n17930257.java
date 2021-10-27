class n17930257 {
	public void actionPerformed(java.awt.event.ActionEvent F1O0jS74) {
		JFileChooser UPDcg3WV = new JFileChooser();
		UPDcg3WV.addChoosableFileFilter(new ImageFilter());
		UPDcg3WV.setFileView(new ImageFileView());
		UPDcg3WV.setAccessory(new ImagePreview(UPDcg3WV));
		int YGtgtLGK = UPDcg3WV.showDialog(Resorces.this, "Seleccione una imagen");
		if (YGtgtLGK == JFileChooser.APPROVE_OPTION) {
			File pLBiH5zA = UPDcg3WV.getSelectedFile();
			String bTMshjvP = System.getProperty("user.dir") + pLBiH5zA.separator + "data" + pLBiH5zA.separator
					+ "imagenes" + pLBiH5zA.separator + pLBiH5zA.getName();
			String TMm5BVsm = "data" + pLBiH5zA.separator + "imagenes" + pLBiH5zA.separator + pLBiH5zA.getName();
			try {
				FileInputStream krlWSyUp = new FileInputStream(pLBiH5zA);
				FileOutputStream PPcrfeAc = new FileOutputStream(bTMshjvP, true);
				FileChannel bOCM4lnX = krlWSyUp.getChannel();
				FileChannel BdFxxXLj = PPcrfeAc.getChannel();
				bOCM4lnX.transferTo(0, bOCM4lnX.size(), BdFxxXLj);
				krlWSyUp.close();
				PPcrfeAc.close();
			} catch (IOException mqrG7T6p) {
				mqrG7T6p.printStackTrace();
			}
			imagen.setImagenURL(TMm5BVsm);
			System.out.println(bTMshjvP + " " + TMm5BVsm);
			buttonImagen.setIcon(new ImageIcon(getClass().getResource("/data/icons/view_sidetreeOK.png")));
			labelImagenPreview.setIcon(gui.procesadorDatos.escalaImageIcon(imagen.getImagenURL()));
		} else {
		}
	}

}