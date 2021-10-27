class n9103010 {
	private void jButton2ActionPerformed(java.awt.event.ActionEvent hXU4iFN4) {
		if ((this.jTree2.getSelectionPath() == null)
				|| !(this.jTree2.getSelectionPath().getLastPathComponent() instanceof StyleTreeNode)) {
			Msg.showMsg("Devi selezionare lo stile sotto il quale caricare la ricetta!", this);
			return;
		}
		if ((this.txtUser.getText() == null) || (this.txtUser.getText().length() == 0)) {
			Msg.showMsg("Il nome utente ии obbligatorio!", this);
			return;
		}
		if ((this.txtPwd.getPassword() == null) || (this.txtPwd.getPassword().length == 0)) {
			Msg.showMsg("La password ии obbligatoria!", this);
			return;
		}
		this.nomeRicetta = this.txtNome.getText();
		if ((this.nomeRicetta == null) || (this.nomeRicetta.length() == 0)) {
			Msg.showMsg("Il nome della ricetta ии obbligatorio!", this);
			return;
		}
		StyleTreeNode TZ0pvzH6 = null;
		if (this.jTree2.getSelectionPath().getLastPathComponent() instanceof StyleTreeNode) {
			TZ0pvzH6 = (StyleTreeNode) this.jTree2.getSelectionPath().getLastPathComponent();
		}
		try {
			String fHLBreQD = URLEncoder.encode("nick", "UTF-8") + "="
					+ URLEncoder.encode(this.txtUser.getText(), "UTF-8");
			fHLBreQD += "&" + URLEncoder.encode("pwd", "UTF-8") + "="
					+ URLEncoder.encode(new String(this.txtPwd.getPassword()), "UTF-8");
			fHLBreQD += "&" + URLEncoder.encode("id_stile", "UTF-8") + "="
					+ URLEncoder.encode(TZ0pvzH6.getIdStile(), "UTF-8");
			fHLBreQD += "&" + URLEncoder.encode("nome_ricetta", "UTF-8") + "="
					+ URLEncoder.encode(this.nomeRicetta, "UTF-8");
			fHLBreQD += "&" + URLEncoder.encode("xml_ricetta", "UTF-8") + "=" + URLEncoder.encode(this.xml, "UTF-8");
			URL N3KHhxxb = new URL("http://" + Main.config.getRemoteServer() + "/upload_ricetta.asp?" + fHLBreQD);
			URLConnection ThPd9azD = N3KHhxxb.openConnection();
			ThPd9azD.setDoOutput(true);
			ThPd9azD.setDoInput(true);
			BufferedReader k8NuMiYk = new BufferedReader(new InputStreamReader(ThPd9azD.getInputStream()));
			String VCD5FiYo;
			String taileluN = "";
			while ((VCD5FiYo = k8NuMiYk.readLine()) != null) {
				taileluN += VCD5FiYo;
			}
			k8NuMiYk.close();
			Msg.showMsg(taileluN, this);
			doDefaultCloseAction();
		} catch (Exception Y6W1pnCf) {
			Utils.showException(Y6W1pnCf, "Errore in upload", this);
		}
		reloadTree();
	}

}