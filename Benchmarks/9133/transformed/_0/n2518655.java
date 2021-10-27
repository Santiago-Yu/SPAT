class n2518655 {
	public static void main(String[] wCRK9X5h) throws FileNotFoundException {
		if (wCRK9X5h.length < 2)
			throw new IllegalArgumentException();
		String Vty9NVgI = wCRK9X5h[wCRK9X5h.length - 1];
		PrintWriter Rjim8m2N = new PrintWriter(Vty9NVgI);
		for (int qFomY0P0 = 0; qFomY0P0 < wCRK9X5h.length - 1; qFomY0P0++) {
			File k4LokY2w = new File(wCRK9X5h[qFomY0P0]);
			Scanner ozoFFGea = new Scanner(k4LokY2w);
			while (ozoFFGea.hasNext()) {
				Rjim8m2N.println(ozoFFGea.nextLine());
			}
		}
		Rjim8m2N.close();
	}

}