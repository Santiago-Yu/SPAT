class n4468255 {
	public static void copy(File from, File to) {
		boolean result;
		if (from.isDirectory()) {
			File[] subFiles = from.listFiles();
			for (int i = 0; i < subFiles.length; i++) {
				result = false;
				File newDir = new File(to, subFiles[i].getName());
				if (subFiles[i].isDirectory()) {
					if (newDir.exists())
						result = true;
					else
						result = newDir.mkdirs();
				} else if (subFiles[i].isFile()) {
					try {
						result = newDir.createNewFile();
					} catch (IOException e) {
						log.error("unable to create new file: " + newDir, e);
						result = false;
					}
				}
				if (result)
					copy(subFiles[i], newDir);
			}
		} else if (from.isFile()) {
			FileOutputStream out = null;
			FileInputStream in = null;
			try {
				out = new FileOutputStream(to);
				in = new FileInputStream(from);
				int fileLength = (int) from.length();
				int len;
				char charBuff[] = new char[fileLength];
				int oneChar;
				while ((oneChar = in.read()) != -1) {
					out.write(oneChar);
				}
			} catch (FileNotFoundException e) {
				log.error("File not found!", e);
			} catch (IOException e) {
				log.error("Unable to read from file!", e);
			} finally {
				try {
					if (in != null)
						in.close();
					if (out != null)
						out.close();
				} catch (IOException e1) {
					log.error("Error closing file reader/writer", e1);
				}
			}
		}
	}

}