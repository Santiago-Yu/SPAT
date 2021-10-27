class n701471 {
	private boolean enregistreToi() {
		PrintWriter h98wVIv5;
		String MT7W7DCw = "./img_types/" + sonImage;
		if (!new File("./img_types").exists()) {
			new File("./img_types").mkdirs();
		}
		try {
			FileChannel tiqiK4gb = new FileInputStream(sonFichier).getChannel();
			FileChannel mMObRiaS = new FileOutputStream(MT7W7DCw).getChannel();
			tiqiK4gb.transferTo(0, tiqiK4gb.size(), mMObRiaS);
			tiqiK4gb.close();
			mMObRiaS.close();
			h98wVIv5 = new PrintWriter(new FileWriter(new File("bundll/types.jay"), true));
			h98wVIv5.println(sonNom);
			h98wVIv5.println(sonImage);
			if (sonOptionRadio1.isSelected()) {
				h98wVIv5.println("0:?");
			}
			if (sonOptionRadio2.isSelected()) {
				h98wVIv5.println("1:" + JOptionPane.showInputDialog(null,
						"Vous avez choisis de rendre ce terrain difficile ? franchir.\nVeuillez en indiquer la raison.",
						"Demande de pr?cision", JOptionPane.INFORMATION_MESSAGE));
			}
			if (sonOptionRadio3.isSelected()) {
				h98wVIv5.println("2:?");
			}
			h98wVIv5.close();
			return true;
		} catch (Exception kWKSM8Id) {
			return false;
		}
	}

}