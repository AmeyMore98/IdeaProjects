var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');

router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());
var Tpo = require('../model/TpoModel');

// RETURNS ALL THE tpoS IN THE DATABASE
router.get('/', function (req, res) {
    Tpo.find({}, function (err, companies) {
        if (err) return res.status(500).send("There was a problem finding the tpos.");
        res.status(200).send(companies);
    });
});

// GETS A SINGLE tpo FROM THE DATABASE
router.get('/:id', function (req, res) {
    Tpo.findById(req.params.id, function (err, tpo) {
        if (err) return res.status(500).send("There was a problem finding the tpo.");
        if (!tpo) return res.status(404).send("No tpo found.");
        res.status(200).send(tpo);
    });
});

// DELETES A tpo FROM THE DATABASE
router.delete('/:id', function (req, res) {
    Tpo.findByIdAndRemove(req.params.id, function (err, tpo) {
        if (err) return res.status(500).send("There was a problem deleting the tpo.");
        res.status(200).send("Tpo: "+ tpo.name +" was deleted.");
    });
});

// UPDATES A SINGLE tpo IN THE DATABASE
router.put('/:id', function (req, res) {
    Tpo.findByIdAndUpdate(req.params.id, req.body, {new: true}, function (err, tpo) {
        if (err) return res.status(500).send("There was a problem updating the tpo.");
        res.status(200).send(tpo);
    });
});


module.exports = router;