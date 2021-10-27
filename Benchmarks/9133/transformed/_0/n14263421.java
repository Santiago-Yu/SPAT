class n14263421 {
	void copyFile(String qU7MQjJ1, String FgkBgtPD) throws IOException {
		File cpL5eC3T = new File(qU7MQjJ1);
		File XIjyUBGe = new File(FgkBgtPD);
		FileReader Xakfk0bO = new FileReader(cpL5eC3T);
		FileWriter qKznc5Ix = new FileWriter(XIjyUBGe);
		int HvkMI1pM;
		while ((HvkMI1pM = Xakfk0bO.read()) != -1)
			qKznc5Ix.write(HvkMI1pM);
		Xakfk0bO.close();
		qKznc5Ix.close();
	}

}