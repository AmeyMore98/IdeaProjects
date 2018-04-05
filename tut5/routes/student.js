var express = require('express');
var router = express.Router();
var AuthController = require('../auth/AuthController');

router.get('/', function(req, res){
	res.render('student');
});

router.use('/auth', AuthController);


module.exports = router;