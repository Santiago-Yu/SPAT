class n14868224 {
	Library(MainFrame mf, boolean newLibrary, String templateName, String newFileName) throws Exception {
        mainFrame = mf;
        trackMap = new HashMap<String, LibraryTrack>();
        String propFileName = null;
        trackVec=new Vector<LibraryTrack>();
        String notExist = "";
        File propFile = null;
        String[] options = templateDesc;
        int ix;
        boolean isCurrent = mainFrame.library != null;
        if (!newLibrary) {
            propFileName = mainFrame.name + ".jampal";
            propFile = new File(propFileName);
        }
        boolean copyLibrary = false;
        if (isCurrent) {
			options = new String[templateDesc.length + 1];
			options[0] = "Copy of Current Library";
			for (ix = 0; ix < templateDesc.length; ix++) {
				options[ix + 1] = templateDesc[ix];
			}
		}
        if (newLibrary) {
            if (templateName == null) {
                Object resp = JOptionPane.showInputDialog(mainFrame.frame, "Please select a template.", "Select Type of Library", JOptionPane.WARNING_MESSAGE, null, options, null);
                if (resp == null) return;
                templateName = (String) resp;
            }
            for (ix = 0; ix < options.length && !options[ix].equals(templateName); ix++) ;
            boolean creatingPlaylist = false;
            if (isCurrent)
				ix--;
            BufferedReader in;
            if (ix == -1) {
                copyLibrary = true;
                in = new BufferedReader(new FileReader(mainFrame.name + ".jampal"));
                creatingPlaylist = (mainFrame.library.attributes.libraryType == 'P');
            } else {
                in = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("pgbennett/jampal/" + templateNames[ix])));
                creatingPlaylist = ("playlist.jampal".equals(templateNames[ix]));
            }
            if (newFileName == null) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Create New Library File");
                String currentDirectory = null;
                if (mainFrame.name != null) {
                    File nameFile = new File(mainFrame.name);
                    currentDirectory = nameFile.getParent();
                    if (currentDirectory == null) currentDirectory = ".";
                }
                if (currentDirectory == null) currentDirectory = Jampal.jampalDirectory;
                if (currentDirectory != null) fileChooser.setCurrentDirectory(new File(currentDirectory));
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setMultiSelectionEnabled(false);
                Mp3FileFilter filter = new Mp3FileFilter();
                filter.setExtension("jampal", "Jampal library files");
                fileChooser.addChoosableFileFilter(filter);
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.setFileFilter(filter);
                fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
                int returnVal = fileChooser.showSaveDialog(mainFrame.frame);
                if (returnVal == fileChooser.APPROVE_OPTION) {
                    propFile = fileChooser.getSelectedFile();
                    propFileName = propFile.getPath();
                    if (!propFileName.toLowerCase().endsWith(".jampal")) {
                        propFileName = propFileName + ".jampal";
                        propFile = new File(propFileName);
                    }
                } else return;
            } else {
                propFileName = newFileName;
                propFile = new File(propFileName);
            }
            if (propFile.exists()) {
                if (JOptionPane.showConfirmDialog(mainFrame.frame, "File " + propFileName + " already exists. Do you want to overwrite it ?", "Warning", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
            }
            PrintWriter out = new PrintWriter(new FileOutputStream(propFile));
            String libName = propFile.getName();
            libName = libName.substring(0, libName.length() - 7);
            for (; ; ) {
                String line = in.readLine();
                if (line == null) break;
                if (creatingPlaylist && line.startsWith("playlist=")) {
                    line = "playlist=" + libName;
                }
                if (line.startsWith("libraryname=")) {
                    line = "libraryname=" + libName + ".jmp";
                }
                out.println(line);
            }
            in.close();
            out.close();
            if (!creatingPlaylist && !copyLibrary) {
                String playlistName = propFile.getParent() + File.separator + "playlist.jampal";
                File playlistFile = new File(playlistName);
                if (!playlistFile.exists()) {
                    out = new PrintWriter(new FileOutputStream(playlistFile));
                    in = new BufferedReader(new InputStreamReader(
							ClassLoader.getSystemResourceAsStream("pgbennett/jampal/playlist.jampal")));
                    for (; ; ) {
                        String line = in.readLine();
                        if (line == null) break;
                        out.println(line);
                    }
                    in.close();
                    out.close();
                }
            }
        }
        if (propFileName != null) attributes = new LibraryAttributes(propFileName);
        insertBefore = -1;
    }

}