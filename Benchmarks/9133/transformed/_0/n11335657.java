class n11335657 {
	public void sorter() {
		String tqAox4ZK, n3OSLjNj;
		String fihgs99z[] = new String[1000];
		String I7yeawSF[] = new String[1000];
		int Jc552scK = 0;
		try {
			String orNwETMq = pluginInterface.getPluginDirectoryName();
			String UvKfY1Ms = orNwETMq + System.getProperty("file.separator") + "EpisodeList.txt";
			File qGG5Pbh6 = new File(UvKfY1Ms);
			if (!qGG5Pbh6.isFile()) {
				qGG5Pbh6.createNewFile();
			}
			final BufferedReader GzkFUk4z = new BufferedReader(new FileReader(qGG5Pbh6));
			while ((tqAox4ZK = GzkFUk4z.readLine()) != null) {
				if ((n3OSLjNj = GzkFUk4z.readLine()) != null) {
					fihgs99z[Jc552scK] = tqAox4ZK;
					I7yeawSF[Jc552scK] = n3OSLjNj;
					Jc552scK++;
				}
			}
			GzkFUk4z.close();
			int sPh8IOhf = fihgs99z.length;
			for (int NbeO0Cm8 = 0; NbeO0Cm8 < (Jc552scK); NbeO0Cm8++) {
				for (int TCrWF1DT = 0; TCrWF1DT < (Jc552scK - 1); TCrWF1DT++) {
					if (fihgs99z[TCrWF1DT].compareToIgnoreCase(fihgs99z[TCrWF1DT + 1]) > 0) {
						String Y9J8Q51J = fihgs99z[TCrWF1DT];
						fihgs99z[TCrWF1DT] = fihgs99z[TCrWF1DT + 1];
						fihgs99z[TCrWF1DT + 1] = Y9J8Q51J;
						String pFIkfMMn = I7yeawSF[TCrWF1DT];
						I7yeawSF[TCrWF1DT] = I7yeawSF[TCrWF1DT + 1];
						I7yeawSF[TCrWF1DT + 1] = pFIkfMMn;
					}
				}
			}
			File PZ92dNJj = new File(UvKfY1Ms);
			BufferedWriter twZO7BU9 = new BufferedWriter(new FileWriter(PZ92dNJj));
			for (int Qc17vj51 = 0; Qc17vj51 <= Jc552scK; Qc17vj51++) {
				if (fihgs99z[Qc17vj51] == null) {
					break;
				}
				twZO7BU9.write(fihgs99z[Qc17vj51] + "\n");
				twZO7BU9.write(I7yeawSF[Qc17vj51] + "\n");
			}
			twZO7BU9.close();
		} catch (IOException RjVWB6gp) {
			RjVWB6gp.printStackTrace();
		}
	}

}