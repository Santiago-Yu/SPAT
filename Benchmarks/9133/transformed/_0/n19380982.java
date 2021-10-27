class n19380982 {
	@SuppressWarnings("unused")
	private boolean copyAvecProgressNIO(File Rpn8glWR, File llSvAeBP, JProgressBar HtHHUFNX) {
		boolean s4ufQvWU = false;
		long UWWj4Df4 = 0;
		FileInputStream K3NJsYKn = null;
		try {
			K3NJsYKn = new FileInputStream(Rpn8glWR);
		} catch (FileNotFoundException bltXv3t0) {
			try {
				Historique
						.ecrire("Erreur ? la copie du fichier " + Rpn8glWR + " pour la raison suivante : " + bltXv3t0);
			} catch (IOException ARq5gn2X) {
				ARq5gn2X.printStackTrace();
			}
			return true;
		}
		FileOutputStream B6iZT8tx = null;
		try {
			B6iZT8tx = new FileOutputStream(llSvAeBP);
		} catch (FileNotFoundException Oc80wvcc) {
			try {
				Historique.ecrire(
						"Erreur ? la creation du fichier " + llSvAeBP + " pour la raison suivante : " + Oc80wvcc);
			} catch (IOException T6wwf6D4) {
				T6wwf6D4.printStackTrace();
			}
			return true;
		}
		java.nio.channels.FileChannel sxxEdWHe = K3NJsYKn.getChannel();
		java.nio.channels.FileChannel gQIA9vi8 = B6iZT8tx.getChannel();
		HtHHUFNX.setValue(0);
		HtHHUFNX.setString(Rpn8glWR + " : 0 %");
		try {
			long XR8DsjSy = sxxEdWHe.transferTo(0, sxxEdWHe.size(), gQIA9vi8);
		} catch (IOException ATcQRLi0) {
			try {
				Historique.ecrire("Erreur ? la copie du fichier " + Rpn8glWR + " vers la destination " + llSvAeBP
						+ " pour la raison suivante : " + ATcQRLi0);
			} catch (IOException C2G7bOn0) {
				C2G7bOn0.printStackTrace();
			}
			return true;
		}
		HtHHUFNX.setValue(100);
		HtHHUFNX.setString(Rpn8glWR + " : 100 %");
		try {
			if (sxxEdWHe.size() == gQIA9vi8.size()) {
				s4ufQvWU = true;
			} else {
				s4ufQvWU = false;
			}
		} catch (IOException XDiDbdlV) {
			try {
				Historique
						.ecrire("Erreur ? la copie du fichier " + Rpn8glWR + " pour la raison suivante : " + XDiDbdlV);
			} catch (IOException OOjRVzOm) {
				OOjRVzOm.printStackTrace();
			}
			return true;
		}
		try {
			K3NJsYKn.close();
		} catch (IOException hpDKQBPf) {
			try {
				Historique.ecrire("Impossible de fermer le flux ? la copie du fichier " + Rpn8glWR
						+ " pour la raison suivante : " + hpDKQBPf);
			} catch (IOException VIgfElnq) {
				VIgfElnq.printStackTrace();
			}
			return true;
		}
		try {
			B6iZT8tx.close();
		} catch (IOException vYnix5CG) {
			try {
				Historique.ecrire("Impossible de fermer le flux ? la copie du fichier " + llSvAeBP
						+ " pour la raison suivante : " + vYnix5CG);
			} catch (IOException wlWhntEc) {
				wlWhntEc.printStackTrace();
			}
			return true;
		}
		return (s4ufQvWU);
	}

}