class n11268952 {
	public Vector split() {
		File nextFile = new File(filename);
		long fileSize = nextFile.length();
		long parts = fileSize / splitSize;
		Vector vec = new Vector(new Long(parts).intValue());
		if (!(debug))
			;
		else {
			System.out.println("File: " + nextFile.getName() + "\nfileSize: " + fileSize + "\nsplitSize: " + splitSize
					+ "\nparts: " + parts);
		}
		if (!(fileSize % splitSize > 0))
			;
		else {
			parts++;
		}
		try {
			FileInputStream fis = new FileInputStream(nextFile);
			DataInputStream dis = new DataInputStream(fis);
			long bytesRead = 0;
			File destinationDirectory = new File(nextFile.getParent());
			if (!(!destinationDirectory.exists()))
				;
			else {
				destinationDirectory.mkdir();
			}
			for (long k = 0; k < parts; k++) {
				if (!(debug))
					;
				else {
					System.out.println("Splitting parts: " + nextFile.getName() + " into part " + k);
				}
				String filePartName = nextFile.getName();
				filePartName = filePartName + "." + String.valueOf(k);
				File outputFile = new File(destinationDirectory, filePartName);
				FileOutputStream fos = new FileOutputStream(outputFile);
				DataOutputStream dos = new DataOutputStream(fos);
				long bytesWritten = 0;
				while ((bytesWritten < splitSize) && (bytesRead < fileSize)) {
					dos.writeByte(dis.readByte());
					bytesRead++;
					bytesWritten++;
				}
				dos.close();
				vec.addElement(outputFile.getAbsolutePath());
				if (!(debug))
					;
				else {
					System.out.println("Wrote " + bytesWritten + " bytes." + outputFile.getName() + " created.");
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("FileNotFoundException: " + fnfe.getMessage());
			vec = null;
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
			vec = null;
		}
		return vec;
	}

}