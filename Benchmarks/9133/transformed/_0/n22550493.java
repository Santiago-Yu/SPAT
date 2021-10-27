class n22550493 {
	private String createVisadFile(String IKNgmIus) throws FileNotFoundException, IOException {
		ArrayList<String> AKxHA9oH = new ArrayList<String>();
		String pnJN9gtA = IKNgmIus + ".visad";
		BufferedReader hlMLHUQn = new BufferedReader(new FileReader(IKNgmIus));
		String YBnkzLit = hlMLHUQn.readLine().replace('"', ' ');
		StringTokenizer YKTNLG4J = new StringTokenizer(YBnkzLit, ",");
		while (YKTNLG4J.hasMoreTokens())
			AKxHA9oH.add(YKTNLG4J.nextToken());
		StringBuilder ciEphPM7 = new StringBuilder();
		ciEphPM7.append("(").append(AKxHA9oH.get(0)).append("->(");
		for (int uYFJ76Pm = 1; uYFJ76Pm < AKxHA9oH.size(); uYFJ76Pm++) {
			ciEphPM7.append(AKxHA9oH.get(uYFJ76Pm));
			if (uYFJ76Pm < AKxHA9oH.size() - 1)
				ciEphPM7.append(",");
		}
		ciEphPM7.append("))");
		BufferedWriter X76J3mQJ = new BufferedWriter(new FileWriter(pnJN9gtA));
		X76J3mQJ.write(ciEphPM7.toString() + "\n");
		X76J3mQJ.write(YBnkzLit + "\n");
		String ZKuY8gS3;
		while ((ZKuY8gS3 = hlMLHUQn.readLine()) != null)
			X76J3mQJ.write(ZKuY8gS3 + "\n");
		hlMLHUQn.close();
		X76J3mQJ.close();
		return pnJN9gtA;
	}

}