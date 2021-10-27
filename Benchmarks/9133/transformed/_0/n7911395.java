class n7911395 {
	public void executaAlteracoes() {
		Album UNxGBNY6 = Album.getAlbum();
		Photo[] Ly5Jsedg = UNxGBNY6.getFotos();
		Photo LEqp7UGx;
		int dYaI6PGB = -1;
		int RrZRA7z6 = UNxGBNY6.getAlbumID();
		sucesso = true;
		PainelWebFotos.setCursorWait(true);
		RrZRA7z6 = recordAlbumData(UNxGBNY6, RrZRA7z6);
		sucesso = recordFotoData(Ly5Jsedg, dYaI6PGB, RrZRA7z6);
		String Y2v45vYT = Util.getFolder("albunsRoot").getPath() + File.separator + RrZRA7z6;
		File e7K3xOHF = new File(Y2v45vYT);
		if (!e7K3xOHF.isDirectory()) {
			if (!e7K3xOHF.mkdir()) {
				Util.log("[AcaoAlterarAlbum.executaAlteracoes.7]/ERRO: diretorio " + Y2v45vYT
						+ " n?o pode ser criado. abortando");
				return;
			}
		}
		for (int I247NELe = 0; I247NELe < Ly5Jsedg.length; I247NELe++) {
			LEqp7UGx = Ly5Jsedg[I247NELe];
			if (LEqp7UGx.getCaminhoArquivo().length() > 0) {
				try {
					FileChannel YyQEvxvJ = new FileInputStream(LEqp7UGx.getCaminhoArquivo()).getChannel();
					FileChannel MR9qZA8k = new FileOutputStream(
							Y2v45vYT + File.separator + LEqp7UGx.getFotoID() + ".jpg").getChannel();
					MR9qZA8k.transferFrom(YyQEvxvJ, 0, YyQEvxvJ.size());
					YyQEvxvJ = null;
					MR9qZA8k = null;
				} catch (Exception Vb9wj8SK) {
					Util.log("[AcaoAlterarAlbum.executaAlteracoes.8]/ERRO: " + Vb9wj8SK);
					sucesso = false;
				}
			}
		}
		prepareThumbsAndFTP(Ly5Jsedg, RrZRA7z6, Y2v45vYT);
		prepareExtraFiles(UNxGBNY6, Y2v45vYT);
		fireChangesToGUI(Ly5Jsedg);
		dispatchAlbum();
		PainelWebFotos.setCursorWait(false);
	}

}