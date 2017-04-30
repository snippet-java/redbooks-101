/**
 * Created by khouly on 29-04-2017.
 */


import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;

import java.util.ArrayList;
import java.util.List;


public class nlutargetedSentiment {
    private static final String username="87fa88fb-a638-463c-9bc3-225aa1c6f01e";
    private static final String password="VDlBnikeRTFS";
    public static void main(String[] arg) {
        //Construct NLU service instance
        NaturalLanguageUnderstanding service=new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27
                ,username,password);
        //The text to analyze its content
        String url = "http://www.techradar.com/reviews/wearables/apple-watch-2-1323213/review";

        //The keywords to do sentiment analysis on
        List<String> targets = new ArrayList<String>();
        targets.add("fitness");

        //The sentiment object, to get the sentiment analysis in the content
        SentimentOptions sentiment = new SentimentOptions.Builder().targets(targets).build();


        //Features object to hold Analysis features
        Features features = new Features.Builder().sentiment(sentiment).build();


        //Options to hold the options for our analysis , e.g., url or text
        AnalyzeOptions parameters = new AnalyzeOptions.Builder().url(url).features(features).build();

        //The sentiment score returned from the analysis, in the range of 0 to 1.
        AnalysisResults response = service.analyze(parameters).execute();

        System.out.println(response);
    }


}
