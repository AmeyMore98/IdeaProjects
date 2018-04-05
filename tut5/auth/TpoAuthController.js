var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');
router.use(bodyParser.urlencoded({ extended: false }));
router.use(bodyParser.json());
var Tpo = require('../model/TpoModel');
var VerifyToken = require('./VerifyToken');

var jwt = require('jsonwebtoken');
var bcrypt = require('bcryptjs');
var config = require('../config');

router.post('/register', function(req, res) {
  
  var hashedPassword = bcrypt.hashSync(req.body.password, 8);
  
  Tpo.create({
    name : req.body.name,
    email : req.body.email,
    password : hashedPassword,
    cid: req.body.cid
  },
  function (err, tpo) {
    if (err) return res.status(500).send("There was a problem registering the tpo.")

    // create a token
    var token = jwt.sign({ id: tpo._id }, config.secret, {
      expiresIn: 86400 // expires in 24 hours
    });

    res.status(200).send({ auth: true, token: token });
  }); 
});

router.get('/me', VerifyToken, function(req, res,next) {
    Tpo.findById(req.userId, { password: 0 }, function (err, tpo) {
      if (err) return res.status(500).send('There was problem finding the tpo');
      if (!tpo) return res.status(404).send('No tpo found');

      res.status(200).send(tpo);
      //res.status(200).render('studentDashboard', {tpo: tpo});
    })
  });

router.post('/login', function(req, res) {
  console.log(req.body.email);
  Tpo.findOne({ email: req.body.email }, function (err, tpo) {
    if (err) return res.status(500).send('Error on the server.');
    if (!tpo) return res.status(404).send('No tpo found.');

    var passwordIsValid = bcrypt.compareSync(req.body.password, tpo.password);
    if (!passwordIsValid) return res.status(401).send({ auth: false, token: null });

    var token = jwt.sign({ id: tpo._id }, config.secret, {
      expiresIn: 86400 // expires in 24 hours
    });

    res.status(200).send({ auth: true, token: token });
    // res.header('x-access-token',token);
    // res.redirect(301, '/tpo/auth/me');
    // res.status(200).render('studentDashboard', {tpo: tpo});

  });

});

router.get('/logout', function(req, res) {
  res.status(200).send({ auth: false, token: null });
});

module.exports = router;