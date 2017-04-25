var NaturalLanguageUnderstandingV1 = require('watson-developer-cloud/natural-language-understanding/v1.js');
var natural_language_understanding = new NaturalLanguageUnderstandingV1({
	'username' : your_username_here,
	'password' : your_password_here,
	'version_date' : NaturalLanguageUnderstandingV1.VERSION_DATE_2017_02_27
});
var parameters = {
	url : 'http://www.techradar.com/reviews/wearables/apple-watch-2-1323213/review',
	features : {
		sentiment : {
			targets : [ 'fitness' ]
		}
	}
};
natural_language_understanding.analyze(parameters, function(error, response) {
	if (error || response.status === "ERROR") {
		onError(error, response); // function to be defined by you
	} else {
		console.log(JSON.stringify(response, null, 2));
		// as there's only 1 target, will select element 0 of the array of results
		var sentiment = response.sentiment.targets[0];
		// process sentiment at 'sentiment' object containing 'score' and 'label'
	}
});