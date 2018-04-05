const express = require('express');
const bodyparser = require('body-parser');
const mongoose = require('mongoose');

const student = require('./Controllers/StudentController');
const company = require('./Controllers/CompanyController');
const tpo = require('./Controllers/TpoController');
const application = require('./Controllers/ApplicationController');
const placement = require('./Controllers/PlacementController');
const notice = require('./Controllers/NoticeController');
const feedback = require('./Controllers/FeedbackController');

const app = express();

mongoose.connect('mongodb://localhost/tpo');

mongoose.Promise = global.Promise;

app.use(express.static('public'));
app.use(bodyparser.json());
app.set('view engine', 'ejs');
app.use(express.static('./assets'))

//Authentication
var StudentAuthController = require('./auth/StudentAuthController');
app.use('/auth/student', StudentAuthController);

var CompanyAuthController = require('./auth/CompanyAuthController');
app.use('/auth/company', CompanyAuthController);

var TpoAuthController = require('./auth/TpoAuthController');
app.use('/auth/tpo', TpoAuthController);

//User Management
app.use('/student', student);
app.use('/company', company);
app.use('/tpo', tpo);

//Applications Management
app.use('/company/applications', application);

//Placement Management
app.use('/company/placements', placement);

//Notice Management
app.use('/tpo/notices', notice);

//Feedback Management
app.use('/student/feedback', feedback);

// app.use(function(err, req, res, next) {
// 	res.status(422).send({error: err.message});
// })

//"process.env.port" indicates port on webhosting sites
app.listen(process.env.port || 4000, function() {
	console.log('Now listening on 4000...');
});