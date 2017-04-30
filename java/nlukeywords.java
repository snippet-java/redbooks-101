/**
 * Created by khouly on 29-04-2017.
 */


import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;


public class nlukeywords {
    private static final String username="87fa88fb-a638-463c-9bc3-225aa1c6f01e";
    private static final String password="VDlBnikeRTFS";
    public static void main(String[] arg) {
        //Construct NLU service instance
        NaturalLanguageUnderstanding service=new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27
                ,username,password);
        //The url to analyze its content
        String url = "http://www.techradar.com/news/phone-and-communications/mobile-phones/20-best-mobile-phones-in-the-world-today-645440";

        //The keywords object, to identify important keywords in the content
        KeywordsOptions keywords = new KeywordsOptions.Builder().build();


        //Features object to hold Analysis features
        Features features = new Features.Builder().keywords(keywords).build();


        //Options to hold the options for our analysis , e.g., url or text
        AnalyzeOptions parameters = new AnalyzeOptions.Builder().url(url).features(features).build();

        //The keywords returned from the analysis, and their relevance.
        AnalysisResults response = service.analyze(parameters).execute();

        System.out.println(response);
    }


}
