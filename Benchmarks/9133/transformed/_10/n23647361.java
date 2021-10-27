class n23647361 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/test";
		String user = "root";
		String password = "password";
		String imageLocation = "C:\\Documents and Settings\\EddyM\\Desktop\\Nick\\01100002.tif";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		String imageLocation2 = "C:\\Documents and Settings\\EddyM\\Desktop\\Nick\\011000022.tif";
		try {
			File f = new File(imageLocation);
			Connection c = DriverManager.getConnection(url, user, password);
			InputStream fis = new FileInputStream(f);
			ResultSet rs = c.createStatement().executeQuery("SELECT Image FROM ImageTable WHERE ImageID=12345678");
			new File(imageLocation2).createNewFile();
			rs.first();
			System.out.println("GotFirst");
			InputStream is = rs.getAsciiStream("Image");
			System.out.println("gotStream");
			int readInt;
			FileOutputStream fos = new FileOutputStream(new File(imageLocation2));
			int i = 0;
			while (true) {
				readInt = is.read();
				i++;
				if (readInt == -1) {
					System.out.println("ReadInt == -1");
					break;
				}
				if (i % 1000000 == 0)
					System.out.println(i + " / " + is.available());
				fos.write(readInt);
			}
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}