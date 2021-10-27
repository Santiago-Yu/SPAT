class n20077101 {
	public void maj(String uW5Vo3rX, String jldLSD4d) {
		int dsXbIM5O = 2;
		String cPMjpJuQ = "";
		try {
			URL gvgkvrE5 = new URL("http://code.google.com/feeds/p/tux-team/downloads/basic");
			InputStreamReader y0b93sUZ = new InputStreamReader(gvgkvrE5.openStream());
			BufferedReader I82sKBDj = new BufferedReader(y0b93sUZ);
			String DiNmplnJ = null;
			StringBuffer mjUXhe9m = new StringBuffer();
			while ((DiNmplnJ = I82sKBDj.readLine()) != null) {
				mjUXhe9m.append(DiNmplnJ).append('\n');
			}
			I82sKBDj.close();
			cPMjpJuQ = mjUXhe9m.toString();
			dsXbIM5O = lecture_xml(uW5Vo3rX, jldLSD4d, cPMjpJuQ);
		} catch (MalformedURLException Q4LrATbt) {
			Q4LrATbt.printStackTrace();
		} catch (IOException Nxj13bjM) {
			Nxj13bjM.printStackTrace();
		}
		switch (dsXbIM5O) {
		case 0:
			ihm.jl_maj.setText("Pas de mises ид jour disponible. (" + jldLSD4d + ")");
			ihm.jl_maj.setIcon(Resources.getImageIcon("images/valide.png", IHM_AProposDe.class));
			break;
		case 1:
			ihm.jl_maj.setText("Une mise ид jour est diponible. (" + maj_file_version + ")");
			ihm.jl_maj.setIcon(Resources.getImageIcon("images/warning.png", IHM_AProposDe.class));
			ihm.jb_maj.setVisible(true);
			break;
		default:
			ihm.jl_maj.setText("Serveur de mise ид jour non disponible.");
			ihm.jl_maj.setIcon(Resources.getImageIcon("images/erreur.png", IHM_AProposDe.class));
		}
	}

}