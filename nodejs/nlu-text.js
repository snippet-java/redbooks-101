var NaturalLanguageUnderstandingV1 = require('watson-developer-cloud/natural-language-understanding/v1.js');
var natural_language_understanding = new NaturalLanguageUnderstandingV1({
	'username' : your_username_here,
	'password' : your_password_here,
	'version_date' : NaturalLanguageUnderstandingV1.VERSION_DATE_2017_02_27
});
var parameters = {
	url : 'http://edition.cnn.com/2016/12/18/americas/gitmo-detainee-uruguay/index.html',
	return_analyzed_text : true,
	features : {
		concepts : { // XXX There's no more text service, set return_analyzed_text to true in any valid request to /analyze
			limit : 1
		}
	}
};
natural_language_understanding.analyze(parameters, function(error, response) {
	if (error || response.status === "ERROR") {
		onError(error, response); // function to be defined by you
	} else {
		console.log(JSON.stringify(response, null, 2));
		var text = response.analyzed_text;
		// process text string in 'text'
	}
});