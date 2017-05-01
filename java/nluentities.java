import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;


public class nluentities {
    private static final String username="87fa88fb-a638-463c-9bc3-225aa1c6f01e";
    private static final String password="VDlBnikeRTFS";
    public static void main(String[] arg) {
        //Construct NLU service instance
        NaturalLanguageUnderstanding service=new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27
                ,username,password);
        //The url to analyze its content
        String url = "http://www.techradar.com/news/phone-and-communications/mobile-phones/20-best-mobile-phones-in-the-world-today-645440";

        //The Entities object, to extract people, cities, organizations from our text
        EntitiesOptions entities = new EntitiesOptions.Builder().build();


        //Features object to hold Analysis features
        Features features = new Features.Builder().entities(entities).build();


        //Options to hold the options for our analysis , e.g., url or text
        AnalyzeOptions parameters = new AnalyzeOptions.Builder().url(url).features(features).build();

        //The entities returned from the analysis with some information about their type, relevance and count
        AnalysisResults response = service.analyze(parameters).execute();

        System.out.println(response);
    }


}
