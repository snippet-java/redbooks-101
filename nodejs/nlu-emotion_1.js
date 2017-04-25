var NaturalLanguageUnderstandingV1 = require('watson-developer-cloud/natural-language-understanding/v1.js');
var natural_language_understanding = new NaturalLanguageUnderstandingV1({
	'username' : your_username_here,
	'password' : your_password_here,
	'version_date' : NaturalLanguageUnderstandingV1.VERSION_DATE_2017_02_27
});
var parameters = {
	text : "This card is way too slow for my taste. It's probably great shooting JPEG but if your shooting Raw you may want to go with something else",
	features : {
		emotion : {}
	}
};
natural_language_understanding.analyze(parameters, function(error, response) {
	if (error) {
		onError(error, response); // function to be defined by you
	} else {
		console.log(JSON.stringify(response, null, 2));
		var docEmotions = response.emotion.document.emotion;
		// process object 'docEmotions' that contains properties 'anger', 'disgust', 'fear', 'joy', 'sadness'
	}
});
