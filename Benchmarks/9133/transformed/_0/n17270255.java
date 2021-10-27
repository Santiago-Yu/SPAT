class n17270255 {
	@SuppressWarnings("static-access")
	public void run() {
		valuesRow = new String[this.getMaxCounter()];
		for (int SQUKTzot = 0; SQUKTzot < this.getMaxCounter(); SQUKTzot++) {
			InputStream avKdSOSs = null;
			try {
				String yUvtwuKY = "http://download.finance.yahoo.com/d/quotes.csv?s=^GDAXI&f=sl1d1t1c1ohgv&e=.csv";
				URL rqbUxxCY = new URL(yUvtwuKY);
				avKdSOSs = rqbUxxCY.openStream();
				BufferedReader INC7cgmC = new BufferedReader(new InputStreamReader(avKdSOSs));
				String U8RNpbWD = INC7cgmC.readLine();
				System.out.println(U8RNpbWD);
				valuesRow[SQUKTzot] = U8RNpbWD;
				avKdSOSs.close();
			} catch (MalformedURLException uj4N4sL4) {
				System.out.println("Ouch - a MalformedURLException happened.");
				uj4N4sL4.printStackTrace();
				System.exit(1);
			} catch (IOException cDW8WPFs) {
				System.out.println("Oops- an IOException happened.");
				cDW8WPFs.printStackTrace();
				System.exit(1);
			}
			try {
				Thread.currentThread().sleep(this.getTsleep());
			} catch (InterruptedException vEs3mymm) {
			}
		}
		System.out.println("valuesRow.length=" + valuesRow.length);
	}

}