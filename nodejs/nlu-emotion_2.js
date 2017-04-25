var NaturalLanguageUnderstandingV1 = require('watson-developer-cloud/natural-language-understanding/v1.js');
var natural_language_understanding = new NaturalLanguageUnderstandingV1({
	'username' : your_username_here,
	'password' : your_password_here,
	'version_date' : NaturalLanguageUnderstandingV1.VERSION_DATE_2017_02_27
});
var parameters = {
	text : "I purchased this card from Best Buy for around $69 to use in my new camcorder. It's perfect. The read/write speed is exactly what I needed to record HD video and the storage capacity is enough for several hours of video. I wish it had been a little cheaper when I bought it. I see it's on sale now so get it while you can before the price goes back up!",
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
