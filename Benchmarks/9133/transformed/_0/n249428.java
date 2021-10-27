class n249428 {
	public boolean onStart() {
		log("Starting up, this may take a minute...");
		gui = new ApeAtollGUI();
		gui.setVisible(true);
		while (waitGUI) {
			sleep(100);
		}
		URLConnection PIPpQx0Z = null;
		BufferedReader zwI1r3N3 = null;
		BufferedWriter H2y7ISWv = null;
		if (checkUpdates) {
			try {
				PIPpQx0Z = new URL("http://www.voltrex.be/rsbot/VoltrexApeAtollVERSION.txt").openConnection();
				zwI1r3N3 = new BufferedReader(new InputStreamReader(PIPpQx0Z.getInputStream()));
				if (Double.parseDouble(zwI1r3N3.readLine()) > properties.version()) {
					if (JOptionPane.showConfirmDialog(null, "Update found. Do you want to update?") == 0) {
						JOptionPane.showMessageDialog(null,
								"Please choose 'VoltrexApeAtoll.java' in your scripts/sources folder.");
						JFileChooser okV97oJU = new JFileChooser();
						if (okV97oJU.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
							PIPpQx0Z = new URL("http://www.voltrex.be/rsbot/VoltrexApeAtoll.java").openConnection();
							zwI1r3N3 = new BufferedReader(new InputStreamReader(PIPpQx0Z.getInputStream()));
							H2y7ISWv = new BufferedWriter(new FileWriter(okV97oJU.getSelectedFile().getPath()));
							String TWR3HfoU;
							while ((TWR3HfoU = zwI1r3N3.readLine()) != null) {
								H2y7ISWv.write(TWR3HfoU);
								H2y7ISWv.newLine();
								H2y7ISWv.flush();
							}
							log("Script successfully downloaded. Please recompile.");
							return false;
						} else
							log("Update canceled");
					} else
						log("Update canceled");
				} else
					log("You have the latest version.");
				if (zwI1r3N3 != null)
					zwI1r3N3.close();
				if (H2y7ISWv != null)
					H2y7ISWv.close();
			} catch (IOException mOd1nply) {
				log("Problem getting version. Please report this bug!");
			}
		}
		try {
			BKG = ImageIO.read(new URL("http://i54.tinypic.com/2egcfaw.jpg"));
		} catch (final java.io.IOException lch2yMle) {
			lch2yMle.printStackTrace();
		}
		try {
			final URL MIdL67WH = new URL("http://imgur.com/i7nMG.png");
			final URL fi1TRMJv = new URL("http://imgur.com/8k9op.png");
			normal = ImageIO.read(MIdL67WH);
			clicked = ImageIO.read(fi1TRMJv);
		} catch (MalformedURLException PaHEhC0q) {
			log.info("Unable to buffer cursor.");
		} catch (IOException hbXRMiTR) {
			log.info("Unable to open cursor image.");
		}
		scriptStartTime = System.currentTimeMillis();
		mouse.setSpeed(MouseSpeed);
		camera.setPitch(true);
		log("You are using Voltrex Ape Atoll agility course.");
		return true;
	}

}