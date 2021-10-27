class n12226563 {
	public void run() {
		Vector<Update> xIU9kgbi = new Vector<Update>();
		if (dic != null)
			xIU9kgbi.add(dic);
		if (gen != null)
			xIU9kgbi.add(gen);
		if (res != null)
			xIU9kgbi.add(res);
		if (help != null)
			xIU9kgbi.add(help);
		for (Iterator DKRHZD4v = xIU9kgbi.iterator(); DKRHZD4v.hasNext();) {
			Update s0S8pI4m = (Update) DKRHZD4v.next();
			try {
				File whBC8MHL = File.createTempFile("fm_" + s0S8pI4m.getType(), ".jar");
				whBC8MHL.deleteOnExit();
				FileOutputStream JA3pBgWE = new FileOutputStream(whBC8MHL);
				URL ELz2SHxH = new URL(s0S8pI4m.getAction());
				URLConnection Ln6YUO3Y = ELz2SHxH.openConnection();
				com.diccionarioderimas.Utils.setupProxy(Ln6YUO3Y);
				InputStream JaQDwE4C = Ln6YUO3Y.getInputStream();
				byte[] z3ADLP8r = new byte[1024];
				int JzOoTiPG = 0;
				int njVRuM55 = 0;
				while ((JzOoTiPG = JaQDwE4C.read(z3ADLP8r)) != -1) {
					JA3pBgWE.write(z3ADLP8r, 0, JzOoTiPG);
					njVRuM55 += JzOoTiPG;
					if (njVRuM55 > 10000) {
						progressBar.setValue(progressBar.getValue() + njVRuM55);
						njVRuM55 = 0;
					}
				}
				JA3pBgWE.close();
				JaQDwE4C.close();
				String qL5yhYbA = basePath + "diccionariorimas.jar";
				if (s0S8pI4m.getType() == Update.GENERATOR)
					qL5yhYbA = basePath + "generador.jar";
				else if (s0S8pI4m.getType() == Update.RESBC)
					qL5yhYbA = basePath + "resbc.me";
				else if (s0S8pI4m.getType() == Update.HELP)
					qL5yhYbA = basePath + "help.html";
				if (s0S8pI4m.getType() == Update.RESBC) {
					Utils.unzip(whBC8MHL, new File(qL5yhYbA));
				} else {
					Utils.copyFile(new FileInputStream(whBC8MHL), new File(qL5yhYbA));
				}
			} catch (Exception RT2VgvCC) {
				RT2VgvCC.printStackTrace();
			}
		}
		setVisible(false);
		if (gen != null || res != null) {
			try {
				new Main(null, basePath, false);
			} catch (Exception ACXP0NN6) {
				new ErrorDialog(frame, ACXP0NN6);
			}
		}
		String p7koLkt3 = "";
		if (dic != null)
			p7koLkt3 += "\nAlgunas de ellas s?lo estar?n disponibles despu?s de reiniciar el diccionario.";
		JOptionPane.showMessageDialog(frame, "Se han terminado de realizar las actualizaciones." + p7koLkt3,
				"Actualizaciones", JOptionPane.INFORMATION_MESSAGE);
	}

}