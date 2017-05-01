import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EmotionOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;

import java.util.ArrayList;
import java.util.List;


public class nlutargetedEmotion {
    private static final String username="87fa88fb-a638-463c-9bc3-225aa1c6f01e";
    private static final String password="VDlBnikeRTFS";
    public static void main(String[] arg) {
        //Construct NLU service instance
        NaturalLanguageUnderstanding service=new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27
                ,username,password);
        //The text to be analyzed for
        String text = "I purchased this card from Best Buy for around $69 to use in my new camcorder. It's perfect. The read/write speed is exactly what I needed to record HD video and the storage capacity is enough for several hours of video. I wish it had been a little cheaper when I bought it. I see it's on sale now so get it while you can before the price goes back up!";


        //The keywords to do emotion analysis on
        List<String> targets = new ArrayList<String>();
        targets.add("Best Buy");

        //The Emotions object
        EmotionOptions emotions = new EmotionOptions.Builder().targets(targets).build();

        //Features object to hold Analysis features
        Features features = new Features.Builder().emotion(emotions).build();


        //Options to hold the options for our analysis , e.g., url or text
        AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(text).features(features).build();

        //The emotions returned from the analysis with their relative weight
        AnalysisResults response = service.analyze(parameters).execute();

        System.out.println(response);
    }


}
