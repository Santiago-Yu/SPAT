class n20056462{
    public static ArrayList<AnalyzeDefinition> read(ArrayList<String> supportedCommands, File analyzeCommands, String programAnalyzeCommands) throws ErrorMessage {
        if (analyzeCommands != null) {
            try {
                Reader fileReader = new FileReader(analyzeCommands);
                BufferedReader reader = new BufferedReader(fileReader);
                return readConfig(reader, analyzeCommands.getName(), null);
            } catch (FileNotFoundException e) {
                throw new ErrorMessage("File \"" + analyzeCommands + "\" not found");
            }
        } else if (programAnalyzeCommands != null) {
            Reader stringReader = new StringReader(programAnalyzeCommands);
            BufferedReader reader = new BufferedReader(stringReader);
            return readConfig(reader, "program response to gogui-analyze_commands", null);
        } else {
            String resource = "net/sf/gogui/gui/analyze-commands";
            URL url = ClassLoader.getSystemClassLoader().getResource(resource);
            if (url == null) return new ArrayList<AnalyzeDefinition>();
            try {
                InputStream inputStream = url.openStream();
                Reader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                return readConfig(reader, "builtin default commands", supportedCommands);
            } catch (IOException e) {
                throw new ErrorMessage(e.getMessage());
            }
        }
    }

}