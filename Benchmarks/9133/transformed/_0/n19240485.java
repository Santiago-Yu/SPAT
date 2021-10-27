class n19240485 {
	private String createCSVFile(String kt8UAxAR) throws FileNotFoundException, IOException {
		String HGGtUSEw = kt8UAxAR + ".csv";
		BufferedReader gLPBFYIH = new BufferedReader(new FileReader(kt8UAxAR));
		BufferedWriter eNgN8ieI = new BufferedWriter(new FileWriter(HGGtUSEw));
		String qOOqwVRi;
		while ((qOOqwVRi = gLPBFYIH.readLine()) != null)
			eNgN8ieI.write(qOOqwVRi + "\n");
		gLPBFYIH.close();
		eNgN8ieI.close();
		return HGGtUSEw;
	}

}