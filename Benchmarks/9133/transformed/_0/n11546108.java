class n11546108 {
	@Override
	public void run() {
		try {
			BufferedReader c56V8qju = new BufferedReader(new InputStreamReader(new URL(urlInfo).openStream()));
			String SMxnIcDh;
			int oKXyGOzs = 0;
			informations = "";
			while ((SMxnIcDh = c56V8qju.readLine()) != null) {
				switch (oKXyGOzs) {
				case 0:
					version = SMxnIcDh;
					break;
				case 1:
					url = SMxnIcDh;
					break;
				default:
					informations += SMxnIcDh + '\n';
					break;
				}
				oKXyGOzs++;
			}
			c56V8qju.close();
			erreur = false;
		} catch (IOException pWF2lHsu) {
			erreur = true;
			texteErreur = pWF2lHsu.getMessage();
			if (texteErreur.equals("Network is unreachable")) {
				texteErreur = "Pas de r¨¦seau";
				numErreur = 1;
			}
			if (pWF2lHsu instanceof FileNotFoundException) {
				texteErreur = "Probl¨¨me param¨¦trage";
				numErreur = 2;
			}
			pWF2lHsu.printStackTrace();
		} finally {
			for (ActionListener qJYu0N7A : listeners) {
				qJYu0N7A.actionPerformed(null);
			}
		}
	}

}