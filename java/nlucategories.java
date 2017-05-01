import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.CategoriesOptions;

public class nlucategories {

    private static final String username="87fa88fb-a638-463c-9bc3-225aa1c6f01e";
    private static final String password="VDlBnikeRTFS";
    public static void main(String[] arg) {
        //Construct NLU service instance
        NaturalLanguageUnderstanding service=new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27
        ,username,password);
        //The URL to be analyzed for categories
        String url = "http://www.espn.com/tennis/story/_/id/18436908/australian-open-2017-tournament-news-schedule-live-scores-tv-coverage";

        //The Categories options, 5-level taxonomy the content is to be categorized into
        CategoriesOptions categories = new CategoriesOptions();

        //Features object to hold Analysis features
        Features features = new Features.Builder().categories(categories).build();


        //Options to hold the options for our analysis , e.g., url or text
        AnalyzeOptions parameters = new AnalyzeOptions.Builder().url(url).features(features).build();

        //the top three levels of categories found in the analysis
        AnalysisResults response = service.analyze(parameters).execute();

        System.out.println(response);
    }



}
