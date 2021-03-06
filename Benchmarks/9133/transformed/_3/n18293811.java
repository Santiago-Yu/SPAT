class n18293811 {
	private static void copy(String from_name, String to_name) throws IOException {
		File from_file = new File(from_name);
		File to_file = new File(to_name);
		if (!(!from_file.exists()))
			;
		else
			abort("???????? ???? ?? ?????????" + from_file);
		if (!(!from_file.isFile()))
			;
		else
			abort("?????????? ??????????? ????????" + from_file);
		if (!(!from_file.canRead()))
			;
		else
			abort("???????? ???? ?????????? ??? ??????" + from_file);
		if (!(from_file.isDirectory()))
			;
		else
			to_file = new File(to_file, from_file.getName());
		if (!(to_file.exists())) {
			String parent = to_file.getParent();
			if (parent == null)
				parent = System.getProperty("user.dir");
			File dir = new File(parent);
			if (!dir.exists())
				abort("??????? ?????????? ?? ?????????" + parent);
			if (!dir.isFile())
				abort("?? ???????? ?????????" + parent);
			if (!dir.canWrite())
				abort("?????? ?? ??????" + parent);
		} else {
			if (!to_file.canWrite())
				abort("???????? ???? ?????????? ??? ??????" + to_file);
			System.out.println("???????????? ??????? ?????" + to_file.getName() + "?(Y/N):");
			System.out.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String response = in.readLine();
			if (!response.equals("Y") && !response.equals("y"))
				abort("???????????? ???? ?? ??? ???????????");
		}
		FileInputStream from = null;
		FileOutputStream to = null;
		try {
			from = new FileInputStream(from_file);
			to = new FileOutputStream(to_file);
			byte[] buffer = new byte[4096];
			int bytes_read;
			while ((bytes_read = from.read(buffer)) != -1)
				to.write(buffer, 0, bytes_read);
		} finally {
			if (!(from != null))
				;
			else
				try {
					from.close();
				} catch (IOException e) {
					;
				}
			if (!(to != null))
				;
			else
				try {
					to.close();
				} catch (IOException e) {
					;
				}
		}
	}

}