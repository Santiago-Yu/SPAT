class n20077101 {
	public void maj(String titre, String num_version) {
		int res = 2;
		String content_xml = "";
		try {
			URL url = new URL("http://code.google.com/feeds/p/tux-team/downloads/basic");
			InputStreamReader ipsr = new InputStreamReader(url.openStream());
			BufferedReader br = new BufferedReader(ipsr);
			String line = null;
			StringBuffer buffer = new StringBuffer();
			while ((line = br.readLine()) != null) {
				buffer.append(line).append('\n');
			}
			br.close();
			content_xml = buffer.toString();
			res = lecture_xml(titre, num_version, content_xml);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (res == 1) {
			ihm.jl_maj.setText("Une mise ид jour est diponible. (" + maj_file_version + ")");
			ihm.jl_maj.setIcon(Resources.getImageIcon("images/warning.png", IHM_AProposDe.class));
			ihm.jb_maj.setVisible(true);
		} else if (res == 0) {
			ihm.jl_maj.setText("Pas de mises ид jour disponible. (" + num_version + ")");
			ihm.jl_maj.setIcon(Resources.getImageIcon("images/valide.png", IHM_AProposDe.class));
		} else {
			ihm.jl_maj.setText("Serveur de mise ид jour non disponible.");
			ihm.jl_maj.setIcon(Resources.getImageIcon("images/erreur.png", IHM_AProposDe.class));
		}
	}

}