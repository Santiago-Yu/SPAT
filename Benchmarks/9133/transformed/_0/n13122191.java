class n13122191 {
	public static void copy(String knMMUPTb, String R4QcxA89) throws EDITSException {
		try {
			FileReader CGppsNrS = new FileReader(knMMUPTb);
			FileWriter W928yDfc = new FileWriter(R4QcxA89);
			int AlpLoYve;
			while ((AlpLoYve = CGppsNrS.read()) != -1)
				W928yDfc.write(AlpLoYve);
			CGppsNrS.close();
			W928yDfc.close();
		} catch (Exception gGfmwGxa) {
			throw new EDITSException(
					"Could not copy " + knMMUPTb + " into " + R4QcxA89 + " because:\n" + gGfmwGxa.getMessage());
		}
	}

}