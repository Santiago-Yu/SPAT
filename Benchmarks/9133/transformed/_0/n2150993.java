class n2150993 {
	public static void main(String[] nSdXRU5T) {
		if (nSdXRU5T.length <= 0) {
			System.out.println(" *** SQL script generator and executor ***");
			System.out.println(" You must specify name of the file with SQL script data");
			System.out.println(" Fisrt rows of this file must be:");
			System.out.println(" 1) JDBC driver class for your DBMS");
			System.out.println(" 2) URL for your database instance");
			System.out.println(" 3) user in that database (with administrator priviliges)");
			System.out.println(" 4) password of that user");
			System.out.println(" Next rows can have: '@' before schema to create,");
			System.out.println("   '#' before table to create, '&' before table to insert,");
			System.out.println("   '$' before trigger (inverse 'FK on delete cascade') to create,");
			System.out.println("   '>' before table to drop, '<' before schema to drop.");
			System.out.println(" Other rows contain parameters of these actions:");
			System.out.println("   for & action each parameter is a list of values,");
			System.out.println("   for @ -//- is # acrion, for # -//- is column/constraint ");
			System.out.println("    definition or $ action. $ syntax to delete from table:");
			System.out.println("    fullNameOfTable:itsColInWhereClause=matchingColOfThisTable");
			System.out.println(" '!' before row means that it is a comment.");
			System.out.println(" If some exception is occured, all script is rolled back.");
			System.out.println(" If you specify 2nd command line argument - file name too -");
			System.out.println("   connection will be established but all statements will");
			System.out.println("   be saved in that output file and not transmitted to DB");
			System.out.println(" If you specify 3nd command line argument - connect_string -");
			System.out.println("   connect information will be added to output file");
			System.out.println("   in the form 'connect user/password@connect_string'");
			System.exit(0);
		}
		try {
			String[] hXkdDKAG = new String[4];
			BufferedReader bqQ2BmzF = new BufferedReader(new FileReader(new File(nSdXRU5T[0])));
			Writer C8f3n08n = null;
			try {
				for (int yN5LzdgI = 0; yN5LzdgI < 4; yN5LzdgI++)
					hXkdDKAG[yN5LzdgI] = bqQ2BmzF.readLine();
				try {
					Class.forName(hXkdDKAG[0]);
					Connection Zzco8hKY = DriverManager.getConnection(hXkdDKAG[1], hXkdDKAG[2], hXkdDKAG[3]);
					SQLScript RamZvNXt = new SQLScript(Zzco8hKY);
					if (nSdXRU5T.length > 1) {
						C8f3n08n = new FileWriter(nSdXRU5T[1]);
						if (nSdXRU5T.length > 2)
							C8f3n08n.write("connect " + hXkdDKAG[2] + "/" + hXkdDKAG[3] + "@" + nSdXRU5T[2]
									+ RamZvNXt.statementTerminator);
					}
					try {
						System.out.println(RamZvNXt.executeScript(bqQ2BmzF, C8f3n08n)
								+ " updates has been performed during script execution");
					} catch (SQLException rp2i8G6o) {
						bqQ2BmzF.close();
						if (C8f3n08n != null)
							C8f3n08n.close();
						System.out.println(" Script execution error: " + rp2i8G6o);
					}
					Zzco8hKY.close();
				} catch (Exception QrNifXua) {
					bqQ2BmzF.close();
					if (C8f3n08n != null)
						C8f3n08n.close();
					System.out.println(" Connection error: " + QrNifXua);
				}
			} catch (IOException TexuxTzd) {
				System.out.println("Error in file " + nSdXRU5T[0]);
			}
		} catch (FileNotFoundException zE2ZSZb0) {
			System.out.println("File " + nSdXRU5T[0] + " not found");
		}
	}

}