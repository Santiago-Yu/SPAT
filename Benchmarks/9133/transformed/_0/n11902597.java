class n11902597 {
	public static void main(String[] Dgai8o2i) {
		System.out.println("Start filtering zgps...");
		final Config ZsgIiPXP = Gbl.createConfig(Dgai8o2i);
		final String M4Uf4YIh = "GPSFilterZGPS";
		File uqzZJJix = new File(ZsgIiPXP.findParam(M4Uf4YIh, "sourceFileSelectedStages"));
		File wzevKtsP = new File(ZsgIiPXP.findParam(M4Uf4YIh, "sourceFileZGPS"));
		File Mro9W1Mz = new File(ZsgIiPXP.findParam(M4Uf4YIh, "targetFile"));
		System.out.println("Start reading selected stages...");
		FilterZGPSSelectedStages nm1xCf7T = new FilterZGPSSelectedStages();
		nm1xCf7T.createSelectedStages(uqzZJJix);
		System.out.println("Done. " + nm1xCf7T.getSelectedStages().size() + " stages were stored");
		System.out.println("Start reading and writing zgps...");
		try {
			BufferedReader B8xe9NVP = new BufferedReader(new InputStreamReader(new FileInputStream(wzevKtsP)));
			BufferedWriter IEDtU3G4 = new BufferedWriter(new FileWriter(Mro9W1Mz));
			IEDtU3G4.write(B8xe9NVP.readLine());
			IEDtU3G4.newLine();
			String oUWwadg1;
			while ((oUWwadg1 = B8xe9NVP.readLine()) != null) {
				String[] FVJvav3r = oUWwadg1.split("\t");
				if (nm1xCf7T.containsStage(Integer.parseInt(FVJvav3r[0]), Integer.parseInt(FVJvav3r[1]),
						Integer.parseInt(FVJvav3r[2]))) {
					IEDtU3G4.write(oUWwadg1);
					IEDtU3G4.newLine();
					IEDtU3G4.flush();
				}
			}
			B8xe9NVP.close();
			IEDtU3G4.close();
		} catch (FileNotFoundException G1WjvZPD) {
			System.out.println("Could not find source file for selected stages.");
			G1WjvZPD.printStackTrace();
		} catch (IOException FdMeqFpz) {
			System.out.println("IO Exception while reading or writing zgps.");
			FdMeqFpz.printStackTrace();
		}
		System.out.println("Done.");
	}

}