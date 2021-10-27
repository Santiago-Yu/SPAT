class n22288476 {
	public void loadJarFile(String jarFileNameParam) throws KExceptionClass {
		jarFileName = jarFileNameParam;
		{
			String message = "Loading resource file [";
			message = message + (jarFileName);
			message = message + ("]...");
			log.log(this, message);
		}
		try {
			URL url = new URL(jarFileName);
			JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
			jarConnection.setUseCaches(false);
			JarFile jarFile = jarConnection.getJarFile();
			Enumeration jarEntries = jarFile.entries();
			while (jarEntries.hasMoreElements()) {
				ZipEntry zipEntrie = (ZipEntry) jarEntries.nextElement();
				{
					String message = "Scanning [";
					message = message + (jarFileName);
					message = message + ("] found [");
					message = message + (describeEntry(zipEntrie));
					message = message + ("]");
					log.log(this, message);
				}
				htSizes.put(zipEntrie.getName(), new Integer((int) zipEntrie.getSize()));
			}
			;
			jarFile.close();
			BufferedInputStream inputBuffer = new BufferedInputStream(jarConnection.getJarFileURL().openStream());
			ZipInputStream input = new ZipInputStream(inputBuffer);
			ZipEntry zipEntrie = null;
			while ((zipEntrie = input.getNextEntry()) != null) {
				if (zipEntrie.isDirectory())
					continue;
				{
					String message = "Scanning [";
					message = message + (jarFileName);
					message = message + ("] loading [");
					message = message + (zipEntrie.getName());
					message = message + ("] for [");
					message = message + (zipEntrie.getSize());
					message = message + ("] bytes.");
					log.log(this, message);
				}
				int size = (int) zipEntrie.getSize();
				if (size == -1) {
					size = ((Integer) htSizes.get(zipEntrie.getName())).intValue();
				}
				;
				byte[] entrieData = new byte[(int) size];
				int offset = 0;
				int dataRead = 0;
				while (((int) size - offset) > 0) {
					dataRead = input.read(entrieData, offset, (int) size - offset);
					if (dataRead == -1)
						break;
					offset = offset + (dataRead);
				}
				htJarContents.put(zipEntrie.getName(), entrieData);
				if (debugOn) {
					System.out.println(zipEntrie.getName() + "  offset=" + offset + ",size=" + size + ",csize="
							+ zipEntrie.getCompressedSize());
				}
				;
			}
			;
		} catch (Exception error) {
			String message = "Error loading data from JAR file [";
			message = message + (error.toString());
			message = message + ("]");
			throw new KExceptionClass(message, new KExceptionClass(error.toString(), null));
		}
		;
	}

}