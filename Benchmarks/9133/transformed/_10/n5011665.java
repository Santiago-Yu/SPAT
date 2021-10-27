class n5011665 {
	public void upgradeSingleFileModelToDirectory(File modelFile) throws IOException {
		int bytesRead = 0;
		byte[] buf = new byte[8192];
		File backupModelFile = new File(modelFile.getPath() + ".bak");
		FileOutputStream backupModelOut = new FileOutputStream(backupModelFile);
		FileInputStream oldModelIn = new FileInputStream(modelFile);
		while ((bytesRead = oldModelIn.read(buf)) >= 0) {
			backupModelOut.write(buf, 0, bytesRead);
		}
		backupModelOut.close();
		oldModelIn.close();
		buf = null;
		modelFile.delete();
		modelFile.mkdir();
		File metaDataFile = new File(modelFile, ConstantParameters.FILENAMEOFModelMetaData);
		BufferedReader oldModelsBuff = new BomStrippingInputStreamReader(new FileInputStream(backupModelFile), "UTF-8");
		BufferedWriter metaDataBuff = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(metaDataFile), "UTF-8"));
		for (int i = 0; i < 8; i++) {
			metaDataBuff.write(oldModelsBuff.readLine());
			metaDataBuff.write('\n');
		}
		metaDataBuff.close();
		BufferedWriter modelWriter = null;
		int classIndex = 1;
		String line = null;
		while ((line = oldModelsBuff.readLine()) != null) {
			if (line.startsWith("Class=") && line.contains("numTraining=") && line.contains("numPos=")) {
				if (modelWriter != null) {
					modelWriter.close();
				}
				File nextModel = new File(modelFile,
						String.format(ConstantParameters.FILENAMEOFPerClassModel, Integer.valueOf(classIndex++)));
				modelWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nextModel), "UTF-8"));
			}
			modelWriter.write(line);
			modelWriter.write('\n');
		}
		if (modelWriter != null) {
			modelWriter.close();
		}
	}

}