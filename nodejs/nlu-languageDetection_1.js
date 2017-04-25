var NaturalLanguageUnderstandingV1 = require('watson-developer-cloud/natural-language-understanding/v1.js');
var natural_language_understanding = new NaturalLanguageUnderstandingV1({
	'username' : your_username_here,
	'password' : your_password_here,
	'version_date' : NaturalLanguageUnderstandingV1.VERSION_DATE_2017_02_27
});
var parameters = {
	url : 'http://www.elpais.com.uy/',
	features : {
		concepts : {
			limit : 1
		}
	}
};
natural_language_understanding.analyze(parameters, function(error, response) {
	if (error) {
		onError(error, response); // function to be defined by you
	} else {
		console.log(JSON.stringify(response, null, 2));
		var language = response.language;
		// process the language text in 'language'
	}
});