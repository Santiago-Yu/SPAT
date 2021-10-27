class n19759580 {
	private void convertFile() {
		final File jAJLMp8E = filePanel.getInputFile();
		final File leKxHoCA = filePanel.getOutputFile();
		if (jAJLMp8E == null || leKxHoCA == null) {
			Main.showMessage("Select valid files for both input and output");
			return;
		}
		if (jAJLMp8E.getName().equals(leKxHoCA.getName())) {
			Main.showMessage("Input and Output files are same.. select different files");
			return;
		}
		final int BsgsJzId = (int) jAJLMp8E.length();
		progressBar.setMinimum(0);
		progressBar.setMaximum(BsgsJzId);
		progressBar.setValue(0);
		try {
			fileCopy(jAJLMp8E, jAJLMp8E.getAbsolutePath() + ".bakup");
		} catch (IOException ytknZEhA) {
			Main.showMessage("Unable to Backup input file");
			return;
		}
		final BufferedReader Q5ys5tQG;
		try {
			Q5ys5tQG = new BufferedReader(new FileReader(jAJLMp8E));
		} catch (FileNotFoundException dqyC28j9) {
			Main.showMessage("Unable to create reader - file not found");
			return;
		}
		final BufferedWriter EqVMLmbe;
		try {
			EqVMLmbe = new BufferedWriter(new FileWriter(leKxHoCA));
		} catch (IOException MSh0szUr) {
			Main.showMessage("Unable to create writer for output file");
			return;
		}
		String CNbWemKg;
		try {
			while ((CNbWemKg = Q5ys5tQG.readLine()) != null) {
				if (stopRequested) {
					break;
				}
				EqVMLmbe.write(parseLine(CNbWemKg));
				EqVMLmbe.newLine();
				progressBar.setValue(progressBar.getValue() + CNbWemKg.length());
			}
		} catch (IOException bsvQiaTD) {
			Main.showMessage("Unable to convert " + bsvQiaTD.getMessage());
			return;
		} finally {
			try {
				Q5ys5tQG.close();
				EqVMLmbe.close();
			} catch (IOException tGPmpPiE) {
				Main.showMessage("Unable to close reader/writer " + tGPmpPiE.getMessage());
				return;
			}
		}
		if (!stopRequested) {
			filePanel.readOutputFile();
			progressBar.setValue(progressBar.getMaximum());
			Main.setStatus("Transliterate Done.");
		}
		progressBar.setValue(progressBar.getMinimum());
	}

}