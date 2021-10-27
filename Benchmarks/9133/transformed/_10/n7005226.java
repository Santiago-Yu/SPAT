class n7005226 {
	private void copyValidFile(File file, int cviceni) {
		try {
			boolean copy = false;
			String filename = String.format("%s%s%02d%s%s", validovane, File.separator, cviceni, File.separator,
					file.getName());
			File newFile = new File(filename);
			if (newFile.exists()) {
				if (file.lastModified() > newFile.lastModified())
					copy = true;
				else
					copy = false;
			} else {
				newFile.createNewFile();
				copy = true;
			}
			if (copy) {
				FileReader fr = new FileReader(file);
				String EOL = "" + (char) 0x0D + (char) 0x0A;
				FileWriter fw = new FileWriter(newFile);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null)
					fw.write(line + EOL);
				br.close();
				fw.close();
				newFile.setLastModified(file.lastModified());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}