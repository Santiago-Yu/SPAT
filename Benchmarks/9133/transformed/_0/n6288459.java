class n6288459 {
	private static void createCompoundData(String EPnspO97, String mnZYPCzS) {
		try {
			Set Qhm5d5gf = new HashSet();
			File rCtHAMr4 = new File(EPnspO97 + "index." + mnZYPCzS);
			FileInputStream pjCBdi9o = new FileInputStream(rCtHAMr4);
			InputStreamReader hApsfFdr = new InputStreamReader(pjCBdi9o);
			StringBuffer WPYqrW5T = new StringBuffer();
			int S93Wgnuj = hApsfFdr.read();
			while (S93Wgnuj >= 0) {
				if (S93Wgnuj == '\n' || S93Wgnuj == '\r') {
					String qR5F9Evc = WPYqrW5T.toString();
					if (qR5F9Evc.length() > 0) {
						String[] HxuImM0y = PerlHelp.split(qR5F9Evc);
						for (int pAa7Gv2v = 0; pAa7Gv2v < HxuImM0y.length; pAa7Gv2v++) {
							if (HxuImM0y[pAa7Gv2v].indexOf('_') >= 0) {
								Qhm5d5gf.add(HxuImM0y[pAa7Gv2v].replace('_', ' '));
							}
						}
					}
					WPYqrW5T.setLength(0);
				} else {
					WPYqrW5T.append((char) S93Wgnuj);
				}
				S93Wgnuj = hApsfFdr.read();
			}
			System.out.println(mnZYPCzS + " size=" + Qhm5d5gf.size());
			File Uxoh2Lqu = new File(EPnspO97 + "compound." + mnZYPCzS + "s.gz");
			FileOutputStream rs8FIbGs = new FileOutputStream(Uxoh2Lqu);
			GZIPOutputStream NTByK5T5 = new GZIPOutputStream(new BufferedOutputStream(rs8FIbGs));
			PrintWriter tY45EPcv = new PrintWriter(NTByK5T5);
			tY45EPcv.println("# This file was extracted from WordNet data, the following copyright notice");
			tY45EPcv.println("# from WordNet is attached.");
			tY45EPcv.println("#");
			tY45EPcv.println("#  This software and database is being provided to you, the LICENSEE, by  ");
			tY45EPcv.println("#  Princeton University under the following license.  By obtaining, using  ");
			tY45EPcv.println("#  and/or copying this software and database, you agree that you have  ");
			tY45EPcv.println("#  read, understood, and will comply with these terms and conditions.:  ");
			tY45EPcv.println("#  ");
			tY45EPcv.println("#  Permission to use, copy, modify and distribute this software and  ");
			tY45EPcv.println("#  database and its documentation for any purpose and without fee or  ");
			tY45EPcv.println("#  royalty is hereby granted, provided that you agree to comply with  ");
			tY45EPcv.println("#  the following copyright notice and statements, including the disclaimer,  ");
			tY45EPcv.println("#  and that the same appear on ALL copies of the software, database and  ");
			tY45EPcv.println("#  documentation, including modifications that you make for internal  ");
			tY45EPcv.println("#  use or for distribution.  ");
			tY45EPcv.println("#  ");
			tY45EPcv.println("#  WordNet 1.7 Copyright 2001 by Princeton University.  All rights reserved. ");
			tY45EPcv.println("#  ");
			tY45EPcv.println("#  THIS SOFTWARE AND DATABASE IS PROVIDED \"AS IS\" AND PRINCETON  ");
			tY45EPcv.println("#  UNIVERSITY MAKES NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR  ");
			tY45EPcv.println("#  IMPLIED.  BY WAY OF EXAMPLE, BUT NOT LIMITATION, PRINCETON  ");
			tY45EPcv.println("#  UNIVERSITY MAKES NO REPRESENTATIONS OR WARRANTIES OF MERCHANT-  ");
			tY45EPcv.println("#  ABILITY OR FITNESS FOR ANY PARTICULAR PURPOSE OR THAT THE USE  ");
			tY45EPcv.println("#  OF THE LICENSED SOFTWARE, DATABASE OR DOCUMENTATION WILL NOT  ");
			tY45EPcv.println("#  INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS, TRADEMARKS OR ");
			tY45EPcv.println("#  OTHER RIGHTS. ");
			tY45EPcv.println("#  ");
			tY45EPcv.println("#  The name of Princeton University or Princeton may not be used in");
			tY45EPcv.println("#  advertising or publicity pertaining to distribution of the software");
			tY45EPcv.println("#  and/or database.  Title to copyright in this software, database and");
			tY45EPcv.println("#  any associated documentation shall at all times remain with");
			tY45EPcv.println("#  Princeton University and LICENSEE agrees to preserve same.  ");
			for (Iterator JDfUcrGM = Qhm5d5gf.iterator(); JDfUcrGM.hasNext();) {
				String sbGNk3Y5 = (String) JDfUcrGM.next();
				tY45EPcv.println(sbGNk3Y5);
			}
			tY45EPcv.close();
		} catch (Exception J8iz8lJQ) {
			J8iz8lJQ.printStackTrace();
		}
	}

}