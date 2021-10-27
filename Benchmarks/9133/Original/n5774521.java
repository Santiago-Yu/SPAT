class n5774521{
    private static URL lookForDefaultThemeFile(String aFilename) {
        try {
            XPathFactory fabrique = XPathFactory.newInstance();
            XPath environnement = fabrique.newXPath();
            URL url = new URL("file:" + aFilename);
            InputSource source = new InputSource(url.openStream());
            XPathExpression expression;
            expression = environnement.compile("/alloy/instance/@filename");
            String resultat = expression.evaluate(source);
            AlloyPlugin.getDefault().logInfo("Solution coming from " + resultat);
            IPath path = new Path(resultat);
            IPath themePath = path.removeFileExtension().addFileExtension("thm");
            File themeFile = themePath.toFile();
            if (themeFile.exists()) {
                AlloyPlugin.getDefault().logInfo("Found default theme " + themeFile);
                return themeFile.toURI().toURL();
            }
        } catch (MalformedURLException e) {
            AlloyPlugin.getDefault().log(e);
        } catch (IOException e) {
            AlloyPlugin.getDefault().log(e);
        } catch (XPathExpressionException e) {
            AlloyPlugin.getDefault().log(e);
        }
        return null;
    }

}