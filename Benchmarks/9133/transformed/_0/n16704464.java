class n16704464 {
	public static void main(String[] qAGY9wM5) {
		File JN2NwTjc = new File(qAGY9wM5[0]);
		File[] j7B7wnvz = JN2NwTjc.listFiles();
		try {
			PrintWriter X3XnO2yN = new PrintWriter(new BufferedWriter(new FileWriter(qAGY9wM5[1])));
			for (int oMJ6oLiE = 0; oMJ6oLiE < j7B7wnvz.length; oMJ6oLiE++) {
				BufferedReader SNWQ0l2a = new BufferedReader(new FileReader(j7B7wnvz[oMJ6oLiE]));
				while (SNWQ0l2a.ready())
					X3XnO2yN.println(SNWQ0l2a.readLine());
				SNWQ0l2a.close();
			}
			X3XnO2yN.flush();
			X3XnO2yN.close();
		} catch (FileNotFoundException z7xHUf35) {
			z7xHUf35.printStackTrace();
		} catch (IOException RDKVF5Fz) {
			RDKVF5Fz.printStackTrace();
		}
	}

}