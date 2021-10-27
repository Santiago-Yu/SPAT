class n9449064 {
	public static void main(String[] BCVpj1Y3) {
		try {
			boolean S5xVBtCk = Utils.getFlag('l', BCVpj1Y3);
			final boolean GGHLaBz1 = Utils.getFlag('s', BCVpj1Y3);
			final String cjhk1Wz6 = Utils.getOption('f', BCVpj1Y3);
			if ((S5xVBtCk || GGHLaBz1) && (cjhk1Wz6.length() == 0)) {
				throw new Exception("A filename must be given with the -f option");
			}
			Experiment WqsVvOTa = null;
			if (S5xVBtCk) {
				FileInputStream cc4qOeGY = new FileInputStream(cjhk1Wz6);
				ObjectInputStream Cc073isr = new ObjectInputStream(new BufferedInputStream(cc4qOeGY));
				WqsVvOTa = (Experiment) Cc073isr.readObject();
				Cc073isr.close();
			} else {
				WqsVvOTa = new Experiment();
			}
			System.err.println("Initial Experiment:\n" + WqsVvOTa.toString());
			final JFrame rsuXCGH9 = new JFrame("Weka Experiment Setup");
			rsuXCGH9.getContentPane().setLayout(new BorderLayout());
			final SetupPanel c1yGk0eq = new SetupPanel();
			rsuXCGH9.getContentPane().add(c1yGk0eq, BorderLayout.CENTER);
			rsuXCGH9.addWindowListener(new WindowAdapter() {

				public void windowClosing(WindowEvent dtiVKejK) {
					System.err.println("\nFinal Experiment:\n" + c1yGk0eq.m_Exp.toString());
					if (GGHLaBz1) {
						try {
							FileOutputStream mTzgS2qr = new FileOutputStream(cjhk1Wz6);
							ObjectOutputStream nQpB1BGA = new ObjectOutputStream(new BufferedOutputStream(mTzgS2qr));
							nQpB1BGA.writeObject(c1yGk0eq.m_Exp);
							nQpB1BGA.close();
						} catch (Exception b4r7rQ32) {
							b4r7rQ32.printStackTrace();
							System.err.println(
									"Couldn't write experiment to: " + cjhk1Wz6 + '\n' + b4r7rQ32.getMessage());
						}
					}
					rsuXCGH9.dispose();
					System.exit(0);
				}
			});
			rsuXCGH9.pack();
			rsuXCGH9.setVisible(true);
			System.err.println("Short nap");
			Thread.currentThread().sleep(3000);
			System.err.println("Done");
			c1yGk0eq.setExperiment(WqsVvOTa);
		} catch (Exception Yezlpidx) {
			Yezlpidx.printStackTrace();
			System.err.println(Yezlpidx.getMessage());
		}
	}

}