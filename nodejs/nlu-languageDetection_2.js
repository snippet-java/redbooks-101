var async = require('async');
var NaturalLanguageUnderstandingV1 = require('watson-developer-cloud/natural-language-understanding/v1.js');
var natural_language_understanding = new NaturalLanguageUnderstandingV1({
	'username' : your_username_here,
	'password' : your_password_here,
	'version_date' : NaturalLanguageUnderstandingV1.VERSION_DATE_2017_02_27
});
var parameters = {
	features : {
		concepts : {
			limit : 1
		}
	}
};
function callLanguageDetection(callback) {
	natural_language_understanding.analyze(parameters, function(error, response) {
		if (error) { // do some error handling
			onError(error, null);
			callback(error, null);
		} else {
			callback(null, response);
		}
	});
}
async.parallel({
	"call1" : function(callback) {
		parameters.url = 'https://www.ibm.com/blockchain/what-is-blockchain.html';
		callLanguageDetection(callback);
	},
	"call2" : function(callback) {
		parameters.url = 'http://www.elpais.com.uy/';
		callLanguageDetection(callback);
	}
}, function(err, results) {
	if (err) {
		onError(err);
	} else {
		console.log(JSON.stringify(results, null, 2));
		// process the languages of asynchronous calls
		var lang1 = results.call1.language;
		var lang2 = results.call2.language;
	}
});
