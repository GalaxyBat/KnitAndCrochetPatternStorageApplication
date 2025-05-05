//setup express to handle routing and rendering
var express = require('express');
var app = express();
const fs = require('node:fs');
const path = require('path');
const filePath = path.join(__dirname, 'Project.exe');
app.set('view engine', 'ejs');

//setup bodyparser to extra data from form posts
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true })); 

// route to index page
app.get('/', function(req, res) {
    res.render('page/index');
});

// route to api call for downloading history
app.get('/api/download', (req, res) => {
	res.download(
		filePath, 
		"Project.exe", 
		(err) => {
			if (err) {
				console.log("Unable to download file")
			} else {
				console.log("Download successful")
			}
	});
});

//start the web app
app.listen(80, function () {
	console.log('App listening on port 80!');
});

