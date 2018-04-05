var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');
router.use(bodyParser.urlencoded({ extended: false }));
router.use(bodyParser.json());
var Student = require('../model/StudentModel');
var VerifyToken = require('./VerifyToken');

var jwt = require('jsonwebtoken');
var bcrypt = require('bcryptjs');
var config = require('../config');

router.post('/register', function(req, res) {
  
  var hashedPassword = bcrypt.hashSync(req.body.password, 8);
  
  Student.create({
    name : req.body.name,
    email : req.body.email,
    password : hashedPassword,
    sid: req.body.sid,
	  branch: req.body.branch,
    year: req.body.year
  },
  function (err, student) {
    if (err) return res.status(500).send("There was a problem registering the student.")

    // create a token
    var token = jwt.sign({ id: student._id }, config.secret, {
      expiresIn: 86400 // expires in 24 hours
    });

    res.status(200).send({ auth: true, token: token });
  }); 
});

router.get('/me', VerifyToken, function(req, res,next) {
    Student.findById(req.userId, { password: 0 }, function (err, student) {
      if (err) return res.status(500).send('There was problem finding the student');
      if (!student) return res.status(404).send('No student found');

      res.status(200).send(student);
      //res.status(200).render('studentDashboard', {student: student});
    })
  });

router.post('/login', function(req, res) {
  console.log(req.body.email);
  Student.findOne({ email: req.body.email }, function (err, student) {
    if (err) return res.status(500).send('Error on the server.');
    if (!student) return res.status(404).send('No student found.');

    var passwordIsValid = bcrypt.compareSync(req.body.password, student.password);
    if (!passwordIsValid) return res.status(401).send({ auth: false, token: null });

    var token = jwt.sign({ id: student._id }, config.secret, {
      expiresIn: 86400 // expires in 24 hours
    });

    res.status(200).send({ auth: true, token: token });
    // res.header('x-access-token',token);
    // res.redirect(301, '/student/auth/me');
    // res.status(200).render('studentDashboard', {student: student});

  });

});

router.get('/logout', function(req, res) {
  res.status(200).send({ auth: false, token: null });
});

module.exports = router;