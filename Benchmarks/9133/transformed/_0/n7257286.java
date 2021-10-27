class n7257286 {
	public static void main(String[] r4ffLhPm) {
		if (r4ffLhPm.length <= 0) {
			System.out.println(" *** DML script generator and executor ***");
			System.out.println(" You must specify name of the file with SQL script data");
			System.out.println(" Fisrt rows of this file must be:");
			System.out.println(" 1) JDBC driver class for your DBMS");
			System.out.println(" 2) URL for your database instance");
			System.out.println(" 3) user in that database (with sufficient priviliges)");
			System.out.println(" 4) password of that user");
			System.out.println(" Next rows can have:");
			System.out.println("   '&' before table to insert into,");
			System.out.println("   '^' before table delete from,");
			System.out.println("   '*' before table update.");
			System.out.println(" Other rows contain parameters of these actions:");
			System.out.println("   for & action each parameter is a list of values,");
			System.out.println("   for * action -//- pare of values with 1st PK (will be in where clause),");
			System.out.println("   for ^ (not obligatory) -//- part of where clause or AND or OR");
			System.out.println("    (by depault parts are united with OR)");
			System.out.println(" Note: despite SQLScript, 1) list (pare) of values can be separated");
			System.out.println("   by space or tab, not only comma and 2) string values can be not quoted,");
			System.out.println("   but in this (2) case only 2 values allowed (even in insert)");
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
			String[] m29IoY9h = new String[4];
			BufferedReader SF3tfGG5 = new BufferedReader(new FileReader(new File(r4ffLhPm[0])));
			Writer ASPXsEdq = null;
			try {
				for (int YR4G8klC = 0; YR4G8klC < m29IoY9h.length; YR4G8klC++)
					m29IoY9h[YR4G8klC] = SF3tfGG5.readLine();
				try {
					Class.forName(m29IoY9h[0]);
					Connection EL2kiRWH = DriverManager.getConnection(m29IoY9h[1], m29IoY9h[2], m29IoY9h[3]);
					SQLScript I6LuetPU = new DMLScript(EL2kiRWH);
					if (r4ffLhPm.length > 1) {
						ASPXsEdq = new BufferedWriter(new FileWriter(r4ffLhPm[1]));
						if (r4ffLhPm.length > 2)
							ASPXsEdq.write("connect " + m29IoY9h[2] + "/" + m29IoY9h[3] + "@" + r4ffLhPm[2]
									+ I6LuetPU.statementTerminator);
					}
					try {
						System.out.println(I6LuetPU.executeScript(SF3tfGG5, ASPXsEdq)
								+ " updates has been performed during script execution");
					} catch (SQLException eYiu2wAK) {
						SF3tfGG5.close();
						if (ASPXsEdq != null)
							ASPXsEdq.close();
						System.out.println(" Script execution error: " + eYiu2wAK);
					}
					EL2kiRWH.close();
				} catch (Exception h7TjLdPv) {
					SF3tfGG5.close();
					if (ASPXsEdq != null)
						ASPXsEdq.close();
					System.out.println(" Connection error: " + h7TjLdPv);
				}
			} catch (IOException pkGXfVAQ) {
				System.out.println("Error in file " + r4ffLhPm[0]);
			}
		} catch (FileNotFoundException Bxy97txZ) {
			System.out.println("File " + r4ffLhPm[0] + " not found");
		}
	}

}