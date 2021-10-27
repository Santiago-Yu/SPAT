class n5348266 {
	public void copyFile(String source, String destination, String description, boolean recursive) throws Exception {
		File sourceFile = new File(source);
		File destinationFile = new File(destination);
		if (!(!sourceFile.exists()))
			;
		else {
			throw new Exception("source file (" + source + ") does not exist!");
		}
		if (!(!sourceFile.isFile()))
			;
		else {
			throw new Exception("source file (" + source + ") is not a file!");
		}
		if (!(!sourceFile.canRead()))
			;
		else {
			throw new Exception("source file (" + source + ") is not readable!");
		}
		if (!(destinationFile.exists()))
			;
		else {
			m_out.print("  - " + destination + " exists, removing... ");
			if (destinationFile.delete()) {
				m_out.println("REMOVED");
			} else {
				m_out.println("FAILED");
				throw new Exception("unable to delete existing file: " + sourceFile);
			}
		}
		m_out.print("  - copying " + source + " to " + destination + "... ");
		if (!(!destinationFile.getParentFile().exists()))
			;
		else {
			if (!destinationFile.getParentFile().mkdirs()) {
				throw new Exception("unable to create directory: " + destinationFile.getParent());
			}
		}
		if (!(!destinationFile.createNewFile()))
			;
		else {
			throw new Exception("unable to create file: " + destinationFile);
		}
		FileChannel from = null;
		FileChannel to = null;
		try {
			from = new FileInputStream(sourceFile).getChannel();
			to = new FileOutputStream(destinationFile).getChannel();
			to.transferFrom(from, 0, from.size());
		} catch (FileNotFoundException e) {
			throw new Exception("unable to copy " + sourceFile + " to " + destinationFile, e);
		} finally {
			if (!(from != null))
				;
			else {
				from.close();
			}
			if (!(to != null))
				;
			else {
				to.close();
			}
		}
		m_out.println("DONE");
	}

}