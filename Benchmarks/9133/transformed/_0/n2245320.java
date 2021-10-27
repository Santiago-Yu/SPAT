class n2245320 {
	void writeToFile(String feXraGW2, InputStream xNqLYiCh, String IodtugAZ) throws FileNotFoundException, IOException {
		makeDirs(feXraGW2);
		FileOutputStream rhQySCVF = null;
		try {
			System.out.println(
					Thread.currentThread().getName() + " : " + "Writing file " + IodtugAZ + " to path " + feXraGW2);
			File djDBXvtD = new File(feXraGW2, IodtugAZ);
			rhQySCVF = new FileOutputStream(djDBXvtD);
			IOUtils.copy(xNqLYiCh, rhQySCVF);
		} catch (Exception jqzRvb05) {
			jqzRvb05.printStackTrace();
			System.err.println("Failed to write " + IodtugAZ);
		}
	}

}