class n11608926 {
	void ProcessRequests(DataInputStream C9zY8wGt, PrintStream ZjxqZjQy) {
		String M7IgF9Bw;
		while (true) {
			try {
				M7IgF9Bw = C9zY8wGt.readLine();
				if (M7IgF9Bw == null)
					return;
				if (M7IgF9Bw.startsWith("select")) {
					ProcessQuery(M7IgF9Bw, ZjxqZjQy);
				} else if (M7IgF9Bw.startsWith("insert")) {
					Statement hJYTCFkj = con.createStatement();
					hJYTCFkj.executeUpdate(M7IgF9Bw);
				} else if (M7IgF9Bw.startsWith("update")) {
					Statement wqyzdCeQ = con.createStatement();
					wqyzdCeQ.executeUpdate(M7IgF9Bw);
				} else if (M7IgF9Bw.startsWith("commit")) {
					con.commit();
				} else if (M7IgF9Bw.startsWith("autocommit true")) {
					con.setAutoCommit(true);
				} else if (M7IgF9Bw.startsWith("autocommit false")) {
					con.setAutoCommit(false);
				} else if (M7IgF9Bw.startsWith("delete")) {
					Statement kPjgM0E2 = con.createStatement();
					kPjgM0E2.executeUpdate(M7IgF9Bw);
				} else if (M7IgF9Bw.startsWith("rollback")) {
					con.rollback();
				} else {
					ZjxqZjQy.println("What ?");
				}
				ZjxqZjQy.println(">");
			} catch (SQLException s1Yh76mF) {
				ZjxqZjQy.println("\n*** SQLException caught ***\n");
				while (s1Yh76mF != null) {
					ZjxqZjQy.println("SQLState: " + s1Yh76mF.getSQLState());
					ZjxqZjQy.println("Message:  " + s1Yh76mF.getMessage());
					ZjxqZjQy.println("Vendor:   " + s1Yh76mF.getErrorCode());
					s1Yh76mF = s1Yh76mF.getNextException();
					ZjxqZjQy.println("");
				}
			} catch (java.lang.Exception WvR53C9o) {
				WvR53C9o.printStackTrace();
			}
		}
	}

}