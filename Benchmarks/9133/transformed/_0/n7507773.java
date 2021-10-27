class n7507773 {
	public boolean restore(File DwVloG80) {
		log.debug("restore file from directory " + DwVloG80.getAbsolutePath());
		try {
			if (!DwVloG80.exists())
				return false;
			String[] TYqnHoJA = DwVloG80.list();
			if (TYqnHoJA.length < 6) {
				log.error("Only " + TYqnHoJA.length + " files found in directory " + DwVloG80.getAbsolutePath());
				return false;
			}
			int yfM2B5Xe = 0;
			for (int cu0kB3HH = 0; cu0kB3HH < TYqnHoJA.length; cu0kB3HH++) {
				if (!TYqnHoJA[cu0kB3HH].toUpperCase().endsWith(".XML"))
					continue;
				log.debug("found file: " + TYqnHoJA[cu0kB3HH]);
				yfM2B5Xe++;
				File yLpSUzPX = new File(DwVloG80.getAbsolutePath() + File.separator + TYqnHoJA[cu0kB3HH]);
				File bPc4vUck = new File(operationsDirectory + File.separator + TYqnHoJA[cu0kB3HH]);
				FileReader jbk7q8hz = new FileReader(yLpSUzPX);
				FileWriter rEqWvWVJ = new FileWriter(bPc4vUck);
				int eFiGNfbr;
				while ((eFiGNfbr = jbk7q8hz.read()) != -1)
					rEqWvWVJ.write(eFiGNfbr);
				jbk7q8hz.close();
				rEqWvWVJ.close();
			}
			if (yfM2B5Xe < 6)
				return false;
			return true;
		} catch (Exception b7TvTas9) {
			log.error("Exception while restoring operations files, may not be complete: " + b7TvTas9);
			return false;
		}
	}

}