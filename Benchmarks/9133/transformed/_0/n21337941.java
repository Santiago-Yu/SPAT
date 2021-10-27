class n21337941 {
	public static void main(String[] dtjwudz9) throws IOException {
		int jvJ6SRL4;
		for (jvJ6SRL4 = 0; jvJ6SRL4 < dtjwudz9.length; jvJ6SRL4++) {
			if (dtjwudz9[jvJ6SRL4].charAt(0) != '-')
				break;
			++jvJ6SRL4;
			switch (dtjwudz9[jvJ6SRL4 - 1].charAt(1)) {
			case 'b':
				try {
					flag_predict_probability = (atoi(dtjwudz9[jvJ6SRL4]) != 0);
				} catch (NumberFormatException vw5xz6JZ) {
					exit_with_help();
				}
				break;
			default:
				System.err.printf("unknown option: -%d%n", dtjwudz9[jvJ6SRL4 - 1].charAt(1));
				exit_with_help();
				break;
			}
		}
		if (jvJ6SRL4 >= dtjwudz9.length || dtjwudz9.length <= jvJ6SRL4 + 2) {
			exit_with_help();
		}
		BufferedReader iqG7oFpJ = null;
		Writer FkUY7EcL = null;
		try {
			iqG7oFpJ = new BufferedReader(
					new InputStreamReader(new FileInputStream(dtjwudz9[jvJ6SRL4]), Linear.FILE_CHARSET));
			FkUY7EcL = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(dtjwudz9[jvJ6SRL4 + 2]), Linear.FILE_CHARSET));
			Model MukOU7NZ = Linear.loadModel(new File(dtjwudz9[jvJ6SRL4 + 1]));
			doPredict(iqG7oFpJ, FkUY7EcL, MukOU7NZ);
		} finally {
			closeQuietly(iqG7oFpJ);
			closeQuietly(FkUY7EcL);
		}
	}

}