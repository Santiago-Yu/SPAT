class n18559586 {
	public void loadJarFile(String jarFileNameParam) throws KExceptionClass {
		jarFileName = jarFileNameParam;
		{
			String message = "Loading resource file [";
			message += jarFileName;
			message += "]...";
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
					message += jarFileName;
					message += "] found [";
					message += describeEntry(zipEntrie);
					message += "]";
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
					message += jarFileName;
					message += "] loading [";
					message += zipEntrie.getName();
					message += "] for [";
					message += zipEntrie.getSize();
					message += "] bytes.";
					log.log(this, message);
				}
				int size = (int) zipEntrie.getSize();
				if (-1 == size) {
					size = ((Integer) htSizes.get(zipEntrie.getName())).intValue();
				}
				;
				byte[] entrieData = new byte[(int) size];
				int offset = 0;
				int dataRead = 0;
				while (((int) size - offset) > 0) {
					dataRead = input.read(entrieData, offset, (int) size - offset);
					if (-1 == dataRead)
						break;
					offset += dataRead;
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
			message += error.toString();
			message += "]";
			throw new KExceptionClass(message, new KExceptionClass(error.toString(), null));
		}
		;
	}

}