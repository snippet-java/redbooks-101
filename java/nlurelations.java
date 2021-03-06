import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;


public class nlurelations {
    private static final String username="87fa88fb-a638-463c-9bc3-225aa1c6f01e";
    private static final String password="VDlBnikeRTFS";
    public static void main(String[] arg) {
        //Construct NLU service instance
        NaturalLanguageUnderstanding service=new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27
                ,username,password);
        //The text to analyze its content
        String text = "Cutting Cash Would Be a Boon for the World’s Poor, Rogoff Says";

        //The Relations object, to identify important relations in the content
        RelationsOptions relations = new RelationsOptions.Builder().build();


        //Features object to hold Analysis features
        Features features = new Features.Builder().relations(relations).build();


        //Options to hold the options for our analysis , e.g., url or text
        AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(text).features(features).build();

        //The relations returned from the analysis, and their types.
        AnalysisResults response = service.analyze(parameters).execute();

        System.out.println(response);
    }


}
