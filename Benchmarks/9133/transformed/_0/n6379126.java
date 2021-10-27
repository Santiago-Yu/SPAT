class n6379126 {
	public boolean gerarTutorialPage() {
		try {
			File GE3IIzOn = criarDiretorioSite();
			File MSQZQWfO = criarDiretorioCss();
			File U15iWkNS = criarDiretorioCapitulos();
			File zOtBjgWS = criarDiretorioLicoes();
			File CcoNYp9u = criarDiretorioMidias();
			File KeZFpGyu = criarDiretorioArquivos();
			File IEM5hcdH = new File(KeZFpGyu + "/videos");
			IEM5hcdH.mkdir();
			File QGBI4u0m = new File(KeZFpGyu + "/imagens");
			QGBI4u0m.mkdir();
			String TG1osNFR = System.getProperty("user.dir");
			FileChannel X5fhvHkh = new FileInputStream(TG1osNFR + "/bin/style/layout.css").getChannel();
			FileChannel EErWgBBT = new FileOutputStream(MSQZQWfO + "/layout.css").getChannel();
			EErWgBBT.transferFrom(X5fhvHkh, 0, X5fhvHkh.size());
			X5fhvHkh.close();
			EErWgBBT.close();
			FileChannel Op6ZCVvg = new FileInputStream(TG1osNFR + "/bin/style/elementos.css").getChannel();
			FileChannel pTR7gLJ6 = new FileOutputStream(MSQZQWfO + "/elementos.css").getChannel();
			pTR7gLJ6.transferFrom(Op6ZCVvg, 0, Op6ZCVvg.size());
			Op6ZCVvg.close();
			pTR7gLJ6.close();
			FileChannel MjyxRAZA = new FileInputStream(TG1osNFR + "/bin/style/estilo-cap-lic-mid.css").getChannel();
			FileChannel tqdhNc9E = new FileOutputStream(MSQZQWfO + "/estilo-cap-lic-mid.css").getChannel();
			tqdhNc9E.transferFrom(MjyxRAZA, 0, MjyxRAZA.size());
			MjyxRAZA.close();
			tqdhNc9E.close();
			FileChannel OJ0SO6Qz = new FileInputStream(TG1osNFR + "/bin/style/layout_ie.css").getChannel();
			FileChannel z80q9sr9 = new FileOutputStream(MSQZQWfO + "/layout_ie.css").getChannel();
			z80q9sr9.transferFrom(OJ0SO6Qz, 0, OJ0SO6Qz.size());
			OJ0SO6Qz.close();
			z80q9sr9.close();
			FileChannel xXAYt7rj = new FileInputStream(TG1osNFR + "/bin/style/elementos_ie.css").getChannel();
			FileChannel dL2Dx9Q2 = new FileOutputStream(MSQZQWfO + "/elementos_ie.css").getChannel();
			dL2Dx9Q2.transferFrom(xXAYt7rj, 0, xXAYt7rj.size());
			xXAYt7rj.close();
			dL2Dx9Q2.close();
			FileChannel jTbNRi0f = new FileInputStream(TG1osNFR + "/bin/style/estilo-cap-lic-mid_ie.css").getChannel();
			FileChannel pWLYDyRZ = new FileOutputStream(MSQZQWfO + "/estilo-cap-lic-mid_ie.css").getChannel();
			pWLYDyRZ.transferFrom(jTbNRi0f, 0, jTbNRi0f.size());
			jTbNRi0f.close();
			pWLYDyRZ.close();
			copiarMidias(IEM5hcdH, QGBI4u0m);
			escreverMidiasPage(CcoNYp9u);
			escreverLicoesPage(zOtBjgWS);
			escreverCapitulosPages(U15iWkNS);
			FileWriter kqnyaxPW = new FileWriter(GE3IIzOn + "/index.html");
			kqnyaxPW.write(escreverIndexHead() + escreverBodyHeader() + escreverIndexBodyContent() + escreverFooter());
			kqnyaxPW.close();
			System.out.println("Site gerado com sucesso");
			JOptionPane.showMessageDialog(null, "Web Site gerado com sucesso", "\\o/", JOptionPane.INFORMATION_MESSAGE);
			return true;
		} catch (Exception kBFZHxBy) {
			kBFZHxBy.printStackTrace();
			System.err.println("Site n?o gerado");
			JOptionPane.showMessageDialog(null, "Web Site n?o gerado corretamente", "Ops...",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

}