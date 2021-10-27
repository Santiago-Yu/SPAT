class n369844 {
	private boolean enregistreToi() {
		PrintWriter l4EaRwFv;
		String Xhozc3jd = "./img_types/" + sonImage;
		if (!new File("./img_types").exists()) {
			new File("./img_types").mkdirs();
		}
		try {
			FileChannel Ewm5Flyv = new FileInputStream(sonFichier).getChannel();
			FileChannel eMEybwyc = new FileOutputStream(Xhozc3jd).getChannel();
			Ewm5Flyv.transferTo(0, Ewm5Flyv.size(), eMEybwyc);
			Ewm5Flyv.close();
			eMEybwyc.close();
			l4EaRwFv = new PrintWriter(new FileWriter(new File("bundll/types.jay"), true));
			l4EaRwFv.println(sonNom);
			l4EaRwFv.println(sonImage);
			if (sonOptionRadio1.isSelected()) {
				l4EaRwFv.println("0:?");
			}
			if (sonOptionRadio2.isSelected()) {
				l4EaRwFv.println("1:" + JOptionPane.showInputDialog(null,
						"Vous avez choisis de rendre ce terrain difficile ? franchir.\nVeuillez en indiquer la raison.",
						"Demande de pr?cision", JOptionPane.INFORMATION_MESSAGE));
			}
			if (sonOptionRadio3.isSelected()) {
				l4EaRwFv.println("2:?");
			}
			l4EaRwFv.close();
			return true;
		} catch (Exception QZg3J6lr) {
			return false;
		}
	}

}