class n6102140 {
	public static void main(String[] bvNuJksy) {
		try {
			boolean xU8mNeND = Utils.getFlag('l', bvNuJksy);
			final boolean scxSxdhS = Utils.getFlag('s', bvNuJksy);
			final String p35WtaQS = Utils.getOption('f', bvNuJksy);
			if ((xU8mNeND || scxSxdhS) && (p35WtaQS.length() == 0)) {
				throw new Exception("A filename must be given with the -f option");
			}
			Experiment caoneyjz = null;
			if (xU8mNeND) {
				FileInputStream kBbNtupg = new FileInputStream(p35WtaQS);
				ObjectInputStream Mcq0X8h9 = new ObjectInputStream(new BufferedInputStream(kBbNtupg));
				caoneyjz = (Experiment) Mcq0X8h9.readObject();
				Mcq0X8h9.close();
			} else {
				caoneyjz = new Experiment();
			}
			System.err.println("Initial Experiment:\n" + caoneyjz.toString());
			final JFrame WGJeRmsA = new JFrame("Weka Experiment Setup");
			WGJeRmsA.getContentPane().setLayout(new BorderLayout());
			final SetupPanel jCUtJZbT = new SetupPanel();
			WGJeRmsA.getContentPane().add(jCUtJZbT, BorderLayout.CENTER);
			WGJeRmsA.addWindowListener(new WindowAdapter() {

				public void windowClosing(WindowEvent oAV4TPJw) {
					System.err.println("\nFinal Experiment:\n" + jCUtJZbT.m_Exp.toString());
					if (scxSxdhS) {
						try {
							FileOutputStream PqIaw4kY = new FileOutputStream(p35WtaQS);
							ObjectOutputStream KKuOTBIE = new ObjectOutputStream(new BufferedOutputStream(PqIaw4kY));
							KKuOTBIE.writeObject(jCUtJZbT.m_Exp);
							KKuOTBIE.close();
						} catch (Exception eP3suelD) {
							eP3suelD.printStackTrace();
							System.err.println(
									"Couldn't write experiment to: " + p35WtaQS + '\n' + eP3suelD.getMessage());
						}
					}
					WGJeRmsA.dispose();
					System.exit(0);
				}
			});
			WGJeRmsA.pack();
			WGJeRmsA.setVisible(true);
			System.err.println("Short nap");
			Thread.currentThread().sleep(3000);
			System.err.println("Done");
			jCUtJZbT.setExperiment(caoneyjz);
		} catch (Exception WqN1kvPl) {
			WqN1kvPl.printStackTrace();
			System.err.println(WqN1kvPl.getMessage());
		}
	}

}