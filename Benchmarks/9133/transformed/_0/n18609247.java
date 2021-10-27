class n18609247 {
	private void compileJarFile() {
		String beJf6RI2 = jarFileName + ".java";
		try {
			File FjplMm4r = new File(CastadivaModel.PLUGIN_WORKFOLDER);
			FjplMm4r.mkdirs();
			File aXO6WQHp = new File(FjplMm4r.getPath() + "/castadiva/Plugins");
			aXO6WQHp.mkdirs();
			BufferedWriter YqcheQcn = new BufferedWriter(
					new FileWriter(FjplMm4r.getPath() + "/castadiva/Plugins/" + beJf6RI2));
			YqcheQcn.write("package castadiva.Plugins;\n");
			YqcheQcn.write("import java.io.*;\n");
			YqcheQcn.write("import java.util.zip.ZipEntry;\n");
			YqcheQcn.write("import java.util.jar.JarFile;\n");
			YqcheQcn.write("import lib.IPluginCastadiva;\n");
			YqcheQcn.write("public class " + jarFileName + " implements IPluginCastadiva {\n");
			YqcheQcn.write("    public String getBin() {\n");
			YqcheQcn.write("        return \"" + binaryFilePath + "\"; \n    }\n");
			YqcheQcn.write("    public String getFlags() {\n");
			YqcheQcn.write("        return \"" + protocolFlags + "\"; \n    }\n");
			YqcheQcn.write("    public String getPathConf() {\n");
			YqcheQcn.write("        return \"" + configurationFilePath + "\"; \n    }\n");
			YqcheQcn.write("    public String getConfContent(){\n");
			YqcheQcn.write("        BufferedReader confFileReader;\n");
			YqcheQcn.write("        try {\n");
			YqcheQcn.write("            JarFile jar = new JarFile(\"" + CastadivaModel.PLUGIN_JAR_FOLDER + "/"
					+ jarFileName + ".jar\");\n");
			YqcheQcn.write("            ZipEntry entry = jar.getEntry(\""
					+ configurationFilename[configurationFilename.length - 1] + "\");\n");
			YqcheQcn.write(
					"            confFileReader = new BufferedReader(new InputStreamReader(jar.getInputStream(entry)));\n");
			YqcheQcn.write("            String confFile = \"\";\n");
			YqcheQcn.write("            String confFileLine;\n");
			YqcheQcn.write("            while((confFileLine = confFileReader.readLine()) != null){\n");
			YqcheQcn.write("                 confFile+=\"\\n\"+confFileLine;\n");
			YqcheQcn.write("            }\n");
			YqcheQcn.write("            return(confFile);\n");
			YqcheQcn.write("        } catch (Exception ex) {\n");
			YqcheQcn.write("            System.out.println(ex);\n");
			YqcheQcn.write("        }\n");
			YqcheQcn.write("        return(null);\n");
			YqcheQcn.write("    }\n");
			YqcheQcn.write("    public String getConf(){\n");
			YqcheQcn.write("        return(\"" + configurationFilename[configurationFilename.length - 1] + "\");\n");
			YqcheQcn.write("    }\n");
			YqcheQcn.write("    public String getKillInstruction() {\n");
			YqcheQcn.write("        return  \"killall " + binFileName[binFileName.length - 1] + " 2>/dev/null\""
					+ ";\n    }\n}");
			YqcheQcn.close();
			BufferedWriter LrHZQku3 = new BufferedWriter(new FileWriter(
					CastadivaModel.PLUGIN_WORKFOLDER + "/" + configurationFilename[configurationFilename.length - 1]));
			LrHZQku3.write(protocolConfiguration);
			LrHZQku3.close();
		} catch (IOException Cu3gvDmA) {
			Logger.getLogger(ProtocolsGUI.class.getName()).log(Level.SEVERE, null, Cu3gvDmA);
		}
	}

}