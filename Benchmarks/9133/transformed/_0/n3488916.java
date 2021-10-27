class n3488916 {
	public static void main(String[] WkXgnJxS) {
		if (WkXgnJxS.length != 2)
			throw new IllegalArgumentException("Expected arguments: fileName log");
		String CNKWgkSt = WkXgnJxS[0];
		String VrvIhck8 = WkXgnJxS[1];
		LineNumberReader XDjx73KT = null;
		PrintWriter z2oLLxPm = null;
		try {
			Reader qg8EvAwb = new FileReader(CNKWgkSt);
			XDjx73KT = new LineNumberReader(qg8EvAwb);
			Writer JdekMHVX = new FileWriter(VrvIhck8);
			BufferedWriter ltlHP5Kf = new BufferedWriter(JdekMHVX);
			z2oLLxPm = new PrintWriter(ltlHP5Kf);
			String fFUhpbzr = XDjx73KT.readLine();
			while (fFUhpbzr != null) {
				fFUhpbzr = fFUhpbzr.trim();
				if (fFUhpbzr.length() >= 81) {
					z2oLLxPm.println("Analyzing Sudoku #" + XDjx73KT.getLineNumber());
					System.out.println("Analyzing Sudoku #" + XDjx73KT.getLineNumber());
					Grid qayyM92f = new Grid();
					for (int HSvuOedk = 0; HSvuOedk < 81; HSvuOedk++) {
						char vDqP4CSm = fFUhpbzr.charAt(HSvuOedk);
						if (vDqP4CSm >= '1' && vDqP4CSm <= '9') {
							int bq0Veunc = (vDqP4CSm - '0');
							qayyM92f.setCellValue(HSvuOedk % 9, HSvuOedk / 9, bq0Veunc);
						}
					}
					Solver v96cCRHu = new Solver(qayyM92f);
					v96cCRHu.rebuildPotentialValues();
					try {
						Map<Rule, Integer> gAnuQExN = v96cCRHu.solve(null);
						Map<String, Integer> fxaOkFEk = v96cCRHu.toNamedList(gAnuQExN);
						double mFXmcXDi = 0;
						String SkWZ6Lcn = "";
						for (Rule wcxhrl3Q : gAnuQExN.keySet()) {
							if (wcxhrl3Q.getDifficulty() > mFXmcXDi) {
								mFXmcXDi = wcxhrl3Q.getDifficulty();
								SkWZ6Lcn = wcxhrl3Q.getName();
							}
						}
						for (String U65AeUgW : fxaOkFEk.keySet()) {
							int Q9Cli6z9 = fxaOkFEk.get(U65AeUgW);
							z2oLLxPm.println(Integer.toString(Q9Cli6z9) + " " + U65AeUgW);
							System.out.println(Integer.toString(Q9Cli6z9) + " " + U65AeUgW);
						}
						z2oLLxPm.println("Hardest technique: " + SkWZ6Lcn);
						System.out.println("Hardest technique: " + SkWZ6Lcn);
						z2oLLxPm.println("Difficulty: " + mFXmcXDi);
						System.out.println("Difficulty: " + mFXmcXDi);
					} catch (UnsupportedOperationException dN9r3VO8) {
						z2oLLxPm.println("Failed !");
						System.out.println("Failed !");
					}
					z2oLLxPm.println();
					System.out.println();
					z2oLLxPm.flush();
				} else
					System.out.println("Skipping incomplete line: " + fFUhpbzr);
				fFUhpbzr = XDjx73KT.readLine();
			}
			z2oLLxPm.close();
			XDjx73KT.close();
		} catch (FileNotFoundException wYzMY60d) {
			wYzMY60d.printStackTrace();
		} catch (IOException QIYYmu84) {
			QIYYmu84.printStackTrace();
		} finally {
			try {
				if (XDjx73KT != null)
					XDjx73KT.close();
				if (z2oLLxPm != null)
					z2oLLxPm.close();
			} catch (IOException L9lJR1DM) {
				L9lJR1DM.printStackTrace();
			}
		}
		System.out.print("Finished.");
	}

}