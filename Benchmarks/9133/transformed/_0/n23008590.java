class n23008590 {
	public void run() {
		URL oQRIPE5b;
		try {
			oQRIPE5b = new URL(Config.UPDATE_SITE_URL);
			InputStream UKnSJ13P = oQRIPE5b.openStream();
			Writer VftGarZq = new StringWriter();
			char[] acOlmWaN = new char[1024];
			Reader QMuSrO07 = new BufferedReader(new InputStreamReader(UKnSJ13P, "UTF-8"));
			int PBOHjhLQ;
			while ((PBOHjhLQ = QMuSrO07.read(acOlmWaN)) != -1) {
				VftGarZq.write(acOlmWaN, 0, PBOHjhLQ);
			}
			String o751L55o = VftGarZq.toString();
			UKnSJ13P.close();
			VftGarZq.close();
			System.out.println("DOWNLOAD PAGE :\n" + o751L55o);
			int z12IcoJr = o751L55o.indexOf("[ANA-CABV]") + 10;
			int XHtFAFsn = o751L55o.indexOf("[/ANA-CABV]");
			int SdeAy00J = o751L55o.indexOf("[ANA-CABVURL]") + 13;
			int FS06z0oX = o751L55o.indexOf("[/ANA-CABVURL]");
			String hrGCAgvF = o751L55o.substring(z12IcoJr, XHtFAFsn);
			currentVersionLabel.setText(currentVersionLabel.getText() + hrGCAgvF);
			if (Double.valueOf(Config.VERSION) < Double.valueOf(hrGCAgvF)) {
				downloadButton.setEnabled(true);
				label0.setText(mw.getLangMap().get("Update_Avalaible"));
			} else
				label0.setText(mw.getLangMap().get("Update_NonAvalaible"));
			downloadURL = o751L55o.substring(SdeAy00J, FS06z0oX);
		} catch (MalformedURLException PG9ynj32) {
			PG9ynj32.printStackTrace();
		} catch (IOException n171CJeJ) {
			n171CJeJ.printStackTrace();
		}
	}

}