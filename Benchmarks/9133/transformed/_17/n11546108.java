class n11546108 {
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new URL(urlInfo).openStream()));
			String ligneEnCours;
			int i = 0;
			informations = "";
			while ((ligneEnCours = in.readLine()) != null) {
				if (i == 1) {
					url = ligneEnCours;
				} else if (i == 0) {
					version = ligneEnCours;
				} else {
					informations += ligneEnCours + '\n';
				}
				i++;
			}
			in.close();
			erreur = false;
		} catch (IOException e) {
			erreur = true;
			texteErreur = e.getMessage();
			if (texteErreur.equals("Network is unreachable")) {
				texteErreur = "Pas de r¨¦seau";
				numErreur = 1;
			}
			if (e instanceof FileNotFoundException) {
				texteErreur = "Probl¨¨me param¨¦trage";
				numErreur = 2;
			}
			e.printStackTrace();
		} finally {
			for (ActionListener al : listeners) {
				al.actionPerformed(null);
			}
		}
	}

}