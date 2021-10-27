class n10482004 {
	public static void main(String[] Pca5gUPB) throws IOException {
		System.out.println("Start filtering zgps...");
		final Config bgHZQESu = ConfigUtils.loadConfig(Pca5gUPB[0]);
		final String oD2Iyz1q = "GPSFilterZGPS";
		File ZL8QuC4J = new File(bgHZQESu.findParam(oD2Iyz1q, "sourceFileSelectedStages"));
		File mTKKxICP = new File(bgHZQESu.findParam(oD2Iyz1q, "sourceFileZGPS"));
		File Ewgnt0XU = new File(bgHZQESu.findParam(oD2Iyz1q, "targetFile"));
		System.out.println("Start reading selected stages...");
		FilterZGPSSelectedStages sWCF5SN9 = new FilterZGPSSelectedStages();
		sWCF5SN9.createSelectedStages(ZL8QuC4J);
		System.out.println("Done. " + sWCF5SN9.getSelectedStages().size() + " stages were stored");
		System.out.println("Start reading and writing zgps...");
		try {
			BufferedReader QD1V6Sts = new BufferedReader(new InputStreamReader(new FileInputStream(mTKKxICP)));
			BufferedWriter EelS5GIx = new BufferedWriter(new FileWriter(Ewgnt0XU));
			EelS5GIx.write(QD1V6Sts.readLine());
			EelS5GIx.newLine();
			String NWK395pw;
			while ((NWK395pw = QD1V6Sts.readLine()) != null) {
				String[] Ep7uhXHD = NWK395pw.split("\t");
				if (sWCF5SN9.containsStage(Integer.parseInt(Ep7uhXHD[0]), Integer.parseInt(Ep7uhXHD[1]),
						Integer.parseInt(Ep7uhXHD[2]))) {
					EelS5GIx.write(NWK395pw);
					EelS5GIx.newLine();
					EelS5GIx.flush();
				}
			}
			QD1V6Sts.close();
			EelS5GIx.close();
		} catch (FileNotFoundException l1JsFqIR) {
			System.out.println("Could not find source file for selected stages.");
			l1JsFqIR.printStackTrace();
		} catch (IOException P2DeEcqW) {
			System.out.println("IO Exception while reading or writing zgps.");
			P2DeEcqW.printStackTrace();
		}
		System.out.println("Done.");
	}

}