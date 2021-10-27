class n17681309 {
	public static void main(String[] args) {
		Dialog dialog = new Dialog();
		try {
			if (args.length != 5) {
				throw new InvalidParameterException(
						"\n\nInvalid nunmber of parameters.\n\nCall must be \"java  -jar  Updater.jar  PATH_TO_MANAGER.JAR  CURRENT_MANAGER_VERSION  VERIONS.TXT_CONTROL_FILE  ROOT_WEBSERVER_FOLDER  LOCAL_TEMPORARY_FOLDER\"");
			}
			File managerJar = new File(args[0]);
			if (!managerJar.exists()) {
				throw new FileNotFoundException(args[0]);
			}
			dialog.updateLabel("Calculating files");
			URL verionsFile = new URL(args[2]);
			URLConnection connection = verionsFile.openConnection();
			connection.setConnectTimeout(10000);
			ArrayList<String> versions = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while (br.ready()) {
				versions.add(br.readLine());
			}
			br.close();
			int index = versions.indexOf(args[1]);
			String root = args[3];
			if (!root.endsWith("/")) {
				root += "/";
			}
			if (index != -1) {
				int k = 0;
				ArrayList<File> filesDownloaded = new ArrayList<File>();
				for (int i = index - 1; i >= 0; i--) {
					dialog.updateLabel("Connecting " + ++k + "/" + index + " files");
					URL url = new URL(root + versions.get(i).replaceAll(" ", "%20") + ".jar");
					URLConnection con = url.openConnection();
					con.setConnectTimeout(10000);
					dialog.progressBar.setValue(0);
					dialog.progressBar.setMaximum(con.getContentLength());
					File f = new File(args[4] + File.separator + versions.get(i) + ".jar");
					FileOutputStream out = new FileOutputStream(f, false);
					InputStream in = con.getInputStream();
					dialog.updateLabel("Downloading " + i + "/" + index + " files");
					copyInputStream(in, out, dialog.progressBar);
					in.close();
					out.close();
					filesDownloaded.add(f);
				}
				k = 0;
				Iterator<File> it = filesDownloaded.iterator();
				while (it.hasNext()) {
					dialog.updateLabel("Applying " + ++k + "/" + filesDownloaded.size() + " files");
					File file = it.next();
					dialog.progressBar.setValue(0);
					FileInputStream fis = new FileInputStream(file);
					dialog.progressBar.setMaximum(fis.available());
					fis.close();
					putDifsInJar(managerJar, file, dialog.progressBar);
				}
			} else {
				dialog.updateLabel("Connecting");
				URL url = new URL(root + "Manager.jar");
				URLConnection con = url.openConnection();
				con.setConnectTimeout(10000);
				dialog.progressBar.setValue(0);
				dialog.progressBar.setMaximum(con.getContentLength());
				File f = new File(args[4] + File.separator + "Manager.jar");
				OutputStream out = new FileOutputStream(f);
				InputStream in = con.getInputStream();
				dialog.updateLabel("Downloading ");
				copyInputStream(in, out, dialog.progressBar);
				in.close();
				out.close();
				FileOutputStream fos = new FileOutputStream(managerJar);
				FileInputStream fis = new FileInputStream(f);
				copyInputStream(in, out, null);
				in.close();
				out.close();
			}
			dialog.updateLabel("Finishing");
			Process runManager = Runtime.getRuntime().exec("java -jar " + managerJar.getAbsolutePath());
			System.exit(0);
		} catch (Exception e) {
			dialog.updateLabel("Closing...");
			JOptionPane.showMessageDialog(null, "Failed to update manager\n\n" + e.toString(), "Update failed",
					JOptionPane.ERROR_MESSAGE);
			long t0, t1;
			t0 = System.currentTimeMillis();
			do {
				t1 = System.currentTimeMillis();
			} while ((t1 - t0) < (1 * 1500));
			System.exit(0);
		}
	}

}