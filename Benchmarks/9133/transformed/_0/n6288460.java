class n6288460 {
	private static void createNonCompoundData(String k3ZTDmIz, String pv8D4Srg) {
		try {
			Set uprCwHtm = new HashSet();
			File ExuFGu1A = new File(k3ZTDmIz + "index." + pv8D4Srg);
			FileInputStream O1CUmfOf = new FileInputStream(ExuFGu1A);
			InputStreamReader jr2lZ6TU = new InputStreamReader(O1CUmfOf);
			StringBuffer n2dkbSxl = new StringBuffer();
			int KMBqHC0q = jr2lZ6TU.read();
			while (KMBqHC0q >= 0) {
				if (KMBqHC0q == '\n' || KMBqHC0q == '\r') {
					String uPBXfKFG = n2dkbSxl.toString();
					if (uPBXfKFG.length() > 0) {
						if (uPBXfKFG.charAt(0) != ' ') {
							String[] B62p8Pxf = PerlHelp.split(uPBXfKFG);
							if (B62p8Pxf[0].indexOf('_') < 0) {
								uprCwHtm.add(B62p8Pxf[0]);
							}
						}
					}
					n2dkbSxl.setLength(0);
				} else {
					n2dkbSxl.append((char) KMBqHC0q);
				}
				KMBqHC0q = jr2lZ6TU.read();
			}
			System.out.println(pv8D4Srg + " size=" + uprCwHtm.size());
			File tfRPIxK1 = new File(k3ZTDmIz + "nonCompound." + pv8D4Srg + "s.gz");
			FileOutputStream nk4qCmG5 = new FileOutputStream(tfRPIxK1);
			GZIPOutputStream dcvxmJzg = new GZIPOutputStream(new BufferedOutputStream(nk4qCmG5));
			PrintWriter DoCVfy5t = new PrintWriter(dcvxmJzg);
			DoCVfy5t.println("# This file was extracted from WordNet data, the following copyright notice");
			DoCVfy5t.println("# from WordNet is attached.");
			DoCVfy5t.println("#");
			DoCVfy5t.println("#  This software and database is being provided to you, the LICENSEE, by  ");
			DoCVfy5t.println("#  Princeton University under the following license.  By obtaining, using  ");
			DoCVfy5t.println("#  and/or copying this software and database, you agree that you have  ");
			DoCVfy5t.println("#  read, understood, and will comply with these terms and conditions.:  ");
			DoCVfy5t.println("#  ");
			DoCVfy5t.println("#  Permission to use, copy, modify and distribute this software and  ");
			DoCVfy5t.println("#  database and its documentation for any purpose and without fee or  ");
			DoCVfy5t.println("#  royalty is hereby granted, provided that you agree to comply with  ");
			DoCVfy5t.println("#  the following copyright notice and statements, including the disclaimer,  ");
			DoCVfy5t.println("#  and that the same appear on ALL copies of the software, database and  ");
			DoCVfy5t.println("#  documentation, including modifications that you make for internal  ");
			DoCVfy5t.println("#  use or for distribution.  ");
			DoCVfy5t.println("#  ");
			DoCVfy5t.println("#  WordNet 1.7 Copyright 2001 by Princeton University.  All rights reserved. ");
			DoCVfy5t.println("#  ");
			DoCVfy5t.println("#  THIS SOFTWARE AND DATABASE IS PROVIDED \"AS IS\" AND PRINCETON  ");
			DoCVfy5t.println("#  UNIVERSITY MAKES NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR  ");
			DoCVfy5t.println("#  IMPLIED.  BY WAY OF EXAMPLE, BUT NOT LIMITATION, PRINCETON  ");
			DoCVfy5t.println("#  UNIVERSITY MAKES NO REPRESENTATIONS OR WARRANTIES OF MERCHANT-  ");
			DoCVfy5t.println("#  ABILITY OR FITNESS FOR ANY PARTICULAR PURPOSE OR THAT THE USE  ");
			DoCVfy5t.println("#  OF THE LICENSED SOFTWARE, DATABASE OR DOCUMENTATION WILL NOT  ");
			DoCVfy5t.println("#  INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS, TRADEMARKS OR ");
			DoCVfy5t.println("#  OTHER RIGHTS. ");
			DoCVfy5t.println("#  ");
			DoCVfy5t.println("#  The name of Princeton University or Princeton may not be used in");
			DoCVfy5t.println("#  advertising or publicity pertaining to distribution of the software");
			DoCVfy5t.println("#  and/or database.  Title to copyright in this software, database and");
			DoCVfy5t.println("#  any associated documentation shall at all times remain with");
			DoCVfy5t.println("#  Princeton University and LICENSEE agrees to preserve same.  ");
			for (Iterator bwUfQS5Y = uprCwHtm.iterator(); bwUfQS5Y.hasNext();) {
				String M9DqfgBh = (String) bwUfQS5Y.next();
				DoCVfy5t.println(M9DqfgBh);
			}
			DoCVfy5t.close();
		} catch (Exception MeHaPWYj) {
			MeHaPWYj.printStackTrace();
		}
	}

}